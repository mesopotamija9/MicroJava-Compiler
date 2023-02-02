// generated with ast extension for cup
// version 0.8
// 15/0/2023 21:44:9


package rs.ac.bg.etf.pp1.ast;

public class DesignatorListCommaOnly extends DesignatorL {

    private DesignatorL DesignatorL;

    public DesignatorListCommaOnly (DesignatorL DesignatorL) {
        this.DesignatorL=DesignatorL;
        if(DesignatorL!=null) DesignatorL.setParent(this);
    }

    public DesignatorL getDesignatorL() {
        return DesignatorL;
    }

    public void setDesignatorL(DesignatorL DesignatorL) {
        this.DesignatorL=DesignatorL;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DesignatorL!=null) DesignatorL.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesignatorL!=null) DesignatorL.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesignatorL!=null) DesignatorL.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesignatorListCommaOnly(\n");

        if(DesignatorL!=null)
            buffer.append(DesignatorL.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesignatorListCommaOnly]");
        return buffer.toString();
    }
}
