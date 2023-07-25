package com.brexson.mockitodemo.list;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ListTest {
    @Test
    void simpleTest() {
        List listMock = mock(List.class);
        when(listMock.size()).thenReturn(3);
        assertEquals(3, listMock.size()); // returns 3 all the time the method is called
        assertEquals(3, listMock.size()); // returns 3 all the time the method is called
        assertEquals(3, listMock.size()); // returns 3 all the time the method is called
    }

    @Test
    void multipleReturns() {
        List listMock = mock(List.class);
        when(listMock.size()).thenReturn(1).thenReturn(2);
        assertEquals(1, listMock.size()); // returns 1 the first time the method is called
        assertEquals(2, listMock.size()); // returns 2 the second time the method is called
        assertEquals(2, listMock.size()); // returns 2 from this point on when the method is called
    }

    @Test
    void specificParameter() {
        List listMock = mock(List.class);
        when(listMock.get(0)).thenReturn("SomeString");
        assertEquals("SomeString", listMock.get(0));
        assertEquals(null, listMock.get(1));
    }
    @Test
    void genericParameter() {
        List listMock = mock(List.class);
        when(listMock.get(Mockito.anyInt())).thenReturn("SomeOtherString"); // return SomeOtherString with any int parameter
        assertEquals("SomeOtherString", listMock.get(0));
        assertEquals("SomeOtherString", listMock.get(1));
        assertEquals("SomeOtherString", listMock.get(555));
    }
}
