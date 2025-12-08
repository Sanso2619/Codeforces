
import java.util.Scanner;

public class A1613_CF {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        while (t-- > 0) {
            String x=scn.next();
            int p1=scn.nextInt();
            String y=scn.next();
            int p2=scn.nextInt();

            long len1=x.length()+p1;
            long len2=y.length()+p2;
            if(len1>len2){
                System.out.println(">");
            }else if(len1<len2){
                System.out.println("<");
            }else{
                int x1=Integer.parseInt(x);
                int y1=Integer.parseInt(y);

                int l1=x.length();
                int l2=y.length();

                while(l1!=l2){
                    if(l1<l2){
                        x1*=10;
                        l1++;
                    }else{
                        y1*=10;
                        l2++;
                    }
                }
                if(x1>y1){
                    System.out.println(">");
                }else if(x1<y1){
                    System.out.println("<");
                }else{
                    System.out.println("=");        
                }
            }
            
        }
    }
}
