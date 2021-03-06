package ru.glassexpress.modules;

public class Res {
    public static final String GET_MARKS = "SELECT * FROM auto_mark ORDER BY mark_title";
    public static final String GET_MODELS = "SELECT * FROM auto_model WHERE id_auto_mark = ? " +
            " ORDER BY title_model";

    public static final String GET_GENERATION = "SELECT * FROM car WHERE id_model = ?" +
            " ORDER BY year_from";
    public static final String GET_INSERT_CLASS = "SELECT * FROM auto_insert_class";
    public static final String GET_INSERT_CLASS1 = "select id_auto_insert_class AS id, auto_insert_class_1.id_glass_type, price, glass_type_title from auto_insert_class_1 " +
            "LEFT JOIN (glass_type) ON auto_insert_class_1.id_glass_type = glass_type.id_glass_type " +
            "ORDER by id_auto_insert_class";


    public static final String INSERT_MODEL = "INSERT INTO `glass_express_db`.`auto_model` (`title_model`, `id_auto_mark`) " +
            "VALUES (?, (SELECT id_auto_mark  FROM auto_mark WHERE mark_title=?))";

    public static final String INSERT_MARK = "INSERT INTO auto_mark  (`mark_title`) VALUES (?) ";

    public static final String INSERT_GENERATION = "INSERT INTO `glass_express_db`.`car` " +
            "(`year_from`, `year_to`, `id_model`) VALUES (?, ?, ?);";

    public static final String INSERT_GLASS = "INSERT INTO glass " +
            "(id_car,   id_glass_type,    id_glass_option, glass_description, price_in, " +
            "price_out, alert_remainder, id_glass_factory, id_insert_method,  insert_price, " +
            "id_body_type, opt_list_json) " +
            "VALUES (?, ?, ?, ?, ?," +
            " ?, ?, ?, ?, ?, " +
            "?, ?)";


    public static final String INSERT_GLASS_OPT = "INSERT INTO glass_option_list (id_glass, id_glass_option) VALUES (?, ?)";

    public static final String INSERT_GLASS_PRICE = "";
    //    insert_price,
    public static final String INSERT_USER = "INSERT INTO employees " +
            " (first_name,   last_name,    id_pos, id_salon, key_user, id_permission, login, mail) " +
            "  VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

    public static final String INSERT_USER_LOGIN = "INSERT INTO logins " +
            " (login, passHash, userKey) " +
            "  VALUES (?, ?, ?)";

    public static final String SELECT_GLASS =
            "SELECT glass.id_glass, CONCAT(auto_mark.mark_title, \" \",auto_model.title_model, \" \", year_from, \"-\", year_to) AS auto, " +
                    "glass_type.glass_type_title, glass_options.glass_option_title,  glass_description, price_in, price_out, alert_remainder, " +
                    "glass_factory.title_glass_factory, glass_insert_method.title_insert_method, " +
                    "glass.id_car, glass.id_glass_type, glass.id_glass_option, glass.id_glass_factory, glass.id_insert_method, insert_price, auto_body_type.type_title,  auto_body_type.id_body_type, opt_list_json " +

                    "FROM glass " +
                    "LEFT JOIN (car) ON glass.id_car = car.id_car " +
                    "LEFT JOIN (auto_model) ON car.id_model = auto_model.id_auto_model " +
                    "LEFT JOIN (auto_mark) ON auto_model.id_auto_mark = auto_mark.id_auto_mark " +
                    "LEFT JOIN (glass_options) ON glass.id_glass_option= glass_options.id_glass_option " +
                    "LEFT JOIN (glass_type) ON glass.id_glass_type = glass_type.id_glass_type " +
                    "LEFT JOIN (glass_factory) ON glass.id_glass_factory = glass_factory.id_glass_factory " +
                    "LEFT JOIN (glass_insert_method) ON glass.id_insert_method = glass_insert_method.id_insert_method " +
                    "LEFT JOIN (auto_body_type) ON glass.id_body_type = auto_body_type.id_body_type " +
                    "WHERE glass.id_car=? " +
                    "ORDER BY glass.id_glass_type";

    public static final String SELECT_GLASS_TYPE = "SELECT * FROM glass_type ORDER BY id_glass_type";
    public static final String SELECT_BODY_TYPE = "SELECT * FROM auto_body_type ORDER BY id_body_type";
    public static final String SELECT_GLASS_OPT = "SELECT * FROM glass_options ORDER BY id_glass_option";
    public static final String SELECT_GLASS_FACTORY = "SELECT * FROM glass_factory ORDER BY id_glass_factory";
    public static final String DELETE_GENERATION = "DELETE FROM car WHERE id_car = ?";
    public static final String DELETE_MODEL = "DELETE FROM auto_model WHERE id_auto_model = ?";
    public static final String DELETE_MARK = "DELETE FROM auto_mark WHERE id_auto_mark = ?";
    public static final String DELETE_USER = "UPDATE employees SET id_permission=4, id_pos=5 WHERE id_emp=?";
//    public static final String DELETE_USER = "DELETE FROM employees WHERE id_emp = ?";
//    public static final String DELETE_LOGIN = "DELETE FROM logins WHERE login =(SELECT login from employees WHERE id_emp=?)";

    public static final String UPD_CAR_INSERT_CLASS = "UPDATE `glass_express_db`.`car` SET id_auto_insert_class=? WHERE id_car=?";
    public static final String DELETE_GLASS = "DELETE FROM glass WHERE id_glass = ?";
    public static final String UPD_GLASS = "UPDATE glass SET id_glass_type=?, id_glass_option=?, glass_description=?, price_in=?, " +
            "price_out=?, alert_remainder=?, id_glass_factory=?, id_insert_method=?,  insert_price=?, " +
            "id_body_type=?, opt_list_json=? WHERE id_glass=?";

    public static final String UPD_GENERATION = "UPDATE car SET year_from=?, year_to=? WHERE id_car=?";
    public static final String UPD_MODEL = "UPDATE auto_model SET title_model=? WHERE id_auto_model=?";
    public static final String UPD_MARK = "UPDATE auto_mark SET mark_title=? WHERE id_auto_mark=?";
    public static final String UPD_LOGIN_EMP = "UPDATE employees SET login=? WHERE id_emp=?";
    public static final String UPD_LOGIN_USER = "UPDATE logins SET login=? WHERE login=(SELECT login from employees WHERE id_emp=?)";
    public static final String UPD_PASS = "UPDATE logins SET passHash=? WHERE login=?";
    public static final String SELECT_USER_BY_KEY = "SELECT * FROM employees WHERE key_user = ?";
    //    public static final String SELECT_USER_BY_LOGIN = "SELECT * FROM employees WHERE login = ? AND passHash = ?";
    public static final String CHECK_USER_BY_LOGIN = "SELECT * FROM logins WHERE login = ?";
    public static final String SELECT_USER_BY_LOGIN = "SELECT userKey FROM logins WHERE login = ? AND passHash = ?";
    public static final String SELECT_SALONS = "SELECT * FROM salon ORDER BY id_salon ";
    public static final String SELECT_PERMISSIONS = "SELECT * FROM emp_permissions ORDER BY id_permissions";
    public static final String SELECT_POSITIONS = "SELECT * FROM emp_positions ORDER BY id_position";
    public static final String SELECT_SERVICES = "SELECT * FROM service ORDER BY id_service";

    public static final String SELECT_EMPLOYEES = "SELECT * FROM employees WHERE id_permission=3 AND id_salon=?";

    public static final String GET_LAST_DAY = "SELECT * FROM day WHERE day_date=(SELECT MAX(day_date) FROM day WHERE id_salon  = ?)  AND id_salon  = ?  LIMIT 1; ";
//    public static final String GET_LAST_DAY = "SELECT * FROM day WHERE id_salon  = ? LIMIT 1";

    public static final String INSERT_NEW_DAY  = "INSERT INTO day (day_date, emp_list_json, id_admin,  id_salon) VALUES (?, ?, ?, ?)";
    public static final String SELECT_USERS = "SELECT * from employees ORDER BY id_salon";



    /// названия колонок таблицы
    // UPDATE `glass_express_db`.`glass` SET `price_out`='3000', `insert_price`='2500' WHERE `id_glass`='2';

}
