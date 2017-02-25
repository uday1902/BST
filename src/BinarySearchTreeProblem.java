import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by vsonthy on 12/18/16.
 */
public class BinarySearchTreeProblem implements Problem{
    private BinarySearchTree root;
    public static int minVal;
    public void find(){

    }

    public void construct(){

    }

    public boolean constructAndCheckPreOrder(List<Integer> seq){
        if(seq.isEmpty()){
            return true;
        }
        Boolean first = true;
        for(int val : seq){
            if(first){
                root = new BinarySearchTree(val);
                first = false;
            }else{
                if(!root.addOrRejectPreOrder(val)){
                    return false;
                }
            }
        }
        return true;
    }

    public void setupAndSolveProblem(){
        //listCheck("3,17,11,7,5,4,9,21");
        listCheck("3,17,11,7,5,4,39,16");
    }

    public List<Integer> createSequence(String values){
        List<String> strList = new ArrayList<String>(Arrays.asList(values.split(",")));
        List<Integer> sequence = new ArrayList<>();
        for(String s : strList) sequence.add(Integer.valueOf(s));
        return sequence;
    }

    public void listCheck(String seqList){
        List<Integer> sequence = createSequence(seqList);
        minVal = minOfSequence(sequence);
        System.out.println("List " + seqList + " is " + (constructAndCheckPreOrder(sequence) ? "a":"NOT a") + " BST pre-order" );
    }

    public int minOfSequence(List<Integer> sequence){
        if(sequence.isEmpty())
            return -1;
        int min = sequence.get(0);
        for( int val: sequence){
            min = (min > val) ? val : min;
        }
        return min;
    }
}
