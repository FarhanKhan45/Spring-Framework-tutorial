
package in.springmvc;

import java.io.File;
import java.util.Collections;

import org.apache.catalina.Context;
import org.apache.catalina.Wrapper;
import org.apache.catalina.startup.Tomcat;
import org.apache.jasper.servlet.JasperInitializer;
import org.apache.jasper.servlet.JspServlet;

import in.springmvc.config.WebConfig;

import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class Main {

    public static void main(String[] args) throws Exception {

        // 1. Create embedded Tomcat
        Tomcat tomcat = new Tomcat();

        // 2. Set server port
        tomcat.setPort(8080);

        // 3. Initialize connector
        tomcat.getConnector();

        // 4. Configure web application directory
        String contextPath = "";

        String baseDoc = new File(
                "src/main/webapp"
        ).getAbsolutePath();

        // 5. Create Tomcat context
        Context context = tomcat.addContext(
                contextPath,
                baseDoc
        );

        // 6. Register Jasper initializerASA
        context.addServletContainerInitializer(
                new JasperInitializer(),
                Collections.emptySet()
        );

        // 7. Create Spring Web Application Context
        AnnotationConfigWebApplicationContext springContext =
                new AnnotationConfigWebApplicationContext();

        // 8. Connect Spring Context with Tomcat ServletContext
        springContext.setServletContext(
                context.getServletContext()
        );

        // 9. Register Spring configuration class
        springContext.register(WebConfig.class);

        // 10. Initialize Spring container
        springContext.refresh();

        // 11. Create DispatcherServlet
        DispatcherServlet dispatcherServlet =
                new DispatcherServlet(springContext);

        // 12. Register DispatcherServlet with Tomcat
        Tomcat.addServlet(
                context,
                "dispatcherServlet",
                dispatcherServlet
        );

        // 13. Map DispatcherServlet to all requests
        context.addServletMappingDecoded(
                "/",
                "dispatcherServlet"
        );

        // 14. Register JSP servlet
        Wrapper jspServlet = Tomcat.addServlet(
                context,
                "jsp",
                new JspServlet()
        );

        // 15. Configure JSP servlet
        jspServlet.addInitParameter(
                "development",
                "true"
        );

        jspServlet.setLoadOnStartup(3);

        // 16. Map JSP files to JSP servlet
        context.addServletMappingDecoded(
                "*.jsp",
                "jsp"
        );

        // 17. Start Tomcat
        tomcat.start();

        System.out.println("Tomcat started on port 8080");

        // 18. Keep server running
        tomcat.getServer().await();
    }
}