/*Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).

 

Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: [[3],[9,20],[15,7]]
Example 2:

Input: root = [1]
Output: [[1]]
Example 3:

Input: root = []
Output: []
 

Constraints:

The number of nodes in the tree is in the range [0, 2000].
-1000 <= Node.val <= 1000 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
     // Jai Ganesh
        
        
        List<Integer> khud_ki = new ArrayList<>();
        
        
        if(root == null){
             List<List<Integer>> main_return_list = new ArrayList<List<Integer>>();
             return main_return_list;
        }
            
        else{
    
        khud_ki.add(root.val);
        
        List<List<Integer>> left_ki_list = levelOrder(root.left);
        List<List<Integer>> right_ki_list = levelOrder(root.right);
        
        List<List<Integer>> main_return_list = new ArrayList<List<Integer>>();
        main_return_list.add(khud_ki);
        
        if(left_ki_list.size() == 0 && right_ki_list.size() == 0)
            return main_return_list;
        
        // if left child returned list is not empty  
            
        if(left_ki_list.size() != 0){
            
        // add elements of left child   
        for(int i=0, j=1; i<left_ki_list.size(); i++){
            
            if(j>=main_return_list.size()){
                
                main_return_list.add(left_ki_list.get(i));
            }
            
            else{
                for(int k=0; k<left_ki_list.get(i).size();k++){
                    main_return_list.get(j).add(left_ki_list.get(i).get(k));
                }    
            }
            j++;
          }     
        }
    
    // if right child returned list is not empty  
            
    if(right_ki_list.size() != 0){
                            
    // add elements of right child
        
        for(int i=0, j=1; i<right_ki_list.size(); i++){
            
            if(j>=main_return_list.size()){
                
                main_return_list.add(right_ki_list.get(i));
            }
            
            else{
                ArrayList<Integer> temporary = new ArrayList<>();
                
                for(int k=0; k<right_ki_list.get(i).size();k++){
                    
                    main_return_list.get(j).add(right_ki_list.get(i).get(k));
                }  
              }
                j++;                    
             }   
          }
     
             return main_return_list; 
        }        
    }
}
