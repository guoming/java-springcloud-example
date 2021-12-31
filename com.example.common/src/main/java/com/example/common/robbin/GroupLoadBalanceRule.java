package com.example.common.robbin;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang.math.RandomUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.Server;
import org.springframework.beans.factory.annotation.Value;




/**
 * @author admin
 * @date 2020/12/17 10:27
 */
public class GroupLoadBalanceRule extends  AbstractLoadBalancerRule {
    @Value("${spring.cloud.consul.discovery.instanceZone}")
    private String zone;
    private static final Log log = LogFactory.getLog(GroupLoadBalanceRule.class);

    @Override
    public Server choose(Object key) {
        log.info("key is " + key);
        List<Server> servers = this.getLoadBalancer().getReachableServers();
        servers = servers.stream().filter(server -> zone.equals(server.getZone())).collect(Collectors.toList());;

        log.info("servers " + servers);
        if (servers.isEmpty()) {
            return null;
        }
        if (servers.size() == 1) {
            return servers.get(0);
        }
        return randomChoose(servers);
    }
    /**
     *
     * <p>随机返回一个服务实例 </p>
     * @param servers 服务列表
     */
    private Server randomChoose(List<Server> servers) {
        int randomIndex = RandomUtils.nextInt(servers.size());
        return servers.get(randomIndex);
    }

    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }
}