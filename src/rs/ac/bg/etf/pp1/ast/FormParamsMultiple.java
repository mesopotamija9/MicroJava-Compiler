// generated with ast extension for cup
// version 0.8
// 15/0/2023 21:44:9


package rs.ac.bg.etf.pp1.ast;

public class FormParamsMultiple extends FormParsMultiple {

    private FormParsMultiple FormParsMultiple;
    private ParTypeName ParTypeName;

    public FormParamsMultiple (FormParsMultiple FormParsMultiple, ParTypeName ParTypeName) {
        this.FormParsMultiple=FormParsMultiple;
        if(FormParsMultiple!=null) FormParsMultiple.setParent(this);
        this.ParTypeName=ParTypeName;
        if(ParTypeName!=null) ParTypeName.setParent(this);
    }

    public FormParsMultiple getFormParsMultiple() {
        return FormParsMultiple;
    }

    public void setFormParsMultiple(FormParsMultiple FormParsMultiple) {
        this.FormParsMultiple=FormParsMultiple;
    }

    public ParTypeName getParTypeName() {
        return ParTypeName;
    }

    public void setParTypeName(ParTypeName ParTypeName) {
        this.ParTypeName=ParTypeName;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(FormParsMultiple!=null) FormParsMultiple.accept(visitor);
        if(ParTypeName!=null) ParTypeName.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(FormParsMultiple!=null) FormParsMultiple.traverseTopDown(visitor);
        if(ParTypeName!=null) ParTypeName.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(FormParsMultiple!=null) FormParsMultiple.traverseBottomUp(visitor);
        if(ParTypeName!=null) ParTypeName.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FormParamsMultiple(\n");

        if(FormParsMultiple!=null)
            buffer.append(FormParsMultiple.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ParTypeName!=null)
            buffer.append(ParTypeName.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FormParamsMultiple]");
        return buffer.toString();
    }
}
