/*

Your Task:
You don't need to read input or print anything. 
The task is to complete the function subarraySum() which takes arr, N, and S as input parameters and returns an arraylist containing the starting and ending 
positions of the first such occurring subarray from the left where sum equals to S. The two indexes in the array should be according to 1-based indexing. 
If no such subarray is found, return an array consisting of only one element that is -1.

 

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

Input: N = 5, S = 12
A[] = {1,2,3,7,5}

Output: 2 4
Explanation: The sum of elements 
from 2nd position to 4th position 

is 12.


Input:
N = 10, S = 15
A[] = {1,2,3,4,5,6,7,8,9,10}
Output: 1 5
Explanation: The sum of elements 
from 1st position to 5th position
is 15.

*/
 
// This looks esay but is not esay to complete in O(N) time complexity so here is the code 

// used sliding window
/*

The idea is simple as we know that all the elements in subarray are positive so,
If a subarray has sum greater than the given sum then there is no possibility that adding elements to the current subarray will be equal to the given sum. 
So the Idea is to use a similar approach to a sliding window. 

Start with an empty subarray 
add elements to the subarray until the sum is less than x( given sum ). 
If the sum is greater than x, remove elements from the start of the current subarray.

*/

class Solution
{
    //Function to find a continuous sub-array which adds up to a given number.
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) 
    {

      // arraylist to be returned
        ArrayList<Integer> to_return = new ArrayList<>();
    
        int start = 0;
        int sum=0;
        int flag = 0;
        int end = 0;
        
      // if sum needed is 0 than just return list with -1 in it
      
        if(s == 0)
        {
            to_return.add(-1);
            return to_return;
        }
        
      
      // while start position is < size of array
      
        while(start<n)
        {

          // found sum then add those two positions and return
            if(sum == s)
            {
                to_return.add(start+1);
                to_return.add(end);
                return to_return; 
            }
                      
            if (sum > s) // if sum becomes larger subtract the element at current start position
            {
                sum = sum - arr[start];
                
                if(sum == s) // found sum then add those two positions and return
                {
                    to_return.add(start+2);
                    to_return.add(end);
                    return to_return;
                }
                
                 
                else
                {
                  start++; // slide the window forward
                }
            }
        
            
           if(sum < s)
           {
               if(end < n) // if sum is less than s and end has not reached at last add element at end position to sum
               {
                   sum = sum + arr[end];
                   end++;
               }
               
               if(sum < s && end >= n) // if end has reached at last position and sum is still < s than given s is not possible so come out of loop
               {
                   break;
               }

           }
        }

    
         to_return.add(-1);
         return to_return;
        
         
    }
}
