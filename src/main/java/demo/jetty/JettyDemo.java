package demo.jetty;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;

public class JettyDemo {

    public static void main(String args[]) throws Exception {
        CamelContext context = new DefaultCamelContext();
        context.addRoutes(new JettyRouter());
        context.start();

        Thread.sleep(100000);
        context.stop();
    }
}
