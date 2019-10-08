package com.goldze.mvvmhabit.ui.bank;

import android.arch.lifecycle.ViewModelProviders;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.goldze.mvvmhabit.R;
import com.goldze.mvvmhabit.app.AppViewModelFactory;
import com.goldze.mvvmhabit.databinding.FragmentBankBinding;

import me.goldze.mvvmhabit.base.BaseFragment;

public class BankFragment extends BaseFragment<FragmentBankBinding, BankViewModel> {

    @Override
    public int initContentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Window window = getActivity().getWindow();
        View decorView = window.getDecorView();
        int option = 0;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
        }
        decorView.setSystemUiVisibility(option);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
        return R.layout.fragment_bank;
    }

    @Override
    public int initVariableId() {
        return com.goldze.mvvmhabit.BR.viewModel;
    }

    @Override
    public BankViewModel initViewModel() {
        //使用自定义的ViewModelFactory来创建ViewModel，如果不重写该方法，则默认会调用NetWorkViewModel(@NonNull Application application)构造方法
        AppViewModelFactory factory = AppViewModelFactory.getInstance(getActivity().getApplication());
        return ViewModelProviders.of(this, factory).get(BankViewModel.class);
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