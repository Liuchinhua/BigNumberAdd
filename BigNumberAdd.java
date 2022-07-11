/*
模擬了人工的演算法，比如1234+987
a.先把位數補齊一致，變成：1234 + 0987
b.從個位開始運算，每次用一個變數w記錄是否要進位
c.遍歷所有的位置就完成了加法；
*/

import java.util.Scanner;
import java.io.*;

public class BigNumberAdd{
    public static void main(String[] args) throws IOException{
        //輸入2個字串型別的大數字
        System.out.print("請輸入第一個數字：");
        String s1=new Scanner(System.in).nextLine();
        System.out.print("請輸入第二個數字：");
        String s2=new Scanner(System.in).nextLine();
        String result=add(s1,s2);
        System.out.println("\n計  算  結  果  ："+result);
    }

    private static String add(String s1,String s2){
        //調整s1長度<=s2長度
        if(s1.length()>s2.length()){
            String t=s1;
            s1=s2;
            s2=t;
        }

        int cha=s2.length()-s1.length(); //s2,s1的位元差

        for(int i=0;i<cha;i++)
            s1='0'+s1;  //把s1前面的空缺補0，調成和s2一樣長

        String result="";
        int w=0; //進位
        for(int i=s2.length()-1;i>=0;i--){
            //s1,s2要各減去48才能達成char轉int的值(char會多48)
            int c=s2.charAt(i)+s1.charAt(i)-96+w;
            w=c/10;  //c除以10就是進位
            result=(c%10)+result; //取餘數即為該位元數字
        }

        //如果最高位元有進位，補1到最前面
        if(w==1)
            result=1+result;

        return result;
    }   
}