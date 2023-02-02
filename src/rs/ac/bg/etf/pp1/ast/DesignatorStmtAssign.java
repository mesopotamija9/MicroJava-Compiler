// generated with ast extension for cup
// version 0.8
// 15/0/2023 21:44:9


package rs.ac.bg.etf.pp1.ast;

public class DesignatorStmtAssign extends DesignatorStatement {

    private DesignatorStmAssign DesignatorStmAssign;

    public DesignatorStmtAssign (DesignatorStmAssign DesignatorStmAssign) {
        this.DesignatorStmAssign=DesignatorStmAssign;
        if(DesignatorStmAssign!=null) DesignatorStmAssign.setParent(this);
    }

    public DesignatorStmAssign getDesignatorStmAssign() {
        return DesignatorStmAssign;
    }

    public void setDesignatorStmAssign(DesignatorStmAssign DesignatorStmAssign) {
        this.DesignatorStmAssign=DesignatorStmAssign;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DesignatorStmAssign!=null) DesignatorStmAssign.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesignatorStmAssign!=null) DesignatorStmAssign.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesignatorStmAssign!=null) DesignatorStmAssign.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesignatorStmtAssign(\n");

        if(DesignatorStmAssign!=null)
            buffer.append(DesignatorStmAssign.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesignatorStmtAssign]");
        return buffer.toString();
    }
}
