package com.nhnacademy.practice.array;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import com.nhnacademy.practice.myarray.IntegerArray;
import com.nhnacademy.practice.myarray.MyArray;
import java.lang.reflect.Field;
import java.util.stream.Stream;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * @author : 이성준
 * @since : 1.0
 */


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ArrayTest {

    @Order(1)
    @Test
    void newInstance() throws NoSuchFieldException, IllegalAccessException {
        MyArray<Integer> myArray = new IntegerArray();

        assertThat(myArray, notNullValue());
        assertDoesNotThrow(() -> assertThat(myArray.isEmpty(), equalTo(true)));

        Field o = myArray.getClass().getDeclaredField("intArray");

        if (o.getType().equals(int[].class)) {
            o.setAccessible(true);
            int[] ints = (int[]) o.get(myArray);
            assertThat(ints.length, equalTo(0));
        } else {
            assert false;
        }
    }

    @Order(2)
    @ParameterizedTest
    @MethodSource("addElementTestParameter")
    void addElement(int[] array) {
        MyArray<Integer> myArray = new IntegerArray();

        for (int i : array) {
            myArray.add(i);
        }

        assertThat(myArray.size(), equalTo(array.length));
    }

    @Order(3)
    @ParameterizedTest
    @MethodSource("indexOfTestParameter")
    void indexOf(MyArray<Integer> myArray, int target, int expected) {
        int actual = myArray.indexOf(target);

        assertThat(actual, equalTo(expected));
    }

    @Order(4)
    @ParameterizedTest
    @MethodSource("getElementTestParameter")
    void getElement(MyArray<Integer> myArray, int target, int expected) {
        int actual = myArray.get(target);

        assertThat(actual, equalTo(expected));
    }

    @Order(5)
    @ParameterizedTest
    @MethodSource("removeElementTestParameter")
    void removeElement(MyArray<Integer> myArray, int removeTarget) {
        boolean actual = myArray.remove(removeTarget);

        assert actual;
        assertThat(myArray.size(), not(lessThan(0)));
        assertThat(myArray.indexOf(removeTarget), equalTo(-1));
    }

    @Order(6)
    @Test
    void iterableMyArray() {
        MyArray<Integer> myArray = newMyArrayInstance();

        if (myArray instanceof Iterable<?> iterable) {

            for (Object o : iterable) {
                assertThat(myArray.indexOf((int)o), not(equalTo(-1)));
            }
        } else {
            assert false;
        }
    }

    public static Stream<int[]> addElementTestParameter() {
        return Stream.of(new int[] {22, 3, 4, 5});
    }

    public static Stream<Arguments> indexOfTestParameter() {
        return Stream.of(
                Arguments.of(newMyArrayInstance(), 9, 3),
                Arguments.of(newMyArrayInstance(), 3, 0),
                Arguments.of(newMyArrayInstance(), 5, 2),
                Arguments.of(newMyArrayInstance(), 7, 1),
                Arguments.of(newMyArrayInstance(), 1, 4),
                Arguments.of(newMyArrayInstance(), 9882393, -1)
        );
    }

    public static Stream<Arguments> getElementTestParameter() {
        return Stream.of(
                Arguments.of(newMyArrayInstance(), 3, 9),
                Arguments.of(newMyArrayInstance(), 0, 3),
                Arguments.of(newMyArrayInstance(), 2, 5),
                Arguments.of(newMyArrayInstance(), 1, 7),
                Arguments.of(newMyArrayInstance(), 4, 1)
        );
    }

    public static Stream<Arguments> removeElementTestParameter() {
        return Stream.of(
                Arguments.of(newMyArrayInstance(), 9),
                Arguments.of(newMyArrayInstance(), 3),
                Arguments.of(newMyArrayInstance(), 5),
                Arguments.of(newMyArrayInstance(), 7),
                Arguments.of(newMyArrayInstance(), 1)
        );
    }

    private static MyArray<Integer> newMyArrayInstance() {
        MyArray<Integer> myArray = new IntegerArray();
        myArray.add(3);
        myArray.add(7);
        myArray.add(5);
        myArray.add(9);
        myArray.add(1);
        return myArray;
    }

}
