// generated with ast extension for cup
// version 0.8
// 15/0/2023 21:44:9


package rs.ac.bg.etf.pp1.ast;

public class StatementIfElse extends Statement {

    private IfKeyWord IfKeyWord;
    private CondCloseParenthesis CondCloseParenthesis;
    private Statement Statement;
    private IfThenEnd IfThenEnd;
    private Statement Statement1;

    public StatementIfElse (IfKeyWord IfKeyWord, CondCloseParenthesis CondCloseParenthesis, Statement Statement, IfThenEnd IfThenEnd, Statement Statement1) {
        this.IfKeyWord=IfKeyWord;
        if(IfKeyWord!=null) IfKeyWord.setParent(this);
        this.CondCloseParenthesis=CondCloseParenthesis;
        if(CondCloseParenthesis!=null) CondCloseParenthesis.setParent(this);
        this.Statement=Statement;
        if(Statement!=null) Statement.setParent(this);
        this.IfThenEnd=IfThenEnd;
        if(IfThenEnd!=null) IfThenEnd.setParent(this);
        this.Statement1=Statement1;
        if(Statement1!=null) Statement1.setParent(this);
    }

    public IfKeyWord getIfKeyWord() {
        return IfKeyWord;
    }

    public void setIfKeyWord(IfKeyWord IfKeyWord) {
        this.IfKeyWord=IfKeyWord;
    }

    public CondCloseParenthesis getCondCloseParenthesis() {
        return CondCloseParenthesis;
    }

    public void setCondCloseParenthesis(CondCloseParenthesis CondCloseParenthesis) {
        this.CondCloseParenthesis=CondCloseParenthesis;
    }

    public Statement getStatement() {
        return Statement;
    }

    public void setStatement(Statement Statement) {
        this.Statement=Statement;
    }

    public IfThenEnd getIfThenEnd() {
        return IfThenEnd;
    }

    public void setIfThenEnd(IfThenEnd IfThenEnd) {
        this.IfThenEnd=IfThenEnd;
    }

    public Statement getStatement1() {
        return Statement1;
    }

    public void setStatement1(Statement Statement1) {
        this.Statement1=Statement1;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(IfKeyWord!=null) IfKeyWord.accept(visitor);
        if(CondCloseParenthesis!=null) CondCloseParenthesis.accept(visitor);
        if(Statement!=null) Statement.accept(visitor);
        if(IfThenEnd!=null) IfThenEnd.accept(visitor);
        if(Statement1!=null) Statement1.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(IfKeyWord!=null) IfKeyWord.traverseTopDown(visitor);
        if(CondCloseParenthesis!=null) CondCloseParenthesis.traverseTopDown(visitor);
        if(Statement!=null) Statement.traverseTopDown(visitor);
        if(IfThenEnd!=null) IfThenEnd.traverseTopDown(visitor);
        if(Statement1!=null) Statement1.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(IfKeyWord!=null) IfKeyWord.traverseBottomUp(visitor);
        if(CondCloseParenthesis!=null) CondCloseParenthesis.traverseBottomUp(visitor);
        if(Statement!=null) Statement.traverseBottomUp(visitor);
        if(IfThenEnd!=null) IfThenEnd.traverseBottomUp(visitor);
        if(Statement1!=null) Statement1.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("StatementIfElse(\n");

        if(IfKeyWord!=null)
            buffer.append(IfKeyWord.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(CondCloseParenthesis!=null)
            buffer.append(CondCloseParenthesis.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Statement!=null)
            buffer.append(Statement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(IfThenEnd!=null)
            buffer.append(IfThenEnd.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Statement1!=null)
            buffer.append(Statement1.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [StatementIfElse]");
        return buffer.toString();
    }
}
