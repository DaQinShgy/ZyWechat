package com.goldze.mvvmhabit.ui.bank;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.goldze.mvvmhabit.R;
import com.goldze.mvvmhabit.app.AppViewModelFactory;
import com.goldze.mvvmhabit.databinding.FragmentBankBinding;

import me.goldze.mvvmhabit.base.BaseActivity;

public class BankActivity extends BaseActivity<FragmentBankBinding, BankViewModel> {

    @Override
    public void initParam() {
        super.initParam();
        setDark(false);
    }

    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.fragment_bank;
    }

    @Override
    public int initVariableId() {
        return com.goldze.mvvmhabit.BR.viewModel;
    }

    @Override
    public BankViewModel initViewModel() {
        //使用自定义的ViewModelFactory来创建ViewModel，如果不重写该方法，则默认会调用NetWorkViewModel(@NonNull Application application)构造方法
        AppViewModelFactory factory = AppViewModelFactory.getInstance(getApplication());
        return ViewModelProviders.of(this, factory).get(BankViewModel.class);
    }

    @Override
    public void initData() {
        //通过binding拿到toolbar控件, 设置给Activity
        setSupportActionBar(binding.include.toolbar);
        //初始化标题
        viewModel.initToolbar();
    }

    @Override
    public void initViewObservable() {
        viewModel.addEvent.observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable Boolean aBoolean) {
                //pSwitchObservable是boolean类型的观察者,所以可以直接使用它的值改变密码开关的图标
                if (viewModel.addEvent.getValue()) {
//                    addBank();
                }
            }
        });
    }

//    private MyAlertInputDialog myAlertInputDialog;
//
//    private void addBank() {
//        if (myAlertInputDialog == null) {
//            myAlertInputDialog = new MyAlertInputDialog(this).builder()
//                    .setTitle("请输入")
//                    .setEditText("");
//            myAlertInputDialog.setPositiveButton("确认", new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    String cardNo = myAlertInputDialog.getResult();
//                    String cardName = BankUtil.getNameOfBank(cardNo);
//                    if (!cardName.contains("·")) {
//                        ToastUtils.showShort(cardName);
//                        return;
//                    }
//                    BankCard bankCard = new BankCard();
//                    bankCard.setName(cardName.split("·")[0]);
//                    bankCard.setNo("****  ****  ****  " + cardNo.substring(12));
//                    bankCard.setType(cardName.split("·")[1].contains("信用卡") ? "信用卡" : "储蓄卡");
//                    int resourceId0 = 0;
//                    int resourceId1 = 0;
//                    if (cardName.contains("农业银行")) {
//                        resourceId0 = R.mipmap.ic_ny0;
//                        resourceId1 = R.mipmap.ic_ny1;
//                    } else if (cardName.contains("工商银行")) {
//                        resourceId0 = R.mipmap.ic_gs0;
//                        resourceId1 = R.mipmap.ic_gs1;
//                    }
//                    bankCard.setDrawable0(resourceId0);
//                    bankCard.setDrawable1(resourceId1);
//                    viewModel.saveBankCard(bankCard);
//                    myAlertInputDialog.dismiss();
//                }
//            }).setNegativeButton("取消", new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    myAlertInputDialog.dismiss();
//                }
//            });
//        }
//        myAlertInputDialog.setEditText("");
//        myAlertInputDialog.show();
//    }

}