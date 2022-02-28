package com.raycloud.test;

import com.raycloud.bean.Car;
import com.raycloud.config.MainConfigOfLifeCycle;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class IOCTest_LifeCycle {
    @Test
    public void test01(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfLifeCycle.class);
        System.out.println("容器创建完成...");
//        Car bean = applicationContext.getBean(Car.class);

        applicationContext.close();
    }
}
