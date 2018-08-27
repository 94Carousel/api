package com.eolane.ywy.api.service;

import com.eolane.ywy.api.dto.DirBean;
import com.eolane.ywy.api.param.FileBatchDelParam;

public interface IFileExploreService {
    /**
     * 遍历目录
     * @param path
     * @return
     */
    DirBean iterateDir(String path) throws Exception;

    /**
     * 批量移动文件夹和文件到回收站
     * @param fileBatchDelParam
     */

    boolean moveFileAndFolderToTrash(FileBatchDelParam fileBatchDelParam,String sourcePath, String trashPath);
}
