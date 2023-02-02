// generated with ast extension for cup
// version 0.8
// 15/0/2023 21:44:9


package rs.ac.bg.etf.pp1.ast;

public class StatementBreak extends Statement {

    private BreakKeyWord BreakKeyWord;

    public StatementBreak (BreakKeyWord BreakKeyWord) {
        this.BreakKeyWord=BreakKeyWord;
        if(BreakKeyWord!=null) BreakKeyWord.setParent(this);
    }

    public BreakKeyWord getBreakKeyWord() {
        return BreakKeyWord;
    }

    public void setBreakKeyWord(BreakKeyWord BreakKeyWord) {
        this.BreakKeyWord=BreakKeyWord;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(BreakKeyWord!=null) BreakKeyWord.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(BreakKeyWord!=null) BreakKeyWord.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(BreakKeyWord!=null) BreakKeyWord.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("StatementBreak(\n");

        if(BreakKeyWord!=null)
            buffer.append(BreakKeyWord.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [StatementBreak]");
        return buffer.toString();
    }
}
