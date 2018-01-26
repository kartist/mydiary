package cn.kartist.mydiary.common.config;

import cn.kartist.mydiary.common.intercepter.SessionInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author Kartist 2018/1/25 21:51
 */
@Configuration
public class IntercepterConfig extends WebMvcConfigurerAdapter{
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new SessionInterceptor()).excludePathPatterns("/index").excludePathPatterns("/login");
        super.addInterceptors(registry);
    }
}
