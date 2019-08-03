package frc.robot.commands;

import java.util.Arrays;
import java.util.List;
import java.util.function.DoubleFunction;

public class MockInputSource {
    private List<Double> list;
    private int idx = 0;
    private DoubleFunction<Double> converter;

    public MockInputSource(DoubleFunction<Double> func, Double ... values ){
        list = Arrays.asList(values);
        converter = func;
    }

    public MockInputSource(Double ... values){
       list = Arrays.asList(values);
       converter = d -> d;
    }

    public Double nextValue(){
        
        if (idx == list.size()){
            return converter.apply(list.get(list.size() - 1));
        } else {
            return converter.apply(list.get(idx++));
        }
    }

    public boolean isDone(){
        return idx == list.size();
    }

    public boolean isStarted(){
        return idx != 0;
    }

    public void reset(){
        idx = 0;
    }
}