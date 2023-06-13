package org.example;

import java.util.ArrayList;
import java.util.List;

public class RunTimeStatistics {
    class RunTimePoint{
        private long StartTimePoint;
        private long EndTimePoint;
        private String TaskDescription;
    }
    public String projectName;
    private List <RunTimePoint> runTimePoints;
    public RunTimeStatistics(String projectName){
        List <RunTimePoint> runTimePoints = new ArrayList<>();
        this.runTimePoints = runTimePoints;
        this.projectName = projectName;
    }

    public List getRunTimePoints() {
        return runTimePoints;
    }

    public boolean addRunTimePoint(long StartTimePoint, long EndTimePoint, String TaskDescription) {
        RunTimePoint timePoint = new RunTimePoint();
        timePoint.StartTimePoint = StartTimePoint;
        timePoint.EndTimePoint = EndTimePoint;
        timePoint.TaskDescription = TaskDescription;
        return runTimePoints.add(timePoint);

    }
    public void printRunTimeStatistics(){
        System.out.println("Measurement results for: " + projectName);
        if (this.runTimePoints.size() == 0){
            System.out.println("Measurement results are empty! \n");
        }else {
            for (Object o : this.runTimePoints) {
                if (o instanceof RunTimePoint) {
                    RunTimePoint myPoint = (RunTimePoint) o;
                    long runTime = myPoint.EndTimePoint - myPoint.StartTimePoint;
                    System.out.println(myPoint.TaskDescription + " :" + runTime + "ns");
                }
            }
        }
    }
}
