package com.goldze.mvvmhabit.ui.loan_input;

import android.app.Application;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;

import com.goldze.mvvmhabit.data.DemoRepository;
import com.goldze.mvvmhabit.ui.base.viewmodel.ToolbarViewModel;

import me.goldze.mvvmhabit.binding.command.BindingAction;
import me.goldze.mvvmhabit.binding.command.BindingCommand;
import me.goldze.mvvmhabit.binding.command.BindingConsumer;
import me.goldze.mvvmhabit.bus.event.SingleLiveEvent;

public class LInputViewModel extends ToolbarViewModel<DemoRepository> {

    public ObservableField<String> money = new ObservableField<>("");

    public ObservableInt dividerGray = new ObservableInt(View.VISIBLE);
    public ObservableInt dividerYellow = new ObservableInt(View.INVISIBLE);
    public ObservableInt dividerRed = new ObservableInt(View.INVISIBLE);
    public ObservableInt textHint = new ObservableInt(View.VISIBLE);
    public ObservableField<String> textRed = new ObservableField<>("");

    public ObservableInt content = new ObservableInt(View.INVISIBLE);

    public ObservableInt month = new ObservableInt(5);

    public LInputViewModel(@NonNull Application application, DemoRepository repository) {
        super(application, repository);
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

    public BindingCommand<Boolean> onFocusChangeCommand = new BindingCommand<>(new BindingConsumer<Boolean>() {
        @Override
        public void call(Boolean hasFocus) {
            setColor(hasFocus);
        }
    });

    public void setColor(Boolean hasFocus) {
        if (hasFocus) {
            if (TextUtils.isEmpty(money.get())) {
                dividerGray.set(View.INVISIBLE);
                dividerYellow.set(View.VISIBLE);
                dividerRed.set(View.INVISIBLE);
                textHint.set(View.VISIBLE);
                content.set(View.INVISIBLE);
                return;
            }
            int result = Integer.parseInt(money.get());
            if (result < 500 || result > 40000) {
                dividerGray.set(View.INVISIBLE);
                dividerYellow.set(View.INVISIBLE);
                dividerRed.set(View.VISIBLE);
                textHint.set(View.INVISIBLE);
                content.set(View.INVISIBLE);
                if (result < 500)
                    textRed.set("单笔借钱金额最低¥500");
                else
                    textRed.set("单笔借钱金额最高¥40000");
                return;
            }
            dividerGray.set(View.INVISIBLE);
            dividerYellow.set(View.VISIBLE);
            dividerRed.set(View.INVISIBLE);
            textHint.set(View.VISIBLE);
        } else {
            if (TextUtils.isEmpty(money.get())) {
                dividerGray.set(View.VISIBLE);
                dividerYellow.set(View.INVISIBLE);
                dividerRed.set(View.INVISIBLE);
                textHint.set(View.VISIBLE);
                content.set(View.INVISIBLE);
                return;
            }
            int result = Integer.parseInt(money.get());
            if (result < 500 || result > 40000) {
                dividerGray.set(View.INVISIBLE);
                dividerYellow.set(View.INVISIBLE);
                dividerRed.set(View.VISIBLE);
                textHint.set(View.INVISIBLE);
                content.set(View.INVISIBLE);
                if (result < 500)
                    textRed.set("单笔借钱金额最低¥500");
                else
                    textRed.set("单笔借钱金额最高¥40000");
                return;
            }
            dividerGray.set(View.VISIBLE);
            dividerYellow.set(View.INVISIBLE);
            dividerRed.set(View.INVISIBLE);
            textHint.set(View.VISIBLE);
        }
        content.set(View.VISIBLE);
    }

    public SingleLiveEvent<Integer> clickEvent = new SingleLiveEvent<>();

    public BindingCommand monthClickCommand = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            clickEvent.setValue(0);
        }
    });

}
