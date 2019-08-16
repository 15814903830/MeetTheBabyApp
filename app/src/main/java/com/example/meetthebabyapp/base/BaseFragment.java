package com.example.meetthebabyapp.base;

import android.os.Bundle;

import com.example.meetthebabyapp.util.MyToastUtil;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class BaseFragment extends Fragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void showShortTip(String tip) {
        MyToastUtil.showShortToast(getContext(), tip);
    }

    public void showLongTip(String tip) {
        MyToastUtil.showLongToast(getContext(), tip);
    }

}
