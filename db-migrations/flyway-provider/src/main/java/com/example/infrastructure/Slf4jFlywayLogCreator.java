package com.example.infrastructure;

import org.flywaydb.core.api.logging.Log;
import org.flywaydb.core.api.logging.LogCreator;
import org.slf4j.LoggerFactory;

public class Slf4jFlywayLogCreator implements LogCreator{

    @Override
    public Log createLogger(Class<?> clazz) {
        return new Slf4jFlywayLogger(LoggerFactory.getLogger(clazz));
    }
}