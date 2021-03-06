package com.czp.project.common.bean;

import java.util.Date;

public class Account {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column account.id
     *
     * @mbg.generated Sat May 09 14:28:17 CST 2020
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column account.card_numb
     *
     * @mbg.generated Sat May 09 14:28:17 CST 2020
     */
    private Integer cardNumb;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column account.balance
     *
     * @mbg.generated Sat May 09 14:28:17 CST 2020
     */
    private Integer balance;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column account.oldman_id
     *
     * @mbg.generated Sat May 09 14:28:17 CST 2020
     */
    private Integer oldmanId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column account.family_name
     *
     * @mbg.generated Sat May 09 14:28:17 CST 2020
     */
    private String familyName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column account.user_id
     *
     * @mbg.generated Sat May 09 14:28:17 CST 2020
     */
    private Integer userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column account.account_date
     *
     * @mbg.generated Sat May 09 14:28:17 CST 2020
     */
    private Date accountDate;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column account.id
     *
     * @return the value of account.id
     *
     * @mbg.generated Sat May 09 14:28:17 CST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column account.id
     *
     * @param id the value for account.id
     *
     * @mbg.generated Sat May 09 14:28:17 CST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column account.card_numb
     *
     * @return the value of account.card_numb
     *
     * @mbg.generated Sat May 09 14:28:17 CST 2020
     */
    public Integer getCardNumb() {
        return cardNumb;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column account.card_numb
     *
     * @param cardNumb the value for account.card_numb
     *
     * @mbg.generated Sat May 09 14:28:17 CST 2020
     */
    public void setCardNumb(Integer cardNumb) {
        this.cardNumb = cardNumb;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column account.balance
     *
     * @return the value of account.balance
     *
     * @mbg.generated Sat May 09 14:28:17 CST 2020
     */
    public Integer getBalance() {
        return balance;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column account.balance
     *
     * @param balance the value for account.balance
     *
     * @mbg.generated Sat May 09 14:28:17 CST 2020
     */
    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column account.oldman_id
     *
     * @return the value of account.oldman_id
     *
     * @mbg.generated Sat May 09 14:28:17 CST 2020
     */
    public Integer getOldmanId() {
        return oldmanId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column account.oldman_id
     *
     * @param oldmanId the value for account.oldman_id
     *
     * @mbg.generated Sat May 09 14:28:17 CST 2020
     */
    public void setOldmanId(Integer oldmanId) {
        this.oldmanId = oldmanId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column account.family_name
     *
     * @return the value of account.family_name
     *
     * @mbg.generated Sat May 09 14:28:17 CST 2020
     */
    public String getFamilyName() {
        return familyName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column account.family_name
     *
     * @param familyName the value for account.family_name
     *
     * @mbg.generated Sat May 09 14:28:17 CST 2020
     */
    public void setFamilyName(String familyName) {
        this.familyName = familyName == null ? null : familyName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column account.user_id
     *
     * @return the value of account.user_id
     *
     * @mbg.generated Sat May 09 14:28:17 CST 2020
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column account.user_id
     *
     * @param userId the value for account.user_id
     *
     * @mbg.generated Sat May 09 14:28:17 CST 2020
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column account.account_date
     *
     * @return the value of account.account_date
     *
     * @mbg.generated Sat May 09 14:28:17 CST 2020
     */
    public Date getAccountDate() {
        return accountDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column account.account_date
     *
     * @param accountDate the value for account.account_date
     *
     * @mbg.generated Sat May 09 14:28:17 CST 2020
     */
    public void setAccountDate(Date accountDate) {
        this.accountDate = accountDate;
    }

	@Override
	public String toString() {
		return "Account [id=" + id + ", cardNumb=" + cardNumb + ", balance=" + balance + ", oldmanId=" + oldmanId
				+ ", familyName=" + familyName + ", userId=" + userId + ", accountDate=" + accountDate + "]";
	}
    
}