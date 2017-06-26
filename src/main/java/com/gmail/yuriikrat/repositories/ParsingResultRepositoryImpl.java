package com.gmail.yuriikrat.repositories;

import com.gmail.yuriikrat.domain.ParsingResult;
import com.gmail.yuriikrat.utils.QueryLoader;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;

/**
 * @author Yurii Krat
 * @version 1.0
 * @since 26.06.17.
 */
public class ParsingResultRepositoryImpl extends JdbcDaoSupport
        implements ParsingResultRepository {

    private static final Logger LOG = Logger.getLogger(ParsingResultRepositoryImpl.class);

    private QueryLoader queryLoader;

    @Autowired
    public ParsingResultRepositoryImpl(QueryLoader queryLoader) {
        this.queryLoader = queryLoader;
    }

    @Override
    public List<ParsingResult> findAll() {
        String query = getQuery("find.all");
        return getJdbcTemplate().query(query, new BeanPropertyRowMapper(ParsingResult.class));
    }

//    public void insert(ParsingResult customer){
//
//        String sql = "INSERT INTO results " +
//                "(VALUE , COUNT ) VALUES (?, ?)";
//
//        getJdbcTemplate().update(sql, customer.getValue(),
//                customer.getCount());
//    }

    private String getQuery(String type) {
        return queryLoader.getQuery("parsing.result." + type);
    }

}
