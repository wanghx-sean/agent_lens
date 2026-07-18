# 项目交接清单

## 删除了哪些文件（旧 6 面板架构）

```
frontend/src/views/ChatView.vue          → 被 AgentCenterView 替代
frontend/src/views/ContextView.vue       → 被 ContextManagerView 替代
frontend/src/views/ExecutionView.vue     → 合并到底部 ExecutionFlow 组件
frontend/src/views/MemoryView.vue        → 被 AgentMonitorView / KnowledgeCenter 覆盖
frontend/src/views/TokenView.vue         → 合并到 ContextPanel
frontend/src/views/PromptView.vue        → 保留，后续 Prompt Tab 用
frontend/src/stores/llm.js               → 旧 Pinia Store
```

## 新增了哪些文件

### 前端
```
App.vue                  — 重写：Perspective + Dock 架构
AgentCenterView.vue      — Agent 中心（任务 + 流程 + 对话）
ContextManagerView.vue   — 上下文管理（文件 + Token）
ChangeReviewView.vue     — 修改审核（Before/After）
AgentMonitorView.vue     — Agent 监控（多 Agent 状态）
KnowledgeCenterView.vue  — 知识中心
TaskBoardView.vue        — 任务看板
i18n.js + locales/*      — 中英文国际化
```

### 后端
```
core/task/AgentTask.java       — 任务模型
core/task/TaskRepository.java  — 任务存储
core/task/TaskService.java     — 任务业务逻辑（TODO）
core/agent/AgentInstance.java  — Agent 实例模型
core/agent/AgentService.java   — Agent 管理（TODO）
core/diff/DiffEntry.java       — Diff 记录模型
core/diff/DiffService.java     — Diff 审核服务（TODO）
```

## 需要你实现的代码

### TaskService（TODO 标记）
- `createTask(name, description)` — 创建任务，状态初始 TODO
- `updateStatus(id, status)` — 更新任务状态流转

### AgentService（TODO 标记）
- `register(name)` — 注册新 Agent，状态 WAITING
- `updateStatus(id, status)` — 更新 Agent 状态并记录耗时

### DiffService（TODO 标记）
- `recordChange(filePath, before, after)` — 记录代码变更，状态 PENDING
- `approve(id)` / `reject(id)` — 审核操作

### 后续还需要加的 Controller
- TaskController（/api/tasks）
- AgentController（/api/agents）
- DiffController（/api/diffs）
- ContextController（/api/context）
- MemoryController（/api/memory）
