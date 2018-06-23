package com.link;

import java.util.*;

/**
 * Created by zhangwei on 2018/5/15.
 * input int：表示返回都页数，每页间用一条空""做间隔
 * input String[]:每条数据由类似 "N，N，N，S"的字符串，是类似一种统计，如 "服务编号，xxx，分数，地址"的统计
 *                其中N是int型，S是字符串型。其中第一个N有重复。
 * output String[]：返回的数据集
 *                      1.其中会按照输入的页数到达num条后插入一条""数据
 *                      2.返回的顺序是先找出第一个N的不重复数据，如果有重复取最前面的数据，
 *                          取完之后，再从剩下的数据里继续取第一个N的不重复数据，一直到取完数据。
 */
public class UniqueResults {

    private static String SEP = "";

    public static void main(String[] s){
        paginate(5, new String[]{
                "1,1fsagsgsgdsafds",
                "2,2fdsfjeioiowhdkf",
                "3,3fjdsgioehgiorenfk",
                "4,4fjdsakogheiofwfw",
                "2,5sjfiowefjioewfjfwkl",
                "4,6jfklds;ajfkljkflfjdksl",
                "7,7fjdkla;fjkwl;ffdsa",
                "5,8fjdsakl;fjsakl;fjdskla;",
                "3,9fjiowfioajskfl;dsajkfl;sa",
                "9,10jfkldsajiogewahiofhkl",
                "6,11fjkdsaljfklsa;fjsfdsa",
                "5,12fjdskal;fjksald;jfkldsa;",
                "2,13fjdskal;fjkla;sjfkl;afdsa",
                "1,14fjkdsla;fjkldsajfksla;jfkl"
        });//12347,24539,6521
    }


    /**
     * 循环数组的每个元素，
     * 如果不重复，放在返回列表里
     * 如果已重复，放在临时链表里
     * 每次循环时先从临时链表里拿，因为临时链表里的数据是上一页遗留下来的重复数据，当前页面的时候优先从这里拿
     *      链表每次处理都要整个倒腾一遍，找出这里不重复的数据，一方面这里的数据肯定不够一页，另一方面为了保证数据的顺序不变
     * 折腾完链表后，继续循环数组里的数据。
     *
     * 极端情况是会有很多连续重复数据，可以将链表中套链表
     */
    static String[] paginate(int num, String[] results) {
        List<String> res = new ArrayList<String>(results.length);
        LinkedList<Opt> list = new LinkedList<Opt>();
        Set<Integer> set = new HashSet<Integer>();
        int m = 0;
        for(int i=0; i<results.length; i++){
            if(!list.isEmpty()){
                int x = list.size();
                for(int j=0; j<x; j++){
                    Opt o = list.poll();
                    if(set.contains(o.k)){
                        list.offer(o);
                    }else {
                        m++;
                        res.add(o.v);
                        set.add(o.k);
                    }
                }
            }

            String s = results[i];
            String pre = s.substring(0, s.indexOf(","));
            int p = Integer.parseInt(pre);
            if(set.contains(p)){
                list.offer(new Opt(p, s));
            }else{
                res.add(s);
                if(++m >= num){
                    m = 0;
                    set.clear();
                    res.add("");
                }else {
                    set.add(p);
                }
            }
        }
        return res.toArray(new String[0]);
    }

    /*static String[] paginate(int num, String[] results) {
        DoublePointLinkNode head = new DoublePointLinkNode(results[0]);
        DoublePointLinkNode cur = head;
        for(int i=1; i<results.length; i++){
            DoublePointLinkNode next = new DoublePointLinkNode(results[i]);
            cur.next = next;
            next.pre = cur;
            cur = cur.next;
        }
        List<String> result = new ArrayList<String>(results.length);
        Set<String> set = new HashSet<String>();
        cur = head;
        while (cur != null){
            String str = cur.str;
            String pre = str.substring(0, str.indexOf(","));
            if(set.contains(pre)){
                cur = cur.next;
            }else {
                set.add(pre);
                result.add(str);
                if(cur.pre != null)
                    cur.pre.next = cur.next;
                if(cur.next != null) {
                    cur.next.pre = cur.pre;
                    cur = cur.next;
                }
            }
        }

        return null;
    }*/

    /*
     * Write your code here.
     */
    /*static String[] paginate(int num, String[] results) {
        LinkedList<Opt> list = new LinkedList<Opt>();
        for(String s:results){
            String[] ss = s.split(",");
            list.add(new Opt(Integer.parseInt(ss[0]), s));
        }

        Set<Integer> set = new HashSet<Integer>();
        List<String> res = new ArrayList<String>(results.length);

        int pn = 0;
        Opt last = list.getLast();
        while(!list.isEmpty()){
            Opt o = list.poll();
            if(set.contains(o.k)){
                list.offer(o);
            }else{
                set.add(o.k);
                res.add(o.v);
                if(pn++ == num){
                    res.add(SEP);
                    pn = 0;
                }
            }

            if(last == o){
                set.clear();
                last = list.getLast();
            }
        }
        return (String[])res.toArray();
    }*/

    static String[] paginate2(int num, String[] results) {
        LinkedList<Opt> list = new LinkedList<Opt>();
        for(String s:results){
            String[] ss = s.split(",");
            list.add(new Opt(Integer.parseInt(ss[0]), s));
        }

        LinkedList<Opt> list2 = new LinkedList<Opt>();
        Set<Integer> set = new HashSet<Integer>();
        List<String> res = new ArrayList<String>(results.length);

        int pn = 0;
        while(!list.isEmpty() || !list2.isEmpty()){
            Opt o = list.poll();
            if(set.contains(o.k)){
                list2.offer(o);
            }else{
                set.add(o.k);
                res.add(o.v);
                if(pn++ == num){
                    pn = 0;
                    set.clear();
                    res.add(SEP);
                }
            }


        }
        return null;
    }

    static class Opt{
        int k;
        String v;
        public Opt(int k, String v){
            this.k = k;
            this.v = v;
        }
        /*public int getK(){
            return k;
        }
        public String getV(){
            return v;
        }*/
    }
}
