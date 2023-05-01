package core.base;

import org.springframework.lang.NonNull;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.images.builder.ImageFromDockerfile;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.nio.file.Path;

@SuppressWarnings({"resource", "unused"})
@Testcontainers(disabledWithoutDocker = true)
public abstract class BaseIntegrationTest {

    public static final String POSTGRES_INITDB_ARGS = "POSTGRES_INITDB_ARGS";

    private static final ImageFromDockerfile postgresImage = new ImageFromDockerfile("postgres")
            .withDockerfile(Path.of(".docker/postgres-ua/Dockerfile"));
    private static final PostgreSQLContainer<?> postgreSqlContainer = new PostgreSQLContainer<>("postgres:14")
//            .withEnv(POSTGRES_INITDB_ARGS, "--lc-collate=uk_UA.UTF-8 --lc-ctype=uk_UA.UTF-8")
            .withReuse(Boolean.TRUE);

    static {
        postgreSqlContainer.start();
    }

    @DynamicPropertySource
    public static void setup(@NonNull final DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", postgreSqlContainer::getJdbcUrl);
        registry.add("spring.datasource.password", postgreSqlContainer::getPassword);
        registry.add("spring.datasource.username", postgreSqlContainer::getUsername);
    }

}
