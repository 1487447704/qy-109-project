package com.aaa.three.controller;

import com.aaa.three.base.BaseService;
import com.aaa.three.base.CommonController;
import com.aaa.three.base.ResultData;
import com.aaa.three.model.MappingProject;
import com.aaa.three.service.ProjectAuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.aaa.three.staticproperties.MappingProjectProperties.*;
import static com.aaa.three.status.LoginStatus.*;
import static com.aaa.three.status.OperationStatus.*;

/**
 * @Param
 * @ClassName projectAuditController
 * @Description 项目审核---项目审核
 * @Author yk
 * @Date 2020/7/16 0016 11:41
 * @Return
 **/
@RestController
public class ProjectAuditController extends CommonController<MappingProject> {

    @Autowired
    private ProjectAuditService projectAuditService;
    @Override
    public BaseService<MappingProject> getBaseService() {
        return null;
    }
    /**
     * @Description :
        查询所有未审核项目
     * @return : java.util.Map<java.lang.String,java.lang.Object>
     * @author : yk
     * @date : 2020/07/16 16:37
     */
    @GetMapping("/allProjectAudit")
    public List<MappingProject> allProjectAudit(){
//        Map<String, Object> map = projectAuditService.projectAudit();
//        return map;
        return projectAuditService.allProjectAudit();
    }

    /**
     * @Description : 项目审核-----项目审核
     * 模糊查询
     * @param hashMap
     * @return : com.aaa.three.base.ResultData
     * @author : yk
     * @date : 2020/07/16 16:37
     */
    @GetMapping("/selectByName")
    public ResultData selectByName(@RequestBody HashMap hashMap) {
        Map<String, Object> resultMap = projectAuditService.selectByName(hashMap);
        if (SUCCESS.getCode().equals(resultMap.get(CODE))) {
            return super.loginSuccess(resultMap.get(DATA));
        } else {
            return super.loginFailed(SYSTEM_EXCEPTION.getMsg());
        }

    }

    /**
     * @Description :项目审核--项目汇交
            查询
     * @return : java.util.List<com.aaa.three.model.MappingProject>
     * @author : yk
     * @date : 2020/07/16 17:29
     */
    @GetMapping("/allAchievementExchange")
    public List<MappingProject> allAchievementExchange(){
        return projectAuditService.allAchievementExchange();
    }
}
