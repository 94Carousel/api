package com.eolane.ywy.api.service.impl;

import com.eolane.ywy.api.dto.DirBean;
import com.eolane.ywy.api.param.FileBatchDelParam;
import com.eolane.ywy.api.service.IFileExploreService;
import com.eolane.ywy.api.util.FileUtil;
import com.eolane.ywy.api.util.IterateDir;
import org.springframework.stereotype.Service;

@Service
public class FileExploreServiceImpl implements IFileExploreService {

    @Override
    public DirBean iterateDir(String path) throws Exception {
        return IterateDir.getFiles(path);
    }

    @Override
    public boolean moveFileAndFolderToTrash(FileBatchDelParam fileBatchDelParam, String sourcePath, String trashPath) {
        for (String filePath : fileBatchDelParam.getFileList()) {
            if (!filePath.startsWith(sourcePath)) {
                return false;
            }
            FileUtil.moveFileOrDir(filePath, filePath.replace(sourcePath, trashPath), true);
        }
        return true;
    }
}
