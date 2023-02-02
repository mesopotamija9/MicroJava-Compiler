// generated with ast extension for cup
// version 0.8
// 15/0/2023 21:44:9


package rs.ac.bg.etf.pp1.ast;

public class StatementContinue extends Statement {

    private ContinueKeyWord ContinueKeyWord;

    public StatementContinue (ContinueKeyWord ContinueKeyWord) {
        this.ContinueKeyWord=ContinueKeyWord;
        if(ContinueKeyWord!=null) ContinueKeyWord.setParent(this);
    }

    public ContinueKeyWord getContinueKeyWord() {
        return ContinueKeyWord;
    }

    public void setContinueKeyWord(ContinueKeyWord ContinueKeyWord) {
        this.ContinueKeyWord=ContinueKeyWord;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ContinueKeyWord!=null) ContinueKeyWord.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ContinueKeyWord!=null) ContinueKeyWord.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ContinueKeyWord!=null) ContinueKeyWord.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("StatementContinue(\n");

        if(ContinueKeyWord!=null)
            buffer.append(ContinueKeyWord.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [StatementContinue]");
        return buffer.toString();
    }
}
