package ru.glassexpress.modules.db_command;

import ru.glassexpress.modules.DBConnect;
import ru.glassexpress.modules.Log2File;
import ru.glassexpress.objects_DB.Composite;
import ru.glassexpress.objects_DB.ErrorObject;
import ru.glassexpress.objects_DB.OkObject;

import java.sql.*;
import java.util.logging.Logger;

public abstract class DBEditCommand extends DBCommand{

    public DBEditCommand(String sql, String request) {
        super(sql, request);
    }
    String TAG = "EDIT";

    public Composite execute( ) {

        try {
            con = DBConnect.getConnection();
            if (con!=null) {
                con.setAutoCommit(false);
                  Log2File.writeLog(request);
                ps = con.prepareStatement(sql);
                queryExecute();

                ps.executeUpdate();
                con.commit();
                disconnect();
            }
        } catch (SQLException e) {

            sendErrorMessage();
            e.printStackTrace();

            return composite;
        }
        composite.addComponent(new OkObject());
        return composite;
    }
    protected abstract void sendErrorMessage();


}
