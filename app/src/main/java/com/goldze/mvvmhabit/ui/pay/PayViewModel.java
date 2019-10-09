package com.goldze.mvvmhabit.ui.pay;

import android.app.Application;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableField;
import android.databinding.ObservableList;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;

import com.goldze.mvvmhabit.R;
import com.goldze.mvvmhabit.data.DemoRepository;
import com.goldze.mvvmhabit.entity.DemoEntity;
import com.goldze.mvvmhabit.entity.InfoEntity;
import com.goldze.mvvmhabit.entity.PayItem;
import com.goldze.mvvmhabit.ui.base.viewmodel.ToolbarViewModel;
import com.goldze.mvvmhabit.ui.input.InputFragment;
import com.goldze.mvvmhabit.ui.network.NetWorkItemViewModel;
import com.goldze.mvvmhabit.ui.network.NetWorkViewModel;
import com.goldze.mvvmhabit.ui.wallet.WalletFragment;

import java.util.ArrayList;
import java.util.List;

import me.goldze.mvvmhabit.binding.command.BindingAction;
import me.goldze.mvvmhabit.binding.command.BindingCommand;
import me.goldze.mvvmhabit.bus.event.SingleLiveEvent;
import me.tatarka.bindingcollectionadapter2.ItemBinding;

public class PayViewModel extends ToolbarViewModel<DemoRepository> {

    public ObservableField<String> balance = new ObservableField<>("");

    public PayViewModel(@NonNull Application application, DemoRepository repository) {
        super(application, repository);
    }

    private int[] resourceTop0 = {R.mipmap.ic_a01, R.mipmap.ic_a03, R.mipmap.ic_a04, R.mipmap.ic_a05, R.mipmap.ic_a06, R.mipmap.ic_a07, R.mipmap.ic_a08};
    private int[] resourceTop1 = {R.mipmap.ic_a01, R.mipmap.ic_a02, R.mipmap.ic_a03, R.mipmap.ic_a04, R.mipmap.ic_a05, R.mipmap.ic_a06, R.mipmap.ic_a07, R.mipmap.ic_a08};

    private String[] nameTop0 = {"信用卡还款", "手机充值", "理财通", "生活缴费", "Q币充值", "城市服务", "腾讯公益"};
    private String[] nameTop1 = {"信用卡还款", "微粒贷借钱", "手机充值", "理财通", "生活缴费", "Q币充值", "城市服务", "腾讯公益"};

    private int[] resourceBottom = {R.mipmap.ic_b01, R.mipmap.ic_b02, R.mipmap.ic_b03, R.mipmap.ic_b04, R.mipmap.ic_b05, R.mipmap.ic_b06, R.mipmap.ic_b07, R.mipmap.ic_b08, R.mipmap.ic_b09, R.mipmap.ic_b10, R.mipmap.ic_b11, R.mipmap.ic_b12};

    private String[] nameBottom = {"火车票机票", "滴滴出行", "京东购物", "美团外卖", "电影演出赛事", "吃喝玩乐", "酒店", "拼多多", "蘑菇街女装", "唯品会特卖", "转转二手", "贝壳找房"};

    @Override
    public void onCreate() {
        super.onCreate();
        balance.set("¥" + model.getBalance());
        initTop(model.getDai());
        List<PayItem> list = new ArrayList<>();
        for (int i = 0; i < resourceBottom.length; i++) {
            list.add(new PayItem(resourceBottom[i], nameBottom[i]));
        }
        observableListBottom.clear();
        for (PayItem entity : list) {
            PayItemViewModel itemViewModel = new PayItemViewModel(this, entity);
            //双向绑定动态添加Item
            observableListBottom.add(itemViewModel);
        }
    }

    /**
     * 初始化Toolbar
     */
    public void initToolbar() {
        //初始化标题栏
        setRightTextVisible(View.GONE);
        setRightIconVisible(View.VISIBLE);
        setTitleText("支付");
    }

    public BindingCommand balanceClickCommand = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            startContainerActivity(WalletFragment.class.getCanonicalName());
        }
    });

    public BindingCommand daiClickCommand = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            model.saveDai(observableListTop.size() != 8);
            initTop(observableListTop.size() != 8);
        }
    });

    private void initTop(boolean hasDai) {
        List<PayItem> list = new ArrayList<>();
        for (int i = 0; i < (!hasDai ? resourceTop0.length : resourceTop1.length); i++) {
            list.add(new PayItem(!hasDai ? resourceTop0[i] : resourceTop1[i], !hasDai ? nameTop0[i] : nameTop1[i]));
        }
        observableListTop.clear();
        for (PayItem entity : list) {
            PayItemViewModel itemViewModel = new PayItemViewModel(this, entity);
            //双向绑定动态添加Item
            observableListTop.add(itemViewModel);
        }
    }

    public ObservableList<PayItemViewModel> observableListTop = new ObservableArrayList<>();
    public ObservableList<PayItemViewModel> observableListBottom = new ObservableArrayList<>();
    //给RecyclerView添加ItemBinding
    public ItemBinding<PayItemViewModel> itemBinding = ItemBinding.of(com.goldze.mvvmhabit.BR.viewModel, R.layout.item_pay);

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
