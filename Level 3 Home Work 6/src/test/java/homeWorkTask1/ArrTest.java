package homeWorkTask1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class ArrTest {
    @Test
    void shouldChangeArrSuccessfully_1(){
        int[] arr1 = {1, 2, 3, 4, 5, 6, 4, 7, 9, 0};
        int[] arr2 = {7, 9, 0};
        Assertions.assertArrayEquals(arr2, Arr.changeArr(arr1));
    }

    @Test
    void testExpectedException() {
        int[] arr2 = {7, 9, 0};
        int[] arr1 = {1, 2, 3, 4, 5, 6, 4, 7, 9, 0};
        Assertions.assertThrows(RuntimeException.class, () -> {
            Arr.changeArr(arr2);
        });

    }

    @ParameterizedTest
    @MethodSource("valuesProvider")
    void shouldChangeArrSuccessfully_2(int[] expected, int[] arr){
        Assertions.assertArrayEquals(expected, Arr.changeArr(arr));
    }

    private static Stream<Arguments> valuesProvider(){
        return Stream.of(
                Arguments.arguments(new int[] {5, 6, 0, 7, 9, 0}, new int[] {1, 2, 3, 4, 5, 6, 0, 7, 9, 0}),
                Arguments.arguments(new int[] {0}, new int[] {1, 2, 3, 4, 5, 6, 0, 7, 4, 0}),
                Arguments.arguments(new int[] {0, 7, 7, 0}, new int[] {1, 2, 3, 4, 5, 4, 0, 7, 7, 0}),
                Arguments.arguments(new int[] {2, 3, 10, 5, 3, 0, 7, 7, 0}, new int[] {4, 2, 3, 10, 5, 3, 0, 7, 7, 0}),
                Arguments.arguments(new int[] {4, 2, 3, 10, 5, 3, 0, 7, 7, 0}, new int[] {4, 2, 3, 10, 5, 3, 0, 7, 7, 0})
        );
    }
}
