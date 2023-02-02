// generated with ast extension for cup
// version 0.8
// 15/0/2023 21:44:9


package rs.ac.bg.etf.pp1.ast;

public class LiteralElementBool extends LiteralE {

    private Boolean literalValue;

    public LiteralElementBool (Boolean literalValue) {
        this.literalValue=literalValue;
    }

    public Boolean getLiteralValue() {
        return literalValue;
    }

    public void setLiteralValue(Boolean literalValue) {
        this.literalValue=literalValue;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("LiteralElementBool(\n");

        buffer.append(" "+tab+literalValue);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [LiteralElementBool]");
        return buffer.toString();
    }
}
