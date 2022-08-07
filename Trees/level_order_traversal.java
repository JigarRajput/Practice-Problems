class Solution
{
    //Function to return the level order traversal of a tree.
    
    static ArrayList <Integer> levelOrder(Node node) 
    {
        // Your code here
        ArrayList<Integer> list_to_return = new ArrayList<>();
        Queue<Node> my_q = new LinkedList<>();
        my_q.add(node);
        
        while(!my_q.isEmpty())
        {
            Node temp = my_q.poll(); // returns head of queue and removes it from the queue
            list_to_return.add(temp.data);
            
            if(temp.left != null)
            my_q.add(temp.left);
            
            if(temp.right != null)
            my_q.add(temp.right);
        }
        
        return list_to_return;
        
    }
}
