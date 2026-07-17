package com.agentlens.core.workflow;

/**
 * Workflow 步骤——工作流中的一个执行单元。
 */
public abstract class WorkflowStep {

    private String name;
    private String description;

    public WorkflowStep(String name, String description) {
        this.name = name;
        this.description = description;
    }

    /**
     * 执行此步骤
     * @param input 上一步的输出，作为本步骤的输入
     * @return 本步骤的输出
     */
    public abstract String execute(String input);

    public String getName() { return name; }
    public String getDescription() { return description; }
}
