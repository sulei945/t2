package com;

/**
 * Created by zhangwei on 2018/1/4.
 */
public class Test {
    public synchronized void test1(){

    }

    public void test2(){
        synchronized (this){

        }
    }
}
