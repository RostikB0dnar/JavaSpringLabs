package Database;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;
public class DataSourceManager {
    private static final BasicDataSource  dataSource = new BasicDataSource();

    static {
        dataSource.setUrl("jdbc:mysql://localhost:3306/mydb");
        dataSource.setUsername("Rostyslav");
        dataSource.setPassword("5720693");
        dataSource.setMinIdle(5);
        dataSource.setMaxIdle(10);
        dataSource.setMaxOpenPreparedStatements(100);
    }

    public static DataSource getDataSource() {
        return dataSource;
    }
}
