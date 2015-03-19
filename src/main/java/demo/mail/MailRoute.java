package demo.mail;

import org.apache.camel.builder.RouteBuilder;

public class MailRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("file://data/responses")
                .setHeader("subject", simple("New file: ${header.CamelFileName}"))
                .to("smtps://smtp.gmail.com:465?password=xxxxxx&username=xxxxxx@gmail.com&to=xxxxxx@gmail.com&debugMode=true");
    }
}
