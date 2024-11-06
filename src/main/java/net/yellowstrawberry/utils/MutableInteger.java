package net.yellowstrawberry.utils;

public class MutableInteger extends Number {
    
    private int value = 0;
    
    @Override
    public int intValue() {
        return value;
    }

    @Override
    public long longValue() {
        return value;
    }

    @Override
    public float floatValue() {
        return value;
    }

    @Override
    public double doubleValue() {
        return value;
    }
    
    public void increase() {
        value++;
    }

    public void decrease() {
        value--;
    }
}
