package com.czp.project.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/*")
public class BasePathFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		String basePath =req.getScheme()+"://"+
				         req.getServerName()+":"+
				         req.getServerPort()+
				         req.getContextPath()+"/";
		req.setAttribute("basePath", basePath);
		System.out.println(basePath);
		chain.doFilter(req, res);
		
	}

}
