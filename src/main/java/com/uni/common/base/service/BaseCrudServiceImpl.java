package com.uni.common.base.service;

import com.uni.common.base.dao.BaseCrudDao;
import com.uni.common.base.entity.BaseCrudEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
* @Description 增删改查Service抽象实现类
*
* @author Created by zc on 2019/6/28
*/
public abstract class BaseCrudServiceImpl<D extends BaseCrudDao<T>, T extends BaseCrudEntity> implements BaseCrudService<T> {

    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    protected D dao;

    /**
     * 根据主键查询单条数据
     *
     * @param id
     * @author Created by zc on 2019/6/28
     */
    @Override
    public T get(Long id) {
        return dao.get(id);
    }

    /**
     * 插入数据
     *
     * @param entity
     * @author Created by zc on 2019/6/28
     */
    @Override
    @Transactional
    public int insert(T entity) {
        // 添加创建时间和更新时间
        entity.setCreateTime(new Date());
        entity.setUpdateTime(new Date());
        return dao.insert(entity);
    }

    /**
     * 更新数据
     *
     * @param entity
     * @author Created by zc on 2019/6/28
     */
    @Override
    @Transactional
    public int update(T entity) {
        // 添加更新时间
        entity.setUpdateTime(new Date());
        return dao.update(entity);
    }

    /**
     * 根据传入对象的主键更新部分数据
     *
     * @param entity
     * @author Created by zc on 2019/7/2
     */
    @Override
    public int updatePartially(T entity) {
        // 添加更新时间
        entity.setUpdateTime(new Date());
        return dao.updatePartially(entity);
    }

    /**
     * 删除数据
     *
     * @param id
     * @author Created by zc on 2019/6/28
     */
    @Override
    @Transactional
    public int delete(Long id) {
        return dao.delete(id);
    }

    /**
     * 删除数据
     *
     * @param entity
     * @author Created by zc on 2019/6/28
     */
    @Override
    @Transactional
    public int delete(T entity) {
        return dao.delete(entity);
    }
}