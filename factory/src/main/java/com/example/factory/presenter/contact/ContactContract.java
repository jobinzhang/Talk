package com.example.factory.presenter.contact;

import com.example.factory.model.card.UserCard;
import com.example.factory.presenter.BaseContract;

import java.util.List;

/**
 * 联系人契约
 */
public interface ContactContract {

    interface Presenter extends BaseContract.Presenter {
        // 获取用户id下关注的联系人
        void getUserContact(int userId);
    }

    interface View extends BaseContract.View<Presenter> {

        void onDataLoaded(List<UserCard> userCards);
    }
}
