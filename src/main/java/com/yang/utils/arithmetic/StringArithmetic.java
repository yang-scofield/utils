package com.yang.utils.arithmetic;

public class StringArithmetic {

    /**
     * description 反转字符串
     * @param s
     * @return
     */
    public String reverseString (String s){
        StringBuffer sb=new StringBuffer();
        for(int i=s.length()-1;i>=0;i--){
            sb.append(s.substring(i,i+1));
        }
        return sb.toString();
    }

    /**
     * description 反转有符号32位整数
     * @param x
     * @return
     */
    public int reverse(int x){

        String symbol="";
        StringBuffer temp=new StringBuffer();
        String param=String.valueOf(x);
        if (x<0){
            symbol=param.substring(0,1);
            param=param.substring(1,param.length());
        }

        for (int i=param.length()-1;i>=0;i--){
            temp.append(param.substring(i,i+1));
        }
        String result=temp.toString();
        if("0".equals(result.charAt(0)))result=result.substring(1,result.length());
        long out= Long.valueOf(symbol+result);
        if(out>Integer.MAX_VALUE||out<Integer.MIN_VALUE)return 0;
        return ((int) out);
    }


    /**
     * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
     * @param s
     * @return
     */
    public int firstUnipChar(String s){

        for (int i=0;i<s.length();i++){
            String temp=s.substring(i,i+1);
            int first=s.indexOf(temp);
            int last=s.lastIndexOf(temp);
            if(first==last)return i;
        }
        return -1;
    }


    public static void main(String[] args) {
        StringArithmetic sa=new StringArithmetic();
        System.out.println(sa.firstUnipChar("loveleetcode"));
    }
}
