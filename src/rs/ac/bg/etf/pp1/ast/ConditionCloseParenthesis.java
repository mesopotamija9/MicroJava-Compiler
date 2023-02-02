// generated with ast extension for cup
// version 0.8
// 15/0/2023 21:44:9


package rs.ac.bg.etf.pp1.ast;

public class ConditionCloseParenthesis extends CondCloseParenthesis {

    private Condition Condition;
    private CondEnd CondEnd;

    public ConditionCloseParenthesis (Condition Condition, CondEnd CondEnd) {
        this.Condition=Condition;
        if(Condition!=null) Condition.setParent(this);
        this.CondEnd=CondEnd;
        if(CondEnd!=null) CondEnd.setParent(this);
    }

    public Condition getCondition() {
        return Condition;
    }

    public void setCondition(Condition Condition) {
        this.Condition=Condition;
    }

    public CondEnd getCondEnd() {
        return CondEnd;
    }

    public void setCondEnd(CondEnd CondEnd) {
        this.CondEnd=CondEnd;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Condition!=null) Condition.accept(visitor);
        if(CondEnd!=null) CondEnd.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Condition!=null) Condition.traverseTopDown(visitor);
        if(CondEnd!=null) CondEnd.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Condition!=null) Condition.traverseBottomUp(visitor);
        if(CondEnd!=null) CondEnd.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConditionCloseParenthesis(\n");

        if(Condition!=null)
            buffer.append(Condition.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(CondEnd!=null)
            buffer.append(CondEnd.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConditionCloseParenthesis]");
        return buffer.toString();
    }
}
