package com.example.factory.presenter.contact;

import android.os.Handler;
import android.os.Looper;

import com.example.factory.data.DataSource;
import com.example.factory.data.helper.UserHelper;
import com.example.factory.model.card.UserCard;
import com.example.factory.presenter.BasePresenter;

import java.util.List;

public class ContactPresenter extends BasePresenter<ContactContract.View> implements ContactContract.Presenter, DataSource.Callback<List<UserCard>> {

    private Handler handler = new Handler(Looper.getMainLooper());

    public ContactPresenter(ContactContract.View view) {
        super(view);
    }

    @Override
    public void getUserContact(int userId) {
        UserHelper.userContact(userId, this);
    }

    @Override
    public void onDataLoaded(final List<UserCard> userCards) {
        final ContactContract.View view = getView();
        handler.post(new Runnable() {
            @Override
            public void run() {
                view.onDataLoaded(userCards);
            }
        });
    }

    @Override
    public void onDataNotAvailable(final int strRes) {
        final ContactContract.View view = getView();
        handler.post(new Runnable() {
            @Override
            public void run() {
                view.showError(strRes);
            }
        });
    }
}
