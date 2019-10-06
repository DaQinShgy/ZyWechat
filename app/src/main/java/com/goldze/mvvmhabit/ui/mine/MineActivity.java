package com.goldze.mvvmhabit.ui.mine;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;

import com.goldze.mvvmhabit.BR;
import com.goldze.mvvmhabit.R;
import com.goldze.mvvmhabit.app.AppViewModelFactory;
import com.goldze.mvvmhabit.databinding.ActivityMineBinding;

import me.goldze.mvvmhabit.base.BaseActivity;

public class MineActivity extends BaseActivity<ActivityMineBinding, MineViewModel> {
    //ActivityLoginBinding类是databinding框架自定生成的,对应activity_login.xml
    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_mine;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

    @Override
    public MineViewModel initViewModel() {
        //使用自定义的ViewModelFactory来创建ViewModel，如果不重写该方法，则默认会调用LoginViewModel(@NonNull Application application)构造方法
        AppViewModelFactory factory = AppViewModelFactory.getInstance(getApplication());
        return ViewModelProviders.of(this, factory).get(MineViewModel.class);
    }

    @Override
    public void initViewObservable() {
//        //监听ViewModel中pSwitchObservable的变化, 当ViewModel中执行【uc.pSwitchObservable.set(!uc.pSwitchObservable.get());】时会回调该方法
//        viewModel.uc.pSwitchEvent.observe(this, new Observer<Boolean>() {
//            @Override
//            public void onChanged(@Nullable Boolean aBoolean) {
//                //pSwitchObservable是boolean类型的观察者,所以可以直接使用它的值改变密码开关的图标
//                if (viewModel.uc.pSwitchEvent.getValue()) {
//                    //密码可见
//                    //在xml中定义id后,使用binding可以直接拿到这个view的引用,不再需要findViewById去找控件了
//                    binding.ivSwichPasswrod.setImageResource(R.mipmap.show_psw);
//                    binding.etPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
//                } else {
//                    //密码不可见
//                    binding.ivSwichPasswrod.setImageResource(R.mipmap.show_psw_press);
//                    binding.etPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
//                }
//            }
//        });
    }
}
