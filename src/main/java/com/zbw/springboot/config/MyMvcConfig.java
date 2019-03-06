package com.zbw.springboot.config;

import com.zbw.springboot.component.LoginHandlerInterceptor;
import com.zbw.springboot.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author zhangbin
 * @{DATE} - 14:42
 */
//@EnableWebMvc
@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter{

    @Bean
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter(){
        WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter() {
            public void addViewControllers(ViewControllerRegistry registry) {
                 registry.addViewController("/").setViewName("login");
                 registry.addViewController("/index.html").setViewName("login");
                 registry.addViewController("/main.html").setViewName("dashboard");
            }

            //注册拦截器
            public void addInterceptors(InterceptorRegistry registry) {
                //super.addInterceptors(registry);
                registry.addInterceptor(new LoginHandlerInterceptor())
                        .addPathPatterns("/**").excludePathPatterns(
                                "/index.html","/","/user/login");
            }

        };
        return adapter;
    }

    @Bean
    public LocaleResolver localeResolver(){

        return new MyLocaleResolver();
    }
}
