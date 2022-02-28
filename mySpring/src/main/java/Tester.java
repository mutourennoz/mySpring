import com.raycloud.bean.Person;
import com.raycloud.config.MainConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Tester {
    public static void main(String[] args) {
//        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("beans.xml");
//        Person person = (Person) classPathXmlApplicationContext.getBean("person");
//        System.out.println(person.getAge()+" "+person.getName());

        ApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        Person bean = annotationConfigApplicationContext.getBean(Person.class);
//        System.out.println(bean);

        Person fuck = (Person) annotationConfigApplicationContext.getBean("person");
        System.out.println(fuck);


    }
}
