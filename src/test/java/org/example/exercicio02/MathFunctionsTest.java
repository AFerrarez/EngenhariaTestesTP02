package org.example.exercicio02;

import net.jqwik.api.*;
import net.jqwik.api.constraints.IntRange;
import org.junit.jupiter.api.Assertions;

class MathFunctionsTest {


    // Teste baseado na propriedade: O dobro de um número sempre é maior ou igual ao próprio número
    // min e max para limitar o tamanho do int e nao considerar numeros negativos de teste.
    @Property
    void testMultiplyByTwoIsGreaterOrEqual(@ForAll @IntRange(min = Integer.MIN_VALUE , max = Integer.MIN_VALUE )  int number) {
        int result = MathFunctions.multiplyByTwo(number);
        Assertions.assertTrue(result >= number);
    }

    // Teste baseado na propriedade: Se x é par, então multiplyByTwo(x) também deve ser par
    @Property
    void testMultiplyByTwoPreservesEvenNumbers(@ForAll @IntRange(min = Integer.MIN_VALUE / 2, max = Integer.MAX_VALUE / 2) int number){
        int result = MathFunctions.multiplyByTwo(number);
        Assertions.assertEquals(0, result %2);

    }
}