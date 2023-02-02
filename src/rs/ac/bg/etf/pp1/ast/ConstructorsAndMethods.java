// generated with ast extension for cup
// version 0.8
// 15/0/2023 21:44:9


package rs.ac.bg.etf.pp1.ast;

public class ConstructorsAndMethods extends ConstructAndMethods {

    private ConstructorDeclL ConstructorDeclL;
    private MethodDeclL MethodDeclL;

    public ConstructorsAndMethods (ConstructorDeclL ConstructorDeclL, MethodDeclL MethodDeclL) {
        this.ConstructorDeclL=ConstructorDeclL;
        if(ConstructorDeclL!=null) ConstructorDeclL.setParent(this);
        this.MethodDeclL=MethodDeclL;
        if(MethodDeclL!=null) MethodDeclL.setParent(this);
    }

    public ConstructorDeclL getConstructorDeclL() {
        return ConstructorDeclL;
    }

    public void setConstructorDeclL(ConstructorDeclL ConstructorDeclL) {
        this.ConstructorDeclL=ConstructorDeclL;
    }

    public MethodDeclL getMethodDeclL() {
        return MethodDeclL;
    }

    public void setMethodDeclL(MethodDeclL MethodDeclL) {
        this.MethodDeclL=MethodDeclL;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ConstructorDeclL!=null) ConstructorDeclL.accept(visitor);
        if(MethodDeclL!=null) MethodDeclL.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ConstructorDeclL!=null) ConstructorDeclL.traverseTopDown(visitor);
        if(MethodDeclL!=null) MethodDeclL.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ConstructorDeclL!=null) ConstructorDeclL.traverseBottomUp(visitor);
        if(MethodDeclL!=null) MethodDeclL.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstructorsAndMethods(\n");

        if(ConstructorDeclL!=null)
            buffer.append(ConstructorDeclL.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(MethodDeclL!=null)
            buffer.append(MethodDeclL.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstructorsAndMethods]");
        return buffer.toString();
    }
}
