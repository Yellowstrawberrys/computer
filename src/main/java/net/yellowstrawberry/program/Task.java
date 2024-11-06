package net.yellowstrawberry.program;

public interface Task {
    int id();
    int priority();
    int duration();
    void run();
}
