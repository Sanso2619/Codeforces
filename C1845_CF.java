import java.util.Scanner;

public class C1845_CF {
    public static void main(String[]args){
        Scanner scn = new Scanner(System.in);
        int t=scn.nextInt();

        while(t-->0){
            String s = scn.next();
            int n = scn.nextInt();

            String l=scn.next();
            String r=scn.next();

            int pos=0;
            boolean possible=false;

            for(int i=0;i<n;i++){
                int li=l.charAt(i)-'0';
                int ri=r.charAt(i)-'0';

                int farthest=pos;

                for(int d=li;d<=ri;d++){
                    int curr=pos;
                    while(curr<s.length() && s.charAt(curr)-'0'!=d){
                        curr++;
                    }
                    if(curr==s.length()){
                        possible=true;
                        break;
                    }
                    farthest=Math.max(farthest,curr);
                }
                if(possible)break;

                pos=farthest+1;
            }
            if(possible)System.out.println("YES");
            else System.out.println("NO");
        }
    }
}


/*
========================================================
CF 1845C - Strong Password
========================================================

WHAT IS THIS QUESTION ABOUT?
--------------------------------------------------------
This is NOT a substring problem.
This is NOT a sliding window problem.
This is NOT a frequency/hashmap problem.

This is a SUBSEQUENCE + GREEDY MATCHING problem.

We are given:
- A database string s
- Password length m
- For each password position i:
    digit must be between l[i] and r[i]

We need to determine:

Does there exist at least ONE valid password
that is NOT a subsequence of s?

--------------------------------------------------------
FIRST WRONG THOUGHTS I HAD
--------------------------------------------------------
1. Generate all possible passwords
   -> Impossible (up to 10^10 possibilities)

2. Use frequency counts
   -> Wrong because subsequences depend on ORDER

3. Use sliding window
   -> Wrong because subsequences are not contiguous

4. Binary search
   -> No monotonic property

--------------------------------------------------------
KEY OBSERVATION 1
--------------------------------------------------------
To check whether a FIXED password is a subsequence:

Greedy matching works.

Example:

s = 12341234
password = 134

Find:
1 -> first occurrence
3 -> first occurrence after that 1
4 -> first occurrence after that 3

If all are found:
    subsequence exists
Else:
    subsequence does not exist

--------------------------------------------------------
KEY OBSERVATION 2
--------------------------------------------------------
The important state is:

    current position in s

After matching some password digits,
the only thing that matters is where we are currently
standing in s.

Everything before that position is useless.

--------------------------------------------------------
KEY OBSERVATION 3
--------------------------------------------------------
Suppose current position is pos.

For password position i:

Allowed digits:
    [l[i], r[i]]

Example:
    [3,5]

Possible choices:
    3,4,5

For each allowed digit,
find its first occurrence after pos.

--------------------------------------------------------
KEY OBSERVATION 4 (THE MAIN GREEDY)
--------------------------------------------------------
Among all allowed digits,
take the one whose next occurrence is FARTHEST right.

Why?

Because it leaves the smallest remaining suffix of s,
making future matching as difficult as possible.

Example:

Current pos = 10

3 -> next occurrence = 20
4 -> next occurrence = 50
5 -> next occurrence = 100

Choose:

    100

because it is the most restrictive choice.

Update:

    pos = 101

--------------------------------------------------------
KEY OBSERVATION 5
--------------------------------------------------------
Suppose for some allowed digit:

    no occurrence exists after pos

Then:

We can choose that digit for our password.

Greedy matching immediately fails.

Therefore:

A valid password exists that is NOT a subsequence.

Answer = YES

--------------------------------------------------------
ALGORITHM
--------------------------------------------------------
pos = 0

For every password position i:

    For every allowed digit d:

        Find first occurrence of d after pos

        If not found:
            Answer = YES
            stop

        Keep track of the farthest occurrence

    Move:

        pos = farthestOccurrence + 1

If all positions are processed successfully:

    Answer = NO

--------------------------------------------------------
WHY DOES THIS WORK?
--------------------------------------------------------
We do NOT construct the password.

Instead we simulate the subsequence matcher.

At every step we assume the password chooses the digit
that pushes the matcher furthest right.

If even this "worst" choice can still be matched,
then no valid password can escape.

If some allowed digit cannot be matched,
then we immediately obtain a password that is not
a subsequence.

--------------------------------------------------------
PATTERN LEARNED
--------------------------------------------------------
For many subsequence problems:

State:
    current position in string

Transition:
    next occurrence of a character/digit

Common keywords:
    subsequence
    next occurrence
    greedy matching
    automaton / next array

--------------------------------------------------------
TIME COMPLEXITY
--------------------------------------------------------
Editorial-style scanning solution:

For each password position:
    check up to 10 digits

Worst case:

    O(m * 10 * |s|)

Since:
    m <= 10
    |s| <= 3e5

This passes.

Optimized solution using next[pos][digit]:

    Preprocessing: O(10 * |s|)
    Query: O(m * 10)

========================================================
*/