package ru.glassexpress.modules.db_command.select.user;

import ru.glassexpress.modules.Res;
import ru.glassexpress.modules.db_command.DBSelectCommand;
import ru.glassexpress.objects_DB.GenerationObj;
import ru.glassexpress.objects_DB.UserObject;
import ru.glassexpress.objects_DB.builders.UserBuilder;

import java.sql.SQLException;

public class DBSelectAllEmployesCommand extends DBSelectCommand {
    public DBSelectAllEmployesCommand( String request) {
        super(Res.SELECT_USERS, request);
    }

    @Override
    protected void prepareStatement() throws SQLException {

    }

    @Override
    protected void queryExecute() throws SQLException {
        UserObject user = new UserBuilder()
                .setId(rs.getInt("id_emp"))
                .setName(rs.getString("first_name"))
                .setLastName(rs.getString("last_name"))
                .setPositionId(rs.getInt("id_pos"))
                .setSalonId(rs.getInt("id_salon"))
                .setPermission(rs.getInt("id_permission"))
                .setLogin(rs.getString("login"))
                .build();



        composite.addComponent(user);
    }
}
