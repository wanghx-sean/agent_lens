/**
 * Electron 启动脚本。
 *
 * 等待 Vite 开发服务器就绪后启动 Electron 窗口。
 * 独立于 Vite 进程运行，避免 vite-plugin-electron 的兼容问题。
 */
import { spawn } from 'child_process'
import { createServer } from 'http'
import { resolve, dirname } from 'path'
import { fileURLToPath } from 'url'

const __dirname = dirname(fileURLToPath(import.meta.url))
const root = resolve(__dirname, '..')

const VITE_DEV_URL = 'http://localhost:5173'

/**
 * 等待 Vite 服务器可访问
 */
function waitForVite() {
  return new Promise((resolve) => {
    const check = () => {
      const req = createServer(VITE_DEV_URL, (res) => {
        res.on('data', () => {})
        res.on('end', () => resolve())
      })
      req.on('error', () => setTimeout(check, 500))
      req.end()
    }
    check()
  })
}

async function start() {
  console.log('[Electron] 等待 Vite 开发服务器...')
  await waitForVite()
  console.log('[Electron] Vite 已就绪，启动 Electron...')

  const electronPath = resolve(root, 'node_modules', 'electron', 'dist', 'electron.exe')

  const child = spawn(electronPath, [root], {
    stdio: 'inherit',
    env: {
      ...process.env,
      VITE_DEV_SERVER_URL: VITE_DEV_URL
    }
  })

  child.on('exit', () => process.exit())
}

start()
