package ru.glassexpress.modules.db_command.select;

import ru.glassexpress.modules.Res;
import ru.glassexpress.modules.db_command.DBSelectCommand;
import ru.glassexpress.objects_DB.ServiceObject;

import java.sql.SQLException;

public class DBselectServiceCommand extends DBSelectCommand{
    public DBselectServiceCommand(String request) {
        super(Res.SELECT_SERVICES, request);
    }

    @Override
    protected void prepareStatement() throws SQLException {

    }

    @Override
    protected void queryExecute() throws SQLException {
        composite.addComponent(new ServiceObject(rs.getInt("id_service"), rs.getString("title_service"), rs.getFloat("base_price")));
    }
}
