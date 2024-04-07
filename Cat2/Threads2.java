
// B.

// Create a Java program for an IPL team named CSK (Chennai Super Kings). The program should implement a class called TeamScore, which stores the scores of 5 players who batted first. Use a random number generator to generate scores for each player between 0 and 100. Additionally, implement a thread to calculate and display the total score of the team. 

import java.util.Random;


class TeamScore {
    private int[] scores;

    public TeamScore() {
        scores = new int[5];
        generateScores();
    }

    private void generateScores() {
        Random random = new Random();
        for (int i = 0; i < scores.length; i++) {
            scores[i] = random.nextInt(101); 
        }
    }
    public int gettotalscore()
    {
        int sum=0;
        for(int i:scores )
        sum+=i;
        return sum;   
    }

    public void displayscore()
    {
        for (int i = 0; i < scores.length; i++) {
            System.out.println("Batsman number "+i+"=> "+scores[i]);
        }
    }
}

class TeamScoreThreads extends Thread
{
    public TeamScore teamscore;

    public  TeamScoreThreads(TeamScore teamscore) {
        this.teamscore = teamscore;
    }

    @Override 
    public void run()
    {
        teamscore.displayscore();
        System.out.println("Total score is =>");
        teamscore.gettotalscore();
    }
}


public class Threads2 {
    public static void main(String[] args) 
    {
        TeamScore teamscore=new TeamScore();
        TeamScoreThreads teamscorethreads=new TeamScoreThreads(teamscore);
        teamscorethreads.start();
    }
}
