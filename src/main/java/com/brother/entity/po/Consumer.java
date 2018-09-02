package com.brother.entity.po;

import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.Date;

public class Consumer implements Serializable {

    private Integer user_id;
    private String email;
    private String user_name;
    private String password;
    private String question;
    private String answer;
    private Integer sex;
    private Date birthday;
    private Double user_money;
    private Double frozen_money;
    private Integer pay_points;
    private Integer rank_points;
    private Integer address_id;
    private Date reg_time;
    private Date last_login;
    private Date last_time;
    private String last_ip;
    private Integer visit_count;
    private Integer user_rank;
    private Integer is_special;
    private String salt;
    private Integer parent_id;
    private Integer flag;
    private String alias;
    private String msn;
    private String qq;
    private String office_phone;
    private String home_phone;
    private String mobile_phone;
    private Integer is_validated;
    private Double creadit_line;

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Double getUser_money() {
        return user_money;
    }

    public void setUser_money(Double user_money) {
        this.user_money = user_money;
    }

    public Double getFrozen_money() {
        return frozen_money;
    }

    public void setFrozen_money(Double frozen_money) {
        this.frozen_money = frozen_money;
    }

    public Integer getPay_points() {
        return pay_points;
    }

    public void setPay_points(Integer pay_points) {
        this.pay_points = pay_points;
    }

    public Integer getRank_points() {
        return rank_points;
    }

    public void setRank_points(Integer rank_points) {
        this.rank_points = rank_points;
    }

    public Integer getAddress_id() {
        return address_id;
    }

    public void setAddress_id(Integer address_id) {
        this.address_id = address_id;
    }

    public Date getReg_time() {
        return reg_time;
    }

    public void setReg_time(Date reg_time) {
        this.reg_time = reg_time;
    }

    public Date getLast_login() {
        return last_login;
    }

    public void setLast_login(Date last_login) {
        this.last_login = last_login;
    }

    public Date getLast_time() {
        return last_time;
    }

    public void setLast_time(Date last_time) {
        this.last_time = last_time;
    }

    public String getLast_ip() {
        return last_ip;
    }

    public void setLast_ip(String last_ip) {
        this.last_ip = last_ip;
    }

    public Integer getVisit_count() {
        return visit_count;
    }

    public void setVisit_count(Integer visit_count) {
        this.visit_count = visit_count;
    }

    public Integer getUser_rank() {
        return user_rank;
    }

    public void setUser_rank(Integer user_rank) {
        this.user_rank = user_rank;
    }

    public Integer getIs_special() {
        return is_special;
    }

    public void setIs_special(Integer is_special) {
        this.is_special = is_special;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Integer getParent_id() {
        return parent_id;
    }

    public void setParent_id(Integer parent_id) {
        this.parent_id = parent_id;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getMsn() {
        return msn;
    }

    public void setMsn(String msn) {
        this.msn = msn;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getOffice_phone() {
        return office_phone;
    }

    public void setOffice_phone(String office_phone) {
        this.office_phone = office_phone;
    }

    public String getHome_phone() {
        return home_phone;
    }

    public void setHome_phone(String home_phone) {
        this.home_phone = home_phone;
    }

    public String getMobile_phone() {
        return mobile_phone;
    }

    public void setMobile_phone(String mobile_phone) {
        this.mobile_phone = mobile_phone;
    }

    public Integer getIs_validated() {
        return is_validated;
    }

    public void setIs_validated(Integer is_validated) {
        this.is_validated = is_validated;
    }

    public Double getCreadit_line() {
        return creadit_line;
    }

    public void setCreadit_line(Double creadit_line) {
        this.creadit_line = creadit_line;
    }

    @Override
    public String toString() {
        return "Consumer{" +
                "user_id=" + user_id +
                ", email='" + email + '\'' +
                ", user_name='" + user_name + '\'' +
                ", password='" + password + '\'' +
                ", question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                ", sex=" + sex +
                ", birthday=" + birthday +
                ", user_money=" + user_money +
                ", frozen_money=" + frozen_money +
                ", pay_points=" + pay_points +
                ", rank_points=" + rank_points +
                ", address_id=" + address_id +
                ", reg_time=" + reg_time +
                ", last_login=" + last_login +
                ", last_time=" + last_time +
                ", last_ip='" + last_ip + '\'' +
                ", visit_count=" + visit_count +
                ", user_rank=" + user_rank +
                ", is_special=" + is_special +
                ", salt='" + salt + '\'' +
                ", parent_id=" + parent_id +
                ", flag=" + flag +
                ", alias='" + alias + '\'' +
                ", msn='" + msn + '\'' +
                ", qq='" + qq + '\'' +
                ", office_phone='" + office_phone + '\'' +
                ", home_phone='" + home_phone + '\'' +
                ", mobile_phone='" + mobile_phone + '\'' +
                ", is_validated=" + is_validated +
                ", creadit_line=" + creadit_line +
                '}';
    }
}
