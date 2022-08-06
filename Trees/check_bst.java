// Jai Ganesh 

public class Solution
{
    ArrayList<Integer> elements = new ArrayList<>();
    boolean isBST(Node root)
    {
       inorder_insertion(root);
    
       for(int i=0; i<elements.size()-1; i++)
       {
           if(elements.get(i)>elements.get(i+1))
           return false;
       }
       
       return true;
    }
    
   public void inorder_insertion(Node node)
    {
        if(node == null)
        return;
        
        inorder_insertion(node.left);
        elements.add(node.data);
        inorder_insertion(node.right);
    }
}
