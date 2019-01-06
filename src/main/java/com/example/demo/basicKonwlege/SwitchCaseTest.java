package com.example.demo.basicKonwlege;

public class SwitchCaseTest {

    public static void main(String[] args) {
       getInt(2);
    }
    public static void getInt(int a){
        switch(a){
            case 1:
                System.out.println(1);break;
            case 2:
                System.out.println(2);break;
            case 3:
                System.out.println(3);break;
            case 4:
                System.out.println(4);break;
                default:
                    System.out.println("default");break;

        }

    }

}
