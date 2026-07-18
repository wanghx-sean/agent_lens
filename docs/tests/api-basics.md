# 基础接口测试

## 前置条件

- 启动后端：`cd backend && mvn spring-boot:run`
- 服务地址：`http://localhost:8080`

---

## 健康检查

```bash
curl http://localhost:8080/api/health
```

预期返回：
```json
{"version":"0.0.1","timestamp":"...","status":"UP"}
```

---

## Prompt 模板 CRUD

### 1. 列表（空）

```bash
curl http://localhost:8080/api/prompts
```

预期返回：`[]`

---

### 2. 创建

```bash
curl -s -X POST "http://localhost:8080/api/prompts" \
  -H "Content-Type: application/json" \
  -d "{\"name\":\"test\",\"role\":\"dev\"}"
```

预期返回（id 和 timestamp 会不同）：
```json
{"id":"4096fb73-...","name":"test","role":"dev","goal":null,"style":null,"outputFormat":null,"constraints":null,"version":1}
```

验证点：
- 返回 `id`（UUID 格式）
- `version` 为 1

---

### 3. 列表（有数据）

```bash
curl http://localhost:8080/api/prompts
```

预期返回：步骤 2 创建的模板在列表中

---

### 4. 根据 ID 查询（存在）

```bash
curl http://localhost:8080/api/prompts/{替换为实际的id}
```

预期返回：该模板的完整数据

---

### 5. 根据 ID 查询（不存在 → 404）

```bash
curl -w "HTTP Status: %{http_code}" http://localhost:8080/api/prompts/not-exist-id
```

预期返回：
```json
{"timestamp":"...","status":404,"error":"Not Found","path":"/api/prompts/not-exist-id"}
```
```
HTTP Status: 404
```
