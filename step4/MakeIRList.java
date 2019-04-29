import java.io.IOException;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class MakeIRList {
    private static int register = 0;
    private static ArrayList<IRNode> irlist = new ArrayList<IRNode>();
    public static String threeAC, op;
    public PrintWriter writer;

    public MakeIRList(PrintWriter writer){
        this.writer = writer;
    }
    public String postOrder(ASTNode n){
        //System.out.println("CHILD");
        // if(n.leftChild != null){System.out.println("Has left child");}
        // if(n.rightChild != null){System.out.println("Has right child");}
        String leftSide = "";
        String rightSide = "";
        boolean flip = false;
        if(n.leftChild == null && n.rightChild == null)
        {
            //System.out.println("HAS NO CHILDREN");
            if(n.data != null){
                //System.out.println(n.data);
                return n.data;
            }
            else{
                return n.operator;
            }
        }
        
        if(n.operator.equals("+") || n.operator.equals("-") || n.operator.equals("*") || n.operator.equals("/"))
        {
            rightSide = postOrder(n.rightChild);
           // System.out.println(n.operator);
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
           // writer.println(threeAC);
            irlist.add(new IRNode(op, leftSide, rightSide, register));
            register += 1;
            return String.valueOf(register-1);
            //make new IRNode w/ 3AC?
        }
        return "";
    }

    public void start(ArrayList<ASTNode> rootList)
    {
        String op;
        for(ASTNode root : rootList){
            String leftSide = "";
            String rightSide = "";
            if(root.leftChild == null && root.rightChild == null){
                if(root.data.equals("main")){

                    irlist.add(new IRNode("LABEL " + root.data + "\n;LINK"));
                    System.out.println(";IR code");
                    System.out.println(";LABEL " + root.data + "\n;LINK");
                   // writer.println(";IR code");
                   // writer.println(";LABEL " + root.data + "\n;LINK");
                }
                if(root.type.equals("WRITE")){
                    irlist.add(new IRNode("WRITE", root.id, root.data));
                    if(root.id.equals("INT")){
                        System.out.println(";WRITEI " + root.data);
                        //writer.println(";WRITEI " + root.data);
                    }
                    else if(root.id.equals("FLOAT")){
                        System.out.println(";WRITEF " + root.data);
                        //writer.println(";WRITEF " + root.data);
                    }
                    else{
                        System.out.println(";WRITES " + root.data);
                       // writer.println(";WRITES " + root.data);
                    }
                }
            }
            else{
                leftSide = postOrder(root.rightChild);
                rightSide = postOrder(root.leftChild);
                if(root.rightChild.type == "INT"){
                    op = "move";
                    irlist.add(new IRNode(op, leftSide, rightSide));
                    System.out.println(";STOREI " + leftSide + " " + rightSide);
                   // writer.println(";STOREI " + leftSide + " " + rightSide);
                   
                }
                else{
                    op = "move";
                    irlist.add(new IRNode(op, leftSide, rightSide));
                    System.out.println(";STOREF " + leftSide + " " + rightSide);
                    //writer.println(";STOREF " + leftSide + " " + rightSide);
                }
            }
        }
        irlist.add(new IRNode("sys halt"));
        System.out.println(";RET");
        //writer.println(";RET");
    }

    public static ArrayList<IRNode> getIRNodes(){
        return irlist;
    }
}