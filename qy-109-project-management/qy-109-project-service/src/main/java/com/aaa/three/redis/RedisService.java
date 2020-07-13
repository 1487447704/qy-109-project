package com.aaa.three.redis;

import com.aaa.three.utils.JSONUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;
import redis.clients.jedis.JedisCluster;

import javax.annotation.PostConstruct;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import static com.aaa.three.staticproperties.RedisProperties.*;

/**
 * @Param
 * @ClassName RedisService
 * @Description TODO
 * @Author yk
 * @Date 2020/7/10 0010 15:45
 * @Return
 **/
@Service
public class RedisService<T> {

    /**
     * @Description :spring提供的key序列化器，作用是把key序列化
     * @param null
     * @return :
     * @author : yk
     * @date : 2020/07/10 16:43
     */
    public RedisSerializer keySerializer = null;

    /**
     * @Description :
        初始化redis的key序列化器
     *  keySerializer：定义具体在什么时间初始化
     *      @PostConstruct:是spring框架的注解（这个注解通常会在搭建架构和写工具类的时候用到）
     *                      作用是 让keySerializer具体在spring配置所有加载完毕后初始化
     *                      （被@PostConstruct所标识的 方法 会在spring的配置加载完毕之后立即执行）
     *  RedisSerializer 是spring框架提供的，如果不带 @PostConstruct注解，initRedisSerializer()有可能会在spring配置加载完毕之前去执行
     *
     *
     *  1.加载spring的配置
     *  2.spring配置加载完毕之后立即检查@PostConstruct
     *      ------>如果注解存在，则直接执行被这个注解所标识的方法
     *  3.方法initRedisSerializer()
     *      判断这个类是否为空
     *      如果这个类为空----->把这个RedisSerializer初始化
     *  4.创建JdkSerializationRedisSerializer属于spring，并不属于jdk（必须要在spring配置加载完毕之后执行）
     *              通过类加载器把这个RedisSerializer进行初始化
     * @return : void
     * @author : yk
     * @date : 2020/07/10 15:48
     */
    @PostConstruct
    public void initRedisSerializer(){
        if (this.keySerializer == null){
                this.keySerializer = new JdkSerializationRedisSerializer(this.getClass().getClassLoader());
        }
    }

    @Autowired
    private JedisCluster jedisCluster;
    /**
     * @Description :
     * @param key
     * @param value
     * @param nxxx  是固定值，有两个值
     *                "nx":
     *                    如果redis中的key不存在，则就可以存储，如果redis中已经有这个key了，则不存数据
     *                "xx":
     *                    如果redis中的key存在，则直接覆盖，如果key不存在则不存
     * @param expx 值也是固定的
     *            只有两个值:
     *                ex:
     *                   失效时间的单位是秒
     *                px:
     *                   失效时间的单位是毫秒
     * @param seconds 失效时间
     * @return : java.lang.String
     * @author : yk
     * @date : 2020/07/10 15:51
     */
    public String set(String key, T value,String nxxx,String expx,Integer seconds){
        if (null != seconds && 0< seconds &&
                (EX.equals(expx)||PX.equals(expx))&&
                (XX.equals(nxxx)||NX.equals(nxxx))){
            //说明在存入数据的时候就必须要上失效时间了
            return jedisCluster.set(key, JSONUtils.toJsonString(value),nxxx,expx,seconds);
        }else {
            /*说明不需要设置失效时间
            * 但是仍然需要进一步去判断用户所传递的到底是nx还是xx*/
            if (NX.equals(nxxx)){
                return String.valueOf(jedisCluster.setnx(key,JSONUtils.toJsonString(value)));
            }else if (XX.equals(nxxx)){
                return jedisCluster.set(key,JSONUtils.toJsonString(value));
            }

        }
        return NO;
    }
    /**
     * @Description :设置失效时间
     * @param key
     * @param time
     * @return : java.lang.Long
     * @author : yk
     * @date : 2020/07/10 16:51
     */
    public Long setExpire(String key,Integer time){
        //判断key或者time在哪些情况不能设置失效时间
        if (key == null  || 0 >= time  ) {
            return Long.valueOf(NO);
        }
        return jedisCluster.expire(key,time);
    }
    /**
     * @Description : 设置失效时间（通用）
     * @param key
     * @param expx
     * @param time
     * @return : java.lang.Long
     * @author : yk
     * @date : 2020/07/10 16:51
     */
    public Long expire(String key,String expx,Integer time){
        if (null == time || 0 == time){
            return 0L;
        }
        if (EX.equals(expx)){
            /*失效单位为秒*/
            return jedisCluster.expire(key,time);
        }else if(PX.equals(expx)){
            /*失效单位为毫秒*/
            /*Long比integer要大，小转大不需要强转，但大转小需要强转*/
            Long millTime = Long.parseLong(String.valueOf(time));
            return jedisCluster.pexpire(key,millTime);
        }
        return 0L;
    }
    /**
     * @Description : 从redis中查询数据（单个数据）
     * @param key
     * @return : T
     * @author : yk
     * @date : 2020/07/10 16:11
     */
    public T getOne(String key){
        return (T)JSONUtils.toObject(jedisCluster.get(key),Object.class);
    }

    /**
     * @Description :从redis中查询数据(value值是字符串)
     * @param key
     * @return : java.lang.String
     * @author : yk
     * @date : 2020/07/10 16:12
     */
    public String getString(String key){
        return jedisCluster.get(key);
    }

    /**
     * @Description : 从redis中查询数据(集合数据)
     * @param key
     * @return : java.util.List<T>
     * @author : yk
     * @date : 2020/07/10 16:13
     */
    public List<T> getList(String key){
        return (List<T>)JSONUtils.toList(jedisCluster.get(key),Object.class);
    }

    /**
     * @Description : 删除单个数据
     * @param key
     * @return : java.lang.Long
     * @author : yk
     * @date : 2020/07/10 16:14
     */
    public Long delOne(Object key){
       /*思路：
       * 目前来说架构遇到的问题：
       *    封装redis的时候发现无法实现通用，因为JedisCluster只能接收String类型key值
       * 并不符合架构标准，最终可以把Object对象转换为字节数组来进行处理这个问题*/
       return jedisCluster.del(rawkey(key));
    }

    /**
     * @Description :删除多条数据
     * @param keys
     * @return : java.lang.Long
     * @author : yk
     * @date : 2020/07/10 16:34
     */
    public Long delMany(Collection<T> keys){
        if (CollectionUtils.isEmpty(keys)){
            return 0L;
        }else {
            byte[][] bytes = this.rawkeys(keys);
            return jedisCluster.del(bytes);
        }
    }
    /**
     * @Description :将object对象转换为字节数组
     * @param key
     * @return : byte[]
     * @author : yk
     * @date : 2020/07/10 16:25
     */
    private byte[] rawkey(Object key){
        /*if (key==null){
            System.out.println("key不存在");
            return null;
        }else {
            if (keySerializer == null && key instanceof byte[]){
                //直接转换
                return (byte[]) key;
            }else {
                //说明条件不满足，需要进行转换
                return keySerializer.serialize(key);
            }
        }*/


        //1.判断
        /*断言就是来判断用的
        * 如果key有值则会去执行下面的代码
        * 如果key没有，则直接return*/
        Assert.notNull(key, "non null key required");
        return this.keySerializer == null && key instanceof  byte[] ?
                (byte[]) key : this.keySerializer.serialize(key);
    }
    /**
     * @Description
     * @param keys
     * @return : byte[][]
     * @author : yk
     * @date : 2020/07/10 16:30
     */
    private byte[][] rawkeys(Collection<T> keys){
        //定义一个长度为集合长度的二维数组
        byte[][] rks = new byte[keys.size()][];

        //二维数组的下标，来进行存储数据用
        int i = 0;

        //因为keys是一个集合，泛型对象是Object，所以需要循环这个集合，把集合中的元素都要序列化
        Object key;

//       Iterator iterator =keys.iterator()------->因为Collection不一定是List，有可能是Map
/*        for (Iterator it:keys.iterator()
             ) {
            if (it.hasNext()){
                key = it.hasNext();
                把这个key进行序列化----->把Object对象序列化成字节数组
                rawkey(key);
            }
        }*/
        for (Iterator iterator = keys.iterator();iterator.hasNext();rks[i++] = this.rawkey(key)){
            //集合中的第一个元素
            key = iterator.next();
        }
        return rks;
    }
}
