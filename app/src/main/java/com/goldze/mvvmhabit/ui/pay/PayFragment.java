package com.goldze.mvvmhabit.ui.pay;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.goldze.mvvmhabit.R;
import com.goldze.mvvmhabit.app.AppViewModelFactory;
import com.goldze.mvvmhabit.databinding.FragmentPayBinding;

import me.goldze.mvvmhabit.base.BaseFragment;

public class PayFragment extends BaseFragment<FragmentPayBinding, PayViewModel> {

    @Override
    public int initContentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return R.layout.fragment_pay;
    }

    @Override
    public int initVariableId() {
        return com.goldze.mvvmhabit.BR.viewModel;
    }

    @Override
    public PayViewModel initViewModel() {
        //使用自定义的ViewModelFactory来创建ViewModel，如果不重写该方法，则默认会调用NetWorkViewModel(@NonNull Application application)构造方法
        AppViewModelFactory factory = AppViewModelFactory.getInstance(getActivity().getApplication());
        return ViewModelProviders.of(this, factory).get(PayViewModel.class);
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