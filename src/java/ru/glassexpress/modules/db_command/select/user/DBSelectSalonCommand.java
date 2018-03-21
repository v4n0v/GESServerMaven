package ru.glassexpress.modules.db_command.select.user;

import ru.glassexpress.modules.Res;
import ru.glassexpress.modules.db_command.DBSelectCommand;
import ru.glassexpress.objects_DB.IdTitleObj;

import java.sql.SQLException;

public class DBSelectSalonCommand extends DBSelectCommand {
    public DBSelectSalonCommand(String request) {
        super(Res.SELECT_SALONS, request);
    }

    @Override
    protected void prepareStatement() throws SQLException {

    }

    @Override
    protected void queryExecute() throws SQLException {
        composite.addComponent(new IdTitleObj(rs.getInt("id_salon"), rs.getString("title_salon")));
    }
}

