package com.czp.project.dao;

import com.czp.project.common.bean.Charges;
import com.czp.project.common.bean.ChargesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ChargesMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table charges
     *
     * @mbg.generated Mon Apr 27 20:58:09 CST 2020
     */
    long countByExample(ChargesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table charges
     *
     * @mbg.generated Mon Apr 27 20:58:09 CST 2020
     */
    int deleteByExample(ChargesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table charges
     *
     * @mbg.generated Mon Apr 27 20:58:09 CST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table charges
     *
     * @mbg.generated Mon Apr 27 20:58:09 CST 2020
     */
    int insert(Charges record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table charges
     *
     * @mbg.generated Mon Apr 27 20:58:09 CST 2020
     */
    int insertSelective(Charges record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table charges
     *
     * @mbg.generated Mon Apr 27 20:58:09 CST 2020
     */
    List<Charges> selectByExample(ChargesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table charges
     *
     * @mbg.generated Mon Apr 27 20:58:09 CST 2020
     */
    Charges selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table charges
     *
     * @mbg.generated Mon Apr 27 20:58:09 CST 2020
     */
    int updateByExampleSelective(@Param("record") Charges record, @Param("example") ChargesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table charges
     *
     * @mbg.generated Mon Apr 27 20:58:09 CST 2020
     */
    int updateByExample(@Param("record") Charges record, @Param("example") ChargesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table charges
     *
     * @mbg.generated Mon Apr 27 20:58:09 CST 2020
     */
    int updateByPrimaryKeySelective(Charges record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table charges
     *
     * @mbg.generated Mon Apr 27 20:58:09 CST 2020
     */
    int updateByPrimaryKey(Charges record);
}