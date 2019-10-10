package com.goldze.mvvmhabit.entity;

import org.litepal.crud.LitePalSupport;

public class Loan extends LitePalSupport {

    //微粒贷可借额度
    private String quota;

    private String quotaTotal;

    //日利率
    private double rateDay;

    private String peopleName;

    private String peopleCardNo;

    private String dateStart;

    //默认还款账户
    private String repayNo;

    //借款用途
    private String objective;

    public String getQuota() {
        return quota;
    }

    public void setQuota(String quota) {
        this.quota = quota;
    }

    public double getRateDay() {
        return rateDay;
    }

    public void setRateDay(double rateDay) {
        this.rateDay = rateDay;
    }

    public String getPeopleName() {
        return peopleName;
    }

    public void setPeopleName(String peopleName) {
        this.peopleName = peopleName;
    }

    public String getPeopleCardNo() {
        return peopleCardNo;
    }

    public void setPeopleCardNo(String peopleCardNo) {
        this.peopleCardNo = peopleCardNo;
    }

    public String getDateStart() {
        return dateStart;
    }

    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    public String getRepayNo() {
        return repayNo;
    }

    public void setRepayNo(String repayNo) {
        this.repayNo = repayNo;
    }

    public String getObjective() {
        return objective;
    }

    public void setObjective(String objective) {
        this.objective = objective;
    }

    public String getQuotaTotal() {
        return quotaTotal;
    }

    public void setQuotaTotal(String quotaTotal) {
        this.quotaTotal = quotaTotal;
    }
}
