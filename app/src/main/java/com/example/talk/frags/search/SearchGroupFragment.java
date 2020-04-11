package com.example.talk.frags.search;

import com.example.common.app.BaseFragment;
import com.example.talk.R;
import com.example.talk.activities.SearchActivity;

/**
 * 搜索群
 */
public class SearchGroupFragment extends BaseFragment implements SearchActivity.SearchFragment {

    public SearchGroupFragment() {
        // Required empty public constructor
    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.fragment_search_group;
    }

    @Override
    public void search(String content) {

    }
}
