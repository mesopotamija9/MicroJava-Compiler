// generated with ast extension for cup
// version 0.8
// 15/0/2023 21:44:9


package rs.ac.bg.etf.pp1.ast;

public class VarDeclaration extends VarDecl {

    private Type Type;
    private VarName VarName;
    private VarDeclMultip VarDeclMultip;

    public VarDeclaration (Type Type, VarName VarName, VarDeclMultip VarDeclMultip) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.VarName=VarName;
        if(VarName!=null) VarName.setParent(this);
        this.VarDeclMultip=VarDeclMultip;
        if(VarDeclMultip!=null) VarDeclMultip.setParent(this);
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public VarName getVarName() {
        return VarName;
    }

    public void setVarName(VarName VarName) {
        this.VarName=VarName;
    }

    public VarDeclMultip getVarDeclMultip() {
        return VarDeclMultip;
    }

    public void setVarDeclMultip(VarDeclMultip VarDeclMultip) {
        this.VarDeclMultip=VarDeclMultip;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Type!=null) Type.accept(visitor);
        if(VarName!=null) VarName.accept(visitor);
        if(VarDeclMultip!=null) VarDeclMultip.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(VarName!=null) VarName.traverseTopDown(visitor);
        if(VarDeclMultip!=null) VarDeclMultip.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(VarName!=null) VarName.traverseBottomUp(visitor);
        if(VarDeclMultip!=null) VarDeclMultip.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarDeclaration(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarName!=null)
            buffer.append(VarName.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarDeclMultip!=null)
            buffer.append(VarDeclMultip.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VarDeclaration]");
        return buffer.toString();
    }
}
