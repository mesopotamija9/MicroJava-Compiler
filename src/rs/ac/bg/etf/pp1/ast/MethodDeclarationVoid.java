// generated with ast extension for cup
// version 0.8
// 15/0/2023 21:44:9


package rs.ac.bg.etf.pp1.ast;

public class MethodDeclarationVoid extends MethodDecl {

    private MethodNameVoid MethodNameVoid;
    private FormPars FormPars;
    private VarDeclL VarDeclL;
    private StatementL StatementL;

    public MethodDeclarationVoid (MethodNameVoid MethodNameVoid, FormPars FormPars, VarDeclL VarDeclL, StatementL StatementL) {
        this.MethodNameVoid=MethodNameVoid;
        if(MethodNameVoid!=null) MethodNameVoid.setParent(this);
        this.FormPars=FormPars;
        if(FormPars!=null) FormPars.setParent(this);
        this.VarDeclL=VarDeclL;
        if(VarDeclL!=null) VarDeclL.setParent(this);
        this.StatementL=StatementL;
        if(StatementL!=null) StatementL.setParent(this);
    }

    public MethodNameVoid getMethodNameVoid() {
        return MethodNameVoid;
    }

    public void setMethodNameVoid(MethodNameVoid MethodNameVoid) {
        this.MethodNameVoid=MethodNameVoid;
    }

    public FormPars getFormPars() {
        return FormPars;
    }

    public void setFormPars(FormPars FormPars) {
        this.FormPars=FormPars;
    }

    public VarDeclL getVarDeclL() {
        return VarDeclL;
    }

    public void setVarDeclL(VarDeclL VarDeclL) {
        this.VarDeclL=VarDeclL;
    }

    public StatementL getStatementL() {
        return StatementL;
    }

    public void setStatementL(StatementL StatementL) {
        this.StatementL=StatementL;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(MethodNameVoid!=null) MethodNameVoid.accept(visitor);
        if(FormPars!=null) FormPars.accept(visitor);
        if(VarDeclL!=null) VarDeclL.accept(visitor);
        if(StatementL!=null) StatementL.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(MethodNameVoid!=null) MethodNameVoid.traverseTopDown(visitor);
        if(FormPars!=null) FormPars.traverseTopDown(visitor);
        if(VarDeclL!=null) VarDeclL.traverseTopDown(visitor);
        if(StatementL!=null) StatementL.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(MethodNameVoid!=null) MethodNameVoid.traverseBottomUp(visitor);
        if(FormPars!=null) FormPars.traverseBottomUp(visitor);
        if(VarDeclL!=null) VarDeclL.traverseBottomUp(visitor);
        if(StatementL!=null) StatementL.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MethodDeclarationVoid(\n");

        if(MethodNameVoid!=null)
            buffer.append(MethodNameVoid.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(FormPars!=null)
            buffer.append(FormPars.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarDeclL!=null)
            buffer.append(VarDeclL.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(StatementL!=null)
            buffer.append(StatementL.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MethodDeclarationVoid]");
        return buffer.toString();
    }
}
