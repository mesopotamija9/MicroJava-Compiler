// generated with ast extension for cup
// version 0.8
// 15/0/2023 21:44:9


package rs.ac.bg.etf.pp1.ast;

public interface Visitor { 

    public void visit(FormPars FormPars);
    public void visit(StatementL StatementL);
    public void visit(Factor Factor);
    public void visit(Statement Statement);
    public void visit(DesignatorStmAssign DesignatorStmAssign);
    public void visit(ClassVarDeclMultip ClassVarDeclMultip);
    public void visit(MethodDecl MethodDecl);
    public void visit(ClassTypeExtend ClassTypeExtend);
    public void visit(VarName VarName);
    public void visit(ParTypeName ParTypeName);
    public void visit(ConstDeclL ConstDeclL);
    public void visit(Relop Relop);
    public void visit(Expr Expr);
    public void visit(MethodDeclL MethodDeclL);
    public void visit(DesignatorL DesignatorL);
    public void visit(VarDecl VarDecl);
    public void visit(CondFactMultiple CondFactMultiple);
    public void visit(VarDeclL VarDeclL);
    public void visit(AddopTerm AddopTerm);
    public void visit(ConstructAndMethods ConstructAndMethods);
    public void visit(ActParsMultiple ActParsMultiple);
    public void visit(VarDeclMultip VarDeclMultip);
    public void visit(Mulop Mulop);
    public void visit(DesignatorStatement DesignatorStatement);
    public void visit(ConstructorDeclL ConstructorDeclL);
    public void visit(ClassVarName ClassVarName);
    public void visit(VarArrayName VarArrayName);
    public void visit(Addop Addop);
    public void visit(Assignop Assignop);
    public void visit(ConstDecl ConstDecl);
    public void visit(DesignatorMultiple DesignatorMultiple);
    public void visit(CondCloseParenthesis CondCloseParenthesis);
    public void visit(MulopFact MulopFact);
    public void visit(CondOrEnd CondOrEnd);
    public void visit(CondTerm CondTerm);
    public void visit(FormParsMultiple FormParsMultiple);
    public void visit(ClassVarDecl ClassVarDecl);
    public void visit(ClassDecl ClassDecl);
    public void visit(FormParsInMethodCloseParenthesis FormParsInMethodCloseParenthesis);
    public void visit(DeclL DeclL);
    public void visit(DesigDot DesigDot);
    public void visit(ConstructorDecl ConstructorDecl);
    public void visit(DeclE DeclE);
    public void visit(LiteralE LiteralE);
    public void visit(ActPars ActPars);
    public void visit(CondFact CondFact);
    public void visit(ClassVarDeclL ClassVarDeclL);
    public void visit(CondTermMultiple CondTermMultiple);
    public void visit(MulopMod MulopMod);
    public void visit(MulopDivide MulopDivide);
    public void visit(MuloptMultiply MuloptMultiply);
    public void visit(AddopMinus AddopMinus);
    public void visit(AddopPlus AddopPlus);
    public void visit(RelopLessOrEqual RelopLessOrEqual);
    public void visit(RelopLessThan RelopLessThan);
    public void visit(RelopGreaterOrEqual RelopGreaterOrEqual);
    public void visit(RelopGreaterThan RelopGreaterThan);
    public void visit(RelopNotEqual RelopNotEqual);
    public void visit(RelopEqualLogic RelopEqualLogic);
    public void visit(AssignOperator AssignOperator);
    public void visit(Label Label);
    public void visit(DesignatorDot DesignatorDot);
    public void visit(DesignatorDotIdent DesignatorDotIdent);
    public void visit(DesignatorIdent DesignatorIdent);
    public void visit(DesignatorMul DesignatorMul);
    public void visit(Designator Designator);
    public void visit(FactorFunctionCallWithParams FactorFunctionCallWithParams);
    public void visit(FactorFunctionCallNoParams FactorFunctionCallNoParams);
    public void visit(FactorDesignator FactorDesignator);
    public void visit(FactorNewTypeNoActPars FactorNewTypeNoActPars);
    public void visit(FactorNewTypeActPars FactorNewTypeActPars);
    public void visit(FactorNewTypeExpr FactorNewTypeExpr);
    public void visit(FactorExpr FactorExpr);
    public void visit(FactorBoolLiteral FactorBoolLiteral);
    public void visit(FactorCharLiteral FactorCharLiteral);
    public void visit(FactorIntLiteral FactorIntLiteral);
    public void visit(NoMulopFactor NoMulopFactor);
    public void visit(MulopFactor MulopFactor);
    public void visit(Term Term);
    public void visit(NoAddopTerminal NoAddopTerminal);
    public void visit(AddopTerminal AddopTerminal);
    public void visit(MinusTerm MinusTerm);
    public void visit(ExprWithoutMinus ExprWithoutMinus);
    public void visit(ExprWithMinus ExprWithMinus);
    public void visit(ConditionFactRelopExpr ConditionFactRelopExpr);
    public void visit(ConditionFact ConditionFact);
    public void visit(NoConditionFactMultiple NoConditionFactMultiple);
    public void visit(ConditionFactMultiple ConditionFactMultiple);
    public void visit(ConditionTerm ConditionTerm);
    public void visit(ConditionOrEnd ConditionOrEnd);
    public void visit(NoConditionTermMultiple NoConditionTermMultiple);
    public void visit(ConditionTermMultiple ConditionTermMultiple);
    public void visit(Condition Condition);
    public void visit(NoActualParamsMultiple NoActualParamsMultiple);
    public void visit(ActualParamsMultiple ActualParamsMultiple);
    public void visit(ActualParams ActualParams);
    public void visit(NoDesignatorList NoDesignatorList);
    public void visit(DesignatorListCommaAndDesignator DesignatorListCommaAndDesignator);
    public void visit(DesignatorListCommaOnly DesignatorListCommaOnly);
    public void visit(DesignatorStmAssignDerived1 DesignatorStmAssignDerived1);
    public void visit(DesignatorStatementAssign DesignatorStatementAssign);
    public void visit(FunctionCallName FunctionCallName);
    public void visit(DesignatorStatementFunctionCallWithParams DesignatorStatementFunctionCallWithParams);
    public void visit(DesignatorStatementFunctionCallNoParams DesignatorStatementFunctionCallNoParams);
    public void visit(DesignatorStatementDecrement DesignatorStatementDecrement);
    public void visit(DesignatorStatementIncrement DesignatorStatementIncrement);
    public void visit(DesignatorStatementCommaFirstInBrackets DesignatorStatementCommaFirstInBrackets);
    public void visit(DesignatorStatementDesignatorFirstInBrackets DesignatorStatementDesignatorFirstInBrackets);
    public void visit(DesignatorStmtAssign DesignatorStmtAssign);
    public void visit(CondEnd CondEnd);
    public void visit(CondCloseParenthesisDerived1 CondCloseParenthesisDerived1);
    public void visit(ConditionCloseParenthesis ConditionCloseParenthesis);
    public void visit(ForEachEnd ForEachEnd);
    public void visit(ForEachCurrName ForEachCurrName);
    public void visit(WhileCondEnd WhileCondEnd);
    public void visit(WhileCondStart WhileCondStart);
    public void visit(WhileEnd WhileEnd);
    public void visit(IfThenEnd IfThenEnd);
    public void visit(IfKeyWord IfKeyWord);
    public void visit(ForeachKeyWord ForeachKeyWord);
    public void visit(ReturnKeyWord ReturnKeyWord);
    public void visit(ContinueKeyWord ContinueKeyWord);
    public void visit(BreakKeyWord BreakKeyWord);
    public void visit(WhileKeyWord WhileKeyWord);
    public void visit(StatementInBraces StatementInBraces);
    public void visit(StatementForEach StatementForEach);
    public void visit(StatementReturnExpr StatementReturnExpr);
    public void visit(StatementReturn StatementReturn);
    public void visit(StatementContinue StatementContinue);
    public void visit(StatementBreak StatementBreak);
    public void visit(StatementWhile StatementWhile);
    public void visit(StatementIfElse StatementIfElse);
    public void visit(StatementIf StatementIf);
    public void visit(StatementPrintWithTwoParams StatementPrintWithTwoParams);
    public void visit(StatementPrintWithOneParam StatementPrintWithOneParam);
    public void visit(StatementRead StatementRead);
    public void visit(StatementDesignatorStatement StatementDesignatorStatement);
    public void visit(Type Type);
    public void visit(NoFormParamsMultiple NoFormParamsMultiple);
    public void visit(FormParamsMultiple FormParamsMultiple);
    public void visit(ParTypeNameDerived1 ParTypeNameDerived1);
    public void visit(ParamArrayTypeName ParamArrayTypeName);
    public void visit(ParamTypeName ParamTypeName);
    public void visit(NoFormParams NoFormParams);
    public void visit(FormParams FormParams);
    public void visit(NoStatementList NoStatementList);
    public void visit(StatementList StatementList);
    public void visit(NoMethodDeclList NoMethodDeclList);
    public void visit(MethodDeclList MethodDeclList);
    public void visit(NoVarDeclList NoVarDeclList);
    public void visit(VarDeclList VarDeclList);
    public void visit(MethodNameVoid MethodNameVoid);
    public void visit(MethodNameType MethodNameType);
    public void visit(MethodDeclarationVoid MethodDeclarationVoid);
    public void visit(MethodDeclarationType MethodDeclarationType);
    public void visit(NoConstructorDeclList NoConstructorDeclList);
    public void visit(ConstructorDeclList ConstructorDeclList);
    public void visit(ConstructorDeclaration ConstructorDeclaration);
    public void visit(NoConstructorsAndMethods NoConstructorsAndMethods);
    public void visit(ConstructorsAndMethods ConstructorsAndMethods);
    public void visit(NoClassVarDeclList NoClassVarDeclList);
    public void visit(ClassVarDeclList ClassVarDeclList);
    public void visit(ClassVarArrayNamee ClassVarArrayNamee);
    public void visit(ClassVarNamee ClassVarNamee);
    public void visit(NoClassVarDeclMultiple NoClassVarDeclMultiple);
    public void visit(ClassVarDeclMultiple ClassVarDeclMultiple);
    public void visit(ClassVarDeclDerived2 ClassVarDeclDerived2);
    public void visit(ClassVarDeclDerived1 ClassVarDeclDerived1);
    public void visit(ClassVarDeclaration ClassVarDeclaration);
    public void visit(ClassTypeExtendDerived1 ClassTypeExtendDerived1);
    public void visit(ClassTypeExtends ClassTypeExtends);
    public void visit(ClassDeclarationWithExtends ClassDeclarationWithExtends);
    public void visit(ClassDeclarationNoExtends ClassDeclarationNoExtends);
    public void visit(VarNameDerived1 VarNameDerived1);
    public void visit(VariableArrayName VariableArrayName);
    public void visit(VariableName VariableName);
    public void visit(NoVarDeclMultiple NoVarDeclMultiple);
    public void visit(VarDeclMultiple VarDeclMultiple);
    public void visit(VarDeclDerived1 VarDeclDerived1);
    public void visit(VarDeclaration VarDeclaration);
    public void visit(ConstName ConstName);
    public void visit(NoConstDeclList NoConstDeclList);
    public void visit(ConstDeclList ConstDeclList);
    public void visit(LiteralElementBool LiteralElementBool);
    public void visit(LiteralElementChar LiteralElementChar);
    public void visit(LiteralElementInt LiteralElementInt);
    public void visit(ConstDeclaration ConstDeclaration);
    public void visit(DeclElementBool DeclElementBool);
    public void visit(DeclElementVar DeclElementVar);
    public void visit(DeclElementConst DeclElementConst);
    public void visit(NoDeclList NoDeclList);
    public void visit(DeclList DeclList);
    public void visit(ProgramName ProgramName);
    public void visit(Program Program);

}
