package com.example.demo.morethread;

import java.util.Date;

/**
 * 笔试
 */
public class WrittenExaminatioin {
    static int m;
    private String string1=new String("string1");
    private StringBuffer string2=new StringBuffer("string2");
    private int i;

    //变量声明 java中所有声明的基本类型或对象，必须先初始化才能输出值；如果不初始化则不能通过编译
    public static void main(String[] args) {
        String s="s";
        int a=0;
//        System.out.println("s="+s);
//        System.out.println("a="+a);
//        System.out.println("m="+m);
        WrittenExaminatioin writtenExaminatioin=new WrittenExaminatioin();
        //验证java中的值传递和引用传递
        writtenExaminatioin.info(writtenExaminatioin.string1,writtenExaminatioin.string2);
        System.out.println("string1="+writtenExaminatioin.string1);
        System.out.println("string2="+writtenExaminatioin.string2);
//        writtenExaminatioin.intTest(writtenExaminatioin.i);
//        System.out.println("i="+writtenExaminatioin.i);



    }

    /**
     * 值传递：
     *
     * 方法调用时，实际参数把它的值传递给对应的形式参数，函数接收的是原始值的一个copy，此时内存中存在两个相等的基本类型，即实际参数和形式参数，后面方法中的操作都是对形参这个值的修改，不影响实际参数的值。
     *
     * 引用传递：
     *
     * 也称为传地址。方法调用时，实际参数的引用(地址，而不是参数的值)被传递给方法中相对应的形式参数，函数接收的是原始值的内存地址；
     * 在方法执行中，形参和实参内容相同，指向同一块内存地址，方法执行中对引用的操作将会影响到实际对象。
     * @param string1
     * @param string2
     */
    public void info(String string1,StringBuffer string2){
        System.out.println("string1="+string1);
        string1="abc";
        System.out.println("string1="+string1);
        System.out.println("-----------------");
        System.out.println("string2="+string2);
        string2.append("abc");
        System.out.println("string2="+string2);
    }
    public void intTest(int a){
        System.out.println("i="+a);
        a=2;
        System.out.println("i="+a);
    }
    //基本类型在声明时就分配了内存空间
    //引用类型声明时只分配了引用空间，初始化时才分配数据空间。
    public void testQuote(){
        Date date1,date2;//在内存中开辟两个引用空间
        date1=new Date();//开辟存储Date对象的数据空间，并把这个空间的首地址赋值给date1;
        date2=date1;//把date1存储空间的地址存到date2中
    }

}
