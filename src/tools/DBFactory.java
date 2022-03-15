package tools;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Properties;

//封装数据库的连接返回conn
public class DBFactory {
    public static DBFactory INSTANCE = new DBFactory();
//    private  static DataSource ds;
    private  static  HikariDataSource datasource;
    public DBFactory() {
        super();
        initHikariCP();
    }
    public Connection getConnection() {
        Connection conn = null;
//        try {
//            Class.forName("org.postgresql.Driver");
//            String url = "jdbc:postgresql://localhost:5432/testjdbc";
//            conn = DriverManager.getConnection(url, "postgres", "9613852");
//        } catch (SQLException var3) {
//            var3.printStackTrace();
//        } catch (ClassNotFoundException var4) {
//            var4.printStackTrace();
//        }
        try {
            conn=datasource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.toString());
        }
        return conn;
    }

    public void closeConnection(Connection conn) {
        try {
//            ((Connection)Objects.requireNonNull(conn)).close();
            if (conn!=null){
                conn.close();
            }
        } catch (SQLException var3) {
            var3.printStackTrace();
        }
    }
    //tomcat连接池
//    private static void setupJdbcPool(){
//        PoolProperties p=new PoolProperties();
//        p.setDriverClassName( driver );
//        p.setUrl( url );
//        p.setUsername( uesr );
//        p.setPassword( password );
//        p.setMaxActive( 50 );//最大活动连接
//        p.setInitialSize( 10 );//初始10个连接
//        p.setMaxWait( 10000 );//最大等待时间ms
//        p.setMaxIdle( 20 );//最大空闲连接
//        p.setMaxIdle( 10 );//最小空闲连接
//        p.setDefaultAutoCommit( false );//自动提交
//        ds=new DataSource(  );//创建一个数据源
//        ds.setPoolProperties(p);
//    }

//    hikarCP连接池
    private void initHikariCP(){
        if(datasource==null){
            Properties props =new Properties();
            props.setProperty("dataSourceClassName", "org.postgresql.ds.PGSimpleDataSource" );
            props.setProperty("dataSource.user", "postgres" );
            props.setProperty("dataSource.password", "9613852" );
            props.setProperty("dataSource.databaseName", "testjdbc" );
            props.setProperty("dataSource.serverName", "localhost" );
            props.setProperty("dataSource.portNumber", "5432" );
            props.setProperty("maximumPoolSize", "20" );
            props.setProperty("minimumIdle", "5" );
            HikariConfig config=new HikariConfig( props );
            datasource=new HikariDataSource( config );
//            HikariConfig config = new HikariConfig();
//            config.setJdbcUrl("jdbc:postgresql://localhost:5432/testjdbc");
//            config.setUsername("postegres");
//            config.setPassword("9613852");
//            config.addDataSourceProperty("cachePrepStmts", "true");
//            config.addDataSourceProperty("prepStmtCacheSize", "250");
//            config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
//
//            HikariDataSource dataSource = new HikariDataSource(config);
        }
    }
}