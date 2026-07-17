package com.agentlens.core.tool;

/**
 * 常量定义工具类。
 *
 * 集中管理项目中使用的常量，避免魔法值散落在各处。
 */
public final class Constants {

    // 工具类禁止实例化
    private Constants() {}

    // ========== Prompt 版本相关 ==========
    /**
     * Prompt 模板版本号前缀
     */
    public static final String PROMPT_VERSION_FOMATE = "V";

    // ========== Token 估算相关 ==========

    /**
     * Token 估算系数（字符数 / 4 ≈ token 数）
     */
    public static final int TOKEN_ESTIMATE_RATIO = 4;
}
