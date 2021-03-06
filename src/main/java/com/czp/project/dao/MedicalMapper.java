package com.czp.project.dao;

import com.czp.project.common.bean.Medical;
import com.czp.project.common.bean.MedicalExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MedicalMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table medical
     *
     * @mbg.generated Wed May 06 21:52:29 CST 2020
     */
    long countByExample(MedicalExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table medical
     *
     * @mbg.generated Wed May 06 21:52:29 CST 2020
     */
    int deleteByExample(MedicalExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table medical
     *
     * @mbg.generated Wed May 06 21:52:29 CST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table medical
     *
     * @mbg.generated Wed May 06 21:52:29 CST 2020
     */
    int insert(Medical record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table medical
     *
     * @mbg.generated Wed May 06 21:52:29 CST 2020
     */
    int insertSelective(Medical record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table medical
     *
     * @mbg.generated Wed May 06 21:52:29 CST 2020
     */
    List<Medical> selectByExample(MedicalExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table medical
     *
     * @mbg.generated Wed May 06 21:52:29 CST 2020
     */
    Medical selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table medical
     *
     * @mbg.generated Wed May 06 21:52:29 CST 2020
     */
    int updateByExampleSelective(@Param("record") Medical record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table medical
     *
     * @mbg.generated Wed May 06 21:52:29 CST 2020
     */
    int updateByExample(@Param("record") Medical record, @Param("example") MedicalExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table medical
     *
     * @mbg.generated Wed May 06 21:52:29 CST 2020
     */
    int updateByPrimaryKeySelective(Medical record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table medical
     *
     * @mbg.generated Wed May 06 21:52:29 CST 2020
     */
    int updateByPrimaryKey(Medical record);
}