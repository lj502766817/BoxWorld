package com.osiris.character.dao;

import com.osiris.character.entity.Character;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 人物表(Character)表数据库访问层
 *
 * @author makejava
 * @since 2020-06-15 20:48:57
 */
public interface CharacterDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Character queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Character> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param character 实例对象
     * @return 对象列表
     */
    List<Character> queryAll(Character character);

    /**
     * 新增数据
     *
     * @param character 实例对象
     * @return 影响行数
     */
    int insert(Character character);

    /**
     * 修改数据
     *
     * @param character 实例对象
     * @return 影响行数
     */
    int update(Character character);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}