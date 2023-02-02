// generated with ast extension for cup
// version 0.8
// 15/0/2023 21:44:9


package rs.ac.bg.etf.pp1.ast;

public class ClassVarDeclList extends ClassVarDeclL {

    private ClassVarDeclL ClassVarDeclL;
    private ClassVarDecl ClassVarDecl;

    public ClassVarDeclList (ClassVarDeclL ClassVarDeclL, ClassVarDecl ClassVarDecl) {
        this.ClassVarDeclL=ClassVarDeclL;
        if(ClassVarDeclL!=null) ClassVarDeclL.setParent(this);
        this.ClassVarDecl=ClassVarDecl;
        if(ClassVarDecl!=null) ClassVarDecl.setParent(this);
    }

    public ClassVarDeclL getClassVarDeclL() {
        return ClassVarDeclL;
    }

    public void setClassVarDeclL(ClassVarDeclL ClassVarDeclL) {
        this.ClassVarDeclL=ClassVarDeclL;
    }

    public ClassVarDecl getClassVarDecl() {
        return ClassVarDecl;
    }

    public void setClassVarDecl(ClassVarDecl ClassVarDecl) {
        this.ClassVarDecl=ClassVarDecl;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ClassVarDeclL!=null) ClassVarDeclL.accept(visitor);
        if(ClassVarDecl!=null) ClassVarDecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ClassVarDeclL!=null) ClassVarDeclL.traverseTopDown(visitor);
        if(ClassVarDecl!=null) ClassVarDecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ClassVarDeclL!=null) ClassVarDeclL.traverseBottomUp(visitor);
        if(ClassVarDecl!=null) ClassVarDecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ClassVarDeclList(\n");

        if(ClassVarDeclL!=null)
            buffer.append(ClassVarDeclL.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ClassVarDecl!=null)
            buffer.append(ClassVarDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ClassVarDeclList]");
        return buffer.toString();
    }
}
