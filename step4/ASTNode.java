import java.util.*;

public class ASTNode{

    
    public ASTNode parent;
    public boolean visited;
    public char operator;
    public String type;
    public String id;
    public String data;
    public String childOne, childTwo;

    public ASTNode(String type){
        this.type = type;

        if(type == "+" || type == "-" || type == "*"){
        }
        else if(type == "="){
            System.out.println("no");
        }
    }

    public ASTNode(String type, String data, String id){
        this.type = type;

        if(type == "int" || type == "-" || type == "*"){
            this.data = data;
            this.id = id;
        }
        else if(type == "="){
            System.out.println("no");
        }
    }

    public ASTNode(){

    }

    public void setParent(ASTNode p){
        parent = p;
    }

    //set if symbol table has been visited
    public void setVisited(){
        visited = true;
    }

    public boolean visited(){
        return visited;
    }

    public String getType(){
        return type;
    }

    public void setChild(ASTNode child, boolean flip){
        if(flip){
            childOne = child;
        }
        else{
            childTwo = child;
        }
    }
    

    public String getID()
    {
        return id;
    }

}