package com.goldze.mvvmhabit.ui.input;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.goldze.mvvmhabit.BR;
import com.goldze.mvvmhabit.R;
import com.goldze.mvvmhabit.app.AppViewModelFactory;
import com.goldze.mvvmhabit.databinding.FragmentInputBinding;

import me.goldze.mvvmhabit.base.BaseFragment;

public class InputFragment extends BaseFragment<FragmentInputBinding, InputViewModel> {

    private int type;

    @Override
    public void initParam() {
        Bundle mBundle = getArguments();
        if (mBundle != null) {
            type = mBundle.getInt("type", 0);
        }
    }

    @Override
    public int initContentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return R.layout.fragment_input;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

    @Override
    public InputViewModel initViewModel() {
        AppViewModelFactory factory = AppViewModelFactory.getInstance(getActivity().getApplication());
        return ViewModelProviders.of(this, factory).get(InputViewModel.class);
    }

    @Override
    public void initData() {
        //通过binding拿到toolbar控件, 设置给Activity
        ((AppCompatActivity) getActivity()).setSupportActionBar(binding.include.toolbar);
        //初始化标题
        viewModel.initToolbar();
        viewModel.setType(type);
    }

    @Override
    public void initViewObservable() {

    }


}