# Alarm Clock Server

闹钟 / 专注计时应用的后端服务，基于 Spring Boot 3 构建，提供用户注册登录、定时任务（TodoList）管理，以及每日专注时长与字数统计等功能。

<img width="1863" height="1045" alt="image" src="https://github.com/user-attachments/assets/aa765393-7de7-4692-a8e5-9cde894d7e42" />

## 功能特性

- **用户管理**：手机号 + 密码注册与登录
- **定时列表（TodoList）**：按用户手机号创建、查询、更新、删除定时任务，支持分页
- **每日数据（DailyData）**：记录专注时长（`focusDuration`）与字数（`wordCount`），支持按日期查询、登录时自动初始化当日数据、查询近 3 个月历史记录

## 技术栈

| 类别 | 技术 |
|------|------|
| 语言 | Java 17 |
| 框架 | Spring Boot 3.3.7 |
| ORM | MyBatis-Plus 3.5.7 |
| 数据库 | MySQL 8 |
| 连接池 | Druid |
| 缓存 | Spring Cache + Redis |
| 构建工具 | Maven（多模块） |

## 环境要求
- JDK 17+
- Maven 3.6+
- MySQL 8.0+
