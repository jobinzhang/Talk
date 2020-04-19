package com.example.factory.presenter.contact;

import com.example.factory.model.card.UserCard;
import com.example.factory.presenter.BaseContract;

public interface PersonContract {

    interface Presenter extends BaseContract.Presenter {
        UserCard getUser(int uid);

    }

    interface View extends BaseContract.View<Presenter> {

        void onDataLoaded(UserCard userCard);
    }
}
