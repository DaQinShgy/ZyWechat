package com.goldze.mvvmhabit.ui.bank;

import android.app.Application;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;
import android.support.annotation.NonNull;
import android.view.View;

import com.goldze.mvvmhabit.BR;
import com.goldze.mvvmhabit.R;
import com.goldze.mvvmhabit.data.DemoRepository;
import com.goldze.mvvmhabit.entity.BankCard;
import com.goldze.mvvmhabit.ui.base.viewmodel.ToolbarViewModel;

import java.util.List;

import me.goldze.mvvmhabit.base.MultiItemViewModel;
import me.tatarka.bindingcollectionadapter2.ItemBinding;
import me.tatarka.bindingcollectionadapter2.OnItemBind;

public class BankViewModel extends ToolbarViewModel<DemoRepository> {

    private static final String MultiRecycleType_0 = "0";
    private static final String MultiRecycleType_1 = "1";
    private static final String MultiRecycleType_2 = "2";

    public BankViewModel(@NonNull Application application, DemoRepository repository) {
        super(application, repository);
        List<BankCard> bankCards = model.getAllBankCard();
        for (BankCard card : bankCards) {
            MultiItemViewModel item = new Type0ViewModel(this, card);
            item.multiItemType(MultiRecycleType_0);
            observableList.add(item);
        }
        MultiItemViewModel item1 = new Type1ViewModel(this);
        item1.multiItemType(MultiRecycleType_1);
        observableList.add(item1);
        MultiItemViewModel item2 = new Type2ViewModel(this);
        item2.multiItemType(MultiRecycleType_2);
        observableList.add(item2);
    }

    /**
     * 初始化Toolbar
     */
    public void initToolbar() {
        //初始化标题栏
        setRightTextVisible(View.GONE);
        setRightIconVisible(View.GONE);
        setTitleText("银行卡");
    }

    public ObservableList<MultiItemViewModel> observableList = new ObservableArrayList<>();
    //RecyclerView多布局添加ItemBinding
    public ItemBinding<MultiItemViewModel> itemBinding = ItemBinding.of(new OnItemBind<MultiItemViewModel>() {
        @Override
        public void onItemBind(ItemBinding itemBinding, int position, MultiItemViewModel item) {
            //通过item的类型, 动态设置Item加载的布局
            String itemType = (String) item.getItemType();
            if (MultiRecycleType_0.equals(itemType)) {
                itemBinding.set(BR.viewModel, R.layout.item_bank0);
            } else if (MultiRecycleType_1.equals(itemType)) {
                itemBinding.set(BR.viewModel, R.layout.item_bank1);
            } else if (MultiRecycleType_2.equals(itemType)) {
                itemBinding.set(BR.viewModel, R.layout.item_bank2);
            }
        }
    });
}
