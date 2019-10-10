package com.goldze.mvvmhabit.ui.loan_code;

import android.app.Application;
import android.databinding.ObservableField;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.view.View;

import com.goldze.mvvmhabit.ui.base.viewmodel.ToolbarViewModel;

import me.goldze.mvvmhabit.binding.command.BindingAction;
import me.goldze.mvvmhabit.binding.command.BindingCommand;

public class CodeViewModel extends ToolbarViewModel {

    public ObservableField<String> code = new ObservableField<>("获取验证码");

    public CodeViewModel(@NonNull Application application) {
        super(application);
    }

    /**
     * 初始化Toolbar
     */
    public void initToolbar() {
        //初始化标题栏
        setRightTextVisible(View.GONE);
        setRightIconVisible(View.GONE);
        setTitleText("验证手机号");
    }

    private CountDownTimer mTimer;

    private void start() {
        if (mTimer == null) {
            mTimer = new CountDownTimer(120000 + 500, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    code.set("获取验证码（" + (millisUntilFinished / 1000) + "）");
                }

                @Override
                public void onFinish() {
                    code.set("获取验证码");
                }
            };
        }
        if (!"获取验证码".equals(code.get()))
            return;
        mTimer.start();
    }

    public BindingCommand codeClickCommand = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            start();
        }
    });


}
