package com.example.library;

import android.support.annotation.NonNull;

/**
 * Created by Administrator on 2016/11/22.
 */

public interface FlatTypeAdapter {


    @NonNull Class onFlattenClass(@NonNull Item item);

    @NonNull Item onFlattenItem(@NonNull final  Item item);


}
