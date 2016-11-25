package com.example.administrator.myapplication.baseutils.utils;

import java.lang.reflect.ParameterizedType;

/**
 * Created by Administrator on 2016/11/24.
 */

public class InstanceUtil {

    /**
     * 通过实例工厂去实例化相应类
     *
     * @param o   带泛型的对象
     * @param i   需要实例化的对象在泛型中的位置
     * @param <T> 返回实例的泛型类型
     * @return
     */

    public static <T> T getInstance(Object o, int i) {
        if(o.getClass().getGenericSuperclass() instanceof ParameterizedType){
            Class mClass= (Class<T>) ((ParameterizedType) o.getClass().getGenericSuperclass()).getActualTypeArguments()[i];
            return getInstance(mClass);
        }
        return  null;
    }

    /**
     * 通过实例工厂去实例化相应类
     *
     * @param <T> 返回实例的泛型类型
     * @return
     */

    public static <T> T getInstance(Class clazz) {
        try{
            return  (T) InstanceFactory.create(clazz);

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;
    }
}
