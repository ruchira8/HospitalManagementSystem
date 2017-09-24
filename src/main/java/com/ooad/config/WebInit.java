package com.ooad.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

@Configuration
public class WebInit implements WebApplicationInitializer {
    public void onStartup(ServletContext container) throws ServletException {
        AnnotationConfigWebApplicationContext webContext = new AnnotationConfigWebApplicationContext();
        webContext.register(WebConfig.class);
        webContext.setServletContext(container);
        ServletRegistration.Dynamic servlet = container.addServlet(
                "dispatcher", new DispatcherServlet(webContext));
        servlet.setLoadOnStartup(1);
        servlet.addMapping("/");
    }
}
