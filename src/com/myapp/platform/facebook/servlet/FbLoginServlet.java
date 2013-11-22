package com.myapp.platform.facebook.servlet;

import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.nutz.json.Json;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.web.ajax.AjaxReturn;

import com.myapp.platform.api.PlatformApi;
import com.myapp.platform.api.PlatformManager;
import com.myapp.platform.common.PlatformGloble;
import com.myapp.platform.config.ConfigManager;
import com.myapp.platform.config.OauthPlatformConfig;
import com.myapp.platform.facebook.FacebookLogin;
import com.myapp.platform.facebook.FacebookSignedRequest;
import com.myapp.platform.facebook.model.FacebookRechargeInfo;
import com.restfb.DefaultFacebookClient;
import com.restfb.types.User;

@WebServlet(name = "facebookLogin", description = "用户登陆", urlPatterns = { "/" + PlatformGloble.PF_FACEBOOK + PlatformGloble.URL_LOGIN}, asyncSupported = true)
public class FbLoginServlet extends HttpServlet {
	
	private static Log logger = Logs.get();
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4222586443218497509L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.debug("param ==" + Json.toJson(req.getParameterMap()));
		String requestSign = req.getParameter("signed_request");
		boolean isOK = StringUtils.isNotBlank(requestSign);
		OauthPlatformConfig config = ConfigManager.getInstance().getPlatformConfigMap().get(PlatformGloble.PF_FACEBOOK);
		if(config == null){
			logger.debug(PlatformGloble.PF_FACEBOOK + " config is null ");
			return ;
		}
		if(isOK){
			PlatformApi<FacebookRechargeInfo> handler = (PlatformApi<FacebookRechargeInfo>) PlatformManager.getInstance().getPlatfromHandler(PlatformGloble.PF_FACEBOOK);
			try {
				FacebookSignedRequest facebookSR = FacebookSignedRequest.getFacebookSignedRequest(requestSign,FacebookSignedRequest.class);
				String accessToken = facebookSR.getOauth_token();
				if(StringUtils.isBlank(accessToken)){
					isOK = false;
				}else {
					DefaultFacebookClient facebookClient = new DefaultFacebookClient(accessToken);
					User facebookUser = facebookClient.fetchObject(PlatformGloble.FACEBOOK_TYPE_USER, User.class);
					AjaxReturn result = FacebookLogin.getInstance().login(handler, facebookUser);
					if(result.isOk()){
						Map<String, Object> parameterMap = (Map<String, Object>)result.getData();
						for(Entry<String, Object> paramter : parameterMap.entrySet()){
							req.setAttribute(paramter.getKey(), paramter.getValue());
						}
					}else {
						isOK = false;
					}
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				isOK = false;
			}
		}
		
		if(isOK){
			
		}else {
			String redirectUri = PlatformGloble.APP_FACEBOOK_URL + config.getNamespace();
			String url = "http://www.facebook.com/dialog/oauth?client_id=" + config.getAppid() + "&scope=email,publish_actions,publish_stream&redirect_uri=" + redirectUri;
			resp.sendRedirect(url);
		}
	}

}
