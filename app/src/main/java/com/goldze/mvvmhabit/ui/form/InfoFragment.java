package com.goldze.mvvmhabit.ui.form;

import android.Manifest;
import android.annotation.SuppressLint;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import com.goldze.mvvmhabit.BR;
import com.goldze.mvvmhabit.R;
import com.goldze.mvvmhabit.app.AppViewModelFactory;
import com.goldze.mvvmhabit.databinding.FragmentInfoBinding;
import com.goldze.mvvmhabit.entity.InfoEntity;
import com.goldze.mvvmhabit.ui.network.NetWorkViewModel;
import com.tbruyelle.rxpermissions2.RxPermissions;
import com.yalantis.ucrop.model.AspectRatio;

import cn.finalteam.rxgalleryfinal.RxGalleryFinal;
import cn.finalteam.rxgalleryfinal.imageloader.ImageLoaderType;
import cn.finalteam.rxgalleryfinal.rxbus.RxBusResultDisposable;
import cn.finalteam.rxgalleryfinal.rxbus.event.ImageRadioResultEvent;
import io.reactivex.functions.Consumer;
import me.goldze.mvvmhabit.base.BaseFragment;
import me.goldze.mvvmhabit.utils.ToastUtils;

public class InfoFragment extends BaseFragment<FragmentInfoBinding, InfoViewModel> {

    @Override
    public int initContentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return R.layout.fragment_info;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

    @Override
    public InfoViewModel initViewModel() {
        //使用自定义的ViewModelFactory来创建ViewModel，如果不重写该方法，则默认会调用NetWorkViewModel(@NonNull Application application)构造方法
        AppViewModelFactory factory = AppViewModelFactory.getInstance(getActivity().getApplication());
        return ViewModelProviders.of(this, factory).get(InfoViewModel.class);
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
        viewModel.requestPermissions.observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable Boolean aBoolean) {
                requestCameraPermissions();
            }
        });
    }

    @SuppressLint("CheckResult")
    private void requestCameraPermissions() {
        //请求打开相机权限
        RxPermissions rxPermissions = new RxPermissions(getActivity());
        rxPermissions.request(Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .subscribe(new Consumer<Boolean>() {
                    @Override
                    public void accept(Boolean aBoolean) throws Exception {
                        if (aBoolean) {
                            RxGalleryFinal
                                    .with(getActivity())
                                    .image()
                                    .radio()
                                    .cropAspectRatioOptions(0, new AspectRatio("3:3", 30, 10))
                                    .crop()
                                    .imageLoader(ImageLoaderType.FRESCO)
                                    .subscribe(new RxBusResultDisposable<ImageRadioResultEvent>() {
                                        @Override
                                        protected void onEvent(ImageRadioResultEvent imageRadioResultEvent) throws Exception {
                                            Toast.makeText(getActivity(), "选中了图片路径：" + imageRadioResultEvent.getResult().getOriginalPath(), Toast.LENGTH_SHORT).show();
                                        }
                                    })
                                    .openGallery();
                        } else {
                            ToastUtils.showShort("权限被拒绝");
                        }
                    }
                });
    }

}
