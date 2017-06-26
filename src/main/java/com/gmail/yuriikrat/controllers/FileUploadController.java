package com.gmail.yuriikrat.controllers;

import com.gmail.yuriikrat.services.FileParsingService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author Yurii Krat
 * @version 1.0
 * @since 25.06.17.
 */
@RestController
@RequestMapping("/upload")
public class FileUploadController {

    private static final Logger LOG = Logger.getLogger(FileUploadController.class);

    private FileParsingService fileParsingService;

    @Autowired
    public FileUploadController(FileParsingService fileParsingService) {
        this.fileParsingService = fileParsingService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public HttpStatus uploadAndParse(
            @RequestParam("files") MultipartFile[] multipartFiles) throws IOException {
        LOG.info("Trying to upload " + multipartFiles.length + " files!");
        fileParsingService.parseFiles(multipartFiles);
        return HttpStatus.OK;
    }


}
