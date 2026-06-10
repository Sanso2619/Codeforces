import java.util.Scanner;

public class D1907_CF {
    static int n ;
    static long l[];
    static long r[];
    public static void main(String[]args){
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();

        while(t-->0){
            n = scn.nextInt();
            l = new long[n];
            r = new long[n];

            for(int i=0;i<n;i++){
                l[i]=scn.nextLong();
                r[i]=scn.nextLong();
            }

            long low=0;
            long high=1000000000L;
            long ans=high;
            while(low<high){
                long mid=(low+high)/2;

                if(check(mid)){
                    ans=mid;
                    high=mid;
                }else{
                    low=mid+1;
                }
            }
            System.out.println(ans);
        }
    }
    public static boolean check(long mid){
        long L=0;
        long R=0;

        for(int i=0;i<n;i++){
            long reachl=L-mid;
            long reachr=R+mid;
            
            L=Math.max(reachl,l[i]);
            R=Math.min(reachr,r[i]);

            if(L>R)return false;
        }
        return true;
    }
}



/*
========================================
THOUGHT PROCESS 
========================================

Problem:
Find the minimum k such that we can start at position 0 and,
after each move, land inside the i-th segment [li, ri].

--------------------------------------------------
OBSERVATION 1: Binary Search on Answer
--------------------------------------------------

We are asked to find the MINIMUM k.

Suppose a value k works.

Then any larger value also works because allowing bigger jumps
cannot make a valid path invalid.

Example:

k = 5   -> false
k = 6   -> false
k = 7   -> false
k = 8   -> true
k = 9   -> true
k = 10  -> true

Pattern:

F F F F T T T T

This monotonic property suggests Binary Search on k.

Search space:

0 <= k <= 1e9

--------------------------------------------------
OBSERVATION 2: Don't Track One Point
--------------------------------------------------

My first instinct was:

0 -> choose a point in segment 1
  -> choose a point in segment 2
  -> choose a point in segment 3

This is wrong because there can be many valid choices.

If one chosen path fails, another path may still succeed.

Therefore, instead of tracking ONE position,
track ALL possible positions.

--------------------------------------------------
OBSERVATION 3: Represent All Positions as a Range
--------------------------------------------------

Let:

[L, R]

represent all positions where the player could possibly stand
after processing some segments.

Initially:

[L, R] = [0, 0]

because we start exactly at position 0.

--------------------------------------------------
OBSERVATION 4: Expanding by k
--------------------------------------------------

If we can currently stand anywhere in:

[L, R]

and the maximum jump length is k,

then after one move we can reach:

[L - k, R + k]

Why?

Leftmost reachable position:
L - k

Rightmost reachable position:
R + k

So the entire reachable interval becomes:

[L - k, R + k]

--------------------------------------------------
OBSERVATION 5: Intersect with Current Segment
--------------------------------------------------

The problem says:

After move i, we MUST land inside segment [li, ri].

So from all reachable positions:

[L - k, R + k]

we keep only positions inside the segment.

This is simply interval intersection:

L = max(L - k, li)
R = min(R + k, ri)

If:

L > R

then the intersection is empty.

That means there is no valid position to stand on,
so this k is impossible.

--------------------------------------------------
CHECK(k)
--------------------------------------------------

L = 0
R = 0

For every segment:

1. Expand:
   [L - k, R + k]

2. Intersect with [li, ri]

3. If intersection becomes empty:
      return false

If all segments are processed successfully:
      return true

--------------------------------------------------
TIME COMPLEXITY
--------------------------------------------------

check(k) = O(n)

Binary Search = O(log(1e9))

Total:

O(n * log(1e9))

which easily fits the constraints.

--------------------------------------------------
KEY LESSON
--------------------------------------------------

When a problem asks:

"Find the minimum X"

and

"If X works, every larger value also works"

think:

>>> Binary Search on Answer <<<

When many choices are possible at each step,
avoid tracking one choice.
Track the entire set of possible states,
often as an interval/range.
*/