import java.io.IOException;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.*;

public class MakeIRList {
    private static int register = 0;
    private static ArrayList<IRNode> irlist = new ArrayList<IRNode>();
    public static String threeAC, op;

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
        System.out.println(child.operator);
        if(child.operator != null)
        {
            rightSide = traverse(child.rightChild);
            leftSide = traverse(child.leftChild);

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
                        op = "ADDI";
                        break;
                    case "-":
                        threeAC = ";SUBI " + leftSide + " " + rightSide + " " + "$T" + register + "\n";
                        op = "SUBI";
                        break;
                    case "*":
                        threeAC = ";MULI " + leftSide + " " + rightSide + " " + "$T" + register + "\n";
                        op = "MULI";
                        break;
                    case "/":
                        threeAC = ";DIVI " + leftSide + " " + rightSide + " " + "$T" + register + "\n";
                        op = "DIVI";
                        break;
                }
            }
            else{
                switch(child.operator){
                    case "+":
                        threeAC = ";ADDF " + leftSide + " " + rightSide + " " + "$T" + register + "\n";
                        op = "ADDF";
                        break;
                    case "-":
                        threeAC = ";SUBF " + leftSide + " " + rightSide + " " + "$T" + register + "\n";
                        op = "SUBF";
                        break;
                    case "*":
                        threeAC = ";MULF " + leftSide + " " + rightSide + " " + "$T" + register + "\n";
                        op = "MULF";
                        break;
                    case "/":
                        threeAC = ";DIVF " + leftSide + " " + rightSide + " " + "$T" + register + "\n";
                        op = "DIVF";
                        break;
                }
            }
            System.out.println(threeAC);
           

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
            }
            if(child.hasChildRoot()){
                traverse(child.getRoot());
                return "";
                }
            
        }
        register += 1;
        return String.valueOf(register-1);
    }

    public static String postOrder(ASTNode n){
        String leftSide = "";
        String rightSide = "";
        boolean flip = false;
        if(n.leftChild == null && n.rightChild == null)
        {
            if(n.data != null){
                return n.data;
            }
            else{
                return n.operator;
            }
        }
        
        if(n.operator == "+" || n.operator == "-" || n.operator == "*" || n.operator == "/")
        {
            rightSide = postOrder(n.rightChild);
            leftSide = postOrder(n.leftChild);
           
            if(n.rightChild.type == "INT"){
                flip = true;
                n.setType("INT");
            }
            else{
                flip = false;
                n.setType("FLOAT");
            }

            if(flip){
                switch(n.operator){
                    case "+":
                        threeAC = ";ADDI " + leftSide + " " + rightSide + " " + "$T" + register;
                        op = "ADDI";
                        break;
                    case "-":
                        threeAC = ";SUBI " + leftSide + " " + rightSide + " " + "$T" + register;
                        op = "SUBI";
                        break;
                    case "*":
                        threeAC = ";MULI " + leftSide + " " + rightSide + " " + "$T" + register;
                        op = "MULI";
                        break;
                    case "/":
                        threeAC = ";DIVI " + leftSide + " " + rightSide + " " + "$T" + register;
                        op = "DIVI";
                        break;
                }
            }
            else{
                switch(n.operator){
                    case "+":
                        threeAC = ";ADDF " + leftSide + " " + rightSide + " " + "$T" + register;
                        op = "ADDF";
                        break;
                    case "-":
                        threeAC = ";SUBF " + leftSide + " " + rightSide + " " + "$T" + register;
                        op = "SUBF";
                        break;
                    case "*":
                        threeAC = ";MULF " + leftSide + " " + rightSide + " " + "$T" + register;
                        op = "MULF";
                        break;
                    case "/":
                        threeAC = ";DIVF " + leftSide + " " + rightSide + " " + "$T" + register;
                        op = "DIVF";
                        break;
                }
            }
            System.out.println(threeAC);
            irlist.add(new IRNode(op, leftSide, rightSide, register));
            register += 1;
            return String.valueOf(register-1);
            //make new IRNode w/ 3AC?
        }
        return "";
    }

    public static void start(ArrayList<ASTNode> rootList)
    {
        for(ASTNode root : rootList){
            String leftSide = "";
            String rightSide = "";
            if(root.leftChild == null && root.rightChild == null){
                if(root.data.equals("main")){
                    irlist.add(new IRNode("LABEL " + root.data + "\n;LINK"));
                }
            }
            else{
                leftSide = postOrder(root.rightChild);
                rightSide = postOrder(root.leftChild);
                if(root.rightChild.type == "INT"){
                    irlist.add(new IRNode(";STOREI " + leftSide + " " + rightSide));
                }
                else{
                    irlist.add(new IRNode(";STOREF " + leftSide + " " + rightSide));
                }
            }
        }
        irlist.add(new IRNode("end"));
    }

    public static ArrayList<IRNode> getIRNodes(){
        return irlist;
    }
}