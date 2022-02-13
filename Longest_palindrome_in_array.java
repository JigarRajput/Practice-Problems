// Longest Palindrome
import java.util.Scanner;
public class Main
{
	public static void main(String[] args) {
	Scanner input = new Scanner(System.in);
	System.out.println("Enter size of array:");
	int size = input.nextInt();
	int array [] = new int[size];
	
	for(int i=0;i<size;i++)
	{
	    System.out.println("Enter number");
	    array[i] = input.nextInt();
	}
		
// Sorting array in Descending array

    for(int i=0;i<size;i++)
    {
        for(int j=i+1;j<size;j++)
        {
           if(array[j] > array[i]){
           int temp = array [i];
           array[i] = array[j];
           array[j] = temp;
           }
        }
    }
int j =0;

 
// checking for palindromes
 int[] palins = new int[size];
for(int i=0;i<size;i++){
 boolean ans = isPalindrome(array[i],size);
 if(ans == true)
 {
    palins[j] = array[i];
    j++;
 }
}


if(palins[0] != '\0')
System.out.println("Largest palindrome is:" + palins[0]);
else
System.out.println(" No palindromes ");
	}
	
public static boolean isPalindrome(int element,int size)
{
  String s = "";
  s = Integer.toString(element);
  
  int low=0;
  int high = s.length()-1;
  
  while(low<high)
  {
      if(s.charAt(low) != s.charAt(high))
      return false;
      low++;
      high--;
  }
   return true;
}
}

