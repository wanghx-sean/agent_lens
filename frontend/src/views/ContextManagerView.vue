<template>
  <div class="context-manager">
    <div class="center-header">
      <h2 class="center-title">📋 {{ $t('persp_context') }}</h2>
    </div>

    <div class="section-card">
      <div class="section-title">{{ $t('context_current_task') }}</div>
      <div class="context-task">实现 PluginManager 文档</div>
    </div>

    <div class="section-card">
      <div class="section-title">{{ $t('context_files_title') }}</div>
      <div class="context-list">
        <div class="ctx-item checked">☑ PluginManager.java</div>
        <div class="ctx-item checked">☑ Plugin.xml</div>
        <div class="ctx-item checked">☑ Architecture.md</div>
        <div class="ctx-item unchecked">☐ Database.md</div>
      </div>
    </div>

    <div class="section-card">
      <div class="section-title">{{ $t('context_memory_title') }}</div>
      <div class="context-memory">历史分析记录</div>
    </div>

    <div class="section-card">
      <div class="section-title">{{ $t('context_token_title') }}</div>
      <div class="token-display">
        <div class="token-bar-lg"><div class="bar-fill-lg" style="width:65%"></div></div>
        <span class="token-pct">65%</span>
      </div>
    </div>
  </div>
</template>

<style scoped>
.context-manager {
  padding: 24px;
  height: 100%;
  overflow-y: auto;
  background: #1e1e2e;
  flex: 1;
  display: flex;
  flex-direction: column;
  gap: 16px;
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
  margin-bottom: 10px;
}
.context-task {
  font-size: 14px;
  color: #cdd6f4;
}
.context-list {
  display: flex;
  flex-direction: column;
  gap: 6px;
}
.ctx-item {
  font-size: 13px;
  padding: 4px 8px;
  border-radius: 4px;
  cursor: pointer;
}
.ctx-item:hover { background: #313244; }
.ctx-item.checked { color: #a6e3a1; }
.ctx-item.unchecked { color: #6c7086; }
.context-memory {
  color: #f9e2af;
  font-size: 13px;
}
.token-display {
  display: flex;
  align-items: center;
  gap: 12px;
}
.token-bar-lg {
  flex: 1;
  height: 12px;
  background: #313244;
  border-radius: 6px;
  overflow: hidden;
}
.bar-fill-lg {
  height: 100%;
  background: #f9e2af;
  border-radius: 6px;
}
.token-pct {
  color: #f9e2af;
  font-size: 14px;
  font-weight: 600;
}
</style>
