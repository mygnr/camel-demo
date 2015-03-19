package lt.kaunasjug.camel.demo.jetty;

import demo.jetty.RequestServiceBean;
import org.apache.camel.EndpointInject;
import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class RequestServiceTest extends CamelTestSupport {

    @EndpointInject(uri = "mock:result")
    protected MockEndpoint resultEndpoint;

    @Produce(uri = "direct:start")
    protected ProducerTemplate template;

    @Test
    public void testGoodRequestServiceResponse() throws InterruptedException {
        String expectedBody = "STATUS_INFORMATION : Web Service is Accessible";
        resultEndpoint.expectedBodiesReceived(expectedBody);
        resultEndpoint.expectedMessageCount(1);

        template.sendBody("123");

        resultEndpoint.assertIsSatisfied();
    }

    @Test
    public void testBadRequestServiceResponse() throws InterruptedException {
        String expectedBody = "STATUS_INFORMATION : Web Service is not Accessible";
        resultEndpoint.expectedBodiesReceived(expectedBody);

        template.sendBody("321");

        resultEndpoint.assertIsNotSatisfied();
    }

    @Override
    protected RouteBuilder createRouteBuilder() throws Exception {
        return new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from("direct:start")
                        .bean(RequestServiceBean.class, "processRequest")
                        .to("mock:result");
            }
        };
    }
}
