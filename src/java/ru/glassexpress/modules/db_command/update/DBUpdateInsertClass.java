package ru.glassexpress.modules.db_command.update;

import ru.glassexpress.modules.Res;
import ru.glassexpress.modules.db_command.DBEditCommand;
import ru.glassexpress.objects_DB.ErrorObject;

import java.sql.SQLException;

public class DBUpdateInsertClass extends DBEditCommand {
    public DBUpdateInsertClass(String request) {
        super(Res.UPD_CAR_INSERT_CLASS, request);
    }

    protected void queryExecute() throws SQLException {
        ps.setInt(1, parser.getIntValue("id"));
        ps.setInt(2, parser.getIntValue("autoId"));
    }

    @Override
    protected void sendErrorMessage() {

    }
}
