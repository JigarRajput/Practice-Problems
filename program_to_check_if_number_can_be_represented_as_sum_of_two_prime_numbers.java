/******************************************************************************
Enter a number : 34
34 = 3 + 31
34 = 5 + 29
34 = 11 + 23
34 = 17 + 17

Enter a number : 23
23 cannot be expressed as a sum of two prime numbers

*******************************************************************************/


import java.util.Scanner;
public class Main{

    public static void main(String[] args){
        
    Scanner input = new Scanner(System.in);
    int x = input.nextInt();
    int flag = 0;
    int[] array = new int[x];
    
    int[] array1 = fill_primes(array);
    int[] flag_array = new int[x];  
    
    for(int i=0; i<array.length; i++){
    flag_array[i] = 0;
    }
        for(int i=0; i<array1.length; i++){
            for(int j=0; j<array1.length; j++){
                if((x == array1[i] + array1[j]) && flag_array[i] == 0  && flag_array[j] ==0){
                    flag = 1;
                    flag_array[i] = 1;
                    flag_array[j] = 1;
                    System.out.println(x + "=" + array1[i] + "+" + array1[j]);
                }
                
            }

        }
    if(flag == 0){
        System.out.println(x + " cannot be expressed as a sum of two prime numbers");
    }    
        
    }
    
    static int[] fill_primes(int array[]){
        
     for(int i=0; i<array.length; i++){
         
         if(check_prime(i) == 0){
             array[i] = 0;
         }
         else{
             array[i] = i;
         }
         
     }
     return array;
    }
    
    static int check_prime(int i){
        int flag = 0;
        if(i == 1 || i== 0){
            return 0;
        }
        else{
        for(int j=2; j<i;j++){
            if(i%j == 0){
                flag = 1;
                break;
            }
        }
        if(flag == 1){
            return 0;
        }
        else
            return 1;
    }
  }
}
