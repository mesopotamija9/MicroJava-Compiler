// generated with ast extension for cup
// version 0.8
// 15/0/2023 21:44:9


package rs.ac.bg.etf.pp1.ast;

public class DeclList extends DeclL {

    private DeclL DeclL;
    private DeclE DeclE;

    public DeclList (DeclL DeclL, DeclE DeclE) {
        this.DeclL=DeclL;
        if(DeclL!=null) DeclL.setParent(this);
        this.DeclE=DeclE;
        if(DeclE!=null) DeclE.setParent(this);
    }

    public DeclL getDeclL() {
        return DeclL;
    }

    public void setDeclL(DeclL DeclL) {
        this.DeclL=DeclL;
    }

    public DeclE getDeclE() {
        return DeclE;
    }

    public void setDeclE(DeclE DeclE) {
        this.DeclE=DeclE;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DeclL!=null) DeclL.accept(visitor);
        if(DeclE!=null) DeclE.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DeclL!=null) DeclL.traverseTopDown(visitor);
        if(DeclE!=null) DeclE.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DeclL!=null) DeclL.traverseBottomUp(visitor);
        if(DeclE!=null) DeclE.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DeclList(\n");

        if(DeclL!=null)
            buffer.append(DeclL.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(DeclE!=null)
            buffer.append(DeclE.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DeclList]");
        return buffer.toString();
    }
}
