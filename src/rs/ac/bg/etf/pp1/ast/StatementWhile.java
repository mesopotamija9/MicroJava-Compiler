// generated with ast extension for cup
// version 0.8
// 15/0/2023 21:44:9


package rs.ac.bg.etf.pp1.ast;

public class StatementWhile extends Statement {

    private WhileKeyWord WhileKeyWord;
    private WhileCondStart WhileCondStart;
    private Condition Condition;
    private WhileCondEnd WhileCondEnd;
    private Statement Statement;
    private WhileEnd WhileEnd;

    public StatementWhile (WhileKeyWord WhileKeyWord, WhileCondStart WhileCondStart, Condition Condition, WhileCondEnd WhileCondEnd, Statement Statement, WhileEnd WhileEnd) {
        this.WhileKeyWord=WhileKeyWord;
        if(WhileKeyWord!=null) WhileKeyWord.setParent(this);
        this.WhileCondStart=WhileCondStart;
        if(WhileCondStart!=null) WhileCondStart.setParent(this);
        this.Condition=Condition;
        if(Condition!=null) Condition.setParent(this);
        this.WhileCondEnd=WhileCondEnd;
        if(WhileCondEnd!=null) WhileCondEnd.setParent(this);
        this.Statement=Statement;
        if(Statement!=null) Statement.setParent(this);
        this.WhileEnd=WhileEnd;
        if(WhileEnd!=null) WhileEnd.setParent(this);
    }

    public WhileKeyWord getWhileKeyWord() {
        return WhileKeyWord;
    }

    public void setWhileKeyWord(WhileKeyWord WhileKeyWord) {
        this.WhileKeyWord=WhileKeyWord;
    }

    public WhileCondStart getWhileCondStart() {
        return WhileCondStart;
    }

    public void setWhileCondStart(WhileCondStart WhileCondStart) {
        this.WhileCondStart=WhileCondStart;
    }

    public Condition getCondition() {
        return Condition;
    }

    public void setCondition(Condition Condition) {
        this.Condition=Condition;
    }

    public WhileCondEnd getWhileCondEnd() {
        return WhileCondEnd;
    }

    public void setWhileCondEnd(WhileCondEnd WhileCondEnd) {
        this.WhileCondEnd=WhileCondEnd;
    }

    public Statement getStatement() {
        return Statement;
    }

    public void setStatement(Statement Statement) {
        this.Statement=Statement;
    }

    public WhileEnd getWhileEnd() {
        return WhileEnd;
    }

    public void setWhileEnd(WhileEnd WhileEnd) {
        this.WhileEnd=WhileEnd;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(WhileKeyWord!=null) WhileKeyWord.accept(visitor);
        if(WhileCondStart!=null) WhileCondStart.accept(visitor);
        if(Condition!=null) Condition.accept(visitor);
        if(WhileCondEnd!=null) WhileCondEnd.accept(visitor);
        if(Statement!=null) Statement.accept(visitor);
        if(WhileEnd!=null) WhileEnd.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(WhileKeyWord!=null) WhileKeyWord.traverseTopDown(visitor);
        if(WhileCondStart!=null) WhileCondStart.traverseTopDown(visitor);
        if(Condition!=null) Condition.traverseTopDown(visitor);
        if(WhileCondEnd!=null) WhileCondEnd.traverseTopDown(visitor);
        if(Statement!=null) Statement.traverseTopDown(visitor);
        if(WhileEnd!=null) WhileEnd.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(WhileKeyWord!=null) WhileKeyWord.traverseBottomUp(visitor);
        if(WhileCondStart!=null) WhileCondStart.traverseBottomUp(visitor);
        if(Condition!=null) Condition.traverseBottomUp(visitor);
        if(WhileCondEnd!=null) WhileCondEnd.traverseBottomUp(visitor);
        if(Statement!=null) Statement.traverseBottomUp(visitor);
        if(WhileEnd!=null) WhileEnd.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("StatementWhile(\n");

        if(WhileKeyWord!=null)
            buffer.append(WhileKeyWord.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(WhileCondStart!=null)
            buffer.append(WhileCondStart.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Condition!=null)
            buffer.append(Condition.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(WhileCondEnd!=null)
            buffer.append(WhileCondEnd.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Statement!=null)
            buffer.append(Statement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(WhileEnd!=null)
            buffer.append(WhileEnd.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [StatementWhile]");
        return buffer.toString();
    }
}
