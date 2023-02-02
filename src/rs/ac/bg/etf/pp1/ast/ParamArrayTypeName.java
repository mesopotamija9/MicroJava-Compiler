// generated with ast extension for cup
// version 0.8
// 15/0/2023 21:44:9


package rs.ac.bg.etf.pp1.ast;

public class ParamArrayTypeName extends ParTypeName {

    private Type Type;
    private String paramArrayName;

    public ParamArrayTypeName (Type Type, String paramArrayName) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.paramArrayName=paramArrayName;
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public String getParamArrayName() {
        return paramArrayName;
    }

    public void setParamArrayName(String paramArrayName) {
        this.paramArrayName=paramArrayName;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Type!=null) Type.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ParamArrayTypeName(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(" "+tab+paramArrayName);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ParamArrayTypeName]");
        return buffer.toString();
    }
}
