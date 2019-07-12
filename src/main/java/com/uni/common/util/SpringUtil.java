package com.uni.common.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
* @Description Spring工具类
*
* @author Created by zc on 2019/6/12
*/
@Component
public class SpringUtil implements ApplicationContextAware {

    private static ApplicationContext ac;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (ac == null) {
            ac = applicationContext;
        }
    }

    /**
     * 获取applicationContext
     *
     * @author Created by zc on 2019/6/12
     */
    public static ApplicationContext getApplicationContext() {
        return ac;
    }

    /**
     * 通过name获取Bean
     *
     * @author Created by zc on 2019/6/12
     */
    public static Object getBean(String name) {
        return getApplicationContext().getBean(name);
    }

    /**
     * 通过class获取Bean
     *
     * @author Created by zc on 2019/6/12
     */
    public static <T> T getBean(Class<T> clazz) {
        return getApplicationContext().getBean(clazz);
    }

    /**
     * 通过name和Clazz返回指定的Bean
     *
     * @author Created by zc on 2019/6/12
     */
    public static <T> T getBean(String name, Class<T> clazz) {
        return getApplicationContext().getBean(name, clazz);
    }

}
