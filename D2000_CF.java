
import java.util.Scanner;

public class D2000_CF {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        while (t-- > 0) {
            int n = scn.nextInt();
            long arr[]=new long[n];
            for(int i=0;i<n;i++){
                arr[i]=scn.nextLong();
            }
            String str=scn.next();
            
            int low=0;
            int high=n-1;
            long sum=0;
            long prefix[]=new long[n];
            prefix[0]=arr[0];
            for(int i=1;i<n;i++){
                prefix[i]=prefix[i-1]+arr[i];
            }
            while(low<=high){
                if(str.charAt(low)=='L' && str.charAt(high)=='R'){
                    long segmentSum = prefix[high] - (low > 0 ? prefix[low - 1] : 0);
                    sum += segmentSum;
                    low++;
                    high--;
                }else if(str.charAt(low)!='L')low++;
                else if(str.charAt(high)!='R')high--;
            }
            System.out.println(sum);
        }
    }
}
