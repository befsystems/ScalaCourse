import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.must.Matchers.noException
import org.scalatest.matchers.should.Matchers

class MainTest extends AnyFunSuite {


}

class MainTest2 extends AnyFlatSpec with Matchers {


}

/*Основные отличия между AnyFunSuite и AnyFlatSpec:

  AnyFunSuite:
    - Использует метод test("описание теста")
      - Более простой и прямолинейный синтаксис
      - Проверки через assert(условие)
    - Подходит для быстрого написания тестов

  AnyFlatSpec:
    - Использует BDD-стиль: "объект" should "поведение" in
  - Требует подключения Matchers для удобных проверок
  - Проверки через матчеры: shouldBe, should be thrownBy
  - Более читаемый, близкий к естественному языку
  - Лучше структурирует тесты по поведению
  
  */


/*В ScalaTest есть несколько основных стилей тестирования:

  1. AnyFunSuite - функциональный стиль с test("описание")

  2. AnyFlatSpec - BDD-стиль с "объект" should "поведение" in

  3. AnyWordSpec - вложенный BDD-стиль:
    "A Stack" when {
      "empty" should {
      "be empty" in { ... }
    }
    }

  4. AnyFreeSpec - свободный стиль с дефисами:
    "A Stack" - {
      "when empty" - {
      "should be empty" in { ... }
    }
    }

  5. AnyFunSpec - стиль describe/it (как в RSpec):
    describe("A Stack") {
    it("should pop values in LIFO order") { ... }
  }

  6. AnyPropSpec - для property-based тестирования

  7. AnyFeatureSpec - для acceptance-тестов в стиле Given/When/Then

  Самые популярные: AnyFunSuite (простой), AnyFlatSpec (BDD), AnyFunSpec (describe/it).*/

