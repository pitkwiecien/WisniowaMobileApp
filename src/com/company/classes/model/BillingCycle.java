package com.company.classes.model;

public enum BillingCycle {
    DAY_1, DAY_4, DAY_7, DAY_11, DAY_14, DAY_17, DAY_21, DAY_24, DAY_27, DAY_LAST;

    public int toInt() {
        if(!this.name().equals(DAY_LAST.name()))
            return Integer.parseInt(this.name().substring(4));
        return -1;
    }

    public static BillingCycle toBillingCycle(Object object) {
        int integer = Integer.parseInt(object.toString());
        String string = integer == -1 ? "DAY_LAST" : ("DAY_" + integer);
        return BillingCycle.valueOf(string);
    }
}