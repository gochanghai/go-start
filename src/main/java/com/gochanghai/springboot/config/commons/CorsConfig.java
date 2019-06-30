package com.gochanghai.springboot.config.commons;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * 跨域访问配置
 */
@SpringBootConfiguration
public class CorsConfig {

    private CorsConfiguration buildConfig() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        /** 允许任何域名 */
        corsConfiguration.addAllowedOrigin("*");
        /** 允许任何头 */
        corsConfiguration.addAllowedHeader("*");
        /** 允许任何方法 */
        corsConfiguration.addAllowedMethod("*");
        return corsConfiguration;
    }

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        /** 注册 */
        source.registerCorsConfiguration("/**", buildConfig());
        return new CorsFilter(source);
    }
}