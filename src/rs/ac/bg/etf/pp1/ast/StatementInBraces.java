// generated with ast extension for cup
// version 0.8
// 15/0/2023 21:44:9


package rs.ac.bg.etf.pp1.ast;

public class StatementInBraces extends Statement {

    private StatementL StatementL;

    public StatementInBraces (StatementL StatementL) {
        this.StatementL=StatementL;
        if(StatementL!=null) StatementL.setParent(this);
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
        if(StatementL!=null) StatementL.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(StatementL!=null) StatementL.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(StatementL!=null) StatementL.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("StatementInBraces(\n");

        if(StatementL!=null)
            buffer.append(StatementL.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [StatementInBraces]");
        return buffer.toString();
    }
}
