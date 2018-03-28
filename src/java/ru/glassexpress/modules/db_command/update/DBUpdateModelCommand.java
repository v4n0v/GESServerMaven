package ru.glassexpress.modules.db_command.update;

import ru.glassexpress.modules.Res;
import ru.glassexpress.modules.db_command.DBEditCommand;
import ru.glassexpress.objects_DB.ErrorObject;

import java.sql.SQLException;

public class DBUpdateModelCommand extends DBEditCommand {

    public DBUpdateModelCommand(String request) {
        super(Res.UPD_MODEL, request);
    }

    protected void queryExecute() throws SQLException {

        // ps.setInt(1, parser.getIntValue("id_car"));
        ps.setString(1, parser.getStringValue("title"));
        ps.setInt(2, parser.getIntValue("id"));


    }

    @Override
    protected void sendErrorMessage() {
        composite.addComponent(new ErrorObject("Модель авто не обновленф "+parser.getStringValue("title")));
    }

}