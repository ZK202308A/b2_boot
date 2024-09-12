package org.zerock.b2.board.config;

import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.zerock.b2.board.controller.interceptor.ViewCntInterceptor;

@Configuration
@Log4j2
@EnableWebMvc
public class BoardConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        log.info("-------------------------");
        log.info("-------------------------");
        log.info("addInterceptors");
        log.info("-------------------------");
        log.info("-------------------------");

        registry.addInterceptor(new ViewCntInterceptor())
                .addPathPatterns("/board/read/*");
    }
}
