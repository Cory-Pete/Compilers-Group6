import java.util.*;

public class ASTNode{

    public String type;// e.g add_op, expr_prefix
    public ArrayList<ASTNode> children = null;
    public ASTNode parent;

    public ASTNode(String type){
        this.name = name;
    }

    public void setParent(ASTNode p){
        parent = p;
    }

    

}