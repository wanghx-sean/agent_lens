import { createRouter, createWebHashHistory } from 'vue-router'
import ChatView from '../views/ChatView.vue'
import PromptView from '../views/PromptView.vue'
import ContextView from '../views/ContextView.vue'
import MemoryView from '../views/MemoryView.vue'
import TokenView from '../views/TokenView.vue'
import ExecutionView from '../views/ExecutionView.vue'

const routes = [
  { path: '/', name: 'Chat', component: ChatView },
  { path: '/prompt', name: 'Prompt', component: PromptView },
  { path: '/context', name: 'Context', component: ContextView },
  { path: '/memory', name: 'Memory', component: MemoryView },
  { path: '/token', name: 'Token', component: TokenView },
  { path: '/execution', name: 'Execution', component: ExecutionView },
]

export default createRouter({
  history: createWebHashHistory(),
  routes
})
