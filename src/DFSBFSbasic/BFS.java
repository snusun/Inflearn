package DFSBFSbasic;

import java.util.*;

class node{
    int data;
    node lt, rt; // Node라는 class의 객체 주소를 저장
    public node(int data){
        this.data = data;
        lt=rt=null;
    }
}

public class BFS {
    node root;
    Queue<node> q = new LinkedList<>();
    public void bfs(node root){
        StringBuilder temp = new StringBuilder();
        q.offer(root);
        while (!q.isEmpty()){
            for(int i=0; i<q.size(); i++){
                node n = q.poll();
                if(n!=null) {
                    temp.append(n.data).append(" ");
                    if(n.lt!=null) q.offer(n.lt);
                    if(n.rt!=null) q.offer(n.rt);
                }
            }
        }
        System.out.println(temp);
    }

    public static void main(String[] args) {
        BFS tree = new BFS();
        tree.root=new node(1);
        tree.root.lt=new node(2);
        tree.root.rt=new node(3);
        tree.root.lt.lt=new node(4);
        tree.root.lt.rt=new node(5);
        tree.root.rt.lt=new node(6);
        tree.root.rt.rt=new node(7);
        tree.bfs(tree.root);
    }
}