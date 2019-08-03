package honeycrisp.util;

public class AnalogValueConverter{
    private static final double  dsConversionConstant =  0.009766;

    public static  double inchesToVoltage(double numInches){
        return  numInches * dsConversionConstant;
    }

    public static double voltageToInches(double voltage){
        return voltage / dsConversionConstant;
    }
}

