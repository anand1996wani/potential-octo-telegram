/*

The Celebrity Problem

A celebrity is a person who is known to all but does not know anyone at a party. A party is being organized by some people. 
A square matrix mat (n*n) is used to represent people at the party such that if an element of row i and column j is set to 1 it means ith person knows jth person. 
You need to return the index of the celebrity in the party, if the celebrity does not exist, return -1.

Note: Follow 0-based indexing.

Examples:

Input: mat[][] = [[0 1 0], [0 0 0], [0 1 0]]
Output: 1
Explanation: 0th and 2nd person both know 1. Therefore, 1 is the celebrity. 
Input: mat[][] = [[0 1], [1 0]]
Output: -1
Explanation: The two people at the party both know each other. None of them is a celebrity.
Input: mat[][] = [[0]]
Output: 0
Constraints:
1 <= mat.size()<= 3000
0 <= mat[i][j]<= 1

*/

class Solution {

  
    // Function to find if there is a celebrity in the party or not.
    public int celebrity1(int mat[][]) {
        // code here
        int n = mat.length;
        
        if(n==1) {
            return 0;
        }
        
        //I know them 
        HashMap<Integer, HashSet<Integer>> h1 = new HashMap<Integer, HashSet<Integer>>();
        
        //Who knows me
        HashMap<Integer, HashSet<Integer>> h2 = new HashMap<Integer, HashSet<Integer>>();
        
        for(int i = 0;i < mat.length;i++) {
            for(int j = 0;j < mat.length;j++){
                if(i != j && mat[i][j] == 1) {
                    if(h1.get(i) == null){
                        HashSet<Integer> s1 = new HashSet<Integer>();
                        s1.add(j);
                        h1.put(i, s1);
                    }else{
                        HashSet<Integer> s1 = h1.get(i);
                        s1.add(j);
                        h1.put(i, s1);
                    }
                    
                    if(h2.get(j) == null){
                        HashSet<Integer> s1 = new HashSet<Integer>();
                        s1.add(i);
                        h2.put(j, s1);
                    }else{
                        HashSet<Integer> s1 = h2.get(j);
                        s1.add(i);
                        h2.put(j, s1);
                    }
                }
            }
        }
        
        for(Map.Entry<Integer, HashSet<Integer>> entry : h2.entrySet()) {
            HashSet<Integer> s1 = entry.getValue();
            int k = entry.getKey();
            if(s1.size() == (n - 1) && h1.get(k) == null){
                return k;
            }   
        }
        
        return -1;
    }
}


