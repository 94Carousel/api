package com.eolane.ywy.api.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "explore")
public class FileExploreProperties {
    private String uploadPath;
    private String trashPath;
    private String basePathAlias;

    public String getUploadPath() {
        return uploadPath;
    }

    public void setUploadPath(String uploadPath) {
        this.uploadPath = uploadPath;
    }

    public String getTrashPath() {
        return trashPath;
    }

    public void setTrashPath(String trashPath) {
        this.trashPath = trashPath;
    }

    public String getBasePathAlias() {
        return basePathAlias;
    }

    public void setBasePathAlias(String basePathAlias) {
        this.basePathAlias = basePathAlias;
    }
}
