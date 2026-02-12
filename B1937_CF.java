import java.util.Scanner;

public class B1937_CF {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int t=scn.nextInt();
        while(t-->0){
            int n=scn.nextInt();
            String s1=scn.next();
            String s2=scn.next();

            StringBuilder s=new StringBuilder();
            int row=1;
            int col=0;
            int count=1;

            while(true){
                if(row==1){
                    s.append(s1.charAt(col));
                }else{
                    s.append(s2.charAt(col));
                }
                if(row==2 && col==n-1){
                    break;
                }
                if(row==2){
                    col++;
                    continue;
                }
                if(col==n-1){
                    row=2;
                    continue;
                }

                char right=s1.charAt(col+1);
                char down=s2.charAt(col);

                if(right>down) row=2;
                else if(right<down){
                    col++;
                    count=1;
                }else{
                    col++;
                    count++;

                }
            }
            System.out.println(s.toString());
            System.out.println(count);
        }
    }
}






/*
LOGIC EXPLANATION:

We are given a 2 × n grid.
We start at (1,1) and want to reach (2,n).

We can only move:
- Right
- Down (only once)

So every path is decided by:
→ At which column we go down.

If we go down at column k,
the string becomes:
s1[0..k] + s2[k..n-1]

Different k = different path.


MAIN IDEA:

We build the answer greedily from left to right.

At each step (while on top row), we compare:

right = s1[col + 1]   // if we move right
down  = s2[col]       // if we move down

These two characters decide which move is better.


CASE 1: right < down
--------------------
Going right gives smaller character.
So this gives a better prefix.

→ Move right
→ Reset count = 1
(only one best path remains)


CASE 2: right > down
--------------------
Going down gives smaller character.

→ We must go down
→ No alternative path
→ count remains same


CASE 3: right == down
---------------------
Both moves give same character.

→ Going right or down both keep string minimal
→ So another valid path exists

→ Move right
→ count++


WHY count STARTS FROM 1?

There is always at least one valid path.
So minimum number of best paths = 1.


WHEN DO WE STOP?

We stop when we reach (2, n-1),
which is the last cell.


WHAT DOES count REPRESENT?

count = Number of different positions
        where we could go down
        and still get the lexicographically smallest string.

In other words:
count = Number of paths that produce the smallest string.


TIME COMPLEXITY:

We move at most n times.
So time = O(n) per test case.
*/
