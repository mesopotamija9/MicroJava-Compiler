// generated with ast extension for cup
// version 0.8
// 15/0/2023 21:44:9


package rs.ac.bg.etf.pp1.ast;

public class StatementForEach extends Statement {

    private DesigDot DesigDot;
    private ForeachKeyWord ForeachKeyWord;
    private ForEachCurrName ForEachCurrName;
    private Statement Statement;
    private ForEachEnd ForEachEnd;

    public StatementForEach (DesigDot DesigDot, ForeachKeyWord ForeachKeyWord, ForEachCurrName ForEachCurrName, Statement Statement, ForEachEnd ForEachEnd) {
        this.DesigDot=DesigDot;
        if(DesigDot!=null) DesigDot.setParent(this);
        this.ForeachKeyWord=ForeachKeyWord;
        if(ForeachKeyWord!=null) ForeachKeyWord.setParent(this);
        this.ForEachCurrName=ForEachCurrName;
        if(ForEachCurrName!=null) ForEachCurrName.setParent(this);
        this.Statement=Statement;
        if(Statement!=null) Statement.setParent(this);
        this.ForEachEnd=ForEachEnd;
        if(ForEachEnd!=null) ForEachEnd.setParent(this);
    }

    public DesigDot getDesigDot() {
        return DesigDot;
    }

    public void setDesigDot(DesigDot DesigDot) {
        this.DesigDot=DesigDot;
    }

    public ForeachKeyWord getForeachKeyWord() {
        return ForeachKeyWord;
    }

    public void setForeachKeyWord(ForeachKeyWord ForeachKeyWord) {
        this.ForeachKeyWord=ForeachKeyWord;
    }

    public ForEachCurrName getForEachCurrName() {
        return ForEachCurrName;
    }

    public void setForEachCurrName(ForEachCurrName ForEachCurrName) {
        this.ForEachCurrName=ForEachCurrName;
    }

    public Statement getStatement() {
        return Statement;
    }

    public void setStatement(Statement Statement) {
        this.Statement=Statement;
    }

    public ForEachEnd getForEachEnd() {
        return ForEachEnd;
    }

    public void setForEachEnd(ForEachEnd ForEachEnd) {
        this.ForEachEnd=ForEachEnd;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DesigDot!=null) DesigDot.accept(visitor);
        if(ForeachKeyWord!=null) ForeachKeyWord.accept(visitor);
        if(ForEachCurrName!=null) ForEachCurrName.accept(visitor);
        if(Statement!=null) Statement.accept(visitor);
        if(ForEachEnd!=null) ForEachEnd.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesigDot!=null) DesigDot.traverseTopDown(visitor);
        if(ForeachKeyWord!=null) ForeachKeyWord.traverseTopDown(visitor);
        if(ForEachCurrName!=null) ForEachCurrName.traverseTopDown(visitor);
        if(Statement!=null) Statement.traverseTopDown(visitor);
        if(ForEachEnd!=null) ForEachEnd.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesigDot!=null) DesigDot.traverseBottomUp(visitor);
        if(ForeachKeyWord!=null) ForeachKeyWord.traverseBottomUp(visitor);
        if(ForEachCurrName!=null) ForEachCurrName.traverseBottomUp(visitor);
        if(Statement!=null) Statement.traverseBottomUp(visitor);
        if(ForEachEnd!=null) ForEachEnd.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("StatementForEach(\n");

        if(DesigDot!=null)
            buffer.append(DesigDot.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ForeachKeyWord!=null)
            buffer.append(ForeachKeyWord.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ForEachCurrName!=null)
            buffer.append(ForEachCurrName.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Statement!=null)
            buffer.append(Statement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ForEachEnd!=null)
            buffer.append(ForEachEnd.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [StatementForEach]");
        return buffer.toString();
    }
}
