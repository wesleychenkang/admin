package com.vanggame.admin.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vanggame.admin.util.CommonConst;


@WebFilter("/faqManager/*")
public class LoginFilter implements Filter {
	
	private static final String[] NO_NEED_URIS = { "/login", "/menus"};

	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest=(HttpServletRequest)request;
		HttpServletResponse httpResponse=(HttpServletResponse)response;
		if(httpRequest.getSession().getAttribute(CommonConst.STRING_ADMIN)==null && isRequestNeedLogin(httpRequest)){
			httpResponse.sendRedirect(httpRequest.getContextPath()+"/login/admin");//CommonConst.STRING_BASE
		}else{
			chain.doFilter(request, response);
		}
		
	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

	private boolean isRequestNeedLogin(HttpServletRequest request) {
		String uri=request.getRequestURI();
		for(String path : NO_NEED_URIS){
			if (uri != null && uri.indexOf(path) >= 0) {
				return false;
			}
		}
		return true;
	}
}
