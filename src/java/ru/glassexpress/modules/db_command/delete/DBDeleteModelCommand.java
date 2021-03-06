package ru.glassexpress.modules.db_command.delete;

import ru.glassexpress.modules.Res;
import ru.glassexpress.modules.db_command.DBEditCommand;

import java.sql.SQLException;

public class DBDeleteModelCommand  extends DBEditCommand {
    public DBDeleteModelCommand(String request) {
        super(Res.DELETE_MODEL, request);
    }

    @Override
    protected void queryExecute() throws SQLException {
        ps.setInt(1, parser.getIntValue("id"));
    }

    @Override
    protected void sendErrorMessage() {

    }
}
