package ai.reportnoti.etl.config;

import ai.reportnoti.etl.interceptor.MDCLoggingInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(new MDCLoggingInterceptor())
                .order(1)
                .addPathPatterns("/**")
                .excludePathPatterns("/error");
    }
}
