package com.example.talk.frags.main;


import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.common.app.PresenterFragment;
import com.example.common.widget.EmptyView;
import com.example.common.widget.PortraitView;
import com.example.common.widget.recycler.RecyclerAdapter;
import com.example.factory.model.card.UserCard;
import com.example.factory.presenter.contact.ContactContract;
import com.example.factory.presenter.contact.ContactPresenter;
import com.example.talk.R;

import java.util.List;

import butterknife.BindView;

public class ContactFragment extends PresenterFragment<ContactContract.Presenter> implements ContactContract.View {

    @BindView(R.id.empty)
    EmptyView emptyView;
    @BindView(R.id.recycler)
    RecyclerView recyclerView;
    private RecyclerAdapter<UserCard> userCardRecyclerAdapter;

    public ContactFragment() {
    }

    @Override
    protected void initWidget(View root) {
        super.initWidget(root);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        userCardRecyclerAdapter = new RecyclerAdapter<UserCard>() {
            @Override
            protected int getItemViewType(int position, UserCard userCard) {
                return R.layout.cell_contact_list;
            }
            @Override
            protected ViewHolder<UserCard> onCreateViewHolder(View root, int viewType) {
                return new ContactFragment.ViewHolder(root);
            }
        };
        recyclerView.setAdapter(userCardRecyclerAdapter);
    }

    @Override
    protected void initData() {
        super.initData();
        // 网络获取联系人
        mPresenter.getUserContact(1);
    }

    class ViewHolder extends RecyclerAdapter.ViewHolder<UserCard>{
        @BindView(R.id.im_portrait)
        PortraitView mPortraitView;
        @BindView(R.id.txt_name)
        TextView mName;
        @BindView(R.id.txt_desc)
        TextView mdesc;
        @BindView(R.id.im_message)
        ImageView mMessage;

        public ViewHolder(View itemView) {
            super(itemView);
        }

        @Override
        protected void onBind(UserCard userCard) {
            mName.setText(userCard.getName());
            mdesc.setText(userCard.getDesc());
        }
    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.fragment_contact;
    }

    @Override
    protected ContactPresenter initPresenter() {
        return new ContactPresenter(this);
    }

    @Override
    public void onDataLoaded(List<UserCard> userCards) {
        userCardRecyclerAdapter.replace(userCards);
        userCardRecyclerAdapter.notifyDataSetChanged();
    }


}
