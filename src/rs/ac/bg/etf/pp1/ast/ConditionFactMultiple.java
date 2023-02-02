// generated with ast extension for cup
// version 0.8
// 15/0/2023 21:44:9


package rs.ac.bg.etf.pp1.ast;

public class ConditionFactMultiple extends CondFactMultiple {

    private CondFactMultiple CondFactMultiple;
    private CondFact CondFact;

    public ConditionFactMultiple (CondFactMultiple CondFactMultiple, CondFact CondFact) {
        this.CondFactMultiple=CondFactMultiple;
        if(CondFactMultiple!=null) CondFactMultiple.setParent(this);
        this.CondFact=CondFact;
        if(CondFact!=null) CondFact.setParent(this);
    }

    public CondFactMultiple getCondFactMultiple() {
        return CondFactMultiple;
    }

    public void setCondFactMultiple(CondFactMultiple CondFactMultiple) {
        this.CondFactMultiple=CondFactMultiple;
    }

    public CondFact getCondFact() {
        return CondFact;
    }

    public void setCondFact(CondFact CondFact) {
        this.CondFact=CondFact;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(CondFactMultiple!=null) CondFactMultiple.accept(visitor);
        if(CondFact!=null) CondFact.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(CondFactMultiple!=null) CondFactMultiple.traverseTopDown(visitor);
        if(CondFact!=null) CondFact.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(CondFactMultiple!=null) CondFactMultiple.traverseBottomUp(visitor);
        if(CondFact!=null) CondFact.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConditionFactMultiple(\n");

        if(CondFactMultiple!=null)
            buffer.append(CondFactMultiple.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(CondFact!=null)
            buffer.append(CondFact.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConditionFactMultiple]");
        return buffer.toString();
    }
}
