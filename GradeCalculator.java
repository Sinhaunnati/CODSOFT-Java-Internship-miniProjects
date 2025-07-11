import java.util.*;

public class GradeCalculator {
    public static void Grades(int AvgPercentage){
        if(AvgPercentage>90){
            System.out.print("Congrats! You obtained an A+.");
        }
        else if(AvgPercentage>80){
            System.out.print("Good,You obtained an B+.");
        }
         else if(AvgPercentage>70){
            System.out.print("You obtained an C+.");
        }
        else if(AvgPercentage>60){
            System.out.print("You obtained an D+.");
        }
        else if(AvgPercentage>50){
            System.out.print("You obtained an E+.");
        }
        else{
            System.out.print("Try Harder next time! ");
        }
    }
     public static int AvgPercentage(int Totalmarks,int totalNumber){
        int AveragePercentage=Totalmarks/totalNumber;
        return AveragePercentage;
    }
    public static int Totalmarks(int arr[]){
    int sum=0;
    for(int i=0;i<arr.length;i++){
        sum+=arr[i];
    }
    System.out.print("Total marks obtained:");
        return sum;
    }
    public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    System.out.print("The number of subjects are:");
    int totalNumber=sc.nextInt();
    int marks[]=new int[totalNumber];
    for(int i=0;i<totalNumber;i++){
        System.out.print("Marks"+ (i+1)+":");
        marks[i]=sc.nextInt();
    }
    int totalobtained=Totalmarks(marks);
    System.out.println(totalobtained);
    int Avgpercent=AvgPercentage(totalobtained,totalNumber);
    System.out.println("The average percentage is:"+ Avgpercent);
    Grades(Avgpercent);
}

}