// generated with ast extension for cup
// version 0.8
// 15/0/2023 21:44:9


package rs.ac.bg.etf.pp1.ast;

public class FactorFunctionCallWithParams extends Factor {

    private FunctionCallName FunctionCallName;
    private ActPars ActPars;

    public FactorFunctionCallWithParams (FunctionCallName FunctionCallName, ActPars ActPars) {
        this.FunctionCallName=FunctionCallName;
        if(FunctionCallName!=null) FunctionCallName.setParent(this);
        this.ActPars=ActPars;
        if(ActPars!=null) ActPars.setParent(this);
    }

    public FunctionCallName getFunctionCallName() {
        return FunctionCallName;
    }

    public void setFunctionCallName(FunctionCallName FunctionCallName) {
        this.FunctionCallName=FunctionCallName;
    }

    public ActPars getActPars() {
        return ActPars;
    }

    public void setActPars(ActPars ActPars) {
        this.ActPars=ActPars;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(FunctionCallName!=null) FunctionCallName.accept(visitor);
        if(ActPars!=null) ActPars.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(FunctionCallName!=null) FunctionCallName.traverseTopDown(visitor);
        if(ActPars!=null) ActPars.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(FunctionCallName!=null) FunctionCallName.traverseBottomUp(visitor);
        if(ActPars!=null) ActPars.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FactorFunctionCallWithParams(\n");

        if(FunctionCallName!=null)
            buffer.append(FunctionCallName.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ActPars!=null)
            buffer.append(ActPars.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FactorFunctionCallWithParams]");
        return buffer.toString();
    }
}
