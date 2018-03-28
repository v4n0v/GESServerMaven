package ru.glassexpress.modules.db_command.update;

import ru.glassexpress.modules.Res;
import ru.glassexpress.modules.db_command.DBEditCommand;
import ru.glassexpress.objects_DB.ErrorObject;

import java.sql.SQLException;

public class DBUpdateUserLogin extends DBEditCommand {

    public DBUpdateUserLogin(String request) {
        super(Res.UPD_LOGIN_USER, request);
    }

    protected void queryExecute() throws SQLException {

        // ps.setInt(1, parser.getIntValue("id_car"));
        ps.setString(1, parser.getStringValue("login"));
        ps.setInt(2, parser.getIntValue("id"));

        ps.executeUpdate();
        ps = con.prepareStatement(Res.UPD_LOGIN_EMP);
        ps.setString(1, parser.getStringValue("login"));
        ps.setInt(2, parser.getIntValue("id"));

    }

    @Override
    protected void sendErrorMessage() {
        composite.addComponent(new ErrorObject("Логин "+parser.getStringValue("title")+" не обновлен, ошибка записи в базу\nПопробуйте еще раз"));
    }

}