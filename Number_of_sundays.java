/******************************************************************************

Jack is always excited about sunday. It is favourite day, when he gets to play all day. And goes to cycling with his friends. 

So every time when the months starts he counts the number of sundays he will get to enjoy. Considering the month can start with any day, be it Sunday, Monday…. Or so on.

Count the number of Sunday jack will get within n number of days.

 Example 1:

Input 

mon-> input String denoting the start of the month.

13  -> input integer denoting the number of days from the start of the month.

Output :

2    -> number of days within 13 days.

Explanation:

The month start with mon(Monday). So the upcoming sunday will arrive in next 6 days. And then next Sunday in next 7 days and so on.

Now total number of days are 13. It means 6 days to first sunday and then remaining 7 days will end up in another sunday. Total 2 sundays may fall within 13 days.

*******************************************************************************/
import java.util.Scanner;
public class Main
{
	public static void main(String[] args) {

    Scanner input = new Scanner(System.in);
    String day = input.next();
    int days = input.nextInt();
    
    int remaining = 0;
    
    
    //if months starts from particular day then it will have following remaining after completing weeks
    if(day.equalsIgnoreCase("mon"))
    {
        remaining = 6;
    }
    
    else if(day.equalsIgnoreCase("tue"))
    {
        remaining = 5;
    }
    
    else if(day.equalsIgnoreCase("wed"))
    {
        remaining = 4;
    }
    
    else if(day.equalsIgnoreCase("thu"))
    {
        remaining = 3;
    }
    
    else if(day.equalsIgnoreCase("fri"))
    {
        remaining = 2;
    }
    
    else if(day.equalsIgnoreCase("sat"))
    {
        remaining = 1;
    }
    
    // quotient(getDirect) denotes that this many days will be sure for any week day
    int getDirect = (int)days/7;
    
    // remainder(getIndirect) denotes that this many days will be remaining after completing weeks so if
    // remaining number of days are more than or equal to the number of days to sunday than we will get one more sunday
    int getIndirect = days%7;
    
    if(getIndirect >= remaining)
    {
        getDirect = getDirect + 1;
    }
    
    System.out.println(getDirect);

	}
}
