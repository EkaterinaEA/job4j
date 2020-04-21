package ru.job4j;

import org.junit.Test;
import ru.job4j.io.Config;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ConfigTest {

    @Test
    public void whenPairWithoutComment() {
        String path = "./data/application.properties";
        Config config = new Config(path);
        config.load();
        assertThat(
                config.value("hibernate.dialect"),
                is("org.hibernate.dialect.PostgreSQLDialect")
        );
        assertThat(
                config.value("hibernate.connection.username"),
                is("postgres")
        );
    }
}
