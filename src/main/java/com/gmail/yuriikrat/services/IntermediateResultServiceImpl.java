package com.gmail.yuriikrat.services;

import com.gmail.yuriikrat.domain.ParsingResult;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Yurii Krat
 * @version 1.0
 * @since 26.06.17.
 */
public class IntermediateResultServiceImpl implements IntermediateResultService {

    private final static int MAP_SIZE = 1000;

    private Map<String, Integer> result;

    private ParseResultService parseResultService;

    @Autowired
    public IntermediateResultServiceImpl(ParseResultService parseResultService) {
        this.result = Collections.synchronizedMap(new HashMap<>());
        this.parseResultService = parseResultService;
    }


    @Override
    public void addToResult(String str) {
        if (result.containsKey(str)) {
            result.replace(str, result.get(str) + 1);
        } else {
            result.put(str, 1);
        }
        if (result.size() >= MAP_SIZE) {
            refresh();
        }
    }

    @Override
    public void refresh() {
        synchronized(result) {
            List<ParsingResult> parsingResults = new ArrayList<>();
            for (String key: result.keySet()) {
                Integer value = result.get(key);
                parsingResults.add(new ParsingResult(key, value));
            }
            if (!parsingResults.isEmpty()) {
                parseResultService.update(parsingResults);
                result.clear();
            }
        }
    }
}
