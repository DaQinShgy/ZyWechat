package com.goldze.mvvmhabit.ui.wallet;

import android.app.Application;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.support.annotation.NonNull;
import android.view.View;

import com.goldze.mvvmhabit.data.DemoRepository;
import com.goldze.mvvmhabit.entity.Loan;
import com.goldze.mvvmhabit.ui.balance.BalanceFragment;
import com.goldze.mvvmhabit.ui.bank.BankActivity;
import com.goldze.mvvmhabit.ui.base.viewmodel.ToolbarViewModel;

import me.goldze.mvvmhabit.binding.command.BindingAction;
import me.goldze.mvvmhabit.binding.command.BindingCommand;

public class WalletViewModel extends ToolbarViewModel<DemoRepository> {

    public ObservableField<String> balance = new ObservableField<>("");

    public ObservableField<Loan> entity = new ObservableField<>();

    public ObservableInt showChange = new ObservableInt(View.GONE);

    public ObservableField<String> changeRate = new ObservableField<>("");
    public ObservableInt showRate = new ObservableInt(View.GONE);

    public ObservableField<String> changeQuota = new ObservableField<>("");
    public ObservableInt showQuota = new ObservableInt(View.GONE);

    public WalletViewModel(@NonNull Application application, DemoRepository repository) {
        super(application, repository);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        balance.set("¥" + model.getBalance());
        entity.set(model.getLoan());
        showChange.set(entity.get().isShowChange() ? View.VISIBLE : View.GONE);
        changeRate.set(String.format("收益率%s", entity.get().getChangeRate()) + "%");
        if (!"0".equals(entity.get().getChangeRate()))
            showRate.set(View.VISIBLE);
        changeQuota.set("¥" + entity.get().getChangeQuota());
        if (!"0".equals(entity.get().getChangeQuota()))
            showQuota.set(View.VISIBLE);
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
            startActivity(BankActivity.class);
        }
    });

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
