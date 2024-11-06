package net.yellowstrawberry.cpu;

import net.yellowstrawberry.program.Task;
import net.yellowstrawberry.utils.MutableInteger;

import java.util.HashMap;
import java.util.Map;

public class HighestResponseRatioNextCPU extends CPUScheduleSystem {

    private final Map<Integer, MutableInteger> waiting = new HashMap<>();

    @Override
    public void run() {
        super.run();
        waiting.values().forEach(MutableInteger::increase);
    }

    @Override
    protected void schedule(Task task) {
        super.schedule(task);
        waiting.put(task.id(), new MutableInteger());
    }

    @Override
    protected Task nextTask() {
        if(getTasks().isEmpty()) return null;
        Task target = getTasks().get(0);
        for(int i = 1; i < getTasks().size(); i++) {
            if(ratio(getTasks().get(i)) > ratio(target)) {
                target = getTasks().get(i);
            }
        }
        return target;
    }

    @Override
    protected void removeTask(int id) {
        waiting.remove(id);
        super.removeTask(id);
    }

    private double ratio(Task task) {
        return (double) (task.duration() + waiting.get(task.id()).intValue()) / task.duration();
    }
}
