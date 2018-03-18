package ru.glassexpress.modules.db_command.select.car;

import ru.glassexpress.modules.Res;
import ru.glassexpress.modules.db_command.DBSelectCommand;
import ru.glassexpress.objects_DB.IdTitleObj;

import java.sql.SQLException;

public class DBSelectModelCommand extends DBSelectCommand {

    public DBSelectModelCommand(String request) {
        super(Res.GET_MODELS, request);
    }



    @Override
    protected void prepareStatement() throws SQLException{
        ps.setInt(1,  parser.getIntValue("mark"));
        System.out.println("");
    }
    @Override
    protected void queryExecute() throws SQLException {

        composite.addComponent(new IdTitleObj(rs.getInt("id_auto_model"), rs.getString("title_model")));
    }

}
