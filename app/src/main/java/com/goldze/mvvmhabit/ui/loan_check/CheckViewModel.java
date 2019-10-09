package com.goldze.mvvmhabit.ui.loan_check;

import android.app.Application;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;
import android.view.View;

import com.goldze.mvvmhabit.data.DemoRepository;
import com.goldze.mvvmhabit.ui.base.viewmodel.ToolbarViewModel;
import com.goldze.mvvmhabit.ui.loan_input.LInputFragment;

import me.goldze.mvvmhabit.binding.command.BindingAction;
import me.goldze.mvvmhabit.binding.command.BindingCommand;

public class CheckViewModel extends ToolbarViewModel {


    public CheckViewModel(@NonNull Application application) {
        super(application);
    }

    /**
     * 初始化Toolbar
     */
    public void initToolbar() {
        //初始化标题栏
        setRightTextVisible(View.GONE);
        setRightIconVisible(View.GONE);
        setTitleText("");
    }

}
