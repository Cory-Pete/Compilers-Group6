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
    public static String postOrder(ASTNode n){
        System.out.println("CHILD");
        if(n.leftChild != null){System.out.println("Has left child");}
        if(n.rightChild != null){System.out.println("Has right child");}
        String leftSide = "";
        String rightSide = "";
        boolean flip = false;
        if(n.operator != null){
            System.out.println(n.operator);
        }
        if(n.data != null){
            System.out.println(n.data);
        }
        if(n.leftChild == null && n.rightChild == null)
        {
            System.out.println("HAS NO CHILDREN");
            if(n.data != null){
                return n.data;
            }
            else{
                return n.operator;
            }
        }
        
        if(n.operator.equals("+") || n.operator.equals("-") || n.operator.equals("*") || n.operator.equals("/"))
        {
            System.out.println("right side " + rightSide);
            rightSide = postOrder(n.rightChild);
            System.out.println("right side " + rightSide);
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
        String op;
        for(ASTNode root : rootList){
            System.out.println("NEW ROOT");
            String leftSide = "";
            String rightSide = "";
            if(root.leftChild == null && root.rightChild == null){
                System.out.println("HAS NO CHILDREN");
                if(root.data.equals("main")){
                    irlist.add(new IRNode("LABEL " + root.data + "\n;LINK"));
                    // System.out.println("LABEL " + root.data + "\n;LINK");
                }
            }
            else{
                if(root.leftChild != null){System.out.println("Has left child");}
                if(root.rightChild != null){System.out.println("Has right child");}
                System.out.println("going right");
                leftSide = postOrder(root.rightChild);
                System.out.println("going left");
                rightSide = postOrder(root.leftChild);
                if(root.rightChild.type == "INT"){
                    op = "STOREI";
                    irlist.add(new IRNode(op, leftSide, rightSide));
                    // System.out.println(";STOREI " + leftSide + " " + rightSide);
                   
                }
                else{
                    op = "STOREF";
                    irlist.add(new IRNode(op, leftSide, rightSide));
                    // System.out.println(";STOREF " + leftSide + " " + rightSide);
                    
                }
            }
        }
        irlist.add(new IRNode("end"));
        System.out.println(";ret");
    }

    public static ArrayList<IRNode> getIRNodes(){
        return irlist;
    }
}