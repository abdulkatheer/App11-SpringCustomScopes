package test;

import beans.Aadhar;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("resources/applicationContext.xml");

        Aadhar a1 = (Aadhar) context.getBean("a1");
        System.out.println(a1);
        System.out.println();
        Aadhar a2 = (Aadhar) context.getBean("a1");
        System.out.println(a2);
        System.out.println();

        //Now creating another thread
        //For each thread, CustomThreadLocal object will be create a new scope object. That's the point here.
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                Aadhar a3 = (Aadhar) context.getBean("a1");
                System.out.println(a3);
                System.out.println();
                Aadhar a4 = (Aadhar) context.getBean("a1");
                System.out.println(a4);
                System.out.println();
            }
        };

        Thread t1 = new Thread(r1);
        t1.start();

        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                Aadhar a5 = (Aadhar) context.getBean("a1");
                System.out.println(a5);
                System.out.println();
                Aadhar a6 = (Aadhar) context.getBean("a1");
                System.out.println(a6);
                System.out.println();
            }
        };

        Thread t2 = new Thread(r2);
        t2.start();
    }
}
