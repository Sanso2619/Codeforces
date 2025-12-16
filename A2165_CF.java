import java.util.*;
public class A2165_CF {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t=scn.nextInt();

        while(t-->0){
            int n=scn.nextInt();
            long arr[]=new long[n+1];
            for(int i=0;i<n;i++) arr[i]=scn.nextLong();
            int idx=0;
            long max=-1;
            for(int i=0;i<n;i++){
                if(arr[i]>max){
                    max=arr[i];
                    idx=i;
                }
            }
            arr[n]=arr[0];
            long sum=-arr[idx];
            for(int i=0;i<n;i++){
                sum+=Math.max(arr[i],arr[i+1]);
            }
            System.out.println(sum);

        }
    }
}
