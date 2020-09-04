package three;

import java.util.ArrayList;

public class RedBlackTree {
    Node root;
    class Node{
        Node right;
        Node left;
        int N;
        int key;
        String value;
        String color; //true为红，false为黑
        public  Node(int key,String value,int N,String color){
            this.key = key;
            this.value = value;
            this.N = N;
            this.color = color;
        }
        public void changeRad(Node node){
            node.color = "red";
        }
        public void changeBlack(Node node){
            node.color = "black";
        }
    }

    public void put(int key,String value){
        root =  put(key,value,root);
    }

    private Node put(int key,String value,Node node){
        if(root == null) return new Node(key,value,1,"black");
        if(node == null) return new Node(key,value,1,"red");
        if(key < node.key){
            node.left = put(key,value,node.left);
            if (node.left.left != null && node.left.color.equals("red")  && node.left.left.color.equals("red")){
                node = rightRotation(node);
                carryBit(node);
            }

        }else if(key > node.key){
            node.right = put(key,value,node.right);
            carryBit(node);
            if (node.right.color.equals("red")  && node.color.equals("black")){
                node = leftRotation(node);
            }
        }else {
            node.value = value;
        }
  //      node.N  = size(node.left) + size(node.right) +1;
        return  node;
    }
    public Node  leftRotation(Node x){
        Node h = x.right;
        Node tem = h.left;
        h.left = x;
        x.right = tem;
        h.color = x.color;
        x.color = "red";
        return h;
    }

    public Node  rightRotation(Node x){
        Node h = x.left;
        Node tem = h.right;
        h.right = x;
        x.left = tem;
        h.color = x.color;
        x.color = "red";
        return h;
    }

    public  void carryBit(Node node){
        if(node.right!=null && node.left != null && node.right.color.equals("red") && node.left.color.equals("red") ){
            if(node == root){node.color = "black";}
            else {node.color = "red";}
            node.left.color = "black";
            node.right.color = "black";
        }
    }
    public Node min(){
        return min(root);
    }

    public Node min(Node node){
        if(node == null) return null;
        while (true){
            if (node.left != null){
                node = node.left;
            }else {
                return  node;
            }
        }
    }

    public Node max(){
        return max(root);
    }

    public Node max(Node node){
        if(node == null) return null;
        while (true){
            if (node.right != null){
                node = node.right;
            }else {
                return  node;
            }
        }
    }

    public ArrayList<String> keys(){
        ArrayList keys = new ArrayList();
        keys(root,keys, min().key,max().key);
        return keys;
    }

    public void keys(Node node,ArrayList<String> arr,int min,int max){
        if (node == null) return ;
        if (min <= node.key && max >= node.key){
            keys( node.left,arr,min,max);
            String key = node.key+"_"+node.color;
            arr.add(key);
            keys(node.right,arr,min,max);
        }else if( min > node.key){
            keys(node.right,arr,min,max);
        } else if(max < node.key){
            keys(node.left,arr,min,max);
        }
    }


    public static void main(String[] arg){
        RedBlackTree tree = new RedBlackTree();
        tree.put(15,"15");
        tree.put(12,"12");
        tree.put(29,"29");
        tree.put(30,"30");
        tree.put(11,"11");
        tree.put(-5,"11");
        tree.put(105,"11");
        tree.put(0,"11");
        System.out.println(tree.keys());
    }
}
