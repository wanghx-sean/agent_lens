# AgentLens 架构设计

## 整体架构

```
┌──────────────────────────┐     HTTP/REST      ┌──────────────────────────┐
│   Vue 3 + Electron       │  ←──────────────→  │   Spring Boot 3         │
│   (Presentation Layer)   │    WebSocket       │   (Agent Core Engine)   │
│                          │                    │                         │
│   ┌──────────────────┐   │                    │   ┌─────────────────┐   │
│   │  Chat 面板        │   │                    │   │  LLM            │   │
│   │  Prompt 面板      │   │                    │   │  Prompt         │   │
│   │  Context 面板     │   │                    │   │  Context        │   │
│   │  Memory 面板      │   │                    │   │  Memory         │   │
│   │  Token 面板       │   │                    │   │  Tool           │   │
│   │  Execution 面板   │   │                    │   │  Workflow       │   │
│   └──────────────────┘   │                    │   └─────────────────┘   │
└──────────────────────────┘                    └──────────────────────────┘
```

## 分层职责

### 前端 (Vue + Electron)

- **Vue 3** — 组件化 UI
- **Pinia** — 状态管理
- **Vue Router** — 面板切换
- **Axios** — 后端 API 调用
- **Electron** — 桌面窗口封装

### 后端 (Spring Boot 3)

- **API 层** (`com.agentlens.api`) — REST Controller，前后端通信契约
- **核心层** (`com.agentlens.core`) — Agent 核心逻辑
  - `llm` — 大模型集成
  - `prompt` — Prompt 模板管理
  - `context` — 上下文管理
  - `memory` — 记忆系统
  - `tool` — 工具注册与调用
  - `workflow` — 工作流编排
- **配置层** (`com.agentlens.config`) — CORS、WebSocket 等配置

## 前后端通信

### REST API

| 方法 | 路径 | 说明 |
|------|------|------|
| GET | /api/health | 健康检查 |
| POST | /api/llm/chat | LLM 对话 |

> 随开发进度扩展。

### 数据流

```
User Input (Vue)
  → POST /api/llm/chat
    → LlmController
      → LlmService.chat()
        → [LlmTestService / 真实 LLM]
    ← 响应
  ← 渲染到 Chat 面板
```

## 包结构

```
backend/src/main/java/com/agentlens/
├── AgentLensApplication.java    # 启动类
├── api/
│   ├── HealthController.java    # 健康检查
│   └── LlmController.java       # LLM 对话 API
├── config/
│   └── WebConfig.java           # CORS 配置
└── core/
    ├── llm/
    │   ├── LlmService.java       # LLM 接口
    │   ├── LlmTestService.java   # 测试实现
    │   └── LlmConfig.java        # 配置模型
    ├── prompt/
    │   ├── PromptTemplate.java   # 模板定义
    │   └── PromptRepository.java # 模板仓库
    ├── context/
    │   ├── ContextManager.java   # 上下文管理器
    │   └── ContextItem.java      # 上下文项
    ├── memory/
    │   └── MemoryManager.java    # 记忆管理器
    ├── tool/
    │   ├── AgentTool.java        # 工具接口
    │   └── ToolRegistry.java     # 工具注册中心
    └── workflow/
        ├── Workflow.java         # 工作流定义
        └── WorkflowStep.java     # 工作流步骤
```
