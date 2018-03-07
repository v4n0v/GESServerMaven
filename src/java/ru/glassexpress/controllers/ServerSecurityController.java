package ru.glassexpress.controllers;

public class ServerSecurityController implements SecurityManagerInterface{

    @Override
    public void connectDB() {
        System.out.println("соединение с базой ");
        validate();
    }

    @Override
    public boolean isValid() {
        connectDB();
        System.out.println("валидация завершена");
        return true;
    }

    @Override
    public void validate() {
        System.out.println("валидация");
    }

    @Override
    public void sendEmail() {
        System.out.println("отправка емейла");
    }
}
