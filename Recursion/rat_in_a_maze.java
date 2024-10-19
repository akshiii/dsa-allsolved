import java.util.ArrayList;

public class rat_in_a_maze {
    //condition: mainArr will always be a square matriz N*N 
    static boolean isSafe(int x, int y, int[][] mainArray, int[][] visitedArray){
        if((x >= 0 && x < mainArray.length) &&
            (y >= 0 && y < mainArray.length) &&
            (visitedArray[x][y] == 0) &&
            (mainArray[x][y] == 1)
        ){
            return true;
        }
        else{
            return false;
        }
        
    }
    static void pattern(int[][] mainArray, int[][] visitedArray,  ArrayList<String> patternStr,int x, int y,String path){
        if(x == mainArray.length -1  && y == mainArray.length-1){
            patternStr.add(path);
            return;
        }

        visitedArray[x][y] = 1;

        //D
        int newX = x+1;
        int newY = y;
        if(isSafe(newX, newY, mainArray, visitedArray)){
            path = path + 'D';
            pattern(mainArray,visitedArray,patternStr,newX,newY,path);
            //backtrack
            path = path.substring(0, path.length() -1);
        }

        //L
        newX = x;
        newY = y-1;
        if(isSafe(newX, newY, mainArray, visitedArray)){
            path = path + 'L';
            pattern(mainArray,visitedArray,patternStr,newX,newY,path);
            //backtrack
             path = path.substring(0, path.length() -1);
        }

        //R
        newX = x;
        newY = y+1;
        if(isSafe(newX, newY, mainArray, visitedArray)){
            path = path + 'R';
            pattern(mainArray,visitedArray,patternStr,newX,newY,path);
            //backtrack
             path = path.substring(0, path.length() -1);
        }

        //U
        newX = x-1;
        newY = y;


        if(isSafe(newX, newY, mainArray, visitedArray)){
            path = path + 'U';
            pattern(mainArray,visitedArray,patternStr,newX,newY,path);
            //backtrack
             path = path.substring(0, path.length() -1);
        }

        //backtrack
        visitedArray[x][y] = 0;
    }
    
    public static void main(String[] args) {
        String path = "";
        int[][] mainArr = {
            {1,0,0,0},
            {1,1,0,1},
            {1,1,0,0},
            {0,1,1,1}
        };
        int[][] visitedArray = new int[4][4];
        //initialize visitedArray with 0
        // for(int i = 0; i < visitedArray.length; i++){
        //     for(int j = 0; j < visitedArray.length; j++){
        //         visitedArray[i][j] = 0;
        //     }
        // }
        ArrayList<String> patternStr = new ArrayList<String>();
        if(mainArr[0][0] == 0){
            System.out.println("Wrong input");
        }
        else{
            pattern(mainArr,visitedArray,patternStr,0,0,path);
            for (String str : patternStr) {
                System.out.println(str);
            }
        }
        
        
    }
}
