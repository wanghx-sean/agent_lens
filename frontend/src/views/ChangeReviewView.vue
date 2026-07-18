<template>
  <div class="review-center">
    <div class="center-header">
      <h2 class="center-title">🔍 {{ $t('persp_review') }}</h2>
    </div>
    <div class="section-card">
      <div class="section-title">{{ $t('review_changes') }}</div>
      <div class="review-file">
        <div class="file-name">PluginManager.java</div>
        <div class="diff-preview">
          <div class="diff-side">
            <div class="diff-label">{{ $t('review_before') }}</div>
            <pre class="diff-code">public void add() { ... }</pre>
          </div>
          <div class="diff-side">
            <div class="diff-label">{{ $t('review_after') }}</div>
            <pre class="diff-code added">public void addPlugin() { ... }</pre>
          </div>
        </div>
        <div class="review-actions">
          <button class="rv-btn accept">✓ {{ $t('review_accept') }}</button>
          <button class="rv-btn reject">✗ {{ $t('review_reject') }}</button>
          <button class="rv-btn modify">✎ {{ $t('review_modify') }}</button>
        </div>
      </div>
    </div>
  </div>
</template>

<style scoped>
.review-center {
  padding: 24px;
  height: 100%;
  overflow-y: auto;
  background: #1e1e2e;
  flex: 1;
}
.center-header { margin-bottom: 16px; }
.center-title { font-size: 18px; font-weight: 600; color: #cdd6f4; }
.section-card {
  background: #181825;
  border: 1px solid #313244;
  border-radius: 8px;
  padding: 16px;
}
.section-title {
  font-size: 12px; font-weight: 600; text-transform: uppercase;
  color: #a6adc8; letter-spacing: 0.5px; margin-bottom: 12px;
}
.review-file { margin-top: 8px; }
.file-name { font-size: 14px; font-weight: 600; color: #89b4fa; margin-bottom: 12px; }
.diff-preview {
  display: flex; gap: 16px; margin-bottom: 12px;
}
.diff-side { flex: 1; }
.diff-label { font-size: 11px; color: #6c7086; margin-bottom: 4px; }
.diff-code {
  background: #11111b; padding: 10px; border-radius: 4px;
  font-size: 12px; font-family: 'JetBrains Mono', monospace;
  border: 1px solid #313244;
}
.diff-code.added { border-left: 3px solid #a6e3a1; }
.review-actions { display: flex; gap: 8px; }
.rv-btn {
  padding: 6px 16px; border: none; border-radius: 4px;
  cursor: pointer; font-size: 12px; font-weight: 600;
}
.rv-btn.accept { background: #a6e3a1; color: #1e1e2e; }
.rv-btn.reject { background: #f38ba8; color: #1e1e2e; }
.rv-btn.modify { background: #89b4fa; color: #1e1e2e; }
</style>
