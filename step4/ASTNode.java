import java.util.*;

public class ASTNode{

    
    public ASTNode parent;
    public String operator;
    public Boolean side;
    public String type;
    public String id;
    public String data;
    public ArrayList<ASTNode> children;
    public ASTNode leftChild, rightChild;
    public boolean root;
    public ASTNode childRoot;
    public String threeAC;
    public boolean hasCode, hasChildRoot;

    // Expressions
    public ASTNode(String operator){
        this.operator = operator;
        children = new ArrayList<ASTNode>();
    }

    //Literals
    public ASTNode(String type, String data){
        this.type = type;
        side = false;
        this.data = data;
    }

    // Roots
    public ASTNode(ASTNode leftChild){
        this.leftChild = leftChild;
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

    public void setSide(Boolean side){
        this.side = side;
    }

    public Boolean getSide(){
        return side;
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
               // System.out.println("CHild rem");
                children.remove(i);
                break;
            }
        }
    }

}