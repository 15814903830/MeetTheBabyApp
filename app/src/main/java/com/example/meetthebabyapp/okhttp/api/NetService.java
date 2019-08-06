package com.example.meetthebabyapp.okhttp.api;

import com.example.meetthebabyapp.okhttp.base.RegisterBase;

import java.util.Map;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by YSL on 2016/8/3 0003.
 */
public interface NetService {

    @POST("login")
    @FormUrlEncoded
    Observable<RegisterBase> GetLogin(@FieldMap Map<String, String> params);
}
