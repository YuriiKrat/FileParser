package com.gmail.yuriikrat.services;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.task.TaskExecutor;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Yurii Krat
 * @version 1.0
 * @since 25.06.17.
 */
public class FileParsingServiceImpl implements FileParsingService {

    private static final Logger LOG = Logger.getLogger(FileParsingServiceImpl.class);

    private TaskExecutor taskExecutor;

    private ApplicationContext applicationContext;

    @Autowired
    public FileParsingServiceImpl(TaskExecutor taskExecutor,
                                  ApplicationContext applicationContext) {
        this.taskExecutor = taskExecutor;
        this.applicationContext = applicationContext;
    }

    @Override
    public void parseFiles(MultipartFile[] files) throws IOException {
        for (MultipartFile file: files) {
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(file.getInputStream()));
            String line;
            while((line = reader.readLine()) != null) {
                LOG.info("Processing line:" + line);
                ParsingWorker worker = (ParsingWorker) applicationContext.getBean("parsingWorker");
                worker.setLine(line);
                taskExecutor.execute(worker);
            }
            ParsingWorker worker = (ParsingWorker) applicationContext.getBean("parsingWorker");
            worker.finishParsing();
        }
    }
}
