

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import javax.lang.model.util.ElementScanner6;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;


public class Robot extends TimedRobot {

  

  // Joysticks
  Joystick _joystick = new Joystick(0); 
  Joystick _joystick2 = new Joystick(1);
  //
  // Left motors
  Spark _leftFront = new Spark(0); 
  Spark _leftBack = new Spark(1);
  SpeedControllerGroup left = new SpeedControllerGroup(_leftFront, _leftBack);
  //
  Spark _rightFront = new Spark(2); 
  Spark _rightBack = new Spark(3); 
  SpeedControllerGroup right = new SpeedControllerGroup(_rightFront, _rightBack);
  DifferentialDrive _maindrive = new DifferentialDrive(left, right); 
  Spark _lift = new Spark(4);

  DigitalInput liftStop = new DigitalInput(0);

  @Override
  public void robotInit() {

  }


  @Override
  public void teleopInit() {
  }


  @Override
  public void teleopPeriodic() {
    double y = _joystick.getRawAxis(1);
    double z = _joystick.getRawAxis(2);
    _maindrive.arcadeDrive(y, z); 

    if(_joystick2.getRawButton(0))
      _lift.set(-.3);
    else if(_joystick2.getRawButton(1))
      _lift.set(.5); 
    else if(liftStop.get())
      _lift.set(0);
    else 
      _lift.set(0);



  }


  @Override
  public void testInit() {
  }


  @Override
  public void testPeriodic() {
  }


}
