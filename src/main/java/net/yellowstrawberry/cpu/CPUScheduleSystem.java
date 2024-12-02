package net.yellowstrawberry.cpu;

import net.yellowstrawberry.program.Task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class CPUScheduleSystem {

    private final Map<Integer, Task> taskMap = new HashMap<>();
    private final List<Task> tasks = new ArrayList<>();
    private Task task;


    public void scheduleTask(Task task) {
        tasks.add(task);
        taskMap.put(task.id(), task);
        schedule(task);
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public Task getTaskById(int id) {
        return taskMap.get(id);
    }

    protected void runTask(int id) {
        taskMap.get(id).run();
    }

    protected void removeTask(int id) {
        Task task = taskMap.remove(id);
        tasks.remove(task);
    }


    protected Task getCurrentTask() {
        return task;
    }

    protected void setTask(Task task) {
        this.task = task;
    }

    /**
     * In this method, ONLY ONE TURN should be processed.
     * */
    public void run() {
        getCurrentTask().run();
        if(getCurrentTask().duration() < 1) {
            removeTask(getCurrentTask().id());
            setTask(nextTask());
        }
    }

    protected void schedule(Task task) {
        if(getCurrentTask() == null) setTask(task);
    }

    protected abstract Task nextTask();
}
