package com.uni.common.base.entity;

import java.util.Date;

/**
* @Description 数据实体基类
*
* @author Created by zc on 2019/6/28
*/
public abstract class BaseCrudEntity extends BaseEntity {

    /** id主键 */
    protected Long id;

    /** 创建时间 */
    protected Date createTime;

    /** 更新时间 */
    protected Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

}
