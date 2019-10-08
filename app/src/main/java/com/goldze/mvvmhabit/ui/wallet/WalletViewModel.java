package com.goldze.mvvmhabit.ui.wallet;

import android.app.Application;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableField;
import android.databinding.ObservableList;
import android.support.annotation.NonNull;
import android.view.View;

import com.goldze.mvvmhabit.R;
import com.goldze.mvvmhabit.data.DemoRepository;
import com.goldze.mvvmhabit.entity.PayItem;
import com.goldze.mvvmhabit.ui.balance.BalanceFragment;
import com.goldze.mvvmhabit.ui.base.viewmodel.ToolbarViewModel;
import com.goldze.mvvmhabit.ui.pay.PayItemViewModel;

import java.util.ArrayList;
import java.util.List;

import me.goldze.mvvmhabit.binding.command.BindingAction;
import me.goldze.mvvmhabit.binding.command.BindingCommand;
import me.tatarka.bindingcollectionadapter2.ItemBinding;

public class WalletViewModel extends ToolbarViewModel<DemoRepository> {

    public ObservableField<String> balance = new ObservableField<>("");

    public WalletViewModel(@NonNull Application application, DemoRepository repository) {
        super(application, repository);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        balance.set("¥" + model.getBalance());
    }

    /**
     * 初始化Toolbar
     */
    public void initToolbar() {
        //初始化标题栏
        setRightTextVisible(View.VISIBLE);
        setRightText("账单");
        setRightIconVisible(View.GONE);
        setTitleText("钱包");
    }

    public BindingCommand balanceClickCommand = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            startContainerActivity(BalanceFragment.class.getCanonicalName());
        }
    });

    public BindingCommand cardClickCommand = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
        }
    });

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
