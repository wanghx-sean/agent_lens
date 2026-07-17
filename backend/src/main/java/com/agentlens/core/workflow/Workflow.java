package com.agentlens.core.workflow;

import java.util.*;

/**
 * Workflow 编排——将多个步骤串联成自动化流程。
 *
 * 例如：Plan → Execute → Review → Answer
 */
public class Workflow {

    private String name;
    private final List<WorkflowStep> steps = new ArrayList<>();

    public Workflow(String name) {
        this.name = name;
    }

    public void addStep(WorkflowStep step) {
        steps.add(step);
    }

    /**
     * 执行完整工作流
     */
    public String execute() {
        String result = null;
        for (WorkflowStep step : steps) {
            System.out.println("[Workflow] Executing step: " + step.getName());
            result = step.execute(result);
        }
        return result;
    }

    public String getName() { return name; }
    public List<WorkflowStep> getSteps() { return List.copyOf(steps); }
}
