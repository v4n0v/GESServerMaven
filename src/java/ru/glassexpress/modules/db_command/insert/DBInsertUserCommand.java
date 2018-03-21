package ru.glassexpress.modules.db_command.insert;

import ru.glassexpress.modules.Res;
import ru.glassexpress.modules.db_command.DBEditCommand;

import java.sql.SQLException;

public class DBInsertUserCommand extends DBEditCommand {
    public DBInsertUserCommand(String request) {
        super(Res.INSERT_USER, request);
    }

    @Override
    protected void queryExecute() throws SQLException {
        ps.setString(1, parser.getStringValue("first_name"));
        ps.setString(2, parser.getStringValue("last_name"));
        ps.setInt(3, parser.getIntValue("id_pos"));
        ps.setInt(4, parser.getIntValue("id_salon"));
        ps.setInt(5, parser.getIntValue("key_user"));
        ps.setInt(6, parser.getIntValue("id_permission"));
    }

//(first_name,   last_name,    id_pos, id_salon, key_user, id_permission)
}
