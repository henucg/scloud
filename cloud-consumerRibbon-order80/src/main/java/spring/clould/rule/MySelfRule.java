package spring.clould.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author chenge
 * @Description
 *  Ribbon的自定义Rule不能放在被@CommentScan扫描的路径下，
 *  因为Application类中的@ApringApplication注解中包含@CommentScan注解，
 *  Application类所在的包都会被扫描，所以新开辟包spring.cloud.rule
 * @Date 2021/2/12 20:48
 */
@Configuration
public class MySelfRule {

    /**
     * @Description 自定义rule（随机）
     * @Param []
     * @return com.netflix.loadbalancer.IRule
     **/
    @Bean
    public IRule getIRule(){
        return new RandomRule();
    }
}
