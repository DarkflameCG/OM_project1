package com.czp.project.common.bean;

import java.util.Date;

public class Cost {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cost.id
     *
     * @mbg.generated Sat Apr 11 20:55:49 CST 2020
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cost.money
     *
     * @mbg.generated Sat Apr 11 20:55:49 CST 2020
     */
    private Double money;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cost.pay_type
     *
     * @mbg.generated Sat Apr 11 20:55:49 CST 2020
     */
    private String payType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cost.index_id
     *
     * @mbg.generated Sat Apr 11 20:55:49 CST 2020
     */
    private Integer indexId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cost.oldMan_id
     *
     * @mbg.generated Sat Apr 11 20:55:49 CST 2020
     */
    private Integer oldmanId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cost.pay_time
     *
     * @mbg.generated Sat Apr 11 20:55:49 CST 2020
     */
    private Date payTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cost.user_id
     *
     * @mbg.generated Sat Apr 11 20:55:49 CST 2020
     */
    private Integer userId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cost.id
     *
     * @return the value of cost.id
     *
     * @mbg.generated Sat Apr 11 20:55:49 CST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cost.id
     *
     * @param id the value for cost.id
     *
     * @mbg.generated Sat Apr 11 20:55:49 CST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cost.money
     *
     * @return the value of cost.money
     *
     * @mbg.generated Sat Apr 11 20:55:49 CST 2020
     */
    public Double getMoney() {
        return money;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cost.money
     *
     * @param money the value for cost.money
     *
     * @mbg.generated Sat Apr 11 20:55:49 CST 2020
     */
    public void setMoney(Double money) {
        this.money = money;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cost.pay_type
     *
     * @return the value of cost.pay_type
     *
     * @mbg.generated Sat Apr 11 20:55:49 CST 2020
     */
    public String getPayType() {
        return payType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cost.pay_type
     *
     * @param payType the value for cost.pay_type
     *
     * @mbg.generated Sat Apr 11 20:55:49 CST 2020
     */
    public void setPayType(String payType) {
        this.payType = payType == null ? null : payType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cost.index_id
     *
     * @return the value of cost.index_id
     *
     * @mbg.generated Sat Apr 11 20:55:49 CST 2020
     */
    public Integer getIndexId() {
        return indexId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cost.index_id
     *
     * @param indexId the value for cost.index_id
     *
     * @mbg.generated Sat Apr 11 20:55:49 CST 2020
     */
    public void setIndexId(Integer indexId) {
        this.indexId = indexId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cost.oldMan_id
     *
     * @return the value of cost.oldMan_id
     *
     * @mbg.generated Sat Apr 11 20:55:49 CST 2020
     */
    public Integer getOldmanId() {
        return oldmanId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cost.oldMan_id
     *
     * @param oldmanId the value for cost.oldMan_id
     *
     * @mbg.generated Sat Apr 11 20:55:49 CST 2020
     */
    public void setOldmanId(Integer oldmanId) {
        this.oldmanId = oldmanId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cost.pay_time
     *
     * @return the value of cost.pay_time
     *
     * @mbg.generated Sat Apr 11 20:55:49 CST 2020
     */
    public Date getPayTime() {
        return payTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cost.pay_time
     *
     * @param payTime the value for cost.pay_time
     *
     * @mbg.generated Sat Apr 11 20:55:49 CST 2020
     */
    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cost.user_id
     *
     * @return the value of cost.user_id
     *
     * @mbg.generated Sat Apr 11 20:55:49 CST 2020
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cost.user_id
     *
     * @param userId the value for cost.user_id
     *
     * @mbg.generated Sat Apr 11 20:55:49 CST 2020
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

	@Override
	public String toString() {
		return "Cost [id=" + id + ", money=" + money + ", payType=" + payType + ", indexId=" + indexId + ", oldmanId="
				+ oldmanId + ", payTime=" + payTime + ", userId=" + userId + "]";
	}
    
}