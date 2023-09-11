package org.example;

import org.example.Account.Account;

public class Main {
    public static void main(String[] args) {

        Account a1=new Account(1);
        Account a2=new Account(2);
        Account a3=new Account(3);

        a1.senMoney(a2,2000);
        a1.widraw(500);
        a3.senMoney(a1,1000);
        a2.widraw(2000);

        System.out.println(a1.transitionHistory());
        System.out.println(a2.transitionHistory());
        System.out.println(a3.transitionHistory());
    }
}