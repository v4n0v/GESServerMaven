package ru.glassexpress.modules.db_command.insert;

import ru.glassexpress.modules.Res;
import ru.glassexpress.modules.db_command.DBEditCommand;
import ru.glassexpress.objects_DB.ErrorObject;

import java.sql.Date;
import java.sql.SQLException;

public class DBInserNewDayCommand extends DBEditCommand {
    public DBInserNewDayCommand(String request) {
        super(Res.INSERT_NEW_DAY, request);
    }

    @Override
    protected void sendErrorMessage() {
        composite.addComponent(new ErrorObject("Ошибка добавления новго дня в базу"));
    }

    @Override
    protected void queryExecute() throws SQLException {
        Date date = new Date(parser.getLongValue("date"));
        ps.setDate(1, date);
        ps.setString(2, parser.getStringValue("employeesJson"));

        ps.setInt(3, parser.getIntValue("idAdmin"));
        ps.setInt(4, parser.getIntValue("id_salon"));
    }
}
