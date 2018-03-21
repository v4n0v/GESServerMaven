package ru.glassexpress.modules.select_command_factory;

import ru.glassexpress.modules.db_command.DBCommand;
import ru.glassexpress.objects_DB.UserObject;

public interface DBFactoryMethod {

    DBCommand createCommand(String req, UserObject user);

}
