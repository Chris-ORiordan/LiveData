package com.example.standard.livedata;

import android.app.Application;
import android.arch.lifecycle.*;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.util.Log;

import java.util.*;

public class MainActivityViewModel extends AndroidViewModel {

    private String TAG = MainActivityViewModel.class.getSimpleName();

    private MutableLiveData<List<String>> fruitList;

    LiveData<List<String>> getFruitList() {
        if(fruitList == null){
            fruitList = new MutableLiveData<>();
            loadFruits();
        }
        return fruitList;
    }

    private void loadFruits() {
        Handler handler = new Handler();
        handler.postDelayed(() -> {
            List<String> fruit = new ArrayList<>();
            fruit.add("Apple");
            fruit.add("Mango");
            fruit.add("Peach");
            fruit.add("Banana");
            fruit.add("Orange");
            long seed = System.nanoTime();
            Collections.shuffle(fruit, new Random(seed));
            fruitList.setValue(fruit);
        }, 5000);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.d(TAG, "on cleared called");
    }

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
    }
}
