package com.goldze.mvvmhabit.ui.bank;

import android.support.annotation.NonNull;

import com.goldze.mvvmhabit.entity.BankCard;

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

public class Type0ViewModel extends MultiItemViewModel {

    public Type0ViewModel(@NonNull BaseViewModel viewModel, BankCard bankCard) {
        super(viewModel);
    }

    //条目的点击事件
    public BindingCommand itemLongClick = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            ToastUtils.showShort("我是头布局");
        }
    });
}
