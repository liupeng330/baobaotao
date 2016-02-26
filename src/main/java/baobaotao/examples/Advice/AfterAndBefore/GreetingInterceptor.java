package baobaotao.examples.Advice.AfterAndBefore;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class GreetingInterceptor implements MethodInterceptor
{
    //截取目标类方法的执行，并在前后添加横切逻辑
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable
    {
        //目标方法的入参
        Object[] args = methodInvocation.getArguments();
        String clientName = (String)args[0];

        //在目标方法被调用前，加入横切逻辑
        System.out.println("How are you! Mr." + clientName);

        //通过反射机制调用目标方法
        Object obj = methodInvocation.proceed();

        //在目标方法被调用后，加入横切逻辑
        System.out.println("Please enjoy yourself!");

        //返回调用方法的返回值
        return obj;
    }
}
