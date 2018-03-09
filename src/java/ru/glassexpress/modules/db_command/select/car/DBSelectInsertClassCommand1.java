package ru.glassexpress.modules.db_command.select.car;

import ru.glassexpress.modules.Res;
import ru.glassexpress.modules.db_command.DBSelectCommand;
import ru.glassexpress.objects_DB.InsertClass;
import ru.glassexpress.objects_DB.InsertClassElement;
import ru.glassexpress.objects_DB.builders.InsertClassBuilder;

import java.sql.SQLException;

public class DBSelectInsertClassCommand1 extends DBSelectCommand {
    public DBSelectInsertClassCommand1(String request) {
        super(Res.GET_INSERT_CLASS1, request);
    }

    protected void prepareStatement() throws SQLException {

    }

    protected void queryExecute() throws SQLException {
        InsertClassElement insertClass = new InsertClassElement(
                rs.getInt("id"),
                rs.getInt("id_glass_type"),
                rs.getFloat("price"),
                rs.getString("glass_type_title")
        );



        composite.addComponent(insertClass);
    }
}