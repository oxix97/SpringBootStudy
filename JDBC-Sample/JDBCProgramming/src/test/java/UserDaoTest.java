import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import java.sql.SQLException;

public class UserDaoTest {

    @BeforeEach
    void setUp() {
        ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
        populator.addScript(new ClassPathResource(("db_schema.sql")));
        DatabasePopulatorUtils.execute(populator,ConnectionManager.getdataSource());
    }

    @Test
    void createdTest() throws SQLException {
        UserDao dao = new UserDao();
        dao.create(new User("hazard","pw","name","email"));

        User user = dao.findByUserId("hazard");
        Assertions.assertEquals(user,new User("hazard","pw","name","email"));

    }
}
