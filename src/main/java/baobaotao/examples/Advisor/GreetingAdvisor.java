package baobaotao.examples.Advisor;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.StaticMethodMatcherPointcutAdvisor;

import java.lang.reflect.Method;

//只匹配Waiter类和其之类中方法名是greetTo的方法
public class GreetingAdvisor extends StaticMethodMatcherPointcutAdvisor
{
    //匹配方法名是greetTo的方法
    @Override
    public boolean matches(Method method, Class<?> aClass)
    {
        return "greetTo".equals(method.getName());
    }

    //匹配Waiter类和其之类
    public ClassFilter getClassFilter()
    {
        return new ClassFilter()
        {
            @Override
            public boolean matches(Class<?> aClass)
            {
                return Waiter.class.isAssignableFrom(aClass);
            }
        };
    }
}
