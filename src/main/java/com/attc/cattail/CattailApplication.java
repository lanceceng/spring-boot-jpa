package com.attc.cattail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.ApplicationContext;

import java.net.InetAddress;
import java.net.UnknownHostException;

@SpringBootApplication
public class CattailApplication {
    private static ApplicationContext ctx;
    public static void main(String[] args) {
        ctx  = SpringApplication.run(CattailApplication.class, args);
        try {
            String host = InetAddress.getLocalHost().getHostAddress();
            TomcatServletWebServerFactory tomcatServletWebServerFactory= (TomcatServletWebServerFactory) ctx.getBean("tomcatServletWebServerFactory");
            int port = tomcatServletWebServerFactory.getPort();
            String contextPath = tomcatServletWebServerFactory.getContextPath();
            System.out.println("http://"+host+":"+port+contextPath+"/");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
