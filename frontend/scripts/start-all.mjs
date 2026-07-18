/**
 * 一键启动 Vite + Electron。
 *
 * 用法：npm run dev:all
 * 先启动 Vite，等待就绪后启动 Electron 窗口。
 */
import { spawn } from 'child_process'
import { resolve, dirname } from 'path'
import { fileURLToPath } from 'url'

const __dirname = dirname(fileURLToPath(import.meta.url))
const root = resolve(__dirname, '..')

// 启动 Vite
const vite = spawn('npx', ['vite'], {
  cwd: root,
  stdio: 'pipe',
  shell: true
})

vite.stdout.on('data', (data) => {
  const text = data.toString()
  process.stdout.write(text)

  // Vite 就绪后启动 Electron
  if (text.includes('Local:') || text.includes('ready in')) {
    setTimeout(() => {
      console.log('\n[启动器] Vite 已就绪，启动 Electron...')
      const electronPath = resolve(root, 'node_modules', 'electron', 'dist', 'electron.exe')
      const electron = spawn(electronPath, [root], {
        stdio: 'inherit',
        env: {
          ...process.env,
          VITE_DEV_SERVER_URL: 'http://localhost:5173'
        }
      })
      electron.on('exit', () => process.exit())
    }, 1000)
  }
})

vite.stderr.on('data', (data) => {
  process.stderr.write(data.toString())
})
