[English](README.md) | [简体中文](README.zh-CN.md) | [繁體中文](README.zh-TW.md)

# Snowflake UID Spring Boot Starter

让 Spring Boot 应用快速集成 `snowflake`，按顺序生成唯一标识符。

## 快速开始

- 导入依赖

```xml
    <dependency>
        <groupId>com.jiovan.spring.starter</groupId>
        <artifactId>snowflake-uid-spring-boot-starter</artifactId>
        <version>LATEST</version>
    </dependency>
```

> 默认情况下，此 starter 会自动生效，你可以通过 `jiovan.snowflake-uid.enabled = false` 关闭它。

- 使用前缀 `jiovan.snowflake-uid` 配置 Spring Boot 的 `application.yml`（**可选**）

```yml
jiovan:
    snowflake-uid:
        epochPoint: '2022-01-01'
```

- 通过构造函数或 `@Autowired`/`@Resource` 注解注入一个 `UidGenerator` Bean，之后即可随意使用。

  `UidGenerator` 有两种不同实现，适用于不同场景：

| 实现类 | 主 Bean |
|-----------------------|--------------|
| DefaultUidGenerator | 是 |
| CacheableUidGenerator | 否 |

## 文档

- GitHub：https://github.com/jiovan-labs/snowflake-uid-spring-boot-starter
- UID 生成器 GitHub：https://github.com/baidu/uid-generator

## 环境要求

- jdk 17+

## 许可证

本项目采用 [Apache License 2.0](https://www.apache.org/licenses/LICENSE-2.0) 许可证。

请参阅 `NOTICE.txt` 文件了解所需的声明与归属信息。

## 捐赠

喜欢这个工具包吗？欢迎[向我们捐赠](https://jiovan.com/donation)以支持开发。

## 版权

北京玖漫科技有限公司

## 网站

- 玖漫：https://jiovan.com
