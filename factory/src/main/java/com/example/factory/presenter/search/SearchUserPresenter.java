package com.example.factory.presenter.search;

import com.example.factory.presenter.BasePresenter;

public class SearchUserPresenter extends BasePresenter<SearchContract.UserView> implements SearchContract.Presenter {

    public SearchUserPresenter(SearchContract.UserView view) {
        super(view);
    }

    @Override
    public void search(String content) {

    }
}
