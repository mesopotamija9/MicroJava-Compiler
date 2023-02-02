package rs.ac.bg.etf.pp1;

import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Struct;
import rs.etf.pp1.symboltable.visitors.DumpSymbolTableVisitor;

public class MySymbolTableVisitor extends DumpSymbolTableVisitor {
	@Override
	public void visitStructNode(Struct structToVisit) {
		if (structToVisit.getKind() == Struct.Bool) {
			output.append("bool");
		} else if (structToVisit.getKind() == Struct.Array && structToVisit.getElemType() == SymbolTable.boolType) {
			output.append("Arr of ");
			output.append("bool");
		}
		else {
			super.visitStructNode(structToVisit);
		}
	}
	
	public String printType(Struct type) {
		StringBuilder output = new StringBuilder();
		
		switch (type.getKind()) {
		case Struct.None:
			output.append("notype");
			break;
		case Struct.Int:
			output.append("int");
			break;
		case Struct.Char:
			output.append("char");
			break;
		case Struct.Bool:
			output.append("bool");
			break;
		case Struct.Array:
			output.append("Arr of ");
			
			switch (type.getElemType().getKind()) {
			case Struct.None:
				output.append("notype");
				break;
			case Struct.Int:
				output.append("int");
				break;
			case Struct.Char:
				output.append("char");
				break;
			case Struct.Bool:
				output.append("bool");
				break;
			case Struct.Class:
				output.append("Class");
				break;
			}
			break;
		case Struct.Class:
			output.append("Class [");
			for (Obj obj : type.getMembers()) {
				printObj(obj);
			}
			output.append("]");
			break;
		}
		
		
		return output.toString();
	}
	
	public String printObj(Obj objToPrint) {
		StringBuilder output = new StringBuilder();
		
		switch (objToPrint.getKind()) {
			case Obj.Con:  output.append("Con "); break;
			case Obj.Var:  output.append("Var "); break;
			case Obj.Type: output.append("Type "); break;
			case Obj.Meth: output.append("Meth "); break;
			case Obj.Fld:  output.append("Fld "); break;
			case Obj.Prog: output.append("Prog "); break;
		}
		
		output.append(objToPrint.getName());
		output.append(": ");
		
		if ((Obj.Var == objToPrint.getKind()) && "this".equalsIgnoreCase(objToPrint.getName()))
			output.append("");
		else
			output.append(printType(objToPrint.getType()));
		
		output.append(", ");
		output.append(objToPrint.getAdr());
		output.append(", ");
		output.append(objToPrint.getLevel());
				
		if (objToPrint.getKind() == Obj.Prog || objToPrint.getKind() == Obj.Meth) {
			output.append("\n");
			nextIndentationLevel();
		}
		

		for (Obj o : objToPrint.getLocalSymbols()) {
			output.append(currentIndent.toString());
			output.append(printObj(o));
			output.append("\n");
		}
		
		if (objToPrint.getKind() == Obj.Prog || objToPrint.getKind() == Obj.Meth) 
			previousIndentationLevel();

		return output.toString();
		
	}
}
