package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HomeWorkTest {
    private Node<Integer> head;
    private HomeWork homeWork;

//    список 1, 2, 3, 4, 5, -3
    @BeforeEach
    public void start() {
        head = new Node<>(1);
        head.add(2);
        head.add(3);
        head.add(4);
        head.add(5);
        head.add(-3);
        homeWork = new HomeWork();
    }

    @Test
    void partitionBy() {
        Predicate<Integer> pred = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer < 4;
            }
        };
        Predicate<Integer> predZero = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer < 0;
            }
        };
        assertEquals(4, homeWork.partitionBy(head, pred));
        assertEquals(1, homeWork.partitionBy(head, predZero));
        assertEquals(0, homeWork.partitionBy(head, null));
        assertEquals(0, homeWork.partitionBy(null, predZero));
    }

    @Test
    void findNthElement() {
        assertEquals(2, homeWork.findNthElement(head, 1));
        assertEquals(head.getValue(), homeWork.findNthElement(head, 0));
        assertEquals((Integer) null, homeWork.findNthElement(null, 0));
        assertEquals(null, homeWork.findNthElement(head, -1));
        assertEquals(null, homeWork.findNthElement(head, 100));
    }
}