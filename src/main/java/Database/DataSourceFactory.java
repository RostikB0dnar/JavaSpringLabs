package Database;

import javax.sql.DataSource;
import java.sql.Connection;

public class DataSourceFactory {
    private static final DataSource dataSource = DataSourceManager.getDataSource();

    public static Connection getConnection() throws Exception {
        return dataSource.getConnection();
    }
}
