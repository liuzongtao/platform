package com.myapp.platform.facebook.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.math.NumberUtils;
import org.nutz.json.Json;
import org.nutz.log.Log;
import org.nutz.log.Logs;

import com.myapp.platform.api.PlatformApi;
import com.myapp.platform.api.PlatformManager;
import com.myapp.platform.common.PlatformGloble;
import com.myapp.platform.facebook.model.FacebookRechargeInfo;
@WebServlet(name = "facebookRechargeMenu", description = "facebook充值菜单", urlPatterns = { "/" + PlatformGloble.PF_FACEBOOK + PlatformGloble.URL_RECHARGE_MENU}, asyncSupported = true)
public class FbRechargeMenuServlet extends HttpServlet {
	
	private static Log logger = Logs.get();

	/**
	 * 
	 */
	private static final long serialVersionUID = -6977619556264666304L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.debug("facebookRechargeMenu param == " + Json.toJson(request.getParameterMap()));
		String idStr = request.getParameter(PlatformGloble.RECHARGE_MENU_PARAM_ID);
		if(!NumberUtils.isNumber(idStr)){
			logger.debug("id is error ! idStr==" + idStr);
			return ;
		}
		PlatformApi<FacebookRechargeInfo> handler = (PlatformApi<FacebookRechargeInfo>) PlatformManager.getInstance().getPlatfromHandler(PlatformGloble.PF_FACEBOOK);
		if(handler == null){
			logger.debug("handler is null!");
			return ;
		}
		FacebookRechargeInfo rechargeInfo = (FacebookRechargeInfo) handler.getRechargeInfo(idStr);
		logger.debug("FacebookRechargeInfo == " + Json.toJson(rechargeInfo));
		if(rechargeInfo != null){
			PrintWriter out = response.getWriter();
			out.println("<!DOCTYPE html PUBLIC '-//W3C//DTD HTML 4.01 Transitional//EN' 'http://www.w3.org/TR/html4/loose.dtd'>");
			out.println("<html>");
			out.println("<head prefix='og: http://ogp.me/ns#\n fb: http://ogp.me/ns/fb#\n product: http://ogp.me/ns/product#'>");
			out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
			out.println("<title>facebookRechargeMenu Info</title>");
			out.println("<meta property='og:type'                   content='og:product' />");
			out.println("<meta property='og:title'                  content=' " + rechargeInfo.getTitle() + "' />");
			out.println("<meta property='og:plural_title'           content=' " + rechargeInfo.getPluralTitle() + "' />");
			out.println("<meta property='og:image'           		content=' " + rechargeInfo.getImage() + "' />");
			out.println("<meta property='og:description'           	content=' " + rechargeInfo.getDescription() + "' />");
			out.println("<meta property='og:url'           			content=' " + rechargeInfo.getUrl() + "' />");
			out.println("<meta property='product:price:amount'      content=' " + rechargeInfo.getPriceAmount() + "' />");
			out.println("<meta property='product:price:currency'    content=' " + rechargeInfo.getPriceCurrency() + "' />");
			out.println("</head>");
			out.print("<body>");
			out.print("</body>");
			out.print("</html>");
			out.flush();
			out.close();
		} 
	}
	
	
	
	

}
