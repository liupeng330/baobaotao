package baobaotao.examples.threadLocal;

import org.apache.ibatis.io.ResolverUtil;
import org.apache.xmlbeans.XmlFactoryHook;

public class SequenceNumber
{
    private static ThreadLocal<Integer> seqNum = new ThreadLocal<Integer>()
    {
        @Override
        public Integer initialValue()
        {
            return 0;
        }
    };

    //将seqNum中的Integer++
    public int getNextNum()
    {
        this.seqNum.set(this.seqNum.get() + 1);
        return this.seqNum.get();
    }

    public static void main(String[] args)
    {
        SequenceNumber sn = new SequenceNumber();

        //三个线程共享一个sn
        TestClient testClient1 = new TestClient(sn);
        TestClient testClient2 = new TestClient(sn);
        TestClient testClient3 = new TestClient(sn);
        testClient1.start();
        testClient2.start();
        testClient3.start();

        //输出结果如下：
        /*
        thread[Thread-0] sn[1]
        thread[Thread-1] sn[1]
        thread[Thread-1] sn[2]
        thread[Thread-2] sn[1]
        thread[Thread-1] sn[3]
        thread[Thread-0] sn[2]
        thread[Thread-2] sn[2]
        thread[Thread-0] sn[3]
        thread[Thread-2] sn[3]
        */
        //每个线程都独享一个sn值
    }

    private static class TestClient extends Thread
    {
        private SequenceNumber sn;
        public TestClient(SequenceNumber sn)
        {
            this.sn = sn;
        }

        @Override
        public void run()
        {
            for(int i=0; i < 3; i++)
            {
                System.out.println("thread[" + Thread.currentThread().getName() + "] sn[" + sn.getNextNum() + "]");
            }
        }
    }
}
