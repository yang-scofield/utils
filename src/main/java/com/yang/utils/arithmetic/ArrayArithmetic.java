package com.yang.utils.arithmetic;

import java.util.*;

public class ArrayArithmetic {


    /**
     * 从排序数组中删除重复项，并返回新数组长度,且原数组为删除后的数组长度
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums){

        Set<Integer> numSet=new HashSet<Integer>();
        int count=nums.length;
        for(int i=0;i<count;i++){
            if(numSet.contains(nums[i])){
                for(int j=i;j<count-1;j++){
                    nums[j]=nums[j+1];
                }
                i--;
                count--;
            }else{
                numSet.add(nums[i]);
            }
        }
        nums=Arrays.copyOf(nums,count);
        System.out.println(Arrays.toString(nums));
        return count;

    }


    /**
     * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        if(nums.length==1){
            return;
        }else{
            for(int i=0;i<k;i++){
                int temp=0;
                temp=nums[nums.length-1];
                for(int j=nums.length-2;j>=0;j--){

                    nums[j+1]=nums[j];
                }
                nums[0]=temp;

            }
            return;
        }
    }

    /**
     * 给定一个整数数组，判断是否存在重复元素。
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> numsSet=new HashSet<Integer>();
        for(int num:nums){
            if(numsSet.contains(num))return true;
            numsSet.add(num);
        }
        return false;
    }

    /**
     * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
     * @param nums
     * @return
     */

    public int singleNumber(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        for(int num:nums){
            if(!map.containsKey(num)){
                map.put(num,1);
            }else {
                map.put(num,2);
            }

        }
        for(int i:map.keySet()){
            if(map.get(i)==1)return i;
        }

        return -1;
    }


    /**
     * 给定一个非负整数组成的非空数组，在该数的基础上加一，返回一个新的数组。

       最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。

       你可以假设除了整数 0 之外，这个整数不会以零开头。
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {
        int[] arr=new int[digits.length+1];
        for(int i=digits.length-1;i>=0;i--){
            if(digits[i]==9){
                digits[i]=0;
            }else{
                digits[i]=digits[i]+1;

                return digits;
            }
        }
        if(digits[0]==0){
            arr[0]=1;
            for(int j=0;j<digits.length;j++){
                arr[j+1]=digits[j];
            }
        }
        return arr;
    }


    /**
     * 给定两个数组，写一个方法来计算它们的交集。输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {

        int count=0;
        Set<Integer> set=new HashSet<Integer>();
        int[] arr=new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
            boolean jump=false;
            for(int j=0;j<nums2.length;j++){
                if(set.contains(j))continue;
                if(true==jump)break;
                if(nums1[i]==nums2[j]){
                    arr[count]=nums1[i];
                    count++;
                    set.add(j);
                    jump=true;

                }
            }
        }
        return Arrays.copyOf(arr,count);
    }

    /**
     * 给定一个数组 nums, 编写一个函数将所有 0 移动到它的末尾，同时保持非零元素的相对顺序。
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int count=nums.length;
        for(int i=0;i<count;i++){
            if(nums[i]==0){
                for(int j=i;j<nums.length-1;j++){
                    nums[j]=nums[j+1];
                }

                nums[nums.length-1]=0;
                i--;
                count--;
            }
        }
        System.out.println(Arrays.toString(nums));
        return;

    }


    /**
     * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int[] arr=new int[2];
        boolean jump=false;
        for(int i=0;i<nums.length;i++){
            if(true==jump)break;
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    arr[0]=i;
                    arr[1]=j;
                    jump=true;
                    break;

                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        ArrayArithmetic aa=new ArrayArithmetic();
        //int[] a={0,0,1,1,1,2,2,3,3,4};
        //System.out.println(aa.removeDuplicates(a));
        int[] a={0,2,1};
        aa.moveZeroes(a);
    }
}
