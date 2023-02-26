package seminars.third.coverage;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SomeServiceTest {
    private SomeService someService;

   @BeforeEach
   void setUp() {
            someService = new SomeService();
        }

   @Test
   void checkFizzBuzz(){
       assertThat(someService.fizzBuzz(15)).isEqualTo("FizzBuzz");
   }

    @Test
    void checkFizz(){
        assertThat(someService.fizzBuzz(3)).isEqualTo("Fizz");
    }

    @Test
    void checkBuzz(){
        assertThat(someService.fizzBuzz(5)).isEqualTo("Buzz");
    }

    @Test
    void checkFizzBuzzOther(){
        assertThat(someService.fizzBuzz(14)).isEqualTo(""+14);
    }


    @Test
    void checkFirst6onTrue(){
       assertTrue(someService.firstLast6(new int[]{6, 3, 5, 8}));
    }

    @Test
    void checkLast6onTrue(){
        assertTrue(someService.firstLast6(new int[]{1, 3, 8, 6}));
    }

    @Test
    void checkLast6onFalse(){
        assertFalse(someService.firstLast6(new int[]{1, 3, 8, 9}));
    }

    //Задание 1
    @Test
    void checkCalculatingDiscont(){
       assertThat(someService.calculatingDiscount(100, 10)).isEqualTo(90);
    }

    @Test
    void checkCalculatingDiscontExeptionProc() {
        assertThatThrownBy(() -> someService.calculatingDiscount(100, 120))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Скидка должна быть в диапазоне от 0 до 100%");
    }

    @Test
    void checkCalculatingDiscontExeptionProcMin() {
        assertThatThrownBy(() -> someService.calculatingDiscount(100, -20))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Скидка должна быть в диапазоне от 0 до 100%");
    }

    @Test
    void checkCalculatingDiscontExeptionSum() {
        assertThatThrownBy(() -> someService.calculatingDiscount(-100, 50))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Сумма покупки не может быть отрицательной");
    }

    @Test
    void luckySumA(){
       assertThat(someService.luckySum(13, 2, 3)).isEqualTo(5);
    }

    @Test
    void luckySumB(){
        assertThat(someService.luckySum(5, 13, 3)).isEqualTo(8);
    }

    @Test
    void luckySumC(){
        assertThat(someService.luckySum(10, 2, 13)).isEqualTo(12);
    }

    @Test
    void luckySumOther(){
        assertThat(someService.luckySum(10, 2, 8)).isEqualTo(20);
    }
}