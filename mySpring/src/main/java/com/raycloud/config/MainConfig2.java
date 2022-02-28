package com.raycloud.config;

import com.raycloud.bean.Color;
import com.raycloud.bean.ColorFactoryBean;
import com.raycloud.bean.Person;
import com.raycloud.bean.Red;
import com.raycloud.condition.MacCondition;
import com.raycloud.condition.MyImportBeanDefinitionRegister;
import com.raycloud.condition.MyImportSelector;
import com.raycloud.condition.WindowsCondition;
import com.sun.deploy.net.protocol.ProtocolType;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;

import java.nio.channels.Pipe;


@Configuration
@ComponentScan
@Import({Color.class, Red.class, MyImportSelector.class, MyImportBeanDefinitionRegister.class})
public class MainConfig2 {
//    @Scope("prototype")
//    @Lazy
    @Bean("person")
    public Person person(){
        System.out.println("person实例创建完成。。。。");
        return new Person("张三","13");
    }

    /**
     * @Conditional 根据条件
     * @return
     */
    @Conditional(WindowsCondition.class)
    @Bean("bill")
    public Person person01(){
        return new Person("Bill gates","62");
    }
    @Conditional({MacCondition.class})
    @Bean("linus")
    public Person person02(){
        return new Person("linus","48");
    }
    /**
     * 给容器注册组建：
     * 1、包扫描+组建标注注解 @Controller @Service @Component @Repository——局限于自己写的
     * 2、第三方包 @Bean——无参构造器，如上 person02
     * 3、@Import（要导入到容器中的组件）：
     * （1）容器中就会自动注册这个组件，id默认是全类名
     * （2）ImportSelector:返回需要导入的组件的全类名
     *  (3)手动注册 ImportBeanDefinitionRegistrar
     *  4、使用Spring提供的FactoryBean（工厂bean）
     *  （1）在id前面添加&前缀，可以获取工厂bean本身，不然是 getObject 里的返回对象
     */

    @Bean
    public ColorFactoryBean colorFactoryBean(){
        return new ColorFactoryBean();
    }

}
