import java.io.IOException;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.*;

public class MakeIRList {
    private static int registers = 0;
    private ArrayList<IRNode> irlist = new ArrayList<IRNode>();

    public static String traverse(ASTNode n){
        String leftside = "";
        String rightside = "";
        boolean flip = false;
        if(n.isRoot())
        {
            
        }
        else if(n.leftChild == null && n.rightChild == null)
        {
            return n.data;
        }
        if(n.operator != null)
        {
            rightSide = generateCode(child.rightChild);
            leftSide = generateCode(child.rightChild);

            if(child.rightChild.type == "INT"){
                flip = true;
            }
            else{
                flip = false;
            }

            if(flip){
                switch(operator){
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
                switch(operator){
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

        if(n.isRoot())
        {
            rightSide = generateCode(child.rightChild);
            leftSide = generateCode(child.rightChild);
            //make new IR node, add to list
            generateCode(n.getChildRoot());
            return "";
        }
        register += 1;
        return str(register-1);
    }
}