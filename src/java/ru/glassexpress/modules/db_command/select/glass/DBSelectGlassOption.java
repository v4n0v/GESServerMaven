package ru.glassexpress.modules.db_command.select.glass;

import ru.glassexpress.modules.Res;
import ru.glassexpress.modules.db_command.DBSelectCommand;
import ru.glassexpress.objects_DB.IdTitleObj;

import java.sql.SQLException;

public class DBSelectGlassOption extends DBSelectCommand {
    public DBSelectGlassOption(String request) {
        super(Res.SELECT_GLASS_OPT, request);
    }

    @Override
    protected void prepareStatement() throws SQLException {

    }

    @Override
    protected void queryExecute() throws SQLException {
        composite.addComponent(new IdTitleObj(rs.getInt("id_glass_option"), rs.getString("glass_option_title")));
    }
}
