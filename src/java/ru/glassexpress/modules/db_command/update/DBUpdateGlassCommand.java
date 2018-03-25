package ru.glassexpress.modules.db_command.update;

import ru.glassexpress.modules.Res;
import ru.glassexpress.modules.db_command.DBEditCommand;
import ru.glassexpress.objects_DB.ErrorObject;

import java.sql.SQLException;

public class DBUpdateGlassCommand extends DBEditCommand {

        public DBUpdateGlassCommand(String request) {
            super(Res.UPD_GLASS, request);
        }

        protected void queryExecute() throws SQLException {
            System.out.println(parser.getIntValue("id_glass"));
           // ps.setInt(1, parser.getIntValue("id_car"));
            ps.setInt(1, parser.getIntValue("id_glass_type"));

            ps.setInt(2, parser.getIntValue("id_glass_opt"));
            ps.setString(3, parser.getStringValue("glass_description"));
            ps.setFloat(4, parser.getFloatValue("price_in"));
            ps.setFloat(5, parser.getFloatValue("price_out"));
            ps.setInt(6, parser.getIntValue("alert_remainder"));
            ps.setInt(7, parser.getIntValue("glass_factory"));
            ps.setInt(8, parser.getIntValue("insert_method"));
            ps.setFloat(9, parser.getFloatValue("insert_price"));
            ps.setInt(10, parser.getIntValue("body_type"));
            String opt = parser.getStringValue("optListString");
            opt = opt.replace("\"", "\"\"");
            ps.setString(11,parser.getStringValue("optListString"));
            ps.setInt(12,parser.getIntValue("id_glass"));
            System.out.println(parser.getIntValue("id_glass"));
        }

    @Override
    protected void sendErrorMessage() {

    }

}



//// ps.setInt(1, parser.getIntValue("id_car"));
//            ps.setInt(2, parser.getIntValue("id_glass_type"));
//
//                    ps.setInt(3, parser.getIntValue("id_glass_opt"));
//                    ps.setString(4, parser.getStringValue("glass_description"));
//                    ps.setFloat(5, parser.getFloatValue("price_in"));
//                    ps.setFloat(6, parser.getFloatValue("price_out"));
//                    ps.setInt(7, parser.getIntValue("alert_remainder"));
//                    ps.setInt(8, parser.getIntValue("glass_factory"));
//                    ps.setInt(9, parser.getIntValue("insert_method"));
//                    ps.setFloat(10, parser.getFloatValue("insert_price"));
//                    ps.setInt(11, parser.getIntValue("body_type"));
//                    ps.setString(12,parser.getStringValue("optListString"));
//                    ps.setInt(13,parser.getIntValue("id_glass"));