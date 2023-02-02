// generated with ast extension for cup
// version 0.8
// 15/0/2023 21:44:9


package rs.ac.bg.etf.pp1.ast;

public class ActualParamsMultiple extends ActParsMultiple {

    private ActParsMultiple ActParsMultiple;
    private Expr Expr;

    public ActualParamsMultiple (ActParsMultiple ActParsMultiple, Expr Expr) {
        this.ActParsMultiple=ActParsMultiple;
        if(ActParsMultiple!=null) ActParsMultiple.setParent(this);
        this.Expr=Expr;
        if(Expr!=null) Expr.setParent(this);
    }

    public ActParsMultiple getActParsMultiple() {
        return ActParsMultiple;
    }

    public void setActParsMultiple(ActParsMultiple ActParsMultiple) {
        this.ActParsMultiple=ActParsMultiple;
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
        if(ActParsMultiple!=null) ActParsMultiple.accept(visitor);
        if(Expr!=null) Expr.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ActParsMultiple!=null) ActParsMultiple.traverseTopDown(visitor);
        if(Expr!=null) Expr.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ActParsMultiple!=null) ActParsMultiple.traverseBottomUp(visitor);
        if(Expr!=null) Expr.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ActualParamsMultiple(\n");

        if(ActParsMultiple!=null)
            buffer.append(ActParsMultiple.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Expr!=null)
            buffer.append(Expr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ActualParamsMultiple]");
        return buffer.toString();
    }
}
