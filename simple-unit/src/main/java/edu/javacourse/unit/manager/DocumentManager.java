package edu.javacourse.unit.manager;

import java.io.InputStream;

public class DocumentManager {
    private AlfrescoManager alfrescoManager;
    public void uploadFile(InputStream file, String fileName, Long companyID,
                           boolean external, boolean restricted) {
        // checkFile
        // Save to Alfresco
        alfrescoManager.uploadFile(file, fileName);
        // if (external) - Save to Amazon S3
        // if (restricted) - set permissions in Alfresco
        // Save to DB
    }


}
