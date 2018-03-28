package ru.glassexpress.modules.db_command.update;

import ru.glassexpress.modules.Res;
import ru.glassexpress.modules.db_command.DBEditCommand;
import ru.glassexpress.objects_DB.ErrorObject;

import java.sql.SQLException;

public class DBUpdateUserPass extends DBEditCommand {

    public DBUpdateUserPass(String request) {
        super(Res.UPD_PASS, request);
    }

    protected void queryExecute() throws SQLException {

        // ps.setInt(1, parser.getIntValue("id_car"));
        ps.setInt(1, parser.getIntValue("pass"));
        ps.setString(2, parser.getStringValue("login"));


    }

    @Override
    protected void sendErrorMessage() {
        composite.addComponent(new ErrorObject("Пароль не изменен "+parser.getStringValue("title")+" \nОшибка чтения базы"));
    }

}