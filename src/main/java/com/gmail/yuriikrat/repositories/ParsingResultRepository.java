package com.gmail.yuriikrat.repositories;

import com.gmail.yuriikrat.domain.ParsingResult;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Yurii Krat
 * @version 1.0
 * @since 26.06.17.
 */
@Repository
public interface ParsingResultRepository {

    List<ParsingResult> findAll();

//    void insert(ParsingResult customer);

}
