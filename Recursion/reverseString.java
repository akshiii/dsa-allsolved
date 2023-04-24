public class reverseString {


    static StringBuilder reverse(StringBuilder mystr, int i, int j){
        if(i > j){
            return mystr;
        }

        char char1 = mystr.charAt(i);
        char char2 = mystr.charAt(j);
        mystr.setCharAt(i, char2);
        mystr.setCharAt(j, char1);

        return reverse(mystr, i+1, j-1);
        
    }

    public static void main(String[] args) {
        //Reverse a string with recursion
        StringBuilder myStr = new StringBuilder( "paints");

        System.out.println("Reversed : "+ reverse(myStr,0,myStr.length() -1));
    }
}
