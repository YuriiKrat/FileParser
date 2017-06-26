package com.gmail.yuriikrat.services;

import com.gmail.yuriikrat.domain.ParsingResult;
import com.gmail.yuriikrat.repositories.ParsingResultRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author Yurii Krat
 * @version 1.0
 * @since 26.06.17.
 */
public class ParseResultServiceImpl implements ParseResultService {

    private ParsingResultRepository repository;

    @Autowired
    public ParseResultServiceImpl(ParsingResultRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ParsingResult> getResult() {
        return repository.findAll();
    }

    @Override
    public void update(List<ParsingResult> prList) {
        repository.update(prList);
    }
}
