package com.shri.dynamicprograming;


/**
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 *
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 *
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 */
public class BuySellStocks {

    public static void main(String args[]){
        int[] stockPrices = new int [10];
        System.out.println("Stock price list: ");
        for(int index=0;index< stockPrices.length;index++){
          System.out.print(stockPrices[index]+ " ");
        }
        System.out.println("Brute Force:"+bruteForce(stockPrices));
        System.out.println("One pass :"+singleRun(stockPrices));
    }

    public static int singleRun(int[] stockPrices){
        int largestDifference =0;
        for(int buyDay=0;buyDay<stockPrices.length;buyDay++)
          for(int sellDay=0;sellDay<stockPrices.length;sellDay++){
              int currentDifference = stockPrices[buyDay]-stockPrices[sellDay];
              if(currentDifference > largestDifference){
                  largestDifference =currentDifference;
              }
          }
        return largestDifference;
    }

    public static int bruteForce(int[] stockPrices){
        int largestDiff =0;
        int minSoFar = Integer.MAX_VALUE;
        for(int sellDay=0;sellDay<stockPrices.length;sellDay++){
            if(stockPrices[sellDay]<minSoFar){
                minSoFar =stockPrices[sellDay];
            }else{
                largestDiff = Math.max(largestDiff,stockPrices[sellDay]-minSoFar);
            }
        }
        return largestDiff;
    }

}
