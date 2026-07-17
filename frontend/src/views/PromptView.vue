<template>
  <div class="panel">
    <h2>Prompt 管理</h2>
    <p class="placeholder">Prompt 模板的创建、编辑、版本管理与 Diff 将在此面板中实现。</p>
    <div class="card">
      <div class="card-header">当前模板</div>
      <div class="card-body">
        <div class="field"><label>角色</label><span>高级工程师</span></div>
        <div class="field"><label>目标</label><span>生成设计文档</span></div>
        <div class="field"><label>风格</label><span>正式</span></div>
        <div class="field"><label>输出格式</label><span>Markdown</span></div>
      </div>
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
.card-body { padding: 16px; display: flex; flex-direction: column; gap: 12px; }
.field { display: flex; gap: 12px; font-size: 14px; }
.field label { color: #888; min-width: 80px; }
</style>
