package honeycrisp.subsystems;

import java.util.function.DoubleFunction;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;

public class PidControllerBuilder {
    private PIDSource pidSource;
    private double p, i, d;
    private PIDOutput pidOutput;
    private Double setPoint;
    private DoubleFunction<Double> setPointConversionFunc;
    private double minInput, maxInput, minOutput, maxOutput;

    public PidControllerBuilder(PIDSource source){
        this.pidSource = source;
        this.setPointConversionFunc = d -> d;
    }

    public PidControllerBuilder(PIDSource source, DoubleFunction<Double> setPointConversionFunc){
        this.pidSource = source;
        this.setPointConversionFunc = setPointConversionFunc;
    }

    public PidControllerBuilder withPidValues(double p, double i, double d){
        this.p = p;
        this.i = i;
        this.d = d;
        return this;
    }

    public PidControllerBuilder withPIDOutput(PIDOutput output){
        this.pidOutput = output;
        return this;
    }

    public PidControllerBuilder withSetPoint(Double setPoint){
        this.setPoint = setPointConversionFunc.apply(setPoint);
        return this;
    }

    public PidControllerBuilder withInputRange(Double min, Double max){
        this.minInput = min;
        this.maxInput = max;
        return this;
    }

    public PidControllerBuilder withOutputRange(Double min, Double max){
        this.minOutput = min;
        this.maxOutput = max;
        return this;
    }

    public PIDController createPidController(){
        if (setPoint == null){
            throw new RuntimeException("Setpoint not specified");
        }

        PIDController controller = new PIDController(p, i, d, pidSource, pidOutput);
        controller.setSetpoint(setPoint);
        controller.setInputRange(minInput, maxInput);
        controller.setOutputRange(minOutput, maxOutput);

        return controller;
    }
}