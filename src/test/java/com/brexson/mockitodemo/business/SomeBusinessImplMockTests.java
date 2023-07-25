package com.brexson.mockitodemo.business;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

// Testing with Mocks
@ExtendWith(MockitoExtension.class)
public class SomeBusinessImplMockTests {
//    Note: The Mock test below was done without any Mockito annotation. It used only static import classes from Mockito
//    Hence, if all the annotations present in this test class were removed, the mock test will still be successful
//    @Test
//    void findTheGreatestFromAllData_basicScenario() {
//        DataService dataServiceMock = mock(DataService.class);
//        when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{25, 15, 45});
//        SomeBusinessImpl businessImpl = new SomeBusinessImpl(dataServiceMock);
//        int result = businessImpl.findTheGreatestFromAllData();
//        System.out.println(result);
//        assertEquals(45, result);
//    }

    @Mock
    DataService dataService;
    @InjectMocks
    SomeBusinessImpl businessImpl;
    @Test
    void findTheGreatestFromAllData_basicScenario() {
        when(dataService.retrieveAllData()).thenReturn(new int[]{25, 15, 45});
        int result = businessImpl.findTheGreatestFromAllData();
        assertEquals(45, result);
        System.out.println(result);
    }
    @Test
    void findTheGreatestFromAllData_oneValue() {
        when(dataService.retrieveAllData()).thenReturn(new int[]{15});
        int result = businessImpl.findTheGreatestFromAllData();
        assertEquals(15, result);
        System.out.println(result);
    }
    @Test
    void findTheGreatestFromAllData_emptyArray() {
        when(dataService.retrieveAllData()).thenReturn(new int[]{});
        assertEquals(Integer.MIN_VALUE, businessImpl.findTheGreatestFromAllData());
        System.out.println(businessImpl.findTheGreatestFromAllData());
    }
}
