package demo.jetty;

import org.apache.camel.Exchange;

import javax.servlet.http.HttpServletRequest;


public class RequestServiceBean {

    public void processRequest(Exchange exchange) throws Exception {
        String body = exchange.getIn().getBody(String.class);
        System.out.println("body = " + body);

        HttpServletRequest req = exchange.getIn().getBody(HttpServletRequest.class);
        System.out.println("req = " + req);

        exchange.getOut().setBody("STATUS_INFORMATION : Web Service is Accessible");

        // We can set response code here
        //exchange.getIn().setHeader(Exchange.HTTP_RESPONSE_CODE, 200);

        //exchange.getOut().setBody("<html><body><b>Camel</b> is in Action</body></html>");
    }

}
