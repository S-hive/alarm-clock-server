# Alarm Clock Server

闹钟 / 专注计时应用的后端服务，基于 Spring Boot 3 构建，提供用户注册登录、定时任务（TodoList）管理，以及每日专注时长与字数统计等功能。

## 页面展示

<img width="1863" height="1045" alt="image" src="https://github.com/user-attachments/assets/aa765393-7de7-4692-a8e5-9cde894d7e42" />
<img width="1863" height="1045" alt="image" src="https://github.com/user-attachments/assets/68a46aeb-a7d4-460d-b017-4e3092c0d985" />
<img width="1863" height="1045" alt="image" src="https://github.com/user-attachments/assets/78df66e0-7d65-47cc-8b20-9cb26f07d89c" />

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
- [前端服务](https://github.com/S-hive/alarm-frontend)

## 待完成 / 可扩展功能

### 核心业务

- [ ] **笔记模块** — 侧边栏品牌名为「笔记」，但目前仅有计时功能，缺少笔记编辑、保存、检索等页面
- [ ] **字数统计录入** — 图表已展示 `wordCount`（新增字数），但前端没有录入或更新字数的入口，数据只能依赖后端默认值
- [ ] **忘记密码** — 登录页有「忘记密码?」链接，目前为 `href="#"` 占位，未对接找回/重置流程
- [ ] **空状态引导** — 无任务时会跳转 `emptyDemo`，但页面只有「了解更多」占位链接，缺少「立即创建第一个任务」的快捷操作

### 导航与侧边栏

- [ ] **占位菜单项** — Capture、Proposal、Prompts、Settings、Get Help、Search 等菜单均为 `href="#"`，可扩展为真实功能页
- [ ] **文档快捷入口** — Data Library、Reports、Word Assistant 等入口尚未对接业务

### 计时体验

- [ ] **闹钟提醒** — 倒计时结束目前仅弹出 Toast（`计时结束.`），可扩展浏览器通知、铃声、桌面提醒等
- [ ] **专注时长统计规则** — 正计时按实际 elapsed 累计，倒计时按预设 `status.time` 累计，可统一统计策略并支持「暂停/继续」
