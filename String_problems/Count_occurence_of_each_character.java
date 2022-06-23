/******************************************************************************

Given a string state which character appear how many times

*******************************************************************************/
import java.util.*;
public class Main
{
	public static void main(String[] args) {
		
	Scanner inp = new Scanner(System.in);
    String name = inp.nextLine();
    int[] alpha = new int[26];
    
    for(int i=0; i<26; i++)
    {
        alpha[i] = 0;
    }
    
    for(int i=0; i<name.length(); i++)
    {
        if(name.charAt(i) >='A' && name.charAt(i) <='Z')
        {
            int pos = (int)name.charAt(i) - 65;
            alpha[pos]++;
        }
        
        if(name.charAt(i) >='a' && name.charAt(i) <='z')
        {
            int pos = (int)name.charAt(i) - 97;
            alpha[pos]++;
        }
        
        else
        {
            
        }
    }
    
    for(int i=0; i<26; i++)
    {
        if(alpha[i] != 0)
        {
            System.out.println((char)(i+65) +" or "+(char)(i+97) +" appeared " + alpha[i] + " times");
        }
    }
		
	}
}
