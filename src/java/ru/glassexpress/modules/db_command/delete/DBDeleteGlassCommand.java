package ru.glassexpress.modules.db_command.delete;

import ru.glassexpress.modules.Res;
import ru.glassexpress.modules.db_command.DBEditCommand;

import java.sql.SQLException;

public class DBDeleteGlassCommand extends DBEditCommand {
    public DBDeleteGlassCommand(String request) {
        super(Res.DELETE_GLASS, request);
    }

    @Override
    protected void queryExecute() throws SQLException {
        ps.setInt(1, parser.getIntValue("id"));
    }
}

