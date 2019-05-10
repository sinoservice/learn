package com.easyhome.po;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TbWorkOrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbWorkOrderExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

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

        public Criteria andFidIsNull() {
            addCriterion("FID is null");
            return (Criteria) this;
        }

        public Criteria andFidIsNotNull() {
            addCriterion("FID is not null");
            return (Criteria) this;
        }

        public Criteria andFidEqualTo(String value) {
            addCriterion("FID =", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidNotEqualTo(String value) {
            addCriterion("FID <>", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidGreaterThan(String value) {
            addCriterion("FID >", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidGreaterThanOrEqualTo(String value) {
            addCriterion("FID >=", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidLessThan(String value) {
            addCriterion("FID <", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidLessThanOrEqualTo(String value) {
            addCriterion("FID <=", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidLike(String value) {
            addCriterion("FID like", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidNotLike(String value) {
            addCriterion("FID not like", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidIn(List<String> values) {
            addCriterion("FID in", values, "fid");
            return (Criteria) this;
        }

        public Criteria andFidNotIn(List<String> values) {
            addCriterion("FID not in", values, "fid");
            return (Criteria) this;
        }

        public Criteria andFidBetween(String value1, String value2) {
            addCriterion("FID between", value1, value2, "fid");
            return (Criteria) this;
        }

        public Criteria andFidNotBetween(String value1, String value2) {
            addCriterion("FID not between", value1, value2, "fid");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNull() {
            addCriterion("ORDER_ID is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("ORDER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(String value) {
            addCriterion("ORDER_ID =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(String value) {
            addCriterion("ORDER_ID <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(String value) {
            addCriterion("ORDER_ID >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(String value) {
            addCriterion("ORDER_ID >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(String value) {
            addCriterion("ORDER_ID <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(String value) {
            addCriterion("ORDER_ID <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLike(String value) {
            addCriterion("ORDER_ID like", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotLike(String value) {
            addCriterion("ORDER_ID not like", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<String> values) {
            addCriterion("ORDER_ID in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<String> values) {
            addCriterion("ORDER_ID not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(String value1, String value2) {
            addCriterion("ORDER_ID between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(String value1, String value2) {
            addCriterion("ORDER_ID not between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andWorkNoIsNull() {
            addCriterion("WORK_NO is null");
            return (Criteria) this;
        }

        public Criteria andWorkNoIsNotNull() {
            addCriterion("WORK_NO is not null");
            return (Criteria) this;
        }

        public Criteria andWorkNoEqualTo(String value) {
            addCriterion("WORK_NO =", value, "workNo");
            return (Criteria) this;
        }

        public Criteria andWorkNoNotEqualTo(String value) {
            addCriterion("WORK_NO <>", value, "workNo");
            return (Criteria) this;
        }

        public Criteria andWorkNoGreaterThan(String value) {
            addCriterion("WORK_NO >", value, "workNo");
            return (Criteria) this;
        }

        public Criteria andWorkNoGreaterThanOrEqualTo(String value) {
            addCriterion("WORK_NO >=", value, "workNo");
            return (Criteria) this;
        }

        public Criteria andWorkNoLessThan(String value) {
            addCriterion("WORK_NO <", value, "workNo");
            return (Criteria) this;
        }

        public Criteria andWorkNoLessThanOrEqualTo(String value) {
            addCriterion("WORK_NO <=", value, "workNo");
            return (Criteria) this;
        }

        public Criteria andWorkNoLike(String value) {
            addCriterion("WORK_NO like", value, "workNo");
            return (Criteria) this;
        }

        public Criteria andWorkNoNotLike(String value) {
            addCriterion("WORK_NO not like", value, "workNo");
            return (Criteria) this;
        }

        public Criteria andWorkNoIn(List<String> values) {
            addCriterion("WORK_NO in", values, "workNo");
            return (Criteria) this;
        }

        public Criteria andWorkNoNotIn(List<String> values) {
            addCriterion("WORK_NO not in", values, "workNo");
            return (Criteria) this;
        }

        public Criteria andWorkNoBetween(String value1, String value2) {
            addCriterion("WORK_NO between", value1, value2, "workNo");
            return (Criteria) this;
        }

        public Criteria andWorkNoNotBetween(String value1, String value2) {
            addCriterion("WORK_NO not between", value1, value2, "workNo");
            return (Criteria) this;
        }

        public Criteria andSendDateIsNull() {
            addCriterion("SEND_DATE is null");
            return (Criteria) this;
        }

        public Criteria andSendDateIsNotNull() {
            addCriterion("SEND_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andSendDateEqualTo(Date value) {
            addCriterionForJDBCDate("SEND_DATE =", value, "sendDate");
            return (Criteria) this;
        }

        public Criteria andSendDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("SEND_DATE <>", value, "sendDate");
            return (Criteria) this;
        }

        public Criteria andSendDateGreaterThan(Date value) {
            addCriterionForJDBCDate("SEND_DATE >", value, "sendDate");
            return (Criteria) this;
        }

        public Criteria andSendDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("SEND_DATE >=", value, "sendDate");
            return (Criteria) this;
        }

        public Criteria andSendDateLessThan(Date value) {
            addCriterionForJDBCDate("SEND_DATE <", value, "sendDate");
            return (Criteria) this;
        }

        public Criteria andSendDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("SEND_DATE <=", value, "sendDate");
            return (Criteria) this;
        }

        public Criteria andSendDateIn(List<Date> values) {
            addCriterionForJDBCDate("SEND_DATE in", values, "sendDate");
            return (Criteria) this;
        }

        public Criteria andSendDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("SEND_DATE not in", values, "sendDate");
            return (Criteria) this;
        }

        public Criteria andSendDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("SEND_DATE between", value1, value2, "sendDate");
            return (Criteria) this;
        }

        public Criteria andSendDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("SEND_DATE not between", value1, value2, "sendDate");
            return (Criteria) this;
        }

        public Criteria andSenderIsNull() {
            addCriterion("SENDER is null");
            return (Criteria) this;
        }

        public Criteria andSenderIsNotNull() {
            addCriterion("SENDER is not null");
            return (Criteria) this;
        }

        public Criteria andSenderEqualTo(String value) {
            addCriterion("SENDER =", value, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderNotEqualTo(String value) {
            addCriterion("SENDER <>", value, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderGreaterThan(String value) {
            addCriterion("SENDER >", value, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderGreaterThanOrEqualTo(String value) {
            addCriterion("SENDER >=", value, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderLessThan(String value) {
            addCriterion("SENDER <", value, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderLessThanOrEqualTo(String value) {
            addCriterion("SENDER <=", value, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderLike(String value) {
            addCriterion("SENDER like", value, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderNotLike(String value) {
            addCriterion("SENDER not like", value, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderIn(List<String> values) {
            addCriterion("SENDER in", values, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderNotIn(List<String> values) {
            addCriterion("SENDER not in", values, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderBetween(String value1, String value2) {
            addCriterion("SENDER between", value1, value2, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderNotBetween(String value1, String value2) {
            addCriterion("SENDER not between", value1, value2, "sender");
            return (Criteria) this;
        }

        public Criteria andPlatFormIdIsNull() {
            addCriterion("PLAT_FORM_ID is null");
            return (Criteria) this;
        }

        public Criteria andPlatFormIdIsNotNull() {
            addCriterion("PLAT_FORM_ID is not null");
            return (Criteria) this;
        }

        public Criteria andPlatFormIdEqualTo(String value) {
            addCriterion("PLAT_FORM_ID =", value, "platFormId");
            return (Criteria) this;
        }

        public Criteria andPlatFormIdNotEqualTo(String value) {
            addCriterion("PLAT_FORM_ID <>", value, "platFormId");
            return (Criteria) this;
        }

        public Criteria andPlatFormIdGreaterThan(String value) {
            addCriterion("PLAT_FORM_ID >", value, "platFormId");
            return (Criteria) this;
        }

        public Criteria andPlatFormIdGreaterThanOrEqualTo(String value) {
            addCriterion("PLAT_FORM_ID >=", value, "platFormId");
            return (Criteria) this;
        }

        public Criteria andPlatFormIdLessThan(String value) {
            addCriterion("PLAT_FORM_ID <", value, "platFormId");
            return (Criteria) this;
        }

        public Criteria andPlatFormIdLessThanOrEqualTo(String value) {
            addCriterion("PLAT_FORM_ID <=", value, "platFormId");
            return (Criteria) this;
        }

        public Criteria andPlatFormIdLike(String value) {
            addCriterion("PLAT_FORM_ID like", value, "platFormId");
            return (Criteria) this;
        }

        public Criteria andPlatFormIdNotLike(String value) {
            addCriterion("PLAT_FORM_ID not like", value, "platFormId");
            return (Criteria) this;
        }

        public Criteria andPlatFormIdIn(List<String> values) {
            addCriterion("PLAT_FORM_ID in", values, "platFormId");
            return (Criteria) this;
        }

        public Criteria andPlatFormIdNotIn(List<String> values) {
            addCriterion("PLAT_FORM_ID not in", values, "platFormId");
            return (Criteria) this;
        }

        public Criteria andPlatFormIdBetween(String value1, String value2) {
            addCriterion("PLAT_FORM_ID between", value1, value2, "platFormId");
            return (Criteria) this;
        }

        public Criteria andPlatFormIdNotBetween(String value1, String value2) {
            addCriterion("PLAT_FORM_ID not between", value1, value2, "platFormId");
            return (Criteria) this;
        }

        public Criteria andPlatFormNameIsNull() {
            addCriterion("PLAT_FORM_NAME is null");
            return (Criteria) this;
        }

        public Criteria andPlatFormNameIsNotNull() {
            addCriterion("PLAT_FORM_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andPlatFormNameEqualTo(String value) {
            addCriterion("PLAT_FORM_NAME =", value, "platFormName");
            return (Criteria) this;
        }

        public Criteria andPlatFormNameNotEqualTo(String value) {
            addCriterion("PLAT_FORM_NAME <>", value, "platFormName");
            return (Criteria) this;
        }

        public Criteria andPlatFormNameGreaterThan(String value) {
            addCriterion("PLAT_FORM_NAME >", value, "platFormName");
            return (Criteria) this;
        }

        public Criteria andPlatFormNameGreaterThanOrEqualTo(String value) {
            addCriterion("PLAT_FORM_NAME >=", value, "platFormName");
            return (Criteria) this;
        }

        public Criteria andPlatFormNameLessThan(String value) {
            addCriterion("PLAT_FORM_NAME <", value, "platFormName");
            return (Criteria) this;
        }

        public Criteria andPlatFormNameLessThanOrEqualTo(String value) {
            addCriterion("PLAT_FORM_NAME <=", value, "platFormName");
            return (Criteria) this;
        }

        public Criteria andPlatFormNameLike(String value) {
            addCriterion("PLAT_FORM_NAME like", value, "platFormName");
            return (Criteria) this;
        }

        public Criteria andPlatFormNameNotLike(String value) {
            addCriterion("PLAT_FORM_NAME not like", value, "platFormName");
            return (Criteria) this;
        }

        public Criteria andPlatFormNameIn(List<String> values) {
            addCriterion("PLAT_FORM_NAME in", values, "platFormName");
            return (Criteria) this;
        }

        public Criteria andPlatFormNameNotIn(List<String> values) {
            addCriterion("PLAT_FORM_NAME not in", values, "platFormName");
            return (Criteria) this;
        }

        public Criteria andPlatFormNameBetween(String value1, String value2) {
            addCriterion("PLAT_FORM_NAME between", value1, value2, "platFormName");
            return (Criteria) this;
        }

        public Criteria andPlatFormNameNotBetween(String value1, String value2) {
            addCriterion("PLAT_FORM_NAME not between", value1, value2, "platFormName");
            return (Criteria) this;
        }

        public Criteria andFranchiseeIdIsNull() {
            addCriterion("FRANCHISEE_ID is null");
            return (Criteria) this;
        }

        public Criteria andFranchiseeIdIsNotNull() {
            addCriterion("FRANCHISEE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andFranchiseeIdEqualTo(String value) {
            addCriterion("FRANCHISEE_ID =", value, "franchiseeId");
            return (Criteria) this;
        }

        public Criteria andFranchiseeIdNotEqualTo(String value) {
            addCriterion("FRANCHISEE_ID <>", value, "franchiseeId");
            return (Criteria) this;
        }

        public Criteria andFranchiseeIdGreaterThan(String value) {
            addCriterion("FRANCHISEE_ID >", value, "franchiseeId");
            return (Criteria) this;
        }

        public Criteria andFranchiseeIdGreaterThanOrEqualTo(String value) {
            addCriterion("FRANCHISEE_ID >=", value, "franchiseeId");
            return (Criteria) this;
        }

        public Criteria andFranchiseeIdLessThan(String value) {
            addCriterion("FRANCHISEE_ID <", value, "franchiseeId");
            return (Criteria) this;
        }

        public Criteria andFranchiseeIdLessThanOrEqualTo(String value) {
            addCriterion("FRANCHISEE_ID <=", value, "franchiseeId");
            return (Criteria) this;
        }

        public Criteria andFranchiseeIdLike(String value) {
            addCriterion("FRANCHISEE_ID like", value, "franchiseeId");
            return (Criteria) this;
        }

        public Criteria andFranchiseeIdNotLike(String value) {
            addCriterion("FRANCHISEE_ID not like", value, "franchiseeId");
            return (Criteria) this;
        }

        public Criteria andFranchiseeIdIn(List<String> values) {
            addCriterion("FRANCHISEE_ID in", values, "franchiseeId");
            return (Criteria) this;
        }

        public Criteria andFranchiseeIdNotIn(List<String> values) {
            addCriterion("FRANCHISEE_ID not in", values, "franchiseeId");
            return (Criteria) this;
        }

        public Criteria andFranchiseeIdBetween(String value1, String value2) {
            addCriterion("FRANCHISEE_ID between", value1, value2, "franchiseeId");
            return (Criteria) this;
        }

        public Criteria andFranchiseeIdNotBetween(String value1, String value2) {
            addCriterion("FRANCHISEE_ID not between", value1, value2, "franchiseeId");
            return (Criteria) this;
        }

        public Criteria andMasterIdIsNull() {
            addCriterion("MASTER_ID is null");
            return (Criteria) this;
        }

        public Criteria andMasterIdIsNotNull() {
            addCriterion("MASTER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andMasterIdEqualTo(String value) {
            addCriterion("MASTER_ID =", value, "masterId");
            return (Criteria) this;
        }

        public Criteria andMasterIdNotEqualTo(String value) {
            addCriterion("MASTER_ID <>", value, "masterId");
            return (Criteria) this;
        }

        public Criteria andMasterIdGreaterThan(String value) {
            addCriterion("MASTER_ID >", value, "masterId");
            return (Criteria) this;
        }

        public Criteria andMasterIdGreaterThanOrEqualTo(String value) {
            addCriterion("MASTER_ID >=", value, "masterId");
            return (Criteria) this;
        }

        public Criteria andMasterIdLessThan(String value) {
            addCriterion("MASTER_ID <", value, "masterId");
            return (Criteria) this;
        }

        public Criteria andMasterIdLessThanOrEqualTo(String value) {
            addCriterion("MASTER_ID <=", value, "masterId");
            return (Criteria) this;
        }

        public Criteria andMasterIdLike(String value) {
            addCriterion("MASTER_ID like", value, "masterId");
            return (Criteria) this;
        }

        public Criteria andMasterIdNotLike(String value) {
            addCriterion("MASTER_ID not like", value, "masterId");
            return (Criteria) this;
        }

        public Criteria andMasterIdIn(List<String> values) {
            addCriterion("MASTER_ID in", values, "masterId");
            return (Criteria) this;
        }

        public Criteria andMasterIdNotIn(List<String> values) {
            addCriterion("MASTER_ID not in", values, "masterId");
            return (Criteria) this;
        }

        public Criteria andMasterIdBetween(String value1, String value2) {
            addCriterion("MASTER_ID between", value1, value2, "masterId");
            return (Criteria) this;
        }

        public Criteria andMasterIdNotBetween(String value1, String value2) {
            addCriterion("MASTER_ID not between", value1, value2, "masterId");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("STATUS is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(BigDecimal value) {
            addCriterion("STATUS =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(BigDecimal value) {
            addCriterion("STATUS <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(BigDecimal value) {
            addCriterion("STATUS >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("STATUS >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(BigDecimal value) {
            addCriterion("STATUS <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(BigDecimal value) {
            addCriterion("STATUS <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<BigDecimal> values) {
            addCriterion("STATUS in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<BigDecimal> values) {
            addCriterion("STATUS not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("STATUS between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("STATUS not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andGiveReasonsIsNull() {
            addCriterion("GIVE_REASONS is null");
            return (Criteria) this;
        }

        public Criteria andGiveReasonsIsNotNull() {
            addCriterion("GIVE_REASONS is not null");
            return (Criteria) this;
        }

        public Criteria andGiveReasonsEqualTo(String value) {
            addCriterion("GIVE_REASONS =", value, "giveReasons");
            return (Criteria) this;
        }

        public Criteria andGiveReasonsNotEqualTo(String value) {
            addCriterion("GIVE_REASONS <>", value, "giveReasons");
            return (Criteria) this;
        }

        public Criteria andGiveReasonsGreaterThan(String value) {
            addCriterion("GIVE_REASONS >", value, "giveReasons");
            return (Criteria) this;
        }

        public Criteria andGiveReasonsGreaterThanOrEqualTo(String value) {
            addCriterion("GIVE_REASONS >=", value, "giveReasons");
            return (Criteria) this;
        }

        public Criteria andGiveReasonsLessThan(String value) {
            addCriterion("GIVE_REASONS <", value, "giveReasons");
            return (Criteria) this;
        }

        public Criteria andGiveReasonsLessThanOrEqualTo(String value) {
            addCriterion("GIVE_REASONS <=", value, "giveReasons");
            return (Criteria) this;
        }

        public Criteria andGiveReasonsLike(String value) {
            addCriterion("GIVE_REASONS like", value, "giveReasons");
            return (Criteria) this;
        }

        public Criteria andGiveReasonsNotLike(String value) {
            addCriterion("GIVE_REASONS not like", value, "giveReasons");
            return (Criteria) this;
        }

        public Criteria andGiveReasonsIn(List<String> values) {
            addCriterion("GIVE_REASONS in", values, "giveReasons");
            return (Criteria) this;
        }

        public Criteria andGiveReasonsNotIn(List<String> values) {
            addCriterion("GIVE_REASONS not in", values, "giveReasons");
            return (Criteria) this;
        }

        public Criteria andGiveReasonsBetween(String value1, String value2) {
            addCriterion("GIVE_REASONS between", value1, value2, "giveReasons");
            return (Criteria) this;
        }

        public Criteria andGiveReasonsNotBetween(String value1, String value2) {
            addCriterion("GIVE_REASONS not between", value1, value2, "giveReasons");
            return (Criteria) this;
        }

        public Criteria andAmountIsNull() {
            addCriterion("AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andAmountIsNotNull() {
            addCriterion("AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andAmountEqualTo(BigDecimal value) {
            addCriterion("AMOUNT =", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotEqualTo(BigDecimal value) {
            addCriterion("AMOUNT <>", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThan(BigDecimal value) {
            addCriterion("AMOUNT >", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("AMOUNT >=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThan(BigDecimal value) {
            addCriterion("AMOUNT <", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("AMOUNT <=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountIn(List<BigDecimal> values) {
            addCriterion("AMOUNT in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotIn(List<BigDecimal> values) {
            addCriterion("AMOUNT not in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("AMOUNT between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("AMOUNT not between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andSingerIsNull() {
            addCriterion("SINGER is null");
            return (Criteria) this;
        }

        public Criteria andSingerIsNotNull() {
            addCriterion("SINGER is not null");
            return (Criteria) this;
        }

        public Criteria andSingerEqualTo(String value) {
            addCriterion("SINGER =", value, "singer");
            return (Criteria) this;
        }

        public Criteria andSingerNotEqualTo(String value) {
            addCriterion("SINGER <>", value, "singer");
            return (Criteria) this;
        }

        public Criteria andSingerGreaterThan(String value) {
            addCriterion("SINGER >", value, "singer");
            return (Criteria) this;
        }

        public Criteria andSingerGreaterThanOrEqualTo(String value) {
            addCriterion("SINGER >=", value, "singer");
            return (Criteria) this;
        }

        public Criteria andSingerLessThan(String value) {
            addCriterion("SINGER <", value, "singer");
            return (Criteria) this;
        }

        public Criteria andSingerLessThanOrEqualTo(String value) {
            addCriterion("SINGER <=", value, "singer");
            return (Criteria) this;
        }

        public Criteria andSingerLike(String value) {
            addCriterion("SINGER like", value, "singer");
            return (Criteria) this;
        }

        public Criteria andSingerNotLike(String value) {
            addCriterion("SINGER not like", value, "singer");
            return (Criteria) this;
        }

        public Criteria andSingerIn(List<String> values) {
            addCriterion("SINGER in", values, "singer");
            return (Criteria) this;
        }

        public Criteria andSingerNotIn(List<String> values) {
            addCriterion("SINGER not in", values, "singer");
            return (Criteria) this;
        }

        public Criteria andSingerBetween(String value1, String value2) {
            addCriterion("SINGER between", value1, value2, "singer");
            return (Criteria) this;
        }

        public Criteria andSingerNotBetween(String value1, String value2) {
            addCriterion("SINGER not between", value1, value2, "singer");
            return (Criteria) this;
        }

        public Criteria andSingTimeIsNull() {
            addCriterion("SING_TIME is null");
            return (Criteria) this;
        }

        public Criteria andSingTimeIsNotNull() {
            addCriterion("SING_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andSingTimeEqualTo(Date value) {
            addCriterionForJDBCDate("SING_TIME =", value, "singTime");
            return (Criteria) this;
        }

        public Criteria andSingTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("SING_TIME <>", value, "singTime");
            return (Criteria) this;
        }

        public Criteria andSingTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("SING_TIME >", value, "singTime");
            return (Criteria) this;
        }

        public Criteria andSingTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("SING_TIME >=", value, "singTime");
            return (Criteria) this;
        }

        public Criteria andSingTimeLessThan(Date value) {
            addCriterionForJDBCDate("SING_TIME <", value, "singTime");
            return (Criteria) this;
        }

        public Criteria andSingTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("SING_TIME <=", value, "singTime");
            return (Criteria) this;
        }

        public Criteria andSingTimeIn(List<Date> values) {
            addCriterionForJDBCDate("SING_TIME in", values, "singTime");
            return (Criteria) this;
        }

        public Criteria andSingTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("SING_TIME not in", values, "singTime");
            return (Criteria) this;
        }

        public Criteria andSingTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("SING_TIME between", value1, value2, "singTime");
            return (Criteria) this;
        }

        public Criteria andSingTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("SING_TIME not between", value1, value2, "singTime");
            return (Criteria) this;
        }

        public Criteria andServiceManIsNull() {
            addCriterion("SERVICE_MAN is null");
            return (Criteria) this;
        }

        public Criteria andServiceManIsNotNull() {
            addCriterion("SERVICE_MAN is not null");
            return (Criteria) this;
        }

        public Criteria andServiceManEqualTo(String value) {
            addCriterion("SERVICE_MAN =", value, "serviceMan");
            return (Criteria) this;
        }

        public Criteria andServiceManNotEqualTo(String value) {
            addCriterion("SERVICE_MAN <>", value, "serviceMan");
            return (Criteria) this;
        }

        public Criteria andServiceManGreaterThan(String value) {
            addCriterion("SERVICE_MAN >", value, "serviceMan");
            return (Criteria) this;
        }

        public Criteria andServiceManGreaterThanOrEqualTo(String value) {
            addCriterion("SERVICE_MAN >=", value, "serviceMan");
            return (Criteria) this;
        }

        public Criteria andServiceManLessThan(String value) {
            addCriterion("SERVICE_MAN <", value, "serviceMan");
            return (Criteria) this;
        }

        public Criteria andServiceManLessThanOrEqualTo(String value) {
            addCriterion("SERVICE_MAN <=", value, "serviceMan");
            return (Criteria) this;
        }

        public Criteria andServiceManLike(String value) {
            addCriterion("SERVICE_MAN like", value, "serviceMan");
            return (Criteria) this;
        }

        public Criteria andServiceManNotLike(String value) {
            addCriterion("SERVICE_MAN not like", value, "serviceMan");
            return (Criteria) this;
        }

        public Criteria andServiceManIn(List<String> values) {
            addCriterion("SERVICE_MAN in", values, "serviceMan");
            return (Criteria) this;
        }

        public Criteria andServiceManNotIn(List<String> values) {
            addCriterion("SERVICE_MAN not in", values, "serviceMan");
            return (Criteria) this;
        }

        public Criteria andServiceManBetween(String value1, String value2) {
            addCriterion("SERVICE_MAN between", value1, value2, "serviceMan");
            return (Criteria) this;
        }

        public Criteria andServiceManNotBetween(String value1, String value2) {
            addCriterion("SERVICE_MAN not between", value1, value2, "serviceMan");
            return (Criteria) this;
        }

        public Criteria andServiceFeedbackIsNull() {
            addCriterion("SERVICE_FEEDBACK is null");
            return (Criteria) this;
        }

        public Criteria andServiceFeedbackIsNotNull() {
            addCriterion("SERVICE_FEEDBACK is not null");
            return (Criteria) this;
        }

        public Criteria andServiceFeedbackEqualTo(String value) {
            addCriterion("SERVICE_FEEDBACK =", value, "serviceFeedback");
            return (Criteria) this;
        }

        public Criteria andServiceFeedbackNotEqualTo(String value) {
            addCriterion("SERVICE_FEEDBACK <>", value, "serviceFeedback");
            return (Criteria) this;
        }

        public Criteria andServiceFeedbackGreaterThan(String value) {
            addCriterion("SERVICE_FEEDBACK >", value, "serviceFeedback");
            return (Criteria) this;
        }

        public Criteria andServiceFeedbackGreaterThanOrEqualTo(String value) {
            addCriterion("SERVICE_FEEDBACK >=", value, "serviceFeedback");
            return (Criteria) this;
        }

        public Criteria andServiceFeedbackLessThan(String value) {
            addCriterion("SERVICE_FEEDBACK <", value, "serviceFeedback");
            return (Criteria) this;
        }

        public Criteria andServiceFeedbackLessThanOrEqualTo(String value) {
            addCriterion("SERVICE_FEEDBACK <=", value, "serviceFeedback");
            return (Criteria) this;
        }

        public Criteria andServiceFeedbackLike(String value) {
            addCriterion("SERVICE_FEEDBACK like", value, "serviceFeedback");
            return (Criteria) this;
        }

        public Criteria andServiceFeedbackNotLike(String value) {
            addCriterion("SERVICE_FEEDBACK not like", value, "serviceFeedback");
            return (Criteria) this;
        }

        public Criteria andServiceFeedbackIn(List<String> values) {
            addCriterion("SERVICE_FEEDBACK in", values, "serviceFeedback");
            return (Criteria) this;
        }

        public Criteria andServiceFeedbackNotIn(List<String> values) {
            addCriterion("SERVICE_FEEDBACK not in", values, "serviceFeedback");
            return (Criteria) this;
        }

        public Criteria andServiceFeedbackBetween(String value1, String value2) {
            addCriterion("SERVICE_FEEDBACK between", value1, value2, "serviceFeedback");
            return (Criteria) this;
        }

        public Criteria andServiceFeedbackNotBetween(String value1, String value2) {
            addCriterion("SERVICE_FEEDBACK not between", value1, value2, "serviceFeedback");
            return (Criteria) this;
        }

        public Criteria andCusNameIsNull() {
            addCriterion("CUS_NAME is null");
            return (Criteria) this;
        }

        public Criteria andCusNameIsNotNull() {
            addCriterion("CUS_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andCusNameEqualTo(String value) {
            addCriterion("CUS_NAME =", value, "cusName");
            return (Criteria) this;
        }

        public Criteria andCusNameNotEqualTo(String value) {
            addCriterion("CUS_NAME <>", value, "cusName");
            return (Criteria) this;
        }

        public Criteria andCusNameGreaterThan(String value) {
            addCriterion("CUS_NAME >", value, "cusName");
            return (Criteria) this;
        }

        public Criteria andCusNameGreaterThanOrEqualTo(String value) {
            addCriterion("CUS_NAME >=", value, "cusName");
            return (Criteria) this;
        }

        public Criteria andCusNameLessThan(String value) {
            addCriterion("CUS_NAME <", value, "cusName");
            return (Criteria) this;
        }

        public Criteria andCusNameLessThanOrEqualTo(String value) {
            addCriterion("CUS_NAME <=", value, "cusName");
            return (Criteria) this;
        }

        public Criteria andCusNameLike(String value) {
            addCriterion("CUS_NAME like", value, "cusName");
            return (Criteria) this;
        }

        public Criteria andCusNameNotLike(String value) {
            addCriterion("CUS_NAME not like", value, "cusName");
            return (Criteria) this;
        }

        public Criteria andCusNameIn(List<String> values) {
            addCriterion("CUS_NAME in", values, "cusName");
            return (Criteria) this;
        }

        public Criteria andCusNameNotIn(List<String> values) {
            addCriterion("CUS_NAME not in", values, "cusName");
            return (Criteria) this;
        }

        public Criteria andCusNameBetween(String value1, String value2) {
            addCriterion("CUS_NAME between", value1, value2, "cusName");
            return (Criteria) this;
        }

        public Criteria andCusNameNotBetween(String value1, String value2) {
            addCriterion("CUS_NAME not between", value1, value2, "cusName");
            return (Criteria) this;
        }

        public Criteria andCusAddressIsNull() {
            addCriterion("CUS_ADDRESS is null");
            return (Criteria) this;
        }

        public Criteria andCusAddressIsNotNull() {
            addCriterion("CUS_ADDRESS is not null");
            return (Criteria) this;
        }

        public Criteria andCusAddressEqualTo(String value) {
            addCriterion("CUS_ADDRESS =", value, "cusAddress");
            return (Criteria) this;
        }

        public Criteria andCusAddressNotEqualTo(String value) {
            addCriterion("CUS_ADDRESS <>", value, "cusAddress");
            return (Criteria) this;
        }

        public Criteria andCusAddressGreaterThan(String value) {
            addCriterion("CUS_ADDRESS >", value, "cusAddress");
            return (Criteria) this;
        }

        public Criteria andCusAddressGreaterThanOrEqualTo(String value) {
            addCriterion("CUS_ADDRESS >=", value, "cusAddress");
            return (Criteria) this;
        }

        public Criteria andCusAddressLessThan(String value) {
            addCriterion("CUS_ADDRESS <", value, "cusAddress");
            return (Criteria) this;
        }

        public Criteria andCusAddressLessThanOrEqualTo(String value) {
            addCriterion("CUS_ADDRESS <=", value, "cusAddress");
            return (Criteria) this;
        }

        public Criteria andCusAddressLike(String value) {
            addCriterion("CUS_ADDRESS like", value, "cusAddress");
            return (Criteria) this;
        }

        public Criteria andCusAddressNotLike(String value) {
            addCriterion("CUS_ADDRESS not like", value, "cusAddress");
            return (Criteria) this;
        }

        public Criteria andCusAddressIn(List<String> values) {
            addCriterion("CUS_ADDRESS in", values, "cusAddress");
            return (Criteria) this;
        }

        public Criteria andCusAddressNotIn(List<String> values) {
            addCriterion("CUS_ADDRESS not in", values, "cusAddress");
            return (Criteria) this;
        }

        public Criteria andCusAddressBetween(String value1, String value2) {
            addCriterion("CUS_ADDRESS between", value1, value2, "cusAddress");
            return (Criteria) this;
        }

        public Criteria andCusAddressNotBetween(String value1, String value2) {
            addCriterion("CUS_ADDRESS not between", value1, value2, "cusAddress");
            return (Criteria) this;
        }

        public Criteria andCusTelIsNull() {
            addCriterion("CUS_TEL is null");
            return (Criteria) this;
        }

        public Criteria andCusTelIsNotNull() {
            addCriterion("CUS_TEL is not null");
            return (Criteria) this;
        }

        public Criteria andCusTelEqualTo(String value) {
            addCriterion("CUS_TEL =", value, "cusTel");
            return (Criteria) this;
        }

        public Criteria andCusTelNotEqualTo(String value) {
            addCriterion("CUS_TEL <>", value, "cusTel");
            return (Criteria) this;
        }

        public Criteria andCusTelGreaterThan(String value) {
            addCriterion("CUS_TEL >", value, "cusTel");
            return (Criteria) this;
        }

        public Criteria andCusTelGreaterThanOrEqualTo(String value) {
            addCriterion("CUS_TEL >=", value, "cusTel");
            return (Criteria) this;
        }

        public Criteria andCusTelLessThan(String value) {
            addCriterion("CUS_TEL <", value, "cusTel");
            return (Criteria) this;
        }

        public Criteria andCusTelLessThanOrEqualTo(String value) {
            addCriterion("CUS_TEL <=", value, "cusTel");
            return (Criteria) this;
        }

        public Criteria andCusTelLike(String value) {
            addCriterion("CUS_TEL like", value, "cusTel");
            return (Criteria) this;
        }

        public Criteria andCusTelNotLike(String value) {
            addCriterion("CUS_TEL not like", value, "cusTel");
            return (Criteria) this;
        }

        public Criteria andCusTelIn(List<String> values) {
            addCriterion("CUS_TEL in", values, "cusTel");
            return (Criteria) this;
        }

        public Criteria andCusTelNotIn(List<String> values) {
            addCriterion("CUS_TEL not in", values, "cusTel");
            return (Criteria) this;
        }

        public Criteria andCusTelBetween(String value1, String value2) {
            addCriterion("CUS_TEL between", value1, value2, "cusTel");
            return (Criteria) this;
        }

        public Criteria andCusTelNotBetween(String value1, String value2) {
            addCriterion("CUS_TEL not between", value1, value2, "cusTel");
            return (Criteria) this;
        }

        public Criteria andSenderIdIsNull() {
            addCriterion("SENDER_ID is null");
            return (Criteria) this;
        }

        public Criteria andSenderIdIsNotNull() {
            addCriterion("SENDER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andSenderIdEqualTo(String value) {
            addCriterion("SENDER_ID =", value, "senderId");
            return (Criteria) this;
        }

        public Criteria andSenderIdNotEqualTo(String value) {
            addCriterion("SENDER_ID <>", value, "senderId");
            return (Criteria) this;
        }

        public Criteria andSenderIdGreaterThan(String value) {
            addCriterion("SENDER_ID >", value, "senderId");
            return (Criteria) this;
        }

        public Criteria andSenderIdGreaterThanOrEqualTo(String value) {
            addCriterion("SENDER_ID >=", value, "senderId");
            return (Criteria) this;
        }

        public Criteria andSenderIdLessThan(String value) {
            addCriterion("SENDER_ID <", value, "senderId");
            return (Criteria) this;
        }

        public Criteria andSenderIdLessThanOrEqualTo(String value) {
            addCriterion("SENDER_ID <=", value, "senderId");
            return (Criteria) this;
        }

        public Criteria andSenderIdLike(String value) {
            addCriterion("SENDER_ID like", value, "senderId");
            return (Criteria) this;
        }

        public Criteria andSenderIdNotLike(String value) {
            addCriterion("SENDER_ID not like", value, "senderId");
            return (Criteria) this;
        }

        public Criteria andSenderIdIn(List<String> values) {
            addCriterion("SENDER_ID in", values, "senderId");
            return (Criteria) this;
        }

        public Criteria andSenderIdNotIn(List<String> values) {
            addCriterion("SENDER_ID not in", values, "senderId");
            return (Criteria) this;
        }

        public Criteria andSenderIdBetween(String value1, String value2) {
            addCriterion("SENDER_ID between", value1, value2, "senderId");
            return (Criteria) this;
        }

        public Criteria andSenderIdNotBetween(String value1, String value2) {
            addCriterion("SENDER_ID not between", value1, value2, "senderId");
            return (Criteria) this;
        }

        public Criteria andServiceManIdIsNull() {
            addCriterion("SERVICE_MAN_ID is null");
            return (Criteria) this;
        }

        public Criteria andServiceManIdIsNotNull() {
            addCriterion("SERVICE_MAN_ID is not null");
            return (Criteria) this;
        }

        public Criteria andServiceManIdEqualTo(String value) {
            addCriterion("SERVICE_MAN_ID =", value, "serviceManId");
            return (Criteria) this;
        }

        public Criteria andServiceManIdNotEqualTo(String value) {
            addCriterion("SERVICE_MAN_ID <>", value, "serviceManId");
            return (Criteria) this;
        }

        public Criteria andServiceManIdGreaterThan(String value) {
            addCriterion("SERVICE_MAN_ID >", value, "serviceManId");
            return (Criteria) this;
        }

        public Criteria andServiceManIdGreaterThanOrEqualTo(String value) {
            addCriterion("SERVICE_MAN_ID >=", value, "serviceManId");
            return (Criteria) this;
        }

        public Criteria andServiceManIdLessThan(String value) {
            addCriterion("SERVICE_MAN_ID <", value, "serviceManId");
            return (Criteria) this;
        }

        public Criteria andServiceManIdLessThanOrEqualTo(String value) {
            addCriterion("SERVICE_MAN_ID <=", value, "serviceManId");
            return (Criteria) this;
        }

        public Criteria andServiceManIdLike(String value) {
            addCriterion("SERVICE_MAN_ID like", value, "serviceManId");
            return (Criteria) this;
        }

        public Criteria andServiceManIdNotLike(String value) {
            addCriterion("SERVICE_MAN_ID not like", value, "serviceManId");
            return (Criteria) this;
        }

        public Criteria andServiceManIdIn(List<String> values) {
            addCriterion("SERVICE_MAN_ID in", values, "serviceManId");
            return (Criteria) this;
        }

        public Criteria andServiceManIdNotIn(List<String> values) {
            addCriterion("SERVICE_MAN_ID not in", values, "serviceManId");
            return (Criteria) this;
        }

        public Criteria andServiceManIdBetween(String value1, String value2) {
            addCriterion("SERVICE_MAN_ID between", value1, value2, "serviceManId");
            return (Criteria) this;
        }

        public Criteria andServiceManIdNotBetween(String value1, String value2) {
            addCriterion("SERVICE_MAN_ID not between", value1, value2, "serviceManId");
            return (Criteria) this;
        }

        public Criteria andOrderSnIsNull() {
            addCriterion("ORDER_SN is null");
            return (Criteria) this;
        }

        public Criteria andOrderSnIsNotNull() {
            addCriterion("ORDER_SN is not null");
            return (Criteria) this;
        }

        public Criteria andOrderSnEqualTo(BigDecimal value) {
            addCriterion("ORDER_SN =", value, "orderSn");
            return (Criteria) this;
        }

        public Criteria andOrderSnNotEqualTo(BigDecimal value) {
            addCriterion("ORDER_SN <>", value, "orderSn");
            return (Criteria) this;
        }

        public Criteria andOrderSnGreaterThan(BigDecimal value) {
            addCriterion("ORDER_SN >", value, "orderSn");
            return (Criteria) this;
        }

        public Criteria andOrderSnGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ORDER_SN >=", value, "orderSn");
            return (Criteria) this;
        }

        public Criteria andOrderSnLessThan(BigDecimal value) {
            addCriterion("ORDER_SN <", value, "orderSn");
            return (Criteria) this;
        }

        public Criteria andOrderSnLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ORDER_SN <=", value, "orderSn");
            return (Criteria) this;
        }

        public Criteria andOrderSnIn(List<BigDecimal> values) {
            addCriterion("ORDER_SN in", values, "orderSn");
            return (Criteria) this;
        }

        public Criteria andOrderSnNotIn(List<BigDecimal> values) {
            addCriterion("ORDER_SN not in", values, "orderSn");
            return (Criteria) this;
        }

        public Criteria andOrderSnBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ORDER_SN between", value1, value2, "orderSn");
            return (Criteria) this;
        }

        public Criteria andOrderSnNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ORDER_SN not between", value1, value2, "orderSn");
            return (Criteria) this;
        }

        public Criteria andMasterNameIsNull() {
            addCriterion("MASTER_NAME is null");
            return (Criteria) this;
        }

        public Criteria andMasterNameIsNotNull() {
            addCriterion("MASTER_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andMasterNameEqualTo(String value) {
            addCriterion("MASTER_NAME =", value, "masterName");
            return (Criteria) this;
        }

        public Criteria andMasterNameNotEqualTo(String value) {
            addCriterion("MASTER_NAME <>", value, "masterName");
            return (Criteria) this;
        }

        public Criteria andMasterNameGreaterThan(String value) {
            addCriterion("MASTER_NAME >", value, "masterName");
            return (Criteria) this;
        }

        public Criteria andMasterNameGreaterThanOrEqualTo(String value) {
            addCriterion("MASTER_NAME >=", value, "masterName");
            return (Criteria) this;
        }

        public Criteria andMasterNameLessThan(String value) {
            addCriterion("MASTER_NAME <", value, "masterName");
            return (Criteria) this;
        }

        public Criteria andMasterNameLessThanOrEqualTo(String value) {
            addCriterion("MASTER_NAME <=", value, "masterName");
            return (Criteria) this;
        }

        public Criteria andMasterNameLike(String value) {
            addCriterion("MASTER_NAME like", value, "masterName");
            return (Criteria) this;
        }

        public Criteria andMasterNameNotLike(String value) {
            addCriterion("MASTER_NAME not like", value, "masterName");
            return (Criteria) this;
        }

        public Criteria andMasterNameIn(List<String> values) {
            addCriterion("MASTER_NAME in", values, "masterName");
            return (Criteria) this;
        }

        public Criteria andMasterNameNotIn(List<String> values) {
            addCriterion("MASTER_NAME not in", values, "masterName");
            return (Criteria) this;
        }

        public Criteria andMasterNameBetween(String value1, String value2) {
            addCriterion("MASTER_NAME between", value1, value2, "masterName");
            return (Criteria) this;
        }

        public Criteria andMasterNameNotBetween(String value1, String value2) {
            addCriterion("MASTER_NAME not between", value1, value2, "masterName");
            return (Criteria) this;
        }

        public Criteria andStatusDisplayIsNull() {
            addCriterion("STATUS_DISPLAY is null");
            return (Criteria) this;
        }

        public Criteria andStatusDisplayIsNotNull() {
            addCriterion("STATUS_DISPLAY is not null");
            return (Criteria) this;
        }

        public Criteria andStatusDisplayEqualTo(String value) {
            addCriterion("STATUS_DISPLAY =", value, "statusDisplay");
            return (Criteria) this;
        }

        public Criteria andStatusDisplayNotEqualTo(String value) {
            addCriterion("STATUS_DISPLAY <>", value, "statusDisplay");
            return (Criteria) this;
        }

        public Criteria andStatusDisplayGreaterThan(String value) {
            addCriterion("STATUS_DISPLAY >", value, "statusDisplay");
            return (Criteria) this;
        }

        public Criteria andStatusDisplayGreaterThanOrEqualTo(String value) {
            addCriterion("STATUS_DISPLAY >=", value, "statusDisplay");
            return (Criteria) this;
        }

        public Criteria andStatusDisplayLessThan(String value) {
            addCriterion("STATUS_DISPLAY <", value, "statusDisplay");
            return (Criteria) this;
        }

        public Criteria andStatusDisplayLessThanOrEqualTo(String value) {
            addCriterion("STATUS_DISPLAY <=", value, "statusDisplay");
            return (Criteria) this;
        }

        public Criteria andStatusDisplayLike(String value) {
            addCriterion("STATUS_DISPLAY like", value, "statusDisplay");
            return (Criteria) this;
        }

        public Criteria andStatusDisplayNotLike(String value) {
            addCriterion("STATUS_DISPLAY not like", value, "statusDisplay");
            return (Criteria) this;
        }

        public Criteria andStatusDisplayIn(List<String> values) {
            addCriterion("STATUS_DISPLAY in", values, "statusDisplay");
            return (Criteria) this;
        }

        public Criteria andStatusDisplayNotIn(List<String> values) {
            addCriterion("STATUS_DISPLAY not in", values, "statusDisplay");
            return (Criteria) this;
        }

        public Criteria andStatusDisplayBetween(String value1, String value2) {
            addCriterion("STATUS_DISPLAY between", value1, value2, "statusDisplay");
            return (Criteria) this;
        }

        public Criteria andStatusDisplayNotBetween(String value1, String value2) {
            addCriterion("STATUS_DISPLAY not between", value1, value2, "statusDisplay");
            return (Criteria) this;
        }

        public Criteria andFeedbackContentIsNull() {
            addCriterion("FEEDBACK_CONTENT is null");
            return (Criteria) this;
        }

        public Criteria andFeedbackContentIsNotNull() {
            addCriterion("FEEDBACK_CONTENT is not null");
            return (Criteria) this;
        }

        public Criteria andFeedbackContentEqualTo(String value) {
            addCriterion("FEEDBACK_CONTENT =", value, "feedbackContent");
            return (Criteria) this;
        }

        public Criteria andFeedbackContentNotEqualTo(String value) {
            addCriterion("FEEDBACK_CONTENT <>", value, "feedbackContent");
            return (Criteria) this;
        }

        public Criteria andFeedbackContentGreaterThan(String value) {
            addCriterion("FEEDBACK_CONTENT >", value, "feedbackContent");
            return (Criteria) this;
        }

        public Criteria andFeedbackContentGreaterThanOrEqualTo(String value) {
            addCriterion("FEEDBACK_CONTENT >=", value, "feedbackContent");
            return (Criteria) this;
        }

        public Criteria andFeedbackContentLessThan(String value) {
            addCriterion("FEEDBACK_CONTENT <", value, "feedbackContent");
            return (Criteria) this;
        }

        public Criteria andFeedbackContentLessThanOrEqualTo(String value) {
            addCriterion("FEEDBACK_CONTENT <=", value, "feedbackContent");
            return (Criteria) this;
        }

        public Criteria andFeedbackContentLike(String value) {
            addCriterion("FEEDBACK_CONTENT like", value, "feedbackContent");
            return (Criteria) this;
        }

        public Criteria andFeedbackContentNotLike(String value) {
            addCriterion("FEEDBACK_CONTENT not like", value, "feedbackContent");
            return (Criteria) this;
        }

        public Criteria andFeedbackContentIn(List<String> values) {
            addCriterion("FEEDBACK_CONTENT in", values, "feedbackContent");
            return (Criteria) this;
        }

        public Criteria andFeedbackContentNotIn(List<String> values) {
            addCriterion("FEEDBACK_CONTENT not in", values, "feedbackContent");
            return (Criteria) this;
        }

        public Criteria andFeedbackContentBetween(String value1, String value2) {
            addCriterion("FEEDBACK_CONTENT between", value1, value2, "feedbackContent");
            return (Criteria) this;
        }

        public Criteria andFeedbackContentNotBetween(String value1, String value2) {
            addCriterion("FEEDBACK_CONTENT not between", value1, value2, "feedbackContent");
            return (Criteria) this;
        }

        public Criteria andInstallLinkPhoneIsNull() {
            addCriterion("INSTALL_LINK_PHONE is null");
            return (Criteria) this;
        }

        public Criteria andInstallLinkPhoneIsNotNull() {
            addCriterion("INSTALL_LINK_PHONE is not null");
            return (Criteria) this;
        }

        public Criteria andInstallLinkPhoneEqualTo(String value) {
            addCriterion("INSTALL_LINK_PHONE =", value, "installLinkPhone");
            return (Criteria) this;
        }

        public Criteria andInstallLinkPhoneNotEqualTo(String value) {
            addCriterion("INSTALL_LINK_PHONE <>", value, "installLinkPhone");
            return (Criteria) this;
        }

        public Criteria andInstallLinkPhoneGreaterThan(String value) {
            addCriterion("INSTALL_LINK_PHONE >", value, "installLinkPhone");
            return (Criteria) this;
        }

        public Criteria andInstallLinkPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("INSTALL_LINK_PHONE >=", value, "installLinkPhone");
            return (Criteria) this;
        }

        public Criteria andInstallLinkPhoneLessThan(String value) {
            addCriterion("INSTALL_LINK_PHONE <", value, "installLinkPhone");
            return (Criteria) this;
        }

        public Criteria andInstallLinkPhoneLessThanOrEqualTo(String value) {
            addCriterion("INSTALL_LINK_PHONE <=", value, "installLinkPhone");
            return (Criteria) this;
        }

        public Criteria andInstallLinkPhoneLike(String value) {
            addCriterion("INSTALL_LINK_PHONE like", value, "installLinkPhone");
            return (Criteria) this;
        }

        public Criteria andInstallLinkPhoneNotLike(String value) {
            addCriterion("INSTALL_LINK_PHONE not like", value, "installLinkPhone");
            return (Criteria) this;
        }

        public Criteria andInstallLinkPhoneIn(List<String> values) {
            addCriterion("INSTALL_LINK_PHONE in", values, "installLinkPhone");
            return (Criteria) this;
        }

        public Criteria andInstallLinkPhoneNotIn(List<String> values) {
            addCriterion("INSTALL_LINK_PHONE not in", values, "installLinkPhone");
            return (Criteria) this;
        }

        public Criteria andInstallLinkPhoneBetween(String value1, String value2) {
            addCriterion("INSTALL_LINK_PHONE between", value1, value2, "installLinkPhone");
            return (Criteria) this;
        }

        public Criteria andInstallLinkPhoneNotBetween(String value1, String value2) {
            addCriterion("INSTALL_LINK_PHONE not between", value1, value2, "installLinkPhone");
            return (Criteria) this;
        }

        public Criteria andInstallLinkManIsNull() {
            addCriterion("INSTALL_LINK_MAN is null");
            return (Criteria) this;
        }

        public Criteria andInstallLinkManIsNotNull() {
            addCriterion("INSTALL_LINK_MAN is not null");
            return (Criteria) this;
        }

        public Criteria andInstallLinkManEqualTo(String value) {
            addCriterion("INSTALL_LINK_MAN =", value, "installLinkMan");
            return (Criteria) this;
        }

        public Criteria andInstallLinkManNotEqualTo(String value) {
            addCriterion("INSTALL_LINK_MAN <>", value, "installLinkMan");
            return (Criteria) this;
        }

        public Criteria andInstallLinkManGreaterThan(String value) {
            addCriterion("INSTALL_LINK_MAN >", value, "installLinkMan");
            return (Criteria) this;
        }

        public Criteria andInstallLinkManGreaterThanOrEqualTo(String value) {
            addCriterion("INSTALL_LINK_MAN >=", value, "installLinkMan");
            return (Criteria) this;
        }

        public Criteria andInstallLinkManLessThan(String value) {
            addCriterion("INSTALL_LINK_MAN <", value, "installLinkMan");
            return (Criteria) this;
        }

        public Criteria andInstallLinkManLessThanOrEqualTo(String value) {
            addCriterion("INSTALL_LINK_MAN <=", value, "installLinkMan");
            return (Criteria) this;
        }

        public Criteria andInstallLinkManLike(String value) {
            addCriterion("INSTALL_LINK_MAN like", value, "installLinkMan");
            return (Criteria) this;
        }

        public Criteria andInstallLinkManNotLike(String value) {
            addCriterion("INSTALL_LINK_MAN not like", value, "installLinkMan");
            return (Criteria) this;
        }

        public Criteria andInstallLinkManIn(List<String> values) {
            addCriterion("INSTALL_LINK_MAN in", values, "installLinkMan");
            return (Criteria) this;
        }

        public Criteria andInstallLinkManNotIn(List<String> values) {
            addCriterion("INSTALL_LINK_MAN not in", values, "installLinkMan");
            return (Criteria) this;
        }

        public Criteria andInstallLinkManBetween(String value1, String value2) {
            addCriterion("INSTALL_LINK_MAN between", value1, value2, "installLinkMan");
            return (Criteria) this;
        }

        public Criteria andInstallLinkManNotBetween(String value1, String value2) {
            addCriterion("INSTALL_LINK_MAN not between", value1, value2, "installLinkMan");
            return (Criteria) this;
        }

        public Criteria andFeedbackTimeIsNull() {
            addCriterion("FEEDBACK_TIME is null");
            return (Criteria) this;
        }

        public Criteria andFeedbackTimeIsNotNull() {
            addCriterion("FEEDBACK_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andFeedbackTimeEqualTo(Date value) {
            addCriterionForJDBCDate("FEEDBACK_TIME =", value, "feedbackTime");
            return (Criteria) this;
        }

        public Criteria andFeedbackTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("FEEDBACK_TIME <>", value, "feedbackTime");
            return (Criteria) this;
        }

        public Criteria andFeedbackTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("FEEDBACK_TIME >", value, "feedbackTime");
            return (Criteria) this;
        }

        public Criteria andFeedbackTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("FEEDBACK_TIME >=", value, "feedbackTime");
            return (Criteria) this;
        }

        public Criteria andFeedbackTimeLessThan(Date value) {
            addCriterionForJDBCDate("FEEDBACK_TIME <", value, "feedbackTime");
            return (Criteria) this;
        }

        public Criteria andFeedbackTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("FEEDBACK_TIME <=", value, "feedbackTime");
            return (Criteria) this;
        }

        public Criteria andFeedbackTimeIn(List<Date> values) {
            addCriterionForJDBCDate("FEEDBACK_TIME in", values, "feedbackTime");
            return (Criteria) this;
        }

        public Criteria andFeedbackTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("FEEDBACK_TIME not in", values, "feedbackTime");
            return (Criteria) this;
        }

        public Criteria andFeedbackTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("FEEDBACK_TIME between", value1, value2, "feedbackTime");
            return (Criteria) this;
        }

        public Criteria andFeedbackTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("FEEDBACK_TIME not between", value1, value2, "feedbackTime");
            return (Criteria) this;
        }

        public Criteria andFeedbackManIsNull() {
            addCriterion("FEEDBACK_MAN is null");
            return (Criteria) this;
        }

        public Criteria andFeedbackManIsNotNull() {
            addCriterion("FEEDBACK_MAN is not null");
            return (Criteria) this;
        }

        public Criteria andFeedbackManEqualTo(String value) {
            addCriterion("FEEDBACK_MAN =", value, "feedbackMan");
            return (Criteria) this;
        }

        public Criteria andFeedbackManNotEqualTo(String value) {
            addCriterion("FEEDBACK_MAN <>", value, "feedbackMan");
            return (Criteria) this;
        }

        public Criteria andFeedbackManGreaterThan(String value) {
            addCriterion("FEEDBACK_MAN >", value, "feedbackMan");
            return (Criteria) this;
        }

        public Criteria andFeedbackManGreaterThanOrEqualTo(String value) {
            addCriterion("FEEDBACK_MAN >=", value, "feedbackMan");
            return (Criteria) this;
        }

        public Criteria andFeedbackManLessThan(String value) {
            addCriterion("FEEDBACK_MAN <", value, "feedbackMan");
            return (Criteria) this;
        }

        public Criteria andFeedbackManLessThanOrEqualTo(String value) {
            addCriterion("FEEDBACK_MAN <=", value, "feedbackMan");
            return (Criteria) this;
        }

        public Criteria andFeedbackManLike(String value) {
            addCriterion("FEEDBACK_MAN like", value, "feedbackMan");
            return (Criteria) this;
        }

        public Criteria andFeedbackManNotLike(String value) {
            addCriterion("FEEDBACK_MAN not like", value, "feedbackMan");
            return (Criteria) this;
        }

        public Criteria andFeedbackManIn(List<String> values) {
            addCriterion("FEEDBACK_MAN in", values, "feedbackMan");
            return (Criteria) this;
        }

        public Criteria andFeedbackManNotIn(List<String> values) {
            addCriterion("FEEDBACK_MAN not in", values, "feedbackMan");
            return (Criteria) this;
        }

        public Criteria andFeedbackManBetween(String value1, String value2) {
            addCriterion("FEEDBACK_MAN between", value1, value2, "feedbackMan");
            return (Criteria) this;
        }

        public Criteria andFeedbackManNotBetween(String value1, String value2) {
            addCriterion("FEEDBACK_MAN not between", value1, value2, "feedbackMan");
            return (Criteria) this;
        }

        public Criteria andInstallLinkAddressIsNull() {
            addCriterion("INSTALL_LINK_ADDRESS is null");
            return (Criteria) this;
        }

        public Criteria andInstallLinkAddressIsNotNull() {
            addCriterion("INSTALL_LINK_ADDRESS is not null");
            return (Criteria) this;
        }

        public Criteria andInstallLinkAddressEqualTo(String value) {
            addCriterion("INSTALL_LINK_ADDRESS =", value, "installLinkAddress");
            return (Criteria) this;
        }

        public Criteria andInstallLinkAddressNotEqualTo(String value) {
            addCriterion("INSTALL_LINK_ADDRESS <>", value, "installLinkAddress");
            return (Criteria) this;
        }

        public Criteria andInstallLinkAddressGreaterThan(String value) {
            addCriterion("INSTALL_LINK_ADDRESS >", value, "installLinkAddress");
            return (Criteria) this;
        }

        public Criteria andInstallLinkAddressGreaterThanOrEqualTo(String value) {
            addCriterion("INSTALL_LINK_ADDRESS >=", value, "installLinkAddress");
            return (Criteria) this;
        }

        public Criteria andInstallLinkAddressLessThan(String value) {
            addCriterion("INSTALL_LINK_ADDRESS <", value, "installLinkAddress");
            return (Criteria) this;
        }

        public Criteria andInstallLinkAddressLessThanOrEqualTo(String value) {
            addCriterion("INSTALL_LINK_ADDRESS <=", value, "installLinkAddress");
            return (Criteria) this;
        }

        public Criteria andInstallLinkAddressLike(String value) {
            addCriterion("INSTALL_LINK_ADDRESS like", value, "installLinkAddress");
            return (Criteria) this;
        }

        public Criteria andInstallLinkAddressNotLike(String value) {
            addCriterion("INSTALL_LINK_ADDRESS not like", value, "installLinkAddress");
            return (Criteria) this;
        }

        public Criteria andInstallLinkAddressIn(List<String> values) {
            addCriterion("INSTALL_LINK_ADDRESS in", values, "installLinkAddress");
            return (Criteria) this;
        }

        public Criteria andInstallLinkAddressNotIn(List<String> values) {
            addCriterion("INSTALL_LINK_ADDRESS not in", values, "installLinkAddress");
            return (Criteria) this;
        }

        public Criteria andInstallLinkAddressBetween(String value1, String value2) {
            addCriterion("INSTALL_LINK_ADDRESS between", value1, value2, "installLinkAddress");
            return (Criteria) this;
        }

        public Criteria andInstallLinkAddressNotBetween(String value1, String value2) {
            addCriterion("INSTALL_LINK_ADDRESS not between", value1, value2, "installLinkAddress");
            return (Criteria) this;
        }

        public Criteria andEvalScoreIsNull() {
            addCriterion("EVAL_SCORE is null");
            return (Criteria) this;
        }

        public Criteria andEvalScoreIsNotNull() {
            addCriterion("EVAL_SCORE is not null");
            return (Criteria) this;
        }

        public Criteria andEvalScoreEqualTo(BigDecimal value) {
            addCriterion("EVAL_SCORE =", value, "evalScore");
            return (Criteria) this;
        }

        public Criteria andEvalScoreNotEqualTo(BigDecimal value) {
            addCriterion("EVAL_SCORE <>", value, "evalScore");
            return (Criteria) this;
        }

        public Criteria andEvalScoreGreaterThan(BigDecimal value) {
            addCriterion("EVAL_SCORE >", value, "evalScore");
            return (Criteria) this;
        }

        public Criteria andEvalScoreGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("EVAL_SCORE >=", value, "evalScore");
            return (Criteria) this;
        }

        public Criteria andEvalScoreLessThan(BigDecimal value) {
            addCriterion("EVAL_SCORE <", value, "evalScore");
            return (Criteria) this;
        }

        public Criteria andEvalScoreLessThanOrEqualTo(BigDecimal value) {
            addCriterion("EVAL_SCORE <=", value, "evalScore");
            return (Criteria) this;
        }

        public Criteria andEvalScoreIn(List<BigDecimal> values) {
            addCriterion("EVAL_SCORE in", values, "evalScore");
            return (Criteria) this;
        }

        public Criteria andEvalScoreNotIn(List<BigDecimal> values) {
            addCriterion("EVAL_SCORE not in", values, "evalScore");
            return (Criteria) this;
        }

        public Criteria andEvalScoreBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("EVAL_SCORE between", value1, value2, "evalScore");
            return (Criteria) this;
        }

        public Criteria andEvalScoreNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("EVAL_SCORE not between", value1, value2, "evalScore");
            return (Criteria) this;
        }

        public Criteria andCustomerEvalIsNull() {
            addCriterion("CUSTOMER_EVAL is null");
            return (Criteria) this;
        }

        public Criteria andCustomerEvalIsNotNull() {
            addCriterion("CUSTOMER_EVAL is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerEvalEqualTo(String value) {
            addCriterion("CUSTOMER_EVAL =", value, "customerEval");
            return (Criteria) this;
        }

        public Criteria andCustomerEvalNotEqualTo(String value) {
            addCriterion("CUSTOMER_EVAL <>", value, "customerEval");
            return (Criteria) this;
        }

        public Criteria andCustomerEvalGreaterThan(String value) {
            addCriterion("CUSTOMER_EVAL >", value, "customerEval");
            return (Criteria) this;
        }

        public Criteria andCustomerEvalGreaterThanOrEqualTo(String value) {
            addCriterion("CUSTOMER_EVAL >=", value, "customerEval");
            return (Criteria) this;
        }

        public Criteria andCustomerEvalLessThan(String value) {
            addCriterion("CUSTOMER_EVAL <", value, "customerEval");
            return (Criteria) this;
        }

        public Criteria andCustomerEvalLessThanOrEqualTo(String value) {
            addCriterion("CUSTOMER_EVAL <=", value, "customerEval");
            return (Criteria) this;
        }

        public Criteria andCustomerEvalLike(String value) {
            addCriterion("CUSTOMER_EVAL like", value, "customerEval");
            return (Criteria) this;
        }

        public Criteria andCustomerEvalNotLike(String value) {
            addCriterion("CUSTOMER_EVAL not like", value, "customerEval");
            return (Criteria) this;
        }

        public Criteria andCustomerEvalIn(List<String> values) {
            addCriterion("CUSTOMER_EVAL in", values, "customerEval");
            return (Criteria) this;
        }

        public Criteria andCustomerEvalNotIn(List<String> values) {
            addCriterion("CUSTOMER_EVAL not in", values, "customerEval");
            return (Criteria) this;
        }

        public Criteria andCustomerEvalBetween(String value1, String value2) {
            addCriterion("CUSTOMER_EVAL between", value1, value2, "customerEval");
            return (Criteria) this;
        }

        public Criteria andCustomerEvalNotBetween(String value1, String value2) {
            addCriterion("CUSTOMER_EVAL not between", value1, value2, "customerEval");
            return (Criteria) this;
        }

        public Criteria andIsCusConfirmIsNull() {
            addCriterion("IS_CUS_CONFIRM is null");
            return (Criteria) this;
        }

        public Criteria andIsCusConfirmIsNotNull() {
            addCriterion("IS_CUS_CONFIRM is not null");
            return (Criteria) this;
        }

        public Criteria andIsCusConfirmEqualTo(BigDecimal value) {
            addCriterion("IS_CUS_CONFIRM =", value, "isCusConfirm");
            return (Criteria) this;
        }

        public Criteria andIsCusConfirmNotEqualTo(BigDecimal value) {
            addCriterion("IS_CUS_CONFIRM <>", value, "isCusConfirm");
            return (Criteria) this;
        }

        public Criteria andIsCusConfirmGreaterThan(BigDecimal value) {
            addCriterion("IS_CUS_CONFIRM >", value, "isCusConfirm");
            return (Criteria) this;
        }

        public Criteria andIsCusConfirmGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("IS_CUS_CONFIRM >=", value, "isCusConfirm");
            return (Criteria) this;
        }

        public Criteria andIsCusConfirmLessThan(BigDecimal value) {
            addCriterion("IS_CUS_CONFIRM <", value, "isCusConfirm");
            return (Criteria) this;
        }

        public Criteria andIsCusConfirmLessThanOrEqualTo(BigDecimal value) {
            addCriterion("IS_CUS_CONFIRM <=", value, "isCusConfirm");
            return (Criteria) this;
        }

        public Criteria andIsCusConfirmIn(List<BigDecimal> values) {
            addCriterion("IS_CUS_CONFIRM in", values, "isCusConfirm");
            return (Criteria) this;
        }

        public Criteria andIsCusConfirmNotIn(List<BigDecimal> values) {
            addCriterion("IS_CUS_CONFIRM not in", values, "isCusConfirm");
            return (Criteria) this;
        }

        public Criteria andIsCusConfirmBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("IS_CUS_CONFIRM between", value1, value2, "isCusConfirm");
            return (Criteria) this;
        }

        public Criteria andIsCusConfirmNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("IS_CUS_CONFIRM not between", value1, value2, "isCusConfirm");
            return (Criteria) this;
        }

        public Criteria andReportManIsNull() {
            addCriterion("REPORT_MAN is null");
            return (Criteria) this;
        }

        public Criteria andReportManIsNotNull() {
            addCriterion("REPORT_MAN is not null");
            return (Criteria) this;
        }

        public Criteria andReportManEqualTo(String value) {
            addCriterion("REPORT_MAN =", value, "reportMan");
            return (Criteria) this;
        }

        public Criteria andReportManNotEqualTo(String value) {
            addCriterion("REPORT_MAN <>", value, "reportMan");
            return (Criteria) this;
        }

        public Criteria andReportManGreaterThan(String value) {
            addCriterion("REPORT_MAN >", value, "reportMan");
            return (Criteria) this;
        }

        public Criteria andReportManGreaterThanOrEqualTo(String value) {
            addCriterion("REPORT_MAN >=", value, "reportMan");
            return (Criteria) this;
        }

        public Criteria andReportManLessThan(String value) {
            addCriterion("REPORT_MAN <", value, "reportMan");
            return (Criteria) this;
        }

        public Criteria andReportManLessThanOrEqualTo(String value) {
            addCriterion("REPORT_MAN <=", value, "reportMan");
            return (Criteria) this;
        }

        public Criteria andReportManLike(String value) {
            addCriterion("REPORT_MAN like", value, "reportMan");
            return (Criteria) this;
        }

        public Criteria andReportManNotLike(String value) {
            addCriterion("REPORT_MAN not like", value, "reportMan");
            return (Criteria) this;
        }

        public Criteria andReportManIn(List<String> values) {
            addCriterion("REPORT_MAN in", values, "reportMan");
            return (Criteria) this;
        }

        public Criteria andReportManNotIn(List<String> values) {
            addCriterion("REPORT_MAN not in", values, "reportMan");
            return (Criteria) this;
        }

        public Criteria andReportManBetween(String value1, String value2) {
            addCriterion("REPORT_MAN between", value1, value2, "reportMan");
            return (Criteria) this;
        }

        public Criteria andReportManNotBetween(String value1, String value2) {
            addCriterion("REPORT_MAN not between", value1, value2, "reportMan");
            return (Criteria) this;
        }

        public Criteria andCompleteDateIsNull() {
            addCriterion("COMPLETE_DATE is null");
            return (Criteria) this;
        }

        public Criteria andCompleteDateIsNotNull() {
            addCriterion("COMPLETE_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andCompleteDateEqualTo(Date value) {
            addCriterionForJDBCDate("COMPLETE_DATE =", value, "completeDate");
            return (Criteria) this;
        }

        public Criteria andCompleteDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("COMPLETE_DATE <>", value, "completeDate");
            return (Criteria) this;
        }

        public Criteria andCompleteDateGreaterThan(Date value) {
            addCriterionForJDBCDate("COMPLETE_DATE >", value, "completeDate");
            return (Criteria) this;
        }

        public Criteria andCompleteDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("COMPLETE_DATE >=", value, "completeDate");
            return (Criteria) this;
        }

        public Criteria andCompleteDateLessThan(Date value) {
            addCriterionForJDBCDate("COMPLETE_DATE <", value, "completeDate");
            return (Criteria) this;
        }

        public Criteria andCompleteDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("COMPLETE_DATE <=", value, "completeDate");
            return (Criteria) this;
        }

        public Criteria andCompleteDateIn(List<Date> values) {
            addCriterionForJDBCDate("COMPLETE_DATE in", values, "completeDate");
            return (Criteria) this;
        }

        public Criteria andCompleteDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("COMPLETE_DATE not in", values, "completeDate");
            return (Criteria) this;
        }

        public Criteria andCompleteDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("COMPLETE_DATE between", value1, value2, "completeDate");
            return (Criteria) this;
        }

        public Criteria andCompleteDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("COMPLETE_DATE not between", value1, value2, "completeDate");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("TYPE is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("TYPE =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("TYPE <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("TYPE >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("TYPE >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("TYPE <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("TYPE <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("TYPE like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("TYPE not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("TYPE in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("TYPE not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("TYPE between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("TYPE not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andBillDateIsNull() {
            addCriterion("BILL_DATE is null");
            return (Criteria) this;
        }

        public Criteria andBillDateIsNotNull() {
            addCriterion("BILL_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andBillDateEqualTo(Date value) {
            addCriterionForJDBCDate("BILL_DATE =", value, "billDate");
            return (Criteria) this;
        }

        public Criteria andBillDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("BILL_DATE <>", value, "billDate");
            return (Criteria) this;
        }

        public Criteria andBillDateGreaterThan(Date value) {
            addCriterionForJDBCDate("BILL_DATE >", value, "billDate");
            return (Criteria) this;
        }

        public Criteria andBillDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("BILL_DATE >=", value, "billDate");
            return (Criteria) this;
        }

        public Criteria andBillDateLessThan(Date value) {
            addCriterionForJDBCDate("BILL_DATE <", value, "billDate");
            return (Criteria) this;
        }

        public Criteria andBillDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("BILL_DATE <=", value, "billDate");
            return (Criteria) this;
        }

        public Criteria andBillDateIn(List<Date> values) {
            addCriterionForJDBCDate("BILL_DATE in", values, "billDate");
            return (Criteria) this;
        }

        public Criteria andBillDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("BILL_DATE not in", values, "billDate");
            return (Criteria) this;
        }

        public Criteria andBillDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("BILL_DATE between", value1, value2, "billDate");
            return (Criteria) this;
        }

        public Criteria andBillDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("BILL_DATE not between", value1, value2, "billDate");
            return (Criteria) this;
        }

        public Criteria andMasterPhoneIsNull() {
            addCriterion("MASTER_PHONE is null");
            return (Criteria) this;
        }

        public Criteria andMasterPhoneIsNotNull() {
            addCriterion("MASTER_PHONE is not null");
            return (Criteria) this;
        }

        public Criteria andMasterPhoneEqualTo(String value) {
            addCriterion("MASTER_PHONE =", value, "masterPhone");
            return (Criteria) this;
        }

        public Criteria andMasterPhoneNotEqualTo(String value) {
            addCriterion("MASTER_PHONE <>", value, "masterPhone");
            return (Criteria) this;
        }

        public Criteria andMasterPhoneGreaterThan(String value) {
            addCriterion("MASTER_PHONE >", value, "masterPhone");
            return (Criteria) this;
        }

        public Criteria andMasterPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("MASTER_PHONE >=", value, "masterPhone");
            return (Criteria) this;
        }

        public Criteria andMasterPhoneLessThan(String value) {
            addCriterion("MASTER_PHONE <", value, "masterPhone");
            return (Criteria) this;
        }

        public Criteria andMasterPhoneLessThanOrEqualTo(String value) {
            addCriterion("MASTER_PHONE <=", value, "masterPhone");
            return (Criteria) this;
        }

        public Criteria andMasterPhoneLike(String value) {
            addCriterion("MASTER_PHONE like", value, "masterPhone");
            return (Criteria) this;
        }

        public Criteria andMasterPhoneNotLike(String value) {
            addCriterion("MASTER_PHONE not like", value, "masterPhone");
            return (Criteria) this;
        }

        public Criteria andMasterPhoneIn(List<String> values) {
            addCriterion("MASTER_PHONE in", values, "masterPhone");
            return (Criteria) this;
        }

        public Criteria andMasterPhoneNotIn(List<String> values) {
            addCriterion("MASTER_PHONE not in", values, "masterPhone");
            return (Criteria) this;
        }

        public Criteria andMasterPhoneBetween(String value1, String value2) {
            addCriterion("MASTER_PHONE between", value1, value2, "masterPhone");
            return (Criteria) this;
        }

        public Criteria andMasterPhoneNotBetween(String value1, String value2) {
            addCriterion("MASTER_PHONE not between", value1, value2, "masterPhone");
            return (Criteria) this;
        }

        public Criteria andWorkOrderMasterIdIsNull() {
            addCriterion("WORK_ORDER_MASTER_ID is null");
            return (Criteria) this;
        }

        public Criteria andWorkOrderMasterIdIsNotNull() {
            addCriterion("WORK_ORDER_MASTER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andWorkOrderMasterIdEqualTo(String value) {
            addCriterion("WORK_ORDER_MASTER_ID =", value, "workOrderMasterId");
            return (Criteria) this;
        }

        public Criteria andWorkOrderMasterIdNotEqualTo(String value) {
            addCriterion("WORK_ORDER_MASTER_ID <>", value, "workOrderMasterId");
            return (Criteria) this;
        }

        public Criteria andWorkOrderMasterIdGreaterThan(String value) {
            addCriterion("WORK_ORDER_MASTER_ID >", value, "workOrderMasterId");
            return (Criteria) this;
        }

        public Criteria andWorkOrderMasterIdGreaterThanOrEqualTo(String value) {
            addCriterion("WORK_ORDER_MASTER_ID >=", value, "workOrderMasterId");
            return (Criteria) this;
        }

        public Criteria andWorkOrderMasterIdLessThan(String value) {
            addCriterion("WORK_ORDER_MASTER_ID <", value, "workOrderMasterId");
            return (Criteria) this;
        }

        public Criteria andWorkOrderMasterIdLessThanOrEqualTo(String value) {
            addCriterion("WORK_ORDER_MASTER_ID <=", value, "workOrderMasterId");
            return (Criteria) this;
        }

        public Criteria andWorkOrderMasterIdLike(String value) {
            addCriterion("WORK_ORDER_MASTER_ID like", value, "workOrderMasterId");
            return (Criteria) this;
        }

        public Criteria andWorkOrderMasterIdNotLike(String value) {
            addCriterion("WORK_ORDER_MASTER_ID not like", value, "workOrderMasterId");
            return (Criteria) this;
        }

        public Criteria andWorkOrderMasterIdIn(List<String> values) {
            addCriterion("WORK_ORDER_MASTER_ID in", values, "workOrderMasterId");
            return (Criteria) this;
        }

        public Criteria andWorkOrderMasterIdNotIn(List<String> values) {
            addCriterion("WORK_ORDER_MASTER_ID not in", values, "workOrderMasterId");
            return (Criteria) this;
        }

        public Criteria andWorkOrderMasterIdBetween(String value1, String value2) {
            addCriterion("WORK_ORDER_MASTER_ID between", value1, value2, "workOrderMasterId");
            return (Criteria) this;
        }

        public Criteria andWorkOrderMasterIdNotBetween(String value1, String value2) {
            addCriterion("WORK_ORDER_MASTER_ID not between", value1, value2, "workOrderMasterId");
            return (Criteria) this;
        }

        public Criteria andBookingTimeIsNull() {
            addCriterion("BOOKING_TIME is null");
            return (Criteria) this;
        }

        public Criteria andBookingTimeIsNotNull() {
            addCriterion("BOOKING_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andBookingTimeEqualTo(Date value) {
            addCriterionForJDBCDate("BOOKING_TIME =", value, "bookingTime");
            return (Criteria) this;
        }

        public Criteria andBookingTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("BOOKING_TIME <>", value, "bookingTime");
            return (Criteria) this;
        }

        public Criteria andBookingTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("BOOKING_TIME >", value, "bookingTime");
            return (Criteria) this;
        }

        public Criteria andBookingTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("BOOKING_TIME >=", value, "bookingTime");
            return (Criteria) this;
        }

        public Criteria andBookingTimeLessThan(Date value) {
            addCriterionForJDBCDate("BOOKING_TIME <", value, "bookingTime");
            return (Criteria) this;
        }

        public Criteria andBookingTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("BOOKING_TIME <=", value, "bookingTime");
            return (Criteria) this;
        }

        public Criteria andBookingTimeIn(List<Date> values) {
            addCriterionForJDBCDate("BOOKING_TIME in", values, "bookingTime");
            return (Criteria) this;
        }

        public Criteria andBookingTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("BOOKING_TIME not in", values, "bookingTime");
            return (Criteria) this;
        }

        public Criteria andBookingTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("BOOKING_TIME between", value1, value2, "bookingTime");
            return (Criteria) this;
        }

        public Criteria andBookingTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("BOOKING_TIME not between", value1, value2, "bookingTime");
            return (Criteria) this;
        }

        public Criteria andDispatchSnIsNull() {
            addCriterion("DISPATCH_SN is null");
            return (Criteria) this;
        }

        public Criteria andDispatchSnIsNotNull() {
            addCriterion("DISPATCH_SN is not null");
            return (Criteria) this;
        }

        public Criteria andDispatchSnEqualTo(String value) {
            addCriterion("DISPATCH_SN =", value, "dispatchSn");
            return (Criteria) this;
        }

        public Criteria andDispatchSnNotEqualTo(String value) {
            addCriterion("DISPATCH_SN <>", value, "dispatchSn");
            return (Criteria) this;
        }

        public Criteria andDispatchSnGreaterThan(String value) {
            addCriterion("DISPATCH_SN >", value, "dispatchSn");
            return (Criteria) this;
        }

        public Criteria andDispatchSnGreaterThanOrEqualTo(String value) {
            addCriterion("DISPATCH_SN >=", value, "dispatchSn");
            return (Criteria) this;
        }

        public Criteria andDispatchSnLessThan(String value) {
            addCriterion("DISPATCH_SN <", value, "dispatchSn");
            return (Criteria) this;
        }

        public Criteria andDispatchSnLessThanOrEqualTo(String value) {
            addCriterion("DISPATCH_SN <=", value, "dispatchSn");
            return (Criteria) this;
        }

        public Criteria andDispatchSnLike(String value) {
            addCriterion("DISPATCH_SN like", value, "dispatchSn");
            return (Criteria) this;
        }

        public Criteria andDispatchSnNotLike(String value) {
            addCriterion("DISPATCH_SN not like", value, "dispatchSn");
            return (Criteria) this;
        }

        public Criteria andDispatchSnIn(List<String> values) {
            addCriterion("DISPATCH_SN in", values, "dispatchSn");
            return (Criteria) this;
        }

        public Criteria andDispatchSnNotIn(List<String> values) {
            addCriterion("DISPATCH_SN not in", values, "dispatchSn");
            return (Criteria) this;
        }

        public Criteria andDispatchSnBetween(String value1, String value2) {
            addCriterion("DISPATCH_SN between", value1, value2, "dispatchSn");
            return (Criteria) this;
        }

        public Criteria andDispatchSnNotBetween(String value1, String value2) {
            addCriterion("DISPATCH_SN not between", value1, value2, "dispatchSn");
            return (Criteria) this;
        }

        public Criteria andDispatchMemoIsNull() {
            addCriterion("DISPATCH_MEMO is null");
            return (Criteria) this;
        }

        public Criteria andDispatchMemoIsNotNull() {
            addCriterion("DISPATCH_MEMO is not null");
            return (Criteria) this;
        }

        public Criteria andDispatchMemoEqualTo(String value) {
            addCriterion("DISPATCH_MEMO =", value, "dispatchMemo");
            return (Criteria) this;
        }

        public Criteria andDispatchMemoNotEqualTo(String value) {
            addCriterion("DISPATCH_MEMO <>", value, "dispatchMemo");
            return (Criteria) this;
        }

        public Criteria andDispatchMemoGreaterThan(String value) {
            addCriterion("DISPATCH_MEMO >", value, "dispatchMemo");
            return (Criteria) this;
        }

        public Criteria andDispatchMemoGreaterThanOrEqualTo(String value) {
            addCriterion("DISPATCH_MEMO >=", value, "dispatchMemo");
            return (Criteria) this;
        }

        public Criteria andDispatchMemoLessThan(String value) {
            addCriterion("DISPATCH_MEMO <", value, "dispatchMemo");
            return (Criteria) this;
        }

        public Criteria andDispatchMemoLessThanOrEqualTo(String value) {
            addCriterion("DISPATCH_MEMO <=", value, "dispatchMemo");
            return (Criteria) this;
        }

        public Criteria andDispatchMemoLike(String value) {
            addCriterion("DISPATCH_MEMO like", value, "dispatchMemo");
            return (Criteria) this;
        }

        public Criteria andDispatchMemoNotLike(String value) {
            addCriterion("DISPATCH_MEMO not like", value, "dispatchMemo");
            return (Criteria) this;
        }

        public Criteria andDispatchMemoIn(List<String> values) {
            addCriterion("DISPATCH_MEMO in", values, "dispatchMemo");
            return (Criteria) this;
        }

        public Criteria andDispatchMemoNotIn(List<String> values) {
            addCriterion("DISPATCH_MEMO not in", values, "dispatchMemo");
            return (Criteria) this;
        }

        public Criteria andDispatchMemoBetween(String value1, String value2) {
            addCriterion("DISPATCH_MEMO between", value1, value2, "dispatchMemo");
            return (Criteria) this;
        }

        public Criteria andDispatchMemoNotBetween(String value1, String value2) {
            addCriterion("DISPATCH_MEMO not between", value1, value2, "dispatchMemo");
            return (Criteria) this;
        }

        public Criteria andMemo2IsNull() {
            addCriterion("MEMO2 is null");
            return (Criteria) this;
        }

        public Criteria andMemo2IsNotNull() {
            addCriterion("MEMO2 is not null");
            return (Criteria) this;
        }

        public Criteria andMemo2EqualTo(String value) {
            addCriterion("MEMO2 =", value, "memo2");
            return (Criteria) this;
        }

        public Criteria andMemo2NotEqualTo(String value) {
            addCriterion("MEMO2 <>", value, "memo2");
            return (Criteria) this;
        }

        public Criteria andMemo2GreaterThan(String value) {
            addCriterion("MEMO2 >", value, "memo2");
            return (Criteria) this;
        }

        public Criteria andMemo2GreaterThanOrEqualTo(String value) {
            addCriterion("MEMO2 >=", value, "memo2");
            return (Criteria) this;
        }

        public Criteria andMemo2LessThan(String value) {
            addCriterion("MEMO2 <", value, "memo2");
            return (Criteria) this;
        }

        public Criteria andMemo2LessThanOrEqualTo(String value) {
            addCriterion("MEMO2 <=", value, "memo2");
            return (Criteria) this;
        }

        public Criteria andMemo2Like(String value) {
            addCriterion("MEMO2 like", value, "memo2");
            return (Criteria) this;
        }

        public Criteria andMemo2NotLike(String value) {
            addCriterion("MEMO2 not like", value, "memo2");
            return (Criteria) this;
        }

        public Criteria andMemo2In(List<String> values) {
            addCriterion("MEMO2 in", values, "memo2");
            return (Criteria) this;
        }

        public Criteria andMemo2NotIn(List<String> values) {
            addCriterion("MEMO2 not in", values, "memo2");
            return (Criteria) this;
        }

        public Criteria andMemo2Between(String value1, String value2) {
            addCriterion("MEMO2 between", value1, value2, "memo2");
            return (Criteria) this;
        }

        public Criteria andMemo2NotBetween(String value1, String value2) {
            addCriterion("MEMO2 not between", value1, value2, "memo2");
            return (Criteria) this;
        }

        public Criteria andStoreNameIsNull() {
            addCriterion("STORE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andStoreNameIsNotNull() {
            addCriterion("STORE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andStoreNameEqualTo(String value) {
            addCriterion("STORE_NAME =", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameNotEqualTo(String value) {
            addCriterion("STORE_NAME <>", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameGreaterThan(String value) {
            addCriterion("STORE_NAME >", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameGreaterThanOrEqualTo(String value) {
            addCriterion("STORE_NAME >=", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameLessThan(String value) {
            addCriterion("STORE_NAME <", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameLessThanOrEqualTo(String value) {
            addCriterion("STORE_NAME <=", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameLike(String value) {
            addCriterion("STORE_NAME like", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameNotLike(String value) {
            addCriterion("STORE_NAME not like", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameIn(List<String> values) {
            addCriterion("STORE_NAME in", values, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameNotIn(List<String> values) {
            addCriterion("STORE_NAME not in", values, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameBetween(String value1, String value2) {
            addCriterion("STORE_NAME between", value1, value2, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameNotBetween(String value1, String value2) {
            addCriterion("STORE_NAME not between", value1, value2, "storeName");
            return (Criteria) this;
        }

        public Criteria andWarehouseNameIsNull() {
            addCriterion("WAREHOUSE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andWarehouseNameIsNotNull() {
            addCriterion("WAREHOUSE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andWarehouseNameEqualTo(String value) {
            addCriterion("WAREHOUSE_NAME =", value, "warehouseName");
            return (Criteria) this;
        }

        public Criteria andWarehouseNameNotEqualTo(String value) {
            addCriterion("WAREHOUSE_NAME <>", value, "warehouseName");
            return (Criteria) this;
        }

        public Criteria andWarehouseNameGreaterThan(String value) {
            addCriterion("WAREHOUSE_NAME >", value, "warehouseName");
            return (Criteria) this;
        }

        public Criteria andWarehouseNameGreaterThanOrEqualTo(String value) {
            addCriterion("WAREHOUSE_NAME >=", value, "warehouseName");
            return (Criteria) this;
        }

        public Criteria andWarehouseNameLessThan(String value) {
            addCriterion("WAREHOUSE_NAME <", value, "warehouseName");
            return (Criteria) this;
        }

        public Criteria andWarehouseNameLessThanOrEqualTo(String value) {
            addCriterion("WAREHOUSE_NAME <=", value, "warehouseName");
            return (Criteria) this;
        }

        public Criteria andWarehouseNameLike(String value) {
            addCriterion("WAREHOUSE_NAME like", value, "warehouseName");
            return (Criteria) this;
        }

        public Criteria andWarehouseNameNotLike(String value) {
            addCriterion("WAREHOUSE_NAME not like", value, "warehouseName");
            return (Criteria) this;
        }

        public Criteria andWarehouseNameIn(List<String> values) {
            addCriterion("WAREHOUSE_NAME in", values, "warehouseName");
            return (Criteria) this;
        }

        public Criteria andWarehouseNameNotIn(List<String> values) {
            addCriterion("WAREHOUSE_NAME not in", values, "warehouseName");
            return (Criteria) this;
        }

        public Criteria andWarehouseNameBetween(String value1, String value2) {
            addCriterion("WAREHOUSE_NAME between", value1, value2, "warehouseName");
            return (Criteria) this;
        }

        public Criteria andWarehouseNameNotBetween(String value1, String value2) {
            addCriterion("WAREHOUSE_NAME not between", value1, value2, "warehouseName");
            return (Criteria) this;
        }

        public Criteria andFeedbackValidityIsNull() {
            addCriterion("FEEDBACK_VALIDITY is null");
            return (Criteria) this;
        }

        public Criteria andFeedbackValidityIsNotNull() {
            addCriterion("FEEDBACK_VALIDITY is not null");
            return (Criteria) this;
        }

        public Criteria andFeedbackValidityEqualTo(String value) {
            addCriterion("FEEDBACK_VALIDITY =", value, "feedbackValidity");
            return (Criteria) this;
        }

        public Criteria andFeedbackValidityNotEqualTo(String value) {
            addCriterion("FEEDBACK_VALIDITY <>", value, "feedbackValidity");
            return (Criteria) this;
        }

        public Criteria andFeedbackValidityGreaterThan(String value) {
            addCriterion("FEEDBACK_VALIDITY >", value, "feedbackValidity");
            return (Criteria) this;
        }

        public Criteria andFeedbackValidityGreaterThanOrEqualTo(String value) {
            addCriterion("FEEDBACK_VALIDITY >=", value, "feedbackValidity");
            return (Criteria) this;
        }

        public Criteria andFeedbackValidityLessThan(String value) {
            addCriterion("FEEDBACK_VALIDITY <", value, "feedbackValidity");
            return (Criteria) this;
        }

        public Criteria andFeedbackValidityLessThanOrEqualTo(String value) {
            addCriterion("FEEDBACK_VALIDITY <=", value, "feedbackValidity");
            return (Criteria) this;
        }

        public Criteria andFeedbackValidityLike(String value) {
            addCriterion("FEEDBACK_VALIDITY like", value, "feedbackValidity");
            return (Criteria) this;
        }

        public Criteria andFeedbackValidityNotLike(String value) {
            addCriterion("FEEDBACK_VALIDITY not like", value, "feedbackValidity");
            return (Criteria) this;
        }

        public Criteria andFeedbackValidityIn(List<String> values) {
            addCriterion("FEEDBACK_VALIDITY in", values, "feedbackValidity");
            return (Criteria) this;
        }

        public Criteria andFeedbackValidityNotIn(List<String> values) {
            addCriterion("FEEDBACK_VALIDITY not in", values, "feedbackValidity");
            return (Criteria) this;
        }

        public Criteria andFeedbackValidityBetween(String value1, String value2) {
            addCriterion("FEEDBACK_VALIDITY between", value1, value2, "feedbackValidity");
            return (Criteria) this;
        }

        public Criteria andFeedbackValidityNotBetween(String value1, String value2) {
            addCriterion("FEEDBACK_VALIDITY not between", value1, value2, "feedbackValidity");
            return (Criteria) this;
        }

        public Criteria andIsFeeIsNull() {
            addCriterion("IS_FEE is null");
            return (Criteria) this;
        }

        public Criteria andIsFeeIsNotNull() {
            addCriterion("IS_FEE is not null");
            return (Criteria) this;
        }

        public Criteria andIsFeeEqualTo(String value) {
            addCriterion("IS_FEE =", value, "isFee");
            return (Criteria) this;
        }

        public Criteria andIsFeeNotEqualTo(String value) {
            addCriterion("IS_FEE <>", value, "isFee");
            return (Criteria) this;
        }

        public Criteria andIsFeeGreaterThan(String value) {
            addCriterion("IS_FEE >", value, "isFee");
            return (Criteria) this;
        }

        public Criteria andIsFeeGreaterThanOrEqualTo(String value) {
            addCriterion("IS_FEE >=", value, "isFee");
            return (Criteria) this;
        }

        public Criteria andIsFeeLessThan(String value) {
            addCriterion("IS_FEE <", value, "isFee");
            return (Criteria) this;
        }

        public Criteria andIsFeeLessThanOrEqualTo(String value) {
            addCriterion("IS_FEE <=", value, "isFee");
            return (Criteria) this;
        }

        public Criteria andIsFeeLike(String value) {
            addCriterion("IS_FEE like", value, "isFee");
            return (Criteria) this;
        }

        public Criteria andIsFeeNotLike(String value) {
            addCriterion("IS_FEE not like", value, "isFee");
            return (Criteria) this;
        }

        public Criteria andIsFeeIn(List<String> values) {
            addCriterion("IS_FEE in", values, "isFee");
            return (Criteria) this;
        }

        public Criteria andIsFeeNotIn(List<String> values) {
            addCriterion("IS_FEE not in", values, "isFee");
            return (Criteria) this;
        }

        public Criteria andIsFeeBetween(String value1, String value2) {
            addCriterion("IS_FEE between", value1, value2, "isFee");
            return (Criteria) this;
        }

        public Criteria andIsFeeNotBetween(String value1, String value2) {
            addCriterion("IS_FEE not between", value1, value2, "isFee");
            return (Criteria) this;
        }

        public Criteria andCustomerEvalScoreIsNull() {
            addCriterion("CUSTOMER_EVAL_SCORE is null");
            return (Criteria) this;
        }

        public Criteria andCustomerEvalScoreIsNotNull() {
            addCriterion("CUSTOMER_EVAL_SCORE is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerEvalScoreEqualTo(BigDecimal value) {
            addCriterion("CUSTOMER_EVAL_SCORE =", value, "customerEvalScore");
            return (Criteria) this;
        }

        public Criteria andCustomerEvalScoreNotEqualTo(BigDecimal value) {
            addCriterion("CUSTOMER_EVAL_SCORE <>", value, "customerEvalScore");
            return (Criteria) this;
        }

        public Criteria andCustomerEvalScoreGreaterThan(BigDecimal value) {
            addCriterion("CUSTOMER_EVAL_SCORE >", value, "customerEvalScore");
            return (Criteria) this;
        }

        public Criteria andCustomerEvalScoreGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("CUSTOMER_EVAL_SCORE >=", value, "customerEvalScore");
            return (Criteria) this;
        }

        public Criteria andCustomerEvalScoreLessThan(BigDecimal value) {
            addCriterion("CUSTOMER_EVAL_SCORE <", value, "customerEvalScore");
            return (Criteria) this;
        }

        public Criteria andCustomerEvalScoreLessThanOrEqualTo(BigDecimal value) {
            addCriterion("CUSTOMER_EVAL_SCORE <=", value, "customerEvalScore");
            return (Criteria) this;
        }

        public Criteria andCustomerEvalScoreIn(List<BigDecimal> values) {
            addCriterion("CUSTOMER_EVAL_SCORE in", values, "customerEvalScore");
            return (Criteria) this;
        }

        public Criteria andCustomerEvalScoreNotIn(List<BigDecimal> values) {
            addCriterion("CUSTOMER_EVAL_SCORE not in", values, "customerEvalScore");
            return (Criteria) this;
        }

        public Criteria andCustomerEvalScoreBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CUSTOMER_EVAL_SCORE between", value1, value2, "customerEvalScore");
            return (Criteria) this;
        }

        public Criteria andCustomerEvalScoreNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CUSTOMER_EVAL_SCORE not between", value1, value2, "customerEvalScore");
            return (Criteria) this;
        }

        public Criteria andFeedbackRemarkIsNull() {
            addCriterion("FEEDBACK_REMARK is null");
            return (Criteria) this;
        }

        public Criteria andFeedbackRemarkIsNotNull() {
            addCriterion("FEEDBACK_REMARK is not null");
            return (Criteria) this;
        }

        public Criteria andFeedbackRemarkEqualTo(String value) {
            addCriterion("FEEDBACK_REMARK =", value, "feedbackRemark");
            return (Criteria) this;
        }

        public Criteria andFeedbackRemarkNotEqualTo(String value) {
            addCriterion("FEEDBACK_REMARK <>", value, "feedbackRemark");
            return (Criteria) this;
        }

        public Criteria andFeedbackRemarkGreaterThan(String value) {
            addCriterion("FEEDBACK_REMARK >", value, "feedbackRemark");
            return (Criteria) this;
        }

        public Criteria andFeedbackRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("FEEDBACK_REMARK >=", value, "feedbackRemark");
            return (Criteria) this;
        }

        public Criteria andFeedbackRemarkLessThan(String value) {
            addCriterion("FEEDBACK_REMARK <", value, "feedbackRemark");
            return (Criteria) this;
        }

        public Criteria andFeedbackRemarkLessThanOrEqualTo(String value) {
            addCriterion("FEEDBACK_REMARK <=", value, "feedbackRemark");
            return (Criteria) this;
        }

        public Criteria andFeedbackRemarkLike(String value) {
            addCriterion("FEEDBACK_REMARK like", value, "feedbackRemark");
            return (Criteria) this;
        }

        public Criteria andFeedbackRemarkNotLike(String value) {
            addCriterion("FEEDBACK_REMARK not like", value, "feedbackRemark");
            return (Criteria) this;
        }

        public Criteria andFeedbackRemarkIn(List<String> values) {
            addCriterion("FEEDBACK_REMARK in", values, "feedbackRemark");
            return (Criteria) this;
        }

        public Criteria andFeedbackRemarkNotIn(List<String> values) {
            addCriterion("FEEDBACK_REMARK not in", values, "feedbackRemark");
            return (Criteria) this;
        }

        public Criteria andFeedbackRemarkBetween(String value1, String value2) {
            addCriterion("FEEDBACK_REMARK between", value1, value2, "feedbackRemark");
            return (Criteria) this;
        }

        public Criteria andFeedbackRemarkNotBetween(String value1, String value2) {
            addCriterion("FEEDBACK_REMARK not between", value1, value2, "feedbackRemark");
            return (Criteria) this;
        }

        public Criteria andSatisfaction1IsNull() {
            addCriterion("SATISFACTION1 is null");
            return (Criteria) this;
        }

        public Criteria andSatisfaction1IsNotNull() {
            addCriterion("SATISFACTION1 is not null");
            return (Criteria) this;
        }

        public Criteria andSatisfaction1EqualTo(BigDecimal value) {
            addCriterion("SATISFACTION1 =", value, "satisfaction1");
            return (Criteria) this;
        }

        public Criteria andSatisfaction1NotEqualTo(BigDecimal value) {
            addCriterion("SATISFACTION1 <>", value, "satisfaction1");
            return (Criteria) this;
        }

        public Criteria andSatisfaction1GreaterThan(BigDecimal value) {
            addCriterion("SATISFACTION1 >", value, "satisfaction1");
            return (Criteria) this;
        }

        public Criteria andSatisfaction1GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SATISFACTION1 >=", value, "satisfaction1");
            return (Criteria) this;
        }

        public Criteria andSatisfaction1LessThan(BigDecimal value) {
            addCriterion("SATISFACTION1 <", value, "satisfaction1");
            return (Criteria) this;
        }

        public Criteria andSatisfaction1LessThanOrEqualTo(BigDecimal value) {
            addCriterion("SATISFACTION1 <=", value, "satisfaction1");
            return (Criteria) this;
        }

        public Criteria andSatisfaction1In(List<BigDecimal> values) {
            addCriterion("SATISFACTION1 in", values, "satisfaction1");
            return (Criteria) this;
        }

        public Criteria andSatisfaction1NotIn(List<BigDecimal> values) {
            addCriterion("SATISFACTION1 not in", values, "satisfaction1");
            return (Criteria) this;
        }

        public Criteria andSatisfaction1Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("SATISFACTION1 between", value1, value2, "satisfaction1");
            return (Criteria) this;
        }

        public Criteria andSatisfaction1NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SATISFACTION1 not between", value1, value2, "satisfaction1");
            return (Criteria) this;
        }

        public Criteria andSatisfaction2IsNull() {
            addCriterion("SATISFACTION2 is null");
            return (Criteria) this;
        }

        public Criteria andSatisfaction2IsNotNull() {
            addCriterion("SATISFACTION2 is not null");
            return (Criteria) this;
        }

        public Criteria andSatisfaction2EqualTo(BigDecimal value) {
            addCriterion("SATISFACTION2 =", value, "satisfaction2");
            return (Criteria) this;
        }

        public Criteria andSatisfaction2NotEqualTo(BigDecimal value) {
            addCriterion("SATISFACTION2 <>", value, "satisfaction2");
            return (Criteria) this;
        }

        public Criteria andSatisfaction2GreaterThan(BigDecimal value) {
            addCriterion("SATISFACTION2 >", value, "satisfaction2");
            return (Criteria) this;
        }

        public Criteria andSatisfaction2GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SATISFACTION2 >=", value, "satisfaction2");
            return (Criteria) this;
        }

        public Criteria andSatisfaction2LessThan(BigDecimal value) {
            addCriterion("SATISFACTION2 <", value, "satisfaction2");
            return (Criteria) this;
        }

        public Criteria andSatisfaction2LessThanOrEqualTo(BigDecimal value) {
            addCriterion("SATISFACTION2 <=", value, "satisfaction2");
            return (Criteria) this;
        }

        public Criteria andSatisfaction2In(List<BigDecimal> values) {
            addCriterion("SATISFACTION2 in", values, "satisfaction2");
            return (Criteria) this;
        }

        public Criteria andSatisfaction2NotIn(List<BigDecimal> values) {
            addCriterion("SATISFACTION2 not in", values, "satisfaction2");
            return (Criteria) this;
        }

        public Criteria andSatisfaction2Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("SATISFACTION2 between", value1, value2, "satisfaction2");
            return (Criteria) this;
        }

        public Criteria andSatisfaction2NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SATISFACTION2 not between", value1, value2, "satisfaction2");
            return (Criteria) this;
        }

        public Criteria andSatisfaction3IsNull() {
            addCriterion("SATISFACTION3 is null");
            return (Criteria) this;
        }

        public Criteria andSatisfaction3IsNotNull() {
            addCriterion("SATISFACTION3 is not null");
            return (Criteria) this;
        }

        public Criteria andSatisfaction3EqualTo(BigDecimal value) {
            addCriterion("SATISFACTION3 =", value, "satisfaction3");
            return (Criteria) this;
        }

        public Criteria andSatisfaction3NotEqualTo(BigDecimal value) {
            addCriterion("SATISFACTION3 <>", value, "satisfaction3");
            return (Criteria) this;
        }

        public Criteria andSatisfaction3GreaterThan(BigDecimal value) {
            addCriterion("SATISFACTION3 >", value, "satisfaction3");
            return (Criteria) this;
        }

        public Criteria andSatisfaction3GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SATISFACTION3 >=", value, "satisfaction3");
            return (Criteria) this;
        }

        public Criteria andSatisfaction3LessThan(BigDecimal value) {
            addCriterion("SATISFACTION3 <", value, "satisfaction3");
            return (Criteria) this;
        }

        public Criteria andSatisfaction3LessThanOrEqualTo(BigDecimal value) {
            addCriterion("SATISFACTION3 <=", value, "satisfaction3");
            return (Criteria) this;
        }

        public Criteria andSatisfaction3In(List<BigDecimal> values) {
            addCriterion("SATISFACTION3 in", values, "satisfaction3");
            return (Criteria) this;
        }

        public Criteria andSatisfaction3NotIn(List<BigDecimal> values) {
            addCriterion("SATISFACTION3 not in", values, "satisfaction3");
            return (Criteria) this;
        }

        public Criteria andSatisfaction3Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("SATISFACTION3 between", value1, value2, "satisfaction3");
            return (Criteria) this;
        }

        public Criteria andSatisfaction3NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SATISFACTION3 not between", value1, value2, "satisfaction3");
            return (Criteria) this;
        }

        public Criteria andCheckCodeIsNull() {
            addCriterion("CHECK_CODE is null");
            return (Criteria) this;
        }

        public Criteria andCheckCodeIsNotNull() {
            addCriterion("CHECK_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andCheckCodeEqualTo(String value) {
            addCriterion("CHECK_CODE =", value, "checkCode");
            return (Criteria) this;
        }

        public Criteria andCheckCodeNotEqualTo(String value) {
            addCriterion("CHECK_CODE <>", value, "checkCode");
            return (Criteria) this;
        }

        public Criteria andCheckCodeGreaterThan(String value) {
            addCriterion("CHECK_CODE >", value, "checkCode");
            return (Criteria) this;
        }

        public Criteria andCheckCodeGreaterThanOrEqualTo(String value) {
            addCriterion("CHECK_CODE >=", value, "checkCode");
            return (Criteria) this;
        }

        public Criteria andCheckCodeLessThan(String value) {
            addCriterion("CHECK_CODE <", value, "checkCode");
            return (Criteria) this;
        }

        public Criteria andCheckCodeLessThanOrEqualTo(String value) {
            addCriterion("CHECK_CODE <=", value, "checkCode");
            return (Criteria) this;
        }

        public Criteria andCheckCodeLike(String value) {
            addCriterion("CHECK_CODE like", value, "checkCode");
            return (Criteria) this;
        }

        public Criteria andCheckCodeNotLike(String value) {
            addCriterion("CHECK_CODE not like", value, "checkCode");
            return (Criteria) this;
        }

        public Criteria andCheckCodeIn(List<String> values) {
            addCriterion("CHECK_CODE in", values, "checkCode");
            return (Criteria) this;
        }

        public Criteria andCheckCodeNotIn(List<String> values) {
            addCriterion("CHECK_CODE not in", values, "checkCode");
            return (Criteria) this;
        }

        public Criteria andCheckCodeBetween(String value1, String value2) {
            addCriterion("CHECK_CODE between", value1, value2, "checkCode");
            return (Criteria) this;
        }

        public Criteria andCheckCodeNotBetween(String value1, String value2) {
            addCriterion("CHECK_CODE not between", value1, value2, "checkCode");
            return (Criteria) this;
        }

        public Criteria andOutOrderSnIsNull() {
            addCriterion("OUT_ORDER_SN is null");
            return (Criteria) this;
        }

        public Criteria andOutOrderSnIsNotNull() {
            addCriterion("OUT_ORDER_SN is not null");
            return (Criteria) this;
        }

        public Criteria andOutOrderSnEqualTo(String value) {
            addCriterion("OUT_ORDER_SN =", value, "outOrderSn");
            return (Criteria) this;
        }

        public Criteria andOutOrderSnNotEqualTo(String value) {
            addCriterion("OUT_ORDER_SN <>", value, "outOrderSn");
            return (Criteria) this;
        }

        public Criteria andOutOrderSnGreaterThan(String value) {
            addCriterion("OUT_ORDER_SN >", value, "outOrderSn");
            return (Criteria) this;
        }

        public Criteria andOutOrderSnGreaterThanOrEqualTo(String value) {
            addCriterion("OUT_ORDER_SN >=", value, "outOrderSn");
            return (Criteria) this;
        }

        public Criteria andOutOrderSnLessThan(String value) {
            addCriterion("OUT_ORDER_SN <", value, "outOrderSn");
            return (Criteria) this;
        }

        public Criteria andOutOrderSnLessThanOrEqualTo(String value) {
            addCriterion("OUT_ORDER_SN <=", value, "outOrderSn");
            return (Criteria) this;
        }

        public Criteria andOutOrderSnLike(String value) {
            addCriterion("OUT_ORDER_SN like", value, "outOrderSn");
            return (Criteria) this;
        }

        public Criteria andOutOrderSnNotLike(String value) {
            addCriterion("OUT_ORDER_SN not like", value, "outOrderSn");
            return (Criteria) this;
        }

        public Criteria andOutOrderSnIn(List<String> values) {
            addCriterion("OUT_ORDER_SN in", values, "outOrderSn");
            return (Criteria) this;
        }

        public Criteria andOutOrderSnNotIn(List<String> values) {
            addCriterion("OUT_ORDER_SN not in", values, "outOrderSn");
            return (Criteria) this;
        }

        public Criteria andOutOrderSnBetween(String value1, String value2) {
            addCriterion("OUT_ORDER_SN between", value1, value2, "outOrderSn");
            return (Criteria) this;
        }

        public Criteria andOutOrderSnNotBetween(String value1, String value2) {
            addCriterion("OUT_ORDER_SN not between", value1, value2, "outOrderSn");
            return (Criteria) this;
        }

        public Criteria andFeedbackStatusIsNull() {
            addCriterion("FEEDBACK_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andFeedbackStatusIsNotNull() {
            addCriterion("FEEDBACK_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andFeedbackStatusEqualTo(String value) {
            addCriterion("FEEDBACK_STATUS =", value, "feedbackStatus");
            return (Criteria) this;
        }

        public Criteria andFeedbackStatusNotEqualTo(String value) {
            addCriterion("FEEDBACK_STATUS <>", value, "feedbackStatus");
            return (Criteria) this;
        }

        public Criteria andFeedbackStatusGreaterThan(String value) {
            addCriterion("FEEDBACK_STATUS >", value, "feedbackStatus");
            return (Criteria) this;
        }

        public Criteria andFeedbackStatusGreaterThanOrEqualTo(String value) {
            addCriterion("FEEDBACK_STATUS >=", value, "feedbackStatus");
            return (Criteria) this;
        }

        public Criteria andFeedbackStatusLessThan(String value) {
            addCriterion("FEEDBACK_STATUS <", value, "feedbackStatus");
            return (Criteria) this;
        }

        public Criteria andFeedbackStatusLessThanOrEqualTo(String value) {
            addCriterion("FEEDBACK_STATUS <=", value, "feedbackStatus");
            return (Criteria) this;
        }

        public Criteria andFeedbackStatusLike(String value) {
            addCriterion("FEEDBACK_STATUS like", value, "feedbackStatus");
            return (Criteria) this;
        }

        public Criteria andFeedbackStatusNotLike(String value) {
            addCriterion("FEEDBACK_STATUS not like", value, "feedbackStatus");
            return (Criteria) this;
        }

        public Criteria andFeedbackStatusIn(List<String> values) {
            addCriterion("FEEDBACK_STATUS in", values, "feedbackStatus");
            return (Criteria) this;
        }

        public Criteria andFeedbackStatusNotIn(List<String> values) {
            addCriterion("FEEDBACK_STATUS not in", values, "feedbackStatus");
            return (Criteria) this;
        }

        public Criteria andFeedbackStatusBetween(String value1, String value2) {
            addCriterion("FEEDBACK_STATUS between", value1, value2, "feedbackStatus");
            return (Criteria) this;
        }

        public Criteria andFeedbackStatusNotBetween(String value1, String value2) {
            addCriterion("FEEDBACK_STATUS not between", value1, value2, "feedbackStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusIsNull() {
            addCriterion("AUDIT_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andAuditStatusIsNotNull() {
            addCriterion("AUDIT_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andAuditStatusEqualTo(BigDecimal value) {
            addCriterion("AUDIT_STATUS =", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusNotEqualTo(BigDecimal value) {
            addCriterion("AUDIT_STATUS <>", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusGreaterThan(BigDecimal value) {
            addCriterion("AUDIT_STATUS >", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("AUDIT_STATUS >=", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusLessThan(BigDecimal value) {
            addCriterion("AUDIT_STATUS <", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusLessThanOrEqualTo(BigDecimal value) {
            addCriterion("AUDIT_STATUS <=", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusIn(List<BigDecimal> values) {
            addCriterion("AUDIT_STATUS in", values, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusNotIn(List<BigDecimal> values) {
            addCriterion("AUDIT_STATUS not in", values, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("AUDIT_STATUS between", value1, value2, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("AUDIT_STATUS not between", value1, value2, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("REMARK is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("REMARK is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("REMARK =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("REMARK <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("REMARK >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("REMARK >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("REMARK <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("REMARK <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("REMARK like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("REMARK not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("REMARK in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("REMARK not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("REMARK between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("REMARK not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andIsTmallOrderIsNull() {
            addCriterion("IS_TMALL_ORDER is null");
            return (Criteria) this;
        }

        public Criteria andIsTmallOrderIsNotNull() {
            addCriterion("IS_TMALL_ORDER is not null");
            return (Criteria) this;
        }

        public Criteria andIsTmallOrderEqualTo(BigDecimal value) {
            addCriterion("IS_TMALL_ORDER =", value, "isTmallOrder");
            return (Criteria) this;
        }

        public Criteria andIsTmallOrderNotEqualTo(BigDecimal value) {
            addCriterion("IS_TMALL_ORDER <>", value, "isTmallOrder");
            return (Criteria) this;
        }

        public Criteria andIsTmallOrderGreaterThan(BigDecimal value) {
            addCriterion("IS_TMALL_ORDER >", value, "isTmallOrder");
            return (Criteria) this;
        }

        public Criteria andIsTmallOrderGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("IS_TMALL_ORDER >=", value, "isTmallOrder");
            return (Criteria) this;
        }

        public Criteria andIsTmallOrderLessThan(BigDecimal value) {
            addCriterion("IS_TMALL_ORDER <", value, "isTmallOrder");
            return (Criteria) this;
        }

        public Criteria andIsTmallOrderLessThanOrEqualTo(BigDecimal value) {
            addCriterion("IS_TMALL_ORDER <=", value, "isTmallOrder");
            return (Criteria) this;
        }

        public Criteria andIsTmallOrderIn(List<BigDecimal> values) {
            addCriterion("IS_TMALL_ORDER in", values, "isTmallOrder");
            return (Criteria) this;
        }

        public Criteria andIsTmallOrderNotIn(List<BigDecimal> values) {
            addCriterion("IS_TMALL_ORDER not in", values, "isTmallOrder");
            return (Criteria) this;
        }

        public Criteria andIsTmallOrderBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("IS_TMALL_ORDER between", value1, value2, "isTmallOrder");
            return (Criteria) this;
        }

        public Criteria andIsTmallOrderNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("IS_TMALL_ORDER not between", value1, value2, "isTmallOrder");
            return (Criteria) this;
        }

        public Criteria andOmsDispatchNoIsNull() {
            addCriterion("OMS_DISPATCH_NO is null");
            return (Criteria) this;
        }

        public Criteria andOmsDispatchNoIsNotNull() {
            addCriterion("OMS_DISPATCH_NO is not null");
            return (Criteria) this;
        }

        public Criteria andOmsDispatchNoEqualTo(String value) {
            addCriterion("OMS_DISPATCH_NO =", value, "omsDispatchNo");
            return (Criteria) this;
        }

        public Criteria andOmsDispatchNoNotEqualTo(String value) {
            addCriterion("OMS_DISPATCH_NO <>", value, "omsDispatchNo");
            return (Criteria) this;
        }

        public Criteria andOmsDispatchNoGreaterThan(String value) {
            addCriterion("OMS_DISPATCH_NO >", value, "omsDispatchNo");
            return (Criteria) this;
        }

        public Criteria andOmsDispatchNoGreaterThanOrEqualTo(String value) {
            addCriterion("OMS_DISPATCH_NO >=", value, "omsDispatchNo");
            return (Criteria) this;
        }

        public Criteria andOmsDispatchNoLessThan(String value) {
            addCriterion("OMS_DISPATCH_NO <", value, "omsDispatchNo");
            return (Criteria) this;
        }

        public Criteria andOmsDispatchNoLessThanOrEqualTo(String value) {
            addCriterion("OMS_DISPATCH_NO <=", value, "omsDispatchNo");
            return (Criteria) this;
        }

        public Criteria andOmsDispatchNoLike(String value) {
            addCriterion("OMS_DISPATCH_NO like", value, "omsDispatchNo");
            return (Criteria) this;
        }

        public Criteria andOmsDispatchNoNotLike(String value) {
            addCriterion("OMS_DISPATCH_NO not like", value, "omsDispatchNo");
            return (Criteria) this;
        }

        public Criteria andOmsDispatchNoIn(List<String> values) {
            addCriterion("OMS_DISPATCH_NO in", values, "omsDispatchNo");
            return (Criteria) this;
        }

        public Criteria andOmsDispatchNoNotIn(List<String> values) {
            addCriterion("OMS_DISPATCH_NO not in", values, "omsDispatchNo");
            return (Criteria) this;
        }

        public Criteria andOmsDispatchNoBetween(String value1, String value2) {
            addCriterion("OMS_DISPATCH_NO between", value1, value2, "omsDispatchNo");
            return (Criteria) this;
        }

        public Criteria andOmsDispatchNoNotBetween(String value1, String value2) {
            addCriterion("OMS_DISPATCH_NO not between", value1, value2, "omsDispatchNo");
            return (Criteria) this;
        }

        public Criteria andEvalServiceCompleteIsNull() {
            addCriterion("EVAL_SERVICE_COMPLETE is null");
            return (Criteria) this;
        }

        public Criteria andEvalServiceCompleteIsNotNull() {
            addCriterion("EVAL_SERVICE_COMPLETE is not null");
            return (Criteria) this;
        }

        public Criteria andEvalServiceCompleteEqualTo(BigDecimal value) {
            addCriterion("EVAL_SERVICE_COMPLETE =", value, "evalServiceComplete");
            return (Criteria) this;
        }

        public Criteria andEvalServiceCompleteNotEqualTo(BigDecimal value) {
            addCriterion("EVAL_SERVICE_COMPLETE <>", value, "evalServiceComplete");
            return (Criteria) this;
        }

        public Criteria andEvalServiceCompleteGreaterThan(BigDecimal value) {
            addCriterion("EVAL_SERVICE_COMPLETE >", value, "evalServiceComplete");
            return (Criteria) this;
        }

        public Criteria andEvalServiceCompleteGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("EVAL_SERVICE_COMPLETE >=", value, "evalServiceComplete");
            return (Criteria) this;
        }

        public Criteria andEvalServiceCompleteLessThan(BigDecimal value) {
            addCriterion("EVAL_SERVICE_COMPLETE <", value, "evalServiceComplete");
            return (Criteria) this;
        }

        public Criteria andEvalServiceCompleteLessThanOrEqualTo(BigDecimal value) {
            addCriterion("EVAL_SERVICE_COMPLETE <=", value, "evalServiceComplete");
            return (Criteria) this;
        }

        public Criteria andEvalServiceCompleteIn(List<BigDecimal> values) {
            addCriterion("EVAL_SERVICE_COMPLETE in", values, "evalServiceComplete");
            return (Criteria) this;
        }

        public Criteria andEvalServiceCompleteNotIn(List<BigDecimal> values) {
            addCriterion("EVAL_SERVICE_COMPLETE not in", values, "evalServiceComplete");
            return (Criteria) this;
        }

        public Criteria andEvalServiceCompleteBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("EVAL_SERVICE_COMPLETE between", value1, value2, "evalServiceComplete");
            return (Criteria) this;
        }

        public Criteria andEvalServiceCompleteNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("EVAL_SERVICE_COMPLETE not between", value1, value2, "evalServiceComplete");
            return (Criteria) this;
        }

        public Criteria andEvalDeliveryIsNull() {
            addCriterion("EVAL_DELIVERY is null");
            return (Criteria) this;
        }

        public Criteria andEvalDeliveryIsNotNull() {
            addCriterion("EVAL_DELIVERY is not null");
            return (Criteria) this;
        }

        public Criteria andEvalDeliveryEqualTo(BigDecimal value) {
            addCriterion("EVAL_DELIVERY =", value, "evalDelivery");
            return (Criteria) this;
        }

        public Criteria andEvalDeliveryNotEqualTo(BigDecimal value) {
            addCriterion("EVAL_DELIVERY <>", value, "evalDelivery");
            return (Criteria) this;
        }

        public Criteria andEvalDeliveryGreaterThan(BigDecimal value) {
            addCriterion("EVAL_DELIVERY >", value, "evalDelivery");
            return (Criteria) this;
        }

        public Criteria andEvalDeliveryGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("EVAL_DELIVERY >=", value, "evalDelivery");
            return (Criteria) this;
        }

        public Criteria andEvalDeliveryLessThan(BigDecimal value) {
            addCriterion("EVAL_DELIVERY <", value, "evalDelivery");
            return (Criteria) this;
        }

        public Criteria andEvalDeliveryLessThanOrEqualTo(BigDecimal value) {
            addCriterion("EVAL_DELIVERY <=", value, "evalDelivery");
            return (Criteria) this;
        }

        public Criteria andEvalDeliveryIn(List<BigDecimal> values) {
            addCriterion("EVAL_DELIVERY in", values, "evalDelivery");
            return (Criteria) this;
        }

        public Criteria andEvalDeliveryNotIn(List<BigDecimal> values) {
            addCriterion("EVAL_DELIVERY not in", values, "evalDelivery");
            return (Criteria) this;
        }

        public Criteria andEvalDeliveryBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("EVAL_DELIVERY between", value1, value2, "evalDelivery");
            return (Criteria) this;
        }

        public Criteria andEvalDeliveryNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("EVAL_DELIVERY not between", value1, value2, "evalDelivery");
            return (Criteria) this;
        }

        public Criteria andEvalInstallIsNull() {
            addCriterion("EVAL_INSTALL is null");
            return (Criteria) this;
        }

        public Criteria andEvalInstallIsNotNull() {
            addCriterion("EVAL_INSTALL is not null");
            return (Criteria) this;
        }

        public Criteria andEvalInstallEqualTo(BigDecimal value) {
            addCriterion("EVAL_INSTALL =", value, "evalInstall");
            return (Criteria) this;
        }

        public Criteria andEvalInstallNotEqualTo(BigDecimal value) {
            addCriterion("EVAL_INSTALL <>", value, "evalInstall");
            return (Criteria) this;
        }

        public Criteria andEvalInstallGreaterThan(BigDecimal value) {
            addCriterion("EVAL_INSTALL >", value, "evalInstall");
            return (Criteria) this;
        }

        public Criteria andEvalInstallGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("EVAL_INSTALL >=", value, "evalInstall");
            return (Criteria) this;
        }

        public Criteria andEvalInstallLessThan(BigDecimal value) {
            addCriterion("EVAL_INSTALL <", value, "evalInstall");
            return (Criteria) this;
        }

        public Criteria andEvalInstallLessThanOrEqualTo(BigDecimal value) {
            addCriterion("EVAL_INSTALL <=", value, "evalInstall");
            return (Criteria) this;
        }

        public Criteria andEvalInstallIn(List<BigDecimal> values) {
            addCriterion("EVAL_INSTALL in", values, "evalInstall");
            return (Criteria) this;
        }

        public Criteria andEvalInstallNotIn(List<BigDecimal> values) {
            addCriterion("EVAL_INSTALL not in", values, "evalInstall");
            return (Criteria) this;
        }

        public Criteria andEvalInstallBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("EVAL_INSTALL between", value1, value2, "evalInstall");
            return (Criteria) this;
        }

        public Criteria andEvalInstallNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("EVAL_INSTALL not between", value1, value2, "evalInstall");
            return (Criteria) this;
        }

        public Criteria andEvalPhoneBackIsNull() {
            addCriterion("EVAL_PHONE_BACK is null");
            return (Criteria) this;
        }

        public Criteria andEvalPhoneBackIsNotNull() {
            addCriterion("EVAL_PHONE_BACK is not null");
            return (Criteria) this;
        }

        public Criteria andEvalPhoneBackEqualTo(BigDecimal value) {
            addCriterion("EVAL_PHONE_BACK =", value, "evalPhoneBack");
            return (Criteria) this;
        }

        public Criteria andEvalPhoneBackNotEqualTo(BigDecimal value) {
            addCriterion("EVAL_PHONE_BACK <>", value, "evalPhoneBack");
            return (Criteria) this;
        }

        public Criteria andEvalPhoneBackGreaterThan(BigDecimal value) {
            addCriterion("EVAL_PHONE_BACK >", value, "evalPhoneBack");
            return (Criteria) this;
        }

        public Criteria andEvalPhoneBackGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("EVAL_PHONE_BACK >=", value, "evalPhoneBack");
            return (Criteria) this;
        }

        public Criteria andEvalPhoneBackLessThan(BigDecimal value) {
            addCriterion("EVAL_PHONE_BACK <", value, "evalPhoneBack");
            return (Criteria) this;
        }

        public Criteria andEvalPhoneBackLessThanOrEqualTo(BigDecimal value) {
            addCriterion("EVAL_PHONE_BACK <=", value, "evalPhoneBack");
            return (Criteria) this;
        }

        public Criteria andEvalPhoneBackIn(List<BigDecimal> values) {
            addCriterion("EVAL_PHONE_BACK in", values, "evalPhoneBack");
            return (Criteria) this;
        }

        public Criteria andEvalPhoneBackNotIn(List<BigDecimal> values) {
            addCriterion("EVAL_PHONE_BACK not in", values, "evalPhoneBack");
            return (Criteria) this;
        }

        public Criteria andEvalPhoneBackBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("EVAL_PHONE_BACK between", value1, value2, "evalPhoneBack");
            return (Criteria) this;
        }

        public Criteria andEvalPhoneBackNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("EVAL_PHONE_BACK not between", value1, value2, "evalPhoneBack");
            return (Criteria) this;
        }

        public Criteria andViewTimeIsNull() {
            addCriterion("VIEW_TIME is null");
            return (Criteria) this;
        }

        public Criteria andViewTimeIsNotNull() {
            addCriterion("VIEW_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andViewTimeEqualTo(Date value) {
            addCriterionForJDBCDate("VIEW_TIME =", value, "viewTime");
            return (Criteria) this;
        }

        public Criteria andViewTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("VIEW_TIME <>", value, "viewTime");
            return (Criteria) this;
        }

        public Criteria andViewTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("VIEW_TIME >", value, "viewTime");
            return (Criteria) this;
        }

        public Criteria andViewTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("VIEW_TIME >=", value, "viewTime");
            return (Criteria) this;
        }

        public Criteria andViewTimeLessThan(Date value) {
            addCriterionForJDBCDate("VIEW_TIME <", value, "viewTime");
            return (Criteria) this;
        }

        public Criteria andViewTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("VIEW_TIME <=", value, "viewTime");
            return (Criteria) this;
        }

        public Criteria andViewTimeIn(List<Date> values) {
            addCriterionForJDBCDate("VIEW_TIME in", values, "viewTime");
            return (Criteria) this;
        }

        public Criteria andViewTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("VIEW_TIME not in", values, "viewTime");
            return (Criteria) this;
        }

        public Criteria andViewTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("VIEW_TIME between", value1, value2, "viewTime");
            return (Criteria) this;
        }

        public Criteria andViewTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("VIEW_TIME not between", value1, value2, "viewTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

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