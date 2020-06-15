/*package tn.esprit.spring.config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tn.esprit.spring.controller.UserController;

public class LoginFilter implements Filter {
	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
		HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
		UserController uController = (UserController) httpServletRequest.getSession()
				.getAttribute("UserController");
		if (uController != null && uController.getUser() != null
				&& uController.getLoggedIn()) {
			filterChain.doFilter(servletRequest, servletResponse);
		} else {
			httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/");
		}
	}
}*/