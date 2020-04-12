package com.example.factory.presenter.search;

import com.example.factory.data.DataSource;
import com.example.factory.data.helper.UserHelper;
import com.example.factory.model.card.UserCard;
import com.example.factory.presenter.BasePresenter;

import java.util.List;

import retrofit2.Call;

public class SearchUserPresenter extends BasePresenter<SearchContract.UserView> implements SearchContract.Presenter, DataSource.Callback<List<UserCard>> {

    private Call searchCall;

    public SearchUserPresenter(SearchContract.UserView view) {
        super(view);
    }

    @Override
    public void search(final String content) {
        start();
        final DataSource.Callback callback = this;
        Call call = searchCall;
        if (call != null && !call.isCanceled()) {
            // 防止重复提交搜索，如果上一次搜索还没结束，直接取消
            call.cancel();
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                searchCall = UserHelper.search(content, callback);
            }
        }).start();
    }



    @Override
    public void onDataNotAvailable(int strRes) {

    }

    @Override
    public void onDataLoaded(List<UserCard> userCards) {
        SearchContract.UserView view = getView();
        view.onSearchDone(userCards);
    }
}
