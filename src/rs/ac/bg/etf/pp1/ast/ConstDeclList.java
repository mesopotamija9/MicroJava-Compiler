// generated with ast extension for cup
// version 0.8
// 15/0/2023 21:44:9


package rs.ac.bg.etf.pp1.ast;

public class ConstDeclList extends ConstDeclL {

    private ConstDeclL ConstDeclL;
    private ConstName ConstName;
    private LiteralE LiteralE;

    public ConstDeclList (ConstDeclL ConstDeclL, ConstName ConstName, LiteralE LiteralE) {
        this.ConstDeclL=ConstDeclL;
        if(ConstDeclL!=null) ConstDeclL.setParent(this);
        this.ConstName=ConstName;
        if(ConstName!=null) ConstName.setParent(this);
        this.LiteralE=LiteralE;
        if(LiteralE!=null) LiteralE.setParent(this);
    }

    public ConstDeclL getConstDeclL() {
        return ConstDeclL;
    }

    public void setConstDeclL(ConstDeclL ConstDeclL) {
        this.ConstDeclL=ConstDeclL;
    }

    public ConstName getConstName() {
        return ConstName;
    }

    public void setConstName(ConstName ConstName) {
        this.ConstName=ConstName;
    }

    public LiteralE getLiteralE() {
        return LiteralE;
    }

    public void setLiteralE(LiteralE LiteralE) {
        this.LiteralE=LiteralE;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ConstDeclL!=null) ConstDeclL.accept(visitor);
        if(ConstName!=null) ConstName.accept(visitor);
        if(LiteralE!=null) LiteralE.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ConstDeclL!=null) ConstDeclL.traverseTopDown(visitor);
        if(ConstName!=null) ConstName.traverseTopDown(visitor);
        if(LiteralE!=null) LiteralE.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ConstDeclL!=null) ConstDeclL.traverseBottomUp(visitor);
        if(ConstName!=null) ConstName.traverseBottomUp(visitor);
        if(LiteralE!=null) LiteralE.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstDeclList(\n");

        if(ConstDeclL!=null)
            buffer.append(ConstDeclL.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ConstName!=null)
            buffer.append(ConstName.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(LiteralE!=null)
            buffer.append(LiteralE.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstDeclList]");
        return buffer.toString();
    }
}
