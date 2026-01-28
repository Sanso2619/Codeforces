
import java.util.*;

public class B96_CF {
    static ArrayList<Long>list=new ArrayList<>();
    static void generate(long num,int len){
        if(len>10)return;
        if(num>0 && isSuperLucky(num))list.add(num);

        generate(num*10+4, len+1);
        generate(num*10+7, len+1);
    }

    static boolean isSuperLucky(long num){
        int c4=0,c7=0;

        while(num>0){
            long temp=num%10;
            if(temp==4)c4++;
            else if(temp==7)c7++;
            num/=10;
        }
        return c4==c7;
    }
    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);
        long n=scn.nextLong();

        generate(0, 0);

        Collections.sort(list);

        for(long x:list){
            if(x>=n){
                System.out.println(x);
                break;
            }
        }
    }
}


// NOTE:
// - This solution generates all numbers consisting only of digits 4 and 7 (lucky numbers).
// - Recursion is limited to length <= 10 because n <= 1e9 (more digits are unnecessary).
// - An additional constraint is applied: count of '4' must be equal to count of '7'.
// - Only balanced lucky numbers (equal 4s and 7s) are stored.
// - After generation, numbers are sorted and the smallest value >= n is selected.
// - Time complexity is safe since total lucky numbers up to 10 digits are very small (~2^10).
