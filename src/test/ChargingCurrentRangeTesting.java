package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import main.BatteryCurrentReading;

public class ChargingCurrentRangeTesting {
	BatteryCurrentReading batteryCurrentReading;
	List<Integer> readings;
	HashMap<String,Integer> expectedValues;
	
	@Before
	public void executedBeforeEach() {
		readings = new ArrayList<Integer>(Arrays.asList(1,3,2,1,7,6,8));
		batteryCurrentReading = new BatteryCurrentReading();
		expectedValues = new HashMap<String,Integer>();
		expectedValues.put("1-3", 4);
		expectedValues.put("6-8", 3);
	}
	
	@Test
	public void givenList_whenEmpty_thenReturnNull() {
		readings = new ArrayList<Integer>();
		assertNull(batteryCurrentReading.checkCurrentRangeAndReadings(readings));
	}
	
	@Test
	public void givenList_whenNull_thenReturnNull() {
		readings = null;
		assertNull(batteryCurrentReading.checkCurrentRangeAndReadings(readings));
	}
	
	@Test
	public void givenList_whenContainsNull_thenReturnNull() {
		readings = new ArrayList<Integer>(Arrays.asList(1,3,2,1,7,6,8,null));
		assertNull(batteryCurrentReading.checkCurrentRangeAndReadings(readings));
	}
	
	@Test
	public void givenList_whenOnlyOneElement_thenReturnNull() {
		readings = new ArrayList<Integer>(Arrays.asList(1));
		assertNull(batteryCurrentReading.checkCurrentRangeAndReadings(readings));
	}
	
	@Test
	public void givenList_whenContainsValues_thenReturnRangeAndCount() {
		readings = new ArrayList<Integer>(Arrays.asList(1,3,2,1,7,6,8));
		assertEquals(expectedValues,batteryCurrentReading.checkCurrentRangeAndReadings(readings));
	}
	
}
