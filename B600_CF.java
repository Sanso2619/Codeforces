import java.io.*;
import java.util.*;

public class B600_CF {
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st=new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long a[]= new long[n];
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++)a[i]=Integer.parseInt(st.nextToken());

        long b[]=new long[m];
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<m;i++)b[i]=Integer.parseInt(st.nextToken());

        Arrays.sort(a);

        StringBuilder sb=new StringBuilder();
        for(int i=0;i<m;i++){
            long ans=binarySearch(0, n-1, a, b[i]);
            sb.append(ans+1).append(" ");
        }
        System.out.println(sb.toString().trim());

    }
    public static long binarySearch(int low,int high,long a[],long b){
        long ans=-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(a[mid]<=b){
                ans=mid;
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return ans;
    }
}
