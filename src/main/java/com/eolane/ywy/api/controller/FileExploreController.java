package com.eolane.ywy.api.controller;

import com.eolane.ywy.api.dto.ResultDTO;
import com.eolane.ywy.api.properties.FileExploreProperties;
import com.eolane.ywy.api.service.IFileExploreService;
import com.eolane.ywy.api.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/explore")
public class FileExploreController {
    private final static Logger log = LoggerFactory.getLogger(FileExploreController.class);
    @Autowired
    private FileExploreProperties fileExploreProperties;
/*    private final String BASE_PATH = fileExploreProperties.getUploadPath();
    private final String TRASH_PATH = fileExploreProperties.getTrashPath();
    private final String BASE_PATH_ALIAS = fileExploreProperties.getBasePathAlias();    */
    private final String BASE_PATH = "C:\\upload";
    private final String TRASH_PATH = "C:\\trash";
    private final String BASE_PATH_ALIAS = "Document";
    private final IFileExploreService fileExploreService;

    @Autowired
    public FileExploreController(IFileExploreService fileExploreService) {
        this.fileExploreService = fileExploreService;
    }


    @GetMapping("/dir")
    @ResponseBody
    public ResultDTO dir(@RequestParam(name = "path") String path) throws Exception {
        if ("".equals(path) || path == null || !path.startsWith(BASE_PATH_ALIAS)) {
            path = BASE_PATH_ALIAS;
        }
        path = path.replace(BASE_PATH_ALIAS, BASE_PATH);
        return ResultUtil.success(fileExploreService.iterateDir(path));
    }
}
