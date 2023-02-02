package rs.ac.bg.etf.pp1;

import rs.ac.bg.etf.pp1.ast.*;

public class CounterVisitor extends VisitorAdaptor {
	
	protected int count;
	
	public int getCount() {
		return count;
	}
	
	public static class FormParamsCounter extends CounterVisitor {
		public void visit(FormParams formParams) {
			count++;
		}
		
		public void visit(FormParamsMultiple formParamsMultiple) {
			count++;
		}
	}
	
	public static class VarDeclCounter extends CounterVisitor {
		public void visit(VarDeclaration varDeclaration) {
			count++;
		}
		
		public void visit(VarDeclMultiple varDeclMultiple) {
			count++;
		}
	}
}
