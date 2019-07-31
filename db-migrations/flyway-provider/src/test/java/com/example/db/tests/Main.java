package com.example.db.tests;

import com.example.db.migrations.FlywayDBMigrationService;
import com.example.db.migrations.FlywayDBMigrations;
import javax.sql.DataSource;
import org.apache.commons.dbcp.BasicDataSource;

public class Main {
    
    public static void main(String[] args) {
        FlywayDBMigrationService dbMigration = 
                new FlywayDBMigrations(createDatawarehouseDatasource());
        dbMigration.migrate();
    }
    
    private static DataSource createDatawarehouseDatasource() {
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName("org.h2.Driver");
        ds.setUrl("jdbc:h2:mem:test");
        ds.setUsername("sa");
        ds.setPassword("");
        
        return ds;
    }

}
