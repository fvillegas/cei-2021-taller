package uy.edu.cei.mercadocei.configuration;

import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class FlywayConfiguration {
    @Bean
    public FlywayMigrationStrategy clean() {
        return flyway -> {
            flyway.clean(); // borra todo
            flyway.migrate(); // ejecuta las migraciones
        };
    }
}
