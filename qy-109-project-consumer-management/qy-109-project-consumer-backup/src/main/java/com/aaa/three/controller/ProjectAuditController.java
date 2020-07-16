package com.aaa.three.controller;

import com.aaa.three.base.ResultData;
import com.aaa.three.model.MappingProject;
import com.aaa.three.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;

/**
 * @Param
 * @ClassName ProjectAuditController
 * @Description TODO
 * @Author yk
 * @Date 2020/7/16 0016 11:52
 * @Return
 **/
@RestController
public class ProjectAuditController {
    @Autowired
    private IProjectService projectService;

    /**
     * @Description :项目审核----项目审核
            查询所有未审核项目
     * @return : java.util.List<com.aaa.three.model.MappingProject>
     * @author : yk
     * @date : 2020/07/16 16:40
     */
    @GetMapping("/allProjectAudit")
    public List<MappingProject> allProjectAudit(){
        return projectService.allProjectAudit();
    }
    /**
     * @Description : 项目审核----项目审核
     *      模糊查询
     * @param hashMap
     * @return : com.aaa.three.base.ResultData
     * @author : yk
     * @date : 2020/07/16 16:41
     */
    @GetMapping("/selectByName")
    public ResultData selectByName(@RequestBody HashMap hashMap) {
        return projectService.selectByName(hashMap);
    }

    /**
     * @Description :
        项目审核---项目汇交
            查询
     * @return : java.util.List<com.aaa.three.model.MappingProject>
     * @author : yk
     * @date : 2020/07/16 17:30
     */
    @GetMapping("/allAchievementExchange")
    public List<MappingProject> allAchievementExchange(){
        return projectService.allAchievementExchange();
    }
}
