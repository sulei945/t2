package company;

import java.util.HashMap;

/**
 * Created by zhangwei on 2018/4/13.
 */
//Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
//You may assume that the array is non-empty and the majority element always exist in the array.
public class MajorityElement {

    public int majorityElement(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int current: nums) {
            if(map.containsKey(current) && map.get(current) + 1 > nums.length / 2) {
                return current;
            } else if(map.containsKey(current)) {
                map.put(current, map.get(current) + 1);
            } else {
                map.put(current, 1);
            }
        }

        //no majority element exists
        return -1;
    }

    public static void main(String[] s){
        int r = new MajorityElement().majorityElement(new int[]{1,1,2,3,1,4,1,1,6,1});
        System.out.println(r);

        int mr = new MajorityElement().myMajorityElement(new int[]{1,1,2,3,1,4,1,1,6,1});
        System.out.println(mr);
    }

    //因为找大于一半的存在，那么任意两个不同的元素相抵消，剩下的肯定是想要的数据
    public int myMajorityElement(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int c = nums[0];
        int cs = 1;
        int l = nums.length;
        for(int i = 1; i < l; i++ ){
            if(cs <= 0){
                cs =1;
                c = nums[i];
            }else if(c == nums[i]){
                cs ++;
            }else {
                cs --;
            }
        }
        return c;
    }
}
