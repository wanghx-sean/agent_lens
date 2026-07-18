<template>
  <div class="knowledge-center">
    <div class="center-header">
      <h2 class="center-title">📚 {{ $t('persp_knowledge') }}</h2>
    </div>
    <div class="section-card">
      <div class="section-title">{{ $t('knowledge_project') }}</div>
      <div class="tree">
        <div class="tree-item">├── Architecture</div>
        <div class="tree-item">├── API</div>
        <div class="tree-item">├── Coding Rule</div>
        <div class="tree-item">└── Business Logic</div>
      </div>
    </div>
    <div class="section-card">
      <div class="section-title">{{ $t('knowledge_agent_memory') }}</div>
      <div class="tree">
        <div class="tree-item">├── Previous Task</div>
        <div class="tree-item">├── Decision</div>
        <div class="tree-item">└── Solution</div>
      </div>
    </div>
  </div>
</template>

<style scoped>
.knowledge-center {
  padding: 24px;
  height: 100%;
  overflow-y: auto;
  background: #1e1e2e;
  flex: 1;
  display: flex;
  flex-direction: column;
  gap: 16px;
}
.center-header { margin-bottom: 0; }
.center-title { font-size: 18px; font-weight: 600; color: #cdd6f4; }
.section-card {
  background: #181825;
  border: 1px solid #313244;
  border-radius: 8px;
  padding: 16px;
}
.section-title {
  font-size: 12px; font-weight: 600; text-transform: uppercase;
  color: #a6adc8; letter-spacing: 0.5px; margin-bottom: 10px;
}
.tree { display: flex; flex-direction: column; gap: 4px; }
.tree-item {
  font-size: 13px;
  color: #cdd6f4;
  padding: 3px 0;
  font-family: 'JetBrains Mono', monospace;
}
</style>
