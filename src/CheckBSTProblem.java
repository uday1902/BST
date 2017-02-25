/**
 * Created by vsonthy on 2/25/17.
 */
public class CheckBSTProblem implements Problem{

    public void setupAndSolveProblem(){
        Node node1 = new Node(5,null,null);
        Node node2 = new Node(7,node1,null);
        Node node3 = new Node(24,null,null);
        Node node4 = new Node(20,null,node3);
        Node root = new Node(18,node2,node4);
        System.out.println(checkBST(root));
    }

    class Node {
        int data;
        Node left;
        Node right;
        Node(int data,Node left,Node right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    class Comp {
        int min;
        int max;
        boolean check;
        Comp(int min, int max, boolean check){
            this.min = min;
            this.max = max;
            this.check = check;
        }
    }

    Comp checkRule(Node root){
        if(root.right == null && root.left == null){
            return new Comp(root.data,root.data,true);
        } else if(root.left == null){
            Comp rightComp = checkRule(root.right);
            return new Comp(root.data,rightComp.max,rightComp.min > root.data && rightComp.check);
        } else if(root.right == null){
            Comp leftComp = checkRule(root.left);
            return new Comp(leftComp.min,root.data,leftComp.max < root.data && leftComp.check);
        }
        Comp leftComp = checkRule(root.left);
        Comp rightComp = checkRule(root.right);

        boolean check = (leftComp.max < root.data && leftComp.check && rightComp.min > root.data && rightComp.check);
        int min = leftComp.min;
        int max = rightComp.max;
        return new Comp(min,max,check);
    }


    boolean checkBST(Node root) {
        return checkRule(root).check;
    }

}
