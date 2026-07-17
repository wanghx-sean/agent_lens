# Workflow 模块

## 职责

多步骤工作流编排——将多个 Agent 步骤串联成自动化流程。

## 核心概念

```java
Workflow {
    String name;
    List<WorkflowStep> steps;

    String execute();  // 顺序执行所有步骤
}

abstract class WorkflowStep {
    String name;
    String description;
    abstract String execute(String input);  // 上一步输出 → 本步输入
}
```

## 设计思路

- **管道模式** — 每一步的输出是下一步的输入
- **可编排** — 步骤可组合、可复用
- **可见性** — 每一步的输入输出可在前端 Execution 面板查看

## 示例工作流

```
User Input → Prompt → Context → Search → LLM → Tool → LLM → Answer
```

## 后续规划

- [ ] 图形化 Workflow 编排界面
- [ ] 条件分支（if/else）
- [ ] 循环步骤
- [ ] 并行步骤
- [ ] 步骤断点续执行
