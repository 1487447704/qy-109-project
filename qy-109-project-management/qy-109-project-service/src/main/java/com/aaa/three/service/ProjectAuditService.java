package com.aaa.three.service;

import com.aaa.three.mapper.MappingProjectMapper;
import com.aaa.three.model.MappingProject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.aaa.three.staticproperties.MappingProjectProperties.*;
import static com.aaa.three.status.OperationStatus.*;

/**
 * @Param
 * @ClassName ProjectAuditService
 * @Description 项目审核
 * @Author yk
 * @Date 2020/7/16 0016 11:07
 * @Return
 **/
@Service
public class ProjectAuditService {

    @Autowired
    private MappingProjectMapper mappingProjectMapper;

    /**
     * @Description : 查询项目未审核通过的所有信息
     * @param
     * @return : java.util.Map<java.lang.String,java.lang.Object>
     * @author : yk
     * @date : 2020/07/16 11:12
     */
    public List<MappingProject> allProjectAudit(){
    /*Map<String,Object> resultMap = new HashMap<String, Object>();
//        根据条件查询项目未审核的所有信息
        List<MappingProject> allProjectAudit = mappingProjectMapper.allProjectAudit();
//        判断查询出来的信息是否为空
            if (allProjectAudit.size()>0 && allProjectAudit != null){
                resultMap.put(CODE,SUCCESS.getCode());
                resultMap.put(MSG,SUCCESS.getMsg());
                resultMap.put(DATA,allProjectAudit);
            }else{
                resultMap.put(CODE,FAILED.getCode());
                resultMap.put(MSG,FAILED.getMsg());
            }
            return resultMap;
*/
        List<MappingProject> allProjectAudit = mappingProjectMapper.allProjectAudit();
        return allProjectAudit;
    }

   /**
    * @Description : 通过名称模糊查询
    * @param map
    * @return : java.util.Map<java.lang.String,java.lang.Object>
    * @author : yk
    * @date : 2020/07/16 15:51
    */
    public Map<String ,Object> selectByName(HashMap map){
        Map<String,Object> resultMap = new HashMap<String, Object>();
        //根据条件查询项目审核信息
        List<MappingProject> mappingProjects = mappingProjectMapper.selectByName(map);
        //判断查询出来的数据是否为空
        if (mappingProjects.size()>0){
            resultMap.put(CODE,SUCCESS.getCode());
            resultMap.put(MSG,SUCCESS.getMsg());
            resultMap.put(DATA,mappingProjects);
        }else{
            resultMap.put(CODE,FAILED.getCode());
            resultMap.put(MSG,FAILED.getMsg());
        }
        return resultMap;
    }

    /**
     * @Description : 查询所有项目汇交未审核的数据
        项目审核---项目汇交
     * @return : java.util.List<com.aaa.three.model.MappingProject>
     * @author : yk
     * @date : 2020/07/16 17:25
     */

    public List<MappingProject> allAchievementExchange(){
        List<MappingProject> allAchievementExchange = mappingProjectMapper.allAchievementExchange();
        return allAchievementExchange;
    }

}
