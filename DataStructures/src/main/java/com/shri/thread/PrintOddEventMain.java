package com.shri.thread;


public class PrintOddEventMain {

    public static void main(String args[]){

        System.out.println("Program to print the odd and even numbers");
        OddEvenPrinter oddEvenPrinter = new OddEvenPrinter(10);
        OddEvenThread evenThread = new OddEvenThread(true,oddEvenPrinter);
        OddEvenThread oddThread = new OddEvenThread(false,oddEvenPrinter);

        Thread thread1 = new Thread(evenThread,"evenThread");
        Thread thread2 = new Thread(oddThread,"oddThread");

        thread1.start();
        thread2.start();

    }
}


class OddEvenThread implements Runnable{

    private  int max = 10;
    private  OddEvenPrinter oddEvenPrinter;
    private  boolean isEven;

    public OddEvenThread(boolean isEven,OddEvenPrinter oddEvenPrinter){
      this.oddEvenPrinter=oddEvenPrinter;
      this.isEven = isEven;
    }


    @Override
    public void run() {
        int number = isEven ? 2 : 1;
        while (number < max) {
            if (isEven) {
                oddEvenPrinter.printEvenNumber(number);
            } else {
                oddEvenPrinter.printOddNumber(number);
            }
            number += 2;
        }
    }

}



class OddEvenPrinter{
    private volatile boolean isOdd;
    private int limit;

    public OddEvenPrinter(int limit){
        this.limit=limit;
    }


    synchronized void printEvenNumber(int number){
        while(!isOdd){
            try{
                System.out.println("even number waiting");
                wait();
            }catch (InterruptedException ie){
                Thread.currentThread().interrupt();
            }
        }
        System.out.println(Thread.currentThread().getName()+" : "+number);
        isOdd = false;
        System.out.println("Even number notify");
        notify();
    }

    synchronized void printOddNumber(int number){
        while(isOdd){
            try{
                System.out.println("Odd number waiting");
                wait();
            }catch (InterruptedException ie){
                Thread.currentThread().interrupt();
            }
        }
        System.out.println(Thread.currentThread().getName()+" : "+number);
        isOdd = true;
        System.out.println("Odd number notify");
        notify();
    }
}

