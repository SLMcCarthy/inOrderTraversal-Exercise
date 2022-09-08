class BinarySearchTree{
    
    protected class Node{
        protected int value;        // Value (Nodes key)
        protected Node left, right; // Left and Right Children, Null if absent

        // Default Constructor for Node
        public Node(int valueInput){
            this.value = valueInput;
            left = null;
            right = null;
        }
        
        // Purpose: Attach Left Node
        // Input:   newLeft - the node to insert into this nodes left
        // Return:  None
        public void attachLeft(Node newLeft){ this.left = newLeft; }

        // Purpose: Attach Right Node
        // Input:   newRight - the node to insert into this nodes right
        // Return:  None
        public void attachRight(Node newRight){ this.right = newRight; }
        
        // Purpose: Compare two nodes based on their values (keys)
        // Input:   otherNode - a node to compare with this node
        // Return:  1 if otherNode >= this Node, -1 if otherNode < this Node
        public int compareTo(Node otherNode){ return otherNode.value >= this.value ? 1 : -1; }
        
        // Create String Representation of Node
        @Override
        public String toString(){ return " [" + value + "] "; }     
    }

    // Represents root of Binary Tree
    protected Node root;
        
    // Default constructor for a Binary Tree
    public BinarySearchTree(){ this.root = null; } 

    // Purpose: Helper function to create new node and call insertNode 
    // Input:   valueInput - the value for the new nodes key
    // Return:  None
    public void insert(int valueInput){
        Node newNode = new Node(valueInput);
        root = insertNode(root, newNode);
    }

    // Purpose: Recursively insert Node into correct position in BST
    // Input:   cur - current node  newNode - node we are inserting
    // Return:  cur - used to recursively find the correct spot to insert 
    public Node insertNode(Node cur, Node newNode){
        if(cur == null)
            return newNode;
    
        if(cur.compareTo(newNode) > 0){
            cur.attachRight(insertNode(cur.right, newNode)); // newnode > current node
        }
        else if(cur.compareTo(newNode) < 0){
            cur.attachLeft(insertNode(cur.left, newNode)); // newnode < current node
        }
        else
            return cur;
        return cur;
    }

    /*
     * TODO: Implement In-Order Traversal Iteratively and recursively
     */

    public static void main(String[] args){
        BinarySearchTree bst = new BinarySearchTree();
    
        bst.insert(100);
        bst.insert(20);
        bst.insert(200);
        bst.insert(10);
        bst.insert(30);
        bst.insert(150);
        bst.insert(300);
    
        System.out.println("\nPrinting In Order Recursively: \n");
        bst.inOrderRecursive();
        System.out.println("\n");
    }
}
