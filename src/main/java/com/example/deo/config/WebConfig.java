package com.example.deo.config;
import org.springframework.context.annotation.*;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
@Configuration @EnableWebMvc @ComponentScan("com.example.deo")
public class WebConfig implements WebMvcConfigurer {
 @Bean public InternalResourceViewResolver viewResolver(){var v=new InternalResourceViewResolver();v.setPrefix("/WEB-INF/views/");v.setSuffix(".jsp");return v;}
}
