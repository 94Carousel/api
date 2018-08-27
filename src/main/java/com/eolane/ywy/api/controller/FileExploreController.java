package com.eolane.ywy.api.controller;

import com.eolane.ywy.api.dto.ResultDTO;
import com.eolane.ywy.api.service.IFileExploreService;
import com.eolane.ywy.api.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/explore")
public class FileExploreController {
    private final String BASE_PATH = "C:\\upload";
    private final String TRASH_PATH = "C:\\trash";
    private final IFileExploreService fileExploreService;

    @Autowired
    public FileExploreController(IFileExploreService fileExploreService) {
        this.fileExploreService = fileExploreService;
    }


    @GetMapping("/dir")
    @ResponseBody
    public ResultDTO dir(@RequestParam(defaultValue = "C:\\upload", name = "path") String path) throws Exception {
        return ResultUtil.success(fileExploreService.iterateDir(path));
    }
}
