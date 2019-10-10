package com.goldze.mvvmhabit.data.source.local;

import com.goldze.mvvmhabit.data.source.LocalDataSource;
import com.goldze.mvvmhabit.data.source.http.service.DemoApiService;
import com.goldze.mvvmhabit.entity.BankCard;
import com.goldze.mvvmhabit.entity.Loan;

import org.litepal.LitePal;

import java.util.List;

import me.goldze.mvvmhabit.utils.SPUtils;

/**
 * 本地数据源，可配合Room框架使用
 * Created by goldze on 2019/3/26.
 */
public class LocalDataSourceImpl implements LocalDataSource {
    private volatile static LocalDataSourceImpl INSTANCE = null;

    public static LocalDataSourceImpl getInstance() {
        if (INSTANCE == null) {
            synchronized (LocalDataSourceImpl.class) {
                if (INSTANCE == null) {
                    INSTANCE = new LocalDataSourceImpl();
                }
            }
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }

    private LocalDataSourceImpl() {
        //数据库Helper构建
    }

    @Override
    public void saveUserName(String userName) {
        SPUtils.getInstance().put("UserName", userName);
    }

    @Override
    public void saveWxId(String wxId) {
        SPUtils.getInstance().put("WxId", wxId);
    }

    @Override
    public void saveHead(String head) {
        SPUtils.getInstance().put("Head", head);
    }

    @Override
    public void saveBalance(String balance) {
        SPUtils.getInstance().put("balance", balance);
    }

    @Override
    public void saveBankCard(BankCard bankCard) {
        bankCard.save();
    }

    @Override
    public void saveDai(boolean dai) {
        SPUtils.getInstance().put("dai", dai);
    }

    @Override
    public void saveLoan(Loan loan) {
        loan.save();
    }

    @Override
    public String getUserName() {
        return SPUtils.getInstance().getString("UserName");
    }

    @Override
    public String getWxId() {
        return SPUtils.getInstance().getString("WxId");
    }

    @Override
    public String getHead() {
        return SPUtils.getInstance().getString("Head");
    }

    @Override
    public String getBalance() {
        return SPUtils.getInstance().getString("balance", "0.00");
    }

    @Override
    public List<BankCard> getAllBankCard() {
        return LitePal.findAll(BankCard.class);
    }

    @Override
    public boolean getDai() {
        return SPUtils.getInstance().getBoolean("dai", false);
    }

    @Override
    public Loan getLoan() {
        return LitePal.findFirst(Loan.class);
    }
}
