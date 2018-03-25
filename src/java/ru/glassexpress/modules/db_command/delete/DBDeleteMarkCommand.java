package ru.glassexpress.modules.db_command.delete;

import ru.glassexpress.modules.Res;
import ru.glassexpress.modules.db_command.DBEditCommand;
import ru.glassexpress.objects_DB.ErrorObject;

import java.sql.SQLException;

public class DBDeleteMarkCommand extends DBEditCommand {
    public DBDeleteMarkCommand(String request) {
        super(Res.DELETE_MARK, request);
    }

    @Override
    protected void queryExecute() throws SQLException {
        ps.setInt(1, parser.getIntValue("id"));
    }

    @Override
    protected void sendErrorMessage() {

    }
}
