package com.yichen.mmq.base;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.yichen.mmq.App;
import com.yichen.mmq.R;
import com.yichen.mmq.dagger2.component.ActivityComponent;
import com.yichen.mmq.dagger2.component.DaggerActivityComponent;
import com.yichen.mmq.utils.Translucent;
import com.yichen.mmq.utils.UIUtils;
import com.yichen.mmq.widget.CustomDialog;

import butterknife.ButterKnife;

public abstract class BaseActivity< V extends BaseView, T extends BasePresenter<V>> extends AppCompatActivity {

    protected boolean  isShow;



    //是否需要依赖注入 默认开启
    protected boolean isNeedInject=true;
    protected T mPresenter;
    private CustomDialog mDialogWaiting;


    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       // MyApp.activities.add(this);
        initBeforeContentView();
        if(isNeedInject){
            inject();
        }
        //听过可以解决过度渲染
        getWindow().setBackgroundDrawable(null);
        //判断是否使用MVP模式
        mPresenter = createPresenter();
        if (mPresenter != null) {
            mPresenter.attachView((V) this);//因为之后所有的子类都要实现对应的View接口
        }

        //子类不再需要设置布局ID，也不再需要使用ButterKnife.bind()
        setContentView(provideContentViewId());
        ButterKnife.bind(this);

       //沉浸式
        Translucent.setStatusColor(this, UIUtils.getColor(R.color.colorPrimaryDark), 10);


        //虚拟导航颜色

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            Translucent.setNavigateColor(this, UIUtils.getColor(R.color.colorPrimaryDark), 10);
        }

        initView();
        initData();
        initListener();
    }

    public ActivityComponent getBuild() {
        return build;
    }

    public void setBuild(ActivityComponent build) {
        this.build = build;
    }

    // 提供依赖注入
   protected ActivityComponent build;
    private void inject() {
       build = DaggerActivityComponent.builder().appComponent(getApp()
                .getAppComponent())
                .build();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }


    public void initBeforeContentView() {
    }

    public void initView() {
    }

    public void initData() {
    }

    public void initListener() {
    }

    //用于创建Presenter和判断是否使用MVP模式(由子类实现)
    protected abstract T createPresenter();

    //得到当前界面的布局文件id(由子类实现)
    protected abstract int provideContentViewId();


    /**
     * 显示等待提示框
     */
    public Dialog showWaitingDialog(String tip) {
        hideWaitingDialog();
        View view = View.inflate(this, R.layout.dialog_waiting, null);
        if (!TextUtils.isEmpty(tip))
            ((TextView) view.findViewById(R.id.tvTip)).setText(tip);
        mDialogWaiting = new CustomDialog(this, view, R.style.MyDialog);
        mDialogWaiting.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                BaseActivity.this.onCancel();
            }
        });
        mDialogWaiting.show();
        mDialogWaiting.setCancelable(true);
        isShow=true;
        return mDialogWaiting;
    }

    /**
     *  当对话框 取消是回调
     */
    public void onCancel() {

    }

    /**
     * 隐藏等待提示框
     */
    public void hideWaitingDialog() {
        if (mDialogWaiting != null) {
            mDialogWaiting.dismiss();
            isShow=false;
            mDialogWaiting = null;
        }
    }



    public void jumpToActivity(Intent intent, boolean isFinish) {

        startActivity(intent);
        if(isFinish)finish();

    }

    public void jumpToActivity(Class activity,boolean isFinish) {
        Intent intent = new Intent(this, activity);
       jumpToActivity(intent,isFinish);
    }


    public void jumpToActivityAndClearTask(Class activity) {
        Intent intent = new Intent(this, activity);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }

    public void jumpToActivityAndClearTop(Class activity,boolean isFinish) {
        Intent intent = new Intent(this, activity);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        jumpToActivity(intent,isFinish);
    }
  public void jumpToActivityForResult(Class activity,boolean isFinish,int requestCode) {
        Intent intent = new Intent(this, activity);

        startActivityForResult(intent,requestCode);
    }

    @Override
    public void onBackPressed() {
        Log.e("tt", "onBackPressed: 1" );
        if(isShow){
            Log.e("tt", "onBackPressed: " );
            hideWaitingDialog();
            return ;
        }

        super.onBackPressed();
    }

    public App getApp(){
        return (App)getApplicationContext();
    }
}
