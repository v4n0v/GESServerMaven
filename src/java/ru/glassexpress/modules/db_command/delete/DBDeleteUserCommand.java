package ru.glassexpress.modules.db_command.delete;

import ru.glassexpress.modules.Res;
import ru.glassexpress.modules.db_command.DBEditCommand;

import java.sql.SQLException;

public class DBDeleteUserCommand extends DBEditCommand {
    public DBDeleteUserCommand(  String request) {
        super(Res.DELETE_USER, request);
    }

    @Override
    protected void sendErrorMessage() {

    }

    @Override
    protected void queryExecute() throws SQLException {

            ps.setInt(1, parser.getIntValue("id"));
//            ps.executeUpdate();
//
//            ps = con.prepareStatement(Res.DELETE_USER);
//            ps.setInt(1, parser.getIntValue("id"));
    }
}
