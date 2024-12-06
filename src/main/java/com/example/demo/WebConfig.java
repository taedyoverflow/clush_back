package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CommonsRequestLoggingFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:3000") // React 개발 서버 URL
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowCredentials(true); // 인증 정보 허용
    }

    @Bean
    public CommonsRequestLoggingFilter requestLoggingFilter() {
        CommonsRequestLoggingFilter filter = new CommonsRequestLoggingFilter();
        filter.setIncludeClientInfo(true); // 클라이언트 정보(IP, 포트 등) 포함
        filter.setIncludeQueryString(true); // 요청 쿼리스트링 포함
        filter.setIncludePayload(true); // 요청 본문(Payload) 포함
        filter.setMaxPayloadLength(10000); // 로깅할 요청 본문 최대 길이
        filter.setIncludeHeaders(false); // 요청 헤더 로깅 비활성화
        return filter;
    }

}
