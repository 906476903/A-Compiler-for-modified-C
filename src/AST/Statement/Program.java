package AST.Statement; /**
 * Created by xsc on 2016/3/30.
 */

import java.util.*;

public class Program extends Ast_node{

    List<Dec> Dlist;
    List<Stmt> Slist;

    Program(){
        Dlist = new LinkedList();
        Slist = new LinkedList();
    }
}
