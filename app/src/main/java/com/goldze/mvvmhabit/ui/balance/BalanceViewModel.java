package com.goldze.mvvmhabit.ui.balance;

import android.app.Application;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;
import android.view.View;

import com.goldze.mvvmhabit.data.DemoRepository;
import com.goldze.mvvmhabit.ui.base.viewmodel.ToolbarViewModel;

import me.goldze.mvvmhabit.binding.command.BindingAction;
import me.goldze.mvvmhabit.binding.command.BindingCommand;

public class BalanceViewModel extends ToolbarViewModel<DemoRepository> {

    public ObservableField<String> balance = new ObservableField<>("");

    public BalanceViewModel(@NonNull Application application, DemoRepository repository) {
        super(application, repository);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        balance.set(model.getBalance());
    }

    /**
     * 初始化Toolbar
     */
    public void initToolbar() {
        //初始化标题栏
        setRightTextVisible(View.GONE);
        setRightIconVisible(View.VISIBLE);
        setTitleText("");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
