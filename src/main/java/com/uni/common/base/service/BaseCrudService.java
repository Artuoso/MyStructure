package com.uni.common.base.service;

import com.github.pagehelper.PageInfo;

/**
* @description 增删改查Service接口
*
* @author Created by zc on 2019/6/28
*/
public interface BaseCrudService<T> extends BaseService {

    /**
     * 根据主键查询单条数据
     *
     * @author Created by zc on 2019/6/28
     */
    T get(Long id);

    /**
     * 插入数据
     *
     * @author Created by zc on 2019/6/28
     */
    int insert(T entity);

    /**
     * 根据传入对象的主键更新数据
     *
     * @author Created by zc on 2019/6/28
     */
    int update(T entity);

    /**
     * 根据传入对象的主键更新部分数据
     *
     * @author Created by zc on 2019/7/2
     */
    int updatePartially(T entity);

    /**
     * 根据主键删除数据
     *
     * @author Created by zc on 2019/6/28
     */
    int delete(Long id);

    /**
     * 根据传入对象的主键删除数据
     *
     * @author Created by zc on 2019/6/28
     */
    int delete(T entity);

    /**
     * 分页查询
     *
     * @author Created by zc on 2019/7/28
     */
    PageInfo<T> listByPage(int pageNum, int pageSize);
}
