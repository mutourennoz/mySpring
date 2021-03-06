package com.raycloud.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Dog {
    public Dog() {
        System.out.println("Dog...constructor...");
    }
    //对象创建并赋值之后调用
    @PostConstruct
    public void init(){
        System.out.println("Dog...@PostConstruct..");
    }
    //容器移除对象之前
    @PreDestroy
    public void destroy(){
        System.out.println("Dog...@PreDestroy...");
    }
}
