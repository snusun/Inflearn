package DFSBFSbasic;

class Node{
    int data;
    Node lt, rt; // Node라는 class의 객체 주소를 저장
    public Node(int data){
        this.data = data;
        lt=rt=null;
    }
}

public class DFS {
    Node root;
    public void dfs(Node root){
        if(root==null) return;
        else {
            //System.out.print(root.data+" "); //전위
            dfs(root.lt);
            //System.out.print(root.data+" "); // 중위
            dfs(root.rt);
            System.out.print(root.data+" "); // 후위
        }
    }

    public static void main(String[] args) {
        DFS tree = new DFS();
        tree.root=new Node(1);
        tree.root.lt=new Node(2);
        tree.root.rt=new Node(3);
        tree.root.lt.lt=new Node(4);
        tree.root.lt.rt=new Node(5);
        tree.root.rt.lt=new Node(6);
        tree.root.rt.rt=new Node(7);
        tree.dfs(tree.root);
    }
}
