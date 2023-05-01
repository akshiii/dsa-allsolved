public class phone_keypad_problem {

    static String[] keypadComb(int keypad,int input, String[] arr){
        if(input == 0){
            String[] wow = {""};
            return wow; 
        }
        
        int digit =  keypad % 10;
        keypad = keypad/10;
        

        String[] smallAns = keypadComb(keypad, digit, arr);
        String[] ans = new String[smallAns.length * arr[input].length()];
        
        int k = 0;
        for(int i = 0; i < arr[input].length() ; i++){
            
            for(int t = 0; t < smallAns.length ; t++){
                String newComb = arr[input];
                ans[k++] = newComb.charAt(i) + smallAns[t];
            }
            
        }

        return ans;
    }
    public static void main(String[] args) {
        String[] arr = {"","","abc", "def","ghi", "jkl","mno","pqrs","tuv","wxyz"};
        int input = 29;
        String[] ans = keypadComb(input/10,input%10,arr);
        for (String string : ans) {
            System.out.println(string);
        }
        
    }
}
