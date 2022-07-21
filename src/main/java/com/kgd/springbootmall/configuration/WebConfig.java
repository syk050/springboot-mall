package com.kgd.springbootmall.configuration;//@EnableWebMvc         // 어노테이션 기반 SpringMVC를 구성할 때, 필요한 빈 설정들을 자동으로 해주는 어노테이션(<mvc:annotation-driven/>과 동일역할)
// but, ViewResolver를 properties파일에서 읽어오는 것과 같은 자동적 boot 기능들은 이 어노테이션을 통해 상실되게 된다.(주의!!)

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan(basePackages = {"com.kgd.springbootmall"},   // 해당 패키지 경로에 있는 컴포넌트들을 자동 스캔(컴포넌트는 전역이름이라 보면된다. 실제로는 @Repository, @Service, @Controller, @Configuration이 이에 해당된다)
        excludeFilters = {  //제외할 컴포넌트들을 설정한다.
//        @ComponentScan.Filter(type = FilterType.ANNOTATION, value = )

        })
public class WebConfig implements WebMvcConfigurer {

}