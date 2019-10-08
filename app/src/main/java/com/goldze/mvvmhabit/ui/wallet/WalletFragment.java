package com.goldze.mvvmhabit.ui.wallet;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.goldze.mvvmhabit.R;
import com.goldze.mvvmhabit.app.AppViewModelFactory;
import com.goldze.mvvmhabit.databinding.FragmentWalletBinding;

import me.goldze.mvvmhabit.base.BaseFragment;

public class WalletFragment extends BaseFragment<FragmentWalletBinding, WalletViewModel> {

    @Override
    public int initContentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return R.layout.fragment_wallet;
    }

    @Override
    public int initVariableId() {
        return com.goldze.mvvmhabit.BR.viewModel;
    }

    @Override
    public WalletViewModel initViewModel() {
        //使用自定义的ViewModelFactory来创建ViewModel，如果不重写该方法，则默认会调用NetWorkViewModel(@NonNull Application application)构造方法
        AppViewModelFactory factory = AppViewModelFactory.getInstance(getActivity().getApplication());
        return ViewModelProviders.of(this, factory).get(WalletViewModel.class);
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