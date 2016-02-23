package baobaotao.examples.proxy;

public class PerformanceMonitor
{
    private static ThreadLocal<MethodPerformance> performanceThreadLocal = new ThreadLocal<MethodPerformance>();

    public static void begin(String method)
    {
        System.out.println("begin monitor...");
        MethodPerformance mp = new MethodPerformance(method);
        performanceThreadLocal.set(mp);
    }

    public static void end()
    {
        System.out.println("end monitor...");
        MethodPerformance mp = performanceThreadLocal.get();

        mp.printPerformance();
    }
}
