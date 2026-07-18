# AgentLens 架构设计

## 整体架构

```
┌──────────────────────────┐     REST/WebSocket    ┌──────────────────────────┐
│   Vue 3 + Electron       │  ←──────────────────→ │   Spring Boot 3         │
│   (Perspective UI)        │                       │   (Agent Engine)         │
│                           │                       │                          │
│   Workspace Perspective  │                       │   llm / prompt           │
│   Agent Center           │                       │   context / memory       │
│   Context Manager        │                       │   task / agent / diff    │
│   Change Review          │                       │   tool / workflow        │
│   Agent Monitor          │                       │                          │
│   Knowledge Center       │                       │                          │
│   Task Board             │                       │                          │
└──────────────────────────┘                       └──────────────────────────┘
```

## UI 架构（Perspective + Dock）

主界面采用 IDEA 风格的侧边工具窗口模式：

```
+------------------------------------------------+
| Menu Bar                                       |
+------------------------------------------------+
| Toolbar (🤖 📋 🔍 📊 📚 📌)                   |
+------------------------------------------------+
|        |                         |  [🤖] [📋]  |
| Project|   Code Workspace        |  [🔍] [📊]  |
|Explorer|                         |  [📚] [📌]  |
|        |                         |  ← 工具按钮条 |
+--------+-------------------------+-------------+
| Terminal / Task Log / Git                      |
+------------------------------------------------+
```

点击右侧按钮 → 停靠窗口以 Tab 形式展开。

## 后端包结构

```
com.agentlens/
├── AgentLensApplication.java    # 启动类
├── config/WebConfig.java        # CORS 配置
├── api/
│   ├── HealthController.java    # GET /api/health
│   ├── LlmController.java       # POST /api/llm/chat
│   ├── PromptController.java    # CRUD /api/prompts
│   ├── TaskController.java      # 🔜 CRUD /api/tasks
│   ├── AgentController.java     # 🔜 /api/agents
│   ├── DiffController.java      # 🔜 /api/diffs
│   └── ContextController.java   # 🔜 /api/context
└── core/
    ├── llm/                     # LLM 集成层
    ├── prompt/                  # Prompt 模板管理
    ├── context/                 # 上下文管理
    ├── memory/                  # 记忆管理
    ├── task/                    # 任务管理（新）
    ├── agent/                   # Agent 实例（新）
    ├── diff/                    # Diff 审核（新）
    ├── tool/                    # Tool Calling
    └── workflow/                # 工作流编排
```

## 新增模块说明

| 模块 | 核心类 | 用途 |
|------|--------|------|
| task | AgentTask / TaskRepository / TaskService | 任务创建、状态流转、看板数据 |
| agent | AgentInstance / AgentService | 多 Agent 状态追踪 |
| diff | DiffEntry / DiffService | Agent 代码变更审核（Accept/Reject） |

## 前端-后端对应关系

| 前端 Perspective | 后端 API | 状态 |
|---|---|---|
| Workspace | 暂无（文件浏览后续） | ✅ 骨架 |
| Agent Center | LlmController + TaskService | 🟡 待实现 |
| Context Manager | ContextManager（需加 Controller） | 🔜 |
| Change Review | DiffService | 🟡 骨架 |
| Agent Monitor | AgentService | 🟡 骨架 |
| Knowledge Center | MemoryService（需加 Controller） | 🔜 |
| Task Board | TaskService | 🟡 骨架 |
