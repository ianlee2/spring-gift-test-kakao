package gift.cucumber;

import io.cucumber.java.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class DatabaseCleanUp {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Before(order = 0)
    public void cleanUp() {
        jdbcTemplate.execute("SET REFERENTIAL_INTEGRITY FALSE");
        jdbcTemplate.execute("TRUNCATE TABLE wish");
        jdbcTemplate.execute("TRUNCATE TABLE option");
        jdbcTemplate.execute("TRUNCATE TABLE product");
        jdbcTemplate.execute("TRUNCATE TABLE member");
        jdbcTemplate.execute("TRUNCATE TABLE category");
        jdbcTemplate.execute("SET REFERENTIAL_INTEGRITY TRUE");
        jdbcTemplate.execute("ALTER TABLE wish ALTER COLUMN id RESTART WITH 1");
        jdbcTemplate.execute("ALTER TABLE option ALTER COLUMN id RESTART WITH 1");
        jdbcTemplate.execute("ALTER TABLE product ALTER COLUMN id RESTART WITH 1");
        jdbcTemplate.execute("ALTER TABLE member ALTER COLUMN id RESTART WITH 1");
        jdbcTemplate.execute("ALTER TABLE category ALTER COLUMN id RESTART WITH 1");
    }
}
