package com.guli.edu.controller.admin;

import com.guli.common.constants.ResultCodeEnum;
import com.guli.common.constants.vo.R;
import com.guli.common.exception.GuliException;
import com.guli.edu.service.SubjectService;
import com.guli.edu.vo.SubjectNestedVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author kaixuan
 * @version 1.0
 * @date 2019/12/4 12:52
 */
@Api(description ="课程分类管理")
@RestController
@CrossOrigin
@RequestMapping("/admin/edu/subject")
public class SubjectAdminController {

    @Autowired
    private SubjectService subjectService;


    @ApiOperation(value = "Excel批量导入")
    @PostMapping("import")
    public R batchImport(
            @ApiParam(name ="file",value ="Excel文件",required =true)
            @RequestParam("file")
            MultipartFile multipartFile) {

        try {
            List<String> errorMsg = subjectService.batchImport(multipartFile);
            if (errorMsg.size() == 0) {
                return R.ok().message("批量导入成功");
            } else {
                return R.error().message("部分数据导入失败").data("errorMsgList", errorMsg);
            }

        } catch (Exception e) {
            throw new GuliException(ResultCodeEnum.EXCEL_DATA_IMPORT_ERROR);
        }
    }

    @ApiOperation(value = "嵌套数据列表")
    @GetMapping
    public R nestedList(){
        List<SubjectNestedVo> subjectNestedVoList = subjectService.nestedList();
        return R.ok().data("items", subjectNestedVoList);
    }
















}
