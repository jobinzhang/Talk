package com.example.talk.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.common.app.PresenterToolbarActivity;
import com.example.common.widget.PortraitView;
import com.example.factory.model.card.UserCard;
import com.example.factory.presenter.contact.PersonContract;
import com.example.factory.presenter.contact.PersonPresenter;
import com.example.talk.R;

import net.qiujuer.genius.ui.widget.Button;

import butterknife.BindView;

public class PersonalActivity extends PresenterToolbarActivity<PersonContract.Presenter> implements PersonContract.View {
    private static String UID = "uid";
    private int uid;

    @BindView(R.id.im_header)
    ImageView mHeader;
    @BindView(R.id.im_portrait)
    PortraitView mPortrait;
    @BindView(R.id.txt_name)
    TextView mName;
    @BindView(R.id.txt_desc)
    TextView mDesc;
    @BindView(R.id.txt_follows)
    TextView mFollows;
    @BindView(R.id.txt_following)
    TextView mFollowing;
    @BindView(R.id.btn_say_hello)
    Button mSayHello;

    public static void show(Context context, int uid) {
        Intent intent = new Intent(context, PersonalActivity.class);
        intent.putExtra(UID, uid);
        context.startActivity(intent);
    }

    @Override
    protected boolean initArgs(Bundle bundle) {
        uid = bundle.getInt(UID);
        return uid == 0 ? false : true;
    }

    @Override
    protected void initData() {
        super.initData();
        mPresenter.getUser(uid);
    }

    @Override
    protected PersonContract.Presenter initPresenter() {
        return new PersonPresenter(this);
    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_personal;
    }


    @Override
    public void onDataLoaded(UserCard userCard) {
        mName.setText(userCard.getName());
        mDesc.setText(userCard.getDesc());
        //mFollows.setText(String.valueOf(userCard.getFollows()));
        mFollows.setText(String.format(getString(R.string.label_follows), userCard.getFollows()+""));
        mFollowing.setText(String.format(getString(R.string.label_following), userCard.getFollowing()+""));
        //mFollowing.setText(String.valueOf(userCard.getFollowing()));
    }
}
