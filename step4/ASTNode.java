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
    public boolean hasCode;

    // Expressions
    public ASTNode(String operator){
        this.operator = operator;
        children = new ArrayList<ASTNode>();
    }

    //Literals
    public ASTNode(String type, String data){
        this.type = type;
        side = false;

        if(type == "int"){
            this.data = data;
        }
        else if(type == "float"){
            this.data = data;
        }
        else if(type == "LABEL")
        {
            this.data = data;
        }
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

    public void setSide(Boolean side)
    {
        this.side = side;
    }

    public Boolean getSide()
    {
        return side;
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

    public boolean hasChildren()
    {
        if(children.size() == 0)
        {
            return false;
        }
        else{
            return true;
        }
    }

    public boolean hasChildRoot()
    {
        if(childRoot != null)
        {
            return true;
        }
        return false;
    }

    public ASTNode getChildRoot(){
        return childRoot;
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

    public String generateCode(){
        threeAC = ";LABEL main\n;LINK";
        generateCode(this.childRoot);
        return threeAC;
    }
    /*
    public void postOrderTraversal(ASTNode node)
    {
        if(node != null)
        {
            postOrderTraversal(node.rightChild);
            postOrderTraversal(node.leftChild);
        }
    }*/

    public String generateCode(ASTNode child){
        System.out.println("TOP");
        String rightSide = "";
        String leftSide = "";
        Boolean flip = true;
        if(child.rightChild != null){
            rightSide = generateCode(child.rightChild);
            if(child.rightChild.type == "INT"){
                flip = true;
            }
            else{
                flip = false;
            }
        }
        if(child.leftChild != null){
            leftSide = generateCode(child.rightChild);
            if(child.rightChild.type == "INT"){
                flip = true;
            }
            else{
                flip = false;
            }
        }
        else{
            if(childRoot != null)
            {
                generateCode(childRoot);
            }
            else{
                System.out.println("WTF");
                return this.data;
            }
        }
        System.out.println("MIDDLE");
        if(this.side){
            if(flip){
                switch(operator){
                    case "+":
                        threeAC = ";ADDI " + leftSide + " " + rightSide + " " + "$T" + 1 + "\n";
                        break;
                    case "-":
                        threeAC = ";SUBI " + leftSide + " " + rightSide + " " + "$T" + 1 + "\n";
                        break;
                    case "*":
                        threeAC = ";MULI " + leftSide + " " + rightSide + " " + "$T" + 1 + "\n";
                        break;
                    case "/":
                        threeAC = ";DIVI " + leftSide + " " + rightSide + " " + "$T" + 1 + "\n";
                        break;
                }
            }
            else{
                switch(operator){
                    case "+":
                        threeAC = ";ADDF " + leftSide + " " + rightSide + " " + "$T" + 1 + "\n";
                        break;
                    case "-":
                        threeAC = ";SUBF " + leftSide + " " + rightSide + " " + "$T" + 1 + "\n";
                        break;
                    case "*":
                        threeAC = ";MULF " + leftSide + " " + rightSide + " " + "$T" + 1 + "\n";
                        break;
                    case "/":
                        threeAC = ";DIVF " + leftSide + " " + rightSide + " " + "$T" + 1 + "\n";
                        break;
                }
            }
        }
        System.out.println("HI");
        this.hasCode = true; 
        System.out.println(threeAC);
        return "";
    }

}