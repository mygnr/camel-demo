package demo.file;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;

public class FileToFileDemo {

    public static void main(String args[]) throws Exception {
        CamelContext context = new DefaultCamelContext();
        context.addRoutes(new FileToFileRoute());
        context.start();

        Thread.sleep(100000);
        context.stop();
    }
}