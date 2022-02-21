/******************************************************************************
 Given an array of integers, perform atmost K operations so that the sum of elements of final array is minimum. An operation is defined as follows –

    Consider any 1 element from the array, arr[i].
    Replace arr[i] by floor(arr[i]/2).
    Perform next operations on the updated array.
    The task is to minimize the sum after utmost K operations.

Constraints

    1 <= N
    K <= 10^5.

Input

    First line contains two integers N and K representing size of array and maximum numbers of operations that can be performed on the array respectively.
    Second line contains N space separated integers denoting the elements of the array, arr.

Output

    Print a single integer denoting the minimum sum of the final array.

Input

4 3

20 7 5 4

Output

17

Explanation

    Operation 1 -> Select 20. Replace it by 10. New array = [10, 7, 5, 4]
    Operation 2 -> Select 10. Replace it by 5. New array = [5, 7, 5, 4].
    Operation 3 -> Select 7. Replace it by 3. New array = [5,3,5,4].
    Sum = 17.

*******************************************************************************/
import java.util.Scanner;
public class Main
{
	public static void main(String[] args) {
    
    Scanner input = new Scanner(System.in);
    int N = input.nextInt();
    int K = input.nextInt();
    
    int[] array = new int[N];
    
    for(int i=0; i<N; i++)
    {
        array[i] = input.nextInt();
    }
    
	
	for(int i=0; i<K; i++)
	{   int index,num;
	    index = max(array);
	    num =(int)( Math.floor(array[index]/2));
	    array[index] = num;
	}
	
	int sum=0;
	for(int i=0; i<array.length; i++)
	{
	    sum = sum+array[i];
	}
	
	System.out.println(sum);
	
	}
	public static int max (int[] array)
	{
	    int max=0;
	    for(int i=0; i< array.length; i++)
	    {
	       if(array[max]<array[i])
	       max = i;
	    }
	    
	    return max;
	    
	}

}
