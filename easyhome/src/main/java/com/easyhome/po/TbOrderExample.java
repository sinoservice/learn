package com.easyhome.po;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TbOrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbOrderExample() {
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

        public Criteria andOrderTypeIsNull() {
            addCriterion("ORDER_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andOrderTypeIsNotNull() {
            addCriterion("ORDER_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andOrderTypeEqualTo(String value) {
            addCriterion("ORDER_TYPE =", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotEqualTo(String value) {
            addCriterion("ORDER_TYPE <>", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeGreaterThan(String value) {
            addCriterion("ORDER_TYPE >", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeGreaterThanOrEqualTo(String value) {
            addCriterion("ORDER_TYPE >=", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeLessThan(String value) {
            addCriterion("ORDER_TYPE <", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeLessThanOrEqualTo(String value) {
            addCriterion("ORDER_TYPE <=", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeLike(String value) {
            addCriterion("ORDER_TYPE like", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotLike(String value) {
            addCriterion("ORDER_TYPE not like", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeIn(List<String> values) {
            addCriterion("ORDER_TYPE in", values, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotIn(List<String> values) {
            addCriterion("ORDER_TYPE not in", values, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeBetween(String value1, String value2) {
            addCriterion("ORDER_TYPE between", value1, value2, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotBetween(String value1, String value2) {
            addCriterion("ORDER_TYPE not between", value1, value2, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrgIdIsNull() {
            addCriterion("ORG_ID is null");
            return (Criteria) this;
        }

        public Criteria andOrgIdIsNotNull() {
            addCriterion("ORG_ID is not null");
            return (Criteria) this;
        }

        public Criteria andOrgIdEqualTo(BigDecimal value) {
            addCriterion("ORG_ID =", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotEqualTo(BigDecimal value) {
            addCriterion("ORG_ID <>", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdGreaterThan(BigDecimal value) {
            addCriterion("ORG_ID >", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ORG_ID >=", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdLessThan(BigDecimal value) {
            addCriterion("ORG_ID <", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ORG_ID <=", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdIn(List<BigDecimal> values) {
            addCriterion("ORG_ID in", values, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotIn(List<BigDecimal> values) {
            addCriterion("ORG_ID not in", values, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ORG_ID between", value1, value2, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ORG_ID not between", value1, value2, "orgId");
            return (Criteria) this;
        }

        public Criteria andStoreIdIsNull() {
            addCriterion("STORE_ID is null");
            return (Criteria) this;
        }

        public Criteria andStoreIdIsNotNull() {
            addCriterion("STORE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andStoreIdEqualTo(BigDecimal value) {
            addCriterion("STORE_ID =", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdNotEqualTo(BigDecimal value) {
            addCriterion("STORE_ID <>", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdGreaterThan(BigDecimal value) {
            addCriterion("STORE_ID >", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("STORE_ID >=", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdLessThan(BigDecimal value) {
            addCriterion("STORE_ID <", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdLessThanOrEqualTo(BigDecimal value) {
            addCriterion("STORE_ID <=", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdIn(List<BigDecimal> values) {
            addCriterion("STORE_ID in", values, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdNotIn(List<BigDecimal> values) {
            addCriterion("STORE_ID not in", values, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("STORE_ID between", value1, value2, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("STORE_ID not between", value1, value2, "storeId");
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

        public Criteria andWarehouseIdIsNull() {
            addCriterion("WAREHOUSE_ID is null");
            return (Criteria) this;
        }

        public Criteria andWarehouseIdIsNotNull() {
            addCriterion("WAREHOUSE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andWarehouseIdEqualTo(BigDecimal value) {
            addCriterion("WAREHOUSE_ID =", value, "warehouseId");
            return (Criteria) this;
        }

        public Criteria andWarehouseIdNotEqualTo(BigDecimal value) {
            addCriterion("WAREHOUSE_ID <>", value, "warehouseId");
            return (Criteria) this;
        }

        public Criteria andWarehouseIdGreaterThan(BigDecimal value) {
            addCriterion("WAREHOUSE_ID >", value, "warehouseId");
            return (Criteria) this;
        }

        public Criteria andWarehouseIdGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("WAREHOUSE_ID >=", value, "warehouseId");
            return (Criteria) this;
        }

        public Criteria andWarehouseIdLessThan(BigDecimal value) {
            addCriterion("WAREHOUSE_ID <", value, "warehouseId");
            return (Criteria) this;
        }

        public Criteria andWarehouseIdLessThanOrEqualTo(BigDecimal value) {
            addCriterion("WAREHOUSE_ID <=", value, "warehouseId");
            return (Criteria) this;
        }

        public Criteria andWarehouseIdIn(List<BigDecimal> values) {
            addCriterion("WAREHOUSE_ID in", values, "warehouseId");
            return (Criteria) this;
        }

        public Criteria andWarehouseIdNotIn(List<BigDecimal> values) {
            addCriterion("WAREHOUSE_ID not in", values, "warehouseId");
            return (Criteria) this;
        }

        public Criteria andWarehouseIdBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("WAREHOUSE_ID between", value1, value2, "warehouseId");
            return (Criteria) this;
        }

        public Criteria andWarehouseIdNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("WAREHOUSE_ID not between", value1, value2, "warehouseId");
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

        public Criteria andCheckstatusIsNull() {
            addCriterion("CHECKSTATUS is null");
            return (Criteria) this;
        }

        public Criteria andCheckstatusIsNotNull() {
            addCriterion("CHECKSTATUS is not null");
            return (Criteria) this;
        }

        public Criteria andCheckstatusEqualTo(BigDecimal value) {
            addCriterion("CHECKSTATUS =", value, "checkstatus");
            return (Criteria) this;
        }

        public Criteria andCheckstatusNotEqualTo(BigDecimal value) {
            addCriterion("CHECKSTATUS <>", value, "checkstatus");
            return (Criteria) this;
        }

        public Criteria andCheckstatusGreaterThan(BigDecimal value) {
            addCriterion("CHECKSTATUS >", value, "checkstatus");
            return (Criteria) this;
        }

        public Criteria andCheckstatusGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("CHECKSTATUS >=", value, "checkstatus");
            return (Criteria) this;
        }

        public Criteria andCheckstatusLessThan(BigDecimal value) {
            addCriterion("CHECKSTATUS <", value, "checkstatus");
            return (Criteria) this;
        }

        public Criteria andCheckstatusLessThanOrEqualTo(BigDecimal value) {
            addCriterion("CHECKSTATUS <=", value, "checkstatus");
            return (Criteria) this;
        }

        public Criteria andCheckstatusIn(List<BigDecimal> values) {
            addCriterion("CHECKSTATUS in", values, "checkstatus");
            return (Criteria) this;
        }

        public Criteria andCheckstatusNotIn(List<BigDecimal> values) {
            addCriterion("CHECKSTATUS not in", values, "checkstatus");
            return (Criteria) this;
        }

        public Criteria andCheckstatusBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CHECKSTATUS between", value1, value2, "checkstatus");
            return (Criteria) this;
        }

        public Criteria andCheckstatusNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CHECKSTATUS not between", value1, value2, "checkstatus");
            return (Criteria) this;
        }

        public Criteria andOutStatusIsNull() {
            addCriterion("OUT_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andOutStatusIsNotNull() {
            addCriterion("OUT_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andOutStatusEqualTo(String value) {
            addCriterion("OUT_STATUS =", value, "outStatus");
            return (Criteria) this;
        }

        public Criteria andOutStatusNotEqualTo(String value) {
            addCriterion("OUT_STATUS <>", value, "outStatus");
            return (Criteria) this;
        }

        public Criteria andOutStatusGreaterThan(String value) {
            addCriterion("OUT_STATUS >", value, "outStatus");
            return (Criteria) this;
        }

        public Criteria andOutStatusGreaterThanOrEqualTo(String value) {
            addCriterion("OUT_STATUS >=", value, "outStatus");
            return (Criteria) this;
        }

        public Criteria andOutStatusLessThan(String value) {
            addCriterion("OUT_STATUS <", value, "outStatus");
            return (Criteria) this;
        }

        public Criteria andOutStatusLessThanOrEqualTo(String value) {
            addCriterion("OUT_STATUS <=", value, "outStatus");
            return (Criteria) this;
        }

        public Criteria andOutStatusLike(String value) {
            addCriterion("OUT_STATUS like", value, "outStatus");
            return (Criteria) this;
        }

        public Criteria andOutStatusNotLike(String value) {
            addCriterion("OUT_STATUS not like", value, "outStatus");
            return (Criteria) this;
        }

        public Criteria andOutStatusIn(List<String> values) {
            addCriterion("OUT_STATUS in", values, "outStatus");
            return (Criteria) this;
        }

        public Criteria andOutStatusNotIn(List<String> values) {
            addCriterion("OUT_STATUS not in", values, "outStatus");
            return (Criteria) this;
        }

        public Criteria andOutStatusBetween(String value1, String value2) {
            addCriterion("OUT_STATUS between", value1, value2, "outStatus");
            return (Criteria) this;
        }

        public Criteria andOutStatusNotBetween(String value1, String value2) {
            addCriterion("OUT_STATUS not between", value1, value2, "outStatus");
            return (Criteria) this;
        }

        public Criteria andDdDateIsNull() {
            addCriterion("DD_DATE is null");
            return (Criteria) this;
        }

        public Criteria andDdDateIsNotNull() {
            addCriterion("DD_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andDdDateEqualTo(Date value) {
            addCriterionForJDBCDate("DD_DATE =", value, "ddDate");
            return (Criteria) this;
        }

        public Criteria andDdDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("DD_DATE <>", value, "ddDate");
            return (Criteria) this;
        }

        public Criteria andDdDateGreaterThan(Date value) {
            addCriterionForJDBCDate("DD_DATE >", value, "ddDate");
            return (Criteria) this;
        }

        public Criteria andDdDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("DD_DATE >=", value, "ddDate");
            return (Criteria) this;
        }

        public Criteria andDdDateLessThan(Date value) {
            addCriterionForJDBCDate("DD_DATE <", value, "ddDate");
            return (Criteria) this;
        }

        public Criteria andDdDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("DD_DATE <=", value, "ddDate");
            return (Criteria) this;
        }

        public Criteria andDdDateIn(List<Date> values) {
            addCriterionForJDBCDate("DD_DATE in", values, "ddDate");
            return (Criteria) this;
        }

        public Criteria andDdDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("DD_DATE not in", values, "ddDate");
            return (Criteria) this;
        }

        public Criteria andDdDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("DD_DATE between", value1, value2, "ddDate");
            return (Criteria) this;
        }

        public Criteria andDdDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("DD_DATE not between", value1, value2, "ddDate");
            return (Criteria) this;
        }

        public Criteria andShDateIsNull() {
            addCriterion("SH_DATE is null");
            return (Criteria) this;
        }

        public Criteria andShDateIsNotNull() {
            addCriterion("SH_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andShDateEqualTo(Date value) {
            addCriterionForJDBCDate("SH_DATE =", value, "shDate");
            return (Criteria) this;
        }

        public Criteria andShDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("SH_DATE <>", value, "shDate");
            return (Criteria) this;
        }

        public Criteria andShDateGreaterThan(Date value) {
            addCriterionForJDBCDate("SH_DATE >", value, "shDate");
            return (Criteria) this;
        }

        public Criteria andShDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("SH_DATE >=", value, "shDate");
            return (Criteria) this;
        }

        public Criteria andShDateLessThan(Date value) {
            addCriterionForJDBCDate("SH_DATE <", value, "shDate");
            return (Criteria) this;
        }

        public Criteria andShDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("SH_DATE <=", value, "shDate");
            return (Criteria) this;
        }

        public Criteria andShDateIn(List<Date> values) {
            addCriterionForJDBCDate("SH_DATE in", values, "shDate");
            return (Criteria) this;
        }

        public Criteria andShDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("SH_DATE not in", values, "shDate");
            return (Criteria) this;
        }

        public Criteria andShDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("SH_DATE between", value1, value2, "shDate");
            return (Criteria) this;
        }

        public Criteria andShDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("SH_DATE not between", value1, value2, "shDate");
            return (Criteria) this;
        }

        public Criteria andMemberIdIsNull() {
            addCriterion("MEMBER_ID is null");
            return (Criteria) this;
        }

        public Criteria andMemberIdIsNotNull() {
            addCriterion("MEMBER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andMemberIdEqualTo(String value) {
            addCriterion("MEMBER_ID =", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdNotEqualTo(String value) {
            addCriterion("MEMBER_ID <>", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdGreaterThan(String value) {
            addCriterion("MEMBER_ID >", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdGreaterThanOrEqualTo(String value) {
            addCriterion("MEMBER_ID >=", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdLessThan(String value) {
            addCriterion("MEMBER_ID <", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdLessThanOrEqualTo(String value) {
            addCriterion("MEMBER_ID <=", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdLike(String value) {
            addCriterion("MEMBER_ID like", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdNotLike(String value) {
            addCriterion("MEMBER_ID not like", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdIn(List<String> values) {
            addCriterion("MEMBER_ID in", values, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdNotIn(List<String> values) {
            addCriterion("MEMBER_ID not in", values, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdBetween(String value1, String value2) {
            addCriterion("MEMBER_ID between", value1, value2, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdNotBetween(String value1, String value2) {
            addCriterion("MEMBER_ID not between", value1, value2, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberCodeIsNull() {
            addCriterion("MEMBER_CODE is null");
            return (Criteria) this;
        }

        public Criteria andMemberCodeIsNotNull() {
            addCriterion("MEMBER_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andMemberCodeEqualTo(String value) {
            addCriterion("MEMBER_CODE =", value, "memberCode");
            return (Criteria) this;
        }

        public Criteria andMemberCodeNotEqualTo(String value) {
            addCriterion("MEMBER_CODE <>", value, "memberCode");
            return (Criteria) this;
        }

        public Criteria andMemberCodeGreaterThan(String value) {
            addCriterion("MEMBER_CODE >", value, "memberCode");
            return (Criteria) this;
        }

        public Criteria andMemberCodeGreaterThanOrEqualTo(String value) {
            addCriterion("MEMBER_CODE >=", value, "memberCode");
            return (Criteria) this;
        }

        public Criteria andMemberCodeLessThan(String value) {
            addCriterion("MEMBER_CODE <", value, "memberCode");
            return (Criteria) this;
        }

        public Criteria andMemberCodeLessThanOrEqualTo(String value) {
            addCriterion("MEMBER_CODE <=", value, "memberCode");
            return (Criteria) this;
        }

        public Criteria andMemberCodeLike(String value) {
            addCriterion("MEMBER_CODE like", value, "memberCode");
            return (Criteria) this;
        }

        public Criteria andMemberCodeNotLike(String value) {
            addCriterion("MEMBER_CODE not like", value, "memberCode");
            return (Criteria) this;
        }

        public Criteria andMemberCodeIn(List<String> values) {
            addCriterion("MEMBER_CODE in", values, "memberCode");
            return (Criteria) this;
        }

        public Criteria andMemberCodeNotIn(List<String> values) {
            addCriterion("MEMBER_CODE not in", values, "memberCode");
            return (Criteria) this;
        }

        public Criteria andMemberCodeBetween(String value1, String value2) {
            addCriterion("MEMBER_CODE between", value1, value2, "memberCode");
            return (Criteria) this;
        }

        public Criteria andMemberCodeNotBetween(String value1, String value2) {
            addCriterion("MEMBER_CODE not between", value1, value2, "memberCode");
            return (Criteria) this;
        }

        public Criteria andShipNameIsNull() {
            addCriterion("SHIP_NAME is null");
            return (Criteria) this;
        }

        public Criteria andShipNameIsNotNull() {
            addCriterion("SHIP_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andShipNameEqualTo(String value) {
            addCriterion("SHIP_NAME =", value, "shipName");
            return (Criteria) this;
        }

        public Criteria andShipNameNotEqualTo(String value) {
            addCriterion("SHIP_NAME <>", value, "shipName");
            return (Criteria) this;
        }

        public Criteria andShipNameGreaterThan(String value) {
            addCriterion("SHIP_NAME >", value, "shipName");
            return (Criteria) this;
        }

        public Criteria andShipNameGreaterThanOrEqualTo(String value) {
            addCriterion("SHIP_NAME >=", value, "shipName");
            return (Criteria) this;
        }

        public Criteria andShipNameLessThan(String value) {
            addCriterion("SHIP_NAME <", value, "shipName");
            return (Criteria) this;
        }

        public Criteria andShipNameLessThanOrEqualTo(String value) {
            addCriterion("SHIP_NAME <=", value, "shipName");
            return (Criteria) this;
        }

        public Criteria andShipNameLike(String value) {
            addCriterion("SHIP_NAME like", value, "shipName");
            return (Criteria) this;
        }

        public Criteria andShipNameNotLike(String value) {
            addCriterion("SHIP_NAME not like", value, "shipName");
            return (Criteria) this;
        }

        public Criteria andShipNameIn(List<String> values) {
            addCriterion("SHIP_NAME in", values, "shipName");
            return (Criteria) this;
        }

        public Criteria andShipNameNotIn(List<String> values) {
            addCriterion("SHIP_NAME not in", values, "shipName");
            return (Criteria) this;
        }

        public Criteria andShipNameBetween(String value1, String value2) {
            addCriterion("SHIP_NAME between", value1, value2, "shipName");
            return (Criteria) this;
        }

        public Criteria andShipNameNotBetween(String value1, String value2) {
            addCriterion("SHIP_NAME not between", value1, value2, "shipName");
            return (Criteria) this;
        }

        public Criteria andShipMobileIsNull() {
            addCriterion("SHIP_MOBILE is null");
            return (Criteria) this;
        }

        public Criteria andShipMobileIsNotNull() {
            addCriterion("SHIP_MOBILE is not null");
            return (Criteria) this;
        }

        public Criteria andShipMobileEqualTo(String value) {
            addCriterion("SHIP_MOBILE =", value, "shipMobile");
            return (Criteria) this;
        }

        public Criteria andShipMobileNotEqualTo(String value) {
            addCriterion("SHIP_MOBILE <>", value, "shipMobile");
            return (Criteria) this;
        }

        public Criteria andShipMobileGreaterThan(String value) {
            addCriterion("SHIP_MOBILE >", value, "shipMobile");
            return (Criteria) this;
        }

        public Criteria andShipMobileGreaterThanOrEqualTo(String value) {
            addCriterion("SHIP_MOBILE >=", value, "shipMobile");
            return (Criteria) this;
        }

        public Criteria andShipMobileLessThan(String value) {
            addCriterion("SHIP_MOBILE <", value, "shipMobile");
            return (Criteria) this;
        }

        public Criteria andShipMobileLessThanOrEqualTo(String value) {
            addCriterion("SHIP_MOBILE <=", value, "shipMobile");
            return (Criteria) this;
        }

        public Criteria andShipMobileLike(String value) {
            addCriterion("SHIP_MOBILE like", value, "shipMobile");
            return (Criteria) this;
        }

        public Criteria andShipMobileNotLike(String value) {
            addCriterion("SHIP_MOBILE not like", value, "shipMobile");
            return (Criteria) this;
        }

        public Criteria andShipMobileIn(List<String> values) {
            addCriterion("SHIP_MOBILE in", values, "shipMobile");
            return (Criteria) this;
        }

        public Criteria andShipMobileNotIn(List<String> values) {
            addCriterion("SHIP_MOBILE not in", values, "shipMobile");
            return (Criteria) this;
        }

        public Criteria andShipMobileBetween(String value1, String value2) {
            addCriterion("SHIP_MOBILE between", value1, value2, "shipMobile");
            return (Criteria) this;
        }

        public Criteria andShipMobileNotBetween(String value1, String value2) {
            addCriterion("SHIP_MOBILE not between", value1, value2, "shipMobile");
            return (Criteria) this;
        }

        public Criteria andShipAddressIsNull() {
            addCriterion("SHIP_ADDRESS is null");
            return (Criteria) this;
        }

        public Criteria andShipAddressIsNotNull() {
            addCriterion("SHIP_ADDRESS is not null");
            return (Criteria) this;
        }

        public Criteria andShipAddressEqualTo(String value) {
            addCriterion("SHIP_ADDRESS =", value, "shipAddress");
            return (Criteria) this;
        }

        public Criteria andShipAddressNotEqualTo(String value) {
            addCriterion("SHIP_ADDRESS <>", value, "shipAddress");
            return (Criteria) this;
        }

        public Criteria andShipAddressGreaterThan(String value) {
            addCriterion("SHIP_ADDRESS >", value, "shipAddress");
            return (Criteria) this;
        }

        public Criteria andShipAddressGreaterThanOrEqualTo(String value) {
            addCriterion("SHIP_ADDRESS >=", value, "shipAddress");
            return (Criteria) this;
        }

        public Criteria andShipAddressLessThan(String value) {
            addCriterion("SHIP_ADDRESS <", value, "shipAddress");
            return (Criteria) this;
        }

        public Criteria andShipAddressLessThanOrEqualTo(String value) {
            addCriterion("SHIP_ADDRESS <=", value, "shipAddress");
            return (Criteria) this;
        }

        public Criteria andShipAddressLike(String value) {
            addCriterion("SHIP_ADDRESS like", value, "shipAddress");
            return (Criteria) this;
        }

        public Criteria andShipAddressNotLike(String value) {
            addCriterion("SHIP_ADDRESS not like", value, "shipAddress");
            return (Criteria) this;
        }

        public Criteria andShipAddressIn(List<String> values) {
            addCriterion("SHIP_ADDRESS in", values, "shipAddress");
            return (Criteria) this;
        }

        public Criteria andShipAddressNotIn(List<String> values) {
            addCriterion("SHIP_ADDRESS not in", values, "shipAddress");
            return (Criteria) this;
        }

        public Criteria andShipAddressBetween(String value1, String value2) {
            addCriterion("SHIP_ADDRESS between", value1, value2, "shipAddress");
            return (Criteria) this;
        }

        public Criteria andShipAddressNotBetween(String value1, String value2) {
            addCriterion("SHIP_ADDRESS not between", value1, value2, "shipAddress");
            return (Criteria) this;
        }

        public Criteria andTotalProductPriceIsNull() {
            addCriterion("TOTAL_PRODUCT_PRICE is null");
            return (Criteria) this;
        }

        public Criteria andTotalProductPriceIsNotNull() {
            addCriterion("TOTAL_PRODUCT_PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andTotalProductPriceEqualTo(BigDecimal value) {
            addCriterion("TOTAL_PRODUCT_PRICE =", value, "totalProductPrice");
            return (Criteria) this;
        }

        public Criteria andTotalProductPriceNotEqualTo(BigDecimal value) {
            addCriterion("TOTAL_PRODUCT_PRICE <>", value, "totalProductPrice");
            return (Criteria) this;
        }

        public Criteria andTotalProductPriceGreaterThan(BigDecimal value) {
            addCriterion("TOTAL_PRODUCT_PRICE >", value, "totalProductPrice");
            return (Criteria) this;
        }

        public Criteria andTotalProductPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("TOTAL_PRODUCT_PRICE >=", value, "totalProductPrice");
            return (Criteria) this;
        }

        public Criteria andTotalProductPriceLessThan(BigDecimal value) {
            addCriterion("TOTAL_PRODUCT_PRICE <", value, "totalProductPrice");
            return (Criteria) this;
        }

        public Criteria andTotalProductPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("TOTAL_PRODUCT_PRICE <=", value, "totalProductPrice");
            return (Criteria) this;
        }

        public Criteria andTotalProductPriceIn(List<BigDecimal> values) {
            addCriterion("TOTAL_PRODUCT_PRICE in", values, "totalProductPrice");
            return (Criteria) this;
        }

        public Criteria andTotalProductPriceNotIn(List<BigDecimal> values) {
            addCriterion("TOTAL_PRODUCT_PRICE not in", values, "totalProductPrice");
            return (Criteria) this;
        }

        public Criteria andTotalProductPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TOTAL_PRODUCT_PRICE between", value1, value2, "totalProductPrice");
            return (Criteria) this;
        }

        public Criteria andTotalProductPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TOTAL_PRODUCT_PRICE not between", value1, value2, "totalProductPrice");
            return (Criteria) this;
        }

        public Criteria andOutCreateDateIsNull() {
            addCriterion("OUT_CREATE_DATE is null");
            return (Criteria) this;
        }

        public Criteria andOutCreateDateIsNotNull() {
            addCriterion("OUT_CREATE_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andOutCreateDateEqualTo(Date value) {
            addCriterionForJDBCDate("OUT_CREATE_DATE =", value, "outCreateDate");
            return (Criteria) this;
        }

        public Criteria andOutCreateDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("OUT_CREATE_DATE <>", value, "outCreateDate");
            return (Criteria) this;
        }

        public Criteria andOutCreateDateGreaterThan(Date value) {
            addCriterionForJDBCDate("OUT_CREATE_DATE >", value, "outCreateDate");
            return (Criteria) this;
        }

        public Criteria andOutCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("OUT_CREATE_DATE >=", value, "outCreateDate");
            return (Criteria) this;
        }

        public Criteria andOutCreateDateLessThan(Date value) {
            addCriterionForJDBCDate("OUT_CREATE_DATE <", value, "outCreateDate");
            return (Criteria) this;
        }

        public Criteria andOutCreateDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("OUT_CREATE_DATE <=", value, "outCreateDate");
            return (Criteria) this;
        }

        public Criteria andOutCreateDateIn(List<Date> values) {
            addCriterionForJDBCDate("OUT_CREATE_DATE in", values, "outCreateDate");
            return (Criteria) this;
        }

        public Criteria andOutCreateDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("OUT_CREATE_DATE not in", values, "outCreateDate");
            return (Criteria) this;
        }

        public Criteria andOutCreateDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("OUT_CREATE_DATE between", value1, value2, "outCreateDate");
            return (Criteria) this;
        }

        public Criteria andOutCreateDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("OUT_CREATE_DATE not between", value1, value2, "outCreateDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNull() {
            addCriterion("CREATE_DATE is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("CREATE_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterionForJDBCDate("CREATE_DATE =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("CREATE_DATE <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterionForJDBCDate("CREATE_DATE >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("CREATE_DATE >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterionForJDBCDate("CREATE_DATE <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("CREATE_DATE <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterionForJDBCDate("CREATE_DATE in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("CREATE_DATE not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("CREATE_DATE between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("CREATE_DATE not between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andLrjdedateIsNull() {
            addCriterion("LRJDEDATE is null");
            return (Criteria) this;
        }

        public Criteria andLrjdedateIsNotNull() {
            addCriterion("LRJDEDATE is not null");
            return (Criteria) this;
        }

        public Criteria andLrjdedateEqualTo(Date value) {
            addCriterionForJDBCDate("LRJDEDATE =", value, "lrjdedate");
            return (Criteria) this;
        }

        public Criteria andLrjdedateNotEqualTo(Date value) {
            addCriterionForJDBCDate("LRJDEDATE <>", value, "lrjdedate");
            return (Criteria) this;
        }

        public Criteria andLrjdedateGreaterThan(Date value) {
            addCriterionForJDBCDate("LRJDEDATE >", value, "lrjdedate");
            return (Criteria) this;
        }

        public Criteria andLrjdedateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("LRJDEDATE >=", value, "lrjdedate");
            return (Criteria) this;
        }

        public Criteria andLrjdedateLessThan(Date value) {
            addCriterionForJDBCDate("LRJDEDATE <", value, "lrjdedate");
            return (Criteria) this;
        }

        public Criteria andLrjdedateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("LRJDEDATE <=", value, "lrjdedate");
            return (Criteria) this;
        }

        public Criteria andLrjdedateIn(List<Date> values) {
            addCriterionForJDBCDate("LRJDEDATE in", values, "lrjdedate");
            return (Criteria) this;
        }

        public Criteria andLrjdedateNotIn(List<Date> values) {
            addCriterionForJDBCDate("LRJDEDATE not in", values, "lrjdedate");
            return (Criteria) this;
        }

        public Criteria andLrjdedateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("LRJDEDATE between", value1, value2, "lrjdedate");
            return (Criteria) this;
        }

        public Criteria andLrjdedateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("LRJDEDATE not between", value1, value2, "lrjdedate");
            return (Criteria) this;
        }

        public Criteria andCkDateIsNull() {
            addCriterion("CK_DATE is null");
            return (Criteria) this;
        }

        public Criteria andCkDateIsNotNull() {
            addCriterion("CK_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andCkDateEqualTo(Date value) {
            addCriterionForJDBCDate("CK_DATE =", value, "ckDate");
            return (Criteria) this;
        }

        public Criteria andCkDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("CK_DATE <>", value, "ckDate");
            return (Criteria) this;
        }

        public Criteria andCkDateGreaterThan(Date value) {
            addCriterionForJDBCDate("CK_DATE >", value, "ckDate");
            return (Criteria) this;
        }

        public Criteria andCkDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("CK_DATE >=", value, "ckDate");
            return (Criteria) this;
        }

        public Criteria andCkDateLessThan(Date value) {
            addCriterionForJDBCDate("CK_DATE <", value, "ckDate");
            return (Criteria) this;
        }

        public Criteria andCkDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("CK_DATE <=", value, "ckDate");
            return (Criteria) this;
        }

        public Criteria andCkDateIn(List<Date> values) {
            addCriterionForJDBCDate("CK_DATE in", values, "ckDate");
            return (Criteria) this;
        }

        public Criteria andCkDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("CK_DATE not in", values, "ckDate");
            return (Criteria) this;
        }

        public Criteria andCkDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("CK_DATE between", value1, value2, "ckDate");
            return (Criteria) this;
        }

        public Criteria andCkDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("CK_DATE not between", value1, value2, "ckDate");
            return (Criteria) this;
        }

        public Criteria andStoresInvoiceIdIsNull() {
            addCriterion("STORES_INVOICE_ID is null");
            return (Criteria) this;
        }

        public Criteria andStoresInvoiceIdIsNotNull() {
            addCriterion("STORES_INVOICE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andStoresInvoiceIdEqualTo(BigDecimal value) {
            addCriterion("STORES_INVOICE_ID =", value, "storesInvoiceId");
            return (Criteria) this;
        }

        public Criteria andStoresInvoiceIdNotEqualTo(BigDecimal value) {
            addCriterion("STORES_INVOICE_ID <>", value, "storesInvoiceId");
            return (Criteria) this;
        }

        public Criteria andStoresInvoiceIdGreaterThan(BigDecimal value) {
            addCriterion("STORES_INVOICE_ID >", value, "storesInvoiceId");
            return (Criteria) this;
        }

        public Criteria andStoresInvoiceIdGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("STORES_INVOICE_ID >=", value, "storesInvoiceId");
            return (Criteria) this;
        }

        public Criteria andStoresInvoiceIdLessThan(BigDecimal value) {
            addCriterion("STORES_INVOICE_ID <", value, "storesInvoiceId");
            return (Criteria) this;
        }

        public Criteria andStoresInvoiceIdLessThanOrEqualTo(BigDecimal value) {
            addCriterion("STORES_INVOICE_ID <=", value, "storesInvoiceId");
            return (Criteria) this;
        }

        public Criteria andStoresInvoiceIdIn(List<BigDecimal> values) {
            addCriterion("STORES_INVOICE_ID in", values, "storesInvoiceId");
            return (Criteria) this;
        }

        public Criteria andStoresInvoiceIdNotIn(List<BigDecimal> values) {
            addCriterion("STORES_INVOICE_ID not in", values, "storesInvoiceId");
            return (Criteria) this;
        }

        public Criteria andStoresInvoiceIdBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("STORES_INVOICE_ID between", value1, value2, "storesInvoiceId");
            return (Criteria) this;
        }

        public Criteria andStoresInvoiceIdNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("STORES_INVOICE_ID not between", value1, value2, "storesInvoiceId");
            return (Criteria) this;
        }

        public Criteria andStoresInvoiceNameIsNull() {
            addCriterion("STORES_INVOICE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andStoresInvoiceNameIsNotNull() {
            addCriterion("STORES_INVOICE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andStoresInvoiceNameEqualTo(String value) {
            addCriterion("STORES_INVOICE_NAME =", value, "storesInvoiceName");
            return (Criteria) this;
        }

        public Criteria andStoresInvoiceNameNotEqualTo(String value) {
            addCriterion("STORES_INVOICE_NAME <>", value, "storesInvoiceName");
            return (Criteria) this;
        }

        public Criteria andStoresInvoiceNameGreaterThan(String value) {
            addCriterion("STORES_INVOICE_NAME >", value, "storesInvoiceName");
            return (Criteria) this;
        }

        public Criteria andStoresInvoiceNameGreaterThanOrEqualTo(String value) {
            addCriterion("STORES_INVOICE_NAME >=", value, "storesInvoiceName");
            return (Criteria) this;
        }

        public Criteria andStoresInvoiceNameLessThan(String value) {
            addCriterion("STORES_INVOICE_NAME <", value, "storesInvoiceName");
            return (Criteria) this;
        }

        public Criteria andStoresInvoiceNameLessThanOrEqualTo(String value) {
            addCriterion("STORES_INVOICE_NAME <=", value, "storesInvoiceName");
            return (Criteria) this;
        }

        public Criteria andStoresInvoiceNameLike(String value) {
            addCriterion("STORES_INVOICE_NAME like", value, "storesInvoiceName");
            return (Criteria) this;
        }

        public Criteria andStoresInvoiceNameNotLike(String value) {
            addCriterion("STORES_INVOICE_NAME not like", value, "storesInvoiceName");
            return (Criteria) this;
        }

        public Criteria andStoresInvoiceNameIn(List<String> values) {
            addCriterion("STORES_INVOICE_NAME in", values, "storesInvoiceName");
            return (Criteria) this;
        }

        public Criteria andStoresInvoiceNameNotIn(List<String> values) {
            addCriterion("STORES_INVOICE_NAME not in", values, "storesInvoiceName");
            return (Criteria) this;
        }

        public Criteria andStoresInvoiceNameBetween(String value1, String value2) {
            addCriterion("STORES_INVOICE_NAME between", value1, value2, "storesInvoiceName");
            return (Criteria) this;
        }

        public Criteria andStoresInvoiceNameNotBetween(String value1, String value2) {
            addCriterion("STORES_INVOICE_NAME not between", value1, value2, "storesInvoiceName");
            return (Criteria) this;
        }

        public Criteria andStoresWorkerNameIsNull() {
            addCriterion("STORES_WORKER_NAME is null");
            return (Criteria) this;
        }

        public Criteria andStoresWorkerNameIsNotNull() {
            addCriterion("STORES_WORKER_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andStoresWorkerNameEqualTo(String value) {
            addCriterion("STORES_WORKER_NAME =", value, "storesWorkerName");
            return (Criteria) this;
        }

        public Criteria andStoresWorkerNameNotEqualTo(String value) {
            addCriterion("STORES_WORKER_NAME <>", value, "storesWorkerName");
            return (Criteria) this;
        }

        public Criteria andStoresWorkerNameGreaterThan(String value) {
            addCriterion("STORES_WORKER_NAME >", value, "storesWorkerName");
            return (Criteria) this;
        }

        public Criteria andStoresWorkerNameGreaterThanOrEqualTo(String value) {
            addCriterion("STORES_WORKER_NAME >=", value, "storesWorkerName");
            return (Criteria) this;
        }

        public Criteria andStoresWorkerNameLessThan(String value) {
            addCriterion("STORES_WORKER_NAME <", value, "storesWorkerName");
            return (Criteria) this;
        }

        public Criteria andStoresWorkerNameLessThanOrEqualTo(String value) {
            addCriterion("STORES_WORKER_NAME <=", value, "storesWorkerName");
            return (Criteria) this;
        }

        public Criteria andStoresWorkerNameLike(String value) {
            addCriterion("STORES_WORKER_NAME like", value, "storesWorkerName");
            return (Criteria) this;
        }

        public Criteria andStoresWorkerNameNotLike(String value) {
            addCriterion("STORES_WORKER_NAME not like", value, "storesWorkerName");
            return (Criteria) this;
        }

        public Criteria andStoresWorkerNameIn(List<String> values) {
            addCriterion("STORES_WORKER_NAME in", values, "storesWorkerName");
            return (Criteria) this;
        }

        public Criteria andStoresWorkerNameNotIn(List<String> values) {
            addCriterion("STORES_WORKER_NAME not in", values, "storesWorkerName");
            return (Criteria) this;
        }

        public Criteria andStoresWorkerNameBetween(String value1, String value2) {
            addCriterion("STORES_WORKER_NAME between", value1, value2, "storesWorkerName");
            return (Criteria) this;
        }

        public Criteria andStoresWorkerNameNotBetween(String value1, String value2) {
            addCriterion("STORES_WORKER_NAME not between", value1, value2, "storesWorkerName");
            return (Criteria) this;
        }

        public Criteria andNeedInstallIsNull() {
            addCriterion("NEED_INSTALL is null");
            return (Criteria) this;
        }

        public Criteria andNeedInstallIsNotNull() {
            addCriterion("NEED_INSTALL is not null");
            return (Criteria) this;
        }

        public Criteria andNeedInstallEqualTo(String value) {
            addCriterion("NEED_INSTALL =", value, "needInstall");
            return (Criteria) this;
        }

        public Criteria andNeedInstallNotEqualTo(String value) {
            addCriterion("NEED_INSTALL <>", value, "needInstall");
            return (Criteria) this;
        }

        public Criteria andNeedInstallGreaterThan(String value) {
            addCriterion("NEED_INSTALL >", value, "needInstall");
            return (Criteria) this;
        }

        public Criteria andNeedInstallGreaterThanOrEqualTo(String value) {
            addCriterion("NEED_INSTALL >=", value, "needInstall");
            return (Criteria) this;
        }

        public Criteria andNeedInstallLessThan(String value) {
            addCriterion("NEED_INSTALL <", value, "needInstall");
            return (Criteria) this;
        }

        public Criteria andNeedInstallLessThanOrEqualTo(String value) {
            addCriterion("NEED_INSTALL <=", value, "needInstall");
            return (Criteria) this;
        }

        public Criteria andNeedInstallLike(String value) {
            addCriterion("NEED_INSTALL like", value, "needInstall");
            return (Criteria) this;
        }

        public Criteria andNeedInstallNotLike(String value) {
            addCriterion("NEED_INSTALL not like", value, "needInstall");
            return (Criteria) this;
        }

        public Criteria andNeedInstallIn(List<String> values) {
            addCriterion("NEED_INSTALL in", values, "needInstall");
            return (Criteria) this;
        }

        public Criteria andNeedInstallNotIn(List<String> values) {
            addCriterion("NEED_INSTALL not in", values, "needInstall");
            return (Criteria) this;
        }

        public Criteria andNeedInstallBetween(String value1, String value2) {
            addCriterion("NEED_INSTALL between", value1, value2, "needInstall");
            return (Criteria) this;
        }

        public Criteria andNeedInstallNotBetween(String value1, String value2) {
            addCriterion("NEED_INSTALL not between", value1, value2, "needInstall");
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

        public Criteria andMemoIsNull() {
            addCriterion("MEMO is null");
            return (Criteria) this;
        }

        public Criteria andMemoIsNotNull() {
            addCriterion("MEMO is not null");
            return (Criteria) this;
        }

        public Criteria andMemoEqualTo(String value) {
            addCriterion("MEMO =", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoNotEqualTo(String value) {
            addCriterion("MEMO <>", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoGreaterThan(String value) {
            addCriterion("MEMO >", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoGreaterThanOrEqualTo(String value) {
            addCriterion("MEMO >=", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoLessThan(String value) {
            addCriterion("MEMO <", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoLessThanOrEqualTo(String value) {
            addCriterion("MEMO <=", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoLike(String value) {
            addCriterion("MEMO like", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoNotLike(String value) {
            addCriterion("MEMO not like", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoIn(List<String> values) {
            addCriterion("MEMO in", values, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoNotIn(List<String> values) {
            addCriterion("MEMO not in", values, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoBetween(String value1, String value2) {
            addCriterion("MEMO between", value1, value2, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoNotBetween(String value1, String value2) {
            addCriterion("MEMO not between", value1, value2, "memo");
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

        public Criteria andInvoiceInfoIsNull() {
            addCriterion("INVOICE_INFO is null");
            return (Criteria) this;
        }

        public Criteria andInvoiceInfoIsNotNull() {
            addCriterion("INVOICE_INFO is not null");
            return (Criteria) this;
        }

        public Criteria andInvoiceInfoEqualTo(String value) {
            addCriterion("INVOICE_INFO =", value, "invoiceInfo");
            return (Criteria) this;
        }

        public Criteria andInvoiceInfoNotEqualTo(String value) {
            addCriterion("INVOICE_INFO <>", value, "invoiceInfo");
            return (Criteria) this;
        }

        public Criteria andInvoiceInfoGreaterThan(String value) {
            addCriterion("INVOICE_INFO >", value, "invoiceInfo");
            return (Criteria) this;
        }

        public Criteria andInvoiceInfoGreaterThanOrEqualTo(String value) {
            addCriterion("INVOICE_INFO >=", value, "invoiceInfo");
            return (Criteria) this;
        }

        public Criteria andInvoiceInfoLessThan(String value) {
            addCriterion("INVOICE_INFO <", value, "invoiceInfo");
            return (Criteria) this;
        }

        public Criteria andInvoiceInfoLessThanOrEqualTo(String value) {
            addCriterion("INVOICE_INFO <=", value, "invoiceInfo");
            return (Criteria) this;
        }

        public Criteria andInvoiceInfoLike(String value) {
            addCriterion("INVOICE_INFO like", value, "invoiceInfo");
            return (Criteria) this;
        }

        public Criteria andInvoiceInfoNotLike(String value) {
            addCriterion("INVOICE_INFO not like", value, "invoiceInfo");
            return (Criteria) this;
        }

        public Criteria andInvoiceInfoIn(List<String> values) {
            addCriterion("INVOICE_INFO in", values, "invoiceInfo");
            return (Criteria) this;
        }

        public Criteria andInvoiceInfoNotIn(List<String> values) {
            addCriterion("INVOICE_INFO not in", values, "invoiceInfo");
            return (Criteria) this;
        }

        public Criteria andInvoiceInfoBetween(String value1, String value2) {
            addCriterion("INVOICE_INFO between", value1, value2, "invoiceInfo");
            return (Criteria) this;
        }

        public Criteria andInvoiceInfoNotBetween(String value1, String value2) {
            addCriterion("INVOICE_INFO not between", value1, value2, "invoiceInfo");
            return (Criteria) this;
        }

        public Criteria andWorkOrderIdIsNull() {
            addCriterion("WORK_ORDER_ID is null");
            return (Criteria) this;
        }

        public Criteria andWorkOrderIdIsNotNull() {
            addCriterion("WORK_ORDER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andWorkOrderIdEqualTo(String value) {
            addCriterion("WORK_ORDER_ID =", value, "workOrderId");
            return (Criteria) this;
        }

        public Criteria andWorkOrderIdNotEqualTo(String value) {
            addCriterion("WORK_ORDER_ID <>", value, "workOrderId");
            return (Criteria) this;
        }

        public Criteria andWorkOrderIdGreaterThan(String value) {
            addCriterion("WORK_ORDER_ID >", value, "workOrderId");
            return (Criteria) this;
        }

        public Criteria andWorkOrderIdGreaterThanOrEqualTo(String value) {
            addCriterion("WORK_ORDER_ID >=", value, "workOrderId");
            return (Criteria) this;
        }

        public Criteria andWorkOrderIdLessThan(String value) {
            addCriterion("WORK_ORDER_ID <", value, "workOrderId");
            return (Criteria) this;
        }

        public Criteria andWorkOrderIdLessThanOrEqualTo(String value) {
            addCriterion("WORK_ORDER_ID <=", value, "workOrderId");
            return (Criteria) this;
        }

        public Criteria andWorkOrderIdLike(String value) {
            addCriterion("WORK_ORDER_ID like", value, "workOrderId");
            return (Criteria) this;
        }

        public Criteria andWorkOrderIdNotLike(String value) {
            addCriterion("WORK_ORDER_ID not like", value, "workOrderId");
            return (Criteria) this;
        }

        public Criteria andWorkOrderIdIn(List<String> values) {
            addCriterion("WORK_ORDER_ID in", values, "workOrderId");
            return (Criteria) this;
        }

        public Criteria andWorkOrderIdNotIn(List<String> values) {
            addCriterion("WORK_ORDER_ID not in", values, "workOrderId");
            return (Criteria) this;
        }

        public Criteria andWorkOrderIdBetween(String value1, String value2) {
            addCriterion("WORK_ORDER_ID between", value1, value2, "workOrderId");
            return (Criteria) this;
        }

        public Criteria andWorkOrderIdNotBetween(String value1, String value2) {
            addCriterion("WORK_ORDER_ID not between", value1, value2, "workOrderId");
            return (Criteria) this;
        }

        public Criteria andPushTimeIsNull() {
            addCriterion("PUSH_TIME is null");
            return (Criteria) this;
        }

        public Criteria andPushTimeIsNotNull() {
            addCriterion("PUSH_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andPushTimeEqualTo(Date value) {
            addCriterionForJDBCDate("PUSH_TIME =", value, "pushTime");
            return (Criteria) this;
        }

        public Criteria andPushTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("PUSH_TIME <>", value, "pushTime");
            return (Criteria) this;
        }

        public Criteria andPushTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("PUSH_TIME >", value, "pushTime");
            return (Criteria) this;
        }

        public Criteria andPushTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("PUSH_TIME >=", value, "pushTime");
            return (Criteria) this;
        }

        public Criteria andPushTimeLessThan(Date value) {
            addCriterionForJDBCDate("PUSH_TIME <", value, "pushTime");
            return (Criteria) this;
        }

        public Criteria andPushTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("PUSH_TIME <=", value, "pushTime");
            return (Criteria) this;
        }

        public Criteria andPushTimeIn(List<Date> values) {
            addCriterionForJDBCDate("PUSH_TIME in", values, "pushTime");
            return (Criteria) this;
        }

        public Criteria andPushTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("PUSH_TIME not in", values, "pushTime");
            return (Criteria) this;
        }

        public Criteria andPushTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("PUSH_TIME between", value1, value2, "pushTime");
            return (Criteria) this;
        }

        public Criteria andPushTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("PUSH_TIME not between", value1, value2, "pushTime");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagIsNull() {
            addCriterion("DELETE_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagIsNotNull() {
            addCriterion("DELETE_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagEqualTo(BigDecimal value) {
            addCriterion("DELETE_FLAG =", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagNotEqualTo(BigDecimal value) {
            addCriterion("DELETE_FLAG <>", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagGreaterThan(BigDecimal value) {
            addCriterion("DELETE_FLAG >", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("DELETE_FLAG >=", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagLessThan(BigDecimal value) {
            addCriterion("DELETE_FLAG <", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagLessThanOrEqualTo(BigDecimal value) {
            addCriterion("DELETE_FLAG <=", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagIn(List<BigDecimal> values) {
            addCriterion("DELETE_FLAG in", values, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagNotIn(List<BigDecimal> values) {
            addCriterion("DELETE_FLAG not in", values, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DELETE_FLAG between", value1, value2, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DELETE_FLAG not between", value1, value2, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andWorkOrderTimeIsNull() {
            addCriterion("WORK_ORDER_TIME is null");
            return (Criteria) this;
        }

        public Criteria andWorkOrderTimeIsNotNull() {
            addCriterion("WORK_ORDER_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andWorkOrderTimeEqualTo(Date value) {
            addCriterionForJDBCDate("WORK_ORDER_TIME =", value, "workOrderTime");
            return (Criteria) this;
        }

        public Criteria andWorkOrderTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("WORK_ORDER_TIME <>", value, "workOrderTime");
            return (Criteria) this;
        }

        public Criteria andWorkOrderTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("WORK_ORDER_TIME >", value, "workOrderTime");
            return (Criteria) this;
        }

        public Criteria andWorkOrderTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("WORK_ORDER_TIME >=", value, "workOrderTime");
            return (Criteria) this;
        }

        public Criteria andWorkOrderTimeLessThan(Date value) {
            addCriterionForJDBCDate("WORK_ORDER_TIME <", value, "workOrderTime");
            return (Criteria) this;
        }

        public Criteria andWorkOrderTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("WORK_ORDER_TIME <=", value, "workOrderTime");
            return (Criteria) this;
        }

        public Criteria andWorkOrderTimeIn(List<Date> values) {
            addCriterionForJDBCDate("WORK_ORDER_TIME in", values, "workOrderTime");
            return (Criteria) this;
        }

        public Criteria andWorkOrderTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("WORK_ORDER_TIME not in", values, "workOrderTime");
            return (Criteria) this;
        }

        public Criteria andWorkOrderTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("WORK_ORDER_TIME between", value1, value2, "workOrderTime");
            return (Criteria) this;
        }

        public Criteria andWorkOrderTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("WORK_ORDER_TIME not between", value1, value2, "workOrderTime");
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