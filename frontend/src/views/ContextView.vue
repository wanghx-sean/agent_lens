<template>
  <div class="panel">
    <h2>Context 管理</h2>
    <p class="placeholder">查看和管理模型当前读取的内容——文件、文档、API 引用等。</p>
    <div class="card">
      <div class="card-header">当前上下文 (预计 ~0 tokens)</div>
      <div class="card-body empty">暂无上下文内容。添加文件或文档后将在显示。</div>
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
