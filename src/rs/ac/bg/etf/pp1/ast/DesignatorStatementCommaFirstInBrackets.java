// generated with ast extension for cup
// version 0.8
// 15/0/2023 21:44:9


package rs.ac.bg.etf.pp1.ast;

public class DesignatorStatementCommaFirstInBrackets extends DesignatorStatement {

    private DesignatorL DesignatorL;
    private Designator Designator;

    public DesignatorStatementCommaFirstInBrackets (DesignatorL DesignatorL, Designator Designator) {
        this.DesignatorL=DesignatorL;
        if(DesignatorL!=null) DesignatorL.setParent(this);
        this.Designator=Designator;
        if(Designator!=null) Designator.setParent(this);
    }

    public DesignatorL getDesignatorL() {
        return DesignatorL;
    }

    public void setDesignatorL(DesignatorL DesignatorL) {
        this.DesignatorL=DesignatorL;
    }

    public Designator getDesignator() {
        return Designator;
    }

    public void setDesignator(Designator Designator) {
        this.Designator=Designator;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DesignatorL!=null) DesignatorL.accept(visitor);
        if(Designator!=null) Designator.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesignatorL!=null) DesignatorL.traverseTopDown(visitor);
        if(Designator!=null) Designator.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesignatorL!=null) DesignatorL.traverseBottomUp(visitor);
        if(Designator!=null) Designator.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesignatorStatementCommaFirstInBrackets(\n");

        if(DesignatorL!=null)
            buffer.append(DesignatorL.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Designator!=null)
            buffer.append(Designator.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesignatorStatementCommaFirstInBrackets]");
        return buffer.toString();
    }
}
