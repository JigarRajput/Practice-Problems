/*
Question – : There are two banks – Bank A and Bank B. Their interest rates vary. You have received offers from both banks in terms of the annual rate of interest, tenure, and variations of the rate of interest over the entire tenure.You have to choose the offer which costs you least interest and reject the other. Do the computation and make a wise choice.

The loan repayment happens at a monthly frequency and Equated Monthly Installment (EMI) is calculated using the formula given below :

EMI = loanAmount * monthlyInterestRate / ( 1 – 1 / (1 + monthlyInterestRate)^(numberOfYears * 12))

 

Constraints:

1 <= P <= 1000000
1 <=T <= 50
1<= N1 <= 30
1<= N2 <= 30
 

Input Format:

First line: P principal (Loan Amount)
Second line: T Total Tenure (in years).
Third Line: N1 is the number of slabs of interest rates for a given period by Bank A. First slab starts from the first year and the second slab starts from the end of the first slab and so on.
Next N1 line will contain the interest rate and their period.
After N1 lines we will receive N2 viz. the number of slabs offered by the second bank.
Next N2 lines are the number of slabs of interest rates for a given period by Bank B. The first slab starts from the first year and the second slab starts from the end of the first slab and so on.
The period and rate will be delimited by single white space.
 

Output Format: Your decision either Bank A or Bank B.

 

Explanation:

Example 1
Input
10000
20
3
5 9.5
10 9.6
5 8.5
3
10 6.9
5 8.5
5 7.9
Output: Bank B
 

Example 2
Input
500000
26
3
13  9.5
3  6.9
10  5.6
3
14  8.5
6  7.4
6  9.6
Output: Bank A
*/











import java.util.Scanner;
public class Main
{
	public static void main(String[] args) {
		 
     Scanner input = new Scanner(System.in);
     
     int P = input.nextInt();
     int T = input.nextInt();
     int N1 = input.nextInt();

// bank 1 inputs   
     double bank1[][] = new double[N1][2];
     
     for(int i=0; i<N1; i++)
     {
         for(int j=0; j<2; j++)
         {
             bank1[i][j] = input.nextDouble();
         }
     }

//bank 2 inputs
  int N2 = input.nextInt();
     
    double bank2[][] = new double[N2][2];
     
     for(int i=0; i<N2; i++)
     {
         for(int j=0; j<2; j++)
         {
             bank2[i][j] = input.nextDouble();
         }
     }     
   
// EMI CALCULATIONS   
double  EMI_A=0;
for(int i=0; i<N1; i++)
{
    int year = (int)bank1[i][0];
    double rate = bank1[i][1];
    
    EMI_A = EMI_A + (P*rate)/(1-1/Math.pow((1+rate),year*12));
}

// EMI CALCULATIONS
double  EMI_B=0;
for(int i=0; i<N2; i++)
{
    int year = (int)bank2[i][0];
    double rate = bank2[i][1];
    
    EMI_B = EMI_B + (P*rate)/(1-1/Math.pow((1+rate),year*12));
}
 
 if(EMI_A <= EMI_B)
 System.out.println("BANK A");
 
 else
 System.out.println("BANK B");
   
     
	}
}
