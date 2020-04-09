package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
@Component("authInterceptor")
public class AuthInterceptor extends HandlerInterceptorAdapter{
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse responsem, Object handler, ModelAndView modelAndView) throws Exception{
		System.out.println("AI: postHandle()");
	}
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse responsem, Object handler, Exception ex) throws Exception{
		System.out.println("AI: afterCompletion()");
	}
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception{
		System.out.println("AI: preHandle()");
		HttpSession session = request.getSession(false);
		/*if(session==null){
			response.sendError(HttpServletResponse.SC_FORBIDDEN);
			return false;
		}*/
		//SC_FORBIDDEN는 서버가 요청을 이해했지만, 실행하는 것은 거부
		if(session.getAttribute("auth")==null){
			response.sendRedirect("/chap07/auth/login");
			//response.sendError(HttpServletResponse.SC_FORBIDDEN);
			return false;
		}
		return true;
	}
}
