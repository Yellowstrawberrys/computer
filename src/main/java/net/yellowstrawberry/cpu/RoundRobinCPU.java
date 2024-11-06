package net.yellowstrawberry.cpu;

import net.yellowstrawberry.program.Task;

public class RoundRobinCPU extends CPUScheduleSystem{

    int currentIndex = 0;

    @Override
    protected Task getCurrentTask() {
        return getTasks().get(currentIndex);
    }

    @Override
    public void run() {
        super.run();
        if(currentIndex < getTasks().size()) currentIndex++;
        else currentIndex = 0;
    }

    @Override
    protected Task nextTask() {
        return null;
    }
}
