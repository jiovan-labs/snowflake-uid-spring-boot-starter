# Snowflake UID Spring Boot Starter

Spring Boot application integrates `snowflake` quickly, to generate unique identifiers in order.

## Quickstart

- Import dependencies

```xml
    <dependency>
        <groupId>com.jiovan.spring.starter</groupId>
        <artifactId>snowflake-uid-spring-boot-starter</artifactId>
        <version>LATEST</version>
    </dependency>
```

> By default, this starter will auto take effect, you can turn it off by `jiovan.snowflake-uid.enabled = false`

- Configure Spring Boot `application.yml` with prefix `jiovan.snowflake-uid` (**Optional**)

```yml
jiovan:
    snowflake-uid:
        epochPoint: '2022-01-01'
```

- Configure your beans with a `UidGenerator` bean by constructor or `@Autowired`/`@Resource` annotation, then you can access it as you wish.

  There are two different implements of `UidGenerator` for different scenarios:

| Implement Class       | Primary Bean |
|-----------------------|--------------|
| DefaultUidGenerator   | Yes          |
| CacheableUidGenerator | No           |

## Document

- Github: https://github.com/jiovan-labs/snowflake-uid-spring-boot-starter
- UID generator GitHub: https://github.com/baidu/uid-generator

## Requirement

- jdk 17+

## License

This project is under the [Apache License 2.0](https://www.apache.org/licenses/LICENSE-2.0)

See the `NOTICE.txt` file for required notices and attributions.

## Donation

You like this package? Then [donate to us](https://jiovan.com/donation) to support the development.

## Copyright

Beijing Jiovan Technology Ltd.

## Website

- Jiovan: https://jiovan.com
