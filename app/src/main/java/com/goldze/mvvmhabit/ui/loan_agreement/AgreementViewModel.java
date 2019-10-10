package com.goldze.mvvmhabit.ui.loan_agreement;

import android.app.Application;
import android.databinding.ObservableField;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.view.View;

import com.goldze.mvvmhabit.ui.base.viewmodel.ToolbarViewModel;

import me.goldze.mvvmhabit.binding.command.BindingAction;
import me.goldze.mvvmhabit.binding.command.BindingCommand;

public class AgreementViewModel extends ToolbarViewModel {

    public AgreementViewModel(@NonNull Application application) {
        super(application);
    }

    /**
     * 初始化Toolbar
     */
    public void initToolbar() {
        //初始化标题栏
        setRightTextVisible(View.GONE);
        setRightIconVisible(View.GONE);
        setTitleText("合同及协议");
    }

}
