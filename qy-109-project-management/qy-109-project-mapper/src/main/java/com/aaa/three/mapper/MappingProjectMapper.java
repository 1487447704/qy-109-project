package com.aaa.three.mapper;

import com.aaa.three.model.MappingProject;
import tk.mybatis.mapper.common.Mapper;

import java.util.HashMap;
import java.util.List;

public interface MappingProjectMapper extends Mapper<MappingProject> {

    /**
     *
     * 项目审核-----项目审核-----查询
     * @return
     */
    List<MappingProject> allProjectAudit();

    /**
     * 项目审核-----项目审核----模糊查询
     * @return
     */
    List<MappingProject> selectByName(HashMap map);

    /**
     * @Description :
     项目审核-----项目汇交审核----查询
     * @return : java.util.List<com.aaa.three.model.MappingProject>
     * @author : yk
     * @date : 2020/07/16 16:55
     */
    List<MappingProject> allAchievementExchange();
}