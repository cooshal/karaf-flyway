package com.example.infrastructure;

import org.flywaydb.core.api.logging.Log;
import org.slf4j.Logger;

public class Slf4jFlywayLogger implements Log{
    
    private final Logger logger;

    public Slf4jFlywayLogger(Logger logger) {
        this.logger = logger;
    }
    
    @Override
    public boolean isDebugEnabled() {
        return logger.isDebugEnabled();
    }

    @Override
    public void debug(String message) {
        logger.debug(message);
    }

    @Override
    public void info(String message) {
        logger.info(message);
    }

    @Override
    public void warn(String message) {
        logger.warn(message);
    }

    @Override
    public void error(String message) {
        logger.error(message);
    }

    @Override
    public void error(String message, Exception exception) {
        logger.error(message, exception);
    }    
}