import java.util.*;

public class ASTNode{

    
    public ASTNode parent;
    public boolean visited;
    public char operator;
    public String type;
    public String id;
    public String data;
    public ArrayList<ASTNode> children = new ArrayList<ASTNode>();;
    public ASTNode leftChild, rightChild;
    public boolean root;
    public ASTNode childRoot;

    public ASTNode(String id){
        this.id = id;
        children = new ArrayList<ASTNode>();

        if(type == "+" || type == "-" || type == "*"){
        }
        else if(type == "="){
           // System.out.println("no");
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

    public ASTNode(ASTNode leftChild){
        this.leftChild = leftChild;
    }
    
    public ASTNode(){

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

    public void setType(String type)
    {
        this.type = type;
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

    public ArrayList<ASTNode> getChildren()
    {
        return children;
    }

    public void setRoot(ASTNode childRoot)
    {
        this.childRoot = childRoot;
    }

    public ASTNode getRoot(){
        return childRoot;
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

    public void generateCode()
    {

    }

}