package com.gmail.yuriikrat.services;

import com.gmail.yuriikrat.domain.ParsingResult;
import com.gmail.yuriikrat.repositories.ParsingResultRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.hamcrest.Matchers.containsInAnyOrder;

/**
 * @author Yurii Krat
 * @version 1.0
 * @since 26.06.17.
 */
@ContextConfiguration(value = "classpath:parse-result-service-config.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class ParseResultServiceImplTest {

    @Autowired
    private ParsingResultRepository parsingResultRepository;

    @Autowired
    private ParseResultService parseResultService;

    @Test
    public void shouldFindAll() throws Exception {
        ParsingResult pr1 = new ParsingResult("xyz", 2);
        ParsingResult pr2 = new ParsingResult("mno", 10);

        when(parsingResultRepository.findAll()).thenReturn(Arrays.asList(pr1, pr2));

        List<ParsingResult> rslt = parseResultService.getResult();

        assertThat(rslt, containsInAnyOrder(pr1, pr2));
    }

    @Test
    public void shouldUpdate() throws Exception {
        ParsingResult pr1 = new ParsingResult("xyz", 2);
        ParsingResult pr2 = new ParsingResult("mno", 10);
        List<ParsingResult> list = Arrays.asList(pr1, pr2);

        parseResultService.update(list);

        verify(parsingResultRepository, atLeastOnce()).update(list);
    }


}