package ru.glassexpress.modules;

public class Res {
    public static final String GET_MARKS = "SELECT * FROM auto_mark ORDER BY mark_title";
    public static final String GET_MODELS = "SELECT * FROM auto_model WHERE id_auto_mark = ? " +
            " ORDER BY title_model";

    public static final String GET_GENERATION = "SELECT * FROM car WHERE id_model = ?" +
            " ORDER BY year_from";
    public static final String GET_INSERT_CLASS = "SELECT * FROM auto_insert_class";
    public static final String GET_INSERT_CLASS1 = "select id_auto_insert_class AS id, auto_insert_class_1.id_glass_type, price, glass_type_title from auto_insert_class_1  from auto_insert_class_1 " +
            "LEFT JOIN (glass_type) ON auto_insert_class_1.id_glass_type = glass_type.id_glass_type " +
            "ORDER by id_auto_insert_class";


    public static final String INSERT_MODEL = "INSERT INTO `glass_express_db`.`auto_model` (`title_model`, `id_auto_mark`) " +
            "VALUES (?, (SELECT id_auto_mark  FROM auto_mark WHERE mark_title=?))";

    public static final String INSERT_MARK = "INSERT INTO auto_mark  (`mark_title`) VALUES (?) ";

    public static final String INSERT_GENERATION = "INSERT INTO `glass_express_db`.`car` " +
            "(`year_from`, `year_to`, `id_model`) VALUES (?, ?, " +
            "(SELECT id_auto_model FROM auto_model WHERE title_model=?));";

    public static final String INSERT_GLASS = "INSERT INTO glass " +
            "(id_car, id_glass_type, id_glass_option, glass_description, price_in, " +
            "price_out, alert_remainder, id_glass_factory, id_insert_method, insert_price, id_body_type) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    public static final String INSERT_GLASS_PRICE = "";


    public static final String SELECT_GLASS =
            "SELECT glass.id_glass, CONCAT(auto_mark.mark_title, \" \",auto_model.title_model, \" \", year_from, \"-\", year_to) AS auto, " +
                    "glass_type.glass_type_title, glass_options.glass_option_title,  glass_description, price_in, price_out, alert_remainder, " +
                    "glass_factory.title_glass_factory, glass_insert_method.title_insert_method, " +
                    "glass.id_car, glass.id_glass_type, glass.id_glass_option, glass.id_glass_factory, glass.id_insert_method, insert_price, auto_body_type.type_title,  auto_body_type.id_body_type " +

                    "FROM glass " +
                    "LEFT JOIN (car) ON glass.id_car = car.id_car " +
                    "LEFT JOIN (auto_model) ON car.id_model = auto_model.id_auto_model " +
                    "LEFT JOIN (auto_mark) ON auto_model.id_auto_mark = auto_mark.id_auto_mark " +
                    "LEFT JOIN (glass_options) ON glass.id_glass_option= glass_options.id_glass_option " +
                    "LEFT JOIN (glass_type) ON glass.id_glass_type = glass_type.id_glass_type " +
                    "LEFT JOIN (glass_factory) ON glass.id_glass_factory = glass_factory.id_glass_factory " +
                    "LEFT JOIN (glass_insert_method) ON glass.id_insert_method = glass_insert_method.id_insert_method " +
                    "LEFT JOIN (auto_body_type) ON glass.id_body_type = auto_body_type.id_body_type " +
                    "WHERE glass.id_car=?" +
                    "ORDER BY glass.id_glass_type";

    public static final String SELECT_GLASS_TYPE = "SELECT * FROM glass_type ORDER BY id_glass_type";
    public static final String SELECT_BODY_TYPE = "SELECT * FROM auto_body_type ORDER BY id_body_type";
    public static final String SELECT_GLASS_OPT = "SELECT * FROM glass_options ORDER BY id_glass_option";
    public static final String SELECT_GLASS_FACTORY = "SELECT * FROM glass_factory ORDER BY id_glass_factory";
    public static final String DELETE_GENERATION = "DELETE FROM car WHERE id_car = ?";
    public static final String DELETE_MODEL = "DELETE FROM auto_model WHERE id_auto_model = ?";
    public static final String DELETE_MARK = "DELETE FROM auto_mark WHERE id_auto_mark = ?";
    ;
    //todo допилить запрос
    public static final String UPD_CAR_INSERT_CLASS = "UPDATE `glass_express_db`.`car` SET `id_auto_insert_class`=? WHERE `id_car`=?";


    /// названия колонок таблицы

}
