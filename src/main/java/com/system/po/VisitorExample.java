package com.system.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VisitorExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public VisitorExample() {
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

        public Criteria andVnameIsNull() {
            addCriterion("Vname is null");
            return (Criteria) this;
        }

        public Criteria andVnameIsNotNull() {
            addCriterion("Vname is not null");
            return (Criteria) this;
        }

        public Criteria andVnameEqualTo(String value) {
            addCriterion("Vname =", value, "vname");
            return (Criteria) this;
        }

        public Criteria andVnameNotEqualTo(String value) {
            addCriterion("Vname <>", value, "vname");
            return (Criteria) this;
        }

        public Criteria andVnameGreaterThan(String value) {
            addCriterion("Vname >", value, "vname");
            return (Criteria) this;
        }

        public Criteria andVnameGreaterThanOrEqualTo(String value) {
            addCriterion("Vname >=", value, "vname");
            return (Criteria) this;
        }

        public Criteria andVnameLessThan(String value) {
            addCriterion("Vname <", value, "vname");
            return (Criteria) this;
        }

        public Criteria andVnameLessThanOrEqualTo(String value) {
            addCriterion("Vname <=", value, "vname");
            return (Criteria) this;
        }

        public Criteria andVnameLike(String value) {
            addCriterion("Vname like", value, "vname");
            return (Criteria) this;
        }

        public Criteria andVnameNotLike(String value) {
            addCriterion("Vname not like", value, "vname");
            return (Criteria) this;
        }

        public Criteria andVnameIn(List<String> values) {
            addCriterion("Vname in", values, "vname");
            return (Criteria) this;
        }

        public Criteria andVnameNotIn(List<String> values) {
            addCriterion("Vname not in", values, "vname");
            return (Criteria) this;
        }

        public Criteria andVnameBetween(String value1, String value2) {
            addCriterion("Vname between", value1, value2, "vname");
            return (Criteria) this;
        }

        public Criteria andVnameNotBetween(String value1, String value2) {
            addCriterion("Vname not between", value1, value2, "vname");
            return (Criteria) this;
        }

        public Criteria andVtimeIsNull() {
            addCriterion("Vtime is null");
            return (Criteria) this;
        }

        public Criteria andVtimeIsNotNull() {
            addCriterion("Vtime is not null");
            return (Criteria) this;
        }

        public Criteria andVtimeEqualTo(Date value) {
            addCriterion("Vtime =", value, "vtime");
            return (Criteria) this;
        }

        public Criteria andVtimeNotEqualTo(Date value) {
            addCriterion("Vtime <>", value, "vtime");
            return (Criteria) this;
        }

        public Criteria andVtimeGreaterThan(Date value) {
            addCriterion("Vtime >", value, "vtime");
            return (Criteria) this;
        }

        public Criteria andVtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("Vtime >=", value, "vtime");
            return (Criteria) this;
        }

        public Criteria andVtimeLessThan(Date value) {
            addCriterion("Vtime <", value, "vtime");
            return (Criteria) this;
        }

        public Criteria andVtimeLessThanOrEqualTo(Date value) {
            addCriterion("Vtime <=", value, "vtime");
            return (Criteria) this;
        }

        public Criteria andVtimeIn(List<Date> values) {
            addCriterion("Vtime in", values, "vtime");
            return (Criteria) this;
        }

        public Criteria andVtimeNotIn(List<Date> values) {
            addCriterion("Vtime not in", values, "vtime");
            return (Criteria) this;
        }

        public Criteria andVtimeBetween(Date value1, Date value2) {
            addCriterion("Vtime between", value1, value2, "vtime");
            return (Criteria) this;
        }

        public Criteria andVtimeNotBetween(Date value1, Date value2) {
            addCriterion("Vtime not between", value1, value2, "vtime");
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