package ru.glassexpress.modules.select_command_factory;

import ru.glassexpress.modules.RequestParser;
import ru.glassexpress.modules.db_command.*;
import ru.glassexpress.modules.db_command.delete.DBDeleteGenerationCommand;
import ru.glassexpress.modules.db_command.delete.DBDeleteGlassCommand;
import ru.glassexpress.modules.db_command.delete.DBDeleteMarkCommand;
import ru.glassexpress.modules.db_command.delete.DBDeleteModelCommand;
import ru.glassexpress.modules.db_command.insert.*;
import ru.glassexpress.modules.db_command.select.car.*;
import ru.glassexpress.modules.db_command.select.glass.DBSelectGlassCommand;
import ru.glassexpress.modules.db_command.select.glass.DBSelectGlassFactoryCommand;
import ru.glassexpress.modules.db_command.select.glass.DBSelectGlassOption;
import ru.glassexpress.modules.db_command.select.glass.DBSelectGlassTypeCommand;
import ru.glassexpress.modules.db_command.select.user.DBSelectPermissionsCommand;
import ru.glassexpress.modules.db_command.select.user.DBSelectPositionsCommand;
import ru.glassexpress.modules.db_command.select.user.DBSelectSalonCommand;
import ru.glassexpress.modules.db_command.select.user.DBUserByKeyCommand;
import ru.glassexpress.modules.db_command.update.DBUpdateGlassCommand;
import ru.glassexpress.modules.db_command.update.DBUpdateInsertClass;
import ru.glassexpress.objects_DB.UserObject;

public class DBCommandFactory implements DBFactoryMethod {

    static DBCommand command;


//    User permission:
//    1 = root
//    2 = admin
//    3 = RO

    public DBCommand createCommand(String req, UserObject user) {
        RequestParser parser = new RequestParser();
        parser.parseRequest(req);
        String target = parser.getStringValue("target");
        String action = parser.getStringValue("action");
        if (action.equals("list")) {
//
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
            } else if (action.equals("list") && target.equals("insert_class")) {
                return new DBSelectInsertClassCommand(req);
            } else if (action.equals("list") && target.equals("insert_class_")) {
                return new DBSelectInsertClassCommand1(req);
            } else if (action.equals("list") && target.equals("user")) {
                return new DBUserByKeyCommand(req);
            } else if (action.equals("list") && target.equals("salon")) {
                return new DBSelectSalonCommand(req);
            } else if (action.equals("list") && target.equals("pos")) {
                return new DBSelectPositionsCommand(req);
            } else if (action.equals("list") && target.equals("permis")) {
                return new DBSelectPermissionsCommand(req);
            }
        } else if (action.equals("insert")) {


            if (action.equals("insert") && target.equals("mark") && (user.getPermission() == 1 || user.getPermission() == 2)) {
                return new DBInsertMarkCommand(req);
            } else if (action.equals("insert") && target.equals("model") && (user.getPermission() == 1 || user.getPermission() == 2)) {
                return new DBInsertModelCommand(req);
            } else if (action.equals("insert") && target.equals("generation") && (user.getPermission() == 1 || user.getPermission() == 2)) {
                return new DBInsertGenerationCommand(req);
            } else if (action.equals("insert") && target.equals("glass") && (user.getPermission() == 1 || user.getPermission() == 2)) {
                return new DBInsertGlassCommand(req);
            } else if (action.equals("insert") && target.equals("user") && user.getPermission() == 1) {
                return new DBInsertUserCommand(req);
            }
        } else if (action.equals("delete") && user.getPermission() == 1) {
            if (target.equals("generation")) {
                return new DBDeleteGenerationCommand(req);
            } else if (target.equals("model")) {
                return new DBDeleteModelCommand(req);
            } else if (target.equals("mark")) {
                return new DBDeleteMarkCommand(req);
            } else if (target.equals("glass")) {
                return new DBDeleteGlassCommand(req);
            }
        } else if (action.equals("upd")) {
            if (target.equals("insert_class")) {
                return new DBUpdateInsertClass(req);
            } else if (target.equals("glass") && user.getPermission() == 1) {
                return new DBUpdateGlassCommand(req);
            }
        }
        return null;
    }
}
