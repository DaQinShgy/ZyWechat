package com.goldze.mvvmhabit.data.source;

import com.goldze.mvvmhabit.entity.BankCard;
import com.goldze.mvvmhabit.entity.Loan;

import java.util.List;

/**
 * Created by goldze on 2019/3/26.
 */
public interface LocalDataSource {

    void saveUserName(String userName);

    void saveWxId(String wxId);

    void saveHead(String head);

    void saveBalance(String balance);

    void saveBankCard(BankCard bankCard);

    void saveDai(boolean dai);

    void saveLoan(Loan loan);

    String getUserName();

    String getWxId();

    String getHead();

    String getBalance();

    List<BankCard> getAllBankCard();

    boolean getDai();

    Loan getLoan();
}
