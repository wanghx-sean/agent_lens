package com.agentlens.core.agent;

/**
 * Agent 实例模型——表示一个正在运行的 Agent。
 *
 * 每个 Agent 有名称、状态、当前任务、启动时间等。
 * 对应前端 Agent Monitor 面板。
 */
public class AgentInstance {

    private String id;
    private String name;       // Planner Agent, Coding Agent, ...
    private String status;     // RUNNING, WAITING, COMPLETED, ERROR
    private String currentTask;
    private long startedAt;
    private long durationMs;

    public AgentInstance() {}

    public AgentInstance(String name, String status) {
        this.name = name;
        this.status = status;
        this.startedAt = System.currentTimeMillis();
    }

    // @claude [todo] 补充 getters/setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getCurrentTask() { return currentTask; }
    public void setCurrentTask(String currentTask) { this.currentTask = currentTask; }
    public long getStartedAt() { return startedAt; }
    public void setStartedAt(long startedAt) { this.startedAt = startedAt; }
    public long getDurationMs() { return durationMs; }
    public void setDurationMs(long durationMs) { this.durationMs = durationMs; }
}
