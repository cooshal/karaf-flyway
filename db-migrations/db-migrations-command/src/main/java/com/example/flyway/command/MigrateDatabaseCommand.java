package com.example.flyway.command;

import com.example.db.migrations.FlywayDBMigrationService;
import org.apache.karaf.shell.api.action.Action;
import org.apache.karaf.shell.api.action.Command;
import org.apache.karaf.shell.api.action.lifecycle.Reference;
import org.apache.karaf.shell.api.action.lifecycle.Service;

@Service
@Command(scope = "dbf", name = "migrate", description = "Migrate global datawarehouse database")
public class MigrateDatabaseCommand implements Action {

    @Reference
    private FlywayDBMigrationService dbMigration;
    
    @Override
    public Object execute() throws Exception {
        System.out.println("Migrating the Global Datawarehouse");
        
        dbMigration.migrate();
        
        System.out.println("Migration completed successfully!");
        return null;
    }

}
