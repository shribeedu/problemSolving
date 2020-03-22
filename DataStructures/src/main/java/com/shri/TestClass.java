package com.shri;
import java.io.*;
import java.util.*;


public class TestClass {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int N = Integer.parseInt(br.readLine().trim());
        int[] P = new int[N];
        int[] R = new int[N];
        for(int i=0; i<N; i++)
        {
            String[] inp = br.readLine().split(" ");
            P[i] = Integer.parseInt(inp[0]);
            R[i] = Integer.parseInt(inp[1]);
        }

        int Q = Integer.parseInt(br.readLine().trim());
        for(int i=0; i<Q; i++)
        {
            String[] inp1 = br.readLine().split(" ");
            int X = Integer.parseInt(inp1[0]);
            int Y = Integer.parseInt(inp1[1]);
            long out_ = solve(N, P, R, X, Y);
            System.out.println(out_);
        }

        wr.close();
        br.close();
    }
    static long solve(int N, int[] P, int[] R, int X ,int Y){

        Map<Integer,Integer> priceRatingMap = new HashMap<Integer, Integer>();

        for(int i=0; i<N; i++)
        {
            int price = P[i];
            int rating = R[i];
            if(price>=X && price<=Y){
                priceRatingMap.put(P[i],R[i]);
            }
        }

        int highestRating = 0;

        for (Map.Entry<Integer,Integer> entry : priceRatingMap.entrySet()){
            int princeEntry = entry.getKey();
            int ratingEntry = entry.getValue();
            if(ratingEntry>highestRating){
                highestRating = ratingEntry;
            }
        }
        return highestRating;

    }
}