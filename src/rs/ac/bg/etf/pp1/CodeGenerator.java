package rs.ac.bg.etf.pp1;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import java_cup.runtime.Symbol;
import rs.ac.bg.etf.pp1.CounterVisitor.FormParamsCounter;
import rs.ac.bg.etf.pp1.CounterVisitor.VarDeclCounter;
import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.mj.runtime.Code;
import rs.etf.pp1.symboltable.concepts.*;

public class CodeGenerator extends VisitorAdaptor{
	private int mainPc;
	
	private boolean newArray = false;
	private int commaCounter = 0;
	private List<Integer> indices = new ArrayList<>();
	private List<Integer> designatorAdresses = new ArrayList<>();
	private List<Obj> designatorObjs = new ArrayList<>();
	
	private boolean returnedVoid = false;
	private boolean returnedType = false;
	
	public int getMainPc(){
		return mainPc;
	}
	
	public void visit(StatementPrintWithOneParam statementPrintWithOneParam) {
		if (statementPrintWithOneParam.getExpr().struct.getKind() == Struct.Int) {
			Code.loadConst(1);
			Code.put(Code.print);
		} else if (statementPrintWithOneParam.getExpr().struct.getKind() == Struct.Char) {
			Code.loadConst(1);
			Code.put(Code.bprint);
		} else if (statementPrintWithOneParam.getExpr().struct.getKind() == Struct.Bool) { 
			Code.loadConst(1);
			Code.put(Code.print);
		}
	}
	
	public void visit(StatementPrintWithTwoParams statementPrintWithTwoParams) {
		int width = statementPrintWithTwoParams.getIntValue();
		if (statementPrintWithTwoParams.getExpr().struct.getKind() == Struct.Int) {
			Code.loadConst(width);
			Code.put(Code.print);
		} else if (statementPrintWithTwoParams.getExpr().struct.getKind() == Struct.Char) {
			Code.loadConst(width);
			Code.put(Code.bprint);
		} else if (statementPrintWithTwoParams.getExpr().struct.getKind() == Struct.Bool) { 
			Code.loadConst(width);
			Code.put(Code.print);
		}
	}
	
	public void visit(StatementRead statementRead) {
		if (statementRead.getDesignator().obj.getType().getKind() == Struct.Int) {
			Code.put(Code.read);
			Code.store(statementRead.getDesignator().obj);
		} else if (statementRead.getDesignator().obj.getType().getKind() == Struct.Char) {
			Code.put(Code.bread);
			Code.store(statementRead.getDesignator().obj);
		}
	}
	
	public void visit(FactorIntLiteral factorIntLiteral) {
		Obj con = SymbolTable.insert(Obj.Con, "$", factorIntLiteral.struct);
		con.setLevel(0);
		con.setAdr(factorIntLiteral.getI1());
		
		Code.load(con);
	}
	
	public void visit(FactorCharLiteral factorCharLiteral) {
		Obj con = SymbolTable.insert(Obj.Con, "$", factorCharLiteral.struct);
		con.setLevel(0);
		con.setAdr(factorCharLiteral.getC1());
		
		Code.load(con);
	}
	
	public void visit(FactorBoolLiteral factorBoolLiteral) {
		Obj con = SymbolTable.insert(Obj.Con, "$", factorBoolLiteral.struct);
		con.setLevel(0);
		boolean boolVal = factorBoolLiteral.getB1();
		if (boolVal) {
			con.setAdr(1);
		} else {
			con.setAdr(0);
		}
		
		
		Code.load(con);
	}
	
	public void visit(MethodNameVoid methodNameVoid) {
		returnedVoid = false;
		
		if (methodNameVoid.getMethodName().equals("main")) {
			mainPc = Code.pc;
		}
		methodNameVoid.obj.setAdr(Code.pc);
		
		currentMethodDecl = methodNameVoid.obj;
		
		SyntaxNode parent = methodNameVoid.getParent();
		
		FormParamsCounter formParamsCounter = new FormParamsCounter();
		parent.traverseTopDown(formParamsCounter);
		
		VarDeclCounter varDeclCounter = new VarDeclCounter();
		parent.traverseTopDown(varDeclCounter);
		
		Code.put(Code.enter);
		Code.put(formParamsCounter.getCount());
		Code.put(formParamsCounter.getCount() + varDeclCounter.getCount());
		
		currentMethodDecl.setFpPos(varDeclCounter.getCount());
	}
	
	public void visit(MethodNameType methodNameType) {
		returnedType = false;
		
		methodNameType.obj.setAdr(Code.pc);
		
		currentMethodDecl = methodNameType.obj;
		
		SyntaxNode parent = methodNameType.getParent();
		
		FormParamsCounter formParamsCounter = new FormParamsCounter();
		parent.traverseTopDown(formParamsCounter);
		
		VarDeclCounter varDeclCounter = new VarDeclCounter();
		parent.traverseTopDown(varDeclCounter);
		
		Code.put(Code.enter);
		Code.put(formParamsCounter.getCount());
		Code.put(formParamsCounter.getCount() + varDeclCounter.getCount());
		
		currentMethodDecl.setFpPos(varDeclCounter.getCount());
	}
	
	
	public void visit(StatementReturn statementReturn) {
		Code.put(Code.exit);
		Code.put(Code.return_);
		returnedVoid = true;
	}
	
	public void visit(MethodDeclarationVoid methodDeclarationVoid) {
		if (!returnedVoid) {
			Code.put(Code.exit);
			Code.put(Code.return_);
		}
		
		currentMethodDecl = null;
	}
	
	public void visit(StatementReturnExpr statementReturnExpr) {
		Code.put(Code.exit);
		Code.put(Code.return_);
		returnedType = true;
	}
	
	private void trapMessage(String message) {
		for(int i = 0; i < message.length(); i++) {
			Code.loadConst(message.charAt(i));
			Code.loadConst(1);
			Code.put(Code.bprint);
		}
	}
	
	public void visit(MethodDeclarationType methodDeclarationType) {
		if (!returnedType) {
			
			trapMessage("Missing return statement in " + methodDeclarationType.getMethodNameType().getMethodName());
			Code.put(Code.trap);
		}
		
		currentMethodDecl = null;
	}
	
	private Obj currentMethodDecl = null;
	
	
	public void visit(DesignatorStatementAssign designatorStatementAssign) {
		if (newArray) {
			Code.put(Code.newarray);
			if (designatorStatementAssign.getDesignator().obj.getType().getElemType().getKind() != Struct.Char) {
				Code.put(1);
			} else {
				Code.put(0);
			}
			
			Code.store(designatorStatementAssign.getDesignator().obj);
			newArray = false;
		} else {
			Code.store(designatorStatementAssign.getDesignator().obj);
		}
	}
	
	private int type;
	private Struct struct;
	
	public void visit(Designator designator) {
		SyntaxNode parent = designator.getParent();
		
		if (DesignatorStatementIncrement.class == parent.getClass() || DesignatorStatementDecrement.class == parent.getClass()) {
			return;
		}
		
		if (StatementRead.class == parent.getClass()) {
			return;
		}
		
		if (DesignatorStatementDesignatorFirstInBrackets.class == parent.getClass()) {
			return;
		}
		
		if (DesignatorStatementCommaFirstInBrackets.class == parent.getClass()) {
			return;
		}
		
		if (DesignatorListCommaAndDesignator.class == parent.getClass()) {
			return;
		}
		
		if (FunctionCallName.class == parent.getClass()) {
			return;
		}
		
		if (DesignatorDot.class == parent.getClass()) {
			type = designator.obj.getType().getElemType().getKind();
			struct = designator.obj.getType().getElemType();
			
			loopIndicatorStack.push("foreach");
			fixupAddressesBREAKForEach.push(new ArrayList<>());
			
			forEachArrStack.push(designator.obj);
			
			SymbolTable.insert(Obj.Var, "$index" + forEachArrStack.size(), SymbolTable.intType);
			// Set index explicitly to 0
			Code.loadConst(0);
			Obj indexObj = SymbolTable.find("$index" + forEachArrStack.size());
			
			int fromalParamCount = currentMethodDecl.getLevel();
			int localVarsCount = currentMethodDecl.getFpPos();
			
			indexObj.setAdr(127);
			Code.store(indexObj);
			forEachIndex.push(indexObj);
			
			fixupAddressFOREACH.push(new ArrayList<>());
			
			// Save for each start address
			forEachStartAddress.push(Code.pc);
			
			// Put current array index on stack
			Code.load(forEachIndex.peek());
			
			// Load arr address
			Code.load(forEachArrStack.peek());
			
			// Get array length on stack
			Code.put(Code.arraylength);
			

			
			// If array length >= index skip for each
			Code.putFalseJump(Code.lt, 0);
			fixupAddressFOREACH.peek().add(Code.pc - 2);
			
			return;
		}
		
		if (DesignatorStatementAssign.class != parent.getClass()) {
			
			if (!forEachCurrStack.isEmpty()) {
				if (designator.obj.getName().equals( forEachCurrStack.peek().getName() )) {
					Code.load(forEachArrStack.peek());
					Code.load(forEachIndex.peek());
					Code.load(forEachCurrStack.peek());
				} else {
					Code.load(designator.obj);
				}
			} else {
				Code.load(designator.obj);
			}
			
		}
	}
	
	
	
	public void visit(DesignatorStatementDesignatorFirstInBrackets designatorStatementDesignatorFirstInBrackets) {
		
		indices.add(0, 0);
		designatorAdresses.add(0, designatorStatementDesignatorFirstInBrackets.getDesignator().obj.getAdr());
		designatorObjs.add(0, designatorStatementDesignatorFirstInBrackets.getDesignator().obj);
		
		int arrAdr = designatorStatementDesignatorFirstInBrackets.getDesignator1().obj.getAdr();
		
		for (int i = designatorObjs.size() - 1; i >= 0; i--) {
			if (designatorObjs.get(i) != null) {
				Code.load(designatorStatementDesignatorFirstInBrackets.getDesignator1().obj);
				Obj con = SymbolTable.insert(Obj.Con, "$", SymbolTable.intType);
				con.setLevel(0);
				con.setAdr(i);
				Code.load(con);

				if (designatorStatementDesignatorFirstInBrackets.getDesignator1().obj.getType().getElemType().getKind() == Struct.Char) {
					Code.put(Code.baload);
				} else {
					Code.put(Code.aload);
				}
				
				Code.store(designatorObjs.get(i));
			}
		}
		
		designatorObjs.clear();
		designatorAdresses.clear();
	}
	
	public void visit(DesignatorStatementCommaFirstInBrackets designatorStatementCommaFirstInBrackets) {
		indices.add(0, 0);
		designatorAdresses.add(0, null);
		designatorObjs.add(0, null);
	
		for (int i = designatorObjs.size() - 1; i >= 0; i--) {
			if (designatorObjs.get(i) != null) {
				Code.load(designatorStatementCommaFirstInBrackets.getDesignator().obj);
				Obj con = SymbolTable.insert(Obj.Con, "$", SymbolTable.intType);
				con.setLevel(0);
				con.setAdr(i);
				Code.load(con);
				
				if (designatorStatementCommaFirstInBrackets.getDesignator().obj.getType().getElemType().getKind() == Struct.Char) {
					Code.put(Code.baload);
				} else {
					Code.put(Code.aload);
				}
				
				Code.store(designatorObjs.get(i));
			}
		}
		
		designatorObjs.clear();
		designatorAdresses.clear();
	}
	
	public void visit(DesignatorListCommaAndDesignator designatorListCommaAndDesignator) {
		commaCounter++;
		indices.add(commaCounter);
		designatorAdresses.add(designatorListCommaAndDesignator.getDesignator().obj.getAdr());
		designatorObjs.add(designatorListCommaAndDesignator.getDesignator().obj);
	}
	
	public void visit(DesignatorListCommaOnly designatorListCommaOnly) {
		commaCounter++;
		indices.add(-1);
		designatorAdresses.add(null);
		designatorObjs.add(null);
	}
	
	public void visit(AddopPlus addopPlus) {
		addopPlus.obj = new Obj(Obj.NO_VALUE, "+", new Struct(Struct.None));
	}
	
	public void visit(AddopMinus addopMinus) {
		addopMinus.obj = new Obj(Obj.NO_VALUE, "-", new Struct(Struct.None));
	}
	
	public void visit(AddopTerminal addopTerminal) {
		String operation = addopTerminal.getAddop().obj.getName();
		if (operation.equals("+")) {
			Code.put(Code.add);
		} else if (operation.equals("-")) {
			Code.put(Code.sub);
		}
	}
	
	public void visit(MuloptMultiply muloptMultiply) {
		muloptMultiply.obj = new Obj(Obj.NO_VALUE, "*", new Struct(Struct.None));
	}
	
	public void visit(MulopDivide mulopDivide) {
		mulopDivide.obj = new Obj(Obj.NO_VALUE, "/", new Struct(Struct.None));
	}
	
	public void visit(MulopMod mulopMod) {
		mulopMod.obj = new Obj(Obj.NO_VALUE, "%", new Struct(Struct.None));
	}
	
	public void visit(MulopFactor mulopFactor) {
		String operation = mulopFactor.getMulop().obj.getName();
		if (operation.equals("*")) {
			Code.put(Code.mul);
		} else if (operation.equals("/")) {
			Code.put(Code.div);
		} else if (operation.equals("%")) {
			Code.put(Code.rem);
		}
	}
	
	public void visit(ExprWithMinus exprWithMinus) {
//		Code.put(Code.neg);
	}
	
	public void visit(MinusTerm minusTerm) {
		Code.put(Code.neg);
	}
	
	public void visit(DesignatorStatementDecrement designatorStatementDecrement) {
		Obj designatorObj = designatorStatementDecrement.getDesignator().obj;
		
		
		Obj con = SymbolTable.insert(Obj.Con, "$", SymbolTable.intType);
		con.setLevel(0);
		con.setAdr(-1);
		
		if (designatorObj.getKind() == Obj.Elem) {
			Code.put(Code.dup2);
		}
		
		Code.load(designatorObj);
		Code.load(con);
		Code.put(Code.add);
		Code.store(designatorObj);
	}
	
	public void visit(DesignatorStatementIncrement designatorStatementIncrement) {
		Obj designatorObj = designatorStatementIncrement.getDesignator().obj;
		
		
		Obj con = SymbolTable.insert(Obj.Con, "$", SymbolTable.intType);
		con.setLevel(0);
		con.setAdr(1);
		
		if (designatorObj.getKind() == Obj.Elem) {
			Code.put(Code.dup2);
		}
		
		Code.load(designatorObj);
		Code.load(con);
		Code.put(Code.add);
		Code.store(designatorObj);
	}
	
	public void visit(FactorNewTypeExpr factorNewTypeExpr) {
		newArray = true;
	}
	
	public void visit(DesignatorMul designatorMul) {
		Code.load(designatorMul.getDesignatorMultiple().obj);
		Code.put(Code.dup_x1);
		Code.put(Code.pop);
	}
	
	
	
	// B nivo
	public void visit(DesignatorStatementFunctionCallNoParams designatorStatementFunctionCallNoParams) {
		Obj functionObj = designatorStatementFunctionCallNoParams.getFunctionCallName().getDesignator().obj;
		int offset = functionObj.getAdr() - Code.pc;
		Code.put(Code.call);
		Code.put2(offset);
	}
	
	public void visit(FactorFunctionCallNoParams factorFunctionCallNoParams) {
		Obj functionObj = factorFunctionCallNoParams.getFunctionCallName().getDesignator().obj;
		int offset = functionObj.getAdr() - Code.pc;
		Code.put(Code.call);
		Code.put2(offset);
	}
	
	
	public void visit(DesignatorStatementFunctionCallWithParams designatorStatementFunctionCallWithParams) {
		Obj functionObj = designatorStatementFunctionCallWithParams.getFunctionCallName().getDesignator().obj;
		int offset = functionObj.getAdr() - Code.pc;
		if (functionObj.getName().equals("ord") || functionObj.getName().equals("chr")) {
			return;
		} else if (functionObj.getName().equals("len")) {
			Code.put(Code.arraylength);
			return;
		}
		Code.put(Code.call);
		Code.put2(offset);
	}
	
	public void visit(FactorFunctionCallWithParams factorFunctionCallWithParams) {
		Obj functionObj = factorFunctionCallWithParams.getFunctionCallName().getDesignator().obj;
		int offset = functionObj.getAdr() - Code.pc;
		if (functionObj.getName().equals("ord") || functionObj.getName().equals("chr")) {
			return;
		} else if (functionObj.getName().equals("len")) {
			Code.put(Code.arraylength);
			return;
		}
		Code.put(Code.call);
		Code.put2(offset);
	}
	
	public void visit(RelopEqualLogic relopEqualLogic) {
		relopEqualLogic.obj = new Obj(Obj.NO_VALUE, "==", new Struct(Struct.None));
	}
	
	public void visit(RelopNotEqual relopNotEqual) {
		relopNotEqual.obj = new Obj(Obj.NO_VALUE, "!=", new Struct(Struct.None));
	}
	
	public void visit(RelopGreaterThan relopGreaterThan) {
		relopGreaterThan.obj = new Obj(Obj.NO_VALUE, ">", new Struct(Struct.None));
	}
	
	public void visit(RelopGreaterOrEqual relopGreaterOrEqual) {
		relopGreaterOrEqual.obj = new Obj(Obj.NO_VALUE, ">=", new Struct(Struct.None));
	}
	
	public void visit(RelopLessThan relopLessThan) {
		relopLessThan.obj = new Obj(Obj.NO_VALUE, "<", new Struct(Struct.None));
	}
	
	public void visit(RelopLessOrEqual relopLessOrEqual) {
		relopLessOrEqual.obj = new Obj(Obj.NO_VALUE, "<=", new Struct(Struct.None));
	}
	
	private Stack<List<Integer>> fixupAddresses = new Stack<>();
	private Stack<List<Integer>> fixupAddressesOR = new Stack<>();
	private Stack<List<Integer>> fixupAddressesTHEN = new Stack<>();
	private Stack<List<Integer>> fixupAddressesBREAK = new Stack<>();
	private Stack<String> loopIndicatorStack = new Stack<>();
	
	public void visit(IfKeyWord ifKeyWord) {
		fixupAddresses.push(new ArrayList<>());
		fixupAddressesOR.push(new ArrayList<>());
		fixupAddressesTHEN.push(new ArrayList<>());
	}
	
	public void visit(ConditionFactRelopExpr conditionFactRelopExpr) {
		String operation = conditionFactRelopExpr.getRelop().obj.getName();
		if (operation.equals("==")) {
			Code.putFalseJump(Code.eq, 0);
		} else if (operation.equals("!=")) {
			Code.putFalseJump(Code.ne, 0);
		} else if (operation.equals(">")) {
			Code.putFalseJump(Code.gt, 0);
		} else if (operation.equals(">=")) {
			Code.putFalseJump(Code.ge, 0);
		} else if (operation.equals("<")) {
			Code.putFalseJump(Code.lt, 0);
		} else if (operation.equals("<=")) {
			Code.putFalseJump(Code.le, 0);
		}
		
		fixupAddresses.peek().add(Code.pc - 2);
	}
	
	public void visit(ConditionFact conditionFact) {
		Code.loadConst(1);
		Code.putFalseJump(Code.eq, 0);
		fixupAddresses.peek().add(Code.pc - 2);
	}
	
	public void visit(IfThenEnd ifThenEnd) {
		if(ifThenEnd.getParent().getClass() == StatementIfElse.class) {
			// If-then executed, skip else
			Code.putJump(0); 		
			fixupAddressesTHEN.peek().add(Code.pc - 2);
		}
		
		// Jump to the end of if-then
		for (int fixupAddress: fixupAddresses.peek()) {
			Code.fixup(fixupAddress);
		}

		fixupAddresses.peek().clear();
	}
	
	public void visit(ConditionOrEnd conditionOrEnd) {
		Code.putJump(0);
		fixupAddressesOR.peek().add(Code.pc - 2);
		
		// Jump to the next condition in OR if any condition in AND is false
		for (int fixupAddress: fixupAddresses.peek()) {
			Code.fixup(fixupAddress);
		}
		
		fixupAddresses.peek().clear();
	}
	
	public void visit(StatementIf statementIf) {
		fixupAddresses.pop();
		fixupAddressesOR.pop();
		fixupAddressesTHEN.pop();
	}
	
	public void visit(StatementIfElse statementIfElse) {
		fixupAddresses.pop();
		fixupAddressesOR.pop();
		
		// If-then executed, jump to the fisrt instruction after else
		for(int fixupAddress: fixupAddressesTHEN.pop()) {
			Code.fixup(fixupAddress);
		}
	}
	
	public void visit(CondEnd condEnd) {
		// First condition that is true in OR will jump here
		for(int fixupAdress: fixupAddressesOR.peek()) {
			Code.fixup(fixupAdress);
		}
		
		fixupAddressesOR.peek().clear();
	}
	
	private Stack<Integer> whileStartAddress = new Stack<>();
	
	public void visit(WhileCondStart whileCondStart) {
		fixupAddresses.push(new ArrayList<>());
		fixupAddressesOR.push(new ArrayList<>());
		fixupAddressesBREAK.push(new ArrayList<>());
		loopIndicatorStack.push("while");
		
		whileStartAddress.push(Code.pc);
	}
	
	public void visit(WhileEnd whileEnd) {
		// Jump to the begining of while to check condition
		Code.put(Code.jmp);
		Code.put2(whileStartAddress.peek() - Code.pc + 1);
		
		// If there is break, jump out of while
		for (int fixupAddress: fixupAddressesBREAK.peek()) {
			Code.fixup(fixupAddress);
		}
		
		for (int fixupAddress: fixupAddresses.peek()) {
			Code.fixup(fixupAddress);
		}
		
//		fixupAddresses.peek().clear();
		fixupAddresses.pop();
		
		whileStartAddress.pop();
		fixupAddressesBREAK.pop();
		loopIndicatorStack.pop();
	}
	
	public void visit(WhileCondEnd whileCondEnd) {
		// First condition that is true in OR will jump here
		for(int fixupAddress: fixupAddressesOR.peek()) {
			Code.fixup(fixupAddress);
		}
		
		fixupAddressesOR.peek().clear();
	}
	
	public void visit(ContinueKeyWord continueKeyWord) {
		if (loopIndicatorStack.peek().equals("foreach")) {
			// Increment current index
			Code.load(forEachIndex.peek());
			Code.loadConst(1);
			Code.put(Code.add);
			Code.store(forEachIndex.peek());
			
			// Unconditionally jump to the beggining of for each
			Code.put(Code.jmp);
			Code.put2(forEachStartAddress.peek() - Code.pc + 1);
		} else if (loopIndicatorStack.peek().equals("while")) {
			// Jump to the begining of while to check condition
			Code.put(Code.jmp);
			Code.put2(whileStartAddress.peek() - Code.pc + 1);
		}
	}
	
	public void visit(BreakKeyWord breakKeyWord) {
		if (loopIndicatorStack.peek().equals("foreach")) {
			Code.putJump(0);
			fixupAddressesBREAKForEach.peek().add(Code.pc - 2);
		} else if (loopIndicatorStack.peek().equals("while")) {
			Code.putJump(0);
			fixupAddressesBREAK.peek().add(Code.pc - 2);
		}
	}

	private Stack<Obj> forEachArrStack = new Stack<>();
	private Stack<Obj> forEachCurrStack = new Stack<>();
	private Stack<Obj> forEachIndex = new Stack<>();
	private Stack<Integer> forEachStartAddress = new Stack<>();
	private Stack<List<Integer>> fixupAddressFOREACH = new Stack<>();
	private Stack<List<Integer>> fixupAddressesBREAKForEach = new Stack<>();
	
	public void visit(ForEachEnd forEachEnd) {
		// Increment current index
		Code.load(forEachIndex.peek());
		Code.loadConst(1);
		Code.put(Code.add);
		Code.store(forEachIndex.peek());
		
		// Unconditionally jump to the beggining of for each
		Code.put(Code.jmp);
		Code.put2(forEachStartAddress.peek() - Code.pc + 1);
		
		for (int fixupAddress: fixupAddressFOREACH.peek()) {
			Code.fixup(fixupAddress);
		}
		
		for (int fixupAddress: fixupAddressesBREAKForEach.peek()) {
			Code.fixup(fixupAddress);
		}
		
		forEachArrStack.pop();
		forEachCurrStack.pop();
		forEachStartAddress.pop();
		fixupAddressFOREACH.pop();
		forEachIndex.pop();
		loopIndicatorStack.pop();
		fixupAddressesBREAKForEach.pop();
	}
	
	public void visit(ForEachCurrName forEachCurrName) {
		Obj ident = SymbolTable.insert(Obj.Elem, forEachCurrName.getName(), struct);

		forEachCurrStack.push(ident);
	}
}
