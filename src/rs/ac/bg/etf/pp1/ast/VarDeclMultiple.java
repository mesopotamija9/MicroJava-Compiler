// generated with ast extension for cup
// version 0.8
// 15/0/2023 21:44:9


package rs.ac.bg.etf.pp1.ast;

public class VarDeclMultiple extends VarDeclMultip {

    private VarDeclMultip VarDeclMultip;
    private VarName VarName;

    public VarDeclMultiple (VarDeclMultip VarDeclMultip, VarName VarName) {
        this.VarDeclMultip=VarDeclMultip;
        if(VarDeclMultip!=null) VarDeclMultip.setParent(this);
        this.VarName=VarName;
        if(VarName!=null) VarName.setParent(this);
    }

    public VarDeclMultip getVarDeclMultip() {
        return VarDeclMultip;
    }

    public void setVarDeclMultip(VarDeclMultip VarDeclMultip) {
        this.VarDeclMultip=VarDeclMultip;
    }

    public VarName getVarName() {
        return VarName;
    }

    public void setVarName(VarName VarName) {
        this.VarName=VarName;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(VarDeclMultip!=null) VarDeclMultip.accept(visitor);
        if(VarName!=null) VarName.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(VarDeclMultip!=null) VarDeclMultip.traverseTopDown(visitor);
        if(VarName!=null) VarName.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(VarDeclMultip!=null) VarDeclMultip.traverseBottomUp(visitor);
        if(VarName!=null) VarName.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarDeclMultiple(\n");

        if(VarDeclMultip!=null)
            buffer.append(VarDeclMultip.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarName!=null)
            buffer.append(VarName.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VarDeclMultiple]");
        return buffer.toString();
    }
}
