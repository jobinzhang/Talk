package com.example.factory.presenter.account;


import com.example.factory.presenter.BaseContract;

/**
 * @author qiujuer Email:qiujuer@live.cn
 * @version 1.0.0
 */
public interface LoginContract {
    interface View extends BaseContract.View<Presenter> {
        // 登录成功
        void loginSuccess();
    }


    interface Presenter extends BaseContract.Presenter {
        // 发起一个登录
        void login(String phone, String password);
    }

}
