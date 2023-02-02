// generated with ast extension for cup
// version 0.8
// 15/0/2023 21:44:9


package rs.ac.bg.etf.pp1.ast;

public class ClassDeclarationNoExtends extends ClassDecl {

    private String I1;
    private ClassVarDeclL ClassVarDeclL;
    private ConstructAndMethods ConstructAndMethods;

    public ClassDeclarationNoExtends (String I1, ClassVarDeclL ClassVarDeclL, ConstructAndMethods ConstructAndMethods) {
        this.I1=I1;
        this.ClassVarDeclL=ClassVarDeclL;
        if(ClassVarDeclL!=null) ClassVarDeclL.setParent(this);
        this.ConstructAndMethods=ConstructAndMethods;
        if(ConstructAndMethods!=null) ConstructAndMethods.setParent(this);
    }

    public String getI1() {
        return I1;
    }

    public void setI1(String I1) {
        this.I1=I1;
    }

    public ClassVarDeclL getClassVarDeclL() {
        return ClassVarDeclL;
    }

    public void setClassVarDeclL(ClassVarDeclL ClassVarDeclL) {
        this.ClassVarDeclL=ClassVarDeclL;
    }

    public ConstructAndMethods getConstructAndMethods() {
        return ConstructAndMethods;
    }

    public void setConstructAndMethods(ConstructAndMethods ConstructAndMethods) {
        this.ConstructAndMethods=ConstructAndMethods;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ClassVarDeclL!=null) ClassVarDeclL.accept(visitor);
        if(ConstructAndMethods!=null) ConstructAndMethods.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ClassVarDeclL!=null) ClassVarDeclL.traverseTopDown(visitor);
        if(ConstructAndMethods!=null) ConstructAndMethods.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ClassVarDeclL!=null) ClassVarDeclL.traverseBottomUp(visitor);
        if(ConstructAndMethods!=null) ConstructAndMethods.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ClassDeclarationNoExtends(\n");

        buffer.append(" "+tab+I1);
        buffer.append("\n");

        if(ClassVarDeclL!=null)
            buffer.append(ClassVarDeclL.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ConstructAndMethods!=null)
            buffer.append(ConstructAndMethods.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ClassDeclarationNoExtends]");
        return buffer.toString();
    }
}
