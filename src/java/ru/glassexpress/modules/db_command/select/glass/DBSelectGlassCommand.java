package ru.glassexpress.modules.db_command.select.glass;

import ru.glassexpress.modules.Res;
import ru.glassexpress.modules.db_command.DBSelectCommand;
import ru.glassexpress.objects_DB.GlassObject;
import ru.glassexpress.objects_DB.TableGlassRow;
import ru.glassexpress.objects_DB.builders.GlassBuilder;
import ru.glassexpress.objects_DB.builders.TableGlassBuilder;

import java.sql.SQLException;

public class DBSelectGlassCommand extends DBSelectCommand {
    public DBSelectGlassCommand(String request) {
        super(Res.SELECT_GLASS, request);
    }

    @Override
    protected void prepareStatement() throws SQLException {


    }

    @Override
    protected void queryExecute() throws SQLException {
        System.out.println(rs.getString("auto"));
        GlassObject table = new GlassBuilder()
                .setId(rs.getInt("id_glass"))
                .setCarId(rs.getInt("id_car"))
                .setInsertCarTitle(rs.getString("auto"))
                .setGlassTypeId(rs.getInt("id_glass_type"))
                .setGlassOptionId(rs.getInt("id_glass_option"))
                .setDescription(rs.getString("glass_description"))
                .setCountRemainder(rs.getInt("alert_remainder"))
                .setPriceIn(rs.getFloat("price_in"))
                .setPrice(rs.getFloat("price_out"))
                .setGlassFactoryId(rs.getInt("id_glass_factory"))
                .setInsertPrice(rs.getFloat("insert_price"))
                .setInsertMethodId(rs.getInt("id_insert_method"))
                .setInsertCarTitle(rs.getString("auto"))
                .setInsertGlassFactoryTitle(rs.getString("title_glass_factory"))
                .setInsertGlassOptTitle(rs.getString("glass_option_title"))
                .setInsertGlassTypeTitle(rs.getString("glass_type_title"))
                .setInsertMethodTitle(rs.getString("title_insert_method"))
                .build();


        composite.addComponent(table);
    }
}
