package com.goldze.mvvmhabit.data;

import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;

import com.goldze.mvvmhabit.data.source.HttpDataSource;
import com.goldze.mvvmhabit.data.source.LocalDataSource;
import com.goldze.mvvmhabit.entity.DemoEntity;

import io.reactivex.Observable;
import me.goldze.mvvmhabit.base.BaseModel;
import me.goldze.mvvmhabit.http.BaseResponse;

/**
 * MVVM的Model层，统一模块的数据仓库，包含网络数据和本地数据（一个应用可以有多个Repositor）
 * Created by goldze on 2019/3/26.
 */
public class DemoRepository extends BaseModel implements HttpDataSource, LocalDataSource {
    private volatile static DemoRepository INSTANCE = null;
    private final HttpDataSource mHttpDataSource;

    private final LocalDataSource mLocalDataSource;

    private DemoRepository(@NonNull HttpDataSource httpDataSource,
                           @NonNull LocalDataSource localDataSource) {
        this.mHttpDataSource = httpDataSource;
        this.mLocalDataSource = localDataSource;
    }

    public static DemoRepository getInstance(HttpDataSource httpDataSource,
                                             LocalDataSource localDataSource) {
        if (INSTANCE == null) {
            synchronized (DemoRepository.class) {
                if (INSTANCE == null) {
                    INSTANCE = new DemoRepository(httpDataSource, localDataSource);
                }
            }
        }
        return INSTANCE;
    }

    @VisibleForTesting
    public static void destroyInstance() {
        INSTANCE = null;
    }


    @Override
    public Observable<Object> login() {
        return mHttpDataSource.login();
    }

    @Override
    public Observable<DemoEntity> loadMore() {
        return mHttpDataSource.loadMore();
    }

    @Override
    public Observable<BaseResponse<DemoEntity>> demoGet() {
        return mHttpDataSource.demoGet();
    }

    @Override
    public Observable<BaseResponse<DemoEntity>> demoPost(String catalog) {
        return mHttpDataSource.demoPost(catalog);
    }

    @Override
    public void saveUserName(String userName) {
        mLocalDataSource.saveUserName(userName);
    }

    @Override
    public void saveWxId(String wxId) {
        mLocalDataSource.saveWxId(wxId);
    }

    @Override
    public void saveHead(String head) {
        mLocalDataSource.saveHead(head);
    }

    @Override
    public void saveBalance(String balance) {
        mLocalDataSource.saveBalance(balance);
    }

    @Override
    public String getUserName() {
        return mLocalDataSource.getUserName();
    }

    @Override
    public String getWxId() {
        return mLocalDataSource.getWxId();
    }

    @Override
    public String getHead() {
        return mLocalDataSource.getHead();
    }

    @Override
    public String getBalance() {
        return mLocalDataSource.getBalance();
    }

}
