package net.yellowstrawberry;

import net.yellowstrawberry.cpu.CPUScheduleSystem;
import net.yellowstrawberry.cpu.HighestResponseRatioNextCPU;
import net.yellowstrawberry.cpu.RoundRobinCPU;
import net.yellowstrawberry.program.SimpleTask;
import net.yellowstrawberry.program.Task;
import net.yellowstrawberry.utils.MutableInteger;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        CPUScheduleSystem cpuScheduleSystem = new RoundRobinCPU();

        cpuScheduleSystem.scheduleTask(new SimpleTask(0, 0, 10));
        cpuScheduleSystem.scheduleTask(new SimpleTask(1, 0, 10));

        int cycle = 0;

        while (true) {
            if(cycle == 13) cpuScheduleSystem.scheduleTask(new SimpleTask(2, 0, 4));
            if(cycle == 10) cpuScheduleSystem.scheduleTask(new SimpleTask(3, 0, 4));
            System.out.printf("\n---- CPU Cycle %d ----%n", cycle++);
            cpuScheduleSystem.run();
            for(Task task : cpuScheduleSystem.getTasks()) {
                System.out.println(task);
            }
            System.out.println("----------------------\n");
            if(cpuScheduleSystem.getTasks().isEmpty()) break;
            Thread.sleep(1000);
        }
        
    }
}