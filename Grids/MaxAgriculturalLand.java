package Grids;

//Microsoft codility round
//Unsolved
public class MaxAgriculturalLand {
    static int findMax2(String[] land){
        int sum = 0;
        //find max from rows
        int maxRowLength = 0;
        for(int i = 0; i < land.length; i++){
            String row = land[i];
            //find max land in this row
            int current = 0;
            for(int j = 0; j < row.length(); j++){
                char c = row.charAt(j);
                if(c == '.'){
                    current++;
                }
                else{
                    maxRowLength = Math.max(maxRowLength, current);
                    current = 0;
                }
            }
            maxRowLength = Math.max(maxRowLength, current);
            current = 0;
        }


        //find max from columns
        int maxColLength = 0;
        for(int i = 0; i < land[0].length(); i++){ //3
            // String column = land[i];
            int current = 0;
            for(int j = 0; j < land.length; j++){ // 6
                char c = land[j].charAt(i);
                if(c == '.'){
                    current++;
                }else{
                    maxColLength = Math.max(maxColLength, current);
                    current = 0;
                }
            }
            maxColLength = Math.max(maxColLength, current);
            current = 0;
        }

        //from rows and column find top 2 max

        return sum;
    }
    public static void main(String[] args) {
        String[] land = {
            "#.#",
            "#.#",
            "#.#",
            "...",
            "#.#",
        }; //6

        findMax2(land);
    }
}
