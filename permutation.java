
import java.util.ArrayList;

public class permutation {
    static boolean visited[][];
 public static void main(String[] args) {
    
   // char maze[][]={{'+','+','.','+'},{'.','.','.','+'},{'+','+','+','.'}};
    char maze[][]={{'+','+','+'},{'.','.','.'},{'+','+','+'}};
    int entrance[]={1,0};
    System.out.println(nearestExit(maze, entrance));
    
 }
 public static int nearestExit(char[][] maze, int[] entrance) {
    visited=new boolean[maze.length][maze[0].length];
    ArrayList<Integer> ans=new ArrayList<>();
    rec(maze,entrance[0],entrance[1],ans,0,entrance);
    System.out.println(ans);
    int min=Integer.MAX_VALUE;
    for(int i:ans)
    min=Math.min(i,min);
    return min == Integer.MAX_VALUE ? -1 : min;

 }

 public static  void rec(char[][] maze, int r, int c,ArrayList<Integer>ans,int steps,int [] entrance)
 {
    if(r<0 || c<0 || r>=maze.length || c>=maze[0].length || maze[r][c]=='+' || visited[r][c])
    return;

    if (r!=entrance[0] ||  c!=entrance[1] && (r==0 || c==0 || r==maze.length-1 || c==maze[0].length-1)) {
        ans.add(steps);
        return;
    }
    visited[r][c]=true;
    rec(maze,r+1,c,ans,steps+1,entrance);
    rec(maze,r,c+1,ans,steps+1,entrance);
    rec(maze,r,c-1,ans,steps+1,entrance);
    rec(maze,r-1,c,ans,steps+1,entrance);
    visited[r][c]=false;
 }
    
}


 