import java.util.Arrays;
import java.util.Scanner;

public class Task2 {

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the No of Subjects");
        int ns = sc.nextInt();
        int sum = 0;
        int[] marks = new int[ns];
        for(int i=0; i<ns; i++)
        {
            System.out.println("Enter marks for Subject"+ (i+1) + " = ");
            marks[i] = sc.nextInt();
            sum = sum + marks[i];
        }
        System.out.println("Your Marks=" + Arrays.toString(marks));
        System.out.println("Total Marks=" +sum);
        int per = sum/ns;
        System.out.println("Percentage=" + per);
        System.out.println("Grade:");
        if(per >=1 && per <= 35){ System.out.println("F");}
        else if(per > 35 && per <= 45){System.out.print("E");}
        else if(per > 45 && per <= 55){System.out.print("D");}
        else if(per > 55 && per <= 65){System.out.print("C");}
        else if(per > 65 && per <= 75){System.out.print("B");}
        else if(per > 75 && per <= 85){System.out.print("A");}
        else if(per > 85){System.out.print("O");}
        sc.close();
    }
}
