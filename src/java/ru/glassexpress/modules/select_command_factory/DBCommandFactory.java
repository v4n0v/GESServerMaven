package ru.glassexpress.modules.select_command_factory;

import ru.glassexpress.modules.RequestParser;
import ru.glassexpress.modules.db_command.*;
import ru.glassexpress.modules.db_command.delete.DBDeleteGenerationCommand;
import ru.glassexpress.modules.db_command.delete.DBDeleteGlassCommand;
import ru.glassexpress.modules.db_command.delete.DBDeleteMarkCommand;
import ru.glassexpress.modules.db_command.delete.DBDeleteModelCommand;
import ru.glassexpress.modules.db_command.insert.*;
import ru.glassexpress.modules.db_command.select.DBSelectLastDayCommand;
import ru.glassexpress.modules.db_command.select.DBselectServiceCommand;
import ru.glassexpress.modules.db_command.select.car.*;
import ru.glassexpress.modules.db_command.select.glass.DBSelectGlassCommand;
import ru.glassexpress.modules.db_command.select.glass.DBSelectGlassFactoryCommand;
import ru.glassexpress.modules.db_command.select.glass.DBSelectGlassOption;
import ru.glassexpress.modules.db_command.select.glass.DBSelectGlassTypeCommand;
import ru.glassexpress.modules.db_command.select.user.*;
import ru.glassexpress.modules.db_command.update.*;
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


        if (action.equals("login")) {
            return new DBSelectUserByLoginCommand(req);

        } else if (action.equals("check")) {
            switch (target) {
                case "user":
                    return new DBCheckUserCommand(req);
                default:
                    break;
            }

        } else if (action.equals("list")) {
            switch (target) {
                case "user":
                    return new DBUserByKeyCommand(req);
                case "emp":
                    return new DBSelectEmployesCommand(req);
                case "emps":
                    return new DBSelectAllEmployesCommand(req);
                case "last_day":
                    return new DBSelectLastDayCommand(req);
                case "mark":
                    return new DBSelectMarkCommand();
                case "model":
                    return new DBSelectModelCommand(req);
                case "generation":
                    return new DBSelectGenerationCommand(req);
                case "table_goods":
                    return new DBSelectGlassCommand(req);
                case "glass_type":
                    return new DBSelectGlassTypeCommand(req);
                case "body_type":
                    return new DBSelectBodyTypeCommand(req);
                case "glass_option":
                    return new DBSelectGlassOption(req);
                case "glass_factory":
                    return new DBSelectGlassFactoryCommand(req);
                case "insert_class":
                    return new DBSelectInsertClassCommand(req);
                case "salon":
                    return new DBSelectSalonCommand(req);
                case "pos":
                    return new DBSelectPositionsCommand(req);
                case "permis":
                    return new DBSelectPermissionsCommand(req);
                case "service":
                    return new DBselectServiceCommand(req);
                default:
                    break;
            }


//            if (target.equals("mark")) {
//                return new DBSelectMarkCommand();
//            } else if (target.equals("model")) {
//                return new DBSelectModelCommand(req);
//            } else if (target.equals("generation")) {
//                return new DBSelectGenerationCommand(req);
//            } else if (target.equals("table_goods")) {
//                return new DBSelectGlassCommand(req);
//            } else if (target.equals("glass_type")) {
//                return new DBSelectGlassTypeCommand(req);
//            } else if (target.equals("body_type")) {
//                return new DBSelectBodyTypeCommand(req);
//            } else if (target.equals("glass_option")) {
//                return new DBSelectGlassOption(req);
//            } else if (target.equals("glass_factory")) {
//                return new DBSelectGlassFactoryCommand(req);
//            } else if (target.equals("insert_class")) {
//                return new DBSelectInsertClassCommand(req);
//            } else if (target.equals("insert_class_")) {
//                return new DBSelectInsertClassCommand1(req);
//            } else if (target.equals("user")) {
//                return new DBUserByKeyCommand(req);
//            } else if (target.equals("salon")) {
//                return new DBSelectSalonCommand(req);
//            } else if (target.equals("pos")) {
//                return new DBSelectPositionsCommand(req);
//            } else if (target.equals("permis")) {
//                return new DBSelectPermissionsCommand(req);
//            } else if (target.equals("service")) {
//                return new DBselectServiceCommand(req);
//            }

        } else if (action.equals("insert")) {


            if (target.equals("mark") && (user.getPermission() == 1 || user.getPermission() == 2)) {
                return new DBInsertMarkCommand(req);
            } else if (target.equals("model") && (user.getPermission() == 1 || user.getPermission() == 2)) {
                return new DBInsertModelCommand(req);
            } else if (target.equals("generation") && (user.getPermission() == 1 || user.getPermission() == 2)) {
                return new DBInsertGenerationCommand(req);
            } else if (target.equals("glass") && (user.getPermission() == 1 || user.getPermission() == 2)) {
                return new DBInsertGlassCommand(req);
            } else if (target.equals("user") && user.getPermission() == 1) {
                return new DBInsertUserCommand(req);
            } else if (target.equals("day") && (user.getPermission() == 1 || user.getPermission() == 2)) {
                return new DBInserNewDayCommand(req);
            }
        } else if (action.equals("delete") && user.getPermission() == 1)

        {
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
            } else if (target.equals("generation") && user.getPermission() == 1) {
                return new DBUpdateCar(req);

            } else if (target.equals("model") && user.getPermission() == 1) {
                return new DBUpdateModelCommand(req);
            } else if (target.equals("mark") && user.getPermission() == 1) {
                return new DBUpdateMarkCommand(req);
            } else if (target.equals("usrlogin") && user.getPermission() == 1) {
                return new DBUpdateUserLogin(req);
            } else if (target.equals("usrpass") && user.getPermission() == 1) {
                return new DBUpdateUserPass(req);
            }
        }
        return null;
    }
}
