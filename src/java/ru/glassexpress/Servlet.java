package ru.glassexpress;

import ru.glassexpress.managers.ServerResponseController;
import ru.glassexpress.managers.ServerSecurityController;
import ru.glassexpress.objects_DB.UserObject;

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


        String answerJson=null;
        String aa = request.getQueryString();   controller = new ServerResponseController();

        // если не проверка логина, то проверяем ключ
        if (!request.getParameter("action").equals("login")) {
            UserObject user;
            securityManager = new ServerSecurityController();


            user = securityManager.getUser(request.getQueryString());
            if (user!=null) {
                answerJson = controller.createResponse(request, user);
            } else {
                answerJson = controller.createErrorResponse();
            }
          // если проверка логина, то предаем запрос с пустым пользователем. костыль ппц
        } else {
            answerJson = controller.createResponse(request, null);
        }

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

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doPost(request, response);
    }

    public void clickServ() {

    }


}
