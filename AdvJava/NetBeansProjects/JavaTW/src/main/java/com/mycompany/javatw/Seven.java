/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javatw;
//please make some legit changes and dont get caught if two or more programs are same
import java.util.*;
public class Seven {
    public static void main(String[] args) {
        BankAccount unsyncAccount = new BankAccount();
        BankAccount syncAccount = new SynchronizedBankAccount();
        System.out.println("Unsynchronized account:");
        runThreads(unsyncAccount);
        System.out.println("Final balance: " + unsyncAccount.getBalance());
        System.out.println("\nSynchronized account:");
        runThreads(syncAccount);
        System.out.println("Final balance: " + syncAccount.getBalance());
    }

    private static void runThreads(BankAccount account) {
        Thread t1 = new Thread(() -> {
            account.deposit(1000);
            account.withdraw(1500);
        }, "Thread 1");
        Thread t2 = new Thread(() -> {
            account.deposit(1000);
            account.withdraw(1500);
        }, "Thread 2");
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class BankAccount {
    private int balance = 0;
    private static final int MIN_BALANCE = 1000;
    void deposit(int amount) {
        balance += amount;
    }
    void withdraw(int amount) {
        if (balance - amount >= MIN_BALANCE) {
            balance -= amount;
        }
        else{
            System.out.println("Thread " + Thread.currentThread().getName() + ": Insufficient balance");
        }
        
    }
    int getBalance() {
        return balance;
    }
}

class SynchronizedBankAccount extends BankAccount {
    @Override
    synchronized void deposit(int amount) {
        super.deposit(amount);
    }
    @Override
    synchronized void withdraw(int amount) {
        super.withdraw(amount);
    }
}