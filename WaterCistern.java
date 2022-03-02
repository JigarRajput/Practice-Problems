/******************************************************************************
Jai Ganesh

Water Cistern
A cylindrical water cistern was built in an apartment complex in Aquatown. The bottom rests on concrete and is not accessible. It has a height h and a radius r,

Problem Description
A cylindrical water cistern was built in an apartment complex in Aquatown. cyllender

The bottom rests on concrete and is not accessible. It has a height h and a radius r,

A mathematical bug is sitting on the cistern at point A, and has established a coordinate system to cover the entire accessible area. The bug is sitting a distance s from the top of the cistern, and the nearest point at the top is B.

For a point C on the curved surface, the nearest point D on the top is determined, and the distance CD is taken as t. The angle p (in degrees) subtended at the centre of the circle E by the arc BD is measured (in a counterclockwise manner). The coordinates of C are taken as the pair (t,p), with t being greater than 0 and less than h, and with p being between 0 and 359 (inclusive).

For a point on the top surface, F, the distance to the centre E is taken (a), and the counterclockwise angle (in degrees) between EF and EB is taken. The coordinates of the point F are then taken as (-a,q). The value of a is between 0 and r, and the value of q is between 0 and 359.

All coordinates are integers, and if the point is on the top surface of the cylinder, the first coordinate is negative, and if it is on the curved surface of the cylinder, the first coordinate is positive.

From its staring point A, the bug needs to go to its destination, which is a point (like C or F) either on the curved surface or the top surface. The coordinates of the destination are given. The bug would like to go by the shortest path to its destination.

The goal is to determine the length of the shortest path the bug can take.

Input
The first line has three comma separated positive integers giving r (the radius), h (the height of the cylinder) and s (the distance from the top of the starting point of the bug)

The next line has two comma separated integers (d and g) giving the coordinates of the destination. If the first integer (d) is negative, it is on top surface of the cylinder, and else it is on the curved surface of the cylinder

Output
The output is a single integer giving the shortest distance that the bug can travel. The computed distance must be rounded to the nearest integer

Constraints
40<s<=h<10000

r<100

0<=g<=359

If d is negative, d > -r

If d is positive, d < h

Difficulty Level
Complex

Time Limit (secs)
1

Examples
Example 1

Input

100,500,200

200,180

Output

314

Explanation

The value of r is 100, and h is 500. The distance of the bug from the top surface is 200.

The coordinates of the destination are (200,180). As the first coordinate is 200, the destination is on the curved surface (like point C), and at the same distance from the top surface as the bug. As the second coordinate is 180, the destination is exactly on the other side of the cylinder at the same height as the bug, The distance is half the circumference of the cylinder, or 314. This is the output.

Example 2

Input

100,500,200

-50,180

Output

350

Explanation

The value of r is 100, and h is 500. The distance of the bug from the top surface is 200.

The coordinates of the destination are (-50,180). As the first coordinate is negative (-50), the point is on the top surface of the cylinder (like point F), and EF is 50. As the second coordinate is 180, BEF is a straight line. The distance travelled is AB + BE + EF = 200 + 100 + 50=350. This is the output.

*******************************************************************************/
import java.util.*;
public class Main
{
	public static void main(String[] args) {

    int min_dis = 0;
    Scanner input = new Scanner(System.in);
    String[] values = input.nextLine().split(",");
    int r = Integer.parseInt(values[0]);
    int h = Integer.parseInt(values[1]);
    int s = Integer.parseInt(values[2]);
    

    
    String destination[] = input.nextLine().split(",");
    int des = Integer.parseInt(destination[0]);
    int angle = Integer.parseInt(destination[1]);
    
    if(des < 0)
    {
        // if angle == 180 just add radius and distance
        if(angle == 180)
        {
            min_dis = (int)(s + r + Math.abs(des));
        }
        
        
        // if angle is more than 180 then, first convert it to less than 180 because we want to find the third side of triangle that is getting formed
        else if(angle > 180)
        {
            angle = 360 - angle;
            min_dis =  (int)(s + Math.sqrt(r*r + Math.abs(des)* Math.abs(des) - 2*r*Math.abs(des)*Math.cos(Math.toRadians(angle))));
            
        }
        
        //else just find the distance        
        else
        {
            min_dis =  (int)(s + Math.sqrt(r*r + Math.abs(des)* Math.abs(des) - 2*r*Math.abs(des)*Math.cos(Math.toRadians(angle))));
        }
    }
    
    //if des is > 0 then, the destination is on the cylindrical surface and we want to find the length of arc getting formed
    else
    {
        min_dis = (int)(Math.abs(s-des) + (Math.PI * r * angle)/180);
    }
    
    System.out.println(min_dis);
    
	}
}

