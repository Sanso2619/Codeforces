
import java.util.*;

public class C893_cf {

   static ArrayList<Integer>[] graph;
   static boolean vis[];
   static long cost[];

    public static long dfs(int node){
        vis[node]=true;
        long mincost=cost[node];

        for(int vertex:graph[node]){
            if(!vis[vertex]){
                mincost=Math.min(mincost,dfs(vertex));
            }
        }
        return mincost;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n=scn.nextInt();
        int m=scn.nextInt();

        cost = new long[n];
        for(int i=0;i<n;i++)cost[i]=scn.nextInt();

        graph=new ArrayList[n];
        for(int i=0;i<n;i++) graph[i]=new ArrayList<>();

        for(int i=0;i<m;i++){
            int u=scn.nextInt()-1;
            int v=scn.nextInt()-1;

            graph[u].add(v);
            graph[v].add(u);
        }

        vis=new boolean[n];
        long ans=0;

        for(int i=0;i<n;i++){
            if(!vis[i]){
                ans+=dfs(i);
            }
        }
        System.out.println(ans);
    }
}


/*
PROBLEM SUMMARY:
- We are given an undirected graph with n vertices (characters).
- Each vertex has a weight (gold cost).
- Edges represent friendships.
- If one vertex in a connected component is bribed,
  the rumor spreads to all vertices in that component for free.
- Goal: make all vertices know the rumor with minimum total gold.

KEY OBSERVATION:
- Rumor spreads inside a connected component.
- Each connected component needs exactly ONE bribe.
- To minimize cost, choose the minimum-cost vertex in each component.

APPROACH:
1. Model the problem as an undirected graph.
   - Vertex → character
   - Vertex weight → gold cost
   - Edge → friendship
2. Use DFS/BFS to find connected components.
3. During DFS of one component, track the minimum vertex cost.
4. Add this minimum cost to the answer.
5. Repeat for all unvisited vertices.

WHY DFS:
- DFS explores all vertices connected (directly/indirectly) to a node.
- This exactly gives one connected component.

IMPORTANT IMPLEMENTATION DETAILS:
- Use adjacency list: ArrayList<Integer>[] graph
- Use visited[] array to avoid revisiting nodes.
- Always check visited[neighbor], NOT visited[current].

TIME COMPLEXITY:
- O(n + m)

SPACE COMPLEXITY:
- O(n + m)

FINAL ANSWER:
- Sum of minimum vertex costs of all connected components.
*/
