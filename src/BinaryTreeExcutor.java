import java.util.LinkedList;
import java.util.Queue;
class Node{
	int data;
	Node left,right;
	Node(int val){
		this.data =val;
		left = null;
		right = null;
	}
}
class BinaryTree{
	Node root;
	void createNode(int [] parent,int i,Node [] created){
		if(created[i] != null)
			return;
		created[i] = new Node(i);
		if(parent[i] == -1){
			root = created[i];
			return;
		}
		if(created[parent[i]] == null)
			createNode(parent, parent[i], created);
		Node p = created[parent[i]];
		if(p.left == null)
			p.left = created[i];
		else
			p.right = created[i];
	}
	
	Node createTree(int [] parent,int n){
		Node [] created = new Node [n];
		for (int i = 0; i < n; i++) 
            created[i] = null;
		for (int i = 0; i < n; i++) 
            createNode(parent,i,created);
		return root;
	}
	int heightOfTree(Node root){
		int leftHeight,rightHeight;
		if(root == null){
			return 0;
		}
		leftHeight = heightOfTree(root.left);
		rightHeight = heightOfTree(root.right);
		if(leftHeight > rightHeight){
			return leftHeight + 1;
		}else
			return rightHeight + 1;
	}
	
	void inOrderTravelsal(Node root){
		if(root != null){
			inOrderTravelsal(root.left);
			System.out.print(root.data);
			System.out.print(" ");
			inOrderTravelsal(root.right);
		}
	}
	void levelOrderTraversal(Node root){
		if(root == null){
			return;
		}
		Queue <Node> queue = new LinkedList<Node>();
		queue.add(root);
		while(!queue.isEmpty()){
			Node temp = queue.poll();
			System.out.print(temp.data);
			System.out.print(" ");
			if(temp.left != null){
				queue.add(temp.left);
			}
			if(temp.right !=  null)
				queue.add(temp.right);
		}
		queue.clear();
	}
}
public class BinaryTreeExcutor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree tree = new BinaryTree();
        int parent[] = new int[]{-1, 0, 0, 1, 1, 3, 5};
        int n = parent.length;
        Node node = tree.createTree(parent, n);
        System.out.println("Height of tree is:" + tree.heightOfTree(node));
        System.out.println("Inorder traversal of constructed tree ");
        //tree.inOrderTravelsal(node);
        tree.levelOrderTraversal(node);
	}

}
