@main def testToArrayAdvanced(): Unit = {
  println("=== toArray: продвинутые тесты ===\n")

  // 1. Boxing примитивов
  println("1. Boxing примитивов:")
  val primitives = (1, 2L, 3.14, true, 'A')
  val arr = primitives.toArray
  println(s"  Tuple: $primitives")
  arr.zipWithIndex.foreach { case (elem, i) =>
    println(s"    [$i] = $elem : ${elem.getClass.getName}")
  }
  println()

  // 2. Вложенные кортежи
  println("2. Вложенные кортежи:")
  val nested = ((1, 2), (3, 4), (5, 6))
  val arrNested = nested.toArray
  println(s"  Tuple: $nested")
  println(s"  toArray: ${arrNested.mkString("[", ", ", "]")}")
  println(s"  arrNested(0): ${arrNested(0)}")
  println(s"  arrNested(0) тип: ${arrNested(0).getClass}")
  println()

  // 3. null элементы
  println("3. Кортеж с null:")
  val withNull = (1, null, "text", null)
  val arrNull = withNull.toArray
  println(s"  Tuple: $withNull")
  println(s"  toArray: ${arrNull.mkString("[", ", ", "]")}")
  println(s"  arrNull(1) == null: ${arrNull(1) == null}")
  println()

  // 4. Именованный кортеж
  println("4. Именованный кортеж:")
  val named = (name = "Alice", age = 30, city = "Berlin")
  val arrNamed = named.toArray
  println(s"  Named tuple: $named")
  println(s"  toArray: ${arrNamed.mkString("[", ", ", "]")}")
  println(s"  Имена полей потеряны в массиве!")
  println()

  // 5. Сравнение toArray, toList, toIArray
  println("5. toArray vs toList vs toIArray:")
  val t = (1, 2, 3, 4, 5)
  val asArray = t.toArray
  val asList = t.toList
  val asIArray = t.toIArray

  println(s"  Tuple: $t")
  println(s"  toArray:  ${asArray.mkString("[", ", ", "]")}")
  println(s"    Тип: ${asArray.getClass}")
  println(s"    Изменяемый: да")

  println(s"  toList:   ${asList.mkString("[", ", ", "]")}")
  println(s"    Тип: ${asList.getClass}")
  println(s"    Изменяемый: нет")

  println(s"  toIArray: ${asIArray.mkString("[", ", ", "]")}")
  println(s"    Тип: ${asIArray.getClass}")
  println(s"    Изменяемый: нет")
  println()

  // 6. Цикл toArray -> fromArray
  println("6. Цикл преобразований:")
  val original = (1, "hello", 3.14)
  println(s"  Оригинал:        $original : ${original.getClass}")
  val arr1 = original.toArray
  println(s"  toArray:         ${arr1.mkString("[", ", ", "]")}")
  val restored = Tuple.fromArray(arr1)
  println(s"  fromArray:       $restored : ${restored.getClass}")
  println(s"  Идентичны:       ${original == restored}")
  println()

  // 7. toArray и pattern matching
  println("7. Работа с массивом в pattern matching:")
  val t2 = (10, 20, 30)
  t2.toArray match {
    case Array(a, b, c) =>
      println(s"  Распаковка: a=$a, b=$b, c=$c")
    case _ =>
      println("  Не совпало")
  }
  println()

  // 8. Сравнение размеров для разных кортежей
  println("8. Размеры и классы:")
  val sizes = List(
    EmptyTuple,
    Tuple1(1),
    (1, 2),
    (1, 2, 3, 4, 5, 6, 7, 8, 9, 10),
    (1 to 22).foldLeft(EmptyTuple: Tuple)(_ :* _),
    (1 to 25).foldLeft(EmptyTuple: Tuple)(_ :* _)
  )

  sizes.foreach { t =>
    val arr = t.toArray
    println(f"  Размер: ${arr.length}%3d | Класс: ${t.getClass.getSimpleName}%-15s | Array.length: ${arr.length}")
  }
  println()

  // 9. Производительность: доступ по индексу
  println("9. Сравнение доступа по индексу:")
  val largeTuple = (1 to 10).foldLeft(EmptyTuple: Tuple)(_ :* _)
  val largeArray = largeTuple.toArray

  // Tuple: через apply()
  val start1 = System.nanoTime()
  var sum1 = 0
  for (i <- 0 until 10000) {
    sum1 += largeTuple(5).asInstanceOf[Int]
  }
  val time1 = (System.nanoTime() - start1) / 1000000.0
  println(s"  Tuple.apply(5) x 10000: ${time1}%.3f ms")

  // Array: прямой доступ
  val start2 = System.nanoTime()
  var sum2 = 0
  for (i <- 0 until 10000) {
    sum2 += largeArray(5).asInstanceOf[Int]
  }
  val time2 = (System.nanoTime() - start2) / 1000000.0
  println(s"  Array(5) x 10000:       ${time2}%.3f ms")
  println(s"  Speedup: ${(time1/time2)}%.2fx быстрее")
}
