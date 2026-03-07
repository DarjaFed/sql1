package db;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbUtils {

    private DbUtils() {}

    public static String getVerificationCode(String login) throws Exception {

        var runner = new QueryRunner();

        try (
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/app",
                        "user",
                        "pass"
                )
        ) {

            String codeSQL =
                    "SELECT code FROM auth_codes " +
                            "JOIN users ON auth_codes.user_id = users.id " +
                            "WHERE login=? " +
                            "ORDER BY created DESC LIMIT 1";

            return runner.query(conn,
                    codeSQL,
                    new ScalarHandler<>(),
                    login
            );
        }
    }
}