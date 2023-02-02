// generated with ast extension for cup
// version 0.8
// 15/0/2023 21:44:9


package rs.ac.bg.etf.pp1.ast;

public class Program implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    public rs.etf.pp1.symboltable.concepts.Obj obj = null;

    private ProgramName ProgramName;
    private DeclL DeclL;
    private MethodDeclL MethodDeclL;

    public Program (ProgramName ProgramName, DeclL DeclL, MethodDeclL MethodDeclL) {
        this.ProgramName=ProgramName;
        if(ProgramName!=null) ProgramName.setParent(this);
        this.DeclL=DeclL;
        if(DeclL!=null) DeclL.setParent(this);
        this.MethodDeclL=MethodDeclL;
        if(MethodDeclL!=null) MethodDeclL.setParent(this);
    }

    public ProgramName getProgramName() {
        return ProgramName;
    }

    public void setProgramName(ProgramName ProgramName) {
        this.ProgramName=ProgramName;
    }

    public DeclL getDeclL() {
        return DeclL;
    }

    public void setDeclL(DeclL DeclL) {
        this.DeclL=DeclL;
    }

    public MethodDeclL getMethodDeclL() {
        return MethodDeclL;
    }

    public void setMethodDeclL(MethodDeclL MethodDeclL) {
        this.MethodDeclL=MethodDeclL;
    }

    public SyntaxNode getParent() {
        return parent;
    }

    public void setParent(SyntaxNode parent) {
        this.parent=parent;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line=line;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ProgramName!=null) ProgramName.accept(visitor);
        if(DeclL!=null) DeclL.accept(visitor);
        if(MethodDeclL!=null) MethodDeclL.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ProgramName!=null) ProgramName.traverseTopDown(visitor);
        if(DeclL!=null) DeclL.traverseTopDown(visitor);
        if(MethodDeclL!=null) MethodDeclL.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ProgramName!=null) ProgramName.traverseBottomUp(visitor);
        if(DeclL!=null) DeclL.traverseBottomUp(visitor);
        if(MethodDeclL!=null) MethodDeclL.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Program(\n");

        if(ProgramName!=null)
            buffer.append(ProgramName.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(DeclL!=null)
            buffer.append(DeclL.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(MethodDeclL!=null)
            buffer.append(MethodDeclL.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [Program]");
        return buffer.toString();
    }
}
