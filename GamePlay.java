import java.util.Scanner;
import java.util.Random;
public class GamePlay {
    public int over, runOne=0, teamone=0, teamtwo=0, balls, gameNumber=0, runs, wicket = 0, inning;
    public Boolean wicketFlag = false; // checks if a wicket has been hit or not
    Scanner sc = new Scanner(System.in);
    Random rand = new Random(); // for run generation
    Random randWicket = new Random(); // for wicket generation
    public GamePlay(){
        System.out.println("Enter the number of overs to be played:");
        over = sc.nextInt();
        while(gameNumber<3){ // total number of games is 3
            gameNumber++;
            System.out.println("---------------------------");            
            System.out.println("GAME NUMBER: " + gameNumber);
            System.out.println("---------------------------");
            for(inning = 1; inning <= 2; inning++){ // there are two innings in each game
                runs = 0;
                wicket = 0;
                System.out.println("---------------------------");
            System.out.println("|Team " + inning + " are batting now.  |");
            System.out.println("---------------------------");
            balls = 0;
            while(balls != (6 * over)){ // keep the balls coming until the inning is done
                balls++;
                if(wicket!=10){
                    Boolean x = wicketHit();    // call the wicketHit() function which checks wicket hits
                    if(!x){ // if no wicket is hit, continue hitting runs
                        hitRun();
                    }
                    else{
                        wicket++; // increase wicket count and move on to the next ball
                        continue;
                    }
                }  
                  
            }
        }
        winnerDecision(); // check the winner
    }
        if(teamone>teamtwo){ // winner of the three games
            System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
            System.out.println("TEAM 1 ARE THE ULTIMATE WINNERS!");
            System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        }
        else {
            System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
            System.out.println("TEAM 2 ARE THE ULTIMATE WINNERS!");
            System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        }
    }

    public void hitRun(){
       System.out.println("Ball number: "+ balls);
       runs = runs + rand.nextInt(7)+0;
       System.out.println("The run is: "+runs);
       if(inning==1){
           runOne = runs;
       }

    }

    public void winnerDecision() {
        if(runOne>runs){
            System.out.println("+++++++++++++++++++++++");
            System.out.println("Team 1 win!");
            System.out.println("+++++++++++++++++++++++");
            teamone++;
        }
        else{
            System.out.println("+++++++++++++++++++++++"); 
            System.out.println("Team 2 win!");
            System.out.println("+++++++++++++++++++++++");   
            teamtwo++;
        }
    }

    public Boolean wicketHit(){
        wicketFlag = randWicket.nextBoolean();
        if(wicketFlag){
            System.out.println("And it's a wicket! It's wicket number: "+ (wicket+1) + " in ball number: "+balls);
            return true;
        }
        else{
            return false;
        }
    }
}