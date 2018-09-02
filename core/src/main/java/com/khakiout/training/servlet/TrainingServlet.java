package com.khakiout.training.servlet;

import static org.apache.sling.api.servlets.ServletResolverConstants.SLING_SERVLET_EXTENSIONS;
import static org.apache.sling.api.servlets.ServletResolverConstants.SLING_SERVLET_METHODS;
import static org.apache.sling.api.servlets.ServletResolverConstants.SLING_SERVLET_PATHS;
import static org.apache.sling.api.servlets.ServletResolverConstants.SLING_SERVLET_RESOURCE_TYPES;
import static org.apache.sling.api.servlets.ServletResolverConstants.SLING_SERVLET_SELECTORS;

import java.io.IOException;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import org.apache.http.HttpStatus;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(
    service = { Servlet.class },
    property = {
//        SLING_SERVLET_RESOURCE_TYPES + "=/apps/training/servlet/foo",
        SLING_SERVLET_METHODS + "=GET",
        SLING_SERVLET_PATHS + "=/bin/training/data",
//        SLING_SERVLET_EXTENSIONS + "=json",
//        SLING_SERVLET_SELECTORS + "=foo",
    }
)
public class TrainingServlet extends SlingSafeMethodsServlet {

    private final Logger logger = LoggerFactory.getLogger(TrainingServlet.class);

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
        throws ServletException, IOException {
        logger.info("Got request for training data.");

        String message = "\"[{\"name\":\"page_one\",\"title\":\"Page One\"},"
            + "{\"name\":\"page_two\",\"title\":\"Page Two\"}]";

        response.setStatus(HttpStatus.SC_OK);
        response.getWriter().write(message);
    }

}
