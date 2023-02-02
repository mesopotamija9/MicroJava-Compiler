// generated with ast extension for cup
// version 0.8
// 15/0/2023 21:44:9


package rs.ac.bg.etf.pp1.ast;

public class FormParams extends FormPars {

    private ParTypeName ParTypeName;
    private FormParsMultiple FormParsMultiple;

    public FormParams (ParTypeName ParTypeName, FormParsMultiple FormParsMultiple) {
        this.ParTypeName=ParTypeName;
        if(ParTypeName!=null) ParTypeName.setParent(this);
        this.FormParsMultiple=FormParsMultiple;
        if(FormParsMultiple!=null) FormParsMultiple.setParent(this);
    }

    public ParTypeName getParTypeName() {
        return ParTypeName;
    }

    public void setParTypeName(ParTypeName ParTypeName) {
        this.ParTypeName=ParTypeName;
    }

    public FormParsMultiple getFormParsMultiple() {
        return FormParsMultiple;
    }

    public void setFormParsMultiple(FormParsMultiple FormParsMultiple) {
        this.FormParsMultiple=FormParsMultiple;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ParTypeName!=null) ParTypeName.accept(visitor);
        if(FormParsMultiple!=null) FormParsMultiple.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ParTypeName!=null) ParTypeName.traverseTopDown(visitor);
        if(FormParsMultiple!=null) FormParsMultiple.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ParTypeName!=null) ParTypeName.traverseBottomUp(visitor);
        if(FormParsMultiple!=null) FormParsMultiple.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FormParams(\n");

        if(ParTypeName!=null)
            buffer.append(ParTypeName.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(FormParsMultiple!=null)
            buffer.append(FormParsMultiple.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FormParams]");
        return buffer.toString();
    }
}
