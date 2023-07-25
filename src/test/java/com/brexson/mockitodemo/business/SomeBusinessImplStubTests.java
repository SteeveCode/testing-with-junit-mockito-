package com.brexson.mockitodemo.business;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

// Testing with Stubs
public class SomeBusinessImplStubTests {

    @Test
    void findTheGreatestFromAllData_basicScenario() {
        DataService dataServiceStub = new DataServiceStub1();
        SomeBusinessImpl businessImpl = new SomeBusinessImpl(dataServiceStub);
        int result = businessImpl.findTheGreatestFromAllData();
        assertEquals(25, result);
    }
    class DataServiceStub1 implements DataService {
        @Override
        public int[] retrieveAllData() {
            return new int[]{25};
        }

    }
}
