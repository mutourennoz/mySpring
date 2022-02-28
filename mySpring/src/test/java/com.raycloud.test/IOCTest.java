package com.raycloud.test;

import com.raycloud.bean.Person;
import com.raycloud.config.MainConfig;
import com.raycloud.config.MainConfig2;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import sun.plugin.PluginURLJarFileCallBack;

import javax.xml.transform.Source;
import java.util.Map;

public class IOCTest {
    AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);


    @Test
    public void testImport(){

        printBeans(annotationConfigApplicationContext);
        Object colorFactoryBean = annotationConfigApplicationContext.getBean("colorFactoryBean");
        Object realColorFactoryBean = annotationConfigApplicationContext.getBean("&colorFactoryBean");
        System.out.println(colorFactoryBean.getClass());
        System.out.println(realColorFactoryBean.getClass());
    }

    private void  printBeans(AnnotationConfigApplicationContext applicationContext){
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
    }
    @SuppressWarnings("resource")
    @Test
    public void test01(){
        String[] beanDefinitionNames = annotationConfigApplicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
    }

    @Test
    public void test02(){
        //单例对象 只在容器初始化建立时创建一次
        //多例对象 是在使用时才创建，可以创建多次
        System.out.println("容器创建完成。。。。。。。。");
//        String[] beanDefinitionNames = annotationConfigApplicationContext.getBeanDefinitionNames();
//        for (String beanDefinitionName : beanDefinitionNames) {
//            System.out.println(beanDefinitionName);
//        }
//        Object person1 = annotationConfigApplicationContext.getBean("person");
//        Object person2 = annotationConfigApplicationContext.getBean("person");
//        System.out.println(person1==person2);
    }

    @Test
    public void test03(){
        String[] beanNamesForType = annotationConfigApplicationContext.getBeanNamesForType(Person.class);
        ConfigurableEnvironment environment = annotationConfigApplicationContext.getEnvironment();
        String property = environment.getProperty("os.name");
        System.out.println(property);
        for (String s : beanNamesForType) {
            System.out.println(s);
        }
        Map<String, Person> beansOfType = annotationConfigApplicationContext.getBeansOfType(Person.class);
        System.out.println(beansOfType);

    }

}
