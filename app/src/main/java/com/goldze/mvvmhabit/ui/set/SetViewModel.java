package com.goldze.mvvmhabit.ui.set;

import android.app.Application;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;

import com.goldze.mvvmhabit.data.DemoRepository;
import com.goldze.mvvmhabit.entity.Loan;
import com.goldze.mvvmhabit.ui.bank.BankActivity;

import me.goldze.mvvmhabit.base.BaseViewModel;
import me.goldze.mvvmhabit.binding.command.BindingAction;
import me.goldze.mvvmhabit.binding.command.BindingCommand;
import me.goldze.mvvmhabit.binding.command.BindingConsumer;
import me.goldze.mvvmhabit.utils.ToastUtils;

/**
 * Created by goldze on 2017/7/17.
 */

public class SetViewModel extends BaseViewModel<DemoRepository> {

    public ObservableField<String> balance = new ObservableField<>("");

    public ObservableField<Loan> entity = new ObservableField<>();

    public SetViewModel(@NonNull Application application, DemoRepository repository) {
        super(application, repository);
        balance.set(model.getBalance());
        entity.set(model.getLoan());
    }


    public BindingCommand clickCommand = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            model.saveBalance(balance.get());
            model.saveLoan(entity.get());
            ToastUtils.showShort("保存成功");
        }
    });

    public BindingCommand cardClickCommand = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            startActivity(BankActivity.class);
        }
    });

    public BindingCommand<String> rgClickCommand = new BindingCommand<>(new BindingConsumer<String>() {
        @Override
        public void call(String string) {
            entity.get().setRateDay(Double.valueOf(string));
        }
    });

}
