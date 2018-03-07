package ru.glassexpress.modules.db_command.select.glass;

import ru.glassexpress.modules.Res;
import ru.glassexpress.modules.db_command.DBSelectCommand;
import ru.glassexpress.objects_DB.IdTitleObj;

import java.sql.SQLException;

public class DBSelectGlassFactoryCommand extends DBSelectCommand {

    public DBSelectGlassFactoryCommand(String request) {
        super(Res.SELECT_GLASS_FACTORY, request);
    }

    @Override
    protected void prepareStatement() throws SQLException {

    }

    @Override
    protected void queryExecute() throws SQLException {
        composite.addComponent(new IdTitleObj(rs.getInt("id_glass_factory"), rs.getString("title_glass_factory")));
    }
}
