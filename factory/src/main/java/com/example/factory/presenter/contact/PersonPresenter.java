package com.example.factory.presenter.contact;

import com.example.factory.data.DataSource;
import com.example.factory.data.helper.UserHelper;
import com.example.factory.model.card.UserCard;
import com.example.factory.presenter.BasePresenter;

import net.qiujuer.genius.kit.handler.Run;
import net.qiujuer.genius.kit.handler.runable.Action;

public class PersonPresenter extends BasePresenter<PersonContract.View> implements PersonContract.Presenter, DataSource.Callback<UserCard> {

    public PersonPresenter(PersonContract.View view) {
        super(view);
    }

    @Override
    public UserCard getUser(int uid) {
        UserHelper.getUser(uid, this);
        return null;
    }

    @Override
    public void onDataLoaded(final UserCard userCard) {
        final PersonContract.View view = getView();
        Run.onUiAsync(new Action() {
            @Override
            public void call() {
                view.onDataLoaded(userCard);
            }
        });
    }

    @Override
    public void onDataNotAvailable(final int strRes) {
        final PersonContract.View view = getView();
        Run.onUiAsync(new Action() {
            @Override
            public void call() {
                view.showError(strRes);
            }
        });
    }
}
