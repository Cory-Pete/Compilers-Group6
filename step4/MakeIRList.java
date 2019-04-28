import java.io.IOException;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.*;

public class MakeIRList {
    private static int registers = 0;

    public static String traverse(ASTNode n){
        if(n.leftChild == null && n.rightChild == null)
        {
            return n.data;
        }
        if(n.isRoot())
        {

        }
        if(n.operator != null)
        {
            if(child.rightChild.type == "INT"){
                flip = true;
            }
            else{
                flip = false;
            }
        }
        return "";
    }
}