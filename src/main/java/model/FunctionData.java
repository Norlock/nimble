package model;

import generated.NimbleParser;
import org.antlr.v4.runtime.ParserRuleContext;
import utils.FunctionContainer;
import utils.JasminHelper;

public class FunctionData extends ParserData {

    private final FunctionContainer functionContainer;

    private FunctionData(ParserRuleContext ctx) {
        super(ctx);
        functionContainer = JasminHelper.getFunctionContainer(ctx);
    }

    public FunctionData(NimbleParser.FunctionContext ctx) {
        this((ParserRuleContext) ctx);
    }

    public FunctionData(ParserData block) {
        this(block.getCtx());
        appendCode(block);

        // Set return type voor main.
        functionContainer.setReturnType(NimbleParser.VOID);

        // Handmatig zetten aangezien geen nimble data type.
        functionContainer.appendConstructorParam("[Ljava/lang/String;");
    }

    public FunctionContainer getFunctionContainer() {
        return functionContainer;
    }
}
