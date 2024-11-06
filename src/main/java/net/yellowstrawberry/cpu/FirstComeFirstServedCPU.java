package net.yellowstrawberry.cpu;

import net.yellowstrawberry.program.Task;

public class FirstComeFirstServedCPU extends CPUScheduleSystem {

    @Override
    public void schedule(Task task) {}

    @Override
    protected Task nextTask() {
        return getTasks().get(0);
    }
}
