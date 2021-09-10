/******************************************************************************
abbcccddddeeeeeff…..
Print the above series, take input from the user which will be used to print the series till the nth term

Assume the input will never exceed its value more than 100

*******************************************************************************/
import java.util.Scanner;
public class Main
{
	public static void main(String[] args) {
	Scanner input = new Scanner(System.in);
	System.out.println("Enter N");
	int N = input.nextInt();
	int i = 97; 
	
int count =0; // counts number of letter
if(N<100){
 while(count<N)
	{
	    
	    int times = ((i%97)+1);
	    for(int j=0;j<times;j++)
	    {
	        System.out.println((char)(i));
	        count++;
	        if(count == N)
	        break;
	    }
	    i++;
	}
}
}
}
