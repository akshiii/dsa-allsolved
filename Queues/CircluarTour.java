package Queues;

//Very Imp question https://www.geeksforgeeks.org/problems/circular-tour-1587115620/1
public class CircluarTour {
    static int findStartingPoint(int petrol[], int distance[]){
        int deficit = 0;
	    int balance = 0;
	    int start = 0;
	    for(int i = 0; i < petrol.length; i++){
	        balance = balance + petrol[i] - distance[i];
	        if(balance < 0){
	            deficit = deficit + balance;
	            start = i + 1 ;
	            balance = 0;
	        }
	    }
	    
	    if(deficit + balance >= 0){
	        return start;
	    }
	    else return -1;
    }
    public static void main(String[] args) {
        int[] petrol = {4 ,6 ,7 ,4};
        int distance[] = {6,5,3,5}; //1

        // int[] petrol = {55 ,33 ,77 ,40 };
        // int distance[] = {52 ,100 ,61 ,69 }; // -1 ( not possible)
        System.out.println("Starting point = "+findStartingPoint(petrol,distance));
    }
}
