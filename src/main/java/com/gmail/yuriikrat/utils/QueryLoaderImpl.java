package com.gmail.yuriikrat.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * @author Yurii Krat
 * @version 1.0
 * @since 26.06.17.
 */
@Component
@PropertySource("classpath:properties/query.properties")
public class QueryLoaderImpl implements QueryLoader {

    private Environment env;

    @Autowired
    public QueryLoaderImpl(Environment env) {
        this.env = env;
    }

    @Override
    public String getQuery(String queryName) {
        return env.getProperty(queryName);
    }
}