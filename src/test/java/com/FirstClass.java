package com;

/**
 * Created by zhangwei on 2017/11/19.
 */
public class FirstClass {

    public static void main(String[] str){
        int i =1;
        for(;;){
            System.out.println(i++);
            try {

                Thread.sleep(10000L);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

//        System.out.println();
//        System.out.println();
    }

    private static void test1(){
        System.out.println("张易琳 哈  哈  哈  哈  哈");
        System.out.println();
        System.out.println();
        int i = 3 + 8;

        System.out.println("3 + 8 = " + i);

        System.out.println();
        System.out.println();
    }

}
