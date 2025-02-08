import java.util.*;
public class Course_Schedule_Graph {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean indegRes = false;
        boolean outdegRes = false;

        int[] indegree = new int[numCourses + 1];
        int[] outdegree = new int[numCourses + 1];

        for(int[] t : prerequisites){
            indegree[t[0]]++;
            outdegree[t[1]]++;
        }

        for(int i = 0; i < indegree.length; i++){
            if(indegree[i] == 0 ){
                indegRes = true;
            }
            else if(outdegree[i] == 0){
                outdegRes = true;
            }
        }

        return indegRes && outdegRes;
    }
    public static void main(String[] args) {
        System.out.println(canFinish(2, new int[][]{{1,0}}));
    }
}
