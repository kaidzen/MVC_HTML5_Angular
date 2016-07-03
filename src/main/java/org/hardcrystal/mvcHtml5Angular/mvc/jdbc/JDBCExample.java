package org.hardcrystal.mvcHtml5Angular.mvc.jdbc;

import org.hardcrystal.mvcHtml5Angular.mvc.bean.DBLog;
import org.hardcrystal.mvcHtml5Angular.mvc.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class JDBCExample {

    @Autowired
    DataSource dataSource;

    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void init(){
        System.out.println("JDBCExample postConstruct is called. datasource = " + dataSource);
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    //JDBC Template Insert
    public boolean insertLog(DBLog log){
        System.out.println("JDBCExample: log(final String log) is called");
        final String INSERT_SQL = "INSERT INTO LOG(LOGSTRING) VALUES(?)";

        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SQL);
                preparedStatement.setString(1, log.getLOGSTRING());
                return preparedStatement;
            }
        });
        return true;
    }

    //JDBC Template Select
    public List<DBLog> queryAllLogs(){
        System.out.println("JDBCExample: queryAllLogs() is called");
        final String QUERY_SQL = "SELECT * FROM LOG ORDER BY IDLOG";

        List<DBLog> dbLogList = this.jdbcTemplate.query(QUERY_SQL, new RowMapper<DBLog>(){
            @Override
            public DBLog mapRow(ResultSet resultSet, int rowNum) throws SQLException {
                System.out.println("Getting log: " +rowNum+ " content: " +resultSet.getString("LOGSTRING"));
                DBLog dbLog = new DBLog();
                dbLog.setIDLOG(resultSet.getInt("IDLOG"));
                dbLog.setLOGSTRING(resultSet.getString("LOGSTRING"));
                return dbLog;
            }
        });
        return dbLogList;
    }

    //JDBC Template Select
    public List<User> queryAllUsers(){
        System.out.println("JDBCExample: queryAllUsers is called");
        final String QUERY_SQL = "SELECT * FROM USER ORDER BY IDUSER";

        List<User> userList = this.jdbcTemplate.query(QUERY_SQL, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User user = new User();
                user.setIdUser(resultSet.getInt("IDUSER"));
                user.setUsername(resultSet.getString("USERNAME"));
                user.setPassword(resultSet.getString("PASSWORD"));
                user.setEnabled(resultSet.getBoolean("ENABLED"));
                return user;
            }
        });
        return userList;
    }

    //JDBC Template Delete
    public boolean deleteUSER(int iduser){
        System.out.println("JDBCExample: deleteUSER called");
        final String DELETE_SQL = "DELETE FROM USER WHERE IDUSER LIKE ?";
        int result = jdbcTemplate.update(DELETE_SQL, new Object[]{iduser});
        System.out.println("result" + result);
        if (result > 0){
            System.out.println("User is deleted" + iduser);
            return true;
        } else {
            return false;
        }
    }
}

