# CLAUDE.md

Руководство для Claude Code при работе с проектом курса Scala 3 для платформы Stepik.

## Обзор проекта

Курс по Scala 3 с практическими примерами, упражнениями и документацией для обучения программированию на Scala 3.

## Структура проекта

```
ScalaCourse/
├── src/              # Исходный код Scala (примеры для курса)
├── content/          # Контент курса (материалы Stepik: .step, .md)
├── requirements/     # Внешние бизнес-требования
├── research/         # Результаты исследовательских задач
├── prompts/          # Модульная система промптов
├── plans/            # Стратегические планы
├── tasks/            # Kanban-доска задач
└── docs/             # Документация
```

## Архитектура управления проектом

```
prompts/ ← Библиотека инструментов (используется везде)
                       ↕
requirements/  → Внешние требования (от стейкхолдеров)
   ↓
research/      → Исследования (анализ подходов, варианты)
   ↓
plans/         → Стратегические планы (дни/недели)
   ↓
tasks/         → Исполнительские задачи (часы/день)
   ↓
content/       → Результаты работы
```

**Детали:** [`docs/DEVELOPMENT.md`](docs/DEVELOPMENT.md)

## Команды и роли

Для работы с проектом используйте команды из [`prompts/commands/quick-commands.md`](prompts/commands/quick-commands.md):

- `@prompt-architect` - работа с промптами
- `@plan-manager` - работа с планами
- `@create-task` / `@start-task` / `@complete-task` - управление задачами

При активации роли или команды, обратитесь к указанным соответствующим файлам документации для получения детальных инструкций.

## Специализированная документация

**Системы управления** (детали нужны только при работе с соответствующими компонентами):
- [`requirements/STRUCTURE.md`](requirements/STRUCTURE.md) - работа с бизнес-требованиями
- [`research/STRUCTURE.md`](research/STRUCTURE.md) - проведение исследований
- [`prompts/STRUCTURE.md`](prompts/STRUCTURE.md) - модульная система промптов
- [`plans/STRUCTURE.md`](plans/STRUCTURE.md) - система планирования
- [`tasks/STRUCTURE.md`](tasks/STRUCTURE.md) - Kanban-система задач

**Текущее состояние** (читайте при необходимости):
- [`plans/course/roadmap.md`](plans/course/roadmap.md) - roadmap курса
- [`tasks/board/`](tasks/board/) - текущие задачи
