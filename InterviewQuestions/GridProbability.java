package InterviewQuestions;

//  Given a 2-D grid of m x n of students who are writting an exam. Probability of getting caught while passing a chit is 50% 
// if chit is passed in ( same row ), 25% if in the same column. Given source & destination , 
// find the probability of getting caught. 
public class GridProbability {

    static double findProbability(int[][] path){
        if(path.length <= 1){
            return 0;
        }

        double pro = 0;

        int firstLevelGap = path[1][0]  -  path[0][0];
        if(firstLevelGap > 0 ){
            //we went down
            pro = 0.45;
        }
        else if(firstLevelGap < 0){
            //we went up
        }
        else if(firstLevelGap == 0){
            //stayed ons same level
            pro = 0.9;
        }

        firstLevelGap = path[1][0];

        double previous = pro;
        for(int i = 2; i < path.length ; i++){
            if(path[i][0] - firstLevelGap > 0){
                //down
                pro = 1 - pro*(1 - 0.5);
            }else if(path[i][0] - firstLevelGap < 0){
                //we went up
            }
            else if(path[i][0] - firstLevelGap == 0){
                //stayed ons same level
                pro = pro + pro*(1 - pro);
            }

            // double newPro1 =  ( Math.pow(0.5, path[i][0] + 1)) ;
            // double newPro = pro * newPro1;
            // pro = pro + (1- pro)* (path[i][0]/10);
        }


        return pro;
    }           
    public static void main(String[] args) {
        int[][] path = {{0,1},{0,2},{0,3}}; // 99%  or //0.99
        int[][] path1 = {{0,1},{0,2},{1,2}}; // 95%
        System.out.println("Probability "+findProbability(path1)); 

    }
}
