package data;

import java.sql.*;

public class DbUtils {

    private static final String url = "jdbc:mysql://localhost:3306/app";
    private static final String user = "app";
    private static final String password = "pass";

    public static String getVerificationCode(String login) throws SQLException {

        String codeSQL =
                "SELECT code FROM auth_codes " +
                        "WHERE user_id = (SELECT id FROM users WHERE login = ?) " +
                        "ORDER BY created DESC LIMIT 1";

        try (
                Connection conn = DriverManager.getConnection(url, user, password);
                PreparedStatement stmt = conn.prepareStatement(codeSQL)
        ) {
            stmt.setString(1, login);

            try (ResultSet rs = stmt.executeQuery()) {
                rs.next();
                return rs.getString("code");
            }
        }
    }

    public static void cleanDatabase() throws SQLException {

        try (
                Connection conn = DriverManager.getConnection(url, user, password);
                Statement stmt = conn.createStatement()
        ) {

            stmt.executeUpdate("DELETE FROM auth_codes;");
            stmt.executeUpdate("DELETE FROM cards;");
            stmt.executeUpdate("DELETE FROM users;");
        }
    }
}