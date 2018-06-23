package com.queue;

import java.util.*;

/**
 * Created by zhangwei on 2018/5/28.
 * 任务调度器
 给定一个用字符数组表示的 CPU 需要执行的任务列表。其中包含使用大写的 A - Z 字母表示的26 种不同种类的任务。任务可以以任意顺序执行，并且每个任务都可以在 1 个单位时间内执行完。CPU 在任何一个单位时间内都可以执行一个任务，或者在待命状态。

 然而，两个相同种类的任务之间必须有长度为 n 的冷却时间，因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，或者在待命状态。

 你需要计算完成所有任务所需要的最短时间。

 示例 1：
 输入: tasks = ["A","A","A","B","B","B"], n = 2
 输出: 8
 执行顺序: A -> B -> (待命) -> A -> B -> (待命) -> A -> B.

 注：
 任务的总个数为 [1, 10000]。
 n 的取值范围为 [0, 100]。
 */
public class TaskScheduler {

    public static void main(String[] s){
        long st = System.currentTimeMillis();
        int r = new TaskScheduler().leastInterval5(new char[]{'A','A','A', 'B','B','B','B'}, 2);
        System.out.println(r + "=======" + (System.currentTimeMillis()-st));
//        new TaskScheduler().myLeastInterval(new char[]{'A','A','A','A','A','A','B','C','D','E','F','G'}, 2);
    }

    /*wrong 应该尽量消耗数字大的任务，来均匀分配cpu，否则小任务之间组合，最后只剩下一个大数字的任务，会消耗更久的时间
    public int myLeastInterval(char[] tasks, int n) {
        if(tasks == null || tasks.length == 0) return 0;
        if(tasks.length == 1) return 1;
        //Arrays.sort(tasks);
        //将任务转成数字放在队列中
        Queue<Integer> queue = new LinkedList<Integer>();
        char t = tasks[0];
        int x = 1;
        for(int i=1; i<tasks.length; i++){
            if(tasks[i] == t){
                x++;
            }else{
                queue.offer(x);
                t = tasks[i];
                x = 1;
            }
        }
        if(x > 0) queue.offer(x);

        int r = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            int m = size >= n+1?n+1:size;
            for(int i=0; i<m; i++){
                int y = queue.poll();
                if(y > 1) queue.offer(y-1);
            }
            if(!queue.isEmpty()){
                r += (n+1);
            }else{
                r+=m;
            }
        }
        return r;
    }*/

    //wrong, 过度消耗初始情况下最大数量的任务，因为随着消耗它已经不是最大的任务了，导致最终会有一个初始情况下非最大任务在最后成主要矛盾
    public int myLeastInterval(char[] tasks, int n) {
        if(tasks == null || tasks.length == 0) return 0;
        if(tasks.length == 1) return 1;
        Arrays.sort(tasks);
        //将任务转成数字放在队列中
        LinkedList<Integer> list = new LinkedList<Integer>();
        char t = tasks[0];
        int x = 1;
        for(int i=1; i<tasks.length; i++){
            if(tasks[i] == t){
                x++;
            }else{
                list.offer(x);
                t = tasks[i];
                x = 1;
            }
        }
        if(x > 0) list.offer(x);

        //循环将队列中的数字减1，为0时抛弃
        int r = 0;
        while (!list.isEmpty()){
            int size = list.size();
            int m = size >= n+1?n+1:size;
            for(int i=m-1; i>=0; i--){
                int y = list.get(i);
                if(y > 1){
                    list.set(i, y-1);
                }else {
                    list.remove(i);
                }
            }
            if(!list.isEmpty()){
                r += (n+1);
            }else{
                r+=m;
            }
        }
        return r;
    }

    public int myLeastInterval1(char[] tasks, int n) {
        if(tasks == null || tasks.length == 0) return 0;
        if(tasks.length == 1) return 1;
        Arrays.sort(tasks);
        //将任务转成数字放在队列中
        int[] temp = new int[tasks.length];
        char t = tasks[0];
        int x = 1;
        int ti = 0;
        for(int i=1; i<tasks.length; i++){
            if(tasks[i] == t){
                x++;
            }else{
                temp[ti++] = x;
                t = tasks[i];
                x = 1;
            }
        }
        if(x > 0) {
            temp[ti++] = x;
        }

        temp = Arrays.copyOfRange(temp, 0, ti);
        Arrays.sort(temp);

        int r = 0;
        int lastIndex = temp.length-1;
        int count = 0;
        while (temp[lastIndex] > 0){
            for(int i=0; i<n; i++){
                if(temp[lastIndex-i] > 0){
                    //temp[lastIndex-i] = temp[lastIndex-i]-1;
                    temp[lastIndex-i]--;
                    count++;
                }else{
                    break;
                }
            }
            if(temp[lastIndex] > 0){
                r += (n+1);
            }else{
                r += count;
            }
            count = 0;
            Arrays.sort(temp);
        }

        return r;
    }

    //beats 5%
    public int leastInterval1(char[] tasks, int n) {
        //creating a map and counting elements from tasks
        Map<Character,Integer> hmap = new HashMap<Character,Integer>();
        for (char c : tasks) {
            hmap.put(c,hmap.getOrDefault(c,0)+1);
        }

        //getting the most common process and counting in case there is more than one
        int valMax=0;
        int countMaxValues=0;
        for (Map.Entry<Character,Integer> me : hmap.entrySet()) {
            if(me.getValue()>valMax)
            {
                valMax = me.getValue();
                countMaxValues=-1;
            }
            if(me.getValue() == valMax)
                countMaxValues++;
        }

        //calculating the position of the last most common precess
        int lastProcIdle = (valMax-1)*n + valMax + countMaxValues;

        //returning most common process in case it is less than number of processes itself
        //this mean that the position of most common process is behind the last process.
        return Math.max(lastProcIdle,tasks.length);
    }

    /*
     * beats 22.5%
     * considering a tasks AAABBBBCCCC, n = 2;
     * find the character with highest frequency (maxLen) and how many of those characters, here are B and C with maxLen (4)
     * there are two characters with maxLen, so count = 2;
     * in order to accormodate all B and C, at least we need;
     * C B _ C B _ C B _ C B  (max - 1) * (1 + n) + count,
     * all other characters can be placed in the idle position, or squeeze in the middle
     * int this we can put A as C B A C B A C B A C B;
     * if the task is AAADDDBBBBCCCC, n = 2;
     * after putting A, all idle positions are occupied, so squeeze D in to the sequence as
     * C B A D C B A D C B A D C B
     */
    public int leastInterval2(char[] tasks, int n) {
        int[] map = new int[26];
        int max = 0, count = 0;
        for (char c : tasks) {
            int index = c - 'A';
            map[index]++;
            if (map[index] == max) count++;
            else if (map[index] > max) {
                max = map[index];
                count = 1;
            }
        }
        return Math.max((max - 1)*(1+n) + count, tasks.length);
    }

    //beats 5%
    public int leastInterval3(char[] tasks, int n) {
        //分别记录26个字母对应出现的次数
        int[] map = new int[26];
        for (char c: tasks)
            map[c - 'A']++;
        //排序，为后面优先消耗大值做准备
        Arrays.sort(map);
        int time = 0;
        //没消耗完不停止
        while (map[25] > 0) {
            int i = 0;
            //不够一个回合不停止
            while (i <= n) {
                //当消耗完了退出，这样最后一次不需要补齐n个时间数
                if (map[25] == 0)
                    break;
                //在数组范围并且可消耗，则消耗。因为每个n时间里不能有重复的字母，所以在一个n时间里只要走一遍数组即可
                if (i < 26 && map[25 - i] > 0)
                    map[25 - i]--;

                time++;
                i++;
            }
            Arrays.sort(map);
        }
        return time;
    }

    //beats 0%
    public int leastInterval5(char[] tasks, int n) {
        int[] map = new int[26];
        for (char c: tasks)
            map[c - 'A']++;
        //逆序队列
        PriorityQueue< Integer > queue = new PriorityQueue < Integer > (26, Collections.reverseOrder());
        for (int f: map) {
            if (f > 0)
                queue.add(f);
        }
        int time = 0;
        while (!queue.isEmpty()) {
            int i = 0;
            List < Integer > temp = new ArrayList < Integer > ();
            while (i <= n) {
                if (!queue.isEmpty()) {
                    if (queue.peek() > 1)
                        temp.add(queue.poll() - 1);
                    else
                        queue.poll();
                }
                time++;
                if (queue.isEmpty() && temp.size() == 0)
                    break;
                i++;
            }
            for (int l: temp)
                queue.add(l);
        }
        return time;
    }

    //beats 25%
    public int leastInterval6(char[] tasks, int n) {
        //分别记录26个字母对应出现的次数
        int[] map = new int[26];
        for (char c: tasks)
            map[c - 'A']++;
        //排序，为后面优先消耗大值做准备
        Arrays.sort(map);

        int max_val = map[25] - 1, idle_slots = max_val * n;
        for (int i = 24; i >= 0 && map[i] > 0; i--) {
            idle_slots -= Math.min(map[i], max_val);
        }
        return idle_slots > 0 ? idle_slots + tasks.length : tasks.length;
    }
}