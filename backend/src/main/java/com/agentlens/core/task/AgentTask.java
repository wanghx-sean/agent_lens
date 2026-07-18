package com.agentlens.core.task;

/**
 * 任务模型——Agent 任务的核心定义。
 *
 * 每个任务包含名称、描述、状态和关联的 Agent 执行信息。
 * 对应前端 Task Board 和 Agent Center 的任务管理功能。
 */
public class AgentTask {

    private String id;
    private String name;
    private String description;
    private String status; // TODO, RUNNING, DONE
    private String agentId;
    private long createdAt;
    private long updatedAt;

    public AgentTask() {}

    public AgentTask(String name, String description) {
        this.name = name;
        this.description = description;
        this.status = "TODO";
        this.createdAt = System.currentTimeMillis();
        this.updatedAt = this.createdAt;
    }

    // @claude [todo] 补充 getters/setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getAgentId() { return agentId; }
    public void setAgentId(String agentId) { this.agentId = agentId; }
    public long getCreatedAt() { return createdAt; }
    public void setCreatedAt(long createdAt) { this.createdAt = createdAt; }
    public long getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(long updatedAt) { this.updatedAt = updatedAt; }
}
