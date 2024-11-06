package net.yellowstrawberry.program;

public class SimpleTask implements Task {

    private final int id,priority;
    private int duration;

    public SimpleTask(int id, int priority, int duration) {
        this.id = id;
        this.priority = priority;
        this.duration = duration;
    }

    @Override
    public int id() {
        return id;
    }

    @Override
    public int priority() {
        return priority;
    }

    @Override
    public int duration() {
        return duration;
    }

    @Override
    public void run() {
        duration--;
    }

    @Override
    public String toString() {
        return "SimpleTask{" +
                "id=" + id +
                ", priority=" + priority +
                ", duration=" + duration +
                '}';
    }
}
