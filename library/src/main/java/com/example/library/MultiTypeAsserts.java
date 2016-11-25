package com.example.library;

import android.support.annotation.NonNull;

import java.util.List;

/**
 * Created by Administrator on 2016/11/23.
 */

public class MultiTypeAsserts {

    private MultiTypeAsserts(){
        throw new AssertionError();
    }


    public static  void assertAllRegistered(@NonNull MultiTypeAdapter adapter,@NonNull List<? extends Item> items)
    throws ProviderNotFoundException,IllegalArgumentException,IllegalAccessError{

        if (items.size() == 0) {
            throw new IllegalArgumentException("Your Items/List is empty.");
        }


    }
}
