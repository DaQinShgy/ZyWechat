package com.goldze.mvvmhabit.ui.mine;

import android.app.Application;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;

import com.goldze.mvvmhabit.data.DemoRepository;
import com.goldze.mvvmhabit.entity.InfoEntity;
import com.goldze.mvvmhabit.ui.info.InfoFragment;
import com.goldze.mvvmhabit.ui.pay.PayFragment;

import me.goldze.mvvmhabit.base.BaseViewModel;
import me.goldze.mvvmhabit.binding.command.BindingAction;
import me.goldze.mvvmhabit.binding.command.BindingCommand;

/**
 * Created by goldze on 2017/7/17.
 */

public class MineViewModel extends BaseViewModel<DemoRepository> {

    public InfoEntity entity;

    public MineViewModel(@NonNull Application application, DemoRepository repository) {
        super(application, repository);
        entity = new InfoEntity();
    }

    @Override
    public void onResume() {
        super.onResume();
        entity.setHead(model.getHead());
        entity.setName(model.getUserName());
        entity.setWxId("微信号：" + model.getWxId());
        entity.notifyChange();
    }

    public BindingCommand infoClickCommand = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            startContainerActivity(InfoFragment.class.getCanonicalName());
        }
    });

    public BindingCommand payClickCommand = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            startContainerActivity(PayFragment.class.getCanonicalName());
        }
    });

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
