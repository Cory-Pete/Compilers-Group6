import java.io.IOException;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.*;

public class MakeIRList {
    private static int register = 0;
    private static ArrayList<IRNode> irlist = new ArrayList<IRNode>();
    public static String threeAC;

    public MakeIRList(){

    }
    public static String traverse(ASTNode child){
        String leftSide = "";
        String rightSide = "";
        boolean flip = false;
        if(child.leftChild == null && child.rightChild == null && !child.isRoot())
        {
            //make irnode of STOREI 2, $t1
            //STORE $t1 a
            return child.data;
        }
        if(child.operator != null)
        {
            rightSide = traverse(child.rightChild);
            leftSide = traverse(child.rightChild);

            if(child.rightChild.type == "INT"){
                flip = true;
            }
            else{
                flip = false;
            }

            if(flip){
                switch(child.operator){
                    case "+":
                        threeAC = ";ADDI " + leftSide + " " + rightSide + " " + "$T" + register + "\n";
                        break;
                    case "-":
                        threeAC = ";SUBI " + leftSide + " " + rightSide + " " + "$T" + register + "\n";
                        break;
                    case "*":
                        threeAC = ";MULI " + leftSide + " " + rightSide + " " + "$T" + register + "\n";
                        break;
                    case "/":
                        threeAC = ";DIVI " + leftSide + " " + rightSide + " " + "$T" + register + "\n";
                        break;
                }
            }
            else{
                switch(child.operator){
                    case "+":
                        threeAC = ";ADDF " + leftSide + " " + rightSide + " " + "$T" + register + "\n";
                        break;
                    case "-":
                        threeAC = ";SUBF " + leftSide + " " + rightSide + " " + "$T" + register + "\n";
                        break;
                    case "*":
                        threeAC = ";MULF " + leftSide + " " + rightSide + " " + "$T" + register + "\n";
                        break;
                    case "/":
                        threeAC = ";DIVF " + leftSide + " " + rightSide + " " + "$T" + register + "\n";
                        break;
                }
            }

            //make new IRNode w/ 3AC?
        }

        if(child.isRoot())
        {
            if(child.leftChild != null && child.rightChild != null)
            {
            rightSide = traverse(child.rightChild);
            leftSide = traverse(child.rightChild);
            //make new IR node, add to list
            register += 1;
            if(child.hasChildRoot()){
                traverse(child.getRoot());
                return "";
                }
            }
        }
        register += 1;
        return String.valueOf(register-1);
    }

    public static ArrayList<IRNode> getIRNodes(){
        return irlist;
    }
}