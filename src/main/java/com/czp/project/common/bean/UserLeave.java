package com.czp.project.common.bean;

import java.util.Date;

public class UserLeave {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_leave.id
     *
     * @mbg.generated Thu May 07 18:51:13 CST 2020
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_leave.start_time
     *
     * @mbg.generated Thu May 07 18:51:13 CST 2020
     */
    private Date startTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_leave.end_time
     *
     * @mbg.generated Thu May 07 18:51:13 CST 2020
     */
    private Date endTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_leave.state
     *
     * @mbg.generated Thu May 07 18:51:13 CST 2020
     */
    private Integer state;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_leave.reson
     *
     * @mbg.generated Thu May 07 18:51:13 CST 2020
     */
    private String reson;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_leave.time
     *
     * @mbg.generated Thu May 07 18:51:13 CST 2020
     */
    private Date time;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_leave.user_id
     *
     * @mbg.generated Thu May 07 18:51:13 CST 2020
     */
    private Integer userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_leave.user_manager
     *
     * @mbg.generated Thu May 07 18:51:13 CST 2020
     */
    private String userManager;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_leave.backup
     *
     * @mbg.generated Thu May 07 18:51:13 CST 2020
     */
    private String backup;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_leave.id
     *
     * @return the value of user_leave.id
     *
     * @mbg.generated Thu May 07 18:51:13 CST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_leave.id
     *
     * @param id the value for user_leave.id
     *
     * @mbg.generated Thu May 07 18:51:13 CST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_leave.start_time
     *
     * @return the value of user_leave.start_time
     *
     * @mbg.generated Thu May 07 18:51:13 CST 2020
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_leave.start_time
     *
     * @param startTime the value for user_leave.start_time
     *
     * @mbg.generated Thu May 07 18:51:13 CST 2020
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_leave.end_time
     *
     * @return the value of user_leave.end_time
     *
     * @mbg.generated Thu May 07 18:51:13 CST 2020
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_leave.end_time
     *
     * @param endTime the value for user_leave.end_time
     *
     * @mbg.generated Thu May 07 18:51:13 CST 2020
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_leave.state
     *
     * @return the value of user_leave.state
     *
     * @mbg.generated Thu May 07 18:51:13 CST 2020
     */
    public Integer getState() {
        return state;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_leave.state
     *
     * @param state the value for user_leave.state
     *
     * @mbg.generated Thu May 07 18:51:13 CST 2020
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_leave.reson
     *
     * @return the value of user_leave.reson
     *
     * @mbg.generated Thu May 07 18:51:13 CST 2020
     */
    public String getReson() {
        return reson;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_leave.reson
     *
     * @param reson the value for user_leave.reson
     *
     * @mbg.generated Thu May 07 18:51:13 CST 2020
     */
    public void setReson(String reson) {
        this.reson = reson == null ? null : reson.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_leave.time
     *
     * @return the value of user_leave.time
     *
     * @mbg.generated Thu May 07 18:51:13 CST 2020
     */
    public Date getTime() {
        return time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_leave.time
     *
     * @param time the value for user_leave.time
     *
     * @mbg.generated Thu May 07 18:51:13 CST 2020
     */
    public void setTime(Date time) {
        this.time = time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_leave.user_id
     *
     * @return the value of user_leave.user_id
     *
     * @mbg.generated Thu May 07 18:51:13 CST 2020
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_leave.user_id
     *
     * @param userId the value for user_leave.user_id
     *
     * @mbg.generated Thu May 07 18:51:13 CST 2020
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_leave.user_manager
     *
     * @return the value of user_leave.user_manager
     *
     * @mbg.generated Thu May 07 18:51:13 CST 2020
     */
    public String getUserManager() {
        return userManager;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_leave.user_manager
     *
     * @param userManager the value for user_leave.user_manager
     *
     * @mbg.generated Thu May 07 18:51:13 CST 2020
     */
    public void setUserManager(String userManager) {
        this.userManager = userManager == null ? null : userManager.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_leave.backup
     *
     * @return the value of user_leave.backup
     *
     * @mbg.generated Thu May 07 18:51:13 CST 2020
     */
    public String getBackup() {
        return backup;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_leave.backup
     *
     * @param backup the value for user_leave.backup
     *
     * @mbg.generated Thu May 07 18:51:13 CST 2020
     */
    public void setBackup(String backup) {
        this.backup = backup == null ? null : backup.trim();
    }

	@Override
	public String toString() {
		return "UserLeave [id=" + id + ", startTime=" + startTime + ", endTime=" + endTime + ", state=" + state
				+ ", reson=" + reson + ", time=" + time + ", userId=" + userId + ", userManager=" + userManager
				+ ", backup=" + backup + "]";
	}
    
}