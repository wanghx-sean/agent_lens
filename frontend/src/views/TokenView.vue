<template>
  <div class="panel">
    <h2>Token 监控</h2>
    <p class="placeholder">实时显示当前会话的 Token 分布——Prompt、Context、Memory、Output。</p>
    <div class="token-bars">
      <div class="token-item">
        <div class="token-label">Prompt</div>
        <div class="token-bar"><div class="bar-fill" style="width:10%"></div></div>
        <div class="token-count">0</div>
      </div>
      <div class="token-item">
        <div class="token-label">Context</div>
        <div class="token-bar"><div class="bar-fill" style="width:0%"></div></div>
        <div class="token-count">0</div>
      </div>
      <div class="token-item">
        <div class="token-label">Memory</div>
        <div class="token-bar"><div class="bar-fill" style="width:0%"></div></div>
        <div class="token-count">0</div>
      </div>
      <div class="token-item">
        <div class="token-label">Output</div>
        <div class="token-bar"><div class="bar-fill" style="width:0%"></div></div>
        <div class="token-count">0</div>
      </div>
    </div>
  </div>
</template>

<style scoped>
.panel { height: 100%; }
.placeholder { color: #888; margin: 12px 0 24px; font-size: 14px; }
.token-bars { display: flex; flex-direction: column; gap: 16px; }
.token-item { display: flex; align-items: center; gap: 12px; }
.token-label { min-width: 80px; font-size: 14px; color: #a0a0b8; }
.token-bar {
  flex: 1; height: 20px; background: #16213e;
  border-radius: 10px; overflow: hidden;
}
.bar-fill { height: 100%; background: #e94560; border-radius: 10px; transition: width 0.3s; }
.token-count { min-width: 40px; text-align: right; font-size: 12px; color: #888; }
</style>
