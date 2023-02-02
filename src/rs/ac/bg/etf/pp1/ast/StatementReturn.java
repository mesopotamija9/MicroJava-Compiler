// generated with ast extension for cup
// version 0.8
// 15/0/2023 21:44:9


package rs.ac.bg.etf.pp1.ast;

public class StatementReturn extends Statement {

    private ReturnKeyWord ReturnKeyWord;

    public StatementReturn (ReturnKeyWord ReturnKeyWord) {
        this.ReturnKeyWord=ReturnKeyWord;
        if(ReturnKeyWord!=null) ReturnKeyWord.setParent(this);
    }

    public ReturnKeyWord getReturnKeyWord() {
        return ReturnKeyWord;
    }

    public void setReturnKeyWord(ReturnKeyWord ReturnKeyWord) {
        this.ReturnKeyWord=ReturnKeyWord;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ReturnKeyWord!=null) ReturnKeyWord.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ReturnKeyWord!=null) ReturnKeyWord.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ReturnKeyWord!=null) ReturnKeyWord.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("StatementReturn(\n");

        if(ReturnKeyWord!=null)
            buffer.append(ReturnKeyWord.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [StatementReturn]");
        return buffer.toString();
    }
}
