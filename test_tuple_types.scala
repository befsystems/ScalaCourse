@main def testTupleTypes(): Unit = {
  import scala.reflect.ClassTag

  val t1 = Tuple1(42)
  val t2 = (1, "hello")

  // Явно указываем тип как Tuple
  val asTuple: Tuple = t1

  // Проверяем все интерфейсы и суперклассы
  def printHierarchy(obj: Any): Unit = {
    val cls = obj.getClass
    println(s"Class: ${cls.getName}")
    println(s"Superclass: ${cls.getSuperclass}")
    println(s"Interfaces: ${cls.getInterfaces.map(_.getName).mkString(", ")}")

    // Рекурсивно проверим суперкласс
    var superCls = cls.getSuperclass
    var level = 1
    while (superCls != null) {
      println(s"  Level $level: ${superCls.getName}")
      println(s"    Interfaces: ${superCls.getInterfaces.map(_.getName).mkString(", ")}")
      superCls = superCls.getSuperclass
      level += 1
    }
  }

  println("=== Tuple1 ===")
  printHierarchy(t1)

  println("\n=== Tuple2 ===")
  printHierarchy(t2)
}
