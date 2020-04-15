package com.example.factory.presenter.contact;

import com.example.factory.model.card.UserCard;
import com.example.factory.presenter.BaseContract;

/**
 * 关注的契约
 */
public interface FollowContract {
    interface Presenter extends BaseContract.Presenter {
        // 关注
        void follow(int uid);
    }

    interface View extends BaseContract.View<Presenter> {
        // 关注成功
        void onFollowSucceed(UserCard userCard);
    }
}
