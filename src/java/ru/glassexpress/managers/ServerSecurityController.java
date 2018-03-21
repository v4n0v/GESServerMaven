package ru.glassexpress.managers;

import ru.glassexpress.modules.db_command.select.user.DBUserByKeyCommand;
import ru.glassexpress.objects_DB.Composite;
import ru.glassexpress.objects_DB.UserObject;

public class ServerSecurityController implements SecurityManagerInterface {


    public void connectDB() {
        System.out.println("соединение с базой ");
        validate();
    }


    public boolean isValid() {
        connectDB();
        System.out.println("валидация завершена");
        return true;
    }


    public UserObject getUser(String req) {

        DBUserByKeyCommand command = new DBUserByKeyCommand(req);
        Composite composite = command.execute();
        UserObject user = (UserObject) composite.getComponents().get(0);
        return user;
    }

    public void validate() {
        System.out.println("валидация");
    }

    public void sendEmail() {
        System.out.println("отправка емейла");
    }
}
