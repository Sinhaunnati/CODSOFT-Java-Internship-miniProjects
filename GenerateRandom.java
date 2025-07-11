import java.util.*;
public class GenerateRandom {
 public static void main(String[] args){
    int score=0;
    int totalRounds=0;
    Scanner playAgain=new Scanner(System.in);
    String Ask="Yes";
    while(Ask.equalsIgnoreCase("Yes")){
    totalRounds++;
    Random rand=new Random();
    int RdInt=rand.nextInt(100);
    System.out.println(RdInt);
    Scanner sc=new Scanner(System.in);
    System.out.print("Enter the guess:");
    int Guess=sc.nextInt();
    boolean Correctlyguessed =false;
    if(RdInt==Guess){
        System.out.println("Correctly Guessed");
        Correctlyguessed=true;
        score++;
    
     }
     else{
        if(RdInt>Guess){
            System.out.println("too low");
        }
        else{
            System.out.println("too high");
        }
        int max=3;
        for(int i=0;i<max;i++){
        System.out.print("Enter the guess again:");
        int Guessagain=sc.nextInt();
        if(RdInt==Guessagain){
            System.out.println("Correctly guessed");
            Correctlyguessed=true;
            score++;
            break;
        }
        else if(RdInt>Guessagain){
        System.out.println("too low");
    }
       else{
        System.out.println("too high");
          }
}
     }
if(!Correctlyguessed){
System.out.println("Ohh! Sorry,You're out of attempts.");
System.out.println("The correct number was:"+RdInt);
    }

    System.out.println("Do you want to play again?(Yes/No):");
    Ask=playAgain.next();
}
    System.out.println("\nGame Over!");
    System.out.println("Total Rounds played:"+totalRounds);
    System.out.println("Rounds won:"+score);
    playAgain.close();
}
}

    
