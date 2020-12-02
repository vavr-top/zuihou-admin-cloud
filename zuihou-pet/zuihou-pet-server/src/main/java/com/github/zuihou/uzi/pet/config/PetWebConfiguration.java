package com.github.zuihou.uzi.pet.config;

import com.github.zuihou.boot.config.BaseConfig;
import org.springframework.context.annotation.Configuration;
import com.github.zuihou.oauth.api.LogApi;
import com.github.zuihou.log.event.SysLogListener;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;

/**
 * 柚子宠物码-Web配置
 *
 * @author zhaoyk
 * @date 2020-12-02
 */
@Configuration
public class PetWebConfiguration extends BaseConfig {

    /**
    * zuihou.log.enabled = true 并且 zuihou.log.type=DB时实例该类
    *
    * @param logApi
    * @return
    */
    @Bean
    @ConditionalOnExpression("${zuihou.log.enabled:true} && 'DB'.equals('${zuihou.log.type:LOGGER}')")
    public SysLogListener sysLogListener(LogApi logApi) {
        return new SysLogListener(logApi::save);
    }
}
