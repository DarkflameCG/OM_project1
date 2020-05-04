package com.czp.project.dao;

import com.czp.project.common.bean.OmWaichu;
import com.czp.project.common.bean.OmWaichuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OmWaichuMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oldman_waichu
     *
     * @mbg.generated Sun May 03 21:17:17 CST 2020
     */
    long countByExample(OmWaichuExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oldman_waichu
     *
     * @mbg.generated Sun May 03 21:17:17 CST 2020
     */
    int deleteByExample(OmWaichuExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oldman_waichu
     *
     * @mbg.generated Sun May 03 21:17:17 CST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oldman_waichu
     *
     * @mbg.generated Sun May 03 21:17:17 CST 2020
     */
    int insert(OmWaichu record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oldman_waichu
     *
     * @mbg.generated Sun May 03 21:17:17 CST 2020
     */
    int insertSelective(OmWaichu record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oldman_waichu
     *
     * @mbg.generated Sun May 03 21:17:17 CST 2020
     */
    List<OmWaichu> selectByExample(OmWaichuExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oldman_waichu
     *
     * @mbg.generated Sun May 03 21:17:17 CST 2020
     */
    OmWaichu selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oldman_waichu
     *
     * @mbg.generated Sun May 03 21:17:17 CST 2020
     */
    int updateByExampleSelective(@Param("record") OmWaichu record, @Param("example") OmWaichuExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oldman_waichu
     *
     * @mbg.generated Sun May 03 21:17:17 CST 2020
     */
    int updateByExample(@Param("record") OmWaichu record, @Param("example") OmWaichuExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oldman_waichu
     *
     * @mbg.generated Sun May 03 21:17:17 CST 2020
     */
    int updateByPrimaryKeySelective(OmWaichu record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oldman_waichu
     *
     * @mbg.generated Sun May 03 21:17:17 CST 2020
     */
    int updateByPrimaryKey(OmWaichu record);
}