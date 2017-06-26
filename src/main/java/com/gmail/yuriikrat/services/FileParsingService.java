package com.gmail.yuriikrat.services;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Service for parsing files in parallel way
 *
 * @author Yurii Krat
 * @version 1.0
 * @since 25.06.17.
 */
public interface FileParsingService {

    /**
     * Initiates file parsing in a parallel way
     *
     * @param files array of files to parse
     * @throws IOException
     */
    void parseFiles(MultipartFile[] files) throws IOException;

}
