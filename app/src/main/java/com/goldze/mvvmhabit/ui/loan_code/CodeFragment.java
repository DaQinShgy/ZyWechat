package com.goldze.mvvmhabit.ui.loan_code;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.goldze.mvvmhabit.R;
import com.goldze.mvvmhabit.databinding.FragmentCheckBinding;
import com.goldze.mvvmhabit.databinding.FragmentCodeBinding;

import me.goldze.mvvmhabit.base.BaseFragment;

public class CodeFragment extends BaseFragment<FragmentCodeBinding, CodeViewModel> {

    @Override
    public int initContentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return R.layout.fragment_code;
    }

    @Override
    public int initVariableId() {
        return com.goldze.mvvmhabit.BR.viewModel;
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
        super.initViewObservable();

    }
}