package com.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {
    // 浏览器预检
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")                     // 对所有路径生效
                .allowedOrigins("http://localhost:5173")  // 允许的前端源（Vite 开发服务器）
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")  // 允许的方法
                .allowedHeaders("*")                   // 允许所有请求头（包括 token、Content-Type 等）
                .allowCredentials(true)                // 允许携带 Cookie
                .maxAge(3600);                         // 预检结果缓存 1 小时
    }
}
