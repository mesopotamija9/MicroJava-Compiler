// generated with ast extension for cup
// version 0.8
// 15/0/2023 21:44:9


package rs.ac.bg.etf.pp1.ast;

public class StatementReturnExpr extends Statement {

    private ReturnKeyWord ReturnKeyWord;
    private Expr Expr;

    public StatementReturnExpr (ReturnKeyWord ReturnKeyWord, Expr Expr) {
        this.ReturnKeyWord=ReturnKeyWord;
        if(ReturnKeyWord!=null) ReturnKeyWord.setParent(this);
        this.Expr=Expr;
        if(Expr!=null) Expr.setParent(this);
    }

    public ReturnKeyWord getReturnKeyWord() {
        return ReturnKeyWord;
    }

    public void setReturnKeyWord(ReturnKeyWord ReturnKeyWord) {
        this.ReturnKeyWord=ReturnKeyWord;
    }

    public Expr getExpr() {
        return Expr;
    }

    public void setExpr(Expr Expr) {
        this.Expr=Expr;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ReturnKeyWord!=null) ReturnKeyWord.accept(visitor);
        if(Expr!=null) Expr.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ReturnKeyWord!=null) ReturnKeyWord.traverseTopDown(visitor);
        if(Expr!=null) Expr.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ReturnKeyWord!=null) ReturnKeyWord.traverseBottomUp(visitor);
        if(Expr!=null) Expr.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("StatementReturnExpr(\n");

        if(ReturnKeyWord!=null)
            buffer.append(ReturnKeyWord.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Expr!=null)
            buffer.append(Expr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [StatementReturnExpr]");
        return buffer.toString();
    }
}
