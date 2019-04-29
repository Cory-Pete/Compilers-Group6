import java.io.IOException;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class MakeIRList {
    public int register = 0;
    public int label = 0;
    private static ArrayList<IRNode> irlist = new ArrayList<IRNode>();
    public static String threeAC, op;
    public HashMap<Integer, String> labelHolder = new HashMap<Integer, String>();

    public MakeIRList(){}

    public String postOrder(ASTNode n){
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
        
        if(n.operator.equals("+") || n.operator.equals("-") || n.operator.equals("*") || n.operator.equals("/"))
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
            irlist.add(new IRNode(op, leftSide, rightSide, "r" + String.valueOf(register)));
            register += 1;
            return ("r" + String.valueOf(register - 1));
        }
        return "";
    }
    
    public void start(ArrayList<ASTNode> rootList)
    {
        String op;
        for(ASTNode root : rootList){
            String leftSide = "";
            String rightSide = "";
            String operation = "";
            if(root.leftChild == null && root.rightChild == null){
                if(root.data.equals("main")){

                    irlist.add(new IRNode("LABEL " + root.data + "\n;LINK"));
                    System.out.println(";IR code");
                    System.out.println(";LABEL " + root.data + "\n;LINK");
                }
                else if(root.type.equals("WRITE")){
                    irlist.add(new IRNode("WRITE", root.id, root.data));
                    if(root.id.equals("INT")){
                        System.out.println(";WRITEI " + root.data);
                    } 
                    else if(root.id.equals("FLOAT")){
                        System.out.println(";WRITEF " + root.data);
                    }
                    else{
                        System.out.println(";WRITES " + root.data);
                    }
                }
                else if(root.id.equals("EXIT")){
                    System.out.println(";label " + labelHolder.get(root.tracker));
                    irlist.add(new IRNode("label", labelHolder.get(root.tracker)));
                }
                else{
                    System.out.println(";move " + root.data + " r" + register);
                    irlist.add(new IRNode("move", root.data, String.valueOf(register)));
                    if(root.type.equals("INT")){
                        System.out.println(";cmpi " + root.id + " r" + register);
                        irlist.add(new IRNode("cmpi", root.id, String.valueOf(register)));
                    }
                    else if(root.type.equals("FLOAT")){
                        System.out.println(";cmpr " + root.id + " r" + register);
                        irlist.add(new IRNode("cmpr", root.id, String.valueOf(register)));
                    }
                    switch(root.operator){
                        case ">":
                            operation = "le";
                            break;
                        case ">=":
                            operation = "lt";
                            break;
                        case "<":
                            operation = "ge";
                            break;
                        case "<=":
                            operation = "gt";
                            break;
                        case "!=":
                            operation = "eq";
                            break;
                        case "=":
                            operation = "ne";
                            break;
                    }
                    System.out.println(";j" + operation + " " + root.id + " label" + label);
                    operation = "j" + operation;
                    String temp = "label" + String.valueOf(label);
                    labelHolder.put(root.tracker, temp);
                    irlist.add(new IRNode(operation, root.id, temp));
                    label++;
                    register++;
                }
            }
            else{
                leftSide = postOrder(root.rightChild);
                rightSide = postOrder(root.leftChild);
                if(root.rightChild.type == "INT"){
                    op = "move";
                    irlist.add(new IRNode(op, leftSide, rightSide, String.valueOf(register)));
                    register++;
                    System.out.println(";STOREI " + leftSide + " $T" + register);
                    System.out.println(";STOREI $T" + register + " " + rightSide);
                }
                else{
                    op = "move";
                    irlist.add(new IRNode(op, leftSide, rightSide, String.valueOf(register)));
                    register++;
                    System.out.println(";STOREF " + leftSide + " $T" + register);
                    System.out.println(";STOREF $T" + register + " " + rightSide);
                }
            }
        }
        irlist.add(new IRNode("sys halt"));
        System.out.println(";RET");
    }

    public static ArrayList<IRNode> getIRNodes(){
        return irlist;
    }
}