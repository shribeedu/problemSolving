package com.shri.thread;

public class OddEvenPrinterB {


    public static void main(String args[]){

        TaskPrinter taskPrinter = new TaskPrinter();
        Thread oddTask = new Thread(new OddTask(taskPrinter),"Odd");
        Thread evenTask = new Thread(new EvenTask(taskPrinter), "Even");
        evenTask.start();
        oddTask.start();

    }

}

class OddTask implements Runnable{
    TaskPrinter taskPrinter;

    public OddTask(TaskPrinter taskPrinter){
        this.taskPrinter = taskPrinter;
    }

    @Override
    public void run() {

        for(int i=1;i<10;i=i+2){
            this.taskPrinter.printOdd(i);
        }

    }
}

class EvenTask implements Runnable{

    TaskPrinter taskPrinter;
    public EvenTask(TaskPrinter taskPrinter){

     this.taskPrinter = taskPrinter;

    }

    @Override
    public void run() {
        for(int i=2;i<10;i=i+2){
            this.taskPrinter.printEven(i);
        }
    }
}

class TaskPrinter{
    private  volatile boolean isOdd;

   synchronized public void printEven(int evenNumber){
       while(!isOdd) {
           try {
               this.wait();
           } catch (InterruptedException ex) {
               System.out.println("Thread is interrupted");
           }
       }
       isOdd=false;
       System.out.println("  "+evenNumber);
       this.notify();
    }

    synchronized public void printOdd(int oddNumber){
       while (isOdd){
        try{
            this.wait();
        } catch (InterruptedException ex){
            System.out.println("Thread is interrupted");
        }
       }
       isOdd=true;
       System.out.println("  "+oddNumber);
       notify();

    }

}
