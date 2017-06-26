package com.gmail.yuriikrat.services;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    public FileParsingServiceImpl(TaskExecutor taskExecutor) {
        this.taskExecutor = taskExecutor;
    }

    @Override
    public void parseFiles(MultipartFile[] files) throws IOException {
        for (MultipartFile file: files) {
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(file.getInputStream()));
            String line;
            while((line = reader.readLine()) != null) {
                LOG.info("Processing line:" + line);
                taskExecutor.execute(new ParsingWorker(line));
            }
        }
    }
}
