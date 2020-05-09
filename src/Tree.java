import java.util.ArrayList;

public class Tree {
    Node root;
    public class Node{
        Node right;
        Node left;
        int N;
        int key;
        String value;

        public  Node(int key,String value,int N){
            this.key = key;
            this.value = value;
            this.N = N;
        }
    }

   public Node get(int key){
       return get(key,root);
    }

    private Node get(int key,Node node){
        if(node == null){return null;}
        while (node != null){
            if(key < node.key){
                node = node.left;
            }else if(key > node.key){
                node = node.right;
            }else {
                return node;
            }
        }
        return  node;
    }

   public void put(int key,String value){
        root =  put(key,value,root);
    }

    private Node put(int key,String value,Node node){
       if(node == null) return new Node(key,value,1);
       if(key < node.key){
           node.left = put(key,value,node.left);
       }else if(key > node.key){
           node.right = put(key,value,node.right);
       }else {
           node.value = value;
       }
       node.N  = size(node.left) + size(node.right) +1;
       return  node;
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

    public Node floor(int key){
        return floor(root,key);
    }

    public Node floor(Node node,int key){
        if(node == null) return null;
        Node tem = null;
        while (node != null){
            if(key < node.key){
                node = node.left;
            }else if(key > node.key){
                tem = node;
                node = node.right;
            }else {
                return node;
            }
        }
        return tem;
    }

    public Node select(int n){
        return select(root,n);
    }

    private Node select(Node node,int n){
        if(node == null) return null;
        while (node != null){
           if(n < size(node.left)){
               node = node.left;
           }else if( n > size(node.right)){
               n = n - size(node.left) - 1;
               node = node.right;
           }else {
               return node;
           }
        }
        return null;
    }

    private int size(Node node){
        return node == null ? 0 : node.N;
    }

    private int size(){
        return  size(root);
    }

    private int rank(Node node,int key){
        if(node == null) return -1;
        int index = -1;
        while (node != null){
            if(key < node.key){
                node = node.left;
            }else if( key > node.key){
                index = index + 1 + size(node.left);
                node = node.right;
            }else {
                return index+ size(node.left)+1;
            }
        }
        return index;
    }

    public  int rank(int key){
       return rank(root, key);
    }

    public  void deleteMin(){
        deleteMin(root);
    }

    public void deleteMin(Node node){
        Node tem = null;
        while (true){
            if (node.left != null){
                tem = node;
                node = node.left;
            }else {
                if(tem == null){
                    if (node.right == null) root = null;
                    else  root  =  node.right;
                }else {
                    if (node.right == null) tem.left = null;
                    else  tem.left  =  node.right;
                }
                tem.N = size(tem.left) + size(tem.right) + 1;
                return;
            }
        }
    }
  /* public Node deleteMin(Node x){
       if(x.left == null) return x.right;
       x.left = deleteMin(x.left);
       return  x;
   }*/

    public  void delete(int key){
        delete(root,key);
    }

    public void delete(Node node,int key){
        Node tem = null;
        Boolean isLeft = null;
        while (node != null){
            if(key < node.key){
                isLeft = true;
                tem = node;
                node = node.left;
            }else if(key > node.key){
                isLeft = false;
                tem = node;
                node = node.right;
            }else {
                Node sonMin = min(node.right);
                deleteMin(node.right);
                sonMin.left = node.left;
                sonMin.right = node.right;
                if(isLeft){
                    tem.left = sonMin;
                }else {
                    tem.right = sonMin;
                }
                return;
            }
        }
    }

    public ArrayList<Integer> keys(){
        ArrayList keys = new ArrayList();
        keys(root,keys, min().key,max().key);
        return keys;
    }

    public void keys(Node node,ArrayList<Integer> arr,int min,int max){
            if (node == null) return ;
            if (min <= node.key && max >= node.key){
                keys( node.left,arr,min,max);
                arr.add(node.key);
                keys(node.right,arr,min,max);
            }else if( min > node.key){
                keys(node.right,arr,min,max);
            } else if(max < node.key){
                keys(node.left,arr,min,max);
            }
    }

    public static void main(String[] arg){
        Tree tree = new Tree();
        tree.put(15,"15");
        tree.put(12,"12");
        tree.put(29,"29");
        tree.put(30,"30");
        tree.put(1,"1");
        tree.put(9,"9");
        tree.put(10,"10");
        tree.put(8,"8");
        tree.put(-15,"-15");
        tree.put(-10,"-10");
        tree.delete(1);

    }
}
