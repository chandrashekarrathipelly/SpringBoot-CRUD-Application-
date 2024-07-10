package com.embarkx.ChallengeApp;

public class ZerosToEnd {
    public static void main(String[] args) {
        int[] arr = {2,4,0,8,6,0,0,7};
           int j = 0; int count = 0;
        for(int i=0; i<arr.length;i++){
            if(arr[i]!=0){
                arr[j] = arr[i] ;
                j++;
            }
            if(arr[i]==0){
                i++;
                count++;
            }
        }
        for(int k = j; k < arr.length; k++){
            arr[j] = 0;
            j++;
        }
        for(int c=0;c<arr.length;c++){
            System.out.println(arr[c]);
        }

    }
}
