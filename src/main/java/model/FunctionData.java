package model;

import generated.NimbleParser;
import utils.JasminConstants;

public class FunctionData extends ParserData {

    private String methodName;
    private JasminConstants.DataType returnValue;

    public FunctionData(NimbleParser.FunctionContext ctx, String methodName, JasminConstants.DataType returnValue) {
        super(ctx);
        this.methodName = methodName;
        this.returnValue = returnValue;
    }

    public String getMethodName() {
        return methodName;
    }

    public JasminConstants.DataType getReturnValue() {
        return returnValue;
    }
}
