package com.easyhome.po;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TbMasterExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbMasterExample() {
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

        public Criteria andSkillIsNull() {
            addCriterion("SKILL is null");
            return (Criteria) this;
        }

        public Criteria andSkillIsNotNull() {
            addCriterion("SKILL is not null");
            return (Criteria) this;
        }

        public Criteria andSkillEqualTo(String value) {
            addCriterion("SKILL =", value, "skill");
            return (Criteria) this;
        }

        public Criteria andSkillNotEqualTo(String value) {
            addCriterion("SKILL <>", value, "skill");
            return (Criteria) this;
        }

        public Criteria andSkillGreaterThan(String value) {
            addCriterion("SKILL >", value, "skill");
            return (Criteria) this;
        }

        public Criteria andSkillGreaterThanOrEqualTo(String value) {
            addCriterion("SKILL >=", value, "skill");
            return (Criteria) this;
        }

        public Criteria andSkillLessThan(String value) {
            addCriterion("SKILL <", value, "skill");
            return (Criteria) this;
        }

        public Criteria andSkillLessThanOrEqualTo(String value) {
            addCriterion("SKILL <=", value, "skill");
            return (Criteria) this;
        }

        public Criteria andSkillLike(String value) {
            addCriterion("SKILL like", value, "skill");
            return (Criteria) this;
        }

        public Criteria andSkillNotLike(String value) {
            addCriterion("SKILL not like", value, "skill");
            return (Criteria) this;
        }

        public Criteria andSkillIn(List<String> values) {
            addCriterion("SKILL in", values, "skill");
            return (Criteria) this;
        }

        public Criteria andSkillNotIn(List<String> values) {
            addCriterion("SKILL not in", values, "skill");
            return (Criteria) this;
        }

        public Criteria andSkillBetween(String value1, String value2) {
            addCriterion("SKILL between", value1, value2, "skill");
            return (Criteria) this;
        }

        public Criteria andSkillNotBetween(String value1, String value2) {
            addCriterion("SKILL not between", value1, value2, "skill");
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

        public Criteria andSkillNameIsNull() {
            addCriterion("SKILL_NAME is null");
            return (Criteria) this;
        }

        public Criteria andSkillNameIsNotNull() {
            addCriterion("SKILL_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andSkillNameEqualTo(String value) {
            addCriterion("SKILL_NAME =", value, "skillName");
            return (Criteria) this;
        }

        public Criteria andSkillNameNotEqualTo(String value) {
            addCriterion("SKILL_NAME <>", value, "skillName");
            return (Criteria) this;
        }

        public Criteria andSkillNameGreaterThan(String value) {
            addCriterion("SKILL_NAME >", value, "skillName");
            return (Criteria) this;
        }

        public Criteria andSkillNameGreaterThanOrEqualTo(String value) {
            addCriterion("SKILL_NAME >=", value, "skillName");
            return (Criteria) this;
        }

        public Criteria andSkillNameLessThan(String value) {
            addCriterion("SKILL_NAME <", value, "skillName");
            return (Criteria) this;
        }

        public Criteria andSkillNameLessThanOrEqualTo(String value) {
            addCriterion("SKILL_NAME <=", value, "skillName");
            return (Criteria) this;
        }

        public Criteria andSkillNameLike(String value) {
            addCriterion("SKILL_NAME like", value, "skillName");
            return (Criteria) this;
        }

        public Criteria andSkillNameNotLike(String value) {
            addCriterion("SKILL_NAME not like", value, "skillName");
            return (Criteria) this;
        }

        public Criteria andSkillNameIn(List<String> values) {
            addCriterion("SKILL_NAME in", values, "skillName");
            return (Criteria) this;
        }

        public Criteria andSkillNameNotIn(List<String> values) {
            addCriterion("SKILL_NAME not in", values, "skillName");
            return (Criteria) this;
        }

        public Criteria andSkillNameBetween(String value1, String value2) {
            addCriterion("SKILL_NAME between", value1, value2, "skillName");
            return (Criteria) this;
        }

        public Criteria andSkillNameNotBetween(String value1, String value2) {
            addCriterion("SKILL_NAME not between", value1, value2, "skillName");
            return (Criteria) this;
        }

        public Criteria andIdentityCardIsNull() {
            addCriterion("IDENTITY_CARD is null");
            return (Criteria) this;
        }

        public Criteria andIdentityCardIsNotNull() {
            addCriterion("IDENTITY_CARD is not null");
            return (Criteria) this;
        }

        public Criteria andIdentityCardEqualTo(String value) {
            addCriterion("IDENTITY_CARD =", value, "identityCard");
            return (Criteria) this;
        }

        public Criteria andIdentityCardNotEqualTo(String value) {
            addCriterion("IDENTITY_CARD <>", value, "identityCard");
            return (Criteria) this;
        }

        public Criteria andIdentityCardGreaterThan(String value) {
            addCriterion("IDENTITY_CARD >", value, "identityCard");
            return (Criteria) this;
        }

        public Criteria andIdentityCardGreaterThanOrEqualTo(String value) {
            addCriterion("IDENTITY_CARD >=", value, "identityCard");
            return (Criteria) this;
        }

        public Criteria andIdentityCardLessThan(String value) {
            addCriterion("IDENTITY_CARD <", value, "identityCard");
            return (Criteria) this;
        }

        public Criteria andIdentityCardLessThanOrEqualTo(String value) {
            addCriterion("IDENTITY_CARD <=", value, "identityCard");
            return (Criteria) this;
        }

        public Criteria andIdentityCardLike(String value) {
            addCriterion("IDENTITY_CARD like", value, "identityCard");
            return (Criteria) this;
        }

        public Criteria andIdentityCardNotLike(String value) {
            addCriterion("IDENTITY_CARD not like", value, "identityCard");
            return (Criteria) this;
        }

        public Criteria andIdentityCardIn(List<String> values) {
            addCriterion("IDENTITY_CARD in", values, "identityCard");
            return (Criteria) this;
        }

        public Criteria andIdentityCardNotIn(List<String> values) {
            addCriterion("IDENTITY_CARD not in", values, "identityCard");
            return (Criteria) this;
        }

        public Criteria andIdentityCardBetween(String value1, String value2) {
            addCriterion("IDENTITY_CARD between", value1, value2, "identityCard");
            return (Criteria) this;
        }

        public Criteria andIdentityCardNotBetween(String value1, String value2) {
            addCriterion("IDENTITY_CARD not between", value1, value2, "identityCard");
            return (Criteria) this;
        }

        public Criteria andCityIsNull() {
            addCriterion("CITY is null");
            return (Criteria) this;
        }

        public Criteria andCityIsNotNull() {
            addCriterion("CITY is not null");
            return (Criteria) this;
        }

        public Criteria andCityEqualTo(String value) {
            addCriterion("CITY =", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotEqualTo(String value) {
            addCriterion("CITY <>", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThan(String value) {
            addCriterion("CITY >", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThanOrEqualTo(String value) {
            addCriterion("CITY >=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThan(String value) {
            addCriterion("CITY <", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThanOrEqualTo(String value) {
            addCriterion("CITY <=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLike(String value) {
            addCriterion("CITY like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotLike(String value) {
            addCriterion("CITY not like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityIn(List<String> values) {
            addCriterion("CITY in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotIn(List<String> values) {
            addCriterion("CITY not in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityBetween(String value1, String value2) {
            addCriterion("CITY between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotBetween(String value1, String value2) {
            addCriterion("CITY not between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andOrganizeIdIsNull() {
            addCriterion("ORGANIZE_ID is null");
            return (Criteria) this;
        }

        public Criteria andOrganizeIdIsNotNull() {
            addCriterion("ORGANIZE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andOrganizeIdEqualTo(String value) {
            addCriterion("ORGANIZE_ID =", value, "organizeId");
            return (Criteria) this;
        }

        public Criteria andOrganizeIdNotEqualTo(String value) {
            addCriterion("ORGANIZE_ID <>", value, "organizeId");
            return (Criteria) this;
        }

        public Criteria andOrganizeIdGreaterThan(String value) {
            addCriterion("ORGANIZE_ID >", value, "organizeId");
            return (Criteria) this;
        }

        public Criteria andOrganizeIdGreaterThanOrEqualTo(String value) {
            addCriterion("ORGANIZE_ID >=", value, "organizeId");
            return (Criteria) this;
        }

        public Criteria andOrganizeIdLessThan(String value) {
            addCriterion("ORGANIZE_ID <", value, "organizeId");
            return (Criteria) this;
        }

        public Criteria andOrganizeIdLessThanOrEqualTo(String value) {
            addCriterion("ORGANIZE_ID <=", value, "organizeId");
            return (Criteria) this;
        }

        public Criteria andOrganizeIdLike(String value) {
            addCriterion("ORGANIZE_ID like", value, "organizeId");
            return (Criteria) this;
        }

        public Criteria andOrganizeIdNotLike(String value) {
            addCriterion("ORGANIZE_ID not like", value, "organizeId");
            return (Criteria) this;
        }

        public Criteria andOrganizeIdIn(List<String> values) {
            addCriterion("ORGANIZE_ID in", values, "organizeId");
            return (Criteria) this;
        }

        public Criteria andOrganizeIdNotIn(List<String> values) {
            addCriterion("ORGANIZE_ID not in", values, "organizeId");
            return (Criteria) this;
        }

        public Criteria andOrganizeIdBetween(String value1, String value2) {
            addCriterion("ORGANIZE_ID between", value1, value2, "organizeId");
            return (Criteria) this;
        }

        public Criteria andOrganizeIdNotBetween(String value1, String value2) {
            addCriterion("ORGANIZE_ID not between", value1, value2, "organizeId");
            return (Criteria) this;
        }

        public Criteria andOrganizeNameIsNull() {
            addCriterion("ORGANIZE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andOrganizeNameIsNotNull() {
            addCriterion("ORGANIZE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andOrganizeNameEqualTo(String value) {
            addCriterion("ORGANIZE_NAME =", value, "organizeName");
            return (Criteria) this;
        }

        public Criteria andOrganizeNameNotEqualTo(String value) {
            addCriterion("ORGANIZE_NAME <>", value, "organizeName");
            return (Criteria) this;
        }

        public Criteria andOrganizeNameGreaterThan(String value) {
            addCriterion("ORGANIZE_NAME >", value, "organizeName");
            return (Criteria) this;
        }

        public Criteria andOrganizeNameGreaterThanOrEqualTo(String value) {
            addCriterion("ORGANIZE_NAME >=", value, "organizeName");
            return (Criteria) this;
        }

        public Criteria andOrganizeNameLessThan(String value) {
            addCriterion("ORGANIZE_NAME <", value, "organizeName");
            return (Criteria) this;
        }

        public Criteria andOrganizeNameLessThanOrEqualTo(String value) {
            addCriterion("ORGANIZE_NAME <=", value, "organizeName");
            return (Criteria) this;
        }

        public Criteria andOrganizeNameLike(String value) {
            addCriterion("ORGANIZE_NAME like", value, "organizeName");
            return (Criteria) this;
        }

        public Criteria andOrganizeNameNotLike(String value) {
            addCriterion("ORGANIZE_NAME not like", value, "organizeName");
            return (Criteria) this;
        }

        public Criteria andOrganizeNameIn(List<String> values) {
            addCriterion("ORGANIZE_NAME in", values, "organizeName");
            return (Criteria) this;
        }

        public Criteria andOrganizeNameNotIn(List<String> values) {
            addCriterion("ORGANIZE_NAME not in", values, "organizeName");
            return (Criteria) this;
        }

        public Criteria andOrganizeNameBetween(String value1, String value2) {
            addCriterion("ORGANIZE_NAME between", value1, value2, "organizeName");
            return (Criteria) this;
        }

        public Criteria andOrganizeNameNotBetween(String value1, String value2) {
            addCriterion("ORGANIZE_NAME not between", value1, value2, "organizeName");
            return (Criteria) this;
        }

        public Criteria andWorkTypeIsNull() {
            addCriterion("WORK_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andWorkTypeIsNotNull() {
            addCriterion("WORK_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andWorkTypeEqualTo(String value) {
            addCriterion("WORK_TYPE =", value, "workType");
            return (Criteria) this;
        }

        public Criteria andWorkTypeNotEqualTo(String value) {
            addCriterion("WORK_TYPE <>", value, "workType");
            return (Criteria) this;
        }

        public Criteria andWorkTypeGreaterThan(String value) {
            addCriterion("WORK_TYPE >", value, "workType");
            return (Criteria) this;
        }

        public Criteria andWorkTypeGreaterThanOrEqualTo(String value) {
            addCriterion("WORK_TYPE >=", value, "workType");
            return (Criteria) this;
        }

        public Criteria andWorkTypeLessThan(String value) {
            addCriterion("WORK_TYPE <", value, "workType");
            return (Criteria) this;
        }

        public Criteria andWorkTypeLessThanOrEqualTo(String value) {
            addCriterion("WORK_TYPE <=", value, "workType");
            return (Criteria) this;
        }

        public Criteria andWorkTypeLike(String value) {
            addCriterion("WORK_TYPE like", value, "workType");
            return (Criteria) this;
        }

        public Criteria andWorkTypeNotLike(String value) {
            addCriterion("WORK_TYPE not like", value, "workType");
            return (Criteria) this;
        }

        public Criteria andWorkTypeIn(List<String> values) {
            addCriterion("WORK_TYPE in", values, "workType");
            return (Criteria) this;
        }

        public Criteria andWorkTypeNotIn(List<String> values) {
            addCriterion("WORK_TYPE not in", values, "workType");
            return (Criteria) this;
        }

        public Criteria andWorkTypeBetween(String value1, String value2) {
            addCriterion("WORK_TYPE between", value1, value2, "workType");
            return (Criteria) this;
        }

        public Criteria andWorkTypeNotBetween(String value1, String value2) {
            addCriterion("WORK_TYPE not between", value1, value2, "workType");
            return (Criteria) this;
        }

        public Criteria andWorkTypeDisplayIsNull() {
            addCriterion("WORK_TYPE_DISPLAY is null");
            return (Criteria) this;
        }

        public Criteria andWorkTypeDisplayIsNotNull() {
            addCriterion("WORK_TYPE_DISPLAY is not null");
            return (Criteria) this;
        }

        public Criteria andWorkTypeDisplayEqualTo(String value) {
            addCriterion("WORK_TYPE_DISPLAY =", value, "workTypeDisplay");
            return (Criteria) this;
        }

        public Criteria andWorkTypeDisplayNotEqualTo(String value) {
            addCriterion("WORK_TYPE_DISPLAY <>", value, "workTypeDisplay");
            return (Criteria) this;
        }

        public Criteria andWorkTypeDisplayGreaterThan(String value) {
            addCriterion("WORK_TYPE_DISPLAY >", value, "workTypeDisplay");
            return (Criteria) this;
        }

        public Criteria andWorkTypeDisplayGreaterThanOrEqualTo(String value) {
            addCriterion("WORK_TYPE_DISPLAY >=", value, "workTypeDisplay");
            return (Criteria) this;
        }

        public Criteria andWorkTypeDisplayLessThan(String value) {
            addCriterion("WORK_TYPE_DISPLAY <", value, "workTypeDisplay");
            return (Criteria) this;
        }

        public Criteria andWorkTypeDisplayLessThanOrEqualTo(String value) {
            addCriterion("WORK_TYPE_DISPLAY <=", value, "workTypeDisplay");
            return (Criteria) this;
        }

        public Criteria andWorkTypeDisplayLike(String value) {
            addCriterion("WORK_TYPE_DISPLAY like", value, "workTypeDisplay");
            return (Criteria) this;
        }

        public Criteria andWorkTypeDisplayNotLike(String value) {
            addCriterion("WORK_TYPE_DISPLAY not like", value, "workTypeDisplay");
            return (Criteria) this;
        }

        public Criteria andWorkTypeDisplayIn(List<String> values) {
            addCriterion("WORK_TYPE_DISPLAY in", values, "workTypeDisplay");
            return (Criteria) this;
        }

        public Criteria andWorkTypeDisplayNotIn(List<String> values) {
            addCriterion("WORK_TYPE_DISPLAY not in", values, "workTypeDisplay");
            return (Criteria) this;
        }

        public Criteria andWorkTypeDisplayBetween(String value1, String value2) {
            addCriterion("WORK_TYPE_DISPLAY between", value1, value2, "workTypeDisplay");
            return (Criteria) this;
        }

        public Criteria andWorkTypeDisplayNotBetween(String value1, String value2) {
            addCriterion("WORK_TYPE_DISPLAY not between", value1, value2, "workTypeDisplay");
            return (Criteria) this;
        }

        public Criteria andServiceProvinceIsNull() {
            addCriterion("SERVICE_PROVINCE is null");
            return (Criteria) this;
        }

        public Criteria andServiceProvinceIsNotNull() {
            addCriterion("SERVICE_PROVINCE is not null");
            return (Criteria) this;
        }

        public Criteria andServiceProvinceEqualTo(String value) {
            addCriterion("SERVICE_PROVINCE =", value, "serviceProvince");
            return (Criteria) this;
        }

        public Criteria andServiceProvinceNotEqualTo(String value) {
            addCriterion("SERVICE_PROVINCE <>", value, "serviceProvince");
            return (Criteria) this;
        }

        public Criteria andServiceProvinceGreaterThan(String value) {
            addCriterion("SERVICE_PROVINCE >", value, "serviceProvince");
            return (Criteria) this;
        }

        public Criteria andServiceProvinceGreaterThanOrEqualTo(String value) {
            addCriterion("SERVICE_PROVINCE >=", value, "serviceProvince");
            return (Criteria) this;
        }

        public Criteria andServiceProvinceLessThan(String value) {
            addCriterion("SERVICE_PROVINCE <", value, "serviceProvince");
            return (Criteria) this;
        }

        public Criteria andServiceProvinceLessThanOrEqualTo(String value) {
            addCriterion("SERVICE_PROVINCE <=", value, "serviceProvince");
            return (Criteria) this;
        }

        public Criteria andServiceProvinceLike(String value) {
            addCriterion("SERVICE_PROVINCE like", value, "serviceProvince");
            return (Criteria) this;
        }

        public Criteria andServiceProvinceNotLike(String value) {
            addCriterion("SERVICE_PROVINCE not like", value, "serviceProvince");
            return (Criteria) this;
        }

        public Criteria andServiceProvinceIn(List<String> values) {
            addCriterion("SERVICE_PROVINCE in", values, "serviceProvince");
            return (Criteria) this;
        }

        public Criteria andServiceProvinceNotIn(List<String> values) {
            addCriterion("SERVICE_PROVINCE not in", values, "serviceProvince");
            return (Criteria) this;
        }

        public Criteria andServiceProvinceBetween(String value1, String value2) {
            addCriterion("SERVICE_PROVINCE between", value1, value2, "serviceProvince");
            return (Criteria) this;
        }

        public Criteria andServiceProvinceNotBetween(String value1, String value2) {
            addCriterion("SERVICE_PROVINCE not between", value1, value2, "serviceProvince");
            return (Criteria) this;
        }

        public Criteria andServiceCityIsNull() {
            addCriterion("SERVICE_CITY is null");
            return (Criteria) this;
        }

        public Criteria andServiceCityIsNotNull() {
            addCriterion("SERVICE_CITY is not null");
            return (Criteria) this;
        }

        public Criteria andServiceCityEqualTo(String value) {
            addCriterion("SERVICE_CITY =", value, "serviceCity");
            return (Criteria) this;
        }

        public Criteria andServiceCityNotEqualTo(String value) {
            addCriterion("SERVICE_CITY <>", value, "serviceCity");
            return (Criteria) this;
        }

        public Criteria andServiceCityGreaterThan(String value) {
            addCriterion("SERVICE_CITY >", value, "serviceCity");
            return (Criteria) this;
        }

        public Criteria andServiceCityGreaterThanOrEqualTo(String value) {
            addCriterion("SERVICE_CITY >=", value, "serviceCity");
            return (Criteria) this;
        }

        public Criteria andServiceCityLessThan(String value) {
            addCriterion("SERVICE_CITY <", value, "serviceCity");
            return (Criteria) this;
        }

        public Criteria andServiceCityLessThanOrEqualTo(String value) {
            addCriterion("SERVICE_CITY <=", value, "serviceCity");
            return (Criteria) this;
        }

        public Criteria andServiceCityLike(String value) {
            addCriterion("SERVICE_CITY like", value, "serviceCity");
            return (Criteria) this;
        }

        public Criteria andServiceCityNotLike(String value) {
            addCriterion("SERVICE_CITY not like", value, "serviceCity");
            return (Criteria) this;
        }

        public Criteria andServiceCityIn(List<String> values) {
            addCriterion("SERVICE_CITY in", values, "serviceCity");
            return (Criteria) this;
        }

        public Criteria andServiceCityNotIn(List<String> values) {
            addCriterion("SERVICE_CITY not in", values, "serviceCity");
            return (Criteria) this;
        }

        public Criteria andServiceCityBetween(String value1, String value2) {
            addCriterion("SERVICE_CITY between", value1, value2, "serviceCity");
            return (Criteria) this;
        }

        public Criteria andServiceCityNotBetween(String value1, String value2) {
            addCriterion("SERVICE_CITY not between", value1, value2, "serviceCity");
            return (Criteria) this;
        }

        public Criteria andServiceDistrictIsNull() {
            addCriterion("SERVICE_DISTRICT is null");
            return (Criteria) this;
        }

        public Criteria andServiceDistrictIsNotNull() {
            addCriterion("SERVICE_DISTRICT is not null");
            return (Criteria) this;
        }

        public Criteria andServiceDistrictEqualTo(String value) {
            addCriterion("SERVICE_DISTRICT =", value, "serviceDistrict");
            return (Criteria) this;
        }

        public Criteria andServiceDistrictNotEqualTo(String value) {
            addCriterion("SERVICE_DISTRICT <>", value, "serviceDistrict");
            return (Criteria) this;
        }

        public Criteria andServiceDistrictGreaterThan(String value) {
            addCriterion("SERVICE_DISTRICT >", value, "serviceDistrict");
            return (Criteria) this;
        }

        public Criteria andServiceDistrictGreaterThanOrEqualTo(String value) {
            addCriterion("SERVICE_DISTRICT >=", value, "serviceDistrict");
            return (Criteria) this;
        }

        public Criteria andServiceDistrictLessThan(String value) {
            addCriterion("SERVICE_DISTRICT <", value, "serviceDistrict");
            return (Criteria) this;
        }

        public Criteria andServiceDistrictLessThanOrEqualTo(String value) {
            addCriterion("SERVICE_DISTRICT <=", value, "serviceDistrict");
            return (Criteria) this;
        }

        public Criteria andServiceDistrictLike(String value) {
            addCriterion("SERVICE_DISTRICT like", value, "serviceDistrict");
            return (Criteria) this;
        }

        public Criteria andServiceDistrictNotLike(String value) {
            addCriterion("SERVICE_DISTRICT not like", value, "serviceDistrict");
            return (Criteria) this;
        }

        public Criteria andServiceDistrictIn(List<String> values) {
            addCriterion("SERVICE_DISTRICT in", values, "serviceDistrict");
            return (Criteria) this;
        }

        public Criteria andServiceDistrictNotIn(List<String> values) {
            addCriterion("SERVICE_DISTRICT not in", values, "serviceDistrict");
            return (Criteria) this;
        }

        public Criteria andServiceDistrictBetween(String value1, String value2) {
            addCriterion("SERVICE_DISTRICT between", value1, value2, "serviceDistrict");
            return (Criteria) this;
        }

        public Criteria andServiceDistrictNotBetween(String value1, String value2) {
            addCriterion("SERVICE_DISTRICT not between", value1, value2, "serviceDistrict");
            return (Criteria) this;
        }

        public Criteria andBankAccountIsNull() {
            addCriterion("BANK_ACCOUNT is null");
            return (Criteria) this;
        }

        public Criteria andBankAccountIsNotNull() {
            addCriterion("BANK_ACCOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andBankAccountEqualTo(String value) {
            addCriterion("BANK_ACCOUNT =", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountNotEqualTo(String value) {
            addCriterion("BANK_ACCOUNT <>", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountGreaterThan(String value) {
            addCriterion("BANK_ACCOUNT >", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountGreaterThanOrEqualTo(String value) {
            addCriterion("BANK_ACCOUNT >=", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountLessThan(String value) {
            addCriterion("BANK_ACCOUNT <", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountLessThanOrEqualTo(String value) {
            addCriterion("BANK_ACCOUNT <=", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountLike(String value) {
            addCriterion("BANK_ACCOUNT like", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountNotLike(String value) {
            addCriterion("BANK_ACCOUNT not like", value, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountIn(List<String> values) {
            addCriterion("BANK_ACCOUNT in", values, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountNotIn(List<String> values) {
            addCriterion("BANK_ACCOUNT not in", values, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountBetween(String value1, String value2) {
            addCriterion("BANK_ACCOUNT between", value1, value2, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankAccountNotBetween(String value1, String value2) {
            addCriterion("BANK_ACCOUNT not between", value1, value2, "bankAccount");
            return (Criteria) this;
        }

        public Criteria andBankNameIsNull() {
            addCriterion("BANK_NAME is null");
            return (Criteria) this;
        }

        public Criteria andBankNameIsNotNull() {
            addCriterion("BANK_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andBankNameEqualTo(String value) {
            addCriterion("BANK_NAME =", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameNotEqualTo(String value) {
            addCriterion("BANK_NAME <>", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameGreaterThan(String value) {
            addCriterion("BANK_NAME >", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameGreaterThanOrEqualTo(String value) {
            addCriterion("BANK_NAME >=", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameLessThan(String value) {
            addCriterion("BANK_NAME <", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameLessThanOrEqualTo(String value) {
            addCriterion("BANK_NAME <=", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameLike(String value) {
            addCriterion("BANK_NAME like", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameNotLike(String value) {
            addCriterion("BANK_NAME not like", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameIn(List<String> values) {
            addCriterion("BANK_NAME in", values, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameNotIn(List<String> values) {
            addCriterion("BANK_NAME not in", values, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameBetween(String value1, String value2) {
            addCriterion("BANK_NAME between", value1, value2, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameNotBetween(String value1, String value2) {
            addCriterion("BANK_NAME not between", value1, value2, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNumberIsNull() {
            addCriterion("BANK_NUMBER is null");
            return (Criteria) this;
        }

        public Criteria andBankNumberIsNotNull() {
            addCriterion("BANK_NUMBER is not null");
            return (Criteria) this;
        }

        public Criteria andBankNumberEqualTo(String value) {
            addCriterion("BANK_NUMBER =", value, "bankNumber");
            return (Criteria) this;
        }

        public Criteria andBankNumberNotEqualTo(String value) {
            addCriterion("BANK_NUMBER <>", value, "bankNumber");
            return (Criteria) this;
        }

        public Criteria andBankNumberGreaterThan(String value) {
            addCriterion("BANK_NUMBER >", value, "bankNumber");
            return (Criteria) this;
        }

        public Criteria andBankNumberGreaterThanOrEqualTo(String value) {
            addCriterion("BANK_NUMBER >=", value, "bankNumber");
            return (Criteria) this;
        }

        public Criteria andBankNumberLessThan(String value) {
            addCriterion("BANK_NUMBER <", value, "bankNumber");
            return (Criteria) this;
        }

        public Criteria andBankNumberLessThanOrEqualTo(String value) {
            addCriterion("BANK_NUMBER <=", value, "bankNumber");
            return (Criteria) this;
        }

        public Criteria andBankNumberLike(String value) {
            addCriterion("BANK_NUMBER like", value, "bankNumber");
            return (Criteria) this;
        }

        public Criteria andBankNumberNotLike(String value) {
            addCriterion("BANK_NUMBER not like", value, "bankNumber");
            return (Criteria) this;
        }

        public Criteria andBankNumberIn(List<String> values) {
            addCriterion("BANK_NUMBER in", values, "bankNumber");
            return (Criteria) this;
        }

        public Criteria andBankNumberNotIn(List<String> values) {
            addCriterion("BANK_NUMBER not in", values, "bankNumber");
            return (Criteria) this;
        }

        public Criteria andBankNumberBetween(String value1, String value2) {
            addCriterion("BANK_NUMBER between", value1, value2, "bankNumber");
            return (Criteria) this;
        }

        public Criteria andBankNumberNotBetween(String value1, String value2) {
            addCriterion("BANK_NUMBER not between", value1, value2, "bankNumber");
            return (Criteria) this;
        }

        public Criteria andSosLinkManIsNull() {
            addCriterion("SOS_LINK_MAN is null");
            return (Criteria) this;
        }

        public Criteria andSosLinkManIsNotNull() {
            addCriterion("SOS_LINK_MAN is not null");
            return (Criteria) this;
        }

        public Criteria andSosLinkManEqualTo(String value) {
            addCriterion("SOS_LINK_MAN =", value, "sosLinkMan");
            return (Criteria) this;
        }

        public Criteria andSosLinkManNotEqualTo(String value) {
            addCriterion("SOS_LINK_MAN <>", value, "sosLinkMan");
            return (Criteria) this;
        }

        public Criteria andSosLinkManGreaterThan(String value) {
            addCriterion("SOS_LINK_MAN >", value, "sosLinkMan");
            return (Criteria) this;
        }

        public Criteria andSosLinkManGreaterThanOrEqualTo(String value) {
            addCriterion("SOS_LINK_MAN >=", value, "sosLinkMan");
            return (Criteria) this;
        }

        public Criteria andSosLinkManLessThan(String value) {
            addCriterion("SOS_LINK_MAN <", value, "sosLinkMan");
            return (Criteria) this;
        }

        public Criteria andSosLinkManLessThanOrEqualTo(String value) {
            addCriterion("SOS_LINK_MAN <=", value, "sosLinkMan");
            return (Criteria) this;
        }

        public Criteria andSosLinkManLike(String value) {
            addCriterion("SOS_LINK_MAN like", value, "sosLinkMan");
            return (Criteria) this;
        }

        public Criteria andSosLinkManNotLike(String value) {
            addCriterion("SOS_LINK_MAN not like", value, "sosLinkMan");
            return (Criteria) this;
        }

        public Criteria andSosLinkManIn(List<String> values) {
            addCriterion("SOS_LINK_MAN in", values, "sosLinkMan");
            return (Criteria) this;
        }

        public Criteria andSosLinkManNotIn(List<String> values) {
            addCriterion("SOS_LINK_MAN not in", values, "sosLinkMan");
            return (Criteria) this;
        }

        public Criteria andSosLinkManBetween(String value1, String value2) {
            addCriterion("SOS_LINK_MAN between", value1, value2, "sosLinkMan");
            return (Criteria) this;
        }

        public Criteria andSosLinkManNotBetween(String value1, String value2) {
            addCriterion("SOS_LINK_MAN not between", value1, value2, "sosLinkMan");
            return (Criteria) this;
        }

        public Criteria andRelationshipIsNull() {
            addCriterion("RELATIONSHIP is null");
            return (Criteria) this;
        }

        public Criteria andRelationshipIsNotNull() {
            addCriterion("RELATIONSHIP is not null");
            return (Criteria) this;
        }

        public Criteria andRelationshipEqualTo(String value) {
            addCriterion("RELATIONSHIP =", value, "relationship");
            return (Criteria) this;
        }

        public Criteria andRelationshipNotEqualTo(String value) {
            addCriterion("RELATIONSHIP <>", value, "relationship");
            return (Criteria) this;
        }

        public Criteria andRelationshipGreaterThan(String value) {
            addCriterion("RELATIONSHIP >", value, "relationship");
            return (Criteria) this;
        }

        public Criteria andRelationshipGreaterThanOrEqualTo(String value) {
            addCriterion("RELATIONSHIP >=", value, "relationship");
            return (Criteria) this;
        }

        public Criteria andRelationshipLessThan(String value) {
            addCriterion("RELATIONSHIP <", value, "relationship");
            return (Criteria) this;
        }

        public Criteria andRelationshipLessThanOrEqualTo(String value) {
            addCriterion("RELATIONSHIP <=", value, "relationship");
            return (Criteria) this;
        }

        public Criteria andRelationshipLike(String value) {
            addCriterion("RELATIONSHIP like", value, "relationship");
            return (Criteria) this;
        }

        public Criteria andRelationshipNotLike(String value) {
            addCriterion("RELATIONSHIP not like", value, "relationship");
            return (Criteria) this;
        }

        public Criteria andRelationshipIn(List<String> values) {
            addCriterion("RELATIONSHIP in", values, "relationship");
            return (Criteria) this;
        }

        public Criteria andRelationshipNotIn(List<String> values) {
            addCriterion("RELATIONSHIP not in", values, "relationship");
            return (Criteria) this;
        }

        public Criteria andRelationshipBetween(String value1, String value2) {
            addCriterion("RELATIONSHIP between", value1, value2, "relationship");
            return (Criteria) this;
        }

        public Criteria andRelationshipNotBetween(String value1, String value2) {
            addCriterion("RELATIONSHIP not between", value1, value2, "relationship");
            return (Criteria) this;
        }

        public Criteria andLinkPhoneIsNull() {
            addCriterion("LINK_PHONE is null");
            return (Criteria) this;
        }

        public Criteria andLinkPhoneIsNotNull() {
            addCriterion("LINK_PHONE is not null");
            return (Criteria) this;
        }

        public Criteria andLinkPhoneEqualTo(String value) {
            addCriterion("LINK_PHONE =", value, "linkPhone");
            return (Criteria) this;
        }

        public Criteria andLinkPhoneNotEqualTo(String value) {
            addCriterion("LINK_PHONE <>", value, "linkPhone");
            return (Criteria) this;
        }

        public Criteria andLinkPhoneGreaterThan(String value) {
            addCriterion("LINK_PHONE >", value, "linkPhone");
            return (Criteria) this;
        }

        public Criteria andLinkPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("LINK_PHONE >=", value, "linkPhone");
            return (Criteria) this;
        }

        public Criteria andLinkPhoneLessThan(String value) {
            addCriterion("LINK_PHONE <", value, "linkPhone");
            return (Criteria) this;
        }

        public Criteria andLinkPhoneLessThanOrEqualTo(String value) {
            addCriterion("LINK_PHONE <=", value, "linkPhone");
            return (Criteria) this;
        }

        public Criteria andLinkPhoneLike(String value) {
            addCriterion("LINK_PHONE like", value, "linkPhone");
            return (Criteria) this;
        }

        public Criteria andLinkPhoneNotLike(String value) {
            addCriterion("LINK_PHONE not like", value, "linkPhone");
            return (Criteria) this;
        }

        public Criteria andLinkPhoneIn(List<String> values) {
            addCriterion("LINK_PHONE in", values, "linkPhone");
            return (Criteria) this;
        }

        public Criteria andLinkPhoneNotIn(List<String> values) {
            addCriterion("LINK_PHONE not in", values, "linkPhone");
            return (Criteria) this;
        }

        public Criteria andLinkPhoneBetween(String value1, String value2) {
            addCriterion("LINK_PHONE between", value1, value2, "linkPhone");
            return (Criteria) this;
        }

        public Criteria andLinkPhoneNotBetween(String value1, String value2) {
            addCriterion("LINK_PHONE not between", value1, value2, "linkPhone");
            return (Criteria) this;
        }

        public Criteria andServiceProvinceDisplayIsNull() {
            addCriterion("SERVICE_PROVINCE_DISPLAY is null");
            return (Criteria) this;
        }

        public Criteria andServiceProvinceDisplayIsNotNull() {
            addCriterion("SERVICE_PROVINCE_DISPLAY is not null");
            return (Criteria) this;
        }

        public Criteria andServiceProvinceDisplayEqualTo(String value) {
            addCriterion("SERVICE_PROVINCE_DISPLAY =", value, "serviceProvinceDisplay");
            return (Criteria) this;
        }

        public Criteria andServiceProvinceDisplayNotEqualTo(String value) {
            addCriterion("SERVICE_PROVINCE_DISPLAY <>", value, "serviceProvinceDisplay");
            return (Criteria) this;
        }

        public Criteria andServiceProvinceDisplayGreaterThan(String value) {
            addCriterion("SERVICE_PROVINCE_DISPLAY >", value, "serviceProvinceDisplay");
            return (Criteria) this;
        }

        public Criteria andServiceProvinceDisplayGreaterThanOrEqualTo(String value) {
            addCriterion("SERVICE_PROVINCE_DISPLAY >=", value, "serviceProvinceDisplay");
            return (Criteria) this;
        }

        public Criteria andServiceProvinceDisplayLessThan(String value) {
            addCriterion("SERVICE_PROVINCE_DISPLAY <", value, "serviceProvinceDisplay");
            return (Criteria) this;
        }

        public Criteria andServiceProvinceDisplayLessThanOrEqualTo(String value) {
            addCriterion("SERVICE_PROVINCE_DISPLAY <=", value, "serviceProvinceDisplay");
            return (Criteria) this;
        }

        public Criteria andServiceProvinceDisplayLike(String value) {
            addCriterion("SERVICE_PROVINCE_DISPLAY like", value, "serviceProvinceDisplay");
            return (Criteria) this;
        }

        public Criteria andServiceProvinceDisplayNotLike(String value) {
            addCriterion("SERVICE_PROVINCE_DISPLAY not like", value, "serviceProvinceDisplay");
            return (Criteria) this;
        }

        public Criteria andServiceProvinceDisplayIn(List<String> values) {
            addCriterion("SERVICE_PROVINCE_DISPLAY in", values, "serviceProvinceDisplay");
            return (Criteria) this;
        }

        public Criteria andServiceProvinceDisplayNotIn(List<String> values) {
            addCriterion("SERVICE_PROVINCE_DISPLAY not in", values, "serviceProvinceDisplay");
            return (Criteria) this;
        }

        public Criteria andServiceProvinceDisplayBetween(String value1, String value2) {
            addCriterion("SERVICE_PROVINCE_DISPLAY between", value1, value2, "serviceProvinceDisplay");
            return (Criteria) this;
        }

        public Criteria andServiceProvinceDisplayNotBetween(String value1, String value2) {
            addCriterion("SERVICE_PROVINCE_DISPLAY not between", value1, value2, "serviceProvinceDisplay");
            return (Criteria) this;
        }

        public Criteria andServiceCityDisplayIsNull() {
            addCriterion("SERVICE_CITY_DISPLAY is null");
            return (Criteria) this;
        }

        public Criteria andServiceCityDisplayIsNotNull() {
            addCriterion("SERVICE_CITY_DISPLAY is not null");
            return (Criteria) this;
        }

        public Criteria andServiceCityDisplayEqualTo(String value) {
            addCriterion("SERVICE_CITY_DISPLAY =", value, "serviceCityDisplay");
            return (Criteria) this;
        }

        public Criteria andServiceCityDisplayNotEqualTo(String value) {
            addCriterion("SERVICE_CITY_DISPLAY <>", value, "serviceCityDisplay");
            return (Criteria) this;
        }

        public Criteria andServiceCityDisplayGreaterThan(String value) {
            addCriterion("SERVICE_CITY_DISPLAY >", value, "serviceCityDisplay");
            return (Criteria) this;
        }

        public Criteria andServiceCityDisplayGreaterThanOrEqualTo(String value) {
            addCriterion("SERVICE_CITY_DISPLAY >=", value, "serviceCityDisplay");
            return (Criteria) this;
        }

        public Criteria andServiceCityDisplayLessThan(String value) {
            addCriterion("SERVICE_CITY_DISPLAY <", value, "serviceCityDisplay");
            return (Criteria) this;
        }

        public Criteria andServiceCityDisplayLessThanOrEqualTo(String value) {
            addCriterion("SERVICE_CITY_DISPLAY <=", value, "serviceCityDisplay");
            return (Criteria) this;
        }

        public Criteria andServiceCityDisplayLike(String value) {
            addCriterion("SERVICE_CITY_DISPLAY like", value, "serviceCityDisplay");
            return (Criteria) this;
        }

        public Criteria andServiceCityDisplayNotLike(String value) {
            addCriterion("SERVICE_CITY_DISPLAY not like", value, "serviceCityDisplay");
            return (Criteria) this;
        }

        public Criteria andServiceCityDisplayIn(List<String> values) {
            addCriterion("SERVICE_CITY_DISPLAY in", values, "serviceCityDisplay");
            return (Criteria) this;
        }

        public Criteria andServiceCityDisplayNotIn(List<String> values) {
            addCriterion("SERVICE_CITY_DISPLAY not in", values, "serviceCityDisplay");
            return (Criteria) this;
        }

        public Criteria andServiceCityDisplayBetween(String value1, String value2) {
            addCriterion("SERVICE_CITY_DISPLAY between", value1, value2, "serviceCityDisplay");
            return (Criteria) this;
        }

        public Criteria andServiceCityDisplayNotBetween(String value1, String value2) {
            addCriterion("SERVICE_CITY_DISPLAY not between", value1, value2, "serviceCityDisplay");
            return (Criteria) this;
        }

        public Criteria andServiceDistrictDisplayIsNull() {
            addCriterion("SERVICE_DISTRICT_DISPLAY is null");
            return (Criteria) this;
        }

        public Criteria andServiceDistrictDisplayIsNotNull() {
            addCriterion("SERVICE_DISTRICT_DISPLAY is not null");
            return (Criteria) this;
        }

        public Criteria andServiceDistrictDisplayEqualTo(String value) {
            addCriterion("SERVICE_DISTRICT_DISPLAY =", value, "serviceDistrictDisplay");
            return (Criteria) this;
        }

        public Criteria andServiceDistrictDisplayNotEqualTo(String value) {
            addCriterion("SERVICE_DISTRICT_DISPLAY <>", value, "serviceDistrictDisplay");
            return (Criteria) this;
        }

        public Criteria andServiceDistrictDisplayGreaterThan(String value) {
            addCriterion("SERVICE_DISTRICT_DISPLAY >", value, "serviceDistrictDisplay");
            return (Criteria) this;
        }

        public Criteria andServiceDistrictDisplayGreaterThanOrEqualTo(String value) {
            addCriterion("SERVICE_DISTRICT_DISPLAY >=", value, "serviceDistrictDisplay");
            return (Criteria) this;
        }

        public Criteria andServiceDistrictDisplayLessThan(String value) {
            addCriterion("SERVICE_DISTRICT_DISPLAY <", value, "serviceDistrictDisplay");
            return (Criteria) this;
        }

        public Criteria andServiceDistrictDisplayLessThanOrEqualTo(String value) {
            addCriterion("SERVICE_DISTRICT_DISPLAY <=", value, "serviceDistrictDisplay");
            return (Criteria) this;
        }

        public Criteria andServiceDistrictDisplayLike(String value) {
            addCriterion("SERVICE_DISTRICT_DISPLAY like", value, "serviceDistrictDisplay");
            return (Criteria) this;
        }

        public Criteria andServiceDistrictDisplayNotLike(String value) {
            addCriterion("SERVICE_DISTRICT_DISPLAY not like", value, "serviceDistrictDisplay");
            return (Criteria) this;
        }

        public Criteria andServiceDistrictDisplayIn(List<String> values) {
            addCriterion("SERVICE_DISTRICT_DISPLAY in", values, "serviceDistrictDisplay");
            return (Criteria) this;
        }

        public Criteria andServiceDistrictDisplayNotIn(List<String> values) {
            addCriterion("SERVICE_DISTRICT_DISPLAY not in", values, "serviceDistrictDisplay");
            return (Criteria) this;
        }

        public Criteria andServiceDistrictDisplayBetween(String value1, String value2) {
            addCriterion("SERVICE_DISTRICT_DISPLAY between", value1, value2, "serviceDistrictDisplay");
            return (Criteria) this;
        }

        public Criteria andServiceDistrictDisplayNotBetween(String value1, String value2) {
            addCriterion("SERVICE_DISTRICT_DISPLAY not between", value1, value2, "serviceDistrictDisplay");
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

        public Criteria andStatusEqualTo(Short value) {
            addCriterion("STATUS =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Short value) {
            addCriterion("STATUS <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Short value) {
            addCriterion("STATUS >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Short value) {
            addCriterion("STATUS >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Short value) {
            addCriterion("STATUS <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Short value) {
            addCriterion("STATUS <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Short> values) {
            addCriterion("STATUS in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Short> values) {
            addCriterion("STATUS not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Short value1, Short value2) {
            addCriterion("STATUS between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Short value1, Short value2) {
            addCriterion("STATUS not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andReasonIsNull() {
            addCriterion("REASON is null");
            return (Criteria) this;
        }

        public Criteria andReasonIsNotNull() {
            addCriterion("REASON is not null");
            return (Criteria) this;
        }

        public Criteria andReasonEqualTo(String value) {
            addCriterion("REASON =", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotEqualTo(String value) {
            addCriterion("REASON <>", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonGreaterThan(String value) {
            addCriterion("REASON >", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonGreaterThanOrEqualTo(String value) {
            addCriterion("REASON >=", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLessThan(String value) {
            addCriterion("REASON <", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLessThanOrEqualTo(String value) {
            addCriterion("REASON <=", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLike(String value) {
            addCriterion("REASON like", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotLike(String value) {
            addCriterion("REASON not like", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonIn(List<String> values) {
            addCriterion("REASON in", values, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotIn(List<String> values) {
            addCriterion("REASON not in", values, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonBetween(String value1, String value2) {
            addCriterion("REASON between", value1, value2, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotBetween(String value1, String value2) {
            addCriterion("REASON not between", value1, value2, "reason");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("CREATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("CREATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterionForJDBCDate("CREATE_TIME =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("CREATE_TIME <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("CREATE_TIME >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("CREATE_TIME >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterionForJDBCDate("CREATE_TIME <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("CREATE_TIME <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterionForJDBCDate("CREATE_TIME in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("CREATE_TIME not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("CREATE_TIME between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("CREATE_TIME not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andAgeIsNull() {
            addCriterion("AGE is null");
            return (Criteria) this;
        }

        public Criteria andAgeIsNotNull() {
            addCriterion("AGE is not null");
            return (Criteria) this;
        }

        public Criteria andAgeEqualTo(String value) {
            addCriterion("AGE =", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotEqualTo(String value) {
            addCriterion("AGE <>", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeGreaterThan(String value) {
            addCriterion("AGE >", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeGreaterThanOrEqualTo(String value) {
            addCriterion("AGE >=", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeLessThan(String value) {
            addCriterion("AGE <", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeLessThanOrEqualTo(String value) {
            addCriterion("AGE <=", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeLike(String value) {
            addCriterion("AGE like", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotLike(String value) {
            addCriterion("AGE not like", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeIn(List<String> values) {
            addCriterion("AGE in", values, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotIn(List<String> values) {
            addCriterion("AGE not in", values, "age");
            return (Criteria) this;
        }

        public Criteria andAgeBetween(String value1, String value2) {
            addCriterion("AGE between", value1, value2, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotBetween(String value1, String value2) {
            addCriterion("AGE not between", value1, value2, "age");
            return (Criteria) this;
        }

        public Criteria andChatIsNull() {
            addCriterion("CHAT is null");
            return (Criteria) this;
        }

        public Criteria andChatIsNotNull() {
            addCriterion("CHAT is not null");
            return (Criteria) this;
        }

        public Criteria andChatEqualTo(String value) {
            addCriterion("CHAT =", value, "chat");
            return (Criteria) this;
        }

        public Criteria andChatNotEqualTo(String value) {
            addCriterion("CHAT <>", value, "chat");
            return (Criteria) this;
        }

        public Criteria andChatGreaterThan(String value) {
            addCriterion("CHAT >", value, "chat");
            return (Criteria) this;
        }

        public Criteria andChatGreaterThanOrEqualTo(String value) {
            addCriterion("CHAT >=", value, "chat");
            return (Criteria) this;
        }

        public Criteria andChatLessThan(String value) {
            addCriterion("CHAT <", value, "chat");
            return (Criteria) this;
        }

        public Criteria andChatLessThanOrEqualTo(String value) {
            addCriterion("CHAT <=", value, "chat");
            return (Criteria) this;
        }

        public Criteria andChatLike(String value) {
            addCriterion("CHAT like", value, "chat");
            return (Criteria) this;
        }

        public Criteria andChatNotLike(String value) {
            addCriterion("CHAT not like", value, "chat");
            return (Criteria) this;
        }

        public Criteria andChatIn(List<String> values) {
            addCriterion("CHAT in", values, "chat");
            return (Criteria) this;
        }

        public Criteria andChatNotIn(List<String> values) {
            addCriterion("CHAT not in", values, "chat");
            return (Criteria) this;
        }

        public Criteria andChatBetween(String value1, String value2) {
            addCriterion("CHAT between", value1, value2, "chat");
            return (Criteria) this;
        }

        public Criteria andChatNotBetween(String value1, String value2) {
            addCriterion("CHAT not between", value1, value2, "chat");
            return (Criteria) this;
        }

        public Criteria andHaveCarIsNull() {
            addCriterion("HAVE_CAR is null");
            return (Criteria) this;
        }

        public Criteria andHaveCarIsNotNull() {
            addCriterion("HAVE_CAR is not null");
            return (Criteria) this;
        }

        public Criteria andHaveCarEqualTo(String value) {
            addCriterion("HAVE_CAR =", value, "haveCar");
            return (Criteria) this;
        }

        public Criteria andHaveCarNotEqualTo(String value) {
            addCriterion("HAVE_CAR <>", value, "haveCar");
            return (Criteria) this;
        }

        public Criteria andHaveCarGreaterThan(String value) {
            addCriterion("HAVE_CAR >", value, "haveCar");
            return (Criteria) this;
        }

        public Criteria andHaveCarGreaterThanOrEqualTo(String value) {
            addCriterion("HAVE_CAR >=", value, "haveCar");
            return (Criteria) this;
        }

        public Criteria andHaveCarLessThan(String value) {
            addCriterion("HAVE_CAR <", value, "haveCar");
            return (Criteria) this;
        }

        public Criteria andHaveCarLessThanOrEqualTo(String value) {
            addCriterion("HAVE_CAR <=", value, "haveCar");
            return (Criteria) this;
        }

        public Criteria andHaveCarLike(String value) {
            addCriterion("HAVE_CAR like", value, "haveCar");
            return (Criteria) this;
        }

        public Criteria andHaveCarNotLike(String value) {
            addCriterion("HAVE_CAR not like", value, "haveCar");
            return (Criteria) this;
        }

        public Criteria andHaveCarIn(List<String> values) {
            addCriterion("HAVE_CAR in", values, "haveCar");
            return (Criteria) this;
        }

        public Criteria andHaveCarNotIn(List<String> values) {
            addCriterion("HAVE_CAR not in", values, "haveCar");
            return (Criteria) this;
        }

        public Criteria andHaveCarBetween(String value1, String value2) {
            addCriterion("HAVE_CAR between", value1, value2, "haveCar");
            return (Criteria) this;
        }

        public Criteria andHaveCarNotBetween(String value1, String value2) {
            addCriterion("HAVE_CAR not between", value1, value2, "haveCar");
            return (Criteria) this;
        }

        public Criteria andHaveTeamIsNull() {
            addCriterion("HAVE_TEAM is null");
            return (Criteria) this;
        }

        public Criteria andHaveTeamIsNotNull() {
            addCriterion("HAVE_TEAM is not null");
            return (Criteria) this;
        }

        public Criteria andHaveTeamEqualTo(String value) {
            addCriterion("HAVE_TEAM =", value, "haveTeam");
            return (Criteria) this;
        }

        public Criteria andHaveTeamNotEqualTo(String value) {
            addCriterion("HAVE_TEAM <>", value, "haveTeam");
            return (Criteria) this;
        }

        public Criteria andHaveTeamGreaterThan(String value) {
            addCriterion("HAVE_TEAM >", value, "haveTeam");
            return (Criteria) this;
        }

        public Criteria andHaveTeamGreaterThanOrEqualTo(String value) {
            addCriterion("HAVE_TEAM >=", value, "haveTeam");
            return (Criteria) this;
        }

        public Criteria andHaveTeamLessThan(String value) {
            addCriterion("HAVE_TEAM <", value, "haveTeam");
            return (Criteria) this;
        }

        public Criteria andHaveTeamLessThanOrEqualTo(String value) {
            addCriterion("HAVE_TEAM <=", value, "haveTeam");
            return (Criteria) this;
        }

        public Criteria andHaveTeamLike(String value) {
            addCriterion("HAVE_TEAM like", value, "haveTeam");
            return (Criteria) this;
        }

        public Criteria andHaveTeamNotLike(String value) {
            addCriterion("HAVE_TEAM not like", value, "haveTeam");
            return (Criteria) this;
        }

        public Criteria andHaveTeamIn(List<String> values) {
            addCriterion("HAVE_TEAM in", values, "haveTeam");
            return (Criteria) this;
        }

        public Criteria andHaveTeamNotIn(List<String> values) {
            addCriterion("HAVE_TEAM not in", values, "haveTeam");
            return (Criteria) this;
        }

        public Criteria andHaveTeamBetween(String value1, String value2) {
            addCriterion("HAVE_TEAM between", value1, value2, "haveTeam");
            return (Criteria) this;
        }

        public Criteria andHaveTeamNotBetween(String value1, String value2) {
            addCriterion("HAVE_TEAM not between", value1, value2, "haveTeam");
            return (Criteria) this;
        }

        public Criteria andTeamNumIsNull() {
            addCriterion("TEAM_NUM is null");
            return (Criteria) this;
        }

        public Criteria andTeamNumIsNotNull() {
            addCriterion("TEAM_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andTeamNumEqualTo(BigDecimal value) {
            addCriterion("TEAM_NUM =", value, "teamNum");
            return (Criteria) this;
        }

        public Criteria andTeamNumNotEqualTo(BigDecimal value) {
            addCriterion("TEAM_NUM <>", value, "teamNum");
            return (Criteria) this;
        }

        public Criteria andTeamNumGreaterThan(BigDecimal value) {
            addCriterion("TEAM_NUM >", value, "teamNum");
            return (Criteria) this;
        }

        public Criteria andTeamNumGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("TEAM_NUM >=", value, "teamNum");
            return (Criteria) this;
        }

        public Criteria andTeamNumLessThan(BigDecimal value) {
            addCriterion("TEAM_NUM <", value, "teamNum");
            return (Criteria) this;
        }

        public Criteria andTeamNumLessThanOrEqualTo(BigDecimal value) {
            addCriterion("TEAM_NUM <=", value, "teamNum");
            return (Criteria) this;
        }

        public Criteria andTeamNumIn(List<BigDecimal> values) {
            addCriterion("TEAM_NUM in", values, "teamNum");
            return (Criteria) this;
        }

        public Criteria andTeamNumNotIn(List<BigDecimal> values) {
            addCriterion("TEAM_NUM not in", values, "teamNum");
            return (Criteria) this;
        }

        public Criteria andTeamNumBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TEAM_NUM between", value1, value2, "teamNum");
            return (Criteria) this;
        }

        public Criteria andTeamNumNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TEAM_NUM not between", value1, value2, "teamNum");
            return (Criteria) this;
        }

        public Criteria andHaveToolsIsNull() {
            addCriterion("HAVE_TOOLS is null");
            return (Criteria) this;
        }

        public Criteria andHaveToolsIsNotNull() {
            addCriterion("HAVE_TOOLS is not null");
            return (Criteria) this;
        }

        public Criteria andHaveToolsEqualTo(String value) {
            addCriterion("HAVE_TOOLS =", value, "haveTools");
            return (Criteria) this;
        }

        public Criteria andHaveToolsNotEqualTo(String value) {
            addCriterion("HAVE_TOOLS <>", value, "haveTools");
            return (Criteria) this;
        }

        public Criteria andHaveToolsGreaterThan(String value) {
            addCriterion("HAVE_TOOLS >", value, "haveTools");
            return (Criteria) this;
        }

        public Criteria andHaveToolsGreaterThanOrEqualTo(String value) {
            addCriterion("HAVE_TOOLS >=", value, "haveTools");
            return (Criteria) this;
        }

        public Criteria andHaveToolsLessThan(String value) {
            addCriterion("HAVE_TOOLS <", value, "haveTools");
            return (Criteria) this;
        }

        public Criteria andHaveToolsLessThanOrEqualTo(String value) {
            addCriterion("HAVE_TOOLS <=", value, "haveTools");
            return (Criteria) this;
        }

        public Criteria andHaveToolsLike(String value) {
            addCriterion("HAVE_TOOLS like", value, "haveTools");
            return (Criteria) this;
        }

        public Criteria andHaveToolsNotLike(String value) {
            addCriterion("HAVE_TOOLS not like", value, "haveTools");
            return (Criteria) this;
        }

        public Criteria andHaveToolsIn(List<String> values) {
            addCriterion("HAVE_TOOLS in", values, "haveTools");
            return (Criteria) this;
        }

        public Criteria andHaveToolsNotIn(List<String> values) {
            addCriterion("HAVE_TOOLS not in", values, "haveTools");
            return (Criteria) this;
        }

        public Criteria andHaveToolsBetween(String value1, String value2) {
            addCriterion("HAVE_TOOLS between", value1, value2, "haveTools");
            return (Criteria) this;
        }

        public Criteria andHaveToolsNotBetween(String value1, String value2) {
            addCriterion("HAVE_TOOLS not between", value1, value2, "haveTools");
            return (Criteria) this;
        }

        public Criteria andHavaInsuranceIsNull() {
            addCriterion("HAVA_INSURANCE is null");
            return (Criteria) this;
        }

        public Criteria andHavaInsuranceIsNotNull() {
            addCriterion("HAVA_INSURANCE is not null");
            return (Criteria) this;
        }

        public Criteria andHavaInsuranceEqualTo(String value) {
            addCriterion("HAVA_INSURANCE =", value, "havaInsurance");
            return (Criteria) this;
        }

        public Criteria andHavaInsuranceNotEqualTo(String value) {
            addCriterion("HAVA_INSURANCE <>", value, "havaInsurance");
            return (Criteria) this;
        }

        public Criteria andHavaInsuranceGreaterThan(String value) {
            addCriterion("HAVA_INSURANCE >", value, "havaInsurance");
            return (Criteria) this;
        }

        public Criteria andHavaInsuranceGreaterThanOrEqualTo(String value) {
            addCriterion("HAVA_INSURANCE >=", value, "havaInsurance");
            return (Criteria) this;
        }

        public Criteria andHavaInsuranceLessThan(String value) {
            addCriterion("HAVA_INSURANCE <", value, "havaInsurance");
            return (Criteria) this;
        }

        public Criteria andHavaInsuranceLessThanOrEqualTo(String value) {
            addCriterion("HAVA_INSURANCE <=", value, "havaInsurance");
            return (Criteria) this;
        }

        public Criteria andHavaInsuranceLike(String value) {
            addCriterion("HAVA_INSURANCE like", value, "havaInsurance");
            return (Criteria) this;
        }

        public Criteria andHavaInsuranceNotLike(String value) {
            addCriterion("HAVA_INSURANCE not like", value, "havaInsurance");
            return (Criteria) this;
        }

        public Criteria andHavaInsuranceIn(List<String> values) {
            addCriterion("HAVA_INSURANCE in", values, "havaInsurance");
            return (Criteria) this;
        }

        public Criteria andHavaInsuranceNotIn(List<String> values) {
            addCriterion("HAVA_INSURANCE not in", values, "havaInsurance");
            return (Criteria) this;
        }

        public Criteria andHavaInsuranceBetween(String value1, String value2) {
            addCriterion("HAVA_INSURANCE between", value1, value2, "havaInsurance");
            return (Criteria) this;
        }

        public Criteria andHavaInsuranceNotBetween(String value1, String value2) {
            addCriterion("HAVA_INSURANCE not between", value1, value2, "havaInsurance");
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

        public Criteria andCreateUserIdIsNull() {
            addCriterion("CREATE_USER_ID is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdIsNotNull() {
            addCriterion("CREATE_USER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdEqualTo(String value) {
            addCriterion("CREATE_USER_ID =", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotEqualTo(String value) {
            addCriterion("CREATE_USER_ID <>", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdGreaterThan(String value) {
            addCriterion("CREATE_USER_ID >", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("CREATE_USER_ID >=", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdLessThan(String value) {
            addCriterion("CREATE_USER_ID <", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdLessThanOrEqualTo(String value) {
            addCriterion("CREATE_USER_ID <=", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdLike(String value) {
            addCriterion("CREATE_USER_ID like", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotLike(String value) {
            addCriterion("CREATE_USER_ID not like", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdIn(List<String> values) {
            addCriterion("CREATE_USER_ID in", values, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotIn(List<String> values) {
            addCriterion("CREATE_USER_ID not in", values, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdBetween(String value1, String value2) {
            addCriterion("CREATE_USER_ID between", value1, value2, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotBetween(String value1, String value2) {
            addCriterion("CREATE_USER_ID not between", value1, value2, "createUserId");
            return (Criteria) this;
        }

        public Criteria andAuditUserIdIsNull() {
            addCriterion("AUDIT_USER_ID is null");
            return (Criteria) this;
        }

        public Criteria andAuditUserIdIsNotNull() {
            addCriterion("AUDIT_USER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andAuditUserIdEqualTo(String value) {
            addCriterion("AUDIT_USER_ID =", value, "auditUserId");
            return (Criteria) this;
        }

        public Criteria andAuditUserIdNotEqualTo(String value) {
            addCriterion("AUDIT_USER_ID <>", value, "auditUserId");
            return (Criteria) this;
        }

        public Criteria andAuditUserIdGreaterThan(String value) {
            addCriterion("AUDIT_USER_ID >", value, "auditUserId");
            return (Criteria) this;
        }

        public Criteria andAuditUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("AUDIT_USER_ID >=", value, "auditUserId");
            return (Criteria) this;
        }

        public Criteria andAuditUserIdLessThan(String value) {
            addCriterion("AUDIT_USER_ID <", value, "auditUserId");
            return (Criteria) this;
        }

        public Criteria andAuditUserIdLessThanOrEqualTo(String value) {
            addCriterion("AUDIT_USER_ID <=", value, "auditUserId");
            return (Criteria) this;
        }

        public Criteria andAuditUserIdLike(String value) {
            addCriterion("AUDIT_USER_ID like", value, "auditUserId");
            return (Criteria) this;
        }

        public Criteria andAuditUserIdNotLike(String value) {
            addCriterion("AUDIT_USER_ID not like", value, "auditUserId");
            return (Criteria) this;
        }

        public Criteria andAuditUserIdIn(List<String> values) {
            addCriterion("AUDIT_USER_ID in", values, "auditUserId");
            return (Criteria) this;
        }

        public Criteria andAuditUserIdNotIn(List<String> values) {
            addCriterion("AUDIT_USER_ID not in", values, "auditUserId");
            return (Criteria) this;
        }

        public Criteria andAuditUserIdBetween(String value1, String value2) {
            addCriterion("AUDIT_USER_ID between", value1, value2, "auditUserId");
            return (Criteria) this;
        }

        public Criteria andAuditUserIdNotBetween(String value1, String value2) {
            addCriterion("AUDIT_USER_ID not between", value1, value2, "auditUserId");
            return (Criteria) this;
        }

        public Criteria andAuditTimeIsNull() {
            addCriterion("AUDIT_TIME is null");
            return (Criteria) this;
        }

        public Criteria andAuditTimeIsNotNull() {
            addCriterion("AUDIT_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andAuditTimeEqualTo(Date value) {
            addCriterionForJDBCDate("AUDIT_TIME =", value, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("AUDIT_TIME <>", value, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("AUDIT_TIME >", value, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("AUDIT_TIME >=", value, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeLessThan(Date value) {
            addCriterionForJDBCDate("AUDIT_TIME <", value, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("AUDIT_TIME <=", value, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeIn(List<Date> values) {
            addCriterionForJDBCDate("AUDIT_TIME in", values, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("AUDIT_TIME not in", values, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("AUDIT_TIME between", value1, value2, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("AUDIT_TIME not between", value1, value2, "auditTime");
            return (Criteria) this;
        }

        public Criteria andImageUrl1IsNull() {
            addCriterion("IMAGE_URL1 is null");
            return (Criteria) this;
        }

        public Criteria andImageUrl1IsNotNull() {
            addCriterion("IMAGE_URL1 is not null");
            return (Criteria) this;
        }

        public Criteria andImageUrl1EqualTo(String value) {
            addCriterion("IMAGE_URL1 =", value, "imageUrl1");
            return (Criteria) this;
        }

        public Criteria andImageUrl1NotEqualTo(String value) {
            addCriterion("IMAGE_URL1 <>", value, "imageUrl1");
            return (Criteria) this;
        }

        public Criteria andImageUrl1GreaterThan(String value) {
            addCriterion("IMAGE_URL1 >", value, "imageUrl1");
            return (Criteria) this;
        }

        public Criteria andImageUrl1GreaterThanOrEqualTo(String value) {
            addCriterion("IMAGE_URL1 >=", value, "imageUrl1");
            return (Criteria) this;
        }

        public Criteria andImageUrl1LessThan(String value) {
            addCriterion("IMAGE_URL1 <", value, "imageUrl1");
            return (Criteria) this;
        }

        public Criteria andImageUrl1LessThanOrEqualTo(String value) {
            addCriterion("IMAGE_URL1 <=", value, "imageUrl1");
            return (Criteria) this;
        }

        public Criteria andImageUrl1Like(String value) {
            addCriterion("IMAGE_URL1 like", value, "imageUrl1");
            return (Criteria) this;
        }

        public Criteria andImageUrl1NotLike(String value) {
            addCriterion("IMAGE_URL1 not like", value, "imageUrl1");
            return (Criteria) this;
        }

        public Criteria andImageUrl1In(List<String> values) {
            addCriterion("IMAGE_URL1 in", values, "imageUrl1");
            return (Criteria) this;
        }

        public Criteria andImageUrl1NotIn(List<String> values) {
            addCriterion("IMAGE_URL1 not in", values, "imageUrl1");
            return (Criteria) this;
        }

        public Criteria andImageUrl1Between(String value1, String value2) {
            addCriterion("IMAGE_URL1 between", value1, value2, "imageUrl1");
            return (Criteria) this;
        }

        public Criteria andImageUrl1NotBetween(String value1, String value2) {
            addCriterion("IMAGE_URL1 not between", value1, value2, "imageUrl1");
            return (Criteria) this;
        }

        public Criteria andAuditUserIsNull() {
            addCriterion("AUDIT_USER is null");
            return (Criteria) this;
        }

        public Criteria andAuditUserIsNotNull() {
            addCriterion("AUDIT_USER is not null");
            return (Criteria) this;
        }

        public Criteria andAuditUserEqualTo(String value) {
            addCriterion("AUDIT_USER =", value, "auditUser");
            return (Criteria) this;
        }

        public Criteria andAuditUserNotEqualTo(String value) {
            addCriterion("AUDIT_USER <>", value, "auditUser");
            return (Criteria) this;
        }

        public Criteria andAuditUserGreaterThan(String value) {
            addCriterion("AUDIT_USER >", value, "auditUser");
            return (Criteria) this;
        }

        public Criteria andAuditUserGreaterThanOrEqualTo(String value) {
            addCriterion("AUDIT_USER >=", value, "auditUser");
            return (Criteria) this;
        }

        public Criteria andAuditUserLessThan(String value) {
            addCriterion("AUDIT_USER <", value, "auditUser");
            return (Criteria) this;
        }

        public Criteria andAuditUserLessThanOrEqualTo(String value) {
            addCriterion("AUDIT_USER <=", value, "auditUser");
            return (Criteria) this;
        }

        public Criteria andAuditUserLike(String value) {
            addCriterion("AUDIT_USER like", value, "auditUser");
            return (Criteria) this;
        }

        public Criteria andAuditUserNotLike(String value) {
            addCriterion("AUDIT_USER not like", value, "auditUser");
            return (Criteria) this;
        }

        public Criteria andAuditUserIn(List<String> values) {
            addCriterion("AUDIT_USER in", values, "auditUser");
            return (Criteria) this;
        }

        public Criteria andAuditUserNotIn(List<String> values) {
            addCriterion("AUDIT_USER not in", values, "auditUser");
            return (Criteria) this;
        }

        public Criteria andAuditUserBetween(String value1, String value2) {
            addCriterion("AUDIT_USER between", value1, value2, "auditUser");
            return (Criteria) this;
        }

        public Criteria andAuditUserNotBetween(String value1, String value2) {
            addCriterion("AUDIT_USER not between", value1, value2, "auditUser");
            return (Criteria) this;
        }

        public Criteria andImageUrl2IsNull() {
            addCriterion("IMAGE_URL2 is null");
            return (Criteria) this;
        }

        public Criteria andImageUrl2IsNotNull() {
            addCriterion("IMAGE_URL2 is not null");
            return (Criteria) this;
        }

        public Criteria andImageUrl2EqualTo(String value) {
            addCriterion("IMAGE_URL2 =", value, "imageUrl2");
            return (Criteria) this;
        }

        public Criteria andImageUrl2NotEqualTo(String value) {
            addCriterion("IMAGE_URL2 <>", value, "imageUrl2");
            return (Criteria) this;
        }

        public Criteria andImageUrl2GreaterThan(String value) {
            addCriterion("IMAGE_URL2 >", value, "imageUrl2");
            return (Criteria) this;
        }

        public Criteria andImageUrl2GreaterThanOrEqualTo(String value) {
            addCriterion("IMAGE_URL2 >=", value, "imageUrl2");
            return (Criteria) this;
        }

        public Criteria andImageUrl2LessThan(String value) {
            addCriterion("IMAGE_URL2 <", value, "imageUrl2");
            return (Criteria) this;
        }

        public Criteria andImageUrl2LessThanOrEqualTo(String value) {
            addCriterion("IMAGE_URL2 <=", value, "imageUrl2");
            return (Criteria) this;
        }

        public Criteria andImageUrl2Like(String value) {
            addCriterion("IMAGE_URL2 like", value, "imageUrl2");
            return (Criteria) this;
        }

        public Criteria andImageUrl2NotLike(String value) {
            addCriterion("IMAGE_URL2 not like", value, "imageUrl2");
            return (Criteria) this;
        }

        public Criteria andImageUrl2In(List<String> values) {
            addCriterion("IMAGE_URL2 in", values, "imageUrl2");
            return (Criteria) this;
        }

        public Criteria andImageUrl2NotIn(List<String> values) {
            addCriterion("IMAGE_URL2 not in", values, "imageUrl2");
            return (Criteria) this;
        }

        public Criteria andImageUrl2Between(String value1, String value2) {
            addCriterion("IMAGE_URL2 between", value1, value2, "imageUrl2");
            return (Criteria) this;
        }

        public Criteria andImageUrl2NotBetween(String value1, String value2) {
            addCriterion("IMAGE_URL2 not between", value1, value2, "imageUrl2");
            return (Criteria) this;
        }

        public Criteria andImageUrl3IsNull() {
            addCriterion("IMAGE_URL3 is null");
            return (Criteria) this;
        }

        public Criteria andImageUrl3IsNotNull() {
            addCriterion("IMAGE_URL3 is not null");
            return (Criteria) this;
        }

        public Criteria andImageUrl3EqualTo(String value) {
            addCriterion("IMAGE_URL3 =", value, "imageUrl3");
            return (Criteria) this;
        }

        public Criteria andImageUrl3NotEqualTo(String value) {
            addCriterion("IMAGE_URL3 <>", value, "imageUrl3");
            return (Criteria) this;
        }

        public Criteria andImageUrl3GreaterThan(String value) {
            addCriterion("IMAGE_URL3 >", value, "imageUrl3");
            return (Criteria) this;
        }

        public Criteria andImageUrl3GreaterThanOrEqualTo(String value) {
            addCriterion("IMAGE_URL3 >=", value, "imageUrl3");
            return (Criteria) this;
        }

        public Criteria andImageUrl3LessThan(String value) {
            addCriterion("IMAGE_URL3 <", value, "imageUrl3");
            return (Criteria) this;
        }

        public Criteria andImageUrl3LessThanOrEqualTo(String value) {
            addCriterion("IMAGE_URL3 <=", value, "imageUrl3");
            return (Criteria) this;
        }

        public Criteria andImageUrl3Like(String value) {
            addCriterion("IMAGE_URL3 like", value, "imageUrl3");
            return (Criteria) this;
        }

        public Criteria andImageUrl3NotLike(String value) {
            addCriterion("IMAGE_URL3 not like", value, "imageUrl3");
            return (Criteria) this;
        }

        public Criteria andImageUrl3In(List<String> values) {
            addCriterion("IMAGE_URL3 in", values, "imageUrl3");
            return (Criteria) this;
        }

        public Criteria andImageUrl3NotIn(List<String> values) {
            addCriterion("IMAGE_URL3 not in", values, "imageUrl3");
            return (Criteria) this;
        }

        public Criteria andImageUrl3Between(String value1, String value2) {
            addCriterion("IMAGE_URL3 between", value1, value2, "imageUrl3");
            return (Criteria) this;
        }

        public Criteria andImageUrl3NotBetween(String value1, String value2) {
            addCriterion("IMAGE_URL3 not between", value1, value2, "imageUrl3");
            return (Criteria) this;
        }

        public Criteria andRefereeIsNull() {
            addCriterion("REFEREE is null");
            return (Criteria) this;
        }

        public Criteria andRefereeIsNotNull() {
            addCriterion("REFEREE is not null");
            return (Criteria) this;
        }

        public Criteria andRefereeEqualTo(String value) {
            addCriterion("REFEREE =", value, "referee");
            return (Criteria) this;
        }

        public Criteria andRefereeNotEqualTo(String value) {
            addCriterion("REFEREE <>", value, "referee");
            return (Criteria) this;
        }

        public Criteria andRefereeGreaterThan(String value) {
            addCriterion("REFEREE >", value, "referee");
            return (Criteria) this;
        }

        public Criteria andRefereeGreaterThanOrEqualTo(String value) {
            addCriterion("REFEREE >=", value, "referee");
            return (Criteria) this;
        }

        public Criteria andRefereeLessThan(String value) {
            addCriterion("REFEREE <", value, "referee");
            return (Criteria) this;
        }

        public Criteria andRefereeLessThanOrEqualTo(String value) {
            addCriterion("REFEREE <=", value, "referee");
            return (Criteria) this;
        }

        public Criteria andRefereeLike(String value) {
            addCriterion("REFEREE like", value, "referee");
            return (Criteria) this;
        }

        public Criteria andRefereeNotLike(String value) {
            addCriterion("REFEREE not like", value, "referee");
            return (Criteria) this;
        }

        public Criteria andRefereeIn(List<String> values) {
            addCriterion("REFEREE in", values, "referee");
            return (Criteria) this;
        }

        public Criteria andRefereeNotIn(List<String> values) {
            addCriterion("REFEREE not in", values, "referee");
            return (Criteria) this;
        }

        public Criteria andRefereeBetween(String value1, String value2) {
            addCriterion("REFEREE between", value1, value2, "referee");
            return (Criteria) this;
        }

        public Criteria andRefereeNotBetween(String value1, String value2) {
            addCriterion("REFEREE not between", value1, value2, "referee");
            return (Criteria) this;
        }

        public Criteria andRefereePhoneIsNull() {
            addCriterion("REFEREE_PHONE is null");
            return (Criteria) this;
        }

        public Criteria andRefereePhoneIsNotNull() {
            addCriterion("REFEREE_PHONE is not null");
            return (Criteria) this;
        }

        public Criteria andRefereePhoneEqualTo(String value) {
            addCriterion("REFEREE_PHONE =", value, "refereePhone");
            return (Criteria) this;
        }

        public Criteria andRefereePhoneNotEqualTo(String value) {
            addCriterion("REFEREE_PHONE <>", value, "refereePhone");
            return (Criteria) this;
        }

        public Criteria andRefereePhoneGreaterThan(String value) {
            addCriterion("REFEREE_PHONE >", value, "refereePhone");
            return (Criteria) this;
        }

        public Criteria andRefereePhoneGreaterThanOrEqualTo(String value) {
            addCriterion("REFEREE_PHONE >=", value, "refereePhone");
            return (Criteria) this;
        }

        public Criteria andRefereePhoneLessThan(String value) {
            addCriterion("REFEREE_PHONE <", value, "refereePhone");
            return (Criteria) this;
        }

        public Criteria andRefereePhoneLessThanOrEqualTo(String value) {
            addCriterion("REFEREE_PHONE <=", value, "refereePhone");
            return (Criteria) this;
        }

        public Criteria andRefereePhoneLike(String value) {
            addCriterion("REFEREE_PHONE like", value, "refereePhone");
            return (Criteria) this;
        }

        public Criteria andRefereePhoneNotLike(String value) {
            addCriterion("REFEREE_PHONE not like", value, "refereePhone");
            return (Criteria) this;
        }

        public Criteria andRefereePhoneIn(List<String> values) {
            addCriterion("REFEREE_PHONE in", values, "refereePhone");
            return (Criteria) this;
        }

        public Criteria andRefereePhoneNotIn(List<String> values) {
            addCriterion("REFEREE_PHONE not in", values, "refereePhone");
            return (Criteria) this;
        }

        public Criteria andRefereePhoneBetween(String value1, String value2) {
            addCriterion("REFEREE_PHONE between", value1, value2, "refereePhone");
            return (Criteria) this;
        }

        public Criteria andRefereePhoneNotBetween(String value1, String value2) {
            addCriterion("REFEREE_PHONE not between", value1, value2, "refereePhone");
            return (Criteria) this;
        }

        public Criteria andMasterNoIsNull() {
            addCriterion("MASTER_NO is null");
            return (Criteria) this;
        }

        public Criteria andMasterNoIsNotNull() {
            addCriterion("MASTER_NO is not null");
            return (Criteria) this;
        }

        public Criteria andMasterNoEqualTo(String value) {
            addCriterion("MASTER_NO =", value, "masterNo");
            return (Criteria) this;
        }

        public Criteria andMasterNoNotEqualTo(String value) {
            addCriterion("MASTER_NO <>", value, "masterNo");
            return (Criteria) this;
        }

        public Criteria andMasterNoGreaterThan(String value) {
            addCriterion("MASTER_NO >", value, "masterNo");
            return (Criteria) this;
        }

        public Criteria andMasterNoGreaterThanOrEqualTo(String value) {
            addCriterion("MASTER_NO >=", value, "masterNo");
            return (Criteria) this;
        }

        public Criteria andMasterNoLessThan(String value) {
            addCriterion("MASTER_NO <", value, "masterNo");
            return (Criteria) this;
        }

        public Criteria andMasterNoLessThanOrEqualTo(String value) {
            addCriterion("MASTER_NO <=", value, "masterNo");
            return (Criteria) this;
        }

        public Criteria andMasterNoLike(String value) {
            addCriterion("MASTER_NO like", value, "masterNo");
            return (Criteria) this;
        }

        public Criteria andMasterNoNotLike(String value) {
            addCriterion("MASTER_NO not like", value, "masterNo");
            return (Criteria) this;
        }

        public Criteria andMasterNoIn(List<String> values) {
            addCriterion("MASTER_NO in", values, "masterNo");
            return (Criteria) this;
        }

        public Criteria andMasterNoNotIn(List<String> values) {
            addCriterion("MASTER_NO not in", values, "masterNo");
            return (Criteria) this;
        }

        public Criteria andMasterNoBetween(String value1, String value2) {
            addCriterion("MASTER_NO between", value1, value2, "masterNo");
            return (Criteria) this;
        }

        public Criteria andMasterNoNotBetween(String value1, String value2) {
            addCriterion("MASTER_NO not between", value1, value2, "masterNo");
            return (Criteria) this;
        }

        public Criteria andCarTypeIsNull() {
            addCriterion("CAR_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andCarTypeIsNotNull() {
            addCriterion("CAR_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andCarTypeEqualTo(String value) {
            addCriterion("CAR_TYPE =", value, "carType");
            return (Criteria) this;
        }

        public Criteria andCarTypeNotEqualTo(String value) {
            addCriterion("CAR_TYPE <>", value, "carType");
            return (Criteria) this;
        }

        public Criteria andCarTypeGreaterThan(String value) {
            addCriterion("CAR_TYPE >", value, "carType");
            return (Criteria) this;
        }

        public Criteria andCarTypeGreaterThanOrEqualTo(String value) {
            addCriterion("CAR_TYPE >=", value, "carType");
            return (Criteria) this;
        }

        public Criteria andCarTypeLessThan(String value) {
            addCriterion("CAR_TYPE <", value, "carType");
            return (Criteria) this;
        }

        public Criteria andCarTypeLessThanOrEqualTo(String value) {
            addCriterion("CAR_TYPE <=", value, "carType");
            return (Criteria) this;
        }

        public Criteria andCarTypeLike(String value) {
            addCriterion("CAR_TYPE like", value, "carType");
            return (Criteria) this;
        }

        public Criteria andCarTypeNotLike(String value) {
            addCriterion("CAR_TYPE not like", value, "carType");
            return (Criteria) this;
        }

        public Criteria andCarTypeIn(List<String> values) {
            addCriterion("CAR_TYPE in", values, "carType");
            return (Criteria) this;
        }

        public Criteria andCarTypeNotIn(List<String> values) {
            addCriterion("CAR_TYPE not in", values, "carType");
            return (Criteria) this;
        }

        public Criteria andCarTypeBetween(String value1, String value2) {
            addCriterion("CAR_TYPE between", value1, value2, "carType");
            return (Criteria) this;
        }

        public Criteria andCarTypeNotBetween(String value1, String value2) {
            addCriterion("CAR_TYPE not between", value1, value2, "carType");
            return (Criteria) this;
        }

        public Criteria andMasterFromIsNull() {
            addCriterion("MASTER_FROM is null");
            return (Criteria) this;
        }

        public Criteria andMasterFromIsNotNull() {
            addCriterion("MASTER_FROM is not null");
            return (Criteria) this;
        }

        public Criteria andMasterFromEqualTo(String value) {
            addCriterion("MASTER_FROM =", value, "masterFrom");
            return (Criteria) this;
        }

        public Criteria andMasterFromNotEqualTo(String value) {
            addCriterion("MASTER_FROM <>", value, "masterFrom");
            return (Criteria) this;
        }

        public Criteria andMasterFromGreaterThan(String value) {
            addCriterion("MASTER_FROM >", value, "masterFrom");
            return (Criteria) this;
        }

        public Criteria andMasterFromGreaterThanOrEqualTo(String value) {
            addCriterion("MASTER_FROM >=", value, "masterFrom");
            return (Criteria) this;
        }

        public Criteria andMasterFromLessThan(String value) {
            addCriterion("MASTER_FROM <", value, "masterFrom");
            return (Criteria) this;
        }

        public Criteria andMasterFromLessThanOrEqualTo(String value) {
            addCriterion("MASTER_FROM <=", value, "masterFrom");
            return (Criteria) this;
        }

        public Criteria andMasterFromLike(String value) {
            addCriterion("MASTER_FROM like", value, "masterFrom");
            return (Criteria) this;
        }

        public Criteria andMasterFromNotLike(String value) {
            addCriterion("MASTER_FROM not like", value, "masterFrom");
            return (Criteria) this;
        }

        public Criteria andMasterFromIn(List<String> values) {
            addCriterion("MASTER_FROM in", values, "masterFrom");
            return (Criteria) this;
        }

        public Criteria andMasterFromNotIn(List<String> values) {
            addCriterion("MASTER_FROM not in", values, "masterFrom");
            return (Criteria) this;
        }

        public Criteria andMasterFromBetween(String value1, String value2) {
            addCriterion("MASTER_FROM between", value1, value2, "masterFrom");
            return (Criteria) this;
        }

        public Criteria andMasterFromNotBetween(String value1, String value2) {
            addCriterion("MASTER_FROM not between", value1, value2, "masterFrom");
            return (Criteria) this;
        }

        public Criteria andBranchIsNull() {
            addCriterion("BRANCH is null");
            return (Criteria) this;
        }

        public Criteria andBranchIsNotNull() {
            addCriterion("BRANCH is not null");
            return (Criteria) this;
        }

        public Criteria andBranchEqualTo(String value) {
            addCriterion("BRANCH =", value, "branch");
            return (Criteria) this;
        }

        public Criteria andBranchNotEqualTo(String value) {
            addCriterion("BRANCH <>", value, "branch");
            return (Criteria) this;
        }

        public Criteria andBranchGreaterThan(String value) {
            addCriterion("BRANCH >", value, "branch");
            return (Criteria) this;
        }

        public Criteria andBranchGreaterThanOrEqualTo(String value) {
            addCriterion("BRANCH >=", value, "branch");
            return (Criteria) this;
        }

        public Criteria andBranchLessThan(String value) {
            addCriterion("BRANCH <", value, "branch");
            return (Criteria) this;
        }

        public Criteria andBranchLessThanOrEqualTo(String value) {
            addCriterion("BRANCH <=", value, "branch");
            return (Criteria) this;
        }

        public Criteria andBranchLike(String value) {
            addCriterion("BRANCH like", value, "branch");
            return (Criteria) this;
        }

        public Criteria andBranchNotLike(String value) {
            addCriterion("BRANCH not like", value, "branch");
            return (Criteria) this;
        }

        public Criteria andBranchIn(List<String> values) {
            addCriterion("BRANCH in", values, "branch");
            return (Criteria) this;
        }

        public Criteria andBranchNotIn(List<String> values) {
            addCriterion("BRANCH not in", values, "branch");
            return (Criteria) this;
        }

        public Criteria andBranchBetween(String value1, String value2) {
            addCriterion("BRANCH between", value1, value2, "branch");
            return (Criteria) this;
        }

        public Criteria andBranchNotBetween(String value1, String value2) {
            addCriterion("BRANCH not between", value1, value2, "branch");
            return (Criteria) this;
        }

        public Criteria andCertificationStatusIsNull() {
            addCriterion("CERTIFICATION_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andCertificationStatusIsNotNull() {
            addCriterion("CERTIFICATION_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andCertificationStatusEqualTo(BigDecimal value) {
            addCriterion("CERTIFICATION_STATUS =", value, "certificationStatus");
            return (Criteria) this;
        }

        public Criteria andCertificationStatusNotEqualTo(BigDecimal value) {
            addCriterion("CERTIFICATION_STATUS <>", value, "certificationStatus");
            return (Criteria) this;
        }

        public Criteria andCertificationStatusGreaterThan(BigDecimal value) {
            addCriterion("CERTIFICATION_STATUS >", value, "certificationStatus");
            return (Criteria) this;
        }

        public Criteria andCertificationStatusGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("CERTIFICATION_STATUS >=", value, "certificationStatus");
            return (Criteria) this;
        }

        public Criteria andCertificationStatusLessThan(BigDecimal value) {
            addCriterion("CERTIFICATION_STATUS <", value, "certificationStatus");
            return (Criteria) this;
        }

        public Criteria andCertificationStatusLessThanOrEqualTo(BigDecimal value) {
            addCriterion("CERTIFICATION_STATUS <=", value, "certificationStatus");
            return (Criteria) this;
        }

        public Criteria andCertificationStatusIn(List<BigDecimal> values) {
            addCriterion("CERTIFICATION_STATUS in", values, "certificationStatus");
            return (Criteria) this;
        }

        public Criteria andCertificationStatusNotIn(List<BigDecimal> values) {
            addCriterion("CERTIFICATION_STATUS not in", values, "certificationStatus");
            return (Criteria) this;
        }

        public Criteria andCertificationStatusBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CERTIFICATION_STATUS between", value1, value2, "certificationStatus");
            return (Criteria) this;
        }

        public Criteria andCertificationStatusNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CERTIFICATION_STATUS not between", value1, value2, "certificationStatus");
            return (Criteria) this;
        }

        public Criteria andWorkSkillIsNull() {
            addCriterion("WORK_SKILL is null");
            return (Criteria) this;
        }

        public Criteria andWorkSkillIsNotNull() {
            addCriterion("WORK_SKILL is not null");
            return (Criteria) this;
        }

        public Criteria andWorkSkillEqualTo(String value) {
            addCriterion("WORK_SKILL =", value, "workSkill");
            return (Criteria) this;
        }

        public Criteria andWorkSkillNotEqualTo(String value) {
            addCriterion("WORK_SKILL <>", value, "workSkill");
            return (Criteria) this;
        }

        public Criteria andWorkSkillGreaterThan(String value) {
            addCriterion("WORK_SKILL >", value, "workSkill");
            return (Criteria) this;
        }

        public Criteria andWorkSkillGreaterThanOrEqualTo(String value) {
            addCriterion("WORK_SKILL >=", value, "workSkill");
            return (Criteria) this;
        }

        public Criteria andWorkSkillLessThan(String value) {
            addCriterion("WORK_SKILL <", value, "workSkill");
            return (Criteria) this;
        }

        public Criteria andWorkSkillLessThanOrEqualTo(String value) {
            addCriterion("WORK_SKILL <=", value, "workSkill");
            return (Criteria) this;
        }

        public Criteria andWorkSkillLike(String value) {
            addCriterion("WORK_SKILL like", value, "workSkill");
            return (Criteria) this;
        }

        public Criteria andWorkSkillNotLike(String value) {
            addCriterion("WORK_SKILL not like", value, "workSkill");
            return (Criteria) this;
        }

        public Criteria andWorkSkillIn(List<String> values) {
            addCriterion("WORK_SKILL in", values, "workSkill");
            return (Criteria) this;
        }

        public Criteria andWorkSkillNotIn(List<String> values) {
            addCriterion("WORK_SKILL not in", values, "workSkill");
            return (Criteria) this;
        }

        public Criteria andWorkSkillBetween(String value1, String value2) {
            addCriterion("WORK_SKILL between", value1, value2, "workSkill");
            return (Criteria) this;
        }

        public Criteria andWorkSkillNotBetween(String value1, String value2) {
            addCriterion("WORK_SKILL not between", value1, value2, "workSkill");
            return (Criteria) this;
        }

        public Criteria andMasterTypeIsNull() {
            addCriterion("MASTER_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andMasterTypeIsNotNull() {
            addCriterion("MASTER_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andMasterTypeEqualTo(BigDecimal value) {
            addCriterion("MASTER_TYPE =", value, "masterType");
            return (Criteria) this;
        }

        public Criteria andMasterTypeNotEqualTo(BigDecimal value) {
            addCriterion("MASTER_TYPE <>", value, "masterType");
            return (Criteria) this;
        }

        public Criteria andMasterTypeGreaterThan(BigDecimal value) {
            addCriterion("MASTER_TYPE >", value, "masterType");
            return (Criteria) this;
        }

        public Criteria andMasterTypeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("MASTER_TYPE >=", value, "masterType");
            return (Criteria) this;
        }

        public Criteria andMasterTypeLessThan(BigDecimal value) {
            addCriterion("MASTER_TYPE <", value, "masterType");
            return (Criteria) this;
        }

        public Criteria andMasterTypeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("MASTER_TYPE <=", value, "masterType");
            return (Criteria) this;
        }

        public Criteria andMasterTypeIn(List<BigDecimal> values) {
            addCriterion("MASTER_TYPE in", values, "masterType");
            return (Criteria) this;
        }

        public Criteria andMasterTypeNotIn(List<BigDecimal> values) {
            addCriterion("MASTER_TYPE not in", values, "masterType");
            return (Criteria) this;
        }

        public Criteria andMasterTypeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MASTER_TYPE between", value1, value2, "masterType");
            return (Criteria) this;
        }

        public Criteria andMasterTypeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MASTER_TYPE not between", value1, value2, "masterType");
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