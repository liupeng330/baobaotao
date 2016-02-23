package baobaotao.examples;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;

public class FileSourceExample
{
    public static void main(String[] args)
    {
        try
        {
            String filePath = "/Users/peng/IdeaProjects/baobaotao/target/classes/test/myconf.txt";

            // 使用系统文件路径方式加载文件
            Resource res1 = new FileSystemResource(filePath);

            // 使用类路径方式加载文件
            Resource res2 = new ClassPathResource("test/myconf.txt");

            InputStream ins1 = res1.getInputStream();
            InputStream ins2 = res2.getInputStream();
            System.out.println("res1:" + res1.getFilename());
            System.out.println("res2:" + res2.getFilename());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
