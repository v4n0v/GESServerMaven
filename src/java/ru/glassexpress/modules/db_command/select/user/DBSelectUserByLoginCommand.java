package ru.glassexpress.modules.db_command.select.user;

import ru.glassexpress.modules.Res;
import ru.glassexpress.modules.db_command.DBSelectCommand;
import ru.glassexpress.objects_DB.IdTitleObj;
import ru.glassexpress.objects_DB.UserObject;
import ru.glassexpress.objects_DB.builders.UserBuilder;

import java.sql.SQLException;

public class DBSelectUserByLoginCommand extends DBSelectCommand {

    public DBSelectUserByLoginCommand(String request) {
        super(Res.SELECT_USER_BY_LOGIN, request);
    }



    @Override
    protected void prepareStatement() throws SQLException {
        ps.setString(1,  parser.getStringValue("login"));
        ps.setInt(2,  parser.getIntValue("pass"));
        System.out.println("");
    }
    @Override
    protected void queryExecute() throws SQLException {
        IdTitleObj user = new IdTitleObj(0,rs.getString("userKey"));
//        UserObject user = new UserBuilder()
//                .setId(rs.getInt("id_emp"))
//                .setName(rs.getString("first_name"))
//                .setLastName(rs.getString("last_name"))
//                .setPositionId(rs.getInt("id_pos"))
//                .setSalonId(rs.getInt("id_salon"))
//                .setPermission(rs.getInt("id_permission"))
//                .setKey(rs.getString("key_orig"))
//                .build();



        composite.addComponent(user);
    }
}
