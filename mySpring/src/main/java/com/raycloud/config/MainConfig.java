package com.raycloud.config;

import com.raycloud.bean.Person;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

//配置类==配置文件

@Configuration
//@ComponentScan
@ComponentScans(
        @ComponentScan(value = "com.raycloud",includeFilters = {
                @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Service.class}),
                @ComponentScan.Filter(type=FilterType.CUSTOM,classes = MyTpyeFilter.class)},useDefaultFilters = false)
)
public class MainConfig {
    //给容器中注册一个Bean，类型为返回值的类型，id默认是用方法名作为id
//    @Bean("person")
//    public Person person(){
//        return new Person("11","22");
//    }
}
