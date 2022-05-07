/******************************************************************************

Problem Statement –

A chocolate factory is packing chocolates into the packets. The chocolate packets here represent an array  of N number of integer values. The task is to find the empty packets(0) of chocolate and push it to the end of the conveyor belt(array).

Example 1 :

N=7 and arr = [4,5,0,1.9,0,5,0].

There are 3 empty packets in the given set. These 3 empty packets represented as O should be pushed towards the end of the array

Input :

7  – Value of N

[4,5,0,1,0,0,5] – Element of arr[O] to arr[N-1],While input each element is separated by newline

Output:

4 5 1 9 5 0 0

Example 2:

Input:

6 — Value of N.

[6,0,1,8,0,2] – Element of arr[0] to arr[N-1], While input each element is separated by newline

Output:

6 1 8 2 0 0

*******************************************************************************/
import java.util.Scanner;
public class Main
{
	public static void main(String[] args) {
	
	Scanner input = new Scanner(System.in);
	
	// taking size
	int size = input.nextInt();
	int[] elements = new int[size];
	
	//initializing zero count
	int count =0;
	
	//taking input
	for(int i=0; i<size; i++)
	{
	    elements[i] = input.nextInt();
	    if(elements[i] == 0)
	    count = count+1;
	}

    // new array
	int [] new_array = new int[size];
	
	
	// copying to new array
	for(int i=0,j=0; i<elements.length; i++)
	{
	    if(elements[i] !=0 )
	    {
	        new_array[j] = elements[i];
	        j++;
	    }
	}
	
	// from where to put zeros
	int zero_s = (elements.length - count);
	
	for(int i=zero_s; i<new_array.length; i++)
	{
	    new_array[i] = 0;
	}
	
	for(int i=0; i<new_array.length; i++)
	{
	    System.out.println(new_array[i]);
	}
	
	
	}
}
