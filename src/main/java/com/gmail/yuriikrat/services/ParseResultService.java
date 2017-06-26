package com.gmail.yuriikrat.services;

import com.gmail.yuriikrat.domain.ParsingResult;

import java.util.List;

/**
 * Service for retrieving and updating parsing result
 *
 * @author Yurii Krat
 * @version 1.0
 * @since 25.06.17.
 */
public interface ParseResultService {

    /**
     * Retrieves result of parsing from db
     * @return
     */
    List<ParsingResult> getResult();

    /**
     * Initiates update of parsing result in db
     *
     * @param prList list of parsing result objects
     */
    void update(List<ParsingResult> prList);
}
