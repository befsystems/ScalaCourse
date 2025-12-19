@main def testTuple(): Unit = {
  val t1: Tuple1[Int] = Tuple1(42)
  val t2: Tuple2[Int, String] = Tuple2(1, "hello")
  val t3: (Int, String, Double) = (1, "hi", 3.14)

  // Проверим что это Tuple
  println(s"t1 is Tuple: ${t1.isInstanceOf[Tuple]}")
  println(s"t2 is Tuple: ${t2.isInstanceOf[Tuple]}")
  println(s"t3 is Tuple: ${t3.isInstanceOf[Tuple]}")

  // Проверим иерархию
  println(s"t1 class: ${t1.getClass}")
  println(s"t1 superclass: ${t1.getClass.getSuperclass}")
  println(s"t1 interfaces: ${t1.getClass.getInterfaces.mkString(", ")}")

  // Проверим NonEmptyTuple
  println(s"t1 is NonEmptyTuple: ${t1.isInstanceOf[NonEmptyTuple]}")

  // Проверим *:
  val t4: Int *: String *: EmptyTuple = 1 *: "hi" *: EmptyTuple
  println(s"t4: $t4")
  println(s"t4 class: ${t4.getClass}")
}
