// generated with ast extension for cup
// version 0.8
// 15/0/2023 21:44:9


package rs.ac.bg.etf.pp1.ast;

public class DesignatorMul extends DesignatorMultiple {

    private DesignatorMultiple DesignatorMultiple;
    private Expr Expr;

    public DesignatorMul (DesignatorMultiple DesignatorMultiple, Expr Expr) {
        this.DesignatorMultiple=DesignatorMultiple;
        if(DesignatorMultiple!=null) DesignatorMultiple.setParent(this);
        this.Expr=Expr;
        if(Expr!=null) Expr.setParent(this);
    }

    public DesignatorMultiple getDesignatorMultiple() {
        return DesignatorMultiple;
    }

    public void setDesignatorMultiple(DesignatorMultiple DesignatorMultiple) {
        this.DesignatorMultiple=DesignatorMultiple;
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
        if(DesignatorMultiple!=null) DesignatorMultiple.accept(visitor);
        if(Expr!=null) Expr.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesignatorMultiple!=null) DesignatorMultiple.traverseTopDown(visitor);
        if(Expr!=null) Expr.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesignatorMultiple!=null) DesignatorMultiple.traverseBottomUp(visitor);
        if(Expr!=null) Expr.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesignatorMul(\n");

        if(DesignatorMultiple!=null)
            buffer.append(DesignatorMultiple.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Expr!=null)
            buffer.append(Expr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesignatorMul]");
        return buffer.toString();
    }
}
