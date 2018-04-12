package ru.glassexpress.modules.db_command;

import ru.glassexpress.modules.RequestParser;
import ru.glassexpress.objects_DB.Composite;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class DBCommand {
    protected Statement stmt;
    protected PreparedStatement ps;
    protected ResultSet rs;
    protected Connection con;

    protected  String sql;
    protected String request;

    protected Composite composite;

    protected List list;
    protected RequestParser parser;
    protected DBCommand(String sql, String request) {
        this.sql = sql;
        if (request!=null) {
            parser = new RequestParser();
            parser.parseRequest(request);
        }
        list=new ArrayList();
        composite=new Composite();
    }

        public abstract Composite execute();
//        public abstract List execute();

    protected void disconnect(){
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    protected abstract void queryExecute() throws SQLException;
}
