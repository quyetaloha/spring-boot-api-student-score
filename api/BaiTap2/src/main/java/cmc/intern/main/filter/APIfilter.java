package cmc.intern.main.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import cmc.inter.main.session.SessionManager;

@Component
@Order(1)
public class APIfilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		
		System.out.println(httpServletRequest.getRequestURI());
		if (httpServletRequest.getRequestURI().contains("login")){
			chain.doFilter(request, response);
		}
		else {
			HttpServletResponse httpServletResponse = (HttpServletResponse) response;
			String SessionId=request.getParameter("SessionId");
			if (SessionId.equals(SessionManager.id)) {
				chain.doFilter(request, response);
			} else {
				httpServletResponse.sendRedirect("https://google.com");
				return;
			}
		}
	}

}
