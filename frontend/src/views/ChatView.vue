<template>
  <div class="chat-view">
    <h2>Chat</h2>
    <div class="connection-status" :class="{ connected: store.backendConnected }">
      {{ store.backendConnected ? '● 后端已连接' : '○ 后端未连接' }}
    </div>

    <div class="message-list" ref="listRef">
      <div v-for="(msg, i) in store.messages" :key="i"
           :class="['message', msg.role]">
        <div class="message-label">{{ msg.role === 'user' ? 'You' : 'Agent' }}</div>
        <div class="message-content">{{ msg.content }}</div>
      </div>
      <div v-if="store.loading" class="message assistant">
        <div class="message-content typing">思考中...</div>
      </div>
    </div>

    <div class="input-area">
      <input v-model="inputText" @keyup.enter="send"
             placeholder="输入消息..." :disabled="store.loading" />
      <button @click="send" :disabled="store.loading || !inputText.trim()">发送</button>
    </div>
  </div>
</template>

<script setup>
import { ref, onMounted, nextTick } from 'vue'
import { useLlmStore } from '../stores/llm'

const store = useLlmStore()
const inputText = ref('')
const listRef = ref(null)

async function send() {
  if (!inputText.value.trim()) return
  await store.sendMessage(inputText.value)
  inputText.value = ''
  nextTick(() => {
    listRef.value?.scrollTo({ top: listRef.value.scrollHeight, behavior: 'smooth' })
  })
}

onMounted(() => store.checkHealth())
</script>

<style scoped>
.chat-view { display: flex; flex-direction: column; height: 100%; }
.connection-status {
  font-size: 12px; color: #666; margin-bottom: 12px;
}
.connection-status.connected { color: #4caf50; }
.message-list {
  flex: 1; overflow-y: auto; padding: 12px 0;
  display: flex; flex-direction: column; gap: 12px;
}
.message {
  max-width: 80%; padding: 10px 14px;
  border-radius: 8px; line-height: 1.5;
}
.message.user { align-self: flex-end; background: #0f3460; }
.message.assistant { align-self: flex-start; background: #16213e; }
.message-label { font-size: 11px; color: #888; margin-bottom: 4px; }
.typing { color: #888; font-style: italic; }
.input-area {
  display: flex; gap: 8px; padding: 12px 0;
}
.input-area input {
  flex: 1; padding: 10px 14px;
  background: #16213e; border: 1px solid #0f3460;
  border-radius: 6px; color: #e0e0e0; outline: none;
}
.input-area input:focus { border-color: #e94560; }
.input-area button {
  padding: 10px 20px; background: #e94560;
  border: none; border-radius: 6px; color: #fff; cursor: pointer;
}
.input-area button:disabled { opacity: 0.5; cursor: not-allowed; }
</style>
