import java.util.*;

public class ASTNode{

    
    public ASTNode parent;
    public boolean visited;
    public char operator;
    public String type;
    public String id;
    public String data;
    public ArrayList<ASTNode> children;
    public ASTNode leftChild, rightChild;
    public boolean root;

    public ASTNode(String type){
        this.type = type;
        children = new ArrayList<ASTNode>();

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
        children = new ArrayList<ASTNode>();
    }

    public void setParent(ASTNode p){
        parent = p;
    }
    public ASTNode getParent(){
        return parent;
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
    
    public void setRoot(){
        root = true;
    }

    public Boolean isRoot(){
        return root;
    }
    public String getID()
    {
        return id;
    }

    public void addChild(ASTNode child)
    {
        children.add(child);
        child.setParent(this);
    }

}