package ru.glassexpress;

import ru.glassexpress.controllers.ServerResponseController;
import ru.glassexpress.controllers.ServerSecurityController;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet(name = "Servlet")
public class Servlet extends HttpServlet {

    ServerResponseController controller;
    ServerSecurityController securityManager;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
   //     request.setCharacterEncoding("UTF-8");



        securityManager = new ServerSecurityController();
        controller = new ServerResponseController();

        // проверка ключа
        if (securityManager.isValid()) {
            String answerJson = controller.createResponse(request);

            response.setContentType("text/html");
            response.setCharacterEncoding("UTF-8");

            if (answerJson != null) {
                PrintWriter out = response.getWriter();
                out.println(answerJson);
                System.out.println("======================================");
                System.out.println("sending json");
                System.out.println(answerJson);
                out.close();
                System.out.println("sending json complete");
                System.out.println("======================================");
            }
        }

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doPost(request, response);
    }


}
