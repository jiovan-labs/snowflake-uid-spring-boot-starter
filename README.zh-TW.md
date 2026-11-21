[English](README.md) | [簡體中文](README.zh-CN.md) | [繁體中文](README.zh-TW.md)

# Snowflake UID Spring Boot Starter

讓 Spring Boot 應用快速整合 `snowflake`，按順序生成唯一識別符號。

## 快速開始

- 匯入相依性

```xml
    <dependency>
        <groupId>com.jiovan.spring.starter</groupId>
        <artifactId>snowflake-uid-spring-boot-starter</artifactId>
        <version>LATEST</version>
    </dependency>
```

> 預設情況下，此 starter 會自動生效，你可以透過 `jiovan.snowflake-uid.enabled = false` 關閉它。

- 使用字首 `jiovan.snowflake-uid` 設定 Spring Boot 的 `application.yml`（**可選**）

```yml
jiovan:
    snowflake-uid:
        epochPoint: '2022-01-01'
```

- 透過建構函式或 `@Autowired`/`@Resource` 註解注入一個 `UidGenerator` Bean，之後即可隨意使用。

  `UidGenerator` 有兩種不同實現，適用於不同場景：

| 實現類 | 主 Bean |
|-----------------------|--------------|
| DefaultUidGenerator | 是 |
| CacheableUidGenerator | 否 |

## 文件

- GitHub：https://github.com/jiovan-labs/snowflake-uid-spring-boot-starter
- UID 生成器 GitHub：https://github.com/baidu/uid-generator

## 環境要求

- jdk 17+

## 許可證

本專案採用 [Apache License 2.0](https://www.apache.org/licenses/LICENSE-2.0) 許可證。

請參閱 `NOTICE.txt` 檔案瞭解所需的宣告與歸屬資訊。

## 捐贈

喜歡這個工具包嗎？歡迎[向我們捐贈](https://jiovan.com/donation)以支援開發。

## 版權

北京玖漫科技有限公司

## 網站

- 玖漫：https://jiovan.com
