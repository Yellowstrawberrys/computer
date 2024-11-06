package net.yellowstrawberry.cpu;

import net.yellowstrawberry.program.Task;

public class ShortestRemainingTimeFirstCPU extends ShortestJobFirstCPU{

    @Override
    protected void schedule(Task task) {
        if(this.getCurrentTask() == null || this.getCurrentTask().duration() > task.duration()) setTask(task);
    }
}
