package com.agentlens;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * AgentLens 应用启动入口。
 *
 * 负责启动 Spring Boot 容器，初始化 Agent 核心引擎。
 */
@SpringBootApplication
public class AgentLensApplication {

    public static void main(String[] args) {
        SpringApplication.run(AgentLensApplication.class, args);
    }
}
