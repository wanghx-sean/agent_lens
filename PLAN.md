# AgentLens 开发计划

## 阶段一：项目骨架 ✅ 已完成

### 1.1 后端初始化
- [x] 创建 Spring Boot 项目（pom.xml：spring-boot-starter-web / websocket）
- [x] 创建启动类 AgentLensApplication
- [x] 配置 application.properties（端口、应用名）
- [x] 配置 CORS（WebConfig，允许 localhost:5173）

### 1.2 基础 REST API
- [x] 实现 HealthController：GET /api/health 返回 status+timestamp+version

### 1.3 前端初始化
- [x] 创建 Vue 3 + Vite 项目（package.json、vite.config.js）
- [x] 配置 Electron 入口（electron/main.js）
- [x] 配置 Vite 代理（/api → localhost:8080）
- [x] 创建全局样式（style.css，暗色主题）
- [x] 创建主布局 App.vue（侧边栏导航 + 内容区）
- [x] 创建路由（router/index.js：6 个面板路由）
- [x] 创建 6 个面板占位视图（ChatView / PromptView / ContextView / MemoryView / TokenView / ExecutionView）

### 1.4 LLM 通信验证
- [x] 定义 LlmService 接口（chat / chatStream）
- [x] 实现 LlmTestService（固定回复）
- [x] 实现 LlmController：POST /api/llm/chat
- [x] 创建 LLM 状态管理 Pinia Store（llm.js）
- [x] 实现 ChatView 基本交互（输入框 + 消息列表 + 发送）
- [x] 后端连通性检测（健康检查指示灯）

---

## 阶段二：Prompt 管理

### 2.1 PromptTemplate 模型
- [ ] 补充 id（String UUID）字段
- [ ] 补充 name 字段
- [ ] 补充 role 字段
- [ ] 补充 goal 字段
- [ ] 补充 style 字段
- [ ] 补充 outputFormat 字段
- [ ] 补充 constraints 字段
- [ ] 补充 version（int）字段
- [ ] 补充 render() 方法（变量注入）
- [ ] 补充 getters / setters

### 2.2 PromptRepository 内存存储
- [ ] @Repository 注解
- [ ] templates 容器（Map<String, PromptTemplate>）
- [ ] history 容器（Map<String, List<String>>）
- [ ] 实现 create() — UUID 生成、存入、初始化 history
- [ ] 实现 update() — 检查存在、覆盖
- [ ] 实现 findById() — Optional 返回
- [ ] 实现 findAll() — 返回全部
- [ ] 实现 delete() — 移除模板和 history

### 2.3 PromptService 业务逻辑
- [ ] @Service 注解，注入 PromptRepository
- [ ] 实现 create() — version 初始化为 1，调用 repository.create()
- [ ] 实现 update() — 递增 version，调用 repository.update()
- [ ] 实现 findById() / findAll() / delete() — 委托给 repository

### 2.4 PromptController REST API
- [ ] @RestController + @RequestMapping("/api/prompts")
- [ ] 注入 PromptService
- [ ] GET /api/prompts → list()
- [ ] GET /api/prompts/{id} → getById()（不存在返回 404）
- [ ] POST /api/prompts → create()
- [ ] PUT /api/prompts/{id} → update()
- [ ] DELETE /api/prompts/{id} → delete()

### 2.5 异常处理
- [ ] 自定义 PromptNotFoundException
- [ ] @ControllerAdvice 全局异常处理
- [ ] 404 响应格式统一

### 2.6 PromptView 模板列表
- [ ] Pinia Store（prompt.js）：prompts 列表 + CRUD actions
- [ ] API 调用封装（axios → /api/prompts）
- [ ] 模板列表组件（表格 / 卡片展示）
- [ ] 选中高亮
- [ ] 空状态（"暂无模板"提示）

### 2.7 PromptView 创建 / 编辑
- [ ] 创建表单（角色 / 目标 / 风格 / 输出格式 / 约束 输入框）
- [ ] 编辑表单（回填已有数据）
- [ ] 表单验证（必填项检查）
- [ ] 保存按钮 → POST / PUT
- [ ] 取消按钮 → 重置表单
- [ ] 保存成功后刷新列表

### 2.8 PromptView 删除
- [ ] 删除按钮
- [ ] 确认对话框
- [ ] 删除成功后刷新列表

### 2.9 版本历史
- [ ] 版本号自动递增（Service 层）
- [ ] history 字段维护（每次 update 记录版本）
- [ ] 版本列表展示组件（时间线形式）
- [ ] 版本号标签显示

### 2.10 Prompt Diff
- [ ] 两个版本的内容对比展示
- [ ] 增删高亮（绿色 / 红色）
- [ ] 版本选择器（左侧选版本A，右侧选版本B）

### 2.11 版本回滚
- [ ] 回滚按钮
- [ ] 回滚确认（将丢失后续版本改动）
- [ ] 回滚后创建新版本（v1→v2→v3，从 v3 回滚到 v1 → 生成 v4）

### 2.12 Prompt 模板持久化
- [ ] Jackson / Yaml 序列化
- [ ] 保存到本地文件（JSON）
- [ ] 启动时自动加载
- [ ] 导出为 JSON 文件
- [ ] 从 JSON 文件导入

---

## 阶段三：LLM 集成

### 3.1 SDK 引入
- [ ] 调研选择 Spring AI 或 LangChain4j
- [ ] 添加 Maven 依赖
- [ ] 配置 API Key / URL（application.properties）

### 3.2 真实模型实现
- [ ] 实现 LlmService（调用真实模型 API）
- [ ] 注入 LlmConfig（model / temperature / maxTokens）
- [ ] 替换 LlmTestService（@Primary 或 @Conditional）
- [ ] 测试基础对话

### 3.3 流式响应
- [ ] 后端 SSE 端点（/api/llm/chat/stream）
- [ ] 后端 WebSocket 配置
- [ ] 前端 EventSource / WebSocket 连接
- [ ] ChatView 逐 token 渲染（打字机效果）

### 3.4 模型参数配置
- [ ] 模型选择（下拉框）
- [ ] Temperature 滑块
- [ ] MaxTokens 输入
- [ ] API Key 管理（环境变量或界面录入）

### 3.5 多模型切换
- [ ] 后端多模型注册（Map<String, LlmService>）
- [ ] 前端模型切换 UI
- [ ] 记忆当前选中模型

### 3.6 Token 用量统计
- [ ] 每次请求记录 input / output tokens
- [ ] Token 累计统计
- [ ] TokenView 展示（各模型占比图）

---

## 阶段四：Context 管理

### 4.1 ContextItem 模型
- [ ] id（String UUID）
- [ ] name
- [ ] type（FILE / DOC / API / MCP）
- [ ] content
- [ ] estimatedTokens
- [ ] pinned
- [ ] getters / setters

### 4.2 ContextManager 实现
- [ ] @Service 注解
- [ ] items 容器（List<ContextItem>）
- [ ] add() — 添加并重算 Token
- [ ] remove() — 删除并重算 Token
- [ ] pin() — 固定不被淘汰
- [ ] getItems() / getTotalTokens()

### 4.3 ContextController
- [ ] GET /api/context — 获取上下文列表 + 总 Token
- [ ] POST /api/context — 添加上下文项
- [ ] DELETE /api/context/{id} — 删除
- [ ] PUT /api/context/{id}/pin — 固定 / 取消固定

### 4.4 Token 精确估算
- [ ] 引入 Token 计数库（如 tiktoken）
- [ ] 按模型类型使用对应编码器
- [ ] 替换粗略的 /4 估算

### 4.5 ContextView 前端
- [ ] Pinia Store（context.js）
- [ ] 上下文列表展示（类型图标 + 文件名 + Token 数）
- [ ] 添加按钮 → 弹出选择（文件 / 文本）
- [ ] 删除按钮
- [ ] Pin / Unpin 切换
- [ ] Token 占用柱状图（每项占总量的比例）
- [ ] 文件选择器（拖拽上传 / 浏览）

### 4.6 自动摘要
- [ ] 摘要触发器（超过 N tokens 时）
- [ ] 调用 LLM 生成摘要
- [ ] 摘要替换原文（可展开查看原文）

---

## 阶段五：Memory 系统

### 5.1 MemoryManager 短期记忆
- [ ] @Service 注解
- [ ] sessionMemory 容器
- [ ] addToSession() — 添加短期记忆
- [ ] getSessionMemory() — 获取全部

### 5.2 MemoryManager 长期记忆
- [ ] longTermMemory 容器
- [ ] consolidateToLongTerm() — 固化到长期
- [ ] getLongTermMemory() — 获取全部

### 5.3 MemoryManager 偏好
- [ ] preferences 容器（Map）
- [ ] setPreference() — 设值
- [ ] getPreferences() — 获取全部

### 5.4 MemoryController
- [ ] GET /api/memory — 获取记忆（会话 + 长期 + 偏好）
- [ ] POST /api/memory/session — 添加短期记忆
- [ ] POST /api/memory/consolidate — 固化到长期
- [ ] DELETE /api/memory/{id} — 删除
- [ ] PUT /api/memory/preferences — 更新偏好

### 5.5 MemoryView 前端
- [ ] Pinia Store（memory.js）
- [ ] 短期记忆列表（显示内容 + 时间）
- [ ] 长期记忆列表（显示内容 + 时间）
- [ ] 偏好设置编辑（键值对形式）
- [ ] 编辑 / 删除 / 锁定操作
- [ ] 固化操作（短期→长期）

### 5.6 向量存储（进阶）
- [ ] 引入 Embedding 模型
- [ ] 引入向量数据库（如 Chroma / Milvus）
- [ ] 记忆检索（相似度匹配）

---

## 阶段六：Tool Calling

### 6.1 AgentTool 接口
- [ ] getName()
- [ ] getDescription()
- [ ] getParameterSchema() — JSON Schema
- [ ] execute(args)

### 6.2 ToolRegistry
- [ ] register(tool) — 注册
- [ ] getTool(name) — 查询
- [ ] getAllTools() — 全部

### 6.3 内置工具实现
- [ ] FileReadTool — 读取文件
- [ ] FileWriteTool — 写入文件
- [ ] CommandTool — 执行命令行
- [ ] SearchTool — 代码搜索

### 6.4 Function Calling 联动
- [ ] 将 Tool 定义转为 LLM Function Calling Schema
- [ ] LLM 返回工具调用请求时执行对应 Tool
- [ ] 执行结果返回 LLM 生成最终回复

### 6.5 Tool 调用日志
- [ ] 记录每次 Tool 调用的入参 + 出参 + 耗时
- [ ] ToolController：GET /api/tools/logs

### 6.6 前端展示
- [ ] Tool 调用日志列表（展开查看详情）
- [ ] 工具开关（启用 / 禁用特定工具）

---

## 阶段七：Workflow 编排

### 7.1 WorkflowStep
- [ ] 抽象类：name / description
- [ ] 抽象方法 execute(input) → output
- [ ] 内置步骤实现：PromptStep / LlmStep / ToolStep / OutputStep

### 7.2 Workflow 引擎
- [ ] steps 容器（有序 List）
- [ ] addStep() — 追加步骤
- [ ] execute() — 顺序执行，传递输出到下一步输入
- [ ] executeAsync() — 异步执行

### 7.3 条件分支
- [ ] 判断条件接口（Condition）
- [ ] IfStep — 条件满足执行 A，否则执行 B

### 7.4 WorkflowController
- [ ] POST /api/workflows — 创建工作流
- [ ] POST /api/workflows/{id}/execute — 执行
- [ ] GET /api/workflows/{id}/status — 查询执行状态
- [ ] GET /api/workflows/{id}/steps — 获取各步骤执行结果

### 7.5 ExecutionView 前端
- [ ] 执行流程可视化（垂直时间线 + 节点状态）
- [ ] 步骤展开面板（显示输入 / 输出）
- [ ] 执行状态标识（等待 / 进行中 / 完成 / 失败）

### 7.6 Workflow 编排界面
- [ ] 步骤列表（可拖拽排序）
- [ ] 添加步骤（选择类型 + 配置参数）
- [ ] 保存工作流模板

---

## 阶段八：高级特性

### 8.1 Prompt Optimizer
- [ ] 分析聊天历史中的重复指令
- [ ] 重复检测算法（相同关键词出现 N 次以上）
- [ ] 通知提示（"检测到经常要求 Markdown 输出，建议加入 Prompt"）
- [ ] 一键确认加入 Prompt

### 8.2 Prompt Timeline
- [ ] 版本时间线可视化（横向时间轴）
- [ ] 每个版本节点（显示版本号 + 修改时间）
- [ ] 分支管理（从某个版本创建新分支）

### 8.3 IDEA 插件适配（远期）
- [ ] 核心引擎模块化（抽离为独立 Library / Maven Module）
- [ ] 创建 IDEA Plugin 模块
- [ ] ToolWindow 注册
- [ ] 工具窗口面板适配（将 Vue 嵌入 IDE）
- [ ] 项目文件上下文接入

---

## 附录：项目文件结构最终形态

```
agent_lens/
├── README.md
├── PLAN.md
├── .gitignore
├── backend/
│   └── src/main/java/com/agentlens/
│       ├── AgentLensApplication.java
│       ├── config/
│       │   └── WebConfig.java
│       ├── api/
│       │   ├── HealthController.java
│       │   ├── LlmController.java
│       │   ├── PromptController.java
│       │   ├── ContextController.java
│       │   ├── MemoryController.java
│       │   ├── ToolController.java
│       │   └── WorkflowController.java
│       ├── core/
│       │   ├── llm/
│       │   │   ├── LlmService.java
│       │   │   ├── LlmTestService.java
│       │   │   └── LlmConfig.java
│       │   ├── prompt/
│       │   │   ├── PromptTemplate.java
│       │   │   ├── PromptRepository.java
│       │   │   └── PromptService.java
│       │   ├── context/
│       │   │   ├── ContextItem.java
│       │   │   └── ContextManager.java
│       │   ├── memory/
│       │   │   └── MemoryManager.java
│       │   ├── tool/
│       │   │   ├── AgentTool.java
│       │   │   ├── ToolRegistry.java
│       │   │   ├── Constants.java
│       │   │   └── impl/
│       │   │       ├── FileReadTool.java
│       │   │       ├── FileWriteTool.java
│       │   │       └── CommandTool.java
│       │   └── workflow/
│       │       ├── Workflow.java
│       │       ├── WorkflowStep.java
│       │       └── steps/
│       │           ├── PromptStep.java
│       │           └── LlmStep.java
│       └── exception/
│           └── GlobalExceptionHandler.java
├── frontend/
│   └── src/
│       ├── main.js / App.vue
│       ├── router/index.js
│       ├── stores/
│       │   ├── llm.js
│       │   ├── prompt.js
│       │   ├── context.js
│       │   ├── memory.js
│       │   └── tool.js
│       ├── views/
│       │   ├── ChatView.vue
│       │   ├── PromptView.vue
│       │   ├── ContextView.vue
│       │   ├── MemoryView.vue
│       │   ├── TokenView.vue
│       │   └── ExecutionView.vue
│       └── components/
│           ├── DiffViewer.vue
│           └── ConfirmDialog.vue
├── docs/
│   ├── ARCHITECTURE.md
│   └── core/
│       ├── llm.md / prompt.md / context.md
│       ├── memory.md / tool.md / workflow.md
└── 其他资源文件
```
