package com.goldze.mvvmhabit.data.source;

/**
 * Created by goldze on 2019/3/26.
 */
public interface LocalDataSource {

    void saveUserName(String userName);

    void saveWxId(String wxId);

    void saveHead(String head);

    void saveBalance(String balance);

    String getUserName();

    String getWxId();

    String getHead();

    String getBalance();
}
