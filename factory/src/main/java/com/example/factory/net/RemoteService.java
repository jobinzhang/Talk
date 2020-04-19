package com.example.factory.net;

import com.example.factory.model.api.RspModel;
import com.example.factory.model.api.account.RegisterModel;
import com.example.factory.model.api.user.UserUpdateModel;
import com.example.factory.model.card.UserCard;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * 网络请求的所有的接口
 *
 * @author qiujuer Email:qiujuer@live.cn
 * @version 1.0.0
 */
public interface RemoteService {

    /**
     * 注册接口
     *
     * @param model 传入的是RegisterModel
     * @return 返回的是RspModel<AccountRspModel>
     */
    @POST("account/register")
    Call<RspModel<UserCard>> accountRegister(@Body RegisterModel model);

    /**
     * 登录接口
     *
     * @return RspModel<AccountRspModel>
     */
    //@POST("account/login")
    //Call<RspModel<AccountRspModel>> accountLogin(@Body LoginModel model);

    @GET("user/login/{username}/{password}")
    Call<RspModel<UserCard>> accountLogin(@Path("username") String username, @Path("password") String password);

    /**
     * 绑定设备Id
     *
     * @param pushId 设备Id
     * @return RspModel<AccountRspModel>
     */
    @POST("account/bind/{pushId}")
    Call<RspModel<UserCard>> accountBind(@Path(encoded = true, value = "pushId") String pushId);

    // 用户更新的接口
    @POST("user")
    Call<RspModel<UserCard>> userUpdate(@Body UserUpdateModel model);

    @GET("user/search/{name}")
    Call<RspModel<List<UserCard>>> userSearch(@Path("name") String name);

    @PUT("user/follow/{uid}")
    Call<RspModel<UserCard>> userFollow(@Path("uid") int uid);

    // 获取用户关注的联系人接口
    @GET("user/contact/{uid}")
    Call<RspModel<List<UserCard>>> userContact(@Path("uid") int uid);

    @GET("user/{uid}")
    Call<RspModel<UserCard>> getUser(@Path("uid") int uid);
}
