package com.goldze.mvvmhabit.ui.base;

import android.app.Activity;
import android.app.Dialog;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;

import com.goldze.mvvmhabit.R;
import com.goldze.mvvmhabit.utils.BaseViewUtils;

/**
 * 底部弹出dialog
 *
 * @author zy
 */
public class BaseDialog extends Dialog {

    private Activity context;

    public BaseDialog(Activity context) {
        this(context, Gravity.BOTTOM);
    }

    public BaseDialog(Activity context, int gravity) {
        super(context, R.style.bottom_dialog);
        this.context = context;
        Window window = this.getWindow();
        window.setGravity(gravity);
        window.setWindowAnimations(R.style.popMenuAnimation);
        this.setCanceledOnTouchOutside(true);
    }

    @Override
    public void setContentView(View view) {
        LayoutParams params = getWindow().getAttributes();
        params.height = LayoutParams.WRAP_CONTENT;
        params.width = BaseViewUtils.getWindowsWidth(context);
        getWindow().setAttributes(params);
        super.setContentView(view, params);
    }

    private void setFullContentView(View view) {
        LayoutParams params = getWindow().getAttributes();
        params.height = BaseViewUtils.getWindowsHeight(context);
        params.width = BaseViewUtils.getWindowsWidth(context);
        getWindow().setAttributes(params);
        super.setContentView(view, params);
    }

    public void show(View contentView) {
        show();
        setContentView(contentView);
    }

    public void showFullScreen(View contentView) {
        show();
        setFullContentView(contentView);
    }

}
