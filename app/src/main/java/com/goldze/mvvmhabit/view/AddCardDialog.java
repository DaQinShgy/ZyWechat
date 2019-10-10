package com.goldze.mvvmhabit.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.goldze.mvvmhabit.R;
import com.goldze.mvvmhabit.entity.BankCard;

import me.goldze.mvvmhabit.utils.ToastUtils;

/**
 * Author: zy
 * Date: 2019/5/29 14:19
 * Description:
 */
public class AddCardDialog extends Dialog {

    public interface DialogCallBack {
        void onSuccess(BankCard bankCard);
    }

    private DialogCallBack mCallBack;

    public AddCardDialog(Context context, DialogCallBack callBack) {
        super(context, R.style.dialog);
        this.mCallBack = callBack;
    }

    private EditText etName;
    private EditText etNo;
    private RadioGroup rg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_add_card);
        setCancelable(true);
        setCanceledOnTouchOutside(true);

        etName = findViewById(R.id.et_bankName);
        etNo = findViewById(R.id.et_bankNo);
        rg = findViewById(R.id.rg);

        findViewById(R.id.btn_add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString().trim();
                String no = etNo.getText().toString().trim();
                if (TextUtils.isEmpty(name) || TextUtils.isEmpty(no)) {
                    ToastUtils.showShort("信息不全");
                    return;
                }
                BankCard bankCard = new BankCard();
                bankCard.setName(name);
                bankCard.setNo("****  ****  ****  " + no);
                bankCard.setType(((RadioButton) rg.findViewById(rg.getCheckedRadioButtonId())).getText().toString());
                int resourceId0 = 0;
                int resourceId1 = 0;
                int resourceId2 = 0;
                if (name.contains("农业银行")) {
                    resourceId0 = R.mipmap.ic_ny0;
                    resourceId1 = R.mipmap.ic_ny1;
                    // resourceId2 = R.mipmap.ic_ny2;
                } else if (name.contains("工商银行")) {
                    resourceId0 = R.mipmap.ic_gs0;
                    resourceId1 = R.mipmap.ic_gs1;
                    resourceId2 = R.mipmap.ic_gs2;
                } else if (name.contains("光大银行")) {
                    resourceId0 = R.mipmap.ic_gd0;
                    resourceId1 = R.mipmap.ic_gd1;
                    resourceId2 = R.mipmap.ic_gd2;
                } else if (name.contains("广发银行")) {
                    resourceId0 = R.mipmap.ic_gf0;
                    resourceId1 = R.mipmap.ic_gf1;
                    resourceId2 = R.mipmap.ic_gf2;
                } else if (name.contains("华夏银行")) {
                    resourceId0 = R.mipmap.ic_hx0;
                    resourceId1 = R.mipmap.ic_hx1;
                    resourceId2 = R.mipmap.ic_hx2;
                } else if (name.contains("交通银行")) {
                    resourceId0 = R.mipmap.ic_jt0;
                    resourceId1 = R.mipmap.ic_jt1;
                    resourceId2 = R.mipmap.ic_jt2;
                } else if (name.contains("浦发银行")) {
                    resourceId0 = R.mipmap.ic_pf0;
                    resourceId1 = R.mipmap.ic_pf1;
                    resourceId2 = R.mipmap.ic_pf2;
                } else if (name.contains("兴业银行")) {
                    resourceId0 = R.mipmap.ic_xy0;
                    resourceId1 = R.mipmap.ic_xy1;
                    resourceId2 = R.mipmap.ic_xy2;
                } else if (name.contains("邮储银行")) {
                    resourceId0 = R.mipmap.ic_yc0;
                    resourceId1 = R.mipmap.ic_yc1;
                    resourceId2 = R.mipmap.ic_yc2;
                } else if (name.contains("招商银行")) {
                    resourceId0 = R.mipmap.ic_zs0;
                    resourceId1 = R.mipmap.ic_zs1;
                    resourceId2 = R.mipmap.ic_zs2;
                } else if (name.contains("建设银行")) {
                    resourceId0 = R.mipmap.ic_js0;
                    resourceId1 = R.mipmap.ic_js1;
                    resourceId2 = R.mipmap.ic_js2;
                } else if (name.contains("民生银行")) {
                    resourceId0 = R.mipmap.ic_ms0;
                    resourceId1 = R.mipmap.ic_ms1;
                    resourceId2 = R.mipmap.ic_ms2;
                } else if (name.contains("中国银行")) {
                    resourceId0 = R.mipmap.ic_zg0;
                    resourceId1 = R.mipmap.ic_zg1;
                    resourceId2 = R.mipmap.ic_zg2;
                } else if (name.contains("中信银行")) {
                    resourceId0 = R.mipmap.ic_zx0;
                    resourceId1 = R.mipmap.ic_zx1;
                    resourceId2 = R.mipmap.ic_zx2;
                }
                bankCard.setDrawable0(resourceId0);
                bankCard.setDrawable1(resourceId1);
                bankCard.setDrawable2(resourceId2);
                mCallBack.onSuccess(bankCard);
                dismiss();
            }
        });
    }
}
