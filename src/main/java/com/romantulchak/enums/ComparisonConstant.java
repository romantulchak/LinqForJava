package com.romantulchak.enums;

public enum ComparisonConstant {
    EQUAL("="),
    MORE_THAN(">"),
    LESS_THAN("<"),
    MORE_OR_EQUAL(">="),
    LESS_OR_EQUAL("<="),
    NOT_EQUAL("<>");

    private final String symbol;

    ComparisonConstant(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
