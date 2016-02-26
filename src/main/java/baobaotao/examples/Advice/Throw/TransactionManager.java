package baobaotao.examples.Advice.Throw;

import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;

public class TransactionManager implements ThrowsAdvice
{
    //定义增强逻辑
    //当有异常抛出时，会向调用此方法，然后再将原有异常抛出
    public void afterThrowing(Method method, Object[] args, Object target, Exception ex) throws Throwable
    {
        System.out.println("--------");
        System.out.println("method" + method.getName());
        System.out.println("抛出异常: " + ex.getMessage());
        System.out.println("模拟回滚事务操作");
    }
}
