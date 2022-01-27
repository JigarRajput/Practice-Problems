/*

A solid cube of 10 cm x 10cm x 10 cm rests on the ground. It has a beetle on it, and some sweet honey spots at various locations on the surface of the cube. The beetle starts at a point on the surface of the cube and goes to the honey spots in order along the surface of the cube.

If it goes from a point to another point on the same face (say X to Y), it goes in an arc of a circle that subtends an angle of 60 degrees at the center of the circle
If it goes from one point to another on a different face, it goes by the shortest path on the surface of the cube, except that it never travels along the bottom of the cube
The beetle is a student of cartesian geometry and knows the coordinates (x, y, z) of all the points it needs to go to. The origin of coordinates it uses is one corner of the cube on the ground, and the z-axis points up.Hence, the bottom surface (on which it does not crawl) is z=0, and the top surface is z=10.The beetle keeps track of all the distances traveled, and rounds the distance traveled to two decimal places once it reaches the next spot so that the final distance is a sum of the rounded distances from spot to spot.

Input Format:

The first line gives an integer N, the total number of points (including the starting point) the beetle visits

The second line is a set of 3N comma separated non-negative numbers, with up to two decimal places each. These are to be interpreted in groups of three as the x, y, z coordinates of the points the beetle needs to visit in the given order.
Output Format:

 One line with a number giving the total distance traveled by the beetle accurate to two decimal places. Even if the distance traveled is an integer, the output should have two decimal places

*/

import java.util.Scanner;
public class Main
{
public static void main(String[] args) {
		
		
		Scanner input = new Scanner(System.in);
		
		int N = input.nextInt();
        
        int co_ordinates[][] = new int[N][3];
		
		input.nextLine();
		String in = input.nextLine();
		
		String array[] = in.split(","); 
		
		double distance = 0.00;
		
		int s_c=0;
		for(int i=0;i<N && s_c<array.length;i++)
		{
		    for(int j=0; j<3; j++)
		    {
		    co_ordinates[i][j] = Integer.parseInt(array[s_c]);
		    s_c++;
		    }
		 }
	
	   for(int i=0; i<N-1; i++)
	   {
	      if(co_ordinates[i][0] == co_ordinates[i+1][0] || co_ordinates[i][1] == co_ordinates[i+1][1] || co_ordinates[i][2] == co_ordinates[i+1][2])
	      {
	          //moving on same surface
	          distance = distance + ((Math.PI*2)/6);
	          distance = (double)(distance*100)/100; // Rounding to two decimal digits
	      }
	      
	      else{ 
	          //moves to other surface
	      distance = distance + Math.round(Math.sqrt(Math.pow((co_ordinates[i+1][0]-co_ordinates[i][0]),2) + Math.pow((co_ordinates[i+1][1]-co_ordinates[i][1]),2) + Math.pow((co_ordinates[i+1][2]-co_ordinates[i][2]),2)));
	      distance = (double)(distance*100)/100;  // Rounding to two decimal digits
	      }
	      }
	
System.out.printf("%.2f",distance);
		
	
}	
}
