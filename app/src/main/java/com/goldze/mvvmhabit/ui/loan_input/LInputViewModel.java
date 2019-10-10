package com.goldze.mvvmhabit.ui.loan_input;

import android.app.Application;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.view.View;

import com.goldze.mvvmhabit.data.DemoRepository;
import com.goldze.mvvmhabit.entity.BankCard;
import com.goldze.mvvmhabit.entity.Loan;
import com.goldze.mvvmhabit.ui.base.viewmodel.ToolbarViewModel;
import com.goldze.mvvmhabit.ui.loan_check.CheckFragment;
import com.goldze.mvvmhabit.utils.StringUtil;

import java.util.List;

import me.goldze.mvvmhabit.binding.command.BindingAction;
import me.goldze.mvvmhabit.binding.command.BindingCommand;
import me.goldze.mvvmhabit.binding.command.BindingConsumer;
import me.goldze.mvvmhabit.bus.event.SingleLiveEvent;

public class LInputViewModel extends ToolbarViewModel<DemoRepository> {

    public ObservableField<Loan> entity = new ObservableField<>();

    public ObservableField<String> money = new ObservableField<>("");

    public ObservableInt dividerGray = new ObservableInt(View.VISIBLE);
    public ObservableInt dividerYellow = new ObservableInt(View.INVISIBLE);
    public ObservableInt dividerRed = new ObservableInt(View.INVISIBLE);
    public ObservableInt textHint = new ObservableInt(View.VISIBLE);
    public ObservableField<String> textRed = new ObservableField<>("");

    public ObservableInt content = new ObservableInt(View.INVISIBLE);
    public ObservableInt btnDefault = new ObservableInt(View.VISIBLE);

    public ObservableInt month = new ObservableInt(5);

    public ObservableInt showDetail = new ObservableInt(View.GONE);

    public ObservableField<String> repay = new ObservableField<>("");

    public ObservableField<Drawable> bankDrawable = new ObservableField<>();
    public ObservableField<String> bankInfo = new ObservableField<>("");

    private List<BankCard> bankCards;

    public ObservableInt rate = new ObservableInt(View.GONE);

    public ObservableField<String> date = new ObservableField<>("");

    public ObservableField<String> repayFirst = new ObservableField<>("");

    public ObservableField<String> peopleNo = new ObservableField<>("");

    public ObservableField<String> repayDay = new ObservableField<>("");

    public LInputViewModel(@NonNull Application application, DemoRepository repository) {
        super(application, repository);
        entity.set(model.getLoan());
        bankCards = model.getAllBankCard();
        setBank(0);
        if (entity.get().getRateDay() == 0.03)
            rate.set(View.VISIBLE);
        repayFirst.set(StringUtil.getAfterMonth(entity.get().getDateStart(), 1));
        peopleNo.set(entity.get().getPeopleCardNo() + "*************");
        repayDay.set(String.format("每月%s日", StringUtil.getAfterMonthOnlyDay(entity.get().getDateStart(), 1)));
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
                btnDefault.set(View.VISIBLE);
                return;
            }
            int result = Integer.parseInt(money.get());
            if (result < 500 || result > 40000) {
                dividerGray.set(View.INVISIBLE);
                dividerYellow.set(View.INVISIBLE);
                dividerRed.set(View.VISIBLE);
                textHint.set(View.INVISIBLE);
                content.set(View.INVISIBLE);
                btnDefault.set(View.VISIBLE);
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
                btnDefault.set(View.VISIBLE);
                return;
            }
            int result = Integer.parseInt(money.get());
            if (result < 500 || result > 40000) {
                dividerGray.set(View.INVISIBLE);
                dividerYellow.set(View.INVISIBLE);
                dividerRed.set(View.VISIBLE);
                textHint.set(View.INVISIBLE);
                content.set(View.INVISIBLE);
                btnDefault.set(View.VISIBLE);
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
        btnDefault.set(View.GONE);
        setRepay();
        date.set(entity.get().getDateStart().replaceAll("-", "/") + " - " + StringUtil.getAfterMonthWithYear(entity.get().getDateStart(), month.get()));


    }

    public SingleLiveEvent<Integer> clickEvent = new SingleLiveEvent<>();

    public BindingCommand monthClickCommand = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            clickEvent.setValue(0);
        }
    });

    public BindingCommand dateClickCommand = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            clickEvent.setValue(1);
        }
    });

    public void setRepay() {
        repay.set(String.format("首次%s  应还¥%.2f", StringUtil.getAfterMonth(entity.get().getDateStart(), 1),
                Integer.valueOf(money.get()) / month.get() + Integer.valueOf(money.get()) * entity.get().getRateDay() * 0.01 * 30));
    }

    public BindingCommand cardClickCommand = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            clickEvent.setValue(2);
        }
    });

    private int mCardSelected = 0;

    public int getCardSelected() {
        return mCardSelected;
    }

    public void setBank(int position) {
        if (bankCards.size() <= position) {
            return;
        }
        this.mCardSelected = position;
        BankCard bankCard = bankCards.get(position);
        bankDrawable.set(ContextCompat.getDrawable(getApplication(), bankCard.getDrawable2()));
        bankInfo.set(bankCard.getName() + " " + bankCard.getType() + " (" +
                bankCard.getNo().replace("****  ****  ****  ", "") + ")");
    }

    public List<BankCard> getAllCard() {
        return model.getAllBankCard();
    }

    public BindingCommand detailClickCommand = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            showDetail.set(showDetail.get() == View.VISIBLE ? View.GONE : View.VISIBLE);
        }
    });

    public BindingCommand nextClickCommand = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            startContainerActivity(CheckFragment.class.getCanonicalName());
        }
    });

}
