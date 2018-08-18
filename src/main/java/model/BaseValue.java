package model;

import generated.NimbleParser;
import org.antlr.v4.runtime.ParserRuleContext;


public abstract class BaseValue extends ParserData {


    protected BaseValue(ParserRuleContext ctx) {
        super(ctx);
    }

    public abstract int getVarType();
    public boolean isType(int type) {
        return type == getVarType();
    }

}
