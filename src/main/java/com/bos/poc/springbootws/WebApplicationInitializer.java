package com.bos.poc.springbootws;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

public class WebApplicationInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(final SpringApplicationBuilder application) {
        return application.sources(Application.class, WebConfiguration.class);
    }
}
