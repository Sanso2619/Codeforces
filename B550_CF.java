
import java.util.Scanner;

public class B550_CF {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n=scn.nextInt();
        int l=scn.nextInt();
        int r=scn.nextInt();
        int x=scn.nextInt();

        int arr[] = new int[n];
        for(int i=0;i<n;i++)arr[i]=scn.nextInt();

        int ans=0;

        for(int mask=0;mask<(1<<n);mask++){
            int sum=0;
            int count=0;
            int min=Integer.MAX_VALUE;
            int max=Integer.MIN_VALUE;

            for(int i=0;i<n;i++){
                if((mask & (1<<i))!=0){
                    count++;
                    sum+=arr[i];
                    min=Math.min(min,arr[i]);
                    max=Math.max(max,arr[i]);
                }
            }

            if(count>=2 && sum>=l && sum<=r && (max-min)>=x){
                ans++;
            }
        }
        System.out.println(ans);

    }
}



/*
    PROBLEM INTUITION (BITMASKING)

    The problem asks us to count all valid problem sets.

    Observation:
    Every problem has only TWO choices:
        1. Include it
        2. Don't include it

    Since each problem has a Yes/No choice, every possible selection of
    problems is simply a SUBSET.

    Constraint:
        n <= 15

    Total possible subsets = 2^n.
    For n = 15,
        2^15 = 32768
    which is small enough to check every subset.

    ------------------------------------------------------------

    HOW BITMASKING HELPS

    We represent every subset using a binary number (called a mask).

    Example:
        Problems = [10, 20, 30]

        Mask 000 -> {}
        Mask 001 -> {10}
        Mask 010 -> {20}
        Mask 011 -> {10,20}
        Mask 100 -> {30}
        Mask 101 -> {10,30}
        Mask 110 -> {20,30}
        Mask 111 -> {10,20,30}

    Every bit represents one problem.

        Bit = 1 -> Problem is selected
        Bit = 0 -> Problem is not selected

    ------------------------------------------------------------

    OUTER LOOP

    for(mask = 0; mask < (1<<n); mask++)

    (1<<n) = 2^n

    The outer loop visits EVERY possible subset exactly once.

    ------------------------------------------------------------

    INNER LOOP

    For each mask, we check every problem.

    if ((mask & (1<<i)) != 0)

    means:

        "Is the i-th problem selected in the current subset?"

    If YES:
        - Add its difficulty to sum
        - Increase count
        - Update minimum difficulty
        - Update maximum difficulty

    ------------------------------------------------------------

    After processing one subset, check if it satisfies:

        1. At least 2 problems
        2. l <= sum <= r
        3. max - min >= x

    If all conditions are true,
        answer++

    ------------------------------------------------------------

    KEY IDEA TO REMEMBER

    Bitmasking is NOT used to calculate the answer.

    Bitmasking is only used to GENERATE EVERY SUBSET efficiently.

    After generating one subset, we simply compute the required
    values (sum, count, min, max) and check the conditions.
*/