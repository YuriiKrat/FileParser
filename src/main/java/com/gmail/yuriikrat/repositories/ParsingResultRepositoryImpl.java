package com.gmail.yuriikrat.repositories;

import com.gmail.yuriikrat.domain.ParsingResult;
import com.gmail.yuriikrat.utils.QueryLoader;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Yurii Krat
 * @version 1.0
 * @since 26.06.17.
 */
@PropertySource("classpath:properties/jdbc.properties")
public class ParsingResultRepositoryImpl extends JdbcDaoSupport
        implements ParsingResultRepository {

    private static final Logger LOG = Logger.getLogger(ParsingResultRepositoryImpl.class);

    private static final int BATCH_SIZE = 1000;

    private QueryLoader queryLoader;

    @Autowired
    public ParsingResultRepositoryImpl(QueryLoader queryLoader) {
        this.queryLoader = queryLoader;
    }

    @Override
    public List<ParsingResult> findAll() {
        String query = getQuery("find.all");
        LOG.info("Trying to execute query: " + query);
        return getJdbcTemplate().query(query, new BeanPropertyRowMapper(ParsingResult.class));
    }

    @Override
    public void update(List<ParsingResult> parsingResults) {
        String query = getQuery("update");

        for (int j = 0; j < parsingResults.size(); j += BATCH_SIZE) {

            final List<ParsingResult> batchList = parsingResults.subList(
                    j, j + BATCH_SIZE > parsingResults.size() ? parsingResults.size() : j + BATCH_SIZE);

            getJdbcTemplate().batchUpdate(query,
                    new BatchPreparedStatementSetter() {
                        @Override
                        public void setValues(PreparedStatement ps, int i)
                                throws SQLException {
                            ParsingResult pr = batchList.get(i);
                            ps.setString(1, pr.getValue());
                            ps.setInt(2, pr.getCount());
                        }

                        @Override
                        public int getBatchSize() {
                            return batchList.size();
                        }
                    });

        }
    }

    private String getQuery(String type) {
        return queryLoader.getQuery("parsing.result." + type);
    }

}
