// generated with ast extension for cup
// version 0.8
// 15/0/2023 21:44:9


package rs.ac.bg.etf.pp1.ast;

public class Designator implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    public rs.etf.pp1.symboltable.concepts.Obj obj = null;

    private DesignatorMultiple DesignatorMultiple;

    public Designator (DesignatorMultiple DesignatorMultiple) {
        this.DesignatorMultiple=DesignatorMultiple;
        if(DesignatorMultiple!=null) DesignatorMultiple.setParent(this);
    }

    public DesignatorMultiple getDesignatorMultiple() {
        return DesignatorMultiple;
    }

    public void setDesignatorMultiple(DesignatorMultiple DesignatorMultiple) {
        this.DesignatorMultiple=DesignatorMultiple;
    }

    public SyntaxNode getParent() {
        return parent;
    }

    public void setParent(SyntaxNode parent) {
        this.parent=parent;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line=line;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DesignatorMultiple!=null) DesignatorMultiple.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesignatorMultiple!=null) DesignatorMultiple.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesignatorMultiple!=null) DesignatorMultiple.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Designator(\n");

        if(DesignatorMultiple!=null)
            buffer.append(DesignatorMultiple.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [Designator]");
        return buffer.toString();
    }
}
