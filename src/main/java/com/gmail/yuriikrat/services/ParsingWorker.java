package com.gmail.yuriikrat.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Implements single task (processing single line)
 * in parsing process
 *
 * @author Yurii Krat
 * @version 1.0
 * @since 26.06.17.
 */
@Component
@Scope("prototype")
public class ParsingWorker extends Thread {

    private String line;

    private IntermediateResultService intermediateResultService;

    @Autowired
    public ParsingWorker(IntermediateResultService intermediateResultService) {
        this.intermediateResultService = intermediateResultService;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    @Override
    public void run() {
        intermediateResultService.addToResult(line);
    }

    public void finishParsing() {
        intermediateResultService.refresh();
    }
}
