package com.goldze.mvvmhabit.ui.bank;

import android.databinding.ObservableField;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;

import com.goldze.mvvmhabit.R;
import com.goldze.mvvmhabit.entity.BankCard;

import me.goldze.mvvmhabit.base.BaseViewModel;
import me.goldze.mvvmhabit.base.MultiItemViewModel;
import me.goldze.mvvmhabit.binding.command.BindingAction;
import me.goldze.mvvmhabit.binding.command.BindingCommand;

/**
 * Create Author：goldze
 * Create Date：2019/01/25
 * Description：
 */

public class Type0ViewModel extends MultiItemViewModel {

    public ObservableField<BankCard> entity = new ObservableField<>();
    public Drawable drawableImg0;
    public Drawable drawableImg1;

    public Type0ViewModel(@NonNull BaseViewModel viewModel, BankCard bankCard) {
        super(viewModel);
        this.entity.set(bankCard);
        drawableImg0 = ContextCompat.getDrawable(viewModel.getApplication(), this.entity.get().getDrawable0());
        drawableImg1 = ContextCompat.getDrawable(viewModel.getApplication(), this.entity.get().getDrawable1());
    }

    //条目的点击事件
    public BindingCommand itemLongClick = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            viewModel.dismissDialog();
        }
    });
}
