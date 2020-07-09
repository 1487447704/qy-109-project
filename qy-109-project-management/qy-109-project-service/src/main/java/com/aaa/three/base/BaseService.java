package com.aaa.three.base;

import com.aaa.three.utils.Map2BeanUtils;
import com.aaa.three.utils.SpringContextUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.Sqls;

import java.lang.reflect.ParameterizedType;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static com.aaa.three.staticproperties.OrderStatic.*;

/**
 * @Param
 * @ClassName BaseService
 * @Description 通用service
 * @Author yk
 * @Date 2020/7/8 0008 20:22
 * @Return
 **/
public abstract class BaseService<T> {

    //全局变量，缓存子类的泛型类型
    private Class<T> cache = null;


    @Autowired
    private Mapper<T> mapper;

    protected Mapper getMapper(){
        return mapper;
    }

    /**
     * @Description : 新增数据
     * @param t
     * @return : java.lang.Integer
     * @author : yk
     * @date : 2020/07/09 14:47
     */
    public Integer add(T t){
        return mapper.insert(t);
    }

    /**
     * @Description : 根据主键进行删除
     * @param t
     * @return : java.lang.Integer
     * @author : yk
     * @date : 2020/07/09 14:48
     */
    public Integer delete(T t){
        return mapper.deleteByPrimaryKey(t);
    }

    /**
     * @Description : 根据主键进行批量删除
     * @param ids
     * @return : java.lang.Integer
     * @author : yk
     * @date : 2020/07/09 14:51
     */
    public Integer deleteByIds(List<Integer> ids){

        /**
         * delete * from user where username = 'zhangsan' and id in(1,2,3...);
         * Example.builder()------>delete * from user
         * Sqls.custom()-------->用户可能会自定义的某些SQL语句 当为null时相当于sql语句中 where 1 = 1
         * andIn("id",ids)--------> in(1,2,3...)   "id"----->数据库中的主键名称
         *                  ids------->(1,2,3...)
         */
        Example example = Example.builder(getTypeArgument()).where(Sqls.custom().andIn("id", ids)).build();
        return mapper.deleteByPrimaryKey(example);
    }

    /**
     * @Description : 更新操作
     *      updateByPrimaryKey与updateByPrimaryKeySelective的区别：
     *          updateByPrimaryKey会对左右的字段都进行更新
     *          updateByPrimaryKeySelective会对字段进行判断再更新（如果为null就忽略更新）
     *              如果只想更新某一字段，可以用这个方法
     * @param t
     * @return : java.lang.Integer
     * @author : yk
     * @date : 2020/07/09 15:18
     */
        public Integer update(T t){
            return mapper.updateByPrimaryKeySelective(t);
        }


        /**
         * @Description :批量更新
         * @param t
         * @param ids
         * @return : java.lang.Integer
         * @author : yk
         * @date : 2020/07/09 15:32
         */
        public Integer batchUpdate(T t,Integer[] ids){
            Example example = Example.builder(getTypeArgument()).where(Sqls.custom().andIn("id", Arrays.asList(ids))).build();
            return mapper.updateByExample(t,example);
        }

        /**
         * @Description : 查询一条数据
         *    selectOne(T t):形参中的t所传递的数据----->主键，唯一键(username,phone,number...)
         * @param t
         * @return : T
         * @author : yk
         * @date : 2020/07/09 15:40
         */
        public T selectOne(T t){
            return mapper.selectOne(t);
        }

        /**
         * @Description : 查询一条数据
         *                 可以排序（orderByField:ASC,DESC）
         *                 fields:不只是代表唯一键
         *                      eg：
         *                      select * from user where username = xxx and password = xxx and address = xxx
         * @param where
         * @param orderByField
         * @param fields
         * @return : T
         * @author : yk
         * @date : 2020/07/09 15:44
         */
        public T selectOneByField(Sqls where,String orderByField,String... fields){
                return (T) selectByFields(null,null,where,orderByField,null,fields);
        }

        /**
         * @Description : 通过条件查询一个列表
         * @param where
         * @param orderByField
         * @param fields
         * @return : java.util.List<T>
         * @author : yk
         * @date : 2020/07/09 16:30
         */
        public List<T> selectListByField(Sqls where,String orderByField,String... fields){
            return selectByFields(null,null,where,orderByField,null,fields);
        }

        /**
         * @Description : 实现条件查询的分页
         * @param pageNo
         * @param pageSize
         * @param where
         * @param orderFiled
         * @param fields
         * @return : com.github.pagehelper.PageInfo<T>
         * @author : yk
         * @date : 2020/07/09 16:34
         */
        public PageInfo<T> selectListByPageAndFiled(Integer pageNo,Integer pageSize,Sqls where,String orderFiled,String... fields){
            return new PageInfo<T>(selectByFields(pageNo,pageSize,where,orderFiled,null,fields));
        }

        /**
         * @Description :查询集合，条件查询
         * @param t
         * @return : java.util.List<T>
         * @author : yk
         * @date : 2020/07/09 16:37
         */
        public List<T> selectList(T t){
            return mapper.select(t);
        }
        /**
         * @Description :查询集合，分页查询
         * @param t
         * @param pageNo
         * @param pageSize
         * @return : com.github.pagehelper.PageInfo<T>
         * @author : yk
         * @date : 2020/07/09 16:39
         */
        public PageInfo<T> selectListByPage(T t,Integer pageNo,Integer pageSize){
            PageHelper.startPage(pageNo,pageSize);
            List<T> select = mapper.select(t);
            PageInfo<T> pageInfo = new PageInfo<T>(select);
            return pageInfo;
        }

        /**
         * @Description : map转换实体类型
         * @param map
         * @return : T
         * @author : yk
         * @date : 2020/07/09 18:54
         */
        public T newInstance(Map map){
            return (T) Map2BeanUtils.map2Bean(map,getTypeArgument());
        }


        /**
         * @Description :实现查询通用
         *              不但可以作用于分页，还可以作用于排序，还能作用于多条件查询
         * @param pageNo
         * @param pageSize
         * @param where 用户是否自定义where条件
         * @param orderByField 所要排序的字段
         * @param orderWord
         * @param fields 查询条件
         * @return : java.util.List<T>
         * @author : yk
         * @date : 2020/07/09 15:52
         */
        public List<T> selectByFields(Integer pageNo,Integer pageSize,Sqls where,String orderByField,String orderWord,String... fields){
            Example.Builder builder = null;

            if (null ==fields || fields.length == 0){
                //查询所有数据
                builder = Example.builder(getTypeArgument());
            } else {
                //说明需要进行条件查询
                builder  = Example.builder(getTypeArgument()).select(fields);
            }

            if (where != null){
                //说明有用户自定义的where语句条件
                builder = builder.where(where);
            }
            if (orderByField != null){
                //说明需要对某个字段进行排序
                if (DESC.equals(orderWord.toUpperCase())){
                    //说明需要倒序
                    builder = builder.orderByDesc(orderByField);
                }else if (ASC.equals(orderWord.toUpperCase())){
                    builder = builder.orderByAsc(orderByField);
                }
            }
            Example example = builder.build();
            //实现分页
            if (pageNo != null & pageSize != null){
                PageHelper.startPage(pageNo,pageSize);
            }
            return getMapper().selectByExample(example);
        }






    /**
     * @Description :
        获取子类泛型类型
     * @return : java.lang.Class<T>
     * @author : yk
     * @date : 2020/07/09 15:04
     */
    public Class<T> getTypeArgument(){
        if (null == cache){
            cache = (Class<T>) ((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        }
        return cache;
    }

    /**
     * @Description :
        获取spring容器/获取spring的上下文
        在项目开始运行的时候，会去加载spring的配置，
        如果项目需要在项目启动的时候也加载自己的配置文件
        在spring源码中有一个必须要看的方法（init())
        init()----->就是在项目启动的时候去加载spring的配置
        如果项目也需要把某一些配置一开始就托管给spring
        需要获取到spring的上下文（applicationContext）
     * @return : org.springframework.context.ApplicationContext
     * @author : yk
     * @date : 2020/07/09 16:46
     */
    public ApplicationContext getApplicationContext(){
        return SpringContextUtils.getApplicationContext();
    }
}
