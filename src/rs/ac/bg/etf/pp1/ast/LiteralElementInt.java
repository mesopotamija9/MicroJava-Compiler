// generated with ast extension for cup
// version 0.8
// 15/0/2023 21:44:9


package rs.ac.bg.etf.pp1.ast;

public class LiteralElementInt extends LiteralE {

    private Integer literalValue;

    public LiteralElementInt (Integer literalValue) {
        this.literalValue=literalValue;
    }

    public Integer getLiteralValue() {
        return literalValue;
    }

    public void setLiteralValue(Integer literalValue) {
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
        buffer.append("LiteralElementInt(\n");

        buffer.append(" "+tab+literalValue);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [LiteralElementInt]");
        return buffer.toString();
    }
}
