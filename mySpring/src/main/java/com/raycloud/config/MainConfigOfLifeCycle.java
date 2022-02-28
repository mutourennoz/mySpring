package com.raycloud.config;

import com.raycloud.bean.Car;
import com.raycloud.bean.Dog;
import org.springframework.context.annotation.*;

import javax.annotation.PostConstruct;
import java.util.Calendar;

/**
 * bean 的生命周期
 * bean 的创建——初始化——销毁的过程
 * 容器管理bean的生命周期：
 * 我们可以自定义初始化和销毁方法：容器在bean进行到当前生命周期的时候来调用我们自定义的初始化和销毁方法
 * （1）指定初始化和销毁方法：
 *     xml 制定init-method和destroy-method
 * （2）通过Bean实现InitializingBean（定义初始化逻辑），DisposableBean（定义销毁逻辑）
 *
 * 构造（对象创建）
 *      单实例：在容器启动的时候创建
 *      多实例：在每次获取的时候创建
 *
 *
 *BeanPostProcessor.postProcessBeforeInitialization
 * 初始化：
 *      对象创建完成， ，调用初始化方法。。。
 *BeanPostProcessor.postProcessAfterInitialization
 * 销毁：
 *      单实例：容器关闭的时候
 *      多实例：容器不会管理这个bean 。close没用，容器不会调用销毁方法
 *  (3)可以使用JSR250 @PostConstruct 在bean创建完成并且属性值赋值完成，来执行初始化方法
 *                  @ PreDestroy
 * (4)BeanPostProcessor[interface】，bean的后置处理器
 *  在bean初始化前后进行一些处理工作
 *  postProcessBeforeInitialization:在初始化之前
 *  postProcessAfterInitialization：在初始化之后
 */
@Import(Dog.class)
@ComponentScan("com.raycloud.bean")
@Configuration
public class MainConfigOfLifeCycle {
//    @Scope("prototype")
    @Bean(initMethod = "init",destroyMethod = "destroy")
    public Car car(){
       return new Car();
    }
}
