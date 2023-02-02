// generated with ast extension for cup
// version 0.8
// 15/0/2023 21:44:9


package rs.ac.bg.etf.pp1.ast;

public class ConstDeclaration extends ConstDecl {

    private Type Type;
    private ConstName ConstName;
    private LiteralE LiteralE;
    private ConstDeclL ConstDeclL;

    public ConstDeclaration (Type Type, ConstName ConstName, LiteralE LiteralE, ConstDeclL ConstDeclL) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.ConstName=ConstName;
        if(ConstName!=null) ConstName.setParent(this);
        this.LiteralE=LiteralE;
        if(LiteralE!=null) LiteralE.setParent(this);
        this.ConstDeclL=ConstDeclL;
        if(ConstDeclL!=null) ConstDeclL.setParent(this);
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
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

    public ConstDeclL getConstDeclL() {
        return ConstDeclL;
    }

    public void setConstDeclL(ConstDeclL ConstDeclL) {
        this.ConstDeclL=ConstDeclL;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Type!=null) Type.accept(visitor);
        if(ConstName!=null) ConstName.accept(visitor);
        if(LiteralE!=null) LiteralE.accept(visitor);
        if(ConstDeclL!=null) ConstDeclL.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(ConstName!=null) ConstName.traverseTopDown(visitor);
        if(LiteralE!=null) LiteralE.traverseTopDown(visitor);
        if(ConstDeclL!=null) ConstDeclL.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(ConstName!=null) ConstName.traverseBottomUp(visitor);
        if(LiteralE!=null) LiteralE.traverseBottomUp(visitor);
        if(ConstDeclL!=null) ConstDeclL.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstDeclaration(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
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

        if(ConstDeclL!=null)
            buffer.append(ConstDeclL.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstDeclaration]");
        return buffer.toString();
    }
}
