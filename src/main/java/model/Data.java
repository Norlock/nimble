package model;

import java.util.ArrayList;

public abstract class Data {
    protected ArrayList<String> jasminCode = new ArrayList<>();

    public ArrayList<String> getJasminCode() {
        return jasminCode;
    }

    /**
     * Loads numeric type on stack (e.g. iconst_3;
     * @param value
     * @return
     */
    public void loadIntegerOntoStack(int value) {
        if (0 <= value && value <= 5) {
            jasminCode.add(JasminConstants.INTEGER_CONST + value);
        } else if (value == -1) {
            jasminCode.add(JasminConstants.INTEGER_CONST + "m1");
        } else {
            jasminCode.add(JasminConstants.INTEGER_ADD + value);
        }
    }

    public void loadBooleanOnStack(boolean value) {
        if(value)
            jasminCode.add(JasminConstants.INTEGER_CONST + JasminConstants.TRUE);
        else
            jasminCode.add(JasminConstants.INTEGER_CONST + JasminConstants.FALSE);
    }

    public void loadDoubleOntoStack(double value) {
        jasminCode.add(JasminConstants.DOUBLE_ADD + value);
    }

    public void loadStringOntoStack(String value) {
        jasminCode.add(JasminConstants.STRING_ADD + value);
    }

    /**
     *
     * @param prefix (integer/double/boolean/string)
     * @param storeIndex
     * @return
     */
    public void setStore(JasminConstants.Prefix prefix, int storeIndex) {
        if(0 <= storeIndex && storeIndex <= 3) {
            jasminCode.add(prefix.toString() + JasminConstants.STORE_VAl_SMALL + storeIndex);
        } else {
            jasminCode.add(prefix.toString() + JasminConstants.STORE_VAL + storeIndex);
        }
    }

    public void setLoad(JasminConstants.Prefix prefix, int storeIndex) {
        if(0 <= storeIndex && storeIndex <= 3) {
            jasminCode.add(prefix.toString() + JasminConstants.LOAD_VAL_SMALL + storeIndex);
        } else {
            jasminCode.add(prefix.toString() + JasminConstants.LOAD_VAL + storeIndex);
        }
    }
}
