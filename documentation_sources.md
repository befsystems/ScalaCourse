# Источники документации на Tuple.toArray

## 🌐 Онлайн Scaladoc (Официальная API документация)

### Scala 3.7.x (ваша версия)
- **Scala 3.7.4 API**: https://www.scala-lang.org/api/3.7.4/
  - Перейдите в: `scala` → `Tuple` → метод `toArray`

### Scala 3.x (актуальная)
- **Scala 3.x API**: https://scala-lang.org/api/3.x/scala/Tuple.html
  - Прямая ссылка на Tuple trait

### Scala 3.3.x LTS (Long Term Support)
- **Scala 3.3.7 API**: https://www.scala-lang.org/api/3.3.7/

### Альтернативный источник
- **EPFL Dotty API**: https://dotty.epfl.ch/api/scala/Tuple.html
  - Компилятор Dotty (Scala 3)

### Все версии
- **Индекс всех версий API**: https://docs.scala-lang.org/api/all.html

---

## 💻 Исходный код на GitHub

### Основной репозиторий Scala 3
1. **Tuple.scala (main branch)**:
   - https://github.com/scala/scala3/blob/main/library/src/scala/Tuple.scala
   - Строка 12-13: определение `toArray`

2. **Tuple.scala (версия 3.4.2)**:
   - https://github.com/scala/scala3/blob/3.4.2/library/src/scala/Tuple.scala

3. **runtime/Tuples.scala (реализация)**:
   - https://github.com/scala/scala3/blob/main/library/src/scala/runtime/Tuples.scala
   - Строки 7-27: метод `toArray` и `productToArray`

### Просмотр на GitHub
```scala
/** Create a copy of this tuple as an Array */
inline def toArray: Array[Object] =
  runtime.Tuples.toArray(this)
```
Ссылка: https://github.com/scala/scala3/blob/main/library/src/scala/Tuple.scala#L12-L13

---

## 📖 Официальные руководства

### Tour of Scala
- **Tuples**: https://docs.scala-lang.org/tour/tuples.html
  - Общее введение в кортежи
  - Базовые операции

### Scala 3 Book
- **Collections**: https://docs.scala-lang.org/scala3/book/taste-collections.html
  - Коллекции и преобразования

### Статьи
- **Tuples bring generic programming to Scala 3**:
  - https://www.scala-lang.org/2021/02/26/tuples-bring-generic-programming-to-scala-3.html
  - Детальное объяснение улучшений Tuple в Scala 3

---

## 🏠 Локальная документация

### Сгенерированная Scaladoc (ваш проект)
```bash
C:\Work\ScalaCourse\target\scala-3.7.4\api\index.html
```

**Как открыть:**
```bash
# Windows
start target/scala-3.7.4/api/index.html

# Или перейдите в браузере:
file:///C:/Work/ScalaCourse/target/scala-3.7.4/api/index.html
```

**Как обновить:**
```bash
sbt doc
```

### Исходники стандартной библиотеки (извлечены)
```
C:\Work\ScalaCourse\scala-sources\
├── scala\
│   ├── Tuple.scala              ← Trait Tuple с toArray
│   └── runtime\
│       └── Tuples.scala         ← Реализация toArray
```

---

## 📝 Документация в коде (Scaladoc комментарии)

### Tuple.scala:12-13
```scala
/** Create a copy of this tuple as an Array */
inline def toArray: Array[Object] =
  runtime.Tuples.toArray(this)
```

### runtime/Tuples.scala:7-11
```scala
def toArray(self: Tuple): Array[Object] = (self: Any) match {
  case EmptyTuple => Array.emptyObjectArray
  case self: TupleXXL => self.toArray
  case self: Product => productToArray(self)
}
```

### runtime/Tuples.scala:19-27
```scala
def productToArray(self: Product): Array[Object] = {
  val arr = new Array[Object](self.productArity)
  var i = 0
  while (i < arr.length) {
    arr(i) = self.productElement(i).asInstanceOf[Object]
    i += 1
  }
  arr
}
```

---

## 🎓 Дополнительные ресурсы

### Scala Documentation
- **Главная страница**: https://docs.scala-lang.org/
- **Scaladoc руководство**: https://docs.scala-lang.org/scala3/guides/scaladoc/

### Сообщество
- **Scala Users Forum**: https://users.scala-lang.org/
- **Scala Contributors**: https://contributors.scala-lang.org/

### Книги и туториалы
- **Scala Book**: https://docs.scala-lang.org/overviews/scala-book/tuples.html
- **TutorialsPoint**: https://www.tutorialspoint.com/scala/scala_tuples.htm

---

## 🔍 Быстрый поиск

### В онлайн Scaladoc
1. Откройте https://www.scala-lang.org/api/3.7.4/
2. Найдите пакет `scala`
3. Выберите `Tuple` trait
4. Найдите метод `toArray` в списке методов

### В GitHub
1. Откройте https://github.com/scala/scala3
2. Перейдите в `library/src/scala/Tuple.scala`
3. Используйте Ctrl+F для поиска "toArray"

### Локально
```bash
# Поиск в исходниках
grep -r "def toArray" C:/Work/ScalaCourse/scala-sources/

# Генерация и открытие документации
sbt doc
start target/scala-3.7.4/api/index.html
```

---

## ✅ Лучшие источники для изучения

| Источник | Лучше для |
|----------|-----------|
| **Scaladoc API** | Полная сигнатура, все методы |
| **GitHub исходники** | Понимание реализации |
| **Tour of Scala** | Начальное изучение |
| **Локальная документация** | Оффлайн работа |
| **Ваши анализы (toArray_analysis.md)** | Детальное понимание |

## 📂 Созданные вами документы (локально)

1. `toArray_analysis.md` - полный анализ API
2. `toArray_internals.md` - внутренняя реализация
3. `test_toArray.scala` - тесты и примеры
4. `test_toArray_advanced.scala` - продвинутые тесты

**Самая полная документация - комбинация официального Scaladoc + ваши детальные анализы!** 🎯
