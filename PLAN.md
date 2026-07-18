# AgentLens 开发计划

## 阶段一：项目骨架 ✅ 已完成

- [x] Spring Boot 项目初始化（pom.xml + 启动类）
- [x] Web 配置（CORS）
- [x] 健康检查接口（/api/health）
- [x] Vue 3 + Electron + Vite 前端初始化
- [x] i18n 中英文切换
- [x] 全局样式（Catppuccin Mocha 暗色主题）

## 阶段二：UI 框架 ✅ 已完成

- [x] IDEA 风格布局（菜单栏 + 工具栏 + 侧按钮条 + 底部）
- [x] 7 Perspective 架构（Workspace / Agent Center / Context / Review / Monitor / Knowledge / Tasks）
- [x] 右侧停靠窗口（Tab 切换多面板）
- [x] Workspace 主界面（Project Explorer + 代码区）
- [x] Agent Center 视图（任务 + 执行流程 + 对话）
- [x] Context Manager 视图（上下文 + Token）
- [x] Change Review 视图（Before / After Diff）
- [x] Agent Monitor 视图（多 Agent 状态卡片）
- [x] Knowledge Center 视图（知识树）
- [x] Task Board 视图（Todo / Running / Done 看板）

---

## 阶段三：Prompt 管理 🟡 后端骨架完成

### 后端
- [x] PromptTemplate 模型定义
- [x] PromptRepository 内存存储（create / update / findById / findAll / delete）
- [x] PromptService 业务逻辑（版本初始化 + 递增）
- [x] PromptController REST API（GET / POST / PUT / DELETE）
- [ ] Prompt 返回 404 异常处理
- [ ] Prompt 模板持久化（文件 / 数据库）

### 前端
- [ ] PromptView 模板列表（在 Prompt Tab 中）
- [ ] 模板创建 / 编辑表单
- [ ] 删除确认对话框

---

## 阶段四：任务系统 🟡 后端骨架完成

- [x] AgentTask 模型
- [x] TaskRepository 内存存储
- [x] TaskService（TODO 骨架）
- [ ] TaskService 实现体（createTask / updateStatus）
- [ ] TaskController REST API
- [ ] 任务看板与后端联调

---

## 阶段五：Agent 管理与状态追踪 🟡 后端骨架完成

- [x] AgentInstance 模型
- [x] AgentService（TODO 骨架）
- [x] DiffEntry 模型
- [x] DiffService（TODO 骨架）
- [ ] AgentService 实现体
- [ ] DiffService 实现体
- [ ] AgentController REST API
- [ ] DiffController REST API
- [ ] Agent Monitor 与后端联调
- [ ] Change Review 与后端联调

---

## 阶段六：Context 与 Memory

- [ ] ContextManager 提升为 @Service + REST API
- [ ] MemoryManager 提升为 @Service + REST API
- [ ] ContextManagerController
- [ ] MemoryController
- [ ] 前端 Context Panel 与后端联调

---

## 阶段七：LLM 集成

- [ ] 引入 Spring AI / LangChain4j
- [ ] LlmService 真实实现（替换 LlmTestService）
- [ ] 流式响应（SSE / WebSocket）
- [ ] 模型参数配置化

---

## 阶段八：Tool Calling 与 Workflow

- [ ] AgentTool 接口 + ToolRegistry
- [ ] 内置工具（文件读写 / 命令行 / 代码搜索）
- [ ] Function Calling 与 LLM 联动
- [ ] Workflow 引擎（步骤编排 + 顺序执行）
- [ ] Workflow 可视化与 Execution Flow 联调

---

## 附录：当前项目文件结构

```
agent_lens/
├── README.md
├── PLAN.md
├── .gitignore
├── backend/src/main/java/com/agentlens/
│   ├── AgentLensApplication.java
│   ├── config/WebConfig.java
│   ├── api/
│   │   ├── HealthController.java
│   │   ├── LlmController.java
│   │   ├── PromptController.java
│   │   ├── TaskController.java        🔜
│   │   ├── AgentController.java       🔜
│   │   ├── DiffController.java        🔜
│   │   └── ContextController.java     🔜
│   └── core/
│       ├── llm/   (LlmService + LlmTestService + LlmConfig)
│       ├── prompt/ (PromptTemplate + Repository + Service)
│       ├── context/ (ContextItem + ContextManager)
│       ├── memory/ (MemoryManager)
│       ├── task/   (AgentTask + TaskRepository + TaskService)
│       ├── agent/  (AgentInstance + AgentService)
│       ├── diff/   (DiffEntry + DiffService)
│       ├── tool/   (AgentTool + ToolRegistry + Constants)
│       └── workflow/ (Workflow + WorkflowStep)
├── frontend/src/
│   ├── App.vue                        # 主布局（Perspective + Dock）
│   ├── main.js / router/index.js
│   ├── i18n.js + locales/
│   ├── assets/style.css
│   ├── components/
│   │   ├── ProjectExplorer.vue
│   │   ├── ContextPanel.vue
│   │   └── ExecutionFlow.vue
│   └── views/
│       ├── AgentCenterView.vue
│       ├── ContextManagerView.vue
│       ├── ChangeReviewView.vue
│       ├── AgentMonitorView.vue
│       ├── KnowledgeCenterView.vue
│       └── TaskBoardView.vue
└── docs/
    ├── ARCHITECTURE.md
    ├── core/ (各模块文档)
    └── tests/api-basics.md
```
