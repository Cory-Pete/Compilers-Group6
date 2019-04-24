import java.util.*;

public class ASTNode{

    public ArrayList<ASTNode> children = new ArrayList<ASTNode>();
    public ASTNode parent;
    public boolean visited;
    public char operator;
    public String type;

    public ASTNode(String type){
        this.type = type;

        if(type == "+" || type == "-" || type == "*"){
            ASTNode child1 = new ASTNode();
            ASTNode child2 = new ASTNode();
            children.add(child1);
            children.add(child2);
            child1.setParent(this);
            child2.setParent(this);
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

}