package com.czp.project.dao;

import com.czp.project.common.bean.OldMan;
import com.czp.project.common.bean.OldManExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OldManMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table old_man
     *
     * @mbg.generated Tue Apr 28 20:55:12 CST 2020
     */
    long countByExample(OldManExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table old_man
     *
     * @mbg.generated Tue Apr 28 20:55:12 CST 2020
     */
    int deleteByExample(OldManExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table old_man
     *
     * @mbg.generated Tue Apr 28 20:55:12 CST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table old_man
     *
     * @mbg.generated Tue Apr 28 20:55:12 CST 2020
     */
    int insert(OldMan record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table old_man
     *
     * @mbg.generated Tue Apr 28 20:55:12 CST 2020
     */
    int insertSelective(OldMan record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table old_man
     *
     * @mbg.generated Tue Apr 28 20:55:12 CST 2020
     */
    List<OldMan> selectByExample(OldManExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table old_man
     *
     * @mbg.generated Tue Apr 28 20:55:12 CST 2020
     */
    OldMan selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table old_man
     *
     * @mbg.generated Tue Apr 28 20:55:12 CST 2020
     */
    int updateByExampleSelective(@Param("record") OldMan record, @Param("example") OldManExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table old_man
     *
     * @mbg.generated Tue Apr 28 20:55:12 CST 2020
     */
    int updateByExample(@Param("record") OldMan record, @Param("example") OldManExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table old_man
     *
     * @mbg.generated Tue Apr 28 20:55:12 CST 2020
     */
    int updateByPrimaryKeySelective(OldMan record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table old_man
     *
     * @mbg.generated Tue Apr 28 20:55:12 CST 2020
     */
    int updateByPrimaryKey(OldMan record);
}