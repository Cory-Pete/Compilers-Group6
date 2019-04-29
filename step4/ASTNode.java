import java.util.*;

public class ASTNode{

    
    public ASTNode parent;
    public String operator;
    public String type;
    public String id;
    public String data;
    public ArrayList<ASTNode> children;
    public ASTNode leftChild, rightChild;
    public boolean root;
    public ASTNode childRoot;
    public int tracker;
    public boolean hasCode, hasChildRoot;

    // Expressions
    public ASTNode(String operator){
        this.operator = operator;
        children = new ArrayList<ASTNode>();
    }

    //Literals
    public ASTNode(String type, String data){
        this.type = type;
        this.data = data;
    }

    public ASTNode(String type, int data){
        this.id = type;
        this.tracker = data;
        this.data = "";
        this.type = "";
    }

    //Write
    public ASTNode(String var, String op, String val){
        this.id = var;
        this.type = op;
        this.data = val;
    }
    //Conditionals
    public ASTNode(String var, String op, String val, String type, int track){
        this.id = var;
        this.operator = op;
        this.data = val;
        this.type = type;
        this.tracker = track;
    }
    
    //Temps
    public ASTNode(){
        children = new ArrayList<ASTNode>();
    }

    public void setRightChild(ASTNode rightChild){
        this.rightChild = rightChild;
    }

    public void setLeftChild(ASTNode leftChild){
        this.leftChild = leftChild;
    }

    public void setParent(ASTNode p){
        parent = p;
    }
    public ASTNode getParent(){
        return parent;
    }

    public String getType(){
        return type;
    }

    public void setType(String type){
        this.type = type;
    }
    
    public void setRoot(){
        root = true;
    }

    public Boolean isRoot(){
        return root;
    }
    public String getID(){
        return id;
    }
    
    public void addChild(ASTNode child){
        children.add(child);
        child.setParent(this);
    }

    public ArrayList<ASTNode> getChildren(){
        return children;
    }

    public boolean hasChildren() {
        if(children.size() == 0){
            return false;
        }
        else{
            return true;
        }
    }

    public void setRoot(ASTNode childRoot){
        this.childRoot = childRoot;
        hasChildRoot = true;
    }

    public ASTNode getRoot(){
        return childRoot;
    }
    public boolean hasChildRoot(){
        return hasChildRoot;
    }
    public void removeChild(ASTNode childToBeRemoved)
    {
        for(int i = 0; i < children.size(); i++){
            if(childToBeRemoved == children.get(i))
            {   
                children.remove(i);
                break;
            }
        }
    }

}