/*
you will receive numbers in which there will be some positive numbers and some of them will be negative.
They will be provided as input as a string in single line and each of them will be separated from each other by commas. (Example: -5,5,1,-2,0,7)

Task: 
Your task is to arrange numbers such that all negative numbers are arranged before positive numbers also their input order must be maintained.
(Example: re-arranged array must be looking like this:  -5,-2,5,1,0,7)

from this newly arranged array take difference of two consecutive numbers and if difference is greater than 1 take the sum of all the numbers between these numbers and store this sum in output array.(For example: -2-(-5) = 3).
and if difference is less than 1 store 0 in output array.

*/



import java.io.*;
import java.util.*;
class myCode
{
    public static void main (String[] args) throws java.lang.Exception
    {
        
        Scanner s = new Scanner(System.in);
        String inputString = s.nextLine();
        
        String array[] = inputString.split(",");
        int[] arr = new int[array.length];
        
       // Converting string to int
        for(int i=0; i<array.length; i++)
        {
            arr[i] = Integer.parseInt(array[i]);
        }
        
        ArrayList<Integer> pos = new ArrayList<Integer>();
        ArrayList<Integer> neg = new ArrayList<Integer>();
        
        
        
        
        int c=0,p=0,n=0;
        while(c<arr.length)
        { 
            if(arr[c] > 0)
            { 
               int temp= arr[c]; 
               pos.add(temp);
            }
            
            if(arr[c] < 0)
            {
             int temp= arr[c]; 
             neg.add(temp);
            }
             
            c++;
                   
        }
        
        int k=0;
        while(k<neg.size())
        {
            arr[k] = neg.get(k);
            k++;
        }
        
        
      int m=k; 
       k=0;
        while(k<pos.size())
        {
            arr[m] = pos.get(k);
            k++;
            m++;
        }
        
       
        int []outarr = new int[arr.length];
        int q=0;
        for(int i=0; i<arr.length-1; i++)
        {
            int num1 = arr[i];
            int num2 = arr[i+1];
            
            if(num2-num1<=1)
            {
                outarr[q] =0;
                q++;
            }
            
            else{
                if(num1 >= num2)
                {
                    int fro = num2+1;
                    int sum=0;
                    while(fro<num1)
                    {
                        sum=sum+fro;
                        fro++;
                    }
                    outarr[q] = sum;
                    q++;
                }
                
                 if(num2 > num1)
                {
                    int fro = num1+1;
                    int sum=0;
                    while(fro<num2)
                    {
                        sum=sum+fro;
                        fro++;
                    }
                     outarr[q] = sum;
                     q++;
                }
                
            }
            
        }
        
        
        
        
        for(int i=0; i<outarr.length-1; i++)
        {
            System.out.print(outarr[i]);
            if(i != outarr.length-2)
            {System.out.print(",");}
        }
    }
    

}
