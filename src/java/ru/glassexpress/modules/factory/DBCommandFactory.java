package ru.glassexpress.modules.factory;

import ru.glassexpress.modules.RequestParser;
import ru.glassexpress.modules.db_command.*;
import ru.glassexpress.modules.db_command.delete.DBDeleteGenerationCommand;
import ru.glassexpress.modules.db_command.delete.DBDeleteMarkCommand;
import ru.glassexpress.modules.db_command.delete.DBDeleteModelCommand;
import ru.glassexpress.modules.db_command.insert.DBInsertGenerationCommand;
import ru.glassexpress.modules.db_command.insert.DBInsertMarkCommand;
import ru.glassexpress.modules.db_command.insert.DBInsertModelCommand;
import ru.glassexpress.modules.db_command.insert.DBIsertGlassCommand;
import ru.glassexpress.modules.db_command.select.car.DBSelectBodyTypeCommand;
import ru.glassexpress.modules.db_command.select.car.DBSelectGenerationCommand;
import ru.glassexpress.modules.db_command.select.car.DBSelectMarkCommand;
import ru.glassexpress.modules.db_command.select.car.DBSelectModelCommand;
import ru.glassexpress.modules.db_command.select.glass.DBSelectGlassCommand;
import ru.glassexpress.modules.db_command.select.glass.DBSelectGlassFactoryCommand;
import ru.glassexpress.modules.db_command.select.glass.DBSelectGlassOption;
import ru.glassexpress.modules.db_command.select.glass.DBSelectGlassTypeCommand;

public class DBCommandFactory implements DBFactoryMethod {

    static DBCommand command;


    public DBCommand createCommand(String req) {
        RequestParser parser = new RequestParser();
        parser.parseRequest(req);
        String target = parser.getStringValue("target");
        String action = parser.getStringValue("action");


        if (action.equals("list") && target.equals("mark")) {
            return new DBSelectMarkCommand();
        } else if (action.equals("list") && target.equals("model")) {
            return new DBSelectModelCommand(req);
        } else if (action.equals("list") && target.equals("generation")) {
            return new DBSelectGenerationCommand(req);
        } else if (action.equals("list") && target.equals("table_goods")) {
            return new DBSelectGlassCommand(req);
        } else if (action.equals("list") && target.equals("glass_type")) {
            return new DBSelectGlassTypeCommand(req);
        } else if (action.equals("list") && target.equals("body_type")) {
            return new DBSelectBodyTypeCommand(req);
        } else if (action.equals("list") && target.equals("glass_option")) {
            return new DBSelectGlassOption(req);
        } else if (action.equals("list") && target.equals("glass_factory")) {
            return new DBSelectGlassFactoryCommand(req);

        } else if (action.equals("insert") && target.equals("mark")) {
            return new DBInsertMarkCommand(req);
        } else if (action.equals("insert") && target.equals("model")) {
            return new DBInsertModelCommand(req);
        } else if (action.equals("insert") && target.equals("generation")) {
            return new DBInsertGenerationCommand(req);
        } else if (action.equals("insert") && target.equals("glass")) {
            return new DBIsertGlassCommand(req);



        } else if (action.equals("delete") && target.equals("generation")) {
            return new DBDeleteGenerationCommand(req);

    } else if (action.equals("delete") && target.equals("model")) {
        return new DBDeleteModelCommand(req);

    } else if (action.equals("delete") && target.equals("mark")) {
        return new DBDeleteMarkCommand(req);
    }
        return null;
    }
}
