package com.gmail.yuriikrat.repositories;

import com.gmail.yuriikrat.domain.ParsingResult;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository with methods for interacting with db
 *
 * @author Yurii Krat
 * @version 1.0
 * @since 26.06.17.
 */
@Repository
public interface ParsingResultRepository {

    /**
     * Retrieves all result objects from db
     * @return list of parsing result objects
     */
    List<ParsingResult> findAll();

    /**
     * Updates result of parsing in db
     * @param parsingResults list of parsing result objects
     */
    void update(List<ParsingResult> parsingResults);

}
