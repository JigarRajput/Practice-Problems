import java.util.*;

public class Main
{
	public static void main(String[] args) {

    Scanner input = new Scanner(System.in);
    String s = input.nextLine();
    String new_str = "";
    String splitted_array [] = s.split(" ");
    for(int i=0;i<splitted_array.length;i++){
     for(int j=0;j<splitted_array[i].length();j++)
     {

         if(j!=0 && j<splitted_array[i].length()-1){
         int a=(int)splitted_array[i].charAt(j);
         String Charact = Character.toString((char)a);
         new_str = new_str + Charact;
         }
         else{
         int a=(int)splitted_array[i].charAt(j);
         String Charact = Character.toString((char)(a-32));    
         new_str = new_str +Charact;
         }
     }
     new_str = new_str + " ";
	}
	System.out.println(new_str);
	}
}
