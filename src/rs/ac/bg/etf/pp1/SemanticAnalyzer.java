package rs.ac.bg.etf.pp1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.symboltable.*;
import rs.etf.pp1.symboltable.concepts.*;

public class SemanticAnalyzer extends VisitorAdaptor {
	private Logger log = Logger.getLogger(getClass());
	private MySymbolTableVisitor mstv = new MySymbolTableVisitor();
	
	private boolean errorDetected = false;
	
	public void report_error(String message, SyntaxNode info) {
		errorDetected = true;
		StringBuilder msg = new StringBuilder(message);
		int line = (info == null) ? 0: info.getLine();
		if (line != 0)
			msg.append (" <- Greska na liniji ").append(line);
		log.error(msg.toString());
	}

	public void report_info(String message, SyntaxNode info) {
		StringBuilder msg = new StringBuilder(message); 
		int line = (info == null) ? 0: info.getLine();
		if (line != 0)
			msg.append (" na liniji ").append(line);
		log.info(msg.toString());
	}
	
	private int nVars;
	
	private int constDeclCount = 0;
	private int globalVarDeclCount = 0;
	private int localVarDeclCount = 0;
	
	private String currentTypeName;
	private String currentConstName;
	
	private Obj currentMethod;
	private int currentMethodParamCount = 0;
	private boolean mainHasParams;
	
	private Obj currentFunctionWithParamsBeingCalled;
	private List<Obj> designators = new ArrayList<>();
	private List<Integer> actualParamsCount = new ArrayList<>();
	
	private int functionCallCounter = 0;
	private List<List<Struct>> expressions = new ArrayList<>();
	
	private boolean inWhile = false;
	private boolean breakFound = false;
	
	private int whileCounter = 0;
	private int foreachCounter = 0;
	
	
	public boolean errorIsDetected() {
		return errorDetected;
	}
	
	public int getNVars() {
		return nVars;
	}
	
	public void visit(ProgramName programName){
		Obj objBeforeInsert = SymbolTable.find(programName.getProgramName());
		programName.obj = SymbolTable.insert(Obj.Prog, programName.getProgramName(), SymbolTable.noType);

		if (objBeforeInsert == programName.obj) {
			report_error("Simbol '" + programName.getProgramName() + "' je vec deklarisan u trenutnom opsegu", programName);
		}
		
		SymbolTable.openScope();
    }
	
	public void visit(Program program){
    	nVars = SymbolTable.currentScope.getnVars();
    	SymbolTable.chainLocalSymbols(program.getProgramName().obj);
    	
    	Obj mainMethodObj = SymbolTable.find("main");
    	
    	if (mainMethodObj == SymbolTable.noObj) {
    		report_error("Main metoda mora biti deklarisana kao void metoda bez argumenata", null);
    	}
    	
    	if (mainMethodObj.getType() != SymbolTable.noType) {
    		report_error("Main metoda mora imati povreatnu vrednost void", null);
    	}
    	
    	if (mainHasParams) {
    		report_error("Main metoda ne sme imati ni jedan parametar", null);
		}
    	
    	SymbolTable.closeScope();
    }

	public void visit(LiteralElementInt literalElementInt) {
		int currentIntLiteral = literalElementInt.getLiteralValue();
		
		Obj varTypeObj;
		if (currentTypeName == null) {
			varTypeObj = SymbolTable.noObj;
		} else {
			varTypeObj = SymbolTable.find(currentTypeName);
		}
		
		if (varTypeObj.getType() != SymbolTable.intType) {
			report_error("Pogresan tip konstante: '" + mstv.printType(varTypeObj.getType()) + "' != 'int'", literalElementInt);
			varTypeObj = SymbolTable.noObj;
		}
		
		if (SymbolTable.find(currentConstName) != SymbolTable.noObj) {
			report_error("Simbol '" + currentConstName + "' je vec deklarisan u trenutnom opsegu", literalElementInt);
		}
		
		literalElementInt.obj = SymbolTable.insert(Obj.Con, currentConstName, varTypeObj.getType());
		literalElementInt.obj.setAdr(currentIntLiteral);
		
		constDeclCount++;
		
		report_info("Deklaracija konstante -> " + new MySymbolTableVisitor().printObj(literalElementInt.obj), literalElementInt);
	}
	
	public void visit(LiteralElementChar literalElementChar) {
		char currentCharLiteral = literalElementChar.getLiteralValue();
		
		Obj varTypeObj;
		if (currentTypeName == null) {
			varTypeObj = SymbolTable.noObj;
		} else {
			varTypeObj = SymbolTable.find(currentTypeName);
		}
		
		if (varTypeObj.getType() != SymbolTable.charType) {
			report_error("Pogresan tip konstante: '" + mstv.printType(varTypeObj.getType()) + "' != 'char'", literalElementChar);
			varTypeObj = SymbolTable.noObj;
		}
		
		if (SymbolTable.find(currentConstName) != SymbolTable.noObj) {
			report_error("Simbol '" + currentConstName + "' je vec deklarisan u trenutnom opsegu", literalElementChar);
		}
		
		literalElementChar.obj = SymbolTable.insert(Obj.Con, currentConstName, varTypeObj.getType());
		literalElementChar.obj.setAdr(currentCharLiteral);
		
		constDeclCount++;
		
		report_info("Deklaracija konstante -> " + new MySymbolTableVisitor().printObj(literalElementChar.obj), literalElementChar);
	}
	
	public void visit(LiteralElementBool literalElementBool) {
		boolean currentBoolLiteral = literalElementBool.getLiteralValue();
		
		Obj varTypeObj;
		if (currentTypeName == null) {
			varTypeObj = SymbolTable.noObj;
		} else {
			varTypeObj = SymbolTable.find(currentTypeName);
		}
		
		if (varTypeObj.getType() != SymbolTable.boolType) {
			report_error("Pogresan tip konstante: '" + mstv.printType(varTypeObj.getType()) + "' != 'bool'", literalElementBool);
			varTypeObj = SymbolTable.noObj;
		}
		
		if (SymbolTable.find(currentConstName) != SymbolTable.noObj) {
			report_error("Simbol '" + currentConstName + "' je vec deklarisan u trenutnom opsegu", literalElementBool);
		}
		
		literalElementBool.obj = SymbolTable.insert(Obj.Con, currentConstName, varTypeObj.getType());
		literalElementBool.obj.setAdr(currentBoolLiteral?1:0);
		
		constDeclCount++;
		
		report_info("Deklaracija konstante -> " + new MySymbolTableVisitor().printObj(literalElementBool.obj), literalElementBool);
	}
	
	public void visit(ConstName constName) {
		currentConstName = constName.getConstName();
	}
	
	public void visit(VariableName variableName){
		Obj varTypeObj;
		if (currentTypeName == null) {
			varTypeObj = SymbolTable.noObj;
		} else {
			varTypeObj = SymbolTable.find(currentTypeName);
		}
		
		Obj objBeforeInsert = SymbolTable.find(variableName.getVarName());
		variableName.obj = SymbolTable.insert(Obj.Var, variableName.getVarName(), varTypeObj.getType());
		
		if (objBeforeInsert == variableName.obj) {
			report_error("Simbol '" + variableName.getVarName() + "' je vec deklarisan u trenutnom opsegu", variableName);
			return;
		}
		
		if(variableName.obj.getLevel() == 0) {
			globalVarDeclCount++;
			report_info("Deklaracija globalne promenljive -> " + new MySymbolTableVisitor().printObj(variableName.obj), variableName);
		} else {
			localVarDeclCount++;
			report_info("Deklaracija lokalne promenljive -> " + new MySymbolTableVisitor().printObj(variableName.obj), variableName);
		}
    }
	
	public void visit(VariableArrayName variableArrayName){
		Obj varTypeObj;
		if (currentTypeName == null) {
			varTypeObj = SymbolTable.noObj;
		} else {
			varTypeObj = SymbolTable.find(currentTypeName);
		}
		
		Struct varStruct = new Struct(Struct.Array);
		varStruct.setElementType(varTypeObj.getType());
		
		Obj objBeforeInsert = SymbolTable.find(variableArrayName.getVarArrayName());
		variableArrayName.obj = SymbolTable.insert(Obj.Var, variableArrayName.getVarArrayName(), varStruct);
		
		if (objBeforeInsert == variableArrayName.obj) {
			report_error("Simbol '" + variableArrayName.getVarArrayName() + "' je vec deklarisan u trenutnom opsegu", variableArrayName);
			return;
		}
		
		if(variableArrayName.obj.getLevel() == 0) {
			globalVarDeclCount++;
			report_info("Deklaracija globalne promenljive -> " + new MySymbolTableVisitor().printObj(variableArrayName.obj), variableArrayName);
		} else {
			localVarDeclCount++;
			report_info("Deklaracija lokalne promenljive -> " + new MySymbolTableVisitor().printObj(variableArrayName.obj), variableArrayName);
		}
    }
	
	public void visit(Type type) {
		Obj typeNode = SymbolTable.find(type.getTypeName());
		if (typeNode == SymbolTable.noObj) {
			report_error("Nije pronadjen tip '" + type.getTypeName() + "' u tabeli simbola", type);
			type.struct = SymbolTable.noType;
			currentTypeName = null;
			return;
		} 
		if (Obj.Type != typeNode.getKind()) {
			report_error("'" + type.getTypeName() + "' ne predstavlja tip", type);
			type.struct = SymbolTable.noType;
			currentTypeName = null;
			return;
		}
		
		type.struct = typeNode.getType();
		currentTypeName = type.getTypeName();
	}
	
	public void visit(MethodDeclarationVoid methodDeclarationVoid) {
		currentMethod.setLevel(currentMethodParamCount);
		SymbolTable.chainLocalSymbols(currentMethod);
		SymbolTable.closeScope();
    	
    	currentMethod = null;
    	currentMethodParamCount = 0;
	}
	
	public void visit(MethodNameVoid methodNameVoid) {
		Obj objBeforeInsert = SymbolTable.find(methodNameVoid.getMethodName());
		currentMethod = SymbolTable.insert(Obj.Meth, methodNameVoid.getMethodName(), SymbolTable.noType);
		
		if (objBeforeInsert == currentMethod) {
			report_error("Simbol '" + methodNameVoid.getMethodName() + "' je vec deklarisan u trenutnom opsegu", methodNameVoid);
		}
		
		methodNameVoid.obj = currentMethod;
		SymbolTable.openScope();
		report_info("Obradjuje se deklaracija funkcije " + methodNameVoid.getMethodName(), methodNameVoid);
	}
	
	public void visit(MethodDeclarationType methodDeclarationType) {
		currentMethod.setLevel(currentMethodParamCount);
		SymbolTable.chainLocalSymbols(currentMethod);
		SymbolTable.closeScope();
    	
    	currentMethod = null;
    	currentMethodParamCount = 0;
	}
	
	public void visit(MethodNameType methodNameType) {
		Obj methTypeObj;
		if (currentTypeName == null) {
			methTypeObj = SymbolTable.noObj;
		} else {
			methTypeObj = SymbolTable.find(currentTypeName);
		}
		
		Obj objBeforeInsert = SymbolTable.find(methodNameType.getMethodName());
		currentMethod = SymbolTable.insert(Obj.Meth, methodNameType.getMethodName(), methTypeObj.getType());
		
		if (objBeforeInsert == currentMethod) {
			report_error("Simbol '" + methodNameType.getMethodName() + "' je vec deklarisan u trenutnom opsegu", methodNameType);
		}
		
		methodNameType.obj = currentMethod;
		SymbolTable.openScope();
		report_info("Obradjuje se deklaracija funkcije " + methodNameType.getMethodName(), methodNameType);
	}
	
	public void visit(ParamTypeName paramTypeName){
		Obj paramTypeObj;
		if (currentTypeName == null) {
			paramTypeObj = SymbolTable.noObj;
		} else {
			paramTypeObj = SymbolTable.find(currentTypeName);
		}
		
		Obj objBeforeInsert = SymbolTable.find(paramTypeName.getParamName());
		paramTypeName.obj = SymbolTable.insert(Obj.Var, paramTypeName.getParamName(), paramTypeObj.getType());
		
		if (objBeforeInsert == paramTypeName.obj) {
			report_error("Simbol '" + paramTypeName.getParamName() + "' je vec deklarisan u trenutnom opsegu", paramTypeName);
		}
		
		if (currentMethod.getName().equals("main")) {
			mainHasParams = true;
		}
		
		currentMethodParamCount++;
		currentMethod.setLevel(currentMethodParamCount);
		report_info("Deklaracija formalnog parametra funkcije -> " + mstv.printObj(paramTypeName.obj), paramTypeName);
    }
	
	public void visit(ParamArrayTypeName paramArrayTypeName){
		Obj paramTypeObj;
		if (currentTypeName == null) {
			paramTypeObj = SymbolTable.noObj;
		} else {
			paramTypeObj = SymbolTable.find(currentTypeName);
		}
		
		Struct paramStruct = new Struct(Struct.Array);
		paramStruct.setElementType(paramTypeObj.getType());
		
		Obj objBeforeInsert = SymbolTable.find(paramArrayTypeName.getParamArrayName());
		paramArrayTypeName.obj = SymbolTable.insert(Obj.Var, paramArrayTypeName.getParamArrayName(), paramStruct);
		
		if (objBeforeInsert == paramArrayTypeName.obj) {
			report_error("Simbol '" + paramArrayTypeName.getParamArrayName() + "' je vec deklarisan u trenutnom opsegu", paramArrayTypeName);
		}
		
		if (currentMethod.getName().equals("main")) {
			mainHasParams = true;
		}
		
		currentMethodParamCount++;
		currentMethod.setLevel(currentMethodParamCount);
		report_info("Deklaracija formalnog parametra funkcije -> " + mstv.printObj(paramArrayTypeName.obj), paramArrayTypeName);
    }
	
	public void visit(DesignatorIdent designatorIdent) {
		Obj designatorObj = SymbolTable.find(designatorIdent.getDesignatorName());
		if (designatorObj == SymbolTable.noObj) {
			report_error("Simbol '" + designatorIdent.getDesignatorName() + "' nije deklarisan", designatorIdent);
			designatorIdent.obj = SymbolTable.noObj;
			return;
		}
		
		// Read param name
		designators.add(designatorObj);
		
		designatorIdent.obj = designatorObj;
		report_info("Upotreba simbola '" + designatorIdent.getDesignatorName() + "'", designatorIdent);
	}
	
	public void visit(Designator designator) {
		designator.obj = designator.getDesignatorMultiple().obj;
	}
	
	public void visit(DesignatorStatementIncrement designatorStatementIncrement) {
		Obj designatorObj = designatorStatementIncrement.getDesignator().obj;
		if (designatorObj.getKind() != Obj.Var && designatorObj.getKind() != Obj.Elem) {
			report_error("Operand '" + designatorObj.getName() + "' mora biti promenljiva, element niza ili polje objekta unutrašnje klase", designatorStatementIncrement);
			return;
		}
		
		if (designatorObj.getType() == null) {
			report_error("Operand '" + designatorObj.getName() + "' mora biti niz", designatorStatementIncrement);
			return;
		}
		
		if (designatorObj.getType() != SymbolTable.intType) {
			report_error("Operand '" + designatorObj.getName() + "' mora biti tipa 'int'", designatorStatementIncrement);
			return;
		}
	}
	
	public void visit(DesignatorStatementDecrement designatorStatementDecrement) {
		Obj designatorObj = designatorStatementDecrement.getDesignator().obj;
		if (designatorObj.getKind() != Obj.Var && designatorObj.getKind() != Obj.Elem) {
			report_error("Operand '" + designatorObj.getName() + "' mora biti promenljiva, element niza ili polje objekta unutrašnje klase", designatorStatementDecrement);
			return;
		}
		
		if (designatorObj.getType() == null) {
			report_error("Operand '" + designatorObj.getName() + "' mora biti niz", designatorStatementDecrement);
			return;
		}
		
		if (designatorObj.getType() != SymbolTable.intType) {
			report_error("Operand '" + designatorObj.getName() + "' mora biti tipa 'int'", designatorStatementDecrement);
			return;
		}
	}
	
	public void visit(DesignatorMul designatorMul) {
		if (designatorMul.getDesignatorMultiple().obj == SymbolTable.noObj) {
			designatorMul.obj = SymbolTable.noObj;
			return;
		}
		
		String designatorName = designatorMul.getDesignatorMultiple().obj.getName();
		Obj designatorObj = SymbolTable.find(designatorName);
		
		if (designatorMul.getExpr().struct != SymbolTable.intType) {
			report_error("Izraz unutar [] mora biti tipa 'int'", designatorMul);
			designatorMul.obj = SymbolTable.noObj;
			return;
		}
		
		if (designatorObj.getType().getKind() != Struct.Array) {
			report_error("'" + designatorName + "' nije niz", designatorMul);
			designatorMul.obj = SymbolTable.noObj;
			return;
		}
		
		int old_adr = designatorObj.getAdr();
		int old_lvl = designatorObj.getLevel();
		designatorMul.obj = new Obj(Obj.Elem, designatorName, designatorObj.getType().getElemType());
		designatorMul.obj.setAdr(old_adr);
		designatorMul.obj.setLevel(old_lvl);
		
		//		designatorMul.obj = designatorMul.getDesignatorMultiple().obj;
	}
	
	public void visit(DesignatorStatementAssign designatorStatementAssign) {
		Struct designatorStruct = designatorStatementAssign.getDesignator().obj.getType();
		Struct exprStruct = designatorStatementAssign.getExpr().struct;
		
		if (designatorStatementAssign.getDesignator().obj.getKind() == Obj.Meth) {
			report_error("Nije moguce dodelite vrednost funkciji '" + designatorStatementAssign.getDesignator().obj.getName() + "'", designatorStatementAssign);
			return;
		}
		
		int designatorKind;
		int exprKind;
		
		
		if (designatorStatementAssign.getDesignator().getDesignatorMultiple().obj.getKind() == Obj.Elem) {
			if (designatorStatementAssign.getDesignator().getDesignatorMultiple().obj.getType().getKind() != exprStruct.getKind()) {
				report_error("c) Leva i desan strana moraju imati isti tip", designatorStatementAssign);
			}
			
			return;
		}
		
		if (designatorStruct.getKind() == Struct.Array) {
			if (exprStruct.getKind() != Struct.Array) {
				report_error("a) Leva i desan strana moraju imati isti tip", designatorStatementAssign);
				return;
			} else if (designatorStruct.getElemType() != exprStruct.getElemType()) {
				report_error("b) Leva i desan strana moraju imati isti tip", designatorStatementAssign);
				return;
			}
		}
		
		
		
		if (designatorStruct.getKind() != exprStruct.getKind()) {
			report_error("d) Leva i desan strana moraju imati isti tip -> '" + mstv.printType(designatorStruct) + "' != '" + mstv.printType(exprStruct) + "'", designatorStatementAssign);
			return;
		}
		
//		
//		if (designatorStruct.getKind() == Struct.Array) {
//			designatorKind = 
//			
//			if (designatorStruct.getKind() != exprStruct.getElemType().getKind()) {
//				report_error("a) Nisu isti tipovi", designatorStatementAssign);
//			}
//		} else {
//			if (designatorStruct.getKind() != exprStruct.getKind()) {
//				report_error("b) Nisu isti tipovi", designatorStatementAssign);
//			}
//		}
		
		
	}
	
	public void visit(DesignatorStatementDesignatorFirstInBrackets designatorStatementDesignatorFirstInBrackets) {
		Obj designatorFirstObj = designatorStatementDesignatorFirstInBrackets.getDesignator().obj;
		Obj designatorListObj = designatorStatementDesignatorFirstInBrackets.getDesignatorL().obj;
		Obj designatorAfterEqualsAssignObj = designatorStatementDesignatorFirstInBrackets.getDesignator1().obj;
	
		if (designatorFirstObj.getKind() != Obj.Var && designatorFirstObj.getKind() != Obj.Elem && designatorFirstObj.getKind() != designatorAfterEqualsAssignObj.Fld) {
			report_error("Unutar [] se moze nalaziti samo promenljiva, element niza ili polje unutar objekta", designatorStatementDesignatorFirstInBrackets);
			return;
		}
		
		if (designatorListObj != null) {
			if (designatorListObj.getKind() != Obj.Var && designatorListObj.getKind() != Obj.Elem && designatorListObj.getKind() != designatorAfterEqualsAssignObj.Fld) {
				report_error("Unutar [] se moze nalaziti samo promenljiva, element niza ili polje unutar objekta", designatorStatementDesignatorFirstInBrackets);
				return;
			}
			
			if (designatorFirstObj.getType() != designatorListObj.getType()) {
				report_error("Neslaganje u tipovima unutar []. Svi tipovi biti isti", designatorStatementDesignatorFirstInBrackets);
				return;
			}
		}
		
		
		
		
		if (designatorAfterEqualsAssignObj.getType().getKind() != Struct.Array) {
			report_error("Promenljiva sa desne strane '=' mora biti niz", designatorStatementDesignatorFirstInBrackets);
			return;
		}
		
		if (designatorAfterEqualsAssignObj.getType().getElemType() != designatorFirstObj.getType()) {
			report_error("Tip sa leve strane '=' mora odgovarati tipu elementa niza sa desne strane '='", designatorStatementDesignatorFirstInBrackets);
			return;
		}
	}
	
	public void visit(DesignatorStatementCommaFirstInBrackets designatorStatementCommaFirstInBrackets) {
		Obj designatorListObj = designatorStatementCommaFirstInBrackets.getDesignatorL().obj;
		Obj designatorAfterEqualsAssignObj = designatorStatementCommaFirstInBrackets.getDesignator().obj;
	
		if (designatorListObj == null) {
			return;
		}
		
		if (designatorListObj.getKind() != Obj.Var && designatorListObj.getKind() != Obj.Elem && designatorListObj.getKind() != designatorAfterEqualsAssignObj.Fld) {
			report_error("Unutar [] se moze nalaziti samo promenljiva, element niza ili polje unutar objekta", designatorStatementCommaFirstInBrackets);
			return;
		}
		
		if (designatorAfterEqualsAssignObj.getType().getKind() != Struct.Array) {
			report_error("Promenljiva sa desne strane '=' mora biti niz", designatorStatementCommaFirstInBrackets);
			return;
		}
		
		if (designatorAfterEqualsAssignObj.getType().getElemType() != designatorListObj.getType()) {
			report_error("Tip sa leve strane '=' mora odgovarati tipu elementa niza sa desne strane '='", designatorStatementCommaFirstInBrackets);
			return;
		}
	}

	public void visit(DesignatorListCommaAndDesignator designatorListCommaAndDesignator) {
		if (designatorListCommaAndDesignator.getDesignatorL().obj != null) {
			if (designatorListCommaAndDesignator.getDesignatorL().obj.getType() != designatorListCommaAndDesignator.getDesignator().obj.getType()) {
//				report_error("a_ Neslaganje u tipovima unutar []. Svi tipovi biti isti", designatorListCommaAndDesignator);
				designatorListCommaAndDesignator.obj = SymbolTable.noObj;
				return;
			}
		}
		
		
		designatorListCommaAndDesignator.obj = designatorListCommaAndDesignator.getDesignator().obj;
	}
	
	public void visit(DesignatorListCommaOnly designatorListCommaOnly) {
		designatorListCommaOnly.obj = designatorListCommaOnly.getDesignatorL().obj;
	}
		
	public void visit(FactorIntLiteral factorIntLiteral) {
		factorIntLiteral.struct = SymbolTable.intType;
	}
	
	public void visit(FactorCharLiteral factorCharLiteral) {
		factorCharLiteral.struct = SymbolTable.charType;
	}
	
	public void visit(FactorBoolLiteral factorBoolLiteral) {
		factorBoolLiteral.struct = SymbolTable.boolType;
	}
	
	public void visit(FactorDesignator factorDesignator) {
		factorDesignator.struct = factorDesignator.getDesignator().obj.getType();
	}
	
	public void visit(FactorExpr factorExpr) {
		factorExpr.struct = factorExpr.getExpr().struct;
	}
	
	public void visit(FactorNewTypeExpr factorNewTypeExpr) {
		if (factorNewTypeExpr.getExpr().struct != SymbolTable.intType) {
			report_error("Izraz unutar [] mora biti tipa 'int'", factorNewTypeExpr);
			factorNewTypeExpr.struct = SymbolTable.noType;
			return;
		}
		
		Struct struct = new Struct(Struct.Array);
		struct.setElementType(SymbolTable.find(factorNewTypeExpr.getType().getTypeName()).getType());
		factorNewTypeExpr.struct = struct;
	}
	
	public void visit(MulopFactor mulopFactor) {
		mulopFactor.struct = mulopFactor.getFactor().struct;
	}
	
	public void visit(Term term) {
		if (term.getMulopFact().struct != null) {
			if (term.getFactor().struct.getKind() != term.getMulopFact().struct.getKind()) {
				term.struct = new Struct(Struct.None);
			} else if (term.getFactor().struct.getKind() != Struct.Int || term.getMulopFact().struct.getKind() != Struct.Int) {
				report_error("'*', '/' i '%' se mogu koristiti samo sa tipom 'int'", term);
				term.struct = new Struct(Struct.None);
			}  
			else {
				term.struct = term.getFactor().struct;
			}
		} else {
			term.struct = term.getFactor().struct;
		}
	}
	
	
	public void visit(ExprWithoutMinus exprWithoutMinus) {
		if (exprWithoutMinus.getAddopTerm().struct != null) {
			if (exprWithoutMinus.getTerm().struct.getKind() != exprWithoutMinus.getAddopTerm().struct.getKind()) {
				exprWithoutMinus.struct = new Struct(Struct.None);
			} else if (exprWithoutMinus.getTerm().struct.getKind() != Struct.Int || exprWithoutMinus.getAddopTerm().struct.getKind() != Struct.Int) {
				report_error("'+' i '-' se mogu koristiti samo sa tipom 'int'", exprWithoutMinus);
				exprWithoutMinus.struct = new Struct(Struct.None);
			}
			else {
				exprWithoutMinus.struct = exprWithoutMinus.getTerm().struct;
			}
		} else {
			exprWithoutMinus.struct = exprWithoutMinus.getTerm().struct;
		}
	}
	
	public void visit(AddopTerminal addopTerminal) {
//		addopTerminal.struct = addopTerminal.getTerm().struct;
		
		if (addopTerminal.getAddopTerm().struct != null) {
			if (addopTerminal.getTerm().struct.getKind() != addopTerminal.getAddopTerm().struct.getKind()) {
				addopTerminal.struct = new Struct(Struct.None);
			} else if (addopTerminal.getTerm().struct.getKind() != Struct.Int || addopTerminal.getAddopTerm().struct.getKind() != Struct.Int) {
				report_error("'+' i '-' se mogu koristiti samo sa tipom 'int'", addopTerminal);
				addopTerminal.struct = new Struct(Struct.None);
			}  
			else {
				addopTerminal.struct = addopTerminal.getTerm().struct;
			}
		} else {
			addopTerminal.struct = addopTerminal.getTerm().struct;
		}
	}
	
	public void visit(ExprWithMinus exprWithMinus) {
		if (exprWithMinus.getMinusTerm().struct != SymbolTable.intType) {
			report_error("Operand za unarni '-' mora biti tipa 'int'", exprWithMinus);
			exprWithMinus.struct = SymbolTable.noType;
			return;
		}
		
		
		exprWithMinus.struct = SymbolTable.intType;
	}
	
	public void visit(MinusTerm minusTerm) {
		minusTerm.struct = minusTerm.getTerm().struct;
	}
	
	public void visit(StatementRead statementRead) {
		Obj designatorObj = statementRead.getDesignator().obj;
		
		if (designatorObj.getKind() != Obj.Var && designatorObj.getKind() != Obj.Elem && designatorObj.getKind() != Obj.Fld) {
			report_error("'" + designatorObj.getName() + "' mora biti promenljiva, element niza ili polje unutar objekta", statementRead);
			return;
		}
		
		if (designatorObj.getType() != SymbolTable.intType && designatorObj.getType() != SymbolTable.charType && designatorObj.getType() != SymbolTable.boolType) {
			report_error("'" + designatorObj.getName() + "' mora biti tipa 'int', 'char' ili 'bool'", statementRead);
			return;
		}
		
		report_info("Poziv 'read()'", statementRead);
	}
	
	public void visit(StatementPrintWithOneParam statementPrintWithOneParam) {
		Struct exprStruct = statementPrintWithOneParam.getExpr().struct;
		
		if (exprStruct != SymbolTable.intType && exprStruct != SymbolTable.charType && exprStruct != SymbolTable.boolType) {
			report_error("print() parametar mora biti tipa 'int', 'char' ili 'bool'", statementPrintWithOneParam);
			return;
		}
		
		report_info("Poziv 'print()'", statementPrintWithOneParam);
	}
	
	public void visit(StatementPrintWithTwoParams statementPrintWithTwoParams) {
		Struct exprStruct = statementPrintWithTwoParams.getExpr().struct;
		
		if (exprStruct != SymbolTable.intType && exprStruct != SymbolTable.charType && exprStruct != SymbolTable.boolType) {
			report_error("print() parametar mora biti tipa 'int', 'char' ili 'bool'", statementPrintWithTwoParams);
			return;
		}
		
		report_info("Poziv 'print()' ciji je drugi parametar: " + statementPrintWithTwoParams.getIntValue(), statementPrintWithTwoParams);
	}


	public void visit(FunctionCallName functionCallName) {
		functionCallCounter++;
		expressions.add(new ArrayList<>());
		actualParamsCount.add(0);
		functionCallName.obj = functionCallName.getDesignator().obj;
	}
	
	public void visit(DesignatorStatementFunctionCallNoParams designatorStatementFunctionCallNoParams) {
		functionCallCounter--;
		expressions.get(functionCallCounter).clear();
		actualParamsCount.remove(functionCallCounter);
		Obj functionObj = designatorStatementFunctionCallNoParams.getFunctionCallName().obj;
		
		if (functionObj.getKind() != Obj.Meth) {
			if (functionObj.getName().equals("noObj")) 
				return;
			report_error("'" + functionObj.getName() + "' nije ime funkcije", designatorStatementFunctionCallNoParams);
			return;
		}
		
		if (functionObj.getLevel() > 0) {
			report_error("'" + functionObj.getName() + "()' zahteva " + functionObj.getLevel() + " parametara", designatorStatementFunctionCallNoParams);
			return;
		}
		
		if (functionCallCounter == 0) {
			expressions.clear();
		}

		report_info("Poziv '" + functionObj.getName() + "()'" , designatorStatementFunctionCallNoParams);
	}
	
	public void visit(DesignatorStatementFunctionCallWithParams designatorStatementFunctionCallWithParams) {
		functionCallCounter--;
		
		Obj functionObj = designatorStatementFunctionCallWithParams.getFunctionCallName().obj;
		currentFunctionWithParamsBeingCalled = functionObj;
		
		if (functionObj.getKind() != Obj.Meth) {
			if (functionObj.getName().equals("noObj")) 
				return;
			report_error("'" + functionObj.getName() + "' nije ime funkcije", designatorStatementFunctionCallWithParams);
			return;
		}
		
		if (functionObj.getLevel() != actualParamsCount.get(functionCallCounter)) {
			report_error("'" + functionObj.getName() + "()' zahteva " + functionObj.getLevel() + " parametara", designatorStatementFunctionCallWithParams);
			designators.clear();
			currentFunctionWithParamsBeingCalled = null;
			actualParamsCount.remove(functionCallCounter);
			return;
		}
		
		Collection<Obj> functionLocals = functionObj.getLocalSymbols();
		
		
		boolean errorDetected = false;
		
		List<Struct> paramsStructs = new ArrayList<>();
		paramsStructs.add(null);
		if (expressions.get(functionCallCounter).size() > 1) {
			int k = 0;
			while(k < expressions.get(functionCallCounter).size() - 1) {
				paramsStructs.add(expressions.get(functionCallCounter).get(k));
				k++;
			}
			paramsStructs.set(0, expressions.get(functionCallCounter).get(k));
		} else {
			paramsStructs.set(0, expressions.get(functionCallCounter).get(0));
		}
		
//		for (Struct s: paramsStructs) {
//			System.out.println(mstv.printType(s));
//		}
		
		int i = 0;
		int j = 1;
		
//		System.out.println(paramsStructs.size());
		
		if (functionObj.getName().equals("len") && paramsStructs.get(0).getKind() == Struct.Array) {
//			paramsStructs.get(0).setElementType(SymbolTable.noType);
		} 
		
		for (Obj exprectedParam: functionLocals) {
			if (functionObj.getName().equals("len") && paramsStructs.get(0).getKind() == Struct.Array) {
				continue;
			}
			else if (!exprectedParam.getType().compatibleWith(paramsStructs.get(i))) {
				report_error(j + ". parametar nije odgovarajuceg tipa -> unet: '" + mstv.printType(paramsStructs.get(i)) + "', ocekuje se: '" + mstv.printType(exprectedParam.getType()) + "'", designatorStatementFunctionCallWithParams);
				errorDetected = true;
			}
			
			j++;
			i++;
			if (j > functionObj.getLevel()) {
				break;
			}
		}
		
//		designators.clear();
//
//		currentFunctionWithParamsBeingCalled = null;
//		actualParamsCount = 0;
		
		expressions.get(functionCallCounter).clear();
		if (functionCallCounter == 0) {
			expressions.clear();
		}
		
		
		actualParamsCount.remove(functionCallCounter);
		
		if (!errorDetected)
			report_info("Poziv '" + functionObj.getName() + "()'" , designatorStatementFunctionCallWithParams);
	}
	
	public void visit(ActualParams actualParams) {
		
		actualParamsCount.set(functionCallCounter - 1, actualParamsCount.get(functionCallCounter - 1 ) + 1);
		expressions.get(functionCallCounter - 1).add(actualParams.getExpr().struct);
	}
	
	public void visit(ActualParamsMultiple actualParamsMultiple) {
		actualParamsCount.set(functionCallCounter - 1, actualParamsCount.get(functionCallCounter - 1 ) + 1);
		expressions.get(functionCallCounter - 1).add(actualParamsMultiple.getExpr().struct);
	}
	
	public void visit(ConditionFact conditionFact) {
		conditionFact.struct = conditionFact.getExpr().struct;
	}
	
	public void visit(RelopEqualLogic relopEqualLogic) {
		relopEqualLogic.obj = new Obj(Obj.NO_VALUE, relopEqualLogic.getOperation(), SymbolTable.nullType);
	}
	
	public void visit(RelopNotEqual relopNotEqual) {
		relopNotEqual.obj = new Obj(Obj.NO_VALUE, relopNotEqual.getOperation(), SymbolTable.nullType);
	}
	
	public void visit(RelopGreaterThan relopGreaterThan) {
		relopGreaterThan.obj = new Obj(Obj.NO_VALUE, relopGreaterThan.getOperation(), SymbolTable.nullType);
	}
	
	public void visit(RelopGreaterOrEqual relopGreaterOrEqual) {
		relopGreaterOrEqual.obj = new Obj(Obj.NO_VALUE, relopGreaterOrEqual.getOperation(), SymbolTable.nullType);
	}
	
	public void visit(RelopLessThan relopLessThan) {
		relopLessThan.obj = new Obj(Obj.NO_VALUE, relopLessThan.getOperation(), SymbolTable.nullType);
	}
	
	public void visit(RelopLessOrEqual relopLessOrEqual) {
		relopLessOrEqual.obj = new Obj(Obj.NO_VALUE, relopLessOrEqual.getOperation(), SymbolTable.nullType);
	}

	public void visit(ConditionFactRelopExpr conditionFactRelopExpr) {
		Struct exprLeftStruct = conditionFactRelopExpr.getExpr().struct;
		Struct exprRightStruct = conditionFactRelopExpr.getExpr1().struct;
		String operation = conditionFactRelopExpr.getRelop().obj.getName();
		
		if (!exprLeftStruct.compatibleWith(exprRightStruct)) {
			report_error("Tipovi izraza sa obe strane '" + operation + "' nisu kompatibilni -> '" + mstv.printType(exprLeftStruct) + "' != '" + mstv.printType(exprRightStruct) + "'", conditionFactRelopExpr);
			conditionFactRelopExpr.struct = new Struct(Struct.None);
			return;
		}
		
		if (exprLeftStruct.getKind() == Struct.Array) {
			if (!operation.equals("!=") && !operation.equals("==")) {
				report_error("Nije moguce koristit '" + operation + "' uz nizove. Mogu se koristiti samo '!=' i '=='" , conditionFactRelopExpr);
				conditionFactRelopExpr.struct = new Struct(Struct.None);
				return;
			}
		}
		
		if (exprLeftStruct.getKind() == Struct.Class) {
			if (!operation.equals("!=") && !operation.equals("==")) {
				report_error("Nije moguce koristit '" + operation + "' uz klase. Mogu se koristiti samo '!=' i '=='" , conditionFactRelopExpr);
				conditionFactRelopExpr.struct = new Struct(Struct.None);
				return;
			}
		}
		
		conditionFactRelopExpr.struct = new Struct(Struct.Bool);
		report_info("Upotreba relazionog operatora: '" + mstv.printType(exprLeftStruct) + "' '" + operation + "' '" + mstv.printType(exprRightStruct) + "'", conditionFactRelopExpr);
	}
	
	public void visit(ConditionFactMultiple conditionFactMultiple) {
		if (conditionFactMultiple.getCondFact().struct.getKind() == Struct.None) {
			conditionFactMultiple.struct = new Struct(Struct.None);
			return;
		}
		
		conditionFactMultiple.struct = conditionFactMultiple.getCondFact().struct;
	}
	
	public void visit(ConditionTerm conditionTerm) {
		if (conditionTerm.getCondFactMultiple().struct == null) {
			conditionTerm.struct = conditionTerm.getCondFact().struct;
			return;
		}
		
		if (conditionTerm.getCondFactMultiple().struct.getKind() != Struct.Bool) {
			conditionTerm.struct = new Struct(Struct.None);
			return;
		}
		
		conditionTerm.struct = conditionTerm.getCondFact().struct;
	}
	
	public void visit(Condition condition) {
		if (condition.getCondTerm().struct.getKind() == Struct.None) {
			condition.struct = new Struct(Struct.None);
			return;
		}
		
		condition.struct = condition.getCondTerm().struct;
	}
	
	public void visit(ConditionTermMultiple conditionTermMultiple) {
		if (conditionTermMultiple.getCondTermMultiple().struct == null) {
			conditionTermMultiple.struct = conditionTermMultiple.getCondTermMultiple().struct;
			return;
		}
		
		if (conditionTermMultiple.getCondTermMultiple().struct.getKind() != Struct.Bool) {
			conditionTermMultiple.struct = new Struct(Struct.None);
			return;
		}
		
		conditionTermMultiple.struct = conditionTermMultiple.getCondTermMultiple().struct;
	}

	public void visit(WhileKeyWord whileKeyWord) {
		whileCounter++;
	}
	
	public void visit(StatementWhile statementWhile) {
		whileCounter--;
		
		if (statementWhile.getCondition().struct.getKind() != Struct.Bool) {
			report_error("Uslovni izraz nije tipa 'bool' -> '" + mstv.printType(statementWhile.getCondition().struct) + "' != 'bool'", statementWhile);
			return;
		}
		
		report_info("Upotreba 'while' petlje", statementWhile);
	}
	
	public void visit(StatementForEach statementForEach) {
		foreachCounter--;
		
		Obj designatorObj = statementForEach.getDesigDot().obj;
		
		if (designatorObj.getType().getKind() != Struct.Array) {
			report_error("'" + designatorObj.getName() + "' nije niz", statementForEach);
			return;
		}
		
		Obj ident = SymbolTable.find(statementForEach.getForEachCurrName().getName());

		
		if (designatorObj.getType().getElemType().getKind() != ident.getType().getKind()) {
			report_error("Tip elementa niza '" + designatorObj.getName() + "': '" + mstv.printType(designatorObj.getType().getElemType()) + "' != tip od '" + ident.getName() + "': '" + mstv.printType(ident.getType()), statementForEach);
			return;
		}
		
		report_info("Upotreba 'foreach' petlje", statementForEach);
	}
	
	public void visit(DesignatorDot designatorDot) {
		designatorDot.obj = designatorDot.getDesignator().obj;
	}
	
	
	public void visit(BreakKeyWord breakKeyWord) {
		if (whileCounter == 0 && foreachCounter == 0) {
			report_error("'break' moze da se koristi samo unutar 'while' ili 'foreach' petlje" , breakKeyWord);
			return;
		}
	}
	
	public void visit(ContinueKeyWord continueKeyWord) {
		if (whileCounter == 0 && foreachCounter == 0) {
			report_error("'continue' moze da se koristi samo unutar 'while' ili 'foreach' petlje na liniji ", continueKeyWord);
			return;
		}
	}
	
	public void visit(ReturnKeyWord returnKeyWord) {
		if (currentMethod == null) {
			report_error("'return' moze da se koristi samo unutar tela funkcije/metode", returnKeyWord);
			return;
		}
	}
	
	public void visit(ForeachKeyWord foreachKeyWord) {
		foreachCounter++;
	}
	
	public void visit(StatementReturn statementReturn) {
		if (currentMethod.getType().getKind() != Struct.None) {
			report_error("'" + currentMethod.getName() + "()' kao povratnu vrednost nema 'void' -> '" + mstv.printType(currentMethod.getType()) + "' != 'void'", statementReturn);
		}
	}
	
	public void visit(StatementReturnExpr statementReturnExpr) {
		if (!currentMethod.getType().equals(statementReturnExpr.getExpr().struct)) {
			report_error("'" + currentMethod.getName() + "()' pogresna povratna vrednost -> '" + mstv.printType(currentMethod.getType()) + "' != '" + mstv.printType(statementReturnExpr.getExpr().struct) + "'", statementReturnExpr);
		}
	}
	
	public void visit(ConditionCloseParenthesis conditionCloseParenthesis) {
		conditionCloseParenthesis.struct = conditionCloseParenthesis.getCondition().struct;
	}
	
	public void visit(StatementIf statementIf) {
		if (statementIf.getCondCloseParenthesis().struct.getKind() != Struct.Bool) {
			report_error("Uslovni izraz nije tipa 'bool' -> '" + mstv.printType(statementIf.getCondCloseParenthesis().struct) + "' != 'bool'", statementIf);
		}
	}
	
	public void visit(StatementIfElse statementIfElse) {
		if (statementIfElse.getCondCloseParenthesis().struct.getKind() != Struct.Bool) {
			report_error("Uslovni izraz nije tipa 'bool' -> '" + mstv.printType(statementIfElse.getCondCloseParenthesis().struct) + "' != 'bool'", statementIfElse);
		}
	}
	
	public void visit(FactorFunctionCallWithParams factorFunctionCallWithParams) {
		factorFunctionCallWithParams.struct = factorFunctionCallWithParams.getFunctionCallName().obj.getType();

		functionCallCounter--;
		
		Obj functionObj = factorFunctionCallWithParams.getFunctionCallName().obj;
		currentFunctionWithParamsBeingCalled = functionObj;
		
		if (functionObj.getKind() != Obj.Meth) {
			if (functionObj.getName().equals("noObj")) 
				return;
			report_error("'" + functionObj.getName() + "' nije ime funkcije", factorFunctionCallWithParams);
			return;
		}
		
		if (functionObj.getLevel() != actualParamsCount.get(functionCallCounter)) {
			report_error("'" + functionObj.getName() + "()' zahteva " + functionObj.getLevel() + " parametara", factorFunctionCallWithParams);
			designators.clear();
			currentFunctionWithParamsBeingCalled = null;
			actualParamsCount.remove(functionCallCounter);
			return;
		}
		
		Collection<Obj> functionLocals = functionObj.getLocalSymbols();
		
		
		boolean errorDetected = false;
		
		List<Struct> paramsStructs = new ArrayList<>();
		paramsStructs.add(null);
		if (expressions.get(functionCallCounter).size() > 1) {
			int k = 0;
			while(k < expressions.get(functionCallCounter).size() - 1) {
				paramsStructs.add(expressions.get(functionCallCounter).get(k));
				k++;
			}
			paramsStructs.set(0, expressions.get(functionCallCounter).get(k));
		} else {
			paramsStructs.set(0, expressions.get(functionCallCounter).get(0));
		}
		
//		for (Struct s: paramsStructs) {
//			System.out.println(mstv.printType(s));
//		}
		
		int i = 0;
		int j = 1;
		
//		System.out.println(paramsStructs.size());
		
		if (functionObj.getName().equals("len") && paramsStructs.get(0).getKind() == Struct.Array) {
//			paramsStructs.get(0).setElementType(SymbolTable.noType);
		} 
		
		for (Obj exprectedParam: functionLocals) {
			if (functionObj.getName().equals("len") && paramsStructs.get(0).getKind() == Struct.Array) {
				continue;
			}
			if (!exprectedParam.getType().compatibleWith(paramsStructs.get(i))) {
				report_error(j + ". parametar nije odgovarajuceg tipa -> unet: '" + mstv.printType(paramsStructs.get(i)) + "', ocekuje se: '" + mstv.printType(exprectedParam.getType()) + "'", factorFunctionCallWithParams);
				errorDetected = true;
			}
			
			j++;
			i++;
			if (j > functionObj.getLevel()) {
				break;
			}
		}
		
//		designators.clear();
//
//		currentFunctionWithParamsBeingCalled = null;
//		actualParamsCount = 0;
		
		expressions.get(functionCallCounter).clear();
		if (functionCallCounter == 0) {
			expressions.clear();
		}
		
		
		actualParamsCount.remove(functionCallCounter);
		
		if (!errorDetected)
			report_info("Poziv '" + functionObj.getName() + "()'" , factorFunctionCallWithParams);
	
		
	}
	
	public void visit(FactorFunctionCallNoParams factorFunctionCallNoParams) {
		factorFunctionCallNoParams.struct = factorFunctionCallNoParams.getFunctionCallName().obj.getType();
		functionCallCounter--;
		expressions.get(functionCallCounter).clear();
		actualParamsCount.remove(functionCallCounter);
		Obj functionObj = factorFunctionCallNoParams.getFunctionCallName().obj;
		
		if (functionObj.getKind() != Obj.Meth) {
			if (functionObj.getName().equals("noObj")) 
				return;
			report_error("'" + functionObj.getName() + "' nije ime funkcije", factorFunctionCallNoParams);
			return;
		}
		
		if (functionObj.getLevel() > 0) {
			report_error("'" + functionObj.getName() + "()' zahteva " + functionObj.getLevel() + " parametara", factorFunctionCallNoParams);
			return;
		}
		
		if (functionCallCounter == 0) {
			expressions.clear();
		}

		report_info("Poziv '" + functionObj.getName() + "()'" , factorFunctionCallNoParams);
	
	}
}
