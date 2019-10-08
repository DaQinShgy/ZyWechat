package com.goldze.mvvmhabit.ui.bank;

import android.support.annotation.NonNull;

import me.goldze.mvvmhabit.base.BaseViewModel;
import me.goldze.mvvmhabit.base.MultiItemViewModel;
import me.goldze.mvvmhabit.binding.command.BindingAction;
import me.goldze.mvvmhabit.binding.command.BindingCommand;
import me.goldze.mvvmhabit.utils.ToastUtils;

/**
 * Create Author：goldze
 * Create Date：2019/01/25
 * Description：
 */

public class Type1ViewModel extends MultiItemViewModel {

    public Type1ViewModel(@NonNull BaseViewModel viewModel) {
        super(viewModel);
    }

    //条目的点击事件
    public BindingCommand itemClick = new BindingCommand(new BindingAction() {
        @Override
        public void call() {

        }
    });
}
