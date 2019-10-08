package com.goldze.mvvmhabit.ui.pay;

import android.databinding.ObservableField;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;

import com.goldze.mvvmhabit.R;
import com.goldze.mvvmhabit.entity.PayItem;
import com.goldze.mvvmhabit.ui.loan.LoanFragment;
import com.goldze.mvvmhabit.ui.wallet.WalletFragment;

import me.goldze.mvvmhabit.base.ItemViewModel;
import me.goldze.mvvmhabit.binding.command.BindingAction;
import me.goldze.mvvmhabit.binding.command.BindingCommand;

/**
 * Created by goldze on 2017/7/17.
 */

public class PayItemViewModel extends ItemViewModel<PayViewModel> {

    public ObservableField<PayItem> entity = new ObservableField<>();
    public Drawable drawableImg;

    public PayItemViewModel(@NonNull PayViewModel viewModel, PayItem entity) {
        super(viewModel);
        this.entity.set(entity);
        //ImageView的占位图片，可以解决RecyclerView中图片错误问题
        drawableImg = ContextCompat.getDrawable(viewModel.getApplication(), entity.getResourceId());
    }

    //条目的点击事件
    public BindingCommand itemClick = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            if ("微粒贷借钱".equals(entity.get().getName())) {
                viewModel.startContainerActivity(LoanFragment.class.getCanonicalName());
            }
        }
    });

}
