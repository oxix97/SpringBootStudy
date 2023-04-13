import org.springframework.jdbc.core.PreparedStatementSetter;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

    public void create(User user) throws SQLException {
        JdbcTemplate template = new JdbcTemplate();
        String sql = "INSERT INTO USERS VALUES (?, ?, ?, ?)";
        template.executeUpdate(sql, setter -> {
            setter.setString(1, user.getUserId());
            setter.setString(2, user.getPassword());
            setter.setString(3, user.getName());
            setter.setString(4, user.getEmail());
        });
        System.out.println(template);
    }

    public User findById(String userId) throws SQLException {
        JdbcTemplate template = new JdbcTemplate();
        String sql = "SELECT userId, password, name, email FROM USERS WHERE userId = ?";

        System.out.println("------------");
        RowMapper tMapper = new RowMapper() {
            @Override
            public Object map(ResultSet set) throws SQLException {
                return new User(
                        set.getString("userId"),
                        set.getString("password"),
                        set.getString("name"),
                        set.getString("email")
                );
            }
        };
        System.out.println("-----------");

        return (User) template.executeQuery(sql, setter -> {
            setter.setString(1, userId);
        }, new RowMapper() {
            @Override
            public Object map(ResultSet set) throws SQLException {
                return new User(
                        set.getString("userId"),
                        set.getString("password"),
                        set.getString("name"),
                        set.getString("email")
                );
            }
        });
    }
}
