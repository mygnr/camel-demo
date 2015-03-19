package demo.jetty;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import javax.servlet.http.HttpServletRequest;

public class RequestServiceProcessor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        String body = exchange.getIn().getBody(String.class);
        System.out.println("body = " + body);

        // we have access to the HttpServletRequest here and we can grab it if we need it
        HttpServletRequest req = exchange.getIn().getBody(HttpServletRequest.class);
        System.out.println("req = " + req);

        exchange.getOut().setBody("STATUS_INFORMATION : Web Service is Accessible");

        // We can set response code here
        //exchange.getIn().setHeader(Exchange.HTTP_RESPONSE_CODE, 200);
    }
}
