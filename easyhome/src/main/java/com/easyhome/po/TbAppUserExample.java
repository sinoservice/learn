package com.easyhome.po;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TbAppUserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbAppUserExample() {
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

        public Criteria andPhoneIsNull() {
            addCriterion("PHONE is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("PHONE is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("PHONE =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("PHONE <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("PHONE >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("PHONE >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("PHONE <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("PHONE <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("PHONE like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("PHONE not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("PHONE in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("PHONE not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("PHONE between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("PHONE not between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("PASSWORD is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("PASSWORD is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("PASSWORD =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("PASSWORD <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("PASSWORD >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("PASSWORD >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("PASSWORD <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("PASSWORD <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("PASSWORD like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("PASSWORD not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("PASSWORD in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("PASSWORD not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("PASSWORD between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("PASSWORD not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("NAME is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("NAME is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("NAME =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("NAME <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("NAME >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("NAME >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("NAME <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("NAME <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("NAME like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("NAME not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("NAME in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("NAME not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("NAME between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("NAME not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andAddDateIsNull() {
            addCriterion("ADD_DATE is null");
            return (Criteria) this;
        }

        public Criteria andAddDateIsNotNull() {
            addCriterion("ADD_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andAddDateEqualTo(Date value) {
            addCriterionForJDBCDate("ADD_DATE =", value, "addDate");
            return (Criteria) this;
        }

        public Criteria andAddDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("ADD_DATE <>", value, "addDate");
            return (Criteria) this;
        }

        public Criteria andAddDateGreaterThan(Date value) {
            addCriterionForJDBCDate("ADD_DATE >", value, "addDate");
            return (Criteria) this;
        }

        public Criteria andAddDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("ADD_DATE >=", value, "addDate");
            return (Criteria) this;
        }

        public Criteria andAddDateLessThan(Date value) {
            addCriterionForJDBCDate("ADD_DATE <", value, "addDate");
            return (Criteria) this;
        }

        public Criteria andAddDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("ADD_DATE <=", value, "addDate");
            return (Criteria) this;
        }

        public Criteria andAddDateIn(List<Date> values) {
            addCriterionForJDBCDate("ADD_DATE in", values, "addDate");
            return (Criteria) this;
        }

        public Criteria andAddDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("ADD_DATE not in", values, "addDate");
            return (Criteria) this;
        }

        public Criteria andAddDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("ADD_DATE between", value1, value2, "addDate");
            return (Criteria) this;
        }

        public Criteria andAddDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("ADD_DATE not between", value1, value2, "addDate");
            return (Criteria) this;
        }

        public Criteria andIsDisableIsNull() {
            addCriterion("IS_DISABLE is null");
            return (Criteria) this;
        }

        public Criteria andIsDisableIsNotNull() {
            addCriterion("IS_DISABLE is not null");
            return (Criteria) this;
        }

        public Criteria andIsDisableEqualTo(Short value) {
            addCriterion("IS_DISABLE =", value, "isDisable");
            return (Criteria) this;
        }

        public Criteria andIsDisableNotEqualTo(Short value) {
            addCriterion("IS_DISABLE <>", value, "isDisable");
            return (Criteria) this;
        }

        public Criteria andIsDisableGreaterThan(Short value) {
            addCriterion("IS_DISABLE >", value, "isDisable");
            return (Criteria) this;
        }

        public Criteria andIsDisableGreaterThanOrEqualTo(Short value) {
            addCriterion("IS_DISABLE >=", value, "isDisable");
            return (Criteria) this;
        }

        public Criteria andIsDisableLessThan(Short value) {
            addCriterion("IS_DISABLE <", value, "isDisable");
            return (Criteria) this;
        }

        public Criteria andIsDisableLessThanOrEqualTo(Short value) {
            addCriterion("IS_DISABLE <=", value, "isDisable");
            return (Criteria) this;
        }

        public Criteria andIsDisableIn(List<Short> values) {
            addCriterion("IS_DISABLE in", values, "isDisable");
            return (Criteria) this;
        }

        public Criteria andIsDisableNotIn(List<Short> values) {
            addCriterion("IS_DISABLE not in", values, "isDisable");
            return (Criteria) this;
        }

        public Criteria andIsDisableBetween(Short value1, Short value2) {
            addCriterion("IS_DISABLE between", value1, value2, "isDisable");
            return (Criteria) this;
        }

        public Criteria andIsDisableNotBetween(Short value1, Short value2) {
            addCriterion("IS_DISABLE not between", value1, value2, "isDisable");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeIsNull() {
            addCriterion("LAST_LOGIN_TIME is null");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeIsNotNull() {
            addCriterion("LAST_LOGIN_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeEqualTo(Date value) {
            addCriterionForJDBCDate("LAST_LOGIN_TIME =", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("LAST_LOGIN_TIME <>", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("LAST_LOGIN_TIME >", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("LAST_LOGIN_TIME >=", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeLessThan(Date value) {
            addCriterionForJDBCDate("LAST_LOGIN_TIME <", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("LAST_LOGIN_TIME <=", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeIn(List<Date> values) {
            addCriterionForJDBCDate("LAST_LOGIN_TIME in", values, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("LAST_LOGIN_TIME not in", values, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("LAST_LOGIN_TIME between", value1, value2, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("LAST_LOGIN_TIME not between", value1, value2, "lastLoginTime");
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

        public Criteria andSexIsNull() {
            addCriterion("SEX is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("SEX is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(String value) {
            addCriterion("SEX =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(String value) {
            addCriterion("SEX <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(String value) {
            addCriterion("SEX >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(String value) {
            addCriterion("SEX >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(String value) {
            addCriterion("SEX <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(String value) {
            addCriterion("SEX <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLike(String value) {
            addCriterion("SEX like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotLike(String value) {
            addCriterion("SEX not like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<String> values) {
            addCriterion("SEX in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<String> values) {
            addCriterion("SEX not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(String value1, String value2) {
            addCriterion("SEX between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(String value1, String value2) {
            addCriterion("SEX not between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andIsDriverIsNull() {
            addCriterion("IS_DRIVER is null");
            return (Criteria) this;
        }

        public Criteria andIsDriverIsNotNull() {
            addCriterion("IS_DRIVER is not null");
            return (Criteria) this;
        }

        public Criteria andIsDriverEqualTo(BigDecimal value) {
            addCriterion("IS_DRIVER =", value, "isDriver");
            return (Criteria) this;
        }

        public Criteria andIsDriverNotEqualTo(BigDecimal value) {
            addCriterion("IS_DRIVER <>", value, "isDriver");
            return (Criteria) this;
        }

        public Criteria andIsDriverGreaterThan(BigDecimal value) {
            addCriterion("IS_DRIVER >", value, "isDriver");
            return (Criteria) this;
        }

        public Criteria andIsDriverGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("IS_DRIVER >=", value, "isDriver");
            return (Criteria) this;
        }

        public Criteria andIsDriverLessThan(BigDecimal value) {
            addCriterion("IS_DRIVER <", value, "isDriver");
            return (Criteria) this;
        }

        public Criteria andIsDriverLessThanOrEqualTo(BigDecimal value) {
            addCriterion("IS_DRIVER <=", value, "isDriver");
            return (Criteria) this;
        }

        public Criteria andIsDriverIn(List<BigDecimal> values) {
            addCriterion("IS_DRIVER in", values, "isDriver");
            return (Criteria) this;
        }

        public Criteria andIsDriverNotIn(List<BigDecimal> values) {
            addCriterion("IS_DRIVER not in", values, "isDriver");
            return (Criteria) this;
        }

        public Criteria andIsDriverBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("IS_DRIVER between", value1, value2, "isDriver");
            return (Criteria) this;
        }

        public Criteria andIsDriverNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("IS_DRIVER not between", value1, value2, "isDriver");
            return (Criteria) this;
        }

        public Criteria andIsInstallIsNull() {
            addCriterion("IS_INSTALL is null");
            return (Criteria) this;
        }

        public Criteria andIsInstallIsNotNull() {
            addCriterion("IS_INSTALL is not null");
            return (Criteria) this;
        }

        public Criteria andIsInstallEqualTo(BigDecimal value) {
            addCriterion("IS_INSTALL =", value, "isInstall");
            return (Criteria) this;
        }

        public Criteria andIsInstallNotEqualTo(BigDecimal value) {
            addCriterion("IS_INSTALL <>", value, "isInstall");
            return (Criteria) this;
        }

        public Criteria andIsInstallGreaterThan(BigDecimal value) {
            addCriterion("IS_INSTALL >", value, "isInstall");
            return (Criteria) this;
        }

        public Criteria andIsInstallGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("IS_INSTALL >=", value, "isInstall");
            return (Criteria) this;
        }

        public Criteria andIsInstallLessThan(BigDecimal value) {
            addCriterion("IS_INSTALL <", value, "isInstall");
            return (Criteria) this;
        }

        public Criteria andIsInstallLessThanOrEqualTo(BigDecimal value) {
            addCriterion("IS_INSTALL <=", value, "isInstall");
            return (Criteria) this;
        }

        public Criteria andIsInstallIn(List<BigDecimal> values) {
            addCriterion("IS_INSTALL in", values, "isInstall");
            return (Criteria) this;
        }

        public Criteria andIsInstallNotIn(List<BigDecimal> values) {
            addCriterion("IS_INSTALL not in", values, "isInstall");
            return (Criteria) this;
        }

        public Criteria andIsInstallBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("IS_INSTALL between", value1, value2, "isInstall");
            return (Criteria) this;
        }

        public Criteria andIsInstallNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("IS_INSTALL not between", value1, value2, "isInstall");
            return (Criteria) this;
        }

        public Criteria andDriverIdIsNull() {
            addCriterion("DRIVER_ID is null");
            return (Criteria) this;
        }

        public Criteria andDriverIdIsNotNull() {
            addCriterion("DRIVER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andDriverIdEqualTo(BigDecimal value) {
            addCriterion("DRIVER_ID =", value, "driverId");
            return (Criteria) this;
        }

        public Criteria andDriverIdNotEqualTo(BigDecimal value) {
            addCriterion("DRIVER_ID <>", value, "driverId");
            return (Criteria) this;
        }

        public Criteria andDriverIdGreaterThan(BigDecimal value) {
            addCriterion("DRIVER_ID >", value, "driverId");
            return (Criteria) this;
        }

        public Criteria andDriverIdGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("DRIVER_ID >=", value, "driverId");
            return (Criteria) this;
        }

        public Criteria andDriverIdLessThan(BigDecimal value) {
            addCriterion("DRIVER_ID <", value, "driverId");
            return (Criteria) this;
        }

        public Criteria andDriverIdLessThanOrEqualTo(BigDecimal value) {
            addCriterion("DRIVER_ID <=", value, "driverId");
            return (Criteria) this;
        }

        public Criteria andDriverIdIn(List<BigDecimal> values) {
            addCriterion("DRIVER_ID in", values, "driverId");
            return (Criteria) this;
        }

        public Criteria andDriverIdNotIn(List<BigDecimal> values) {
            addCriterion("DRIVER_ID not in", values, "driverId");
            return (Criteria) this;
        }

        public Criteria andDriverIdBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DRIVER_ID between", value1, value2, "driverId");
            return (Criteria) this;
        }

        public Criteria andDriverIdNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DRIVER_ID not between", value1, value2, "driverId");
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

        public Criteria andDriverNameIsNull() {
            addCriterion("DRIVER_NAME is null");
            return (Criteria) this;
        }

        public Criteria andDriverNameIsNotNull() {
            addCriterion("DRIVER_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andDriverNameEqualTo(String value) {
            addCriterion("DRIVER_NAME =", value, "driverName");
            return (Criteria) this;
        }

        public Criteria andDriverNameNotEqualTo(String value) {
            addCriterion("DRIVER_NAME <>", value, "driverName");
            return (Criteria) this;
        }

        public Criteria andDriverNameGreaterThan(String value) {
            addCriterion("DRIVER_NAME >", value, "driverName");
            return (Criteria) this;
        }

        public Criteria andDriverNameGreaterThanOrEqualTo(String value) {
            addCriterion("DRIVER_NAME >=", value, "driverName");
            return (Criteria) this;
        }

        public Criteria andDriverNameLessThan(String value) {
            addCriterion("DRIVER_NAME <", value, "driverName");
            return (Criteria) this;
        }

        public Criteria andDriverNameLessThanOrEqualTo(String value) {
            addCriterion("DRIVER_NAME <=", value, "driverName");
            return (Criteria) this;
        }

        public Criteria andDriverNameLike(String value) {
            addCriterion("DRIVER_NAME like", value, "driverName");
            return (Criteria) this;
        }

        public Criteria andDriverNameNotLike(String value) {
            addCriterion("DRIVER_NAME not like", value, "driverName");
            return (Criteria) this;
        }

        public Criteria andDriverNameIn(List<String> values) {
            addCriterion("DRIVER_NAME in", values, "driverName");
            return (Criteria) this;
        }

        public Criteria andDriverNameNotIn(List<String> values) {
            addCriterion("DRIVER_NAME not in", values, "driverName");
            return (Criteria) this;
        }

        public Criteria andDriverNameBetween(String value1, String value2) {
            addCriterion("DRIVER_NAME between", value1, value2, "driverName");
            return (Criteria) this;
        }

        public Criteria andDriverNameNotBetween(String value1, String value2) {
            addCriterion("DRIVER_NAME not between", value1, value2, "driverName");
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

        public Criteria andPlatFormIdIsNull() {
            addCriterion("PLAT_FORM_ID is null");
            return (Criteria) this;
        }

        public Criteria andPlatFormIdIsNotNull() {
            addCriterion("PLAT_FORM_ID is not null");
            return (Criteria) this;
        }

        public Criteria andPlatFormIdEqualTo(BigDecimal value) {
            addCriterion("PLAT_FORM_ID =", value, "platFormId");
            return (Criteria) this;
        }

        public Criteria andPlatFormIdNotEqualTo(BigDecimal value) {
            addCriterion("PLAT_FORM_ID <>", value, "platFormId");
            return (Criteria) this;
        }

        public Criteria andPlatFormIdGreaterThan(BigDecimal value) {
            addCriterion("PLAT_FORM_ID >", value, "platFormId");
            return (Criteria) this;
        }

        public Criteria andPlatFormIdGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PLAT_FORM_ID >=", value, "platFormId");
            return (Criteria) this;
        }

        public Criteria andPlatFormIdLessThan(BigDecimal value) {
            addCriterion("PLAT_FORM_ID <", value, "platFormId");
            return (Criteria) this;
        }

        public Criteria andPlatFormIdLessThanOrEqualTo(BigDecimal value) {
            addCriterion("PLAT_FORM_ID <=", value, "platFormId");
            return (Criteria) this;
        }

        public Criteria andPlatFormIdIn(List<BigDecimal> values) {
            addCriterion("PLAT_FORM_ID in", values, "platFormId");
            return (Criteria) this;
        }

        public Criteria andPlatFormIdNotIn(List<BigDecimal> values) {
            addCriterion("PLAT_FORM_ID not in", values, "platFormId");
            return (Criteria) this;
        }

        public Criteria andPlatFormIdBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PLAT_FORM_ID between", value1, value2, "platFormId");
            return (Criteria) this;
        }

        public Criteria andPlatFormIdNotBetween(BigDecimal value1, BigDecimal value2) {
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

        public Criteria andIsModifyPwdIsNull() {
            addCriterion("IS_MODIFY_PWD is null");
            return (Criteria) this;
        }

        public Criteria andIsModifyPwdIsNotNull() {
            addCriterion("IS_MODIFY_PWD is not null");
            return (Criteria) this;
        }

        public Criteria andIsModifyPwdEqualTo(Short value) {
            addCriterion("IS_MODIFY_PWD =", value, "isModifyPwd");
            return (Criteria) this;
        }

        public Criteria andIsModifyPwdNotEqualTo(Short value) {
            addCriterion("IS_MODIFY_PWD <>", value, "isModifyPwd");
            return (Criteria) this;
        }

        public Criteria andIsModifyPwdGreaterThan(Short value) {
            addCriterion("IS_MODIFY_PWD >", value, "isModifyPwd");
            return (Criteria) this;
        }

        public Criteria andIsModifyPwdGreaterThanOrEqualTo(Short value) {
            addCriterion("IS_MODIFY_PWD >=", value, "isModifyPwd");
            return (Criteria) this;
        }

        public Criteria andIsModifyPwdLessThan(Short value) {
            addCriterion("IS_MODIFY_PWD <", value, "isModifyPwd");
            return (Criteria) this;
        }

        public Criteria andIsModifyPwdLessThanOrEqualTo(Short value) {
            addCriterion("IS_MODIFY_PWD <=", value, "isModifyPwd");
            return (Criteria) this;
        }

        public Criteria andIsModifyPwdIn(List<Short> values) {
            addCriterion("IS_MODIFY_PWD in", values, "isModifyPwd");
            return (Criteria) this;
        }

        public Criteria andIsModifyPwdNotIn(List<Short> values) {
            addCriterion("IS_MODIFY_PWD not in", values, "isModifyPwd");
            return (Criteria) this;
        }

        public Criteria andIsModifyPwdBetween(Short value1, Short value2) {
            addCriterion("IS_MODIFY_PWD between", value1, value2, "isModifyPwd");
            return (Criteria) this;
        }

        public Criteria andIsModifyPwdNotBetween(Short value1, Short value2) {
            addCriterion("IS_MODIFY_PWD not between", value1, value2, "isModifyPwd");
            return (Criteria) this;
        }

        public Criteria andUserTypeIsNull() {
            addCriterion("USER_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andUserTypeIsNotNull() {
            addCriterion("USER_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andUserTypeEqualTo(Short value) {
            addCriterion("USER_TYPE =", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotEqualTo(Short value) {
            addCriterion("USER_TYPE <>", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeGreaterThan(Short value) {
            addCriterion("USER_TYPE >", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeGreaterThanOrEqualTo(Short value) {
            addCriterion("USER_TYPE >=", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeLessThan(Short value) {
            addCriterion("USER_TYPE <", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeLessThanOrEqualTo(Short value) {
            addCriterion("USER_TYPE <=", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeIn(List<Short> values) {
            addCriterion("USER_TYPE in", values, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotIn(List<Short> values) {
            addCriterion("USER_TYPE not in", values, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeBetween(Short value1, Short value2) {
            addCriterion("USER_TYPE between", value1, value2, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotBetween(Short value1, Short value2) {
            addCriterion("USER_TYPE not between", value1, value2, "userType");
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