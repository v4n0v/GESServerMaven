package ru.glassexpress.modules.db_command.select.car;

import ru.glassexpress.modules.Res;
import ru.glassexpress.modules.db_command.DBSelectCommand;
import ru.glassexpress.objects_DB.IdTitleObj;

import java.sql.SQLException;

public class DBSelectMarkCommand extends DBSelectCommand {
    public DBSelectMarkCommand() {
        super(Res.GET_MARKS, null);
    }

    @Override
    protected void queryExecute() throws SQLException {
        composite.addComponent(new IdTitleObj(rs.getInt("id_auto_mark"), rs.getString("mark_title")));
    }

    @Override
    protected void prepareStatement() throws SQLException {

    }
}
