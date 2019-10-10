package com.goldze.mvvmhabit.ui.set;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;

import com.goldze.mvvmhabit.BR;
import com.goldze.mvvmhabit.R;
import com.goldze.mvvmhabit.app.AppViewModelFactory;
import com.goldze.mvvmhabit.databinding.ActivitySetBinding;

import me.goldze.mvvmhabit.base.BaseActivity;

public class SetActivity extends BaseActivity<ActivitySetBinding, SetViewModel> {
    //ActivityLoginBinding类是databinding框架自定生成的,对应activity_login.xml
    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_set;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

    @Override
    public SetViewModel initViewModel() {
        //使用自定义的ViewModelFactory来创建ViewModel，如果不重写该方法，则默认会调用LoginViewModel(@NonNull Application application)构造方法
        AppViewModelFactory factory = AppViewModelFactory.getInstance(getApplication());
        return ViewModelProviders.of(this, factory).get(SetViewModel.class);
    }

    @Override
    public void initViewObservable() {
        if (viewModel.entity.get().getRateDay() == 0.03)
            binding.rb0.setChecked(true);
        else
            binding.rb1.setChecked(true);
    }
}
