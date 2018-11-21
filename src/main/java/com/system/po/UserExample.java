package com.system.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserExample() {
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

        public Criteria andUsernameIsNull() {
            addCriterion("UserName is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("UserName is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("UserName =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("UserName <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("UserName >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("UserName >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("UserName <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("UserName <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("UserName like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("UserName not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("UserName in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("UserName not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("UserName between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("UserName not between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("PassWord is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("PassWord is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("PassWord =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("PassWord <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("PassWord >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("PassWord >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("PassWord <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("PassWord <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("PassWord like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("PassWord not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("PassWord in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("PassWord not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("PassWord between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("PassWord not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andOpennumIsNull() {
            addCriterion("OpenNum is null");
            return (Criteria) this;
        }

        public Criteria andOpennumIsNotNull() {
            addCriterion("OpenNum is not null");
            return (Criteria) this;
        }

        public Criteria andOpennumEqualTo(Integer value) {
            addCriterion("OpenNum =", value, "opennum");
            return (Criteria) this;
        }

        public Criteria andOpennumNotEqualTo(Integer value) {
            addCriterion("OpenNum <>", value, "opennum");
            return (Criteria) this;
        }

        public Criteria andOpennumGreaterThan(Integer value) {
            addCriterion("OpenNum >", value, "opennum");
            return (Criteria) this;
        }

        public Criteria andOpennumGreaterThanOrEqualTo(Integer value) {
            addCriterion("OpenNum >=", value, "opennum");
            return (Criteria) this;
        }

        public Criteria andOpennumLessThan(Integer value) {
            addCriterion("OpenNum <", value, "opennum");
            return (Criteria) this;
        }

        public Criteria andOpennumLessThanOrEqualTo(Integer value) {
            addCriterion("OpenNum <=", value, "opennum");
            return (Criteria) this;
        }

        public Criteria andOpennumIn(List<Integer> values) {
            addCriterion("OpenNum in", values, "opennum");
            return (Criteria) this;
        }

        public Criteria andOpennumNotIn(List<Integer> values) {
            addCriterion("OpenNum not in", values, "opennum");
            return (Criteria) this;
        }

        public Criteria andOpennumBetween(Integer value1, Integer value2) {
            addCriterion("OpenNum between", value1, value2, "opennum");
            return (Criteria) this;
        }

        public Criteria andOpennumNotBetween(Integer value1, Integer value2) {
            addCriterion("OpenNum not between", value1, value2, "opennum");
            return (Criteria) this;
        }

        public Criteria andLastopentimeIsNull() {
            addCriterion("LastOpenTime is null");
            return (Criteria) this;
        }

        public Criteria andLastopentimeIsNotNull() {
            addCriterion("LastOpenTime is not null");
            return (Criteria) this;
        }

        public Criteria andLastopentimeEqualTo(Date value) {
            addCriterion("LastOpenTime =", value, "lastopentime");
            return (Criteria) this;
        }

        public Criteria andLastopentimeNotEqualTo(Date value) {
            addCriterion("LastOpenTime <>", value, "lastopentime");
            return (Criteria) this;
        }

        public Criteria andLastopentimeGreaterThan(Date value) {
            addCriterion("LastOpenTime >", value, "lastopentime");
            return (Criteria) this;
        }

        public Criteria andLastopentimeGreaterThanOrEqualTo(Date value) {
            addCriterion("LastOpenTime >=", value, "lastopentime");
            return (Criteria) this;
        }

        public Criteria andLastopentimeLessThan(Date value) {
            addCriterion("LastOpenTime <", value, "lastopentime");
            return (Criteria) this;
        }

        public Criteria andLastopentimeLessThanOrEqualTo(Date value) {
            addCriterion("LastOpenTime <=", value, "lastopentime");
            return (Criteria) this;
        }

        public Criteria andLastopentimeIn(List<Date> values) {
            addCriterion("LastOpenTime in", values, "lastopentime");
            return (Criteria) this;
        }

        public Criteria andLastopentimeNotIn(List<Date> values) {
            addCriterion("LastOpenTime not in", values, "lastopentime");
            return (Criteria) this;
        }

        public Criteria andLastopentimeBetween(Date value1, Date value2) {
            addCriterion("LastOpenTime between", value1, value2, "lastopentime");
            return (Criteria) this;
        }

        public Criteria andLastopentimeNotBetween(Date value1, Date value2) {
            addCriterion("LastOpenTime not between", value1, value2, "lastopentime");
            return (Criteria) this;
        }

        public Criteria andCsvpathIsNull() {
            addCriterion("CsvPath is null");
            return (Criteria) this;
        }

        public Criteria andCsvpathIsNotNull() {
            addCriterion("CsvPath is not null");
            return (Criteria) this;
        }

        public Criteria andCsvpathEqualTo(String value) {
            addCriterion("CsvPath =", value, "csvpath");
            return (Criteria) this;
        }

        public Criteria andCsvpathNotEqualTo(String value) {
            addCriterion("CsvPath <>", value, "csvpath");
            return (Criteria) this;
        }

        public Criteria andCsvpathGreaterThan(String value) {
            addCriterion("CsvPath >", value, "csvpath");
            return (Criteria) this;
        }

        public Criteria andCsvpathGreaterThanOrEqualTo(String value) {
            addCriterion("CsvPath >=", value, "csvpath");
            return (Criteria) this;
        }

        public Criteria andCsvpathLessThan(String value) {
            addCriterion("CsvPath <", value, "csvpath");
            return (Criteria) this;
        }

        public Criteria andCsvpathLessThanOrEqualTo(String value) {
            addCriterion("CsvPath <=", value, "csvpath");
            return (Criteria) this;
        }

        public Criteria andCsvpathLike(String value) {
            addCriterion("CsvPath like", value, "csvpath");
            return (Criteria) this;
        }

        public Criteria andCsvpathNotLike(String value) {
            addCriterion("CsvPath not like", value, "csvpath");
            return (Criteria) this;
        }

        public Criteria andCsvpathIn(List<String> values) {
            addCriterion("CsvPath in", values, "csvpath");
            return (Criteria) this;
        }

        public Criteria andCsvpathNotIn(List<String> values) {
            addCriterion("CsvPath not in", values, "csvpath");
            return (Criteria) this;
        }

        public Criteria andCsvpathBetween(String value1, String value2) {
            addCriterion("CsvPath between", value1, value2, "csvpath");
            return (Criteria) this;
        }

        public Criteria andCsvpathNotBetween(String value1, String value2) {
            addCriterion("CsvPath not between", value1, value2, "csvpath");
            return (Criteria) this;
        }

        public Criteria andImagepathIsNull() {
            addCriterion("ImagePath is null");
            return (Criteria) this;
        }

        public Criteria andImagepathIsNotNull() {
            addCriterion("ImagePath is not null");
            return (Criteria) this;
        }

        public Criteria andImagepathEqualTo(String value) {
            addCriterion("ImagePath =", value, "imagepath");
            return (Criteria) this;
        }

        public Criteria andImagepathNotEqualTo(String value) {
            addCriterion("ImagePath <>", value, "imagepath");
            return (Criteria) this;
        }

        public Criteria andImagepathGreaterThan(String value) {
            addCriterion("ImagePath >", value, "imagepath");
            return (Criteria) this;
        }

        public Criteria andImagepathGreaterThanOrEqualTo(String value) {
            addCriterion("ImagePath >=", value, "imagepath");
            return (Criteria) this;
        }

        public Criteria andImagepathLessThan(String value) {
            addCriterion("ImagePath <", value, "imagepath");
            return (Criteria) this;
        }

        public Criteria andImagepathLessThanOrEqualTo(String value) {
            addCriterion("ImagePath <=", value, "imagepath");
            return (Criteria) this;
        }

        public Criteria andImagepathLike(String value) {
            addCriterion("ImagePath like", value, "imagepath");
            return (Criteria) this;
        }

        public Criteria andImagepathNotLike(String value) {
            addCriterion("ImagePath not like", value, "imagepath");
            return (Criteria) this;
        }

        public Criteria andImagepathIn(List<String> values) {
            addCriterion("ImagePath in", values, "imagepath");
            return (Criteria) this;
        }

        public Criteria andImagepathNotIn(List<String> values) {
            addCriterion("ImagePath not in", values, "imagepath");
            return (Criteria) this;
        }

        public Criteria andImagepathBetween(String value1, String value2) {
            addCriterion("ImagePath between", value1, value2, "imagepath");
            return (Criteria) this;
        }

        public Criteria andImagepathNotBetween(String value1, String value2) {
            addCriterion("ImagePath not between", value1, value2, "imagepath");
            return (Criteria) this;
        }

        public Criteria andRolenameIsNull() {
            addCriterion("roleName is null");
            return (Criteria) this;
        }

        public Criteria andRolenameIsNotNull() {
            addCriterion("roleName is not null");
            return (Criteria) this;
        }

        public Criteria andRolenameEqualTo(String value) {
            addCriterion("roleName =", value, "rolename");
            return (Criteria) this;
        }

        public Criteria andRolenameNotEqualTo(String value) {
            addCriterion("roleName <>", value, "rolename");
            return (Criteria) this;
        }

        public Criteria andRolenameGreaterThan(String value) {
            addCriterion("roleName >", value, "rolename");
            return (Criteria) this;
        }

        public Criteria andRolenameGreaterThanOrEqualTo(String value) {
            addCriterion("roleName >=", value, "rolename");
            return (Criteria) this;
        }

        public Criteria andRolenameLessThan(String value) {
            addCriterion("roleName <", value, "rolename");
            return (Criteria) this;
        }

        public Criteria andRolenameLessThanOrEqualTo(String value) {
            addCriterion("roleName <=", value, "rolename");
            return (Criteria) this;
        }

        public Criteria andRolenameLike(String value) {
            addCriterion("roleName like", value, "rolename");
            return (Criteria) this;
        }

        public Criteria andRolenameNotLike(String value) {
            addCriterion("roleName not like", value, "rolename");
            return (Criteria) this;
        }

        public Criteria andRolenameIn(List<String> values) {
            addCriterion("roleName in", values, "rolename");
            return (Criteria) this;
        }

        public Criteria andRolenameNotIn(List<String> values) {
            addCriterion("roleName not in", values, "rolename");
            return (Criteria) this;
        }

        public Criteria andRolenameBetween(String value1, String value2) {
            addCriterion("roleName between", value1, value2, "rolename");
            return (Criteria) this;
        }

        public Criteria andRolenameNotBetween(String value1, String value2) {
            addCriterion("roleName not between", value1, value2, "rolename");
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