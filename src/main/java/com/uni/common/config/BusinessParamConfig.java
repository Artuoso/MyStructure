package com.uni.common.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

/**
* @Description 获取在yml中配置的业务参数工具类
*
* @author Created by zc on 2019/6/12
*/
@Configuration
@ConfigurationProperties(prefix = "business")
public class BusinessParamConfig {

    /** 企业微信 */
    private Map<String, String> enterpriseWeChat;

    public Map<String, String> getEnterpriseWeChat() {
        return enterpriseWeChat;
    }

    public void setEnterpriseWeChat(Map<String, String> enterpriseWeChat) {
        this.enterpriseWeChat = enterpriseWeChat;
    }

    public String getToken() {
        return enterpriseWeChat.get("token");
    }

    public String getCorpID() {
        return enterpriseWeChat.get("corpID");
    }

    public String getEncodingAESKey() {
        return enterpriseWeChat.get("encodingAESKey");
    }
}
