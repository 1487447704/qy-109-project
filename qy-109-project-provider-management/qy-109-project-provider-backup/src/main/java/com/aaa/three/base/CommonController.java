package com.aaa.three.base;

import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @Param
 * @ClassName CommonController
 * @Description abstract:想实现的方法实现，不想实现的方法不实现
 * @Author yk
 * @Date 2020/7/8 0008 20:16
 * @Return
 **/
public abstract class CommonController<T> extends BaseController {
    /**
     * @Description :钩子函数
     *          在新增之前去执行某些操作
     *
     *              下单操作：
     *                  需求：
     *                      在购物车中当点击立即下单的按钮的时候---》跳转到下单页面（选择地址，选择优惠券...）
     *                      把购物车中的这个商品删除
     *                      deleteCart(List<Integer> id);--->优先于insertOrder（Order order）前置执行
     * @param map
     * @return : void
     * @author : yk
     * @date : 2020/07/09 17:12
     */
    protected void beforeAdd(Map map){
        // todo AddMethod Before to do something
    }

    /**
     * @Description :钩子函数
     *  是在新增后去执行
     *
     *      int result = insertOrder(Order order);
     *      if(result > 0 ){
     *          insertOrderDetail(OrderDetail orderDetail);
     *      }
     * @param map
     * @return : void
     * @author : yk
     * @date : 2020/07/09 17:19
     */
    protected void afterAdd(Map map){
        // TODO AddMethod After to do something
    }


    public abstract BaseService<T> getBaseService();

    /**
     * @Description :通用的新增方法
     *                  因为目前市面上的所有公司实现的全是异步了
     *                  也就是说前端向后端传递的数据都是json格式
     *                  之前在controller的方法中接收的是固定的实体类，是因为我们知道前端给我们传递的类型就是这个实体类
     *                  但是既然要做通用，前端所传递的类型就不会固定了--->所以使用map类型来统一接收
     * @param map
     * @return : com.aaa.three.base.ResultData
     * @author : yk
     * @date : 2020/07/09 18:45
     */

    public ResultData add(@RequestBody Map map){
        //根据封装规则，在service中是需要传递泛型的，就意味着service需要接收固定的实体类
        //但是controller是一个map类型
        beforeAdd(map);
        /*1.Map转实体类*/
        T instance = getBaseService().newInstance(map);
        /*2.通用service*/
        Integer addResult = getBaseService().add(instance);
        if (addResult > 0){
            afterAdd(map);
            return super.operationSuccess();
        }
        return super.operationFailed();
    }
    /**
     * @Description : 删除操作
     * @param map
     * @return : com.aaa.three.base.ResultData
     * @author : yk
     * @date : 2020/07/09 20:25
     */
    public ResultData delete(@RequestBody Map map){
        T instance = getBaseService().newInstance(map);
        Integer deleteResult = getBaseService().delete(instance);
        if (deleteResult > 0 ){
            return super.operationSuccess();
        }
        return super.operationFailed();
    }
    /**
     * @Description :批量删除
     * @param ids
     * @return : com.aaa.three.base.ResultData
     * @author : yk
     * @date : 2020/07/09 20:28
     */
    public ResultData batchDelete(@RequestParam("ids[]")Integer ids){
        Integer deleteResult = getBaseService().deleteByIds(Arrays.asList(ids));
        if (deleteResult > 0 ){
            return super.deleteOperation();
        }
        return super.operationFailed();
    }

    /**
     * @Description :更新操作
     * @param map
     * @return : com.aaa.three.base.ResultData
     * @author : yk
     * @date : 2020/07/09 20:39
     */
    public ResultData update(@RequestBody Map map){
        T instance = getBaseService().newInstance(map);
        Integer update = getBaseService().update(instance);
        if (update > 0){
            return super.updateOperation();
        }
        return super.operationFailed();
    }

    //TODO:批量修改未写


    /**
     * @Description : 查询一条数据
     * @param map
     * @return : com.aaa.three.base.ResultData
     * @author : yk
     * @date : 2020/07/09 21:08
     */
    public ResultData selectOne(@RequestBody Map map){
        T instance = getBaseService().newInstance(map);
        T selectOne = getBaseService().selectOne(instance);
        if (null != selectOne && "".equals(selectOne)){
            return super.operationSuccess();
        }
        return super.operationFailed();
    }
    /**
     * @Description : 查询集合，条件查询
     * @param map
     * @return : com.aaa.three.base.ResultData
     * @author : yk
     * @date : 2020/07/09 21:12
     */
    public ResultData selectList(@RequestBody Map map){
        T instance = getBaseService().newInstance(map);
        List<T> list = getBaseService().selectList(instance);
        if (list.size() > 0 && list != null){
            return super.operationFailed();
        }
        return super.operationFailed();

    }
    /**
     * @Description : 带分页不带条件的查询
     * @param t
     * @param pageNo
     * @param pageSize
     * @return : com.aaa.three.base.ResultData
     * @author : yk
     * @date : 2020/07/09 21:16
     */
    public ResultData selectListPage(T t, Integer pageNo,Integer pageSize){
            try{
                PageInfo<T> pageInfo = getBaseService().selectListByPage(t,pageNo,pageSize);
                if (pageInfo != null && pageInfo.getPageSize()>0){
                    return super.operationSuccess();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
            return super.operationFailed();
    }
}
