<template>
  <div class="agent-center">
    <!-- @claude [think] Agent Center 主窗口 -- 独立全屏 Perspective -->
    <div class="center-header">
      <h2 class="center-title">🤖 {{ $t('persp_agent_center') }}</h2>
      <div class="center-actions">
        <button class="action-btn primary">{{ $t('agent_new_task') }}</button>
      </div>
    </div>

    <!-- 当前任务 -->
    <div class="section-card">
      <div class="section-title">{{ $t('agent_current_task') }}</div>
      <div class="task-display">
        <span class="task-badge">Active</span>
        <span class="task-text">Create plugin system documentation</span>
      </div>
    </div>

    <!-- Agent Workflow -->
    <div class="section-card">
      <div class="section-title">{{ $t('agent_workflow') }}</div>
      <div class="workflow">
        <div class="wf-step completed">✓ Plan</div>
        <div class="wf-arrow">↓</div>
        <div class="wf-step active">● Analysis</div>
        <div class="wf-arrow">↓</div>
        <div class="wf-step pending">○ Coding</div>
        <div class="wf-arrow">↓</div>
        <div class="wf-step pending">○ Review</div>
      </div>
    </div>

    <!-- Agent Conversation -->
    <div class="section-card conversation">
      <div class="section-title">{{ $t('agent_conversation') }}</div>
      <div class="conv-placeholder">{{ $t('agent_conv_empty') }}</div>
    </div>
  </div>
</template>

<style scoped>
.agent-center {
  display: flex;
  flex-direction: column;
  gap: 16px;
  padding: 24px;
  height: 100%;
  overflow-y: auto;
  background: #1e1e2e;
  flex: 1;
}
.center-header {
  display: flex;
  align-items: center;
  justify-content: space-between;
}
.center-title {
  font-size: 18px;
  font-weight: 600;
  color: #cdd6f4;
}
.action-btn {
  padding: 6px 16px;
  border-radius: 4px;
  border: none;
  cursor: pointer;
  font-size: 12px;
}
.action-btn.primary {
  background: #cba6f7;
  color: #1e1e2e;
  font-weight: 600;
}
.section-card {
  background: #181825;
  border: 1px solid #313244;
  border-radius: 8px;
  padding: 16px;
}
.section-title {
  font-size: 12px;
  font-weight: 600;
  text-transform: uppercase;
  color: #a6adc8;
  letter-spacing: 0.5px;
  margin-bottom: 12px;
}
.task-display {
  display: flex;
  align-items: center;
  gap: 10px;
}
.task-badge {
  background: #a6e3a1;
  color: #1e1e2e;
  padding: 2px 8px;
  border-radius: 4px;
  font-size: 11px;
  font-weight: 600;
}
.task-text {
  font-size: 14px;
  color: #cdd6f4;
}
.workflow {
  display: flex;
  flex-direction: column;
  align-items: flex-start;
  gap: 4px;
}
.wf-step {
  font-size: 13px;
  padding: 4px 0;
}
.wf-step.completed { color: #a6e3a1; }
.wf-step.active { color: #cba6f7; font-weight: 600; }
.wf-step.pending { color: #6c7086; }
.wf-arrow { color: #6c7086; font-size: 11px; padding-left: 8px; }
.conversation { flex: 1; }
.conv-placeholder {
  color: #6c7086;
  font-size: 13px;
  text-align: center;
  padding: 40px 0;
}
</style>
