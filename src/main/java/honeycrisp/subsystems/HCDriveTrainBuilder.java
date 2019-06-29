package honeycrisp.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;

public abstract class HCDriveTrainBuilder<T extends HCDriveTrain> {
    private WPI_TalonSRX lfTalon;
    private WPI_TalonSRX rfTalon;
    private WPI_TalonSRX lrTalon;
    private WPI_TalonSRX rrTalon;
    private AnalogInput distanceSensor;
    private ADXRS450_Gyro gyro;

    public HCDriveTrainBuilder(){
    }

    public HCDriveTrainBuilder<T> addLfSpeedControler(int canId){
        lfTalon = new WPI_TalonSRX(canId);
        return this;
    }

    public HCDriveTrainBuilder<T> addRfSpeedControler(int canId){
        rfTalon = new WPI_TalonSRX(canId);
        return this;
    }

    public HCDriveTrainBuilder<T> addLrSpeedControler(int canId){
        lrTalon = new WPI_TalonSRX(canId);
        return this;
    }
    
    public HCDriveTrainBuilder<T> addRrSpeedControler(int canId){
        rrTalon = new WPI_TalonSRX(canId);
        return this;
    }

    public HCDriveTrainBuilder<T> addDistanceSensor(int id){
        distanceSensor = new AnalogInput(id);
        return this;
    }

    public HCDriveTrainBuilder<T> addGyro(){
        gyro = new ADXRS450_Gyro();
        return this;
    }

    public T build(){
        T dt = newDriveTrain(lfTalon,rfTalon,lrTalon,rrTalon);
        dt.setDistanceSensor(distanceSensor);
        return dt;
    }

    abstract protected T newDriveTrain(WPI_TalonSRX leftFront,  WPI_TalonSRX rightFront,  WPI_TalonSRX leftRear,  WPI_TalonSRX rightRear);
}