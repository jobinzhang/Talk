package com.example.factory.presenter.search;

import android.os.Handler;
import android.os.Looper;

import com.example.factory.data.DataSource;
import com.example.factory.data.helper.UserHelper;
import com.example.factory.model.card.UserCard;
import com.example.factory.presenter.BasePresenter;

import java.util.List;

import retrofit2.Call;

public class SearchUserPresenter extends BasePresenter<SearchContract.UserView> implements SearchContract.Presenter, DataSource.Callback<List<UserCard>> {

    private Call searchCall;
    private Handler handler = new Handler(Looper.getMainLooper());

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
        // 网络请求需要在子线程
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
    public void onDataLoaded(final List<UserCard> userCards) {
        final SearchContract.UserView view = getView();
        // 切换回主线程
        handler.post(new Runnable() {
            @Override
            public void run() {
                view.onSearchDone(userCards);
            }
        });

    }
}
