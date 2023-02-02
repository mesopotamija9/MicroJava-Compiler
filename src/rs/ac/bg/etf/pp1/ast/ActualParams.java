// generated with ast extension for cup
// version 0.8
// 15/0/2023 21:44:9


package rs.ac.bg.etf.pp1.ast;

public class ActualParams extends ActPars {

    private Expr Expr;
    private ActParsMultiple ActParsMultiple;

    public ActualParams (Expr Expr, ActParsMultiple ActParsMultiple) {
        this.Expr=Expr;
        if(Expr!=null) Expr.setParent(this);
        this.ActParsMultiple=ActParsMultiple;
        if(ActParsMultiple!=null) ActParsMultiple.setParent(this);
    }

    public Expr getExpr() {
        return Expr;
    }

    public void setExpr(Expr Expr) {
        this.Expr=Expr;
    }

    public ActParsMultiple getActParsMultiple() {
        return ActParsMultiple;
    }

    public void setActParsMultiple(ActParsMultiple ActParsMultiple) {
        this.ActParsMultiple=ActParsMultiple;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Expr!=null) Expr.accept(visitor);
        if(ActParsMultiple!=null) ActParsMultiple.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Expr!=null) Expr.traverseTopDown(visitor);
        if(ActParsMultiple!=null) ActParsMultiple.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Expr!=null) Expr.traverseBottomUp(visitor);
        if(ActParsMultiple!=null) ActParsMultiple.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ActualParams(\n");

        if(Expr!=null)
            buffer.append(Expr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ActParsMultiple!=null)
            buffer.append(ActParsMultiple.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ActualParams]");
        return buffer.toString();
    }
}
