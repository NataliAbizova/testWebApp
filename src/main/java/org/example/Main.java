package org.example;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class Main {
    public static void main(String[] args) throws Exception {

       Frontend frontend = new Frontend();

       Server server = new Server(8080);//сервер джетти на порту локалхост
        //создание сервлета и передача в него того что обробатывает запросы на сервер
       ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);

       server.setHandler(context);
       context.addServlet(new ServletHolder(frontend),"/authform");

       server.start();
       server.join();
    }
}