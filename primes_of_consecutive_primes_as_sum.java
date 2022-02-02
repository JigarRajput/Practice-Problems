/*
Question – :  Some prime numbers can be expressed as a sum of other consecutive prime numbers.

For example
5 = 2 + 3,
17 = 2 + 3 + 5 + 7,
41 = 2 + 3 + 5 + 7 + 11 + 13.
Your task is to find out how many prime numbers which satisfy this property are present in the range 3 to N subject to a constraint that summation should always start with number 2.
Write code to find out the number of prime numbers that satisfy the above-mentioned property in a given range.

Input Format: First line contains a number N

Output Format: Print the total number of all such prime numbers which are less than or equal to N.
*/

import java.util.Scanner;
public class Main
{
	public static void main(String[] args) {
	
	Scanner input = new Scanner(System.in);
	int N = input.nextInt();
	
	int primes[] = new int[N/2];
	primes[0] = 2;
	
	// find primes upto N and store them in primes Array
	
	for(int i=3, k=1; i<N && k<N/2; i++)
	{
	    int flag = 0;
	    for(int j=2; j<i; j++)
	    {
	        if(i%j == 0)
	        {
	            flag = 1;
	        }
	    }
	    
	    if(flag == 0)
	    {
	        primes[k] = i; 
	        k++;
	    }
	 
	}
	
// keep on doing sum and look if the sum matches any prime	
	
int sum=2;
for(int i=1; i<primes.length; i++)
{
    sum = sum+primes[i];
    searchSum(sum,primes);
}

	
	
} // main ends
	
public static void searchSum(int key, int[] primes)
{
    for(int i=0; i<primes.length; i++)
    {
        if(primes[i] == key)
        System.out.println(primes[i]);
    }
}
}
