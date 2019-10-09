package com.goldze.mvvmhabit.ui.set;

import android.app.Application;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;

import com.goldze.mvvmhabit.data.DemoRepository;
import com.goldze.mvvmhabit.entity.InfoEntity;
import com.goldze.mvvmhabit.ui.info.InfoFragment;
import com.goldze.mvvmhabit.ui.pay.PayFragment;

import me.goldze.mvvmhabit.base.BaseViewModel;
import me.goldze.mvvmhabit.binding.command.BindingAction;
import me.goldze.mvvmhabit.binding.command.BindingCommand;
import me.goldze.mvvmhabit.utils.ToastUtils;

/**
 * Created by goldze on 2017/7/17.
 */

public class SetViewModel extends BaseViewModel<DemoRepository> {

    public ObservableField<String> balance = new ObservableField<>("");

    public SetViewModel(@NonNull Application application, DemoRepository repository) {
        super(application, repository);
        balance.set(model.getBalance());
    }


    public BindingCommand clickCommand = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            model.saveBalance(balance.get());
            ToastUtils.showShort("保存成功");
        }
    });


    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
