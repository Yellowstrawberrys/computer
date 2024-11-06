package net.yellowstrawberry.cpu;

import net.yellowstrawberry.program.Task;

public class ShortestJobFirstCPU extends CPUScheduleSystem{

    @Override
    protected void schedule(Task task) {
        if(super.getCurrentTask() == null) this.setTask(task);
    }

    @Override
    protected Task nextTask() {
        if(getTasks().isEmpty()) return null;

        Task task = getTasks().get(0);
        for(int i = 1; i < getTasks().size(); i++) {
            if(task.duration() > getTasks().get(i).duration()) {
                task = getTasks().get(i);
            }
        }
        return task;
    }
}
