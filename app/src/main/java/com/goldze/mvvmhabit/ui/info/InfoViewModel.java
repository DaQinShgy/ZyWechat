package com.goldze.mvvmhabit.ui.info;

import android.app.Application;
import android.databinding.ObservableBoolean;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;

import com.goldze.mvvmhabit.data.DemoRepository;
import com.goldze.mvvmhabit.entity.InfoEntity;
import com.goldze.mvvmhabit.ui.base.viewmodel.ToolbarViewModel;
import com.goldze.mvvmhabit.ui.input.InputFragment;

import me.goldze.mvvmhabit.binding.command.BindingAction;
import me.goldze.mvvmhabit.binding.command.BindingCommand;
import me.goldze.mvvmhabit.bus.event.SingleLiveEvent;

public class InfoViewModel extends ToolbarViewModel<DemoRepository> {

    public InfoEntity entity;

    public InfoViewModel(@NonNull Application application, DemoRepository repository) {
        super(application, repository);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        entity = new InfoEntity();
    }

    @Override
    public void onResume() {
        super.onResume();
        entity.setHead(model.getHead());
        entity.setName(model.getUserName());
        entity.setWxId(model.getWxId());
        entity.notifyChange();
    }

    public void initHead(String path){
        model.saveHead(path);
        entity.setHead(model.getHead());
        entity.notifyChange();
    }

    /**
     * 初始化Toolbar
     */
    public void initToolbar() {
        //初始化标题栏
        setRightTextVisible(View.GONE);
        setRightIconVisible(View.GONE);
        setTitleText("个人信息");
    }

    public SingleLiveEvent<Boolean> requestPermissions = new SingleLiveEvent<>();

    public BindingCommand headClickCommand = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            requestPermissions.call();
        }
    });

    public BindingCommand nickClickCommand = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            Bundle mBundle = new Bundle();
            mBundle.putInt("type", 0);
            startContainerActivity(InputFragment.class.getCanonicalName(), mBundle);
        }
    });

    public BindingCommand wxClickCommand = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            Bundle mBundle = new Bundle();
            mBundle.putInt("type", 1);
            startContainerActivity(InputFragment.class.getCanonicalName(), mBundle);
        }
    });

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
