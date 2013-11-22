package com.myapp.platform.facebook.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.nutz.http.Http;
import org.nutz.http.Response;
import org.nutz.json.Json;
import org.nutz.log.Log;
import org.nutz.log.Logs;

import com.myapp.platform.api.PlatformApi;
import com.myapp.platform.api.PlatformManager;
import com.myapp.platform.common.PlatformGloble;
import com.myapp.platform.facebook.model.FacebookRechargeInfo;
@WebServlet(name = "facebookRechargeRefresh", description = "facebook清除订单缓存", urlPatterns = { "/" + PlatformGloble.PF_FACEBOOK + PlatformGloble.URL_RECHARGE_REFRESH}, asyncSupported = true)
public class FbRechargeRefreshServlet extends HttpServlet {
	
	private static Log logger = Logs.get();
	
	private static final String FACEBOOK_URL = "https://graph.facebook.com/?id=%s&scrape=true&method=post";

	/**
	 * 
	 */
	private static final long serialVersionUID = -5273853736340511348L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.debug("facebookRechargeRefresh param == " + Json.toJson(req.getParameterMap()));
		PlatformApi<FacebookRechargeInfo> handler = (PlatformApi<FacebookRechargeInfo>) PlatformManager.getInstance().getPlatfromHandler(PlatformGloble.PF_FACEBOOK);
		if(handler == null){
			logger.debug("handler is null");
			return;
		}
		List<String> idList = handler.getRechargeIdList();
		if(idList == null){
			logger.debug("idList is null");
			return ;
		}
		StringBuffer sb = new StringBuffer();
		for(String id : idList){
			FacebookRechargeInfo rechargeInfo = (FacebookRechargeInfo) handler.getRechargeInfo(id);
			if(rechargeInfo != null){
				String url = String.format(FACEBOOK_URL, rechargeInfo.getUrl());
				Response facebookResp = Http.get(url);
				sb.append(facebookResp.getContent());
			}
		}
		logger.debug("facebook back info == " + sb.toString());
		PrintWriter out = resp.getWriter();
		out.println(sb.toString());
		out.flush();
		out.close();
		
	}
	
}
