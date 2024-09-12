package org.zerock.b2.board.controller.interceptor;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Log4j2
public class ViewCntInterceptor  implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        log.info("preHandle.....................");


        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        log.info("postHandle.......................");

        int value = (int)(Math.random()*100);

        log.info("-----------------" + value);

        Cookie viewCookie = new Cookie("view", "123" + value);
        viewCookie.setMaxAge(60*60*24);
        viewCookie.setPath("/");
        response.addCookie(viewCookie);

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

        log.info("afterCompletion......................");



    }
}