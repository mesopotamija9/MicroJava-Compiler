package rs.ac.bg.etf.pp1;

import org.apache.log4j.Logger;
import rs.ac.bg.etf.pp1.ast.*;

public class RuleVisitor extends VisitorAdaptor {

	Logger log = Logger.getLogger(getClass());
	
	public void visit(Program Program) { 
		log.info("Prepoznat pogram");
	}
	
	int counter = 0;
	
	public void visit(VarDeclaration VarDeclaration) { 
		counter++;
		log.info("VarDeclaration: " + counter);
	}
	
	public void visit(VarDeclMultiple VarDeclMultiple) { 
		counter++;
		log.info("VarDeclMultiple: " + counter);
	}
}
