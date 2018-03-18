package ru.glassexpress.modules.db_command.insert;

import ru.glassexpress.modules.Res;
import ru.glassexpress.modules.db_command.DBEditCommand;

import java.sql.SQLException;

public class DBInsertGenerationCommand extends DBEditCommand {
    public DBInsertGenerationCommand(String request) {
        super(Res.INSERT_GENERATION, request);
    }

    @Override
    protected void queryExecute() throws SQLException {
        System.out.println("insert generation");

        ps.setInt(1, parser.getIntValue("yearFrom"));
        ps.setInt(2, parser.getIntValue("yearTo"));
        ps.setInt(3, parser.getIntValue("model"));
    }
}
