import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class IRNode{
    public String operator, var, var1, var2, threeAC, val;
    public int register;
    PrintWriter writer;
    
    public IRNode(){

    }
    //main or end
    public IRNode(String threeAC){
        this.threeAC = threeAC;
    }
    //var declaration
    public IRNode(String var, String val){
        this.var = var;
        this.val = val;
    }
    //Operators
    public IRNode(String operator, String var1, String var2, int register){
        this.operator = operator;
        this.var1 = var1;
        this.var2 = var2;
        this.register = register;
        this.threeAC = null;
    }
    public IRNode(String operator, String var1, String var2){
        this.operator = operator;
        this.var1 = var1;
        this.var2 = var2;
    }

    public String getThreeAC(){
        return threeAC;
    }
    
    public void makeAssebly(ArrayList<IRNode> nodes, PrintWriter writer){
        this.writer = writer;
        for(IRNode n : nodes){
            if(n.operator != null){
                if(n.operator.equals("WRITE")){
                    switch(n.var1){
                        case "INT":
                            System.out.println("sys writei " + n.var2);
                            writer.println("sys writei " + n.var2);
                            break;
                        case "FLOAT":
                            System.out.println("sys writer " + n.var2);
                            writer.println("sys writer " + n.var2);
                            break;
                        case "STRING":
                            System.out.println("sys writes " + n.var2);
                            writer.println("sys writes " + n.var2);
                            break;
                    }
                }
            }
            if(n.threeAC != null && n.threeAC.equals("sys halt")){
                System.out.println(n.threeAC);
                writer.println(n.threeAC);
            }
            if(n.threeAC != null && n.threeAC.equals("LABEL main\n;LINK")){
                System.out.println("label main");
                writer.println("label main");
            }
            else{
                if(n.operator == "ADDI"){
                    System.out.println("addi " + n.var1 + " " + n.var2 + " " + n.register);
                    writer.println("addi " + n.var1 + " " + n.var2 + " " + n.register);
                }
                else if(n.operator == "ADDF"){
                    System.out.println("addr " + n.var1 + " " + n.var2 + " " + n.register);
                    writer.println("addr " + n.var1 + " " + n.var2 + " " + n.register);
                }
                else if(n.operator == "SUBI"){
                    System.out.println("subi " + n.var1 + " " + n.var2 + " " + n.register);
                    writer.println("subi " + n.var1 + " " + n.var2 + " " + n.register);
                }
                else if(n.operator == "SUBF"){
                    System.out.println("subr " + n.var1 + " " + n.var2 + " " + n.register);
                    writer.println("subr " + n.var1 + " " + n.var2 + " " + n.register);
                }
                else if(n.operator == "MULI"){
                    System.out.println("muli " + n.var1 + " " + n.var2 + " " + n.register);
                    writer.println("muli " + n.var1 + " " + n.var2 + " " + n.register);
                }
                else if(n.operator == "MULF"){
                    System.out.println("mulr " + n.var1 + " " + n.var2 + " " + n.register);
                    writer.println("mulr " + n.var1 + " " + n.var2 + " " + n.register);
                }
                else if(n.operator == "DIVI"){
                    System.out.println("divi " + n.var1 + " " + n.var2 + " " + n.register);
                    writer.println("divi " + n.var1 + " " + n.var2 + " " + n.register);
                }
                else if(n.operator == "DIVF"){
                    System.out.println("divr " + n.var1 + " " + n.var2 + " " + n.register);
                    writer.println("divr " + n.var1 + " " + n.var2 + " " + n.register);
                }
                else if(n.operator == "move"){
                    System.out.println("move " + n.var1 + " r" + n.register);
                    System.out.println("move r" + n.register + " " + n.var2);

                    writer.println("move " + n.var1 + " " + n.var2);
                }
                else if(n.operator == "cmpr"){
                    System.out.println("cmpr " + n.var1 + " r" + n.var2);
                }
                
            }
        }
    }


}