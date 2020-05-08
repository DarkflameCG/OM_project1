package com.czp.project.common.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class MedicalExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table medical
     *
     * @mbg.generated Wed May 06 21:52:29 CST 2020
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table medical
     *
     * @mbg.generated Wed May 06 21:52:29 CST 2020
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table medical
     *
     * @mbg.generated Wed May 06 21:52:29 CST 2020
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table medical
     *
     * @mbg.generated Wed May 06 21:52:29 CST 2020
     */
    public MedicalExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table medical
     *
     * @mbg.generated Wed May 06 21:52:29 CST 2020
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table medical
     *
     * @mbg.generated Wed May 06 21:52:29 CST 2020
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table medical
     *
     * @mbg.generated Wed May 06 21:52:29 CST 2020
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table medical
     *
     * @mbg.generated Wed May 06 21:52:29 CST 2020
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table medical
     *
     * @mbg.generated Wed May 06 21:52:29 CST 2020
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table medical
     *
     * @mbg.generated Wed May 06 21:52:29 CST 2020
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table medical
     *
     * @mbg.generated Wed May 06 21:52:29 CST 2020
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table medical
     *
     * @mbg.generated Wed May 06 21:52:29 CST 2020
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table medical
     *
     * @mbg.generated Wed May 06 21:52:29 CST 2020
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table medical
     *
     * @mbg.generated Wed May 06 21:52:29 CST 2020
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table medical
     *
     * @mbg.generated Wed May 06 21:52:29 CST 2020
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIsfamilyIsNull() {
            addCriterion("isFamily is null");
            return (Criteria) this;
        }

        public Criteria andIsfamilyIsNotNull() {
            addCriterion("isFamily is not null");
            return (Criteria) this;
        }

        public Criteria andIsfamilyEqualTo(String value) {
            addCriterion("isFamily =", value, "isfamily");
            return (Criteria) this;
        }

        public Criteria andIsfamilyNotEqualTo(String value) {
            addCriterion("isFamily <>", value, "isfamily");
            return (Criteria) this;
        }

        public Criteria andIsfamilyGreaterThan(String value) {
            addCriterion("isFamily >", value, "isfamily");
            return (Criteria) this;
        }

        public Criteria andIsfamilyGreaterThanOrEqualTo(String value) {
            addCriterion("isFamily >=", value, "isfamily");
            return (Criteria) this;
        }

        public Criteria andIsfamilyLessThan(String value) {
            addCriterion("isFamily <", value, "isfamily");
            return (Criteria) this;
        }

        public Criteria andIsfamilyLessThanOrEqualTo(String value) {
            addCriterion("isFamily <=", value, "isfamily");
            return (Criteria) this;
        }

        public Criteria andIsfamilyLike(String value) {
            addCriterion("isFamily like", value, "isfamily");
            return (Criteria) this;
        }

        public Criteria andIsfamilyNotLike(String value) {
            addCriterion("isFamily not like", value, "isfamily");
            return (Criteria) this;
        }

        public Criteria andIsfamilyIn(List<String> values) {
            addCriterion("isFamily in", values, "isfamily");
            return (Criteria) this;
        }

        public Criteria andIsfamilyNotIn(List<String> values) {
            addCriterion("isFamily not in", values, "isfamily");
            return (Criteria) this;
        }

        public Criteria andIsfamilyBetween(String value1, String value2) {
            addCriterion("isFamily between", value1, value2, "isfamily");
            return (Criteria) this;
        }

        public Criteria andIsfamilyNotBetween(String value1, String value2) {
            addCriterion("isFamily not between", value1, value2, "isfamily");
            return (Criteria) this;
        }

        public Criteria andIsworkerIsNull() {
            addCriterion("isWorker is null");
            return (Criteria) this;
        }

        public Criteria andIsworkerIsNotNull() {
            addCriterion("isWorker is not null");
            return (Criteria) this;
        }

        public Criteria andIsworkerEqualTo(String value) {
            addCriterion("isWorker =", value, "isworker");
            return (Criteria) this;
        }

        public Criteria andIsworkerNotEqualTo(String value) {
            addCriterion("isWorker <>", value, "isworker");
            return (Criteria) this;
        }

        public Criteria andIsworkerGreaterThan(String value) {
            addCriterion("isWorker >", value, "isworker");
            return (Criteria) this;
        }

        public Criteria andIsworkerGreaterThanOrEqualTo(String value) {
            addCriterion("isWorker >=", value, "isworker");
            return (Criteria) this;
        }

        public Criteria andIsworkerLessThan(String value) {
            addCriterion("isWorker <", value, "isworker");
            return (Criteria) this;
        }

        public Criteria andIsworkerLessThanOrEqualTo(String value) {
            addCriterion("isWorker <=", value, "isworker");
            return (Criteria) this;
        }

        public Criteria andIsworkerLike(String value) {
            addCriterion("isWorker like", value, "isworker");
            return (Criteria) this;
        }

        public Criteria andIsworkerNotLike(String value) {
            addCriterion("isWorker not like", value, "isworker");
            return (Criteria) this;
        }

        public Criteria andIsworkerIn(List<String> values) {
            addCriterion("isWorker in", values, "isworker");
            return (Criteria) this;
        }

        public Criteria andIsworkerNotIn(List<String> values) {
            addCriterion("isWorker not in", values, "isworker");
            return (Criteria) this;
        }

        public Criteria andIsworkerBetween(String value1, String value2) {
            addCriterion("isWorker between", value1, value2, "isworker");
            return (Criteria) this;
        }

        public Criteria andIsworkerNotBetween(String value1, String value2) {
            addCriterion("isWorker not between", value1, value2, "isworker");
            return (Criteria) this;
        }

        public Criteria andIscarIsNull() {
            addCriterion("isCar is null");
            return (Criteria) this;
        }

        public Criteria andIscarIsNotNull() {
            addCriterion("isCar is not null");
            return (Criteria) this;
        }

        public Criteria andIscarEqualTo(String value) {
            addCriterion("isCar =", value, "iscar");
            return (Criteria) this;
        }

        public Criteria andIscarNotEqualTo(String value) {
            addCriterion("isCar <>", value, "iscar");
            return (Criteria) this;
        }

        public Criteria andIscarGreaterThan(String value) {
            addCriterion("isCar >", value, "iscar");
            return (Criteria) this;
        }

        public Criteria andIscarGreaterThanOrEqualTo(String value) {
            addCriterion("isCar >=", value, "iscar");
            return (Criteria) this;
        }

        public Criteria andIscarLessThan(String value) {
            addCriterion("isCar <", value, "iscar");
            return (Criteria) this;
        }

        public Criteria andIscarLessThanOrEqualTo(String value) {
            addCriterion("isCar <=", value, "iscar");
            return (Criteria) this;
        }

        public Criteria andIscarLike(String value) {
            addCriterion("isCar like", value, "iscar");
            return (Criteria) this;
        }

        public Criteria andIscarNotLike(String value) {
            addCriterion("isCar not like", value, "iscar");
            return (Criteria) this;
        }

        public Criteria andIscarIn(List<String> values) {
            addCriterion("isCar in", values, "iscar");
            return (Criteria) this;
        }

        public Criteria andIscarNotIn(List<String> values) {
            addCriterion("isCar not in", values, "iscar");
            return (Criteria) this;
        }

        public Criteria andIscarBetween(String value1, String value2) {
            addCriterion("isCar between", value1, value2, "iscar");
            return (Criteria) this;
        }

        public Criteria andIscarNotBetween(String value1, String value2) {
            addCriterion("isCar not between", value1, value2, "iscar");
            return (Criteria) this;
        }

        public Criteria andHospitalIsNull() {
            addCriterion("hospital is null");
            return (Criteria) this;
        }

        public Criteria andHospitalIsNotNull() {
            addCriterion("hospital is not null");
            return (Criteria) this;
        }

        public Criteria andHospitalEqualTo(String value) {
            addCriterion("hospital =", value, "hospital");
            return (Criteria) this;
        }

        public Criteria andHospitalNotEqualTo(String value) {
            addCriterion("hospital <>", value, "hospital");
            return (Criteria) this;
        }

        public Criteria andHospitalGreaterThan(String value) {
            addCriterion("hospital >", value, "hospital");
            return (Criteria) this;
        }

        public Criteria andHospitalGreaterThanOrEqualTo(String value) {
            addCriterion("hospital >=", value, "hospital");
            return (Criteria) this;
        }

        public Criteria andHospitalLessThan(String value) {
            addCriterion("hospital <", value, "hospital");
            return (Criteria) this;
        }

        public Criteria andHospitalLessThanOrEqualTo(String value) {
            addCriterion("hospital <=", value, "hospital");
            return (Criteria) this;
        }

        public Criteria andHospitalLike(String value) {
            addCriterion("hospital like", value, "hospital");
            return (Criteria) this;
        }

        public Criteria andHospitalNotLike(String value) {
            addCriterion("hospital not like", value, "hospital");
            return (Criteria) this;
        }

        public Criteria andHospitalIn(List<String> values) {
            addCriterion("hospital in", values, "hospital");
            return (Criteria) this;
        }

        public Criteria andHospitalNotIn(List<String> values) {
            addCriterion("hospital not in", values, "hospital");
            return (Criteria) this;
        }

        public Criteria andHospitalBetween(String value1, String value2) {
            addCriterion("hospital between", value1, value2, "hospital");
            return (Criteria) this;
        }

        public Criteria andHospitalNotBetween(String value1, String value2) {
            addCriterion("hospital not between", value1, value2, "hospital");
            return (Criteria) this;
        }

        public Criteria andTimeIsNull() {
            addCriterion("time is null");
            return (Criteria) this;
        }

        public Criteria andTimeIsNotNull() {
            addCriterion("time is not null");
            return (Criteria) this;
        }

        public Criteria andTimeEqualTo(Date value) {
            addCriterionForJDBCDate("time =", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("time <>", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("time >", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("time >=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThan(Date value) {
            addCriterionForJDBCDate("time <", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("time <=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeIn(List<Date> values) {
            addCriterionForJDBCDate("time in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("time not in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("time between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("time not between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andOldManIdIsNull() {
            addCriterion("old_man_id is null");
            return (Criteria) this;
        }

        public Criteria andOldManIdIsNotNull() {
            addCriterion("old_man_id is not null");
            return (Criteria) this;
        }

        public Criteria andOldManIdEqualTo(Integer value) {
            addCriterion("old_man_id =", value, "oldManId");
            return (Criteria) this;
        }

        public Criteria andOldManIdNotEqualTo(Integer value) {
            addCriterion("old_man_id <>", value, "oldManId");
            return (Criteria) this;
        }

        public Criteria andOldManIdGreaterThan(Integer value) {
            addCriterion("old_man_id >", value, "oldManId");
            return (Criteria) this;
        }

        public Criteria andOldManIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("old_man_id >=", value, "oldManId");
            return (Criteria) this;
        }

        public Criteria andOldManIdLessThan(Integer value) {
            addCriterion("old_man_id <", value, "oldManId");
            return (Criteria) this;
        }

        public Criteria andOldManIdLessThanOrEqualTo(Integer value) {
            addCriterion("old_man_id <=", value, "oldManId");
            return (Criteria) this;
        }

        public Criteria andOldManIdIn(List<Integer> values) {
            addCriterion("old_man_id in", values, "oldManId");
            return (Criteria) this;
        }

        public Criteria andOldManIdNotIn(List<Integer> values) {
            addCriterion("old_man_id not in", values, "oldManId");
            return (Criteria) this;
        }

        public Criteria andOldManIdBetween(Integer value1, Integer value2) {
            addCriterion("old_man_id between", value1, value2, "oldManId");
            return (Criteria) this;
        }

        public Criteria andOldManIdNotBetween(Integer value1, Integer value2) {
            addCriterion("old_man_id not between", value1, value2, "oldManId");
            return (Criteria) this;
        }

        public Criteria andUserLogIsNull() {
            addCriterion("user_log is null");
            return (Criteria) this;
        }

        public Criteria andUserLogIsNotNull() {
            addCriterion("user_log is not null");
            return (Criteria) this;
        }

        public Criteria andUserLogEqualTo(String value) {
            addCriterion("user_log =", value, "userLog");
            return (Criteria) this;
        }

        public Criteria andUserLogNotEqualTo(String value) {
            addCriterion("user_log <>", value, "userLog");
            return (Criteria) this;
        }

        public Criteria andUserLogGreaterThan(String value) {
            addCriterion("user_log >", value, "userLog");
            return (Criteria) this;
        }

        public Criteria andUserLogGreaterThanOrEqualTo(String value) {
            addCriterion("user_log >=", value, "userLog");
            return (Criteria) this;
        }

        public Criteria andUserLogLessThan(String value) {
            addCriterion("user_log <", value, "userLog");
            return (Criteria) this;
        }

        public Criteria andUserLogLessThanOrEqualTo(String value) {
            addCriterion("user_log <=", value, "userLog");
            return (Criteria) this;
        }

        public Criteria andUserLogLike(String value) {
            addCriterion("user_log like", value, "userLog");
            return (Criteria) this;
        }

        public Criteria andUserLogNotLike(String value) {
            addCriterion("user_log not like", value, "userLog");
            return (Criteria) this;
        }

        public Criteria andUserLogIn(List<String> values) {
            addCriterion("user_log in", values, "userLog");
            return (Criteria) this;
        }

        public Criteria andUserLogNotIn(List<String> values) {
            addCriterion("user_log not in", values, "userLog");
            return (Criteria) this;
        }

        public Criteria andUserLogBetween(String value1, String value2) {
            addCriterion("user_log between", value1, value2, "userLog");
            return (Criteria) this;
        }

        public Criteria andUserLogNotBetween(String value1, String value2) {
            addCriterion("user_log not between", value1, value2, "userLog");
            return (Criteria) this;
        }

        public Criteria andBackupIsNull() {
            addCriterion("backup is null");
            return (Criteria) this;
        }

        public Criteria andBackupIsNotNull() {
            addCriterion("backup is not null");
            return (Criteria) this;
        }

        public Criteria andBackupEqualTo(String value) {
            addCriterion("backup =", value, "backup");
            return (Criteria) this;
        }

        public Criteria andBackupNotEqualTo(String value) {
            addCriterion("backup <>", value, "backup");
            return (Criteria) this;
        }

        public Criteria andBackupGreaterThan(String value) {
            addCriterion("backup >", value, "backup");
            return (Criteria) this;
        }

        public Criteria andBackupGreaterThanOrEqualTo(String value) {
            addCriterion("backup >=", value, "backup");
            return (Criteria) this;
        }

        public Criteria andBackupLessThan(String value) {
            addCriterion("backup <", value, "backup");
            return (Criteria) this;
        }

        public Criteria andBackupLessThanOrEqualTo(String value) {
            addCriterion("backup <=", value, "backup");
            return (Criteria) this;
        }

        public Criteria andBackupLike(String value) {
            addCriterion("backup like", value, "backup");
            return (Criteria) this;
        }

        public Criteria andBackupNotLike(String value) {
            addCriterion("backup not like", value, "backup");
            return (Criteria) this;
        }

        public Criteria andBackupIn(List<String> values) {
            addCriterion("backup in", values, "backup");
            return (Criteria) this;
        }

        public Criteria andBackupNotIn(List<String> values) {
            addCriterion("backup not in", values, "backup");
            return (Criteria) this;
        }

        public Criteria andBackupBetween(String value1, String value2) {
            addCriterion("backup between", value1, value2, "backup");
            return (Criteria) this;
        }

        public Criteria andBackupNotBetween(String value1, String value2) {
            addCriterion("backup not between", value1, value2, "backup");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table medical
     *
     * @mbg.generated do_not_delete_during_merge Wed May 06 21:52:29 CST 2020
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table medical
     *
     * @mbg.generated Wed May 06 21:52:29 CST 2020
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}