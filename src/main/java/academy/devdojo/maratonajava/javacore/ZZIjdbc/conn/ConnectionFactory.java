package academy.devdojo.maratonajava.javacore.ZZIjdbc.conn;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    //java.sql = Connection, Statement, ResultSet, DriverManager
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/anime_store";
        String username = "root";
        String password = "root";
        return DriverManager.getConnection(url, username, password);
    }

    // é basicamente um ResultSet, vai manter uma conexão no banco de dados ou não
    // a partir dele consigo pegar os dados do banco de dados
    public static JdbcRowSet getJdbcRowSet() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/anime_store";
        String username = "root";
        String password = "root";
        JdbcRowSet jdbcRowSet = RowSetProvider.newFactory().createJdbcRowSet();
        jdbcRowSet.setUrl(url);
        jdbcRowSet.setUsername(username);
        jdbcRowSet.setPassword(password);
        return jdbcRowSet;
    }

    //    273 - JDBC pt 22 - Disconnected RowSet - CachedRowSet
    public static CachedRowSet getCachedRowSet() throws SQLException {
//        String url = "jdbc:mysql://localhost:3306/anime_store";
//        String username = "root";
//        String password = "root";
//        cachedRowSet.setUrl(url);
//        cachedRowSet.setUsername(username);
//        cachedRowSet.setPassword(password);
        return RowSetProvider.newFactory().createCachedRowSet();  // << só preciso deste
    }
}
