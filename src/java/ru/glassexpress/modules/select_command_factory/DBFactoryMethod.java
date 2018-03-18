package ru.glassexpress.modules.select_command_factory;

import ru.glassexpress.modules.db_command.DBCommand;

public interface DBFactoryMethod {

    DBCommand createCommand(String req);

}
