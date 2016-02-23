package baobaotao.examples;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

public class BeanFactoryTest
{
    public static void main(String[] args) throws Throwable
    {
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource resource = resolver.getResource("classpath:beans.xml");
        BeanFactory beanFactory = new XmlBeanFactory(resource);

        Car car = beanFactory.getBean("car1", Car.class);
        System.out.println(car);
        car = beanFactory.getBean("car1", Car.class);
        System.out.println(car);
    }
}
