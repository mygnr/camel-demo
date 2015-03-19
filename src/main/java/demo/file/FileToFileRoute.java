package demo.file;

import org.apache.camel.builder.RouteBuilder;

public class FileToFileRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("file://data/incomingFiles").to("file://data/outcomingFiles");
    }
}
