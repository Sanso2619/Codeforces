import java.util.Scanner;

public class A1693_CF {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();

        while(t-->0){
            int n = scn.nextInt();
            long arr[]=new long[n];
            for(int i=0;i<n;i++)arr[i]=scn.nextLong();

            long pref[]=new long[n];
            pref[0]=arr[0];
            for(int i=1;i<n;i++)pref[i]=pref[i-1]+arr[i];

            boolean ans=true;

            if(pref[n-1]!=0) ans=false;

            for(int i=0;i<n;i++){
                if(pref[i]<0){
                    ans=false;
                    break;
                }
            }

            int firstzero=-1;
            for(int i=0;i<n;i++){
                if(pref[i]==0){
                    firstzero=i;
                    break;
                }
            }
            if(firstzero!=-1){
                for(int i=firstzero;i<n;i++){
                    if(pref[i]!=0){
                        ans=false;  
                        break;
                    }
                }
            }
            

            System.out.println(ans?"YES":"NO");
        }
    }
}



/*
-----------------------------------------------
CF A1693 – Prefix Sum Validation Notes
-----------------------------------------------

Problem Type:
- Prefix Sum
- Balance / Validation Problem (similar to bracket sequence check)

Core Idea:
We are given an array and must verify whether it represents a valid
process based on prefix sums.

Definitions:
pref[i] = sum of elements from index 0 to i

-----------------------------------------------
Conditions for a valid array:
-----------------------------------------------

1) Prefix sum should NEVER become negative
   - pref[i] < 0 means we tried to remove something
     that was never added
   - Immediately invalid

2) Total sum MUST be zero
   - pref[n-1] represents sum of entire array
   - If pref[n-1] != 0, then some operation was left unfinished

3) Once prefix sum becomes zero, it must remain zero
   - After the process finishes, no more operations are allowed
   - If any pref[j] != 0 after reaching zero, it is invalid

-----------------------------------------------
Why pref[n-1] == 0 is mandatory:
-----------------------------------------------
- Prefix >= 0 ensures balance never goes below zero
- Final sum = 0 ensures balance returns to zero
- Without this check, unfinished sequences would pass

Example Invalid:
[1, 1] -> pref = [1, 2] (never negative, but never finishes)

Example Valid:
[2, -1, -1] -> pref = [2, 1, 0]

-----------------------------------------------
Implementation Strategy:
-----------------------------------------------
- Build prefix sum array
- Check for negative prefix
- Find first index where pref[i] == 0
- Ensure all following prefixes are also zero

Time Complexity:
- O(n) per test case

Space Complexity:
- O(n) for prefix array (can be optimized to O(1))

-----------------------------------------------
Key Takeaway:
-----------------------------------------------
This is a balance validation problem.
Every addition must be matched by a removal,
and once balance reaches zero, it must stay zero.
-----------------------------------------------
*/
