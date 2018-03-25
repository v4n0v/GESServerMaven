package ru.glassexpress.modules.db_command.insert;

import ru.glassexpress.modules.Res;
import ru.glassexpress.modules.db_command.DBEditCommand;
import ru.glassexpress.objects_DB.ErrorObject;

import java.sql.SQLException;

public class DBInsertModelCommand extends DBEditCommand {


    public DBInsertModelCommand(String request) {
        super(Res.INSERT_MODEL, request);
       // this.request=request;
    }

    @Override
    protected void queryExecute() throws SQLException{
        ps.setString(1, parser.getStringValue("model"));
        ps.setString(2, parser.getStringValue("mark"));

    }


    @Override
    protected void sendErrorMessage() {
        composite.addComponent(new ErrorObject("Модель " + parser.getStringValue("model")+" не добавлена в базу"));
    }
}
