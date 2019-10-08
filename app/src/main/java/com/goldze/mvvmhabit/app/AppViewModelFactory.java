package com.goldze.mvvmhabit.app;

import android.annotation.SuppressLint;
import android.app.Application;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;

import com.goldze.mvvmhabit.data.DemoRepository;
import com.goldze.mvvmhabit.ui.balance.BalanceViewModel;
import com.goldze.mvvmhabit.ui.bank.BankViewModel;
import com.goldze.mvvmhabit.ui.info.InfoViewModel;
import com.goldze.mvvmhabit.ui.input.InputViewModel;
import com.goldze.mvvmhabit.ui.mine.MineViewModel;
import com.goldze.mvvmhabit.ui.network.NetWorkViewModel;
import com.goldze.mvvmhabit.ui.pay.PayViewModel;
import com.goldze.mvvmhabit.ui.wallet.WalletViewModel;

/**
 * Created by goldze on 2019/3/26.
 */
public class AppViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    @SuppressLint("StaticFieldLeak")
    private static volatile AppViewModelFactory INSTANCE;
    private final Application mApplication;
    private final DemoRepository mRepository;

    public static AppViewModelFactory getInstance(Application application) {
        if (INSTANCE == null) {
            synchronized (AppViewModelFactory.class) {
                if (INSTANCE == null) {
                    INSTANCE = new AppViewModelFactory(application, Injection.provideDemoRepository());
                }
            }
        }
        return INSTANCE;
    }

    @VisibleForTesting
    public static void destroyInstance() {
        INSTANCE = null;
    }

    private AppViewModelFactory(Application application, DemoRepository repository) {
        this.mApplication = application;
        this.mRepository = repository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(NetWorkViewModel.class)) {
            return (T) new NetWorkViewModel(mApplication, mRepository);
        } else if (modelClass.isAssignableFrom(MineViewModel.class)) {
            return (T) new MineViewModel(mApplication, mRepository);
        } else if (modelClass.isAssignableFrom(InfoViewModel.class)) {
            return (T) new InfoViewModel(mApplication, mRepository);
        } else if (modelClass.isAssignableFrom(InputViewModel.class)) {
            return (T) new InputViewModel(mApplication, mRepository);
        } else if (modelClass.isAssignableFrom(PayViewModel.class)) {
            return (T) new PayViewModel(mApplication, mRepository);
        } else if (modelClass.isAssignableFrom(WalletViewModel.class)) {
            return (T) new WalletViewModel(mApplication, mRepository);
        } else if (modelClass.isAssignableFrom(BalanceViewModel.class)) {
            return (T) new BalanceViewModel(mApplication, mRepository);
        } else if (modelClass.isAssignableFrom(BankViewModel.class)) {
            return (T) new BankViewModel(mApplication, mRepository);
        }
        throw new IllegalArgumentException("Unknown ViewModel class: " + modelClass.getName());
    }
}
