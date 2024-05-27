package Binary_search;

//Same as Book Alocation Problems 
//Same as - Divide an Array into N sub-arrays so  that the largest sum of any subarray is minimum
class PaintersPartitionProblem{
    public static void main(String[] args) {
        int[] arr = {5 ,10 ,30 ,20 ,15};
        int painters = 3;
        System.out.println("Min time= "+minTime(arr, arr.length, painters));
    }
    static long minTime(int[] arr,int n,int painters){
        //code here
        int start = 0;
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        
        int end = sum;
        int ans = -1;
        
        int mid = (start + end) / 2;
        
        while (start <= end) {
            if (isPossibleSolution(arr,painters, mid)) {
              ans = mid;
              end = mid - 1;
            } else {
              start = mid + 1;
            }
            mid = (start + end) / 2;
        }
        return ans;
    }
    
    static boolean isPossibleSolution(int[] arr, int students, int mid){
      int studentCount = 1;
      int pageSum = 0;
    
      for (int i = 0; i < arr.length; i++) {
        if (pageSum + arr[i] <= mid) {
          pageSum += arr[i];
        } else {
          studentCount++;
          if (studentCount > students || arr[i] > mid) {
            return false;
          }
          // this page sum is  for new student thats why we are only assigning new value and not adding with previous one
          pageSum = arr[i];
        }
      }
      return true;
    }
}