<template>
  <div class="panel">
    <h2>Memory</h2>
    <p class="placeholder">管理 Agent 的长期记忆与偏好设置。</p>
    <div class="card">
      <div class="card-header">长期记忆</div>
      <div class="card-body empty">暂无长期记忆。</div>
    </div>
    <div class="card" style="margin-top:12px">
      <div class="card-header">会话记忆</div>
      <div class="card-body empty">暂无会话记忆。</div>
    </div>
  </div>
</template>

<style scoped>
.panel { height: 100%; }
.placeholder { color: #888; margin: 12px 0 24px; font-size: 14px; }
.card {
  background: #16213e; border: 1px solid #0f3460;
  border-radius: 8px; overflow: hidden;
}
.card-header {
  padding: 12px 16px; background: #0f3460;
  font-weight: 600; font-size: 14px;
}
.card-body { padding: 16px; }
.empty { color: #666; font-size: 14px; text-align: center; padding: 32px; }
</style>
