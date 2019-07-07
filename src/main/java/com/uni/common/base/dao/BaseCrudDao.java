package com.uni.common.base.dao;

/**
* @description 数据基础Dao接口
*
* @author Created by zc on 2019/6/28
*/
public interface BaseCrudDao<T> extends BaseDao {

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
     * 更新数据
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
     * 删除数据
     *
     * @author Created by zc on 2019/6/28
     */
    int delete(Long id);

    /**
     * 删除数据
     *
     * @author Created by zc on 2019/6/28
     */
    int delete(T entity);

}
