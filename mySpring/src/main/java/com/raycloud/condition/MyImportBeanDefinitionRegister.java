package com.raycloud.condition;

import com.raycloud.bean.Rainbow;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import java.rmi.registry.Registry;

public class MyImportBeanDefinitionRegister implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry){
        boolean red = registry.containsBeanDefinition("com.raycloud.bean.Blue");
        boolean blue = registry.containsBeanDefinition("com.raycloud.bean.Yellow");
        if(red&&blue){
            RootBeanDefinition rainbow = new RootBeanDefinition(Rainbow.class);
            registry.registerBeanDefinition("rainbow",rainbow);
        }

    }

}
