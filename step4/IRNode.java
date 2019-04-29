import java.util.*;

public class IRNode{
    public String operator, var, var1, var2, threeAC, val;
    public int register;
    
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
    
    public void makeAssebly(ArrayList<IRNode> nodes){
        for(IRNode n : nodes){
            if(n.operator.equals("WRITE")){
                switch(n.var1){
                    case "INT":
                        System.out.println("sys writei " + n.var2);
                        break;
                    case "FLOAT":
                        System.out.println("sys writei " + n.var2);
                        break;
                    case "STRING":
                        System.out.println("sys writei " + n.var2);
                        break;
                }
            }
            if(n.threeAC != null && n.threeAC.equals("sys halt")){
                System.out.println(n.threeAC);
            }
            if(n.threeAC != null && n.threeAC.equals("LABEL main\n;LINK")){
                System.out.println("label main");
            }
            else{
                if(n.operator == "ADDI"){
                    System.out.println("ADDI " + n.var1 + " " + n.var2 + " " + n.register);
                }
                else if(n.operator == "ADDF"){
                    System.out.println("ADDF " + n.var1 + " " + n.var2 + " " + n.register);
                }
                else if(n.operator == "SUBI"){
                    System.out.println("SUBI " + n.var1 + " " + n.var2 + " " + n.register);
                }
                else if(n.operator == "SUBF"){
                    System.out.println("SUBF " + n.var1 + " " + n.var2 + " " + n.register);
                }
                else if(n.operator == "MULI"){
                    System.out.println("MULI " + n.var1 + " " + n.var2 + " " + n.register);
                }
                else if(n.operator == "MULF"){
                    System.out.println("MULF " + n.var1 + " " + n.var2 + " " + n.register);
                }
                else if(n.operator == "DIVI"){
                    System.out.println("DIVI " + n.var1 + " " + n.var2 + " " + n.register);
                }
                else if(n.operator == "DIVF"){
                    System.out.println("DIVF " + n.var1 + " " + n.var2 + " " + n.register);
                }
                else if(n.operator == "move"){
                    System.out.println("move " + n.var1 + " " + n.var2);
                }
                
            }
        }
    }


}