package com.aaa.three.config;

import com.aaa.three.properties.RedisClusterProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;
import java.util.Set;

/**
 * @Param
 * @ClassName RedisClusterConfig
 * @Description redis的配置类
 * @Author yk
 * @Date 2020/7/10 0010 15:04
 * @Return
 **/
@Configuration
public class RedisClusterConfig {

    @Autowired
    private RedisClusterProperties redisClusterProperties;

    @Bean
    public JedisCluster getjedisCluster(){
        Set<HostAndPort> hostAndPortSet = new HashSet<HostAndPort>();

        //1.先连接上远程redis服务器（ip地址和端口号） 192.168.23.166:6380...
        String nodes = redisClusterProperties.getNodes();

        //2.分割nodes，以","进行分割["192.168.23.166:6380","192.168.23.166:6381"...]
        String[] split = nodes.split(",");

       //3.循环获取每一台服务器的ip和端口号
        for (String hostPort:split
             ) {
            //第一次循环（192.168.23.166:6380）
            //4. 再次分割，以":"为分隔符 ["192.168.23.166","6380"](这个数组的长度是固定的)
            String[] split1 = hostPort.split(":");
            HostAndPort hostAndPort = new HostAndPort(split1[0],Integer.parseInt(split1[1]));
            //为了防止循环时覆盖掉上次的循环结果，所以将结果存储进集合中
            hostAndPortSet.add(hostAndPort);
        }
            //hostAndPortSet中已经有了这六台服务器的ip地址和端口号
        //5.创建JedisCluster
        return new JedisCluster(hostAndPortSet,redisClusterProperties.getCommandTimeout(),redisClusterProperties.getMaxAttempts());
    }
}
