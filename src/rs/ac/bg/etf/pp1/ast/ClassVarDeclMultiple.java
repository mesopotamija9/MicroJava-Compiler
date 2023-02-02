// generated with ast extension for cup
// version 0.8
// 15/0/2023 21:44:9


package rs.ac.bg.etf.pp1.ast;

public class ClassVarDeclMultiple extends ClassVarDeclMultip {

    private ClassVarDeclMultip ClassVarDeclMultip;
    private ClassVarName ClassVarName;

    public ClassVarDeclMultiple (ClassVarDeclMultip ClassVarDeclMultip, ClassVarName ClassVarName) {
        this.ClassVarDeclMultip=ClassVarDeclMultip;
        if(ClassVarDeclMultip!=null) ClassVarDeclMultip.setParent(this);
        this.ClassVarName=ClassVarName;
        if(ClassVarName!=null) ClassVarName.setParent(this);
    }

    public ClassVarDeclMultip getClassVarDeclMultip() {
        return ClassVarDeclMultip;
    }

    public void setClassVarDeclMultip(ClassVarDeclMultip ClassVarDeclMultip) {
        this.ClassVarDeclMultip=ClassVarDeclMultip;
    }

    public ClassVarName getClassVarName() {
        return ClassVarName;
    }

    public void setClassVarName(ClassVarName ClassVarName) {
        this.ClassVarName=ClassVarName;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ClassVarDeclMultip!=null) ClassVarDeclMultip.accept(visitor);
        if(ClassVarName!=null) ClassVarName.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ClassVarDeclMultip!=null) ClassVarDeclMultip.traverseTopDown(visitor);
        if(ClassVarName!=null) ClassVarName.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ClassVarDeclMultip!=null) ClassVarDeclMultip.traverseBottomUp(visitor);
        if(ClassVarName!=null) ClassVarName.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ClassVarDeclMultiple(\n");

        if(ClassVarDeclMultip!=null)
            buffer.append(ClassVarDeclMultip.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ClassVarName!=null)
            buffer.append(ClassVarName.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ClassVarDeclMultiple]");
        return buffer.toString();
    }
}
