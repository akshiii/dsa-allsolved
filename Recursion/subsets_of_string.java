

public class subsets_of_string {

    public static String[] powerSet(String str){

        //base case 
        if(str.length()==0){
            String[] wow = {""};
            return wow;
        }

        String[] smallAns = powerSet(str.substring(1));
        String[] ans = new String[2*smallAns.length];

        int k = 0;
        for(int i = 0; i < smallAns.length; i++){
            ans[k++] = str.charAt(0)+smallAns[i];
        }
        for(int i = 0; i < smallAns.length; i++){
            ans[k++] = smallAns[i];
        }

        return ans;
    }
    public static void main(String[] args) {
        String str = "abc";
        String[] ans = powerSet(str);
        // Arrays.sort(ans);
        for(int i = 0; i < ans.length; i++){
            System.out.println(ans[i]);
        }
        
    }
}
