package com.garroid.androidadvancejava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;

public class RxJavaActivity extends AppCompatActivity {

    private final String TAG = "RxJavaActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_java);

        Observer<String> observer = new Observer<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                Log.d(TAG, "onSubscribe");
            }

            @Override
            public void onNext(@NonNull String s) {
                Log.d(TAG, "onNext"+s);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.d(TAG, "onError");
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "onComplete");
            }
        };


        Observable observable = Observable.create(new ObservableOnSubscribe<String>() {

            @Override
            public void subscribe(@NonNull ObservableEmitter<String> emitter) throws Throwable {
                emitter.onNext("No.1");
                emitter.onNext("No.2");
                emitter.onComplete();
            }
        });

        // 另一种create方法
        Observable observable2 = Observable.just("No.3","No.4");

        observable2.subscribe(observer);


        // interval 间隔定时器 每隔3秒发射（一直运行）
        Observable.interval(3, TimeUnit.SECONDS)
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Throwable {
                        Log.d(TAG, "interval: "+aLong.intValue());
                    }
                });

        // [0,5) 运行4次
        Observable.range(0, 5)
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Throwable {
                        Log.d(TAG, "range: "+integer.intValue());
                    }
                });


        // 如果要重复几次上面这个循环
        Observable.range(0, 5).repeat(1)
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Throwable {
                        Log.d(TAG, "range: "+integer.intValue());
                    }
                });

    }


}