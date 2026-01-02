
import java.util.Scanner;

public class A189_CF {
    public static void main(String[]args){
        Scanner scn = new Scanner(System.in);
        int n=scn.nextInt();
        int a=scn.nextInt();
        int b=scn.nextInt();
        int c=scn.nextInt();

        int ans =0;

        for(int i=0;i<=n/a;i++){
            for(int j=0;j<=n/b;j++){
                int used=i*a+j*b;
                if(used>n)continue;
                int remaining=n-used;
                if(remaining%c==0){
                    int k=remaining/c;
                    ans=Math.max(ans,i+j+k);
                }
            }
        }
        System.out.println(ans);
    }
}
