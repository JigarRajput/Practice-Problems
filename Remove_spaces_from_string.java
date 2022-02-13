import java.util.Scanner;
import java.lang.String;
public class Main
{
	public static void main(String[] args) {
	Scanner input = new Scanner(System.in);
	
	System.out.println("Enter Your string:\t");
	String str = input.nextLine();
	String new_str = "";

	for(int i=0;i<str.length();i++)
	{
	    if(str.charAt(i) != ' ')
	    new_str = new_str + str.charAt(i);
	}
	System.out.println(new_str);
	}
}
