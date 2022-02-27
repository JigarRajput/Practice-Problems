/******************************************************************************

Problem Description
The parcel section of the Head Post Office is in a mess.  The parcels that need to be loaded to the vans have been lined up in a row in an arbitrary order of weights.  The Head Post Master wants them to be sorted in the increasing order of the weights of the parcels, with one exception.  He wants the heaviest (and presumably the most valuable) parcel kept nearest his office.

 You and your friend try to sort these boxes and you decide to sort them by interchanging two boxes at a time.  Such an interchange needs effort equals to the product of the weights of the two boxes. 

The objective is to reposition the boxes as required with minimum effort.

Input
The first line consists of two space separated positive integers giving the number of boxes (N) and the position of the Head Post Masterâ€™s office (k) where the heaviest box must be.

The second line consists of N space separated positive integers giving the weights of the boxes.  You may assume that no two weights are equal.

Output
The output is one line giving the total effort taken to get the boxes in sorted order, and the heaviest in position k.

Constraints
N<=50

Weights <= 1000

Difficulty Level
Complex

Time Limit (secs)
1

Examples
Example 1

Input

5 2

20 50 30 80 70

Output

3600

Explanation

There are 5 boxes (N=5) and the heaviest box must be in position 2 (k=2).  If we look at the final order (sorted, with the heaviest at position 2), it should be 20 80 30 50 70.  If we look at this, we notice that only the 50 and the 80 parcels need to be exchanged.  As this takes effort of the product of the weights, the effort is 4000.   

Further reduction can be obtained if we use the smallest package (20) as an intermediary.  If we exchange 20 with 50 (effort 1000), then with 80 (effort 1600) and back with 50 again (effort 1000), the effect is the same, with a total effort of 3600 (less th an the effort obtained by the direct move)an the effort

The results after the optimal sequence of exchanges are

50 20 30 80 70

50 80 30 20 70

20 80 30 80 70

 

As this takes an effort of 3600, the output is 3600.

Example 2

Input

6 3

30 20 40 80 70 60

Output

7600

Explanation

There are 6 parcels, and the heaviest should be at position 3.  Hence the final order needs to be 20 30 80 40 60 70.  If we look at the initial position, we see that 20 and 30 need to be exchanged (effort 600), 40 and 80 need to be exchanged (effort 3200) and 60 and 70 need to be exchanged (effort 4200).  Hence the total effort is 600+3200+4200=8000. 

If we use the same approach as in Example 1, we get the following efforts

 

(600)   20 30 40 80 70 60

(3200) 20 30 80 40 70 60   

(1200) 60 30 80 40 70 20

(1400) 60 30 80 40 20 70

(1200) 20 30 80 40 60 70

A total effort of 7600 is obtained rather than an effort of 8000, which is the output.

*******************************************************************************/
import java.util.*;
public class Main
{
	public static void main(String[] args) {
	    
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		int k = input.nextInt();
		
		int[] array = new int[N];
		
		int minimumEffort = 0;
		
// input parcels

		for(int i=0; i<array.length; i++)
		{
		    array[i] = input.nextInt();
		}
		
// find indexes of maximum and minimum

		int minimum = findMin(array);
		int maximum = findMax(array);

// weights of position of interest

		int wk = array[k-1];
		int wmin = array[minimum];
		int wmax = array[maximum];

// if minimum not at first position move it first of all to first position		
		if(minimum != 0)
		{
		    minimumEffort = minimumEffort + array[minimum]*array[0];  // count the effort
		    swap(minimum,0,array);
		}

// if maximum not at k position move it to k position
		if(maximum != k-1)
		{
		    if(wk*wmax > wk*wmin + wmin*wmax + wmin*wk) // if direct swap is costly than using smallest as intermediary
		    {
		        minimumEffort = minimumEffort + wk*wmin + wmin*wmax + wmin*wk; // count effort using this way
		        swap(k-1,0,array);
		        swap(maximum,k-1,array);
		        swap(maximum,0,array);
		        
		    }
		    
		    else  // if direct swap is cheaper
		    {
		        swap(maximum,k-1,array);
		        minimumEffort = minimumEffort + wk*wmax; // count effort using this way
		    }
		    
		    boolean check = isSorted(array,k-1); // check if array is already sorted after these two changes
		    if(check == false)
		    {
		    int effortReturned = sortArray(array,k-1); // not sorted then sort it
		    minimumEffort = minimumEffort + effortReturned;
		    }
		}
		
	        System.out.println(minimumEffort); // print the effort
		
	}
	
	// this method finds the index of minimum element
	static int findMin(int[] array) 
	{
	    int minimum = 0;
	    for(int i=0;i<array.length;i++)
	    {
	        if(array[i] < array[minimum])
	        minimum = i;
	    }
	    
	    return minimum;
	}
	
	// this method finds the index of maximum element
	static int findMax(int[] array)
	{
	    int maximum = 0;
	    for(int i=0;i<array.length;i++)
	    {
	        if(array[i] > array[maximum])
	        maximum = i;
	    }
	    
	    return maximum;
	}
	
	// this method sorts the array ignoring element at 0th and k position
	static int sortArray(int[] array, int k)
	{
	    int leave = k;
	    int effortReturned = 0;
	    for(int i=1;i<array.length-1;i++)
	    {
	        if(i==k)
	        continue;
	        for(int j=1;j<array.length-1;j++)
	        {
	            if(j==k)
	            continue;
	            
	            if(array[j] > array[j+1])
	            {
	                int wz = array[0];
	                int wj = array[j];
	                int wj1 = array[j+1];
	                if(wj*wj1 > wj1*wz + wz*wj + wj1*wz)
	                {
	                    swap(j+1,0,array);
	                    swap(j,j+1,array);
	                    swap(j,0,array);
	                    
	                    effortReturned = effortReturned + wj1*wz + wz*wj + wj1*wz;
	                }
	                
	                else
	                {
	                swap(j,j+1,array);         
	                effortReturned = effortReturned + wj*wj1;     
	                }
	            }
	        }
	    }
	    return effortReturned;
	    
	}
	
	// this method checks if the array is sorted ignoring 0th and k position
	static boolean isSorted(int[] array, int k)
	{
	    int leave = k;
	    int flag = 0;
	    for(int i=0;i<array.length-1;i++)
	    {
	        if(i==k)
	        continue;
	        
	        for(int j=0;j<array.length-1;j++)
	        {
	            if(j==k)
	            continue;
	            
	            if(array[j] > array[j+1])
	            {
	                flag = 1;
	                break;
	            }
	        }
	        
	        if(flag==1)
	        {
	            break;
	        }
	    }
	    
	    if(flag==1)
	    {
	        return false;
	    }
	    
	    else 
	    return true;
	}
	
	// swaps the two given position elements
	static void swap(int maximum, int minimum, int[] array)
	{
	    int temp = array[maximum];
	    array[maximum] = array[minimum];
	    array[minimum] = temp;
	}
	
	
	
}
