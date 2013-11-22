package com.myapp.init;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.nutz.log.Log;
import org.nutz.log.Logs;

import com.facebook.test.FacebookApiImp;
import com.myapp.platform.api.PlatformManager;
import com.myapp.platform.common.PlatformGloble;

public class InitServlet extends HttpServlet {
	
	private static Log logger = Logs.get();

	/**
	 * 
	 */
	private static final long serialVersionUID = -2657452609756071090L;
	
	public InitServlet() {
		super();
	}

	@Override
	public void init() throws ServletException {
//		FacebookApiImp facebookApi = new FacebookApiImp();
//		PlatformManager.getInstance().registerPlatForm(PlatformGloble.PF_FACEBOOK, facebookApi);
//		logger.debug(1);
		
		
	}
	
	

}
