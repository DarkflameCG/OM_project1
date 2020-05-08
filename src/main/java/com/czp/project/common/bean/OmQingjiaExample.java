package com.czp.project.common.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OmQingjiaExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table old_man_leave
     *
     * @mbg.generated Mon May 04 22:39:47 CST 2020
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table old_man_leave
     *
     * @mbg.generated Mon May 04 22:39:47 CST 2020
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table old_man_leave
     *
     * @mbg.generated Mon May 04 22:39:47 CST 2020
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table old_man_leave
     *
     * @mbg.generated Mon May 04 22:39:47 CST 2020
     */
    public OmQingjiaExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table old_man_leave
     *
     * @mbg.generated Mon May 04 22:39:47 CST 2020
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table old_man_leave
     *
     * @mbg.generated Mon May 04 22:39:47 CST 2020
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table old_man_leave
     *
     * @mbg.generated Mon May 04 22:39:47 CST 2020
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table old_man_leave
     *
     * @mbg.generated Mon May 04 22:39:47 CST 2020
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table old_man_leave
     *
     * @mbg.generated Mon May 04 22:39:47 CST 2020
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table old_man_leave
     *
     * @mbg.generated Mon May 04 22:39:47 CST 2020
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table old_man_leave
     *
     * @mbg.generated Mon May 04 22:39:47 CST 2020
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table old_man_leave
     *
     * @mbg.generated Mon May 04 22:39:47 CST 2020
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
     * This method corresponds to the database table old_man_leave
     *
     * @mbg.generated Mon May 04 22:39:47 CST 2020
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table old_man_leave
     *
     * @mbg.generated Mon May 04 22:39:47 CST 2020
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table old_man_leave
     *
     * @mbg.generated Mon May 04 22:39:47 CST 2020
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

        public Criteria andStartTimeIsNull() {
            addCriterion("start_time is null");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNotNull() {
            addCriterion("start_time is not null");
            return (Criteria) this;
        }

        public Criteria andStartTimeEqualTo(Date value) {
            addCriterion("start_time =", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotEqualTo(Date value) {
            addCriterion("start_time <>", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThan(Date value) {
            addCriterion("start_time >", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("start_time >=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThan(Date value) {
            addCriterion("start_time <", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("start_time <=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIn(List<Date> values) {
            addCriterion("start_time in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotIn(List<Date> values) {
            addCriterion("start_time not in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeBetween(Date value1, Date value2) {
            addCriterion("start_time between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("start_time not between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNull() {
            addCriterion("end_time is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("end_time is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(Date value) {
            addCriterion("end_time =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(Date value) {
            addCriterion("end_time <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(Date value) {
            addCriterion("end_time >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("end_time >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(Date value) {
            addCriterion("end_time <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("end_time <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<Date> values) {
            addCriterion("end_time in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<Date> values) {
            addCriterion("end_time not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(Date value1, Date value2) {
            addCriterion("end_time between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("end_time not between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(Integer value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(Integer value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(Integer value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(Integer value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(Integer value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<Integer> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<Integer> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(Integer value1, Integer value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(Integer value1, Integer value2) {
            addCriterion("state not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andOldmanIdIsNull() {
            addCriterion("oldman_id is null");
            return (Criteria) this;
        }

        public Criteria andOldmanIdIsNotNull() {
            addCriterion("oldman_id is not null");
            return (Criteria) this;
        }

        public Criteria andOldmanIdEqualTo(Integer value) {
            addCriterion("oldman_id =", value, "oldmanId");
            return (Criteria) this;
        }

        public Criteria andOldmanIdNotEqualTo(Integer value) {
            addCriterion("oldman_id <>", value, "oldmanId");
            return (Criteria) this;
        }

        public Criteria andOldmanIdGreaterThan(Integer value) {
            addCriterion("oldman_id >", value, "oldmanId");
            return (Criteria) this;
        }

        public Criteria andOldmanIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("oldman_id >=", value, "oldmanId");
            return (Criteria) this;
        }

        public Criteria andOldmanIdLessThan(Integer value) {
            addCriterion("oldman_id <", value, "oldmanId");
            return (Criteria) this;
        }

        public Criteria andOldmanIdLessThanOrEqualTo(Integer value) {
            addCriterion("oldman_id <=", value, "oldmanId");
            return (Criteria) this;
        }

        public Criteria andOldmanIdIn(List<Integer> values) {
            addCriterion("oldman_id in", values, "oldmanId");
            return (Criteria) this;
        }

        public Criteria andOldmanIdNotIn(List<Integer> values) {
            addCriterion("oldman_id not in", values, "oldmanId");
            return (Criteria) this;
        }

        public Criteria andOldmanIdBetween(Integer value1, Integer value2) {
            addCriterion("oldman_id between", value1, value2, "oldmanId");
            return (Criteria) this;
        }

        public Criteria andOldmanIdNotBetween(Integer value1, Integer value2) {
            addCriterion("oldman_id not between", value1, value2, "oldmanId");
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

        public Criteria andTimeIsNull() {
            addCriterion("time is null");
            return (Criteria) this;
        }

        public Criteria andTimeIsNotNull() {
            addCriterion("time is not null");
            return (Criteria) this;
        }

        public Criteria andTimeEqualTo(Date value) {
            addCriterion("time =", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotEqualTo(Date value) {
            addCriterion("time <>", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThan(Date value) {
            addCriterion("time >", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("time >=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThan(Date value) {
            addCriterion("time <", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThanOrEqualTo(Date value) {
            addCriterion("time <=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeIn(List<Date> values) {
            addCriterion("time in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotIn(List<Date> values) {
            addCriterion("time not in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeBetween(Date value1, Date value2) {
            addCriterion("time between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotBetween(Date value1, Date value2) {
            addCriterion("time not between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andBakcupIsNull() {
            addCriterion("bakcup is null");
            return (Criteria) this;
        }

        public Criteria andBakcupIsNotNull() {
            addCriterion("bakcup is not null");
            return (Criteria) this;
        }

        public Criteria andBakcupEqualTo(String value) {
            addCriterion("bakcup =", value, "bakcup");
            return (Criteria) this;
        }

        public Criteria andBakcupNotEqualTo(String value) {
            addCriterion("bakcup <>", value, "bakcup");
            return (Criteria) this;
        }

        public Criteria andBakcupGreaterThan(String value) {
            addCriterion("bakcup >", value, "bakcup");
            return (Criteria) this;
        }

        public Criteria andBakcupGreaterThanOrEqualTo(String value) {
            addCriterion("bakcup >=", value, "bakcup");
            return (Criteria) this;
        }

        public Criteria andBakcupLessThan(String value) {
            addCriterion("bakcup <", value, "bakcup");
            return (Criteria) this;
        }

        public Criteria andBakcupLessThanOrEqualTo(String value) {
            addCriterion("bakcup <=", value, "bakcup");
            return (Criteria) this;
        }

        public Criteria andBakcupLike(String value) {
            addCriterion("bakcup like", value, "bakcup");
            return (Criteria) this;
        }

        public Criteria andBakcupNotLike(String value) {
            addCriterion("bakcup not like", value, "bakcup");
            return (Criteria) this;
        }

        public Criteria andBakcupIn(List<String> values) {
            addCriterion("bakcup in", values, "bakcup");
            return (Criteria) this;
        }

        public Criteria andBakcupNotIn(List<String> values) {
            addCriterion("bakcup not in", values, "bakcup");
            return (Criteria) this;
        }

        public Criteria andBakcupBetween(String value1, String value2) {
            addCriterion("bakcup between", value1, value2, "bakcup");
            return (Criteria) this;
        }

        public Criteria andBakcupNotBetween(String value1, String value2) {
            addCriterion("bakcup not between", value1, value2, "bakcup");
            return (Criteria) this;
        }

        public Criteria andResonIsNull() {
            addCriterion("reson is null");
            return (Criteria) this;
        }

        public Criteria andResonIsNotNull() {
            addCriterion("reson is not null");
            return (Criteria) this;
        }

        public Criteria andResonEqualTo(String value) {
            addCriterion("reson =", value, "reson");
            return (Criteria) this;
        }

        public Criteria andResonNotEqualTo(String value) {
            addCriterion("reson <>", value, "reson");
            return (Criteria) this;
        }

        public Criteria andResonGreaterThan(String value) {
            addCriterion("reson >", value, "reson");
            return (Criteria) this;
        }

        public Criteria andResonGreaterThanOrEqualTo(String value) {
            addCriterion("reson >=", value, "reson");
            return (Criteria) this;
        }

        public Criteria andResonLessThan(String value) {
            addCriterion("reson <", value, "reson");
            return (Criteria) this;
        }

        public Criteria andResonLessThanOrEqualTo(String value) {
            addCriterion("reson <=", value, "reson");
            return (Criteria) this;
        }

        public Criteria andResonLike(String value) {
            addCriterion("reson like", value, "reson");
            return (Criteria) this;
        }

        public Criteria andResonNotLike(String value) {
            addCriterion("reson not like", value, "reson");
            return (Criteria) this;
        }

        public Criteria andResonIn(List<String> values) {
            addCriterion("reson in", values, "reson");
            return (Criteria) this;
        }

        public Criteria andResonNotIn(List<String> values) {
            addCriterion("reson not in", values, "reson");
            return (Criteria) this;
        }

        public Criteria andResonBetween(String value1, String value2) {
            addCriterion("reson between", value1, value2, "reson");
            return (Criteria) this;
        }

        public Criteria andResonNotBetween(String value1, String value2) {
            addCriterion("reson not between", value1, value2, "reson");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table old_man_leave
     *
     * @mbg.generated do_not_delete_during_merge Mon May 04 22:39:47 CST 2020
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table old_man_leave
     *
     * @mbg.generated Mon May 04 22:39:47 CST 2020
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