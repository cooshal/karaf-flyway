package com.example.db.migrations;

import javax.sql.DataSource;
import org.flywaydb.core.Flyway;

public class FlywayDBMigrations implements FlywayDBMigrationService {

    private final DataSource dataSource;

    public FlywayDBMigrations(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    
    @Override
    public void migrate() {
         Flyway flyway = Flyway.configure()
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
