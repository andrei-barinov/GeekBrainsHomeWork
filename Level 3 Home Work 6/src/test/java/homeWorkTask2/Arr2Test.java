package homeWorkTask2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class Arr2Test {

    @ParameterizedTest
    @MethodSource("valueProvider")
    void checkArrSuccessfully(boolean result){
        Assertions.assertTrue(result);
    }

    private static Stream<Arguments> valueProvider(){
        return Stream.of(
                Arguments.arguments(Arr2.checkArr(new int[] {9, 2, 3, 4, 5, 6, 0, 7, 9, 0})),
                Arguments.arguments(Arr2.checkArr(new int[] {5, 2, 3, 3, 5, 6, 0, 7, 9, 0})),
                Arguments.arguments(Arr2.checkArr(new int[] {5, 2, 3, 3, 1, 6, 0, 7, 9, 0})),
                Arguments.arguments(Arr2.checkArr(new int[] {5, 2, 4, 3, 1, 6, 0, 7, 9, 0}))
        );
    }
}
