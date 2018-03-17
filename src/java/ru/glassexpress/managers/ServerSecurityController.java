package ru.glassexpress.managers;

public class ServerSecurityController implements SecurityManagerInterface{


    public void connectDB() {
        System.out.println("соединение с базой ");
        validate();
    }


    public boolean isValid() {
        connectDB();
        System.out.println("валидация завершена");
        return true;
    }

    public void validate() {
        System.out.println("валидация");
    }

    public void sendEmail() {
        System.out.println("отправка емейла");
    }
}
