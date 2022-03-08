/******************************************************************************
Four Joggers are jogging on four circular jogging track

Input:
First line contains four iintegers denoting following
R radius of all four circles
D1 denotes distance of centre of second circle from left to centre of the leftmost circle
D2 denotes distance of centre of third circle from left to centre of the leftmost circle
D3 denotes distance of centre of fourth circle from left to centre of the leftmost circle

second line contains four space separated integers denoting the angle with point a of each of 4 circles
where 0 degree indicates point a itself 90 indicates point b 180 indicates point c 270 indicates point d

Third line contains 4 space separated integers denoting velocities in degrees per second 

fourth line indicates 4 space separated integers denoting the direction of running for joggers(0=clockwise and 1=anticlockwise)

fifth line contains the integer N denoting the time in seconds since the start of the jog 

output:
print the summation of length of three segments between the four joggers after N seconds, rounded to nearest integer.

Time Limit 
1 second

Examples
example1 
input 
10 25 50 75
0 0 0 0
1 1 1 1 
1 1 1 1 
90

output 
75

explanation:
every jogger is starting from point a and all have speed of 1 degree per second. So they will be at 90 degree after 90 second.
after connecting these points we get segment lengths as (25 + 25 + 25) = 75

example2
input
10 25 50 75
0 0 0 0 
1 2 3 4
0 0 0 0 
90

output
91

explanation
every jogger is starting from point a. They are jogging at speed of 1,2,3 and 4 degrees per second respectively in clockwise direction.
Hence after 90 seconds they will reach where the segment length between them is (18.027756377319946 + 36.40054944640259 + 36.40054944640259) = 90.8288.
Hence output is 91
*******************************************************************************/
import java.util.*;
public class Main
{
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		// input first line
		int R = input.nextInt();
		int D1 = input.nextInt();
		int D2 = input.nextInt();
		int D3 = input.nextInt();
        
        //input second line (angles)
        int A1 = input.nextInt();
		int A2 = input.nextInt();
		int A3 = input.nextInt();
		int A4 = input.nextInt();
		
		//input third line (velocities)
		int v1 = input.nextInt();
		int v2 = input.nextInt();
		int v3 = input.nextInt();
		int v4 = input.nextInt();
		
		//input fourth line (directions) 
		int dir1 = input.nextInt();
		int dir2 = input.nextInt();
		int dir3 = input.nextInt();
		int dir4 = input.nextInt();
		
		/*input fifth line time*/
		int time = input.nextInt();
		
		//obtain co-ordinates after given time
		double co1x = co_x(R,0,A1,v1,dir1,time);
		double co1y = co_y(R,0,A1,v1,dir1,time);
		
		double co2x = co_x(R,D1,A2,v2,dir2,time);
		double co2y = co_y(R,D1,A2,v2,dir2,time);
		
		double co3x = co_x(R,D2,A3,v3,dir3,time);
		double co3y = co_y(R,D2,A3,v3,dir3,time);
		
		double co4x = co_x(R,D3,A4,v4,dir4,time);
		double co4y = co_y(R,D3,A4,v4,dir4,time);
		
		// calculate distance between these co-ordinates (segments)
		double segmentdistance1 = Math.sqrt((co1x - co2x)*(co1x - co2x) + (co1y - co2y)*(co1y - co2y));
		double segmentdistance2 = Math.sqrt((co2x - co3x)*(co2x - co3x) + (co2y - co3y)*(co2y - co3y));
		double segmentdistance3 = Math.sqrt((co3x - co4x)*(co3x - co4x) + (co3y - co4y)*(co3y - co4y));
		
		System.out.println(segmentdistance1+" "+segmentdistance2+" "+segmentdistance3);
		
		// add these segments
		long totalSegmentLength = Math.round((segmentdistance1+segmentdistance3+segmentdistance2));
		System.out.println(totalSegmentLength);
		
	}
	
	// function to calculate co-ordinate x 
	static double co_x(int R, int dist, int angle, int velocity, int direction, int time)
	{
	    double x;
	    
	    if(direction == 1) // if they are moving anticlockwise
	    {
	        angle = angle + velocity*time; 
	    }
	    
	    if(angle >= 360 ) // if angle becomes > 360 
	    {
	        angle = angle - 360;
	    }
	    
	    
	    if(direction == 0) // if they are moving clock-wise
	    {
	        angle = angle - velocity*time;
	        if (angle < 0)
	        {
	            angle = angle + 360;
	            
	        }
	    }
	    

	    x = R*Math.cos(Math.toRadians(angle)) + dist ; // formula to calculate x co-ordinate according to formula x = rcos(theta) + a where a is distance from origin where theta is the angle subtended with positive x-axis
	    
	    return x;
	}
	
	static double co_y(int R, int dist, int angle, int velocity, int direction,int time)
	{
	    double y;
	    
	    if(direction == 1)
	    {
	        angle = angle + velocity*time;
	    }
	    
	    if(angle >= 360 )
	    {
	        angle = angle - 360;
	    }
	    
	    
	    if(direction == 0)
	    {
	        angle = angle - velocity*time;
	        if (angle < 0)
	        {
	            angle = angle + 360;
	            
	        }
	    }
	    
	  
	    
	    y = R*Math.cos(Math.toRadians(angle)); // formula to calculate y co-ordinate according to formula y = rsin(theta) where theta is the angle subtended with positive x-axis
	    
	    return y;
	}
}
