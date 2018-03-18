package ru.glassexpress.modules.db_command.insert;

import ru.glassexpress.modules.Res;
import ru.glassexpress.modules.db_command.DBEditCommand;

import java.sql.SQLException;

public class DBInsertMarkCommand extends DBEditCommand {
    public DBInsertMarkCommand(String request) {
        super(Res.INSERT_MARK, request);
    }

    @Override
    protected void queryExecute() throws SQLException {
        ps.setString(1, parser.getStringValue("mark"));
    }
}
