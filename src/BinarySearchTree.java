/**
 * Created by vsonthy on 12/18/16.
 */
public class BinarySearchTree {

    private int value;
    private BinarySearchTree left,right;

    public BinarySearchTree(int num){
        value = num;
        left = null;
        right = null;
    }
    public BinarySearchTree(){
        value = -1;
        left = null;
        right = null;
    }

    public int getValue() {
        return value;
    }

    public Boolean setLeft(int num) {
        this.left = new BinarySearchTree(num);
        return true;
    }

    public Boolean setRight(int num) {
        this.right = new BinarySearchTree(num);
        return true;
    }


    public boolean find(int num){
        if(value == num){
            return true;
        } else if(value < num){
            return (left != null) ?  left.find(num) : false;
        }
        return (right != null) ?  right.find(num) : false;
    }

    public boolean add(int num){
        if(value == num){
            return false;
        } else if(value > num){
            return (left != null) ?  left.add(num) : setLeft(num);
        }
        return (right != null) ?  right.add(num) : setRight(num);
    }

    public boolean addOrRejectPreOrder(int num){
        if(value == num){
            return false;
        } else if(value > num){
            if(left == null){
                return setLeft(num);
            }
            else if(left.getValue() == BinarySearchTreeProblem.minVal -1){
                return false;
            }
            return left.addOrRejectPreOrder(num);
        }
        leftDummy();
        if(right == null){
            return setRight(num);
        }
        else if(right.getValue() == BinarySearchTreeProblem.minVal -1){
            return false;
        }
        return right.addOrRejectPreOrder(num);
    }

    public void passDummy(){
        leftDummy();
        rightDummy();
    }

    public void leftDummy(){
        if(left == null){
            setLeft(BinarySearchTreeProblem.minVal -1);
        }else if(left.getValue() == BinarySearchTreeProblem.minVal -1){
            return;
        } else{
            left.passDummy();
        }
    }

    public void rightDummy(){
        if(right == null){
            setRight(BinarySearchTreeProblem.minVal -1);
        }else if(right.getValue() == BinarySearchTreeProblem.minVal -1){
            return;
        }else{
            right.passDummy();
        }
    }
}
