<template>
  <div class="task-board">
    <div class="center-header">
      <h2 class="center-title">📌 {{ $t('persp_tasks') }}</h2>
      <button class="action-btn primary">+ New Task</button>
    </div>
    <div class="board-columns">
      <div class="board-col">
        <div class="col-header todo">{{ $t('task_todo') }}</div>
        <div class="col-card">Analyze Module</div>
        <div class="col-card">Review API docs</div>
      </div>
      <div class="board-col">
        <div class="col-header running">{{ $t('task_running') }}</div>
        <div class="col-card active">Generate API Doc</div>
      </div>
      <div class="board-col">
        <div class="col-header done">{{ $t('task_done') }}</div>
        <div class="col-card done">Create Plugin Template</div>
      </div>
    </div>
  </div>
</template>

<style scoped>
.task-board {
  padding: 24px;
  height: 100%;
  overflow-y: auto;
  background: #1e1e2e;
  flex: 1;
}
.center-header {
  display: flex; align-items: center; justify-content: space-between; margin-bottom: 16px;
}
.center-title { font-size: 18px; font-weight: 600; color: #cdd6f4; }
.action-btn {
  padding: 6px 16px; border-radius: 4px; border: none;
  cursor: pointer; font-size: 12px;
}
.action-btn.primary { background: #cba6f7; color: #1e1e2e; font-weight: 600; }
.board-columns { display: flex; gap: 16px; height: calc(100% - 60px); }
.board-col {
  flex: 1; background: #181825;
  border: 1px solid #313244; border-radius: 8px; padding: 12px;
}
.col-header {
  font-size: 12px; font-weight: 600; text-transform: uppercase;
  letter-spacing: 0.5px; margin-bottom: 12px; padding-bottom: 8px;
  border-bottom: 2px solid;
}
.col-header.todo { color: #6c7086; border-color: #6c7086; }
.col-header.running { color: #cba6f7; border-color: #cba6f7; }
.col-header.done { color: #a6e3a1; border-color: #a6e3a1; }
.col-card {
  padding: 10px 12px; border-radius: 4px; font-size: 13px;
  margin-bottom: 8px; cursor: pointer;
  background: #313244; color: #cdd6f4;
}
.col-card:hover { background: #45475a; }
.col-card.active { border-left: 3px solid #cba6f7; }
.col-card.done { opacity: 0.6; }
</style>
