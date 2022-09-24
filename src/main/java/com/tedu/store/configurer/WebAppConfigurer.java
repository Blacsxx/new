package com.tedu.store.configurer;

import com.tedu.store.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.ArrayList;

@SuppressWarnings("deprecation")
@Configuration
public class WebAppConfigurer extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        ArrayList<String> addPathPatterns = new ArrayList<>();
        addPathPatterns.add("/user/**");
        addPathPatterns.add("/web/**");
        addPathPatterns.add("/address/**");
        ArrayList<String> excludePathPatterns = new ArrayList<>();
        excludePathPatterns.add("/user/reg.do");
        excludePathPatterns.add("/user/login.do");
        excludePathPatterns.add("/web/login.html");
        excludePathPatterns.add("/web/register.html");
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns(addPathPatterns)
                .excludePathPatterns(excludePathPatterns);
    }
}
