package ru.glassexpress.modules.db_command;

import ru.glassexpress.modules.DBConnect;
import ru.glassexpress.objects_DB.Composite;

import java.sql.SQLException;

public abstract class DBSelectCommand extends DBCommand{
    public DBSelectCommand(String sql, String request) {
        super(sql, request);
    }




    public Composite execute(){


        try{ con= DBConnect.getConnection();
            if (con!=null) {
                System.out.println("соединение с базой установлено из "+this.getClass().getSimpleName());
                ps = con.prepareStatement(sql);
                prepareStatement();
                System.out.println("выборка подготовлена");
                rs = ps.executeQuery();
                System.out.println("данные из бызы получены");
                while (rs.next()) {
                    queryExecute();
                    System.out.println("элемент считан");
                }
                disconnect();
                System.out.println("соединение с базой разорвано "+this.getClass().getSimpleName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        return composite;
    }

    protected abstract void prepareStatement() throws SQLException;

}
