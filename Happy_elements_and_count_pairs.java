/******************************************************************************
Given an array of integers A, and an integer K find number of happy elements.

Element X is happy if there exists at least 1 element whose difference is less than K 
i.e. an element X is happy if there is another element in the range [X-K, X+K] other than X itself.

Constraints

    1 <= N <= 10^5
    0 <= K <= 10^5
    0 <= A[i] <= 10^9

Input

    First line contains two integers N and K where N is size of the array and K is a number as described above.
    Second line contains N integers separated by space.

Output

    Print a single integer denoting the total number of happy elements.

Example 1

Input

6 3

5 5 7 9 15 2

Output

5

Explanation

Other than number 15, everyone has at least 1 element in the range [X-3, X+3]. Hence they are all happy elements. Since these five are in number, the output is 5.
*******************************************************************************/


import java.util.Scanner;
public class Main
{
	public static void main(String[] args) {
	Scanner input = new Scanner(System.in);
	
	int n = input.nextInt();
	int k = input.nextInt();
	
	int elements[] = new int[n];
	
	for(int i=0; i<n; i++)
	{
	    elements[i] = input.nextInt();
	}

int count=0;
	
	for(int i=0; i<n; i++)
	{
	    int temp1 = elements[i]-k;
	    int temp2 = elements[i]+k;
	    int num= elements[i];
	    
	    int flag =0;
	    for(int j=0; j<n; j++)
	    {
	        if(elements[j] >= temp1 && elements[j] <= temp2 && elements[j] != num)
	        {
	            count++;
	            flag = 1;
	        }
	        if(flag == 1)
	        break;
	    }
	}   
	   
	   
	
	
	System.out.println(count);
	
	}

}
