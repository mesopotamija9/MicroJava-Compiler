// generated with ast extension for cup
// version 0.8
// 15/0/2023 21:44:9


package rs.ac.bg.etf.pp1.ast;

public class FactorFunctionCallNoParams extends Factor {

    private FunctionCallName FunctionCallName;

    public FactorFunctionCallNoParams (FunctionCallName FunctionCallName) {
        this.FunctionCallName=FunctionCallName;
        if(FunctionCallName!=null) FunctionCallName.setParent(this);
    }

    public FunctionCallName getFunctionCallName() {
        return FunctionCallName;
    }

    public void setFunctionCallName(FunctionCallName FunctionCallName) {
        this.FunctionCallName=FunctionCallName;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(FunctionCallName!=null) FunctionCallName.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(FunctionCallName!=null) FunctionCallName.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(FunctionCallName!=null) FunctionCallName.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FactorFunctionCallNoParams(\n");

        if(FunctionCallName!=null)
            buffer.append(FunctionCallName.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FactorFunctionCallNoParams]");
        return buffer.toString();
    }
}
