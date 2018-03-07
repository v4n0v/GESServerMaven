package ru.glassexpress.modules.factory;

import ru.glassexpress.modules.db_command.DBCommand;

public interface DBFactoryMethod {

    DBCommand createCommand(String req);

}
