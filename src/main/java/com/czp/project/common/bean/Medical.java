package com.czp.project.common.bean;

import java.util.Date;

public class Medical {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column medical.id
     *
     * @mbg.generated Wed May 06 21:52:29 CST 2020
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column medical.isFamily
     *
     * @mbg.generated Wed May 06 21:52:29 CST 2020
     */
    private String isfamily;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column medical.isWorker
     *
     * @mbg.generated Wed May 06 21:52:29 CST 2020
     */
    private String isworker;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column medical.isCar
     *
     * @mbg.generated Wed May 06 21:52:29 CST 2020
     */
    private String iscar;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column medical.hospital
     *
     * @mbg.generated Wed May 06 21:52:29 CST 2020
     */
    private String hospital;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column medical.time
     *
     * @mbg.generated Wed May 06 21:52:29 CST 2020
     */
    private Date time;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column medical.old_man_id
     *
     * @mbg.generated Wed May 06 21:52:29 CST 2020
     */
    private Integer oldManId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column medical.user_log
     *
     * @mbg.generated Wed May 06 21:52:29 CST 2020
     */
    private String userLog;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column medical.backup
     *
     * @mbg.generated Wed May 06 21:52:29 CST 2020
     */
    private String backup;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column medical.id
     *
     * @return the value of medical.id
     *
     * @mbg.generated Wed May 06 21:52:29 CST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column medical.id
     *
     * @param id the value for medical.id
     *
     * @mbg.generated Wed May 06 21:52:29 CST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column medical.isFamily
     *
     * @return the value of medical.isFamily
     *
     * @mbg.generated Wed May 06 21:52:29 CST 2020
     */
    public String getIsfamily() {
        return isfamily;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column medical.isFamily
     *
     * @param isfamily the value for medical.isFamily
     *
     * @mbg.generated Wed May 06 21:52:29 CST 2020
     */
    public void setIsfamily(String isfamily) {
        this.isfamily = isfamily == null ? null : isfamily.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column medical.isWorker
     *
     * @return the value of medical.isWorker
     *
     * @mbg.generated Wed May 06 21:52:29 CST 2020
     */
    public String getIsworker() {
        return isworker;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column medical.isWorker
     *
     * @param isworker the value for medical.isWorker
     *
     * @mbg.generated Wed May 06 21:52:29 CST 2020
     */
    public void setIsworker(String isworker) {
        this.isworker = isworker == null ? null : isworker.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column medical.isCar
     *
     * @return the value of medical.isCar
     *
     * @mbg.generated Wed May 06 21:52:29 CST 2020
     */
    public String getIscar() {
        return iscar;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column medical.isCar
     *
     * @param iscar the value for medical.isCar
     *
     * @mbg.generated Wed May 06 21:52:29 CST 2020
     */
    public void setIscar(String iscar) {
        this.iscar = iscar == null ? null : iscar.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column medical.hospital
     *
     * @return the value of medical.hospital
     *
     * @mbg.generated Wed May 06 21:52:29 CST 2020
     */
    public String getHospital() {
        return hospital;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column medical.hospital
     *
     * @param hospital the value for medical.hospital
     *
     * @mbg.generated Wed May 06 21:52:29 CST 2020
     */
    public void setHospital(String hospital) {
        this.hospital = hospital == null ? null : hospital.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column medical.time
     *
     * @return the value of medical.time
     *
     * @mbg.generated Wed May 06 21:52:29 CST 2020
     */
    public Date getTime() {
        return time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column medical.time
     *
     * @param time the value for medical.time
     *
     * @mbg.generated Wed May 06 21:52:29 CST 2020
     */
    public void setTime(Date time) {
        this.time = time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column medical.old_man_id
     *
     * @return the value of medical.old_man_id
     *
     * @mbg.generated Wed May 06 21:52:29 CST 2020
     */
    public Integer getOldManId() {
        return oldManId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column medical.old_man_id
     *
     * @param oldManId the value for medical.old_man_id
     *
     * @mbg.generated Wed May 06 21:52:29 CST 2020
     */
    public void setOldManId(Integer oldManId) {
        this.oldManId = oldManId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column medical.user_log
     *
     * @return the value of medical.user_log
     *
     * @mbg.generated Wed May 06 21:52:29 CST 2020
     */
    public String getUserLog() {
        return userLog;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column medical.user_log
     *
     * @param userLog the value for medical.user_log
     *
     * @mbg.generated Wed May 06 21:52:29 CST 2020
     */
    public void setUserLog(String userLog) {
        this.userLog = userLog == null ? null : userLog.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column medical.backup
     *
     * @return the value of medical.backup
     *
     * @mbg.generated Wed May 06 21:52:29 CST 2020
     */
    public String getBackup() {
        return backup;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column medical.backup
     *
     * @param backup the value for medical.backup
     *
     * @mbg.generated Wed May 06 21:52:29 CST 2020
     */
    public void setBackup(String backup) {
        this.backup = backup == null ? null : backup.trim();
    }
}