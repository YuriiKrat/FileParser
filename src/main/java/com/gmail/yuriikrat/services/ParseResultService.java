package com.gmail.yuriikrat.services;

import com.gmail.yuriikrat.domain.ParsingResult;

import java.util.List;

/**
 * @author Yurii Krat
 * @version 1.0
 * @since 25.06.17.
 */
public interface ParseResultService {

    List<ParsingResult> getResult();

    void addParsingResult(ParsingResult pr);
}
