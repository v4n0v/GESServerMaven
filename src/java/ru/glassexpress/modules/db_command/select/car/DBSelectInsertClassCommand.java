package ru.glassexpress.modules.db_command.select.car;

import ru.glassexpress.modules.Res;
import ru.glassexpress.modules.db_command.DBSelectCommand;
import ru.glassexpress.objects_DB.IdTitleObj;
import ru.glassexpress.objects_DB.InsertClass;
import ru.glassexpress.objects_DB.builders.InsertClassBuilder;

import java.sql.SQLException;

public class DBSelectInsertClassCommand extends DBSelectCommand {
    public DBSelectInsertClassCommand(String request) {
        super(Res.GET_INSERT_CLASS, request);
    }

    protected void prepareStatement() throws SQLException {

    }

    protected void queryExecute() throws SQLException {
        InsertClass insertClass = new InsertClassBuilder()
                .setId(rs.getInt("id_auto_insert_class"))
                .setInsertFront(rs.getFloat("price_front"))
                .setInsertRear(rs.getFloat("price_rear"))
                .setInsertSide(rs.getFloat("price_side"))
                .setToneFront(rs.getFloat("price_tone"))
                .build();


        composite.addComponent(insertClass);
    }
}
