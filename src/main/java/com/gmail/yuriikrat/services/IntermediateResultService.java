package com.gmail.yuriikrat.services;

/**
 * Service for storing result of parsing and writing it to db
 *
 * @author Yurii Krat
 * @version 1.0
 * @since 26.06.17.
 */
public interface IntermediateResultService {

    /**
     * Adds line to parsing result
     *
     * @param str string to add to result of parsing
     */
    void addToResult(String str);

    /**
     * Initiates writing list of result objects to db
     * and clears current result
     */
    void refresh();

}
