package model;

import utils.FunctionContainer;
import utils.JasminHelper;

public class FunctionData extends ParserData {

    private final FunctionContainer functionContainer;

    /**
     * Main method function.
     * @param block main blockData.
     */
    public FunctionData(ParserData block) {
        super(block.getCtx());
        functionContainer = JasminHelper.getFunctionContainer(getCtx());
        appendCode(block);
    }

    public FunctionContainer getFunctionContainer() {
        return functionContainer;
    }
}
