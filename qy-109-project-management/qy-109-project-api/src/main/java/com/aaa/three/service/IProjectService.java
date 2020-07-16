package com.aaa.three.service;

import com.aaa.three.base.ResultData;
import com.aaa.three.model.LoginLog;
import com.aaa.three.model.MappingProject;
import com.aaa.three.model.MappingUnit;
import com.aaa.three.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;

/**
 * @Param
 * @ClassName IProjectService
 * @Description
 * @Author yk
 * @Date 2020/7/15 0015 15:08
 * @Return
 **/
@FeignClient(value = "provider-name")
public interface IProjectService {
    /**
     * @Description :执行登录操作
     * @param user
     * @return : com.aaa.three.base.ResultData
     * @author : yk
     * @date : 2020/07/15 15:11
     */
    @PostMapping("/doLogin")
    ResultData doLogin(@RequestBody User user);
    /**
     * @Description : 新增日志
     * @param loginLog
     * @return : java.lang.Integer
     * @author : yk
     * @date : 2020/07/15 20:27
     */
    @PostMapping("/addLoginLog")
    Integer addLoginLog(@RequestBody LoginLog loginLog);

    /**
     * @Description : 项目审核---项目审核
     查询所有未审核项目
     * @return : java.util.List<com.aaa.three.model.MappingProject>
     * @author : yk
     * @date : 2020/07/16 16:38
     */
    @GetMapping("/allProjectAudit")
     List<MappingProject> allProjectAudit();

    /**
     * @Description : 项目审核----项目审核
     *          模糊查询
     * @param hashMap
     * @return : com.aaa.three.base.ResultData
     * @author : yk
     * @date : 2020/07/16 16:38
     */
    @GetMapping("/selectByName")
    ResultData selectByName(@RequestBody HashMap hashMap);

    /**
     * @Description :
        项目审核---项目汇交
                查询
     * @return : java.util.List<com.aaa.three.model.MappingProject>
     * @author : yk
     * @date : 2020/07/16 17:29
     */
    @GetMapping("/allAchievementExchange")
    List<MappingProject> allAchievementExchange();
    /**
     * @author: deng
     * @date: 2020/07/16
     * @Description:
     *      查询测绘单位全表
     * @Param: []
     * @return: java.util.List<com.aaa.three.model.MappingUnit>
     */
    @GetMapping("/selectAllUnits")
    List<MappingUnit> selectAllUnits();
}
