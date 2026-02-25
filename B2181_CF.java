
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class B2181_CF {
    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);
        int t=scn.nextInt();

        while(t-->0){
            int n=scn.nextInt();
            int m =scn.nextInt();

            PriorityQueue<Long>Alice=new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Long>Bob= new PriorityQueue<>(Collections.reverseOrder());

            for(int i=0;i<n;i++)Alice.add(scn.nextLong());
            for(int i=0;i<m;i++)Bob.add(scn.nextLong());

            boolean isAlice=true;

            while(!Alice.isEmpty() && !Bob.isEmpty()){
                if(isAlice){
                    long x=Alice.peek();
                    long y =Bob.remove();
                    if(y>x){
                        Bob.add(y-x);
                    }
                }else{
                    long x=Bob.peek();
                    long y=Alice.remove();
                    if(y>x){
                        Alice.add(y-x);
                    }
                }
                isAlice=!isAlice;
            }

            System.out.println(Alice.isEmpty()?"Bob":"Alice");
        }
    }
}
