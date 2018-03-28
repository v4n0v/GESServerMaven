package ru.glassexpress.modules.db_command.update;

import ru.glassexpress.modules.Res;
import ru.glassexpress.modules.db_command.DBEditCommand;
import ru.glassexpress.objects_DB.ErrorObject;

import java.sql.SQLException;

public class DBUpdateMarkCommand  extends DBEditCommand {

    public DBUpdateMarkCommand(String request) {
        super(Res.UPD_MARK, request);
    }

    protected void queryExecute() throws SQLException {

        // ps.setInt(1, parser.getIntValue("id_car"));
        ps.setString(1, parser.getStringValue("title"));
        ps.setInt(2, parser.getIntValue("id"));


    }

    @Override
    protected void sendErrorMessage() {
        composite.addComponent(new ErrorObject("Марка авто не обновленф "+parser.getStringValue("title")));
    }

}