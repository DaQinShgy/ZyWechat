package com.goldze.mvvmhabit.ui.bank;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.goldze.mvvmhabit.R;
import com.goldze.mvvmhabit.app.AppViewModelFactory;
import com.goldze.mvvmhabit.databinding.FragmentBankBinding;
import com.goldze.mvvmhabit.entity.BankCard;
import com.goldze.mvvmhabit.view.AddCardDialog;

import me.goldze.mvvmhabit.base.BaseActivity;

public class BankActivity extends BaseActivity<FragmentBankBinding, BankViewModel> {

    @Override
    public void initParam() {
        super.initParam();
        setDark(false);
    }

    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.fragment_bank;
    }

    @Override
    public int initVariableId() {
        return com.goldze.mvvmhabit.BR.viewModel;
    }

    @Override
    public BankViewModel initViewModel() {
        //使用自定义的ViewModelFactory来创建ViewModel，如果不重写该方法，则默认会调用NetWorkViewModel(@NonNull Application application)构造方法
        AppViewModelFactory factory = AppViewModelFactory.getInstance(getApplication());
        return ViewModelProviders.of(this, factory).get(BankViewModel.class);
    }

    @Override
    public void initData() {
        //通过binding拿到toolbar控件, 设置给Activity
        setSupportActionBar(binding.include.toolbar);
        //初始化标题
        viewModel.initToolbar();
    }

    @Override
    public void initViewObservable() {
        viewModel.addEvent.observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable Boolean aBoolean) {
                //pSwitchObservable是boolean类型的观察者,所以可以直接使用它的值改变密码开关的图标
                if (viewModel.addEvent.getValue()) {
                    new AddCardDialog(BankActivity.this, new AddCardDialog.DialogCallBack() {
                        @Override
                        public void onSuccess(BankCard bankCard) {
                            viewModel.saveBankCard(bankCard);
                        }
                    }).show();
                }
            }
        });
    }

}