package com.example.chapter3.homework;


import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.LottieAnimationView;

import java.util.ArrayList;

public class PlaceholderFragment extends Fragment {

    public RecyclerView mRecyclerView;
    private ArrayList<FriendsEntity> friendsEntitylist = new ArrayList<FriendsEntity>();
    private RecyclerAdapter mRecyclerAdapter;

    //懒加载方法，使得fragment不再预加载相邻页
    private boolean isVisible;
    private boolean isPrepared;

    public static final String TAG = "PlaceholderFragment";


    @Nullable  //可为空
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_placeholder, container, false);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.my_rv);
        mRecyclerAdapter = new RecyclerAdapter(getActivity(),friendsEntitylist);
        mRecyclerView.setAdapter(mRecyclerAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));

//        initRecyclerView();
        initFriends();
        //使得懒加载在初始化操作完成之后再执行
//        isPrepared = true;
//        lazyload();
        // TODO ex3-3: 修改 fragment_placeholder，添加 loading 控件和列表视图控件
        return view;
    }

    private void initFriends(){
        //这里简单生成20个好友的列表用以展示
        //好友头像直接用了系统自带的图标文件，实际也可设置
        for (int i=1; i<=20; i++){
            FriendsEntity friendsEntity = new FriendsEntity();
            friendsEntity.setFriendName("好友"+ i);
            friendsEntity.setChatContent("第"+ i +"句");
            friendsEntitylist.add(friendsEntity);
        }
    }

//    private void initRecyclerView(){
//        mRecyclerView = (RecyclerView) getView().findViewById(R.id.my_rv);
//        mRecyclerAdapter = new RecyclerAdapter(getActivity(),friendsEntitylist);
//        mRecyclerView.setAdapter(mRecyclerAdapter);
//        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
//
//    }



    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        final RecyclerView rv = getActivity().findViewById(R.id.my_rv);
        final LottieAnimationView mloading_animation = getActivity().findViewById(R.id.loading_animation);

        mloading_animation.setVisibility(View.VISIBLE);
        rv.setVisibility(View.INVISIBLE);



        getView().postDelayed(new Runnable() {
            @Override
            public void run() {
                // 这里会在 5s 后执行
                // TODO ex3-4：实现动画，将 lottie 控件淡出，列表数据淡入

                mloading_animation.startAnimation(AnimationUtils.loadAnimation(getActivity().getApplicationContext(),R.anim.fade_out));
                mloading_animation.setVisibility(View.INVISIBLE);
                rv.startAnimation(AnimationUtils.loadAnimation(getActivity().getApplicationContext(),R.anim.fade_in));
                rv.setVisibility(View.VISIBLE);

            }
        }, 5000);
    }

//    //懒加载方法，使得fragment不再预加载相邻页
//    @Override
//    public void setUserVisibleHint(boolean isVisibleToUser){
//        super.setUserVisibleHint(isVisibleToUser);
//        if(getUserVisibleHint()){
//            isVisible = true;
//            onVisible();
//        } else {
//            isVisible = false;
//            onInvisible();
//        }
//    }
//
//    private void onVisible(){
//        lazyload();
//    }
//
//    private void onInvisible(){ }
//
//    private void lazyload(){
//        //仅在初始化完成并且fragment可见时才继续加载
//        Log.d(TAG,"isPrepared:"+isPrepared+", isVisible:"+isVisible);
//        if (!isPrepared || !isVisible){
//            return;
//        }
//
//        final RecyclerView rv = getActivity().findViewById(R.id.my_rv);
//        final LottieAnimationView mloading_animation = getActivity().findViewById(R.id.loading_animation);
//
//        mloading_animation.setVisibility(View.VISIBLE);
//        rv.setVisibility(View.INVISIBLE);
//        getView().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                // 这里会在 5s 后执行
//                // TODO ex3-4：实现动画，将 lottie 控件淡出，列表数据淡入
//                mloading_animation.startAnimation(AnimationUtils.loadAnimation(getActivity().getApplicationContext(),R.anim.fade_out));
//                mloading_animation.setVisibility(View.INVISIBLE);
//                rv.startAnimation(AnimationUtils.loadAnimation(getActivity().getApplicationContext(),R.anim.fade_in));
//                rv.setVisibility(View.VISIBLE);
//                Log.d(TAG,"执行成功");
//
//            }
//        }, 5000);
//
//    }
//
}
