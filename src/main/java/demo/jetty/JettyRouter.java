package demo.jetty;

import org.apache.camel.builder.RouteBuilder;

public class JettyRouter extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("jetty:http://0.0.0.0:9000/example?httpMethodRestrict=GET,POST,PUT")
                .bean(RequestServiceBean.class, "processRequest")
                //.process(new RequestServiceProcessor())  alternative component for bean
                .to("file://data/responses");
    }
}
