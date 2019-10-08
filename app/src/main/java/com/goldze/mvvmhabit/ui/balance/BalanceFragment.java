package com.goldze.mvvmhabit.ui.balance;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.goldze.mvvmhabit.R;
import com.goldze.mvvmhabit.app.AppViewModelFactory;
import com.goldze.mvvmhabit.databinding.FragmentBalanceBinding;
import com.goldze.mvvmhabit.databinding.FragmentWalletBinding;

import me.goldze.mvvmhabit.base.BaseFragment;

public class BalanceFragment extends BaseFragment<FragmentBalanceBinding, BalanceViewModel> {

    @Override
    public int initContentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return R.layout.fragment_balance;
    }

    @Override
    public int initVariableId() {
        return com.goldze.mvvmhabit.BR.viewModel;
    }

    @Override
    public BalanceViewModel initViewModel() {
        //使用自定义的ViewModelFactory来创建ViewModel，如果不重写该方法，则默认会调用NetWorkViewModel(@NonNull Application application)构造方法
        AppViewModelFactory factory = AppViewModelFactory.getInstance(getActivity().getApplication());
        return ViewModelProviders.of(this, factory).get(BalanceViewModel.class);
    }

    @Override
    public void initData() {
        //通过binding拿到toolbar控件, 设置给Activity
        ((AppCompatActivity) getActivity()).setSupportActionBar(binding.include.toolbar);
        //初始化标题
        viewModel.initToolbar();
    }

    @Override
    public void initViewObservable() {

    }

}