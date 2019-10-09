package com.goldze.mvvmhabit.ui.loan_input;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.goldze.mvvmhabit.R;
import com.goldze.mvvmhabit.app.AppViewModelFactory;
import com.goldze.mvvmhabit.databinding.FragmentLinputBinding;
import com.goldze.mvvmhabit.databinding.FragmentLoanBinding;
import com.goldze.mvvmhabit.ui.base.BaseDialog;

import me.goldze.mvvmhabit.base.BaseFragment;

public class LInputFragment extends BaseFragment<FragmentLinputBinding, LInputViewModel> {

    @Override
    public int initContentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return R.layout.fragment_linput;
    }

    @Override
    public int initVariableId() {
        return com.goldze.mvvmhabit.BR.viewModel;
    }

    @Override
    public LInputViewModel initViewModel() {
        //使用自定义的ViewModelFactory来创建ViewModel，如果不重写该方法，则默认会调用NetWorkViewModel(@NonNull Application application)构造方法
        AppViewModelFactory factory = AppViewModelFactory.getInstance(getActivity().getApplication());
        return ViewModelProviders.of(this, factory).get(LInputViewModel.class);
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
        viewModel.clickEvent.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer integer) {
                //pSwitchObservable是boolean类型的观察者,所以可以直接使用它的值改变密码开关的图标
                if (integer == 0) {
                    showMonthsDialog();
                }
            }
        });
    }

    private BaseDialog mBaseDialog;

    private View mViewMonth;

    private void showMonthsDialog() {
        if (mBaseDialog == null)
            mBaseDialog = new BaseDialog(getActivity());
        if (mViewMonth == null) {
            mViewMonth = getLayoutInflater().inflate(R.layout.dialog_months, null);
            final ImageView iv5 = mViewMonth.findViewById(R.id.iv_5);
            final ImageView iv10 = mViewMonth.findViewById(R.id.iv_10);
            final ImageView iv20 = mViewMonth.findViewById(R.id.iv_20);
            View.OnClickListener onClickListener = new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switch (v.getId()) {
                        case R.id.ll_5:
                            iv5.setVisibility(View.VISIBLE);
                            iv10.setVisibility(View.GONE);
                            iv20.setVisibility(View.GONE);
                            viewModel.month.set(5);
                            break;
                        case R.id.ll_10:
                            iv5.setVisibility(View.GONE);
                            iv10.setVisibility(View.VISIBLE);
                            iv20.setVisibility(View.GONE);
                            viewModel.month.set(10);
                            break;
                        case R.id.ll_20:
                            iv5.setVisibility(View.GONE);
                            iv10.setVisibility(View.GONE);
                            iv20.setVisibility(View.VISIBLE);
                            viewModel.month.set(20);
                            break;
                        default:
                            break;
                    }
                    mBaseDialog.dismiss();
                }
            };
            mViewMonth.findViewById(R.id.iv_close).setOnClickListener(onClickListener);
            mViewMonth.findViewById(R.id.ll_5).setOnClickListener(onClickListener);
            mViewMonth.findViewById(R.id.ll_10).setOnClickListener(onClickListener);
            mViewMonth.findViewById(R.id.ll_20).setOnClickListener(onClickListener);
        }
        mBaseDialog.show(mViewMonth);
    }

}