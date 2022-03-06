/*
Given number of opponents and their scores you have to choose the order to play with opponent so that you can maximize your score

It is guranteed that you will always beat the player

here are some rules:
-> all opponent are standing in a line the order is fixed
-> your task is to choose suitable opponent from this line
-> when you choose the opponent he is removed
-> if opponent has beaten two neighbours then you have option to multiply the opponent number and subtract the other opponent number. This value becomes winning score of that match
-> if the opponent has only one neighbour then winning score for that match is product of that opponent number and its neighbour number.
-> when dealing with last opponent the score is equal to the value of last opponent number

example:
suppose that you have four opponents 2,5,6,7
you can choose any order to play:
2 -> 5 -> 6 -> 7 or
5 -> 7 -> 6 -> 2 or

in any order

the task is to maximize the score 

suppose you choose to play with opponent 5 first then,
6 then 7 and then 2
your score will be 5*6 -2 + (5 removed)
6*7 -2 +  (6 removed)
2*7 + (2 removed)
7

score will be 89 but this is not the maximum score

if you first start with 6->5->2->7
then your score will be:
6*7 -5 + (6 removed)
5*7 -2 + (5 removed)
2*7 + (2 removed)
7 (7 removed)

score will be 91 and this will be maximum

input:
first line contains number of opponents
second line contains values of opponents

output:
single line displaying maximum score

example 1:
input:
4
2 5 6 7

output:
91

example 2:
input: 
3
7 8 9

output:
137

*/

// jai Ganesh

import java.util.*;
public class Main
{
	public static void main(String[] args) {
	
	Scanner input = new Scanner(System.in);
	 
	 int N = input.nextInt();

	 ArrayList<Integer> opponents = new ArrayList<>();
	 
	 for(int i=0; i<N; i++)
	 {
	     int temp = input.nextInt();
	     opponents.add(temp);
	 }
	 
	 int score =0;
	 int maxProduct = 0;
	 int product;
	 int tempItem=0;
	 int newScore=0;
	 for(int i=0; i<N;i++)
	 {
	     for(int j=0; j<opponents.size();j++)
	     {
	        
	        // if only one element is left
	        if(opponents.size() == 1)
	        {
	            tempItem = j;
	            newScore = opponents.get(j);
	            break;
	        }
	        
	        // if only two elements are left and j is last
	        if(opponents.size() == 2 && j== (opponents.size()-1))
	        {
	            product = opponents.get(j)*opponents.get(j-1);
	            if(opponents.get(j-1) < opponents.get(j))
	            {
	                tempItem = j-1; // index to be removed
	                newScore = product;
	                break;
	            }
	            
	            else
	            {
	                tempItem = j; // index to be removed
	                newScore = product;
	                break;
	            }
	        }
	        
	        //if only two elements are  left and j is first
	        if(opponents.size() == 2 && j== 0)
	        {
	            product = opponents.get(j)*opponents.get(j+1);
	            if(opponents.get(j) < opponents.get(j+1))
	            {
	                tempItem = j; // index to be removed
	                newScore = product;
	                break;
	            }
	            
	            else
	            {
	                tempItem = j+1; // index to be removed
	                newScore = product;
	                break;
	            }
	        }
	        
	        // if size is greater than 2
	        if(opponents.size() > 2 && j+1 < opponents.size())
	        {
	         
	         product = opponents.get(j)*opponents.get(j+1);
	         
	         if(product > maxProduct)
	         {
	          maxProduct = product;
                if(opponents.get(j) < opponents.get(j+1)) // check which index has lower value
                {
                    tempItem = j; // index to be removed
                    if(j!=0)
                    {
                    newScore = maxProduct - opponents.get(j-1); // subtract the score of previous item if it is present
                    }
                    
                    else{
                        newScore = maxProduct; // if previous item is not present then don't subtract
                    }
                }
                else
                {
                    tempItem = j+1; // index to be removed
                        if(j!=0)
                    {
                    newScore = maxProduct - opponents.get(j-1); // subtract the score of previous item if it is present
                    }
                    
                    else{
                        newScore = maxProduct; // if previous item is not present then don't subtract
                    }
                }    
	         }
	        
	     }
	   }
	     maxProduct = 0;
	     score=score+newScore;
	     opponents.remove(tempItem);
	 }
	
	System.out.println(score);
	}
}
