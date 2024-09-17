package Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

// https://leetcode.com/problems/course-schedule/
public class CourseSchedule {
    public static void main(String[] args) {
        int[][] prerequisites = {{1,0}}; //true
        int numCourses = 2;
        System.out.println(canFinish(numCourses, prerequisites));

        int[][] p = {{1,0},{0,1}}; //false
        int numCourses1 = 2;
        System.out.println(canFinish(numCourses1, p));

        int[][] p1 = {{1,4},{2,4},{3,1},{3,2}};
        int numCourses2 = 5;
        System.out.println(canFinish(numCourses2, p1));
    }

    static boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer , Boolean> visited = new HashMap<>();
        for(int i = 0; i< numCourses; i++){
            visited.put(i,false);
        }

        for(int i = 0; i < numCourses; i++){
            if(visited.get(i) == false){
                boolean ans = isCycleDetected(numCourses,prerequisites,visited);
                if(ans){
                    return false;
                }
            }
        }
        return true;
    }

    

    static boolean isCycleDetected(int numCourses, int[][] prerequisites, Map<Integer , Boolean> visited ){

        ArrayList<ArrayList<Integer>> adj= new ArrayList<>(); // creating our adj list
        for(int i= 0; i< numCourses; i++){
            adj.add(new ArrayList<>());
        }

        int m = prerequisites.length; // converting the input prerequisites to adjList Step1
        for(int i=0;i<m;i++){
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        int[] indegree = new int[numCourses];

        for(int i=0; i< numCourses; i++){   // marking the incoming edges (incoming edges) of node node Step2
            for(int it: adj.get(i)){
                indegree[it]++;
            }
        }
 
        //Step 2 : Push all 0 indegree nodes 
        Queue<Integer> queue = new LinkedList();
        for(int i = 0; i < indegree.length ; i++){
            if(indegree[i] == 0){
                queue.add(i);
            }
        }

        //Step 3: Do BFS
        int count = 0;
        while(!queue.isEmpty()){
            int front = queue.remove();

            count++;

            // if(adj.contains(front)){
                for (int neighbour : adj.get(front)) {
                    indegree[neighbour]--;
                    if(indegree[neighbour] == 0){
                        queue.add(neighbour);
                    }
                }
            // }
        }

        if(count != numCourses){
            //we found a invalid topological sort, hence a cycle is detected
            return true;
        }
        else{
            return false;
        }
    }

}