package com.goldze.mvvmhabit.ui.loan_first;

import android.app.Application;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.support.annotation.NonNull;
import android.view.View;

import com.goldze.mvvmhabit.data.DemoRepository;
import com.goldze.mvvmhabit.entity.Loan;
import com.goldze.mvvmhabit.ui.base.viewmodel.ToolbarViewModel;
import com.goldze.mvvmhabit.ui.loan_input.LInputFragment;

import me.goldze.mvvmhabit.binding.command.BindingAction;
import me.goldze.mvvmhabit.binding.command.BindingCommand;

public class LoanViewModel extends ToolbarViewModel<DemoRepository> {

    public ObservableField<Loan> entity = new ObservableField<>();

    public ObservableField<String> rateTotal = new ObservableField<>();

    public ObservableInt rate = new ObservableInt(View.GONE);

    public LoanViewModel(@NonNull Application application, DemoRepository repository) {
        super(application, repository);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        entity.set(model.getLoan());
        if (entity.get().getRateDay() == 0.03)
            rate.set(View.VISIBLE);
        rateTotal.set(String.format("总额度%s，日利率%s", entity.get().getQuotaTotal(), entity.get().getRateDay() + "%"));
    }

    /**
     * 初始化Toolbar
     */
    public void initToolbar() {
        //初始化标题栏
        setRightTextVisible(View.GONE);
        setRightIconVisible(View.VISIBLE);
        setTitleText("微粒贷");
    }

    public BindingCommand clickCommand = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            startContainerActivity(LInputFragment.class.getCanonicalName());
        }
    });
}
