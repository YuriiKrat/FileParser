package com.gmail.yuriikrat.services;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author Yurii Krat
 * @version 1.0
 * @since 25.06.17.
 */
public interface FileParsingService {

    void parseFiles(MultipartFile[] files) throws IOException;

}
