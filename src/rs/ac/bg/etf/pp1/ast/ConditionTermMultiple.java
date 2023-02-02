// generated with ast extension for cup
// version 0.8
// 15/0/2023 21:44:9


package rs.ac.bg.etf.pp1.ast;

public class ConditionTermMultiple extends CondTermMultiple {

    private CondTermMultiple CondTermMultiple;
    private CondOrEnd CondOrEnd;
    private CondTerm CondTerm;

    public ConditionTermMultiple (CondTermMultiple CondTermMultiple, CondOrEnd CondOrEnd, CondTerm CondTerm) {
        this.CondTermMultiple=CondTermMultiple;
        if(CondTermMultiple!=null) CondTermMultiple.setParent(this);
        this.CondOrEnd=CondOrEnd;
        if(CondOrEnd!=null) CondOrEnd.setParent(this);
        this.CondTerm=CondTerm;
        if(CondTerm!=null) CondTerm.setParent(this);
    }

    public CondTermMultiple getCondTermMultiple() {
        return CondTermMultiple;
    }

    public void setCondTermMultiple(CondTermMultiple CondTermMultiple) {
        this.CondTermMultiple=CondTermMultiple;
    }

    public CondOrEnd getCondOrEnd() {
        return CondOrEnd;
    }

    public void setCondOrEnd(CondOrEnd CondOrEnd) {
        this.CondOrEnd=CondOrEnd;
    }

    public CondTerm getCondTerm() {
        return CondTerm;
    }

    public void setCondTerm(CondTerm CondTerm) {
        this.CondTerm=CondTerm;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(CondTermMultiple!=null) CondTermMultiple.accept(visitor);
        if(CondOrEnd!=null) CondOrEnd.accept(visitor);
        if(CondTerm!=null) CondTerm.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(CondTermMultiple!=null) CondTermMultiple.traverseTopDown(visitor);
        if(CondOrEnd!=null) CondOrEnd.traverseTopDown(visitor);
        if(CondTerm!=null) CondTerm.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(CondTermMultiple!=null) CondTermMultiple.traverseBottomUp(visitor);
        if(CondOrEnd!=null) CondOrEnd.traverseBottomUp(visitor);
        if(CondTerm!=null) CondTerm.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConditionTermMultiple(\n");

        if(CondTermMultiple!=null)
            buffer.append(CondTermMultiple.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(CondOrEnd!=null)
            buffer.append(CondOrEnd.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(CondTerm!=null)
            buffer.append(CondTerm.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConditionTermMultiple]");
        return buffer.toString();
    }
}
