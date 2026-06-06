package org.example;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import servlets.AllRequestsServlet;

public class Main {
    public static void main(String[] args) throws Exception {

       AllRequestsServlet frontend = new AllRequestsServlet();

       Server server = new Server(8080);//сервер джетти на порту локалхост
        //создание сервлета и передача в него того что обробатывает запросы на сервер
       ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);

       context.addServlet(new ServletHolder(frontend),"/*");
       server.setHandler(context);

       server.start();
       server.join();
    }
}