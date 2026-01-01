import java.io.*;
import java.util.*;

public class A1470_CF {
    public static void main(String[] args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder out =new StringBuilder();
        int t=Integer.parseInt(br.readLine());

        while(t-->0){
            st=new StringTokenizer(br.readLine());
            int n=Integer.parseInt(st.nextToken());
            int m=Integer.parseInt(st.nextToken());

            int k[]=new int[n];
            st=new StringTokenizer(br.readLine());
            for(int i=0;i<n;i++)k[i]=Integer.parseInt(st.nextToken());

            long c[]=new long[m];
            st=new StringTokenizer(br.readLine());
            for(int i=0;i<m;i++)c[i]=Long.parseLong(st.nextToken());

            Arrays.sort(k);
            long sum=0;
            int j=0;
            for(int i=n-1;i>=0;i--){
                if(j+1<=k[i]){
                    sum+=c[j];
                    j++;
                }else{
                    sum+=c[k[i]-1];
                }
            }
            out.append(sum).append('\n');
        }
        System.out.print(out.toString());
    }
}