package util;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBUtil {
    private static DataSource dataSource;

    public static DataSource getDataSource() {
        if (dataSource == null) {
            try {
                Context ctx = new InitialContext();
                dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/ContactDB");
            } catch (Exception e) {
                throw new RuntimeException("Error initializing DataSource", e);
            }
        }
        return dataSource;
    }
}
