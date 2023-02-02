// generated with ast extension for cup
// version 0.8
// 15/0/2023 21:44:9


package rs.ac.bg.etf.pp1.ast;

public class ClassVarDeclaration extends ClassVarDecl {

    private Type Type;
    private ClassVarName ClassVarName;
    private ClassVarDeclMultip ClassVarDeclMultip;

    public ClassVarDeclaration (Type Type, ClassVarName ClassVarName, ClassVarDeclMultip ClassVarDeclMultip) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.ClassVarName=ClassVarName;
        if(ClassVarName!=null) ClassVarName.setParent(this);
        this.ClassVarDeclMultip=ClassVarDeclMultip;
        if(ClassVarDeclMultip!=null) ClassVarDeclMultip.setParent(this);
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public ClassVarName getClassVarName() {
        return ClassVarName;
    }

    public void setClassVarName(ClassVarName ClassVarName) {
        this.ClassVarName=ClassVarName;
    }

    public ClassVarDeclMultip getClassVarDeclMultip() {
        return ClassVarDeclMultip;
    }

    public void setClassVarDeclMultip(ClassVarDeclMultip ClassVarDeclMultip) {
        this.ClassVarDeclMultip=ClassVarDeclMultip;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Type!=null) Type.accept(visitor);
        if(ClassVarName!=null) ClassVarName.accept(visitor);
        if(ClassVarDeclMultip!=null) ClassVarDeclMultip.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(ClassVarName!=null) ClassVarName.traverseTopDown(visitor);
        if(ClassVarDeclMultip!=null) ClassVarDeclMultip.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(ClassVarName!=null) ClassVarName.traverseBottomUp(visitor);
        if(ClassVarDeclMultip!=null) ClassVarDeclMultip.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ClassVarDeclaration(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ClassVarName!=null)
            buffer.append(ClassVarName.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ClassVarDeclMultip!=null)
            buffer.append(ClassVarDeclMultip.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ClassVarDeclaration]");
        return buffer.toString();
    }
}
