@main def testToArray(): Unit = {
  println("=== Операция toArray для кортежей ===\n")

  // 1. Базовое использование
  println("1. Базовые примеры:")
  val t1 = (1, "hello", 3.14)
  val arr1 = t1.toArray
  println(s"  Tuple: $t1")
  println(s"  toArray: ${arr1.mkString("[", ", ", "]")}")
  println(s"  Тип: ${arr1.getClass}")
  println()

  // 2. Пустой кортеж
  println("2. Пустой кортеж:")
  val empty = EmptyTuple
  val arrEmpty = empty.toArray
  println(s"  EmptyTuple.toArray: ${arrEmpty.mkString("[", ", ", "]")}")
  println(s"  Длина: ${arrEmpty.length}")
  println()

  // 3. Разные типы элементов
  println("3. Смешанные типы:")
  val mixed = (42, "text", true, List(1, 2, 3), 3.14, 'A')
  val arrMixed = mixed.toArray
  println(s"  Tuple: $mixed")
  println(s"  toArray: ${arrMixed.mkString("[", ", ", "]")}")
  println(s"  Типы элементов:")
  arrMixed.zipWithIndex.foreach { case (elem, idx) =>
    println(s"    [$idx] = $elem : ${elem.getClass.getSimpleName}")
  }
  println()

  // 4. Одноэлементный кортеж
  println("4. Tuple1:")
  val single = Tuple1(99)
  val arrSingle = single.toArray
  println(s"  Tuple1(99).toArray: ${arrSingle.mkString("[", ", ", "]")}")
  println()

  // 5. Доступ к элементам массива
  println("5. Доступ к элементам:")
  val t2 = ("zero", "one", "two", "three")
  val arr2 = t2.toArray
  println(s"  Оригинальный tuple: $t2")
  println(s"  arr2(0) = ${arr2(0)}")
  println(s"  arr2(2) = ${arr2(2)}")
  println()

  // 6. Мутабельность массива
  println("6. Изменяемость массива:")
  val t3 = (1, 2, 3)
  val arr3 = t3.toArray
  println(s"  Оригинальный tuple: $t3")
  println(s"  Массив до изменения: ${arr3.mkString("[", ", ", "]")}")
  arr3(0) = 999.asInstanceOf[Object]
  println(s"  Массив после arr3(0) = 999: ${arr3.mkString("[", ", ", "]")}")
  println(s"  Оригинальный tuple: $t3 (не изменился!)")
  println()

  // 7. Обратное преобразование
  println("7. Обратное преобразование fromArray:")
  val arr4 = Array[Object]("a", "b", "c")
  val tuple4 = Tuple.fromArray(arr4)
  println(s"  Array: ${arr4.mkString("[", ", ", "]")}")
  println(s"  fromArray: $tuple4")
  println(s"  Тип: ${tuple4.getClass}")
  println()

  // 8. Большой кортеж (XXL)
  println("8. Большой кортеж (>22 элементов):")
  val bigTuple = (1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
                  11, 12, 13, 14, 15, 16, 17, 18, 19, 20,
                  21, 22, 23, 24, 25)
  val arrBig = bigTuple.toArray
  println(s"  Размер кортежа: ${bigTuple.size}")
  println(s"  Класс: ${bigTuple.getClass.getSimpleName}")
  println(s"  Размер массива: ${arrBig.length}")
  println(s"  Первые 5 элементов: ${arrBig.take(5).mkString("[", ", ", "]")}")
  println(s"  Последние 5 элементов: ${arrBig.takeRight(5).mkString("[", ", ", "]")}")
  println()

  // 9. Сравнение toArray и toList
  println("9. toArray vs toList:")
  val t5 = (1, 2, 3, 4, 5)
  val asArray = t5.toArray
  val asList = t5.toList
  println(s"  Tuple: $t5")
  println(s"  toArray: ${asArray.mkString("[", ", ", "]")} : ${asArray.getClass}")
  println(s"  toList:  ${asList.mkString("[", ", ", "]")} : ${asList.getClass}")
}
