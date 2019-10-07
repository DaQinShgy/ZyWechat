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

/**
 * Created by goldze on 2017/7/17.
 */

public class InfoViewModel extends ToolbarViewModel<DemoRepository> {

    public InfoEntity entity;

    //封装一个界面发生改变的观察者
    public UIChangeObservable uc;

    public class UIChangeObservable {
        //显示日期对话框
        public ObservableBoolean showDateDialogObservable;

        public UIChangeObservable() {
            showDateDialogObservable = new ObservableBoolean(false);
        }
    }

    public InfoViewModel(@NonNull Application application, DemoRepository repository) {
        super(application, repository);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        uc = new UIChangeObservable();
        entity = new InfoEntity();
    }

    @Override
    public void onResume() {
        super.onResume();
        entity.setHead(model.getHead());
        entity.setName(model.getUserName());
        entity.setWxId(model.getWxId());
    }

    public void initHead(){

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
