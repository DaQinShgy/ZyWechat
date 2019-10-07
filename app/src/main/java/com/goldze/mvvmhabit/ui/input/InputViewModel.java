package com.goldze.mvvmhabit.ui.input;

import android.app.Application;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;

import com.goldze.mvvmhabit.data.DemoRepository;
import com.goldze.mvvmhabit.ui.base.viewmodel.ToolbarViewModel;

import me.goldze.mvvmhabit.utils.ToastUtils;

/**
 * Created by goldze on 2017/7/17.
 */

public class InputViewModel extends ToolbarViewModel<DemoRepository> {

    public ObservableField<String> string = new ObservableField<>("");

    public InputViewModel(@NonNull Application application, DemoRepository repository) {
        super(application, repository);
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    /**
     * 初始化Toolbar
     */
    public void initToolbar() {
        //初始化标题栏
        setRightTextVisible(View.VISIBLE);
        setRightIconVisible(View.GONE);
        setTitleText("设置");
    }

    public int type;

    public void setType(int type) {
        this.type = type;
        if (type == 0)
            string.set(model.getUserName());
        else if (type == 1)
            string.set(model.getWxId());
    }

    @Override
    public void rightTextOnClick() {
        if (type == 0) {
            if (TextUtils.isEmpty(string.get())) {
                ToastUtils.showShort("请输入内容");
                return;
            }
            model.saveUserName(string.get());
            finish();
        } else if (type == 1) {
            if (TextUtils.isEmpty(string.get())) {
                ToastUtils.showShort("请输入内容");
                return;
            }
            model.saveWxId(string.get());
            finish();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
