import java.util.*;

public class B2195_CF {
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();

        while (t-- > 0) {

            int n = scn.nextInt();
            int arr[] = new int[n+1];

            for (int i = 0; i < n; i++) arr[i] = scn.nextInt();
            boolean ok=true;
            for(int i=1;i<=n;i++){

                int a = i/(i&-i);
                int b=arr[i-1]/ (arr[i-1]& -arr[i-1]);
                if(a!=b){
                    ok=false;
                    break;
                }
            }
            if(ok)System.out.println("YES");
            else System.out.println("NO");

        }
    }
}

/*
------------------------------------------------------------
PROBLEM IDEA & APPROACH

We are allowed to swap only at positions:
    i ↔ 2*i

So an element can move only by repeatedly multiplying/dividing
its position by 2.

Example (n = 8):
1 → 2 → 4 → 8
3 → 6
5 → 10 (out of range)
7 (alone)

These form independent "chains".

------------------------------------------------------------
KEY OBSERVATION (INVARIANT)

Any number x can be written as:
    x = (2^k) * odd

where "odd" is the odd part of x.

When we multiply/divide by 2:
    → Only 2^k changes
    → odd part NEVER changes

So odd(x) is invariant (cannot be changed).

------------------------------------------------------------
HOW TO GET ODD PART USING BITS

Lowest power of 2 in x:
    low = x & -x

Odd part:
    odd(x) = x / low
           = x / (x & -x)

------------------------------------------------------------
WHY THIS WORKS

We want to place value i at position i.

A value can move only inside its chain
(same odd part).

So sorting is possible IF AND ONLY IF:

    odd(i) == odd(a[i])

for all i.

If even one position violates this → impossible.

------------------------------------------------------------
ALGORITHM

For each i from 1 to n:
    a = i / (i & -i)
    b = a[i] / (a[i] & -a[i])

    if a != b → print NO

If all matched → print YES

------------------------------------------------------------
TIME COMPLEXITY
O(n) per test case (very fast)

------------------------------------------------------------
*/
