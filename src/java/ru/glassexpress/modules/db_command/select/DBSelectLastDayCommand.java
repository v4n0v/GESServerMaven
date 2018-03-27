package ru.glassexpress.modules.db_command.select;

import ru.glassexpress.modules.Res;
import ru.glassexpress.modules.db_command.DBSelectCommand;
import ru.glassexpress.objects_DB.DateObject;

import java.sql.SQLException;

public class DBSelectLastDayCommand extends DBSelectCommand {
    public DBSelectLastDayCommand( String request) {
        super(Res.GET_LAST_DAY, request);
    }

    @Override
    protected void prepareStatement() throws SQLException {
        ps.setInt(1, parser.getIntValue("id_salon"));
    }

    @Override
    protected void queryExecute() throws SQLException {
        composite.addComponent(new DateObject(rs.getInt("id_day"), rs.getDate("day_date"), rs.getString("emp_list_json"), rs.getInt("id_admin"), rs.getInt("id_salon")));
    }
}
