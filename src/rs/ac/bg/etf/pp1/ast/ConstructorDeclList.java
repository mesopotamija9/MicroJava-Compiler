// generated with ast extension for cup
// version 0.8
// 15/0/2023 21:44:9


package rs.ac.bg.etf.pp1.ast;

public class ConstructorDeclList extends ConstructorDeclL {

    private ConstructorDeclL ConstructorDeclL;
    private ConstructorDecl ConstructorDecl;

    public ConstructorDeclList (ConstructorDeclL ConstructorDeclL, ConstructorDecl ConstructorDecl) {
        this.ConstructorDeclL=ConstructorDeclL;
        if(ConstructorDeclL!=null) ConstructorDeclL.setParent(this);
        this.ConstructorDecl=ConstructorDecl;
        if(ConstructorDecl!=null) ConstructorDecl.setParent(this);
    }

    public ConstructorDeclL getConstructorDeclL() {
        return ConstructorDeclL;
    }

    public void setConstructorDeclL(ConstructorDeclL ConstructorDeclL) {
        this.ConstructorDeclL=ConstructorDeclL;
    }

    public ConstructorDecl getConstructorDecl() {
        return ConstructorDecl;
    }

    public void setConstructorDecl(ConstructorDecl ConstructorDecl) {
        this.ConstructorDecl=ConstructorDecl;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ConstructorDeclL!=null) ConstructorDeclL.accept(visitor);
        if(ConstructorDecl!=null) ConstructorDecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ConstructorDeclL!=null) ConstructorDeclL.traverseTopDown(visitor);
        if(ConstructorDecl!=null) ConstructorDecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ConstructorDeclL!=null) ConstructorDeclL.traverseBottomUp(visitor);
        if(ConstructorDecl!=null) ConstructorDecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstructorDeclList(\n");

        if(ConstructorDeclL!=null)
            buffer.append(ConstructorDeclL.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ConstructorDecl!=null)
            buffer.append(ConstructorDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstructorDeclList]");
        return buffer.toString();
    }
}
