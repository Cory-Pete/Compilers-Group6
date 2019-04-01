import java.util.*;

public class ASTNode{

    public String type;// e.g add_op, expr_prefix
    public ArrayList<ASTNode> children = new ArrayList<ASTNode>();
    public ASTNode parent;
    public boolean visited;
    public char operator;

    public ASTNode(String type, char operator){
        this.type = type;
        this.operator = operator;
        if(name == "add_op"){
            ASTNode child1 = new ASTNode("child1");
            ASTNode child2 = new ASTNode("child2");
            children.add(child1);
            children.add(child2);
            child1.setParent(this);
            child2.setParent(this);
        }
        else if(name == "expr_prefix"){
            System.out.println("no");
        }
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