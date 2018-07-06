package model;

import model.Data;

public class VarTypeData extends Data {
    private final int type;

    public VarTypeData(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }
}
