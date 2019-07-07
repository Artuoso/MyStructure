package com.uni.modules.demo.entity;

import com.uni.common.base.entity.BaseCrudEntity;

import java.util.Date;

/**
 * @Description 示例entity
 *
 * @author Created by zc on 2019/7/5
 */
public class DemoUser extends BaseCrudEntity {

    private String name;

    private String haveSectFlag;

    private String sectName;

    private Integer roundCount;

    private Date createTime;

    private Date updateTime;

    // 有门派标识
    public static final String HAVE_SECT_FLAG_YES = "1";
    // 无门派标识
    public static final String HAVE_SECT_FLAG_NO = "0";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHaveSectFlag() {
        return haveSectFlag;
    }

    public void setHaveSectFlag(String haveSectFlag) {
        this.haveSectFlag = haveSectFlag;
    }

    public String getSectName() {
        return sectName;
    }

    public void setSectName(String sectName) {
        this.sectName = sectName;
    }

    public Integer getRoundCount() {
        return roundCount;
    }

    public void setRoundCount(Integer roundCount) {
        this.roundCount = roundCount;
    }

}