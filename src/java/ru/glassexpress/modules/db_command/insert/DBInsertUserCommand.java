package ru.glassexpress.modules.db_command.insert;

import ru.glassexpress.modules.Res;
import ru.glassexpress.modules.db_command.DBEditCommand;
import ru.glassexpress.objects_DB.ErrorObject;

import java.sql.SQLException;

public class DBInsertUserCommand extends DBEditCommand {
    public DBInsertUserCommand(String request) {
        super(Res.INSERT_USER, request);
    }

    @Override
    protected void queryExecute() throws SQLException {
        ps.setString(1, parser.getStringValue("first_name"));
        ps.setString(2, parser.getStringValue("last_name"));
        ps.setInt(3, parser.getIntValue("id_pos"));
        ps.setInt(4, parser.getIntValue("id_salon"));
        ps.setInt(5, parser.getStringValue("key_user").hashCode());
        ps.setInt(6, parser.getIntValue("id_permission"));
        ps.setString(7, parser.getStringValue("login"));
        ps.setString(8, parser.getStringValue("mail"));
      //  ps.setString(8, parser.getStringValue("user_key"));
        ps.executeUpdate();
        ps = con.prepareStatement(Res.INSERT_USER_LOGIN);
        ps.setString(1, parser.getStringValue("login"));
        ps.setInt(2, parser.getIntValue("passHash"));
        ps.setString(3, parser.getStringValue("key_user"));
    }

    @Override
    protected void sendErrorMessage() {
        composite.addComponent(new ErrorObject("Ошибка добавления пользователся "+parser.getStringValue("login")));
    }

//(first_name,   last_name,    id_pos, id_salon, key_user, id_permission)
}
