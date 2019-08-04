package com.example.db.migrations;

import javax.sql.DataSource;
import com.example.infrastructure.Slf4jFlywayLogCreator;
import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.logging.LogFactory;

public class FlywayDBMigrations implements FlywayDBMigrationService {

    private final DataSource dataSource;

    public FlywayDBMigrations(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    
    @Override
    public void migrate() {
        
        LogFactory.setLogCreator(new Slf4jFlywayLogCreator());
        ClassLoader classLoader = this.getClass().getClassLoader();

         Flyway flyway = Flyway.configure(classLoader)
                    .dataSource(this.dataSource)
                    .validateOnMigrate(true)
                    .baselineVersion("0.0.1")
                    .outOfOrder(true)
                    .skipDefaultResolvers(false)
                    .baselineOnMigrate(true)
                    .load();
            
            flyway.migrate();
    }    
}
