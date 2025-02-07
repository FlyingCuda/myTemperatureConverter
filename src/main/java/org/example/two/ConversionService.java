package org.example.two;

public class ConversionService {
    public static final String CELSIUS = "celsius";
    public static final String FAHRENHEIT = "fahrenheit";
    public static final String KELVIN = "kelvin";
    public static double result;

    public double getResult(String unit, double value, String unitTo){

        if (unit.equals(ConversionService.CELSIUS) && (unitTo.equals(ConversionService.FAHRENHEIT))) {
            result = (value * 9 / 5) + 32;
        } else if (unit.equals(ConversionService.CELSIUS) && (unitTo.equals(ConversionService.KELVIN))) {
            result = (value + 273.15);
        } else if (unit.equals(ConversionService.FAHRENHEIT) && (unitTo.equals(ConversionService.CELSIUS))) {
            result = ((value - 32) * 5) / 9;
        } else if (unit.equals(ConversionService.FAHRENHEIT) && (unitTo.equals(ConversionService.KELVIN))) {
            result = (value + 459.67) * 0.55556;
        } else if (unit.equals(ConversionService.KELVIN) && (unitTo.equals(ConversionService.CELSIUS))) {
            result = (value - 273.15);
        } else if (unit.equals(ConversionService.KELVIN) && (unitTo.equals(ConversionService.FAHRENHEIT))) {
            result = (1.8 * value) - 459.67;
        } else if (unit.equals(unitTo)){
            result = value;
        } else {
            System.out.println("Incorrect input, u idiot");
        }


        return result;


    }
}



