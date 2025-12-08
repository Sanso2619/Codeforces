
import java.util.*;

public class B1613 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        while (t-- > 0) {
            HashSet<Integer> set = new HashSet<>();
            int n=scn.nextInt();
            int arr[]=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=scn.nextInt();
                set.add(arr[i]);
            }
            Arrays.sort(arr);
            int count=0;
            int max=n/2;
            for(int i=0;i<n;i++){
                int x = arr[i];
                for(int j=i+1;j<n;j++){
                    int y=arr[j];
                    int mod;
                    if(count==max){
                        break;
                    }
                    int big=Math.max(x,y);
                    int smol=Math.min(x,y);
                    mod=big%smol;
                    if(big!=smol && !(set.contains(mod))){
                        count++;
                        System.out.println(big+" "+smol);
                    } 
                }
            }
        }
    }
}
