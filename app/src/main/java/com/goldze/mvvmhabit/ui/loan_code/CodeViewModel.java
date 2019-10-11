package com.goldze.mvvmhabit.ui.loan_code;

import android.app.Application;
import android.databinding.ObservableField;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;

import com.goldze.mvvmhabit.data.DemoRepository;
import com.goldze.mvvmhabit.entity.Loan;
import com.goldze.mvvmhabit.ui.base.viewmodel.ToolbarViewModel;

import me.goldze.mvvmhabit.binding.command.BindingAction;
import me.goldze.mvvmhabit.binding.command.BindingCommand;

public class CodeViewModel extends ToolbarViewModel<DemoRepository> {

    public ObservableField<String> code = new ObservableField<>("获取验证码");

    public ObservableField<Loan> entity = new ObservableField<>();

    public ObservableField<String> phone = new ObservableField<>();

    public CodeViewModel(@NonNull Application application, DemoRepository repository) {
        super(application, repository);
        entity.set(model.getLoan());
        String phoneNumber = entity.get().getPhone();
        if (!TextUtils.isEmpty(phoneNumber) && phoneNumber.length() > 7)
            phoneNumber = phoneNumber.substring(0, 3) + "****" + phoneNumber.substring(7);
        phone.set("接收验证码:" + phoneNumber);
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
            mTimer = new CountDownTimer(60000 + 500, 1000) {
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
