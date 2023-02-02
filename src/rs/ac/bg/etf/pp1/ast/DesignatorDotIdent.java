// generated with ast extension for cup
// version 0.8
// 15/0/2023 21:44:9


package rs.ac.bg.etf.pp1.ast;

public class DesignatorDotIdent extends DesignatorMultiple {

    private DesigDot DesigDot;
    private String designatorName;

    public DesignatorDotIdent (DesigDot DesigDot, String designatorName) {
        this.DesigDot=DesigDot;
        if(DesigDot!=null) DesigDot.setParent(this);
        this.designatorName=designatorName;
    }

    public DesigDot getDesigDot() {
        return DesigDot;
    }

    public void setDesigDot(DesigDot DesigDot) {
        this.DesigDot=DesigDot;
    }

    public String getDesignatorName() {
        return designatorName;
    }

    public void setDesignatorName(String designatorName) {
        this.designatorName=designatorName;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DesigDot!=null) DesigDot.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesigDot!=null) DesigDot.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesigDot!=null) DesigDot.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesignatorDotIdent(\n");

        if(DesigDot!=null)
            buffer.append(DesigDot.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(" "+tab+designatorName);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesignatorDotIdent]");
        return buffer.toString();
    }
}
