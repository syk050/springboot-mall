package com.kgd.springbootmall.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


//@EnableWebMvc         // 어노테이션 기반 SpringMVC를 구성할 때, 필요한 빈 설정들을 자동으로 해주는 어노테이션(<mvc:annotation-driven/>과 동일역할)
                        // but, ViewResolver를 properties파일에서 읽어오는 것과 같은 자동적 boot 기능들은 이 어노테이션을 통해 상실되게 된다.(주의!!)
@Configuration
public class WebConfig implements WebMvcConfigurer {

}
