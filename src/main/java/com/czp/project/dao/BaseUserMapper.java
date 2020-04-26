package com.czp.project.dao;

import com.czp.project.common.bean.BaseUser;
import com.czp.project.common.bean.BaseUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseUserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_user_info
     *
     * @mbg.generated Wed Jan 29 13:12:45 CST 2020
     */
    long countByExample(BaseUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_user_info
     *
     * @mbg.generated Wed Jan 29 13:12:45 CST 2020
     */
    int deleteByExample(BaseUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_user_info
     *
     * @mbg.generated Wed Jan 29 13:12:45 CST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_user_info
     *
     * @mbg.generated Wed Jan 29 13:12:45 CST 2020
     */
    int insert(BaseUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_user_info
     *
     * @mbg.generated Wed Jan 29 13:12:45 CST 2020
     */
    int insertSelective(BaseUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_user_info
     *
     * @mbg.generated Wed Jan 29 13:12:45 CST 2020
     */
    List<BaseUser> selectByExample(BaseUserExample example);
    //查找所有员工
  	 List<BaseUser> findAll(int curPage, int row) throws Exception;
  	public int getAllRows() throws Exception;
  	//批量删除
  	 public int deleteMany(String[] ids);
  	 //查询
  	List<BaseUser> selectByName(String name);
  	//验证用户名密码权限是否一致
  	BaseUser selectLogin(BaseUser baseUser);
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_user_info
     *
     * @mbg.generated Wed Jan 29 13:12:45 CST 2020
     */
    BaseUser selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_user_info
     *
     * @mbg.generated Wed Jan 29 13:12:45 CST 2020
     */
    int updateByExampleSelective(@Param("record") BaseUser record, @Param("example") BaseUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_user_info
     *
     * @mbg.generated Wed Jan 29 13:12:45 CST 2020
     */
    int updateByExample(@Param("record") BaseUser record, @Param("example") BaseUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_user_info
     *
     * @mbg.generated Wed Jan 29 13:12:45 CST 2020
     */
    int updateByPrimaryKeySelective(BaseUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_user_info
     *
     * @mbg.generated Wed Jan 29 13:12:45 CST 2020
     */
    int updateByPrimaryKey(BaseUser record);
    //更新oldman里面的护工id
      int updateByoldman(@Param("userId1")String userId1, @Param("userId2")int userId2);

}