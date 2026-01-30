import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class C1203_CF {

    static long gcd(long a, long b) {
    while (b != 0) {
        long t = a % b;
        a = b;
        b = t;
    }
    return a;
}

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        long[] arr=new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++)arr[i]=Long.parseLong(st.nextToken());

        long g=arr[0];
        for(int i=1;i<n;i++){
            g=gcd(g,arr[i]);
        }

        int count=0;
        for(int i=1;i<=g/i;i++){
            if(g%i==0){
                count++;
                long pair=g/i;
                if(i!=pair){count++;}
            }
        }
        System.out.println(count);
    }
}


// NOTE:
// We first compute the GCD of all array elements because any number that divides
// all elements must divide their GCD. To count the number of such divisors efficiently,
// we use the fact that divisors always come in pairs: if i divides g, then g/i is also
// a divisor. Hence, we iterate only up to sqrt(g) (using i <= g/i to avoid overflow),
// and for every valid divisor i, we count both i and its paired divisor g/i. The extra
// condition (i != g/i) ensures that perfect square divisors are counted only once.
// This reduces the divisor-counting complexity from O(g) to O(sqrt(g)) and avoids
// double counting, making the solution efficient for large inputs.
