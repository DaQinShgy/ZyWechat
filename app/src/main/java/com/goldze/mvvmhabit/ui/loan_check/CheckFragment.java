package com.goldze.mvvmhabit.ui.loan_check;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.goldze.mvvmhabit.R;
import com.goldze.mvvmhabit.databinding.FragmentCheckBinding;
import com.goldze.mvvmhabit.databinding.FragmentLoanBinding;

import me.goldze.mvvmhabit.base.BaseFragment;

public class CheckFragment extends BaseFragment<FragmentCheckBinding, CheckViewModel> {

    @Override
    public int initContentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return R.layout.fragment_check;
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
        binding.et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String result = s.toString().trim();
                if (!TextUtils.isEmpty(result) && result.length() == 6) {

                }
            }
        });
    }
}