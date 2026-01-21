
import java.util.*;
public class B862_CF {
    static ArrayList<Integer>[]graph;
    static int[]color;
    static long cntA;
    static long cntB;

    public static void main(String[]args){
        Scanner scn = new Scanner(System.in);
        int n=scn.nextInt();

        graph=new ArrayList[n+1];
        for(int i=1;i<=n;i++){
            graph[i]=new ArrayList<>();
        }
        for(int i=0;i<n-1;i++){
            int u=scn.nextInt();
            int v=scn.nextInt();

            graph[u].add(v);
            graph[v].add(u);
        }
        color=new int[n+1];
        color[1]=1;
        cntA++;
        dfs(1);

        System.out.println((cntA*cntB)-(n-1));
    }

    static void dfs(int node){
        for(int n:graph[node]){
            if(color[n]==0){
                if(color[node]==1){
                    color[n]=2;
                    cntB++;
                }else{
                    color[n]=1;
                    cntA++;
                }
                dfs(n);
            }
        }
    }
}

/*
Problem: Mahmoud and Ehab and Bipartite Graph (Tree)

Idea:
- A tree is always bipartite.
- We can divide the nodes into two groups (A and B) such that
  every edge connects nodes from different groups.

Observation:
- If group A has 'a' nodes and group B has 'b' nodes,
  the maximum number of edges in a bipartite graph is a * b.
- The given tree already has (n - 1) edges.

So, maximum edges we can add:
    (a * b) - (n - 1)

Approach:
1. Use DFS to traverse the tree.
2. Assign nodes alternately to two groups (A and B).
3. Count how many nodes are in each group.
4. Apply the formula above to get the answer.

Why DFS?
- DFS helps us visit every node exactly once.
- It ensures adjacent nodes are always placed in opposite groups.

Complexity:
- Time Complexity: O(n)
- Space Complexity: O(n)

*/
