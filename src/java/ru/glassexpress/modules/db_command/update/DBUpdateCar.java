package ru.glassexpress.modules.db_command.update;

import ru.glassexpress.modules.Res;
import ru.glassexpress.modules.db_command.DBEditCommand;
import ru.glassexpress.objects_DB.ErrorObject;

import java.sql.SQLException;

public class DBUpdateCar extends DBEditCommand {

    public DBUpdateCar(String request) {
        super(Res.UPD_GENERATION, request);
    }

    protected void queryExecute() throws SQLException {

        // ps.setInt(1, parser.getIntValue("id_car"));
        ps.setInt(1, parser.getIntValue("yearFrom"));
        ps.setInt(2, parser.getIntValue("yearTo"));
        ps.setInt(3, parser.getIntValue("id"));

    }

    @Override
    protected void sendErrorMessage() {
        composite.addComponent(new ErrorObject("Поколение авто не обновлено "+parser.getIntValue("yearFrom")+" "+parser.getIntValue("yearTo")));
    }

}