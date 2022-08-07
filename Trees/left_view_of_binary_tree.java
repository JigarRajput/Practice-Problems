class Tree
{
    ArrayList<Integer> list_to_return = new ArrayList<>();
    
    ArrayList<Integer> leftView(Node root)
    {
        addList(list_to_return, root, 0);
        
        return list_to_return;
    }
    
  // funtion addList takes current level, list, and current node
  // if at current level there is no node then add this node at the current level and go for next level childerens (first left child and then right child)
  
    public void addList(ArrayList<Integer> list_to_return, Node node, int level)
    {
        if(node == null)
        return;
        
        else
        {
            if(list_to_return.size() <= level)
            {
                list_to_return.add(node.data);
            }
            
            addList(list_to_return, node.left, level+1);
            addList(list_to_return, node.right, level+1);
            
        }
    }
}
