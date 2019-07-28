package com.uni;

import com.github.pagehelper.PageInfo;
import com.uni.modules.demo.entity.DemoUser;
import com.uni.modules.demo.service.DemoUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class DemoTest {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private DemoUserService demoUserService;

    @Test
    public void testDemo() {
        DemoUser user = new DemoUser();
        user.setName("玄彩娥");
        user.setHaveSectFlag(DemoUser.HAVE_SECT_FLAG_YES);
        user.setSectName("普陀山");
        user.setRoundCount(36);

//        demoUserService.insert(user);
//        logger.debug("主键ID是：" + user.getId());

        DemoUser selectUser = demoUserService.get(5L);
        logger.debug("id：" + selectUser.getId() + " " + selectUser.getName() + " " + selectUser.getSectName());
//
//        selectUser.setSectName("方寸山");
//        demoUserService.update(selectUser);

//        DemoUser upUser = new DemoUser();
//        upUser.setId(2L);
//        upUser.setRoundCount(20);
//        demoUserService.updatePartially(upUser);

    }

    @Test
    public void testLog() {
        logger.trace("----这是trace");
        logger.debug("----这是debug");
        logger.info("----这是info");
        logger.warn("--这是warn");
        logger.error("----这是error");
    }

    /**
     * 分页测试
     *
     * @author Created by zc on 2019/7/28
     */
    @Test
    public void pageTest() {
        PageInfo<DemoUser> pageInfo = demoUserService.listByPage(2, 5);
        List<DemoUser> users = pageInfo.getList();
        for (DemoUser user : users) {
            logger.debug("id：" + user.getId() + " " + user.getName() + " " + user.getSectName());
        }
        logger.debug("总数：" + pageInfo.getTotal());
    }

}
