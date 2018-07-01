package model;

import model.Data;

public class TokenData extends Data {
    private final int type;

    public TokenData(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }
}
