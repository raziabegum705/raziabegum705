

import java.util.*;

class Solution {

    public int[] findSubtreeSizes(int[] parent, String s) {

        int n = parent.length;

        List<Integer>[] tree = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            tree[parent[i]].add(i);
        }

        int[] ans = new int[n];
        int[] last = new int[26];

        Arrays.fill(last, -1);

        dfs(0, tree, parent, s, last, ans);

        return ans;
    }

    private void dfs(int node,
                     List<Integer>[] tree,
                     int[] parent,
                     String s,
                     int[] last,
                     int[] ans) {

        int c = s.charAt(node) - 'a';

        int old = last[c];

        last[c] = node;

        ans[node] = 1;

        for (int child : tree[node]) {
            dfs(child, tree, parent, s, last, ans);
        }

        int newParent = (old == -1)
                        ? parent[node]
                        : old;

        if (node != 0) {
            ans[newParent] += ans[node];
        }

        last[c] = old;
    }
}
