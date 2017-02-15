// import ANTLR's runtime libraries
import AST.AST_VISIT.visit_first;
import AST.AST_VISIT.visit_second;
import AST.AST_VISIT.visit_zero;
import Error_handle.Error_msg;
import IR.Create_liner_IR;
import gen.MogicLexer;
import gen.MogicParser;
import gen.MogicVisitor;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.io.*;


public class Main {



    public static void main(String[] args) throws Exception {

        InputStream inputFile = System.in;
        OutputStream outputFile = System.out;

        //inputFile = new BufferedInputStream(new FileInputStream("./test.c"));

        //PrintStream ps=new PrintStream("./MX.s");
        //System.setOut(ps);


// create a CharStream that reads from standard input
        ANTLRInputStream input = new ANTLRInputStream(inputFile);

// create a lexer that feeds off of input CharStream
        MogicLexer lexer = new MogicLexer(input);
// create a buffer of tokens pulled from the lexer
        CommonTokenStream tokens = new CommonTokenStream(lexer);
// create a parser that feeds off the tokens buffer
        MogicParser parser = new MogicParser(tokens);
        ParseTree tree = parser.mogic_pro(); // begin parsing at init rule
        //System.out.println(tree.toStringTree(parser)); // print LISP-style tree

        MogicVisitor visitor0 = new visit_zero();
        visitor0.visit(tree);

        MogicVisitor visitor1 = new visit_first();
        visitor1.visit(tree);

        MogicVisitor visitor2 = new visit_second();
        visitor2.visit(tree);

        if(Error_msg.anyerrors)System.exit(1);
        //else System.exit(0);

        MogicVisitor create_IR = new Create_liner_IR();
        create_IR.visit(tree);
        ((Create_liner_IR)create_IR).print();


    }
}