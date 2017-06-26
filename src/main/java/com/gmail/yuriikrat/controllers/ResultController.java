package com.gmail.yuriikrat.controllers;

import com.gmail.yuriikrat.domain.ParsingResult;
import com.gmail.yuriikrat.services.ParseResultService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Yurii Krat
 * @version 1.0
 * @since 25.06.17.
 */
@RestController
@RequestMapping("/result")
public class ResultController {

    private static final Logger LOG = Logger.getLogger(ResultController.class);

    private ParseResultService parseResultService;

    @Autowired
    public ResultController(ParseResultService parseResultService) {
        this.parseResultService = parseResultService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<ParsingResult> getResult() {
        LOG.info("Trying to get result of parsing!");
        return parseResultService.getResult();
    }


}
