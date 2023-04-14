package com.kiddcorp;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class AboutTime {

	public static void main(String[] args) {
		Set<String> allZones = ZoneId.getAvailableZoneIds();
		LocalDateTime dt = LocalDateTime.now();

		// Create a List using the set of zones and sort it.
		List<String> zoneList = new ArrayList<String>(allZones);
		Collections.sort(zoneList);

		for (String s : zoneList) {
			ZoneId zone = ZoneId.of(s);
			ZonedDateTime zdt = dt.atZone(zone);
			ZoneOffset offset = zdt.getOffset();
			int secondsOfHour = offset.getTotalSeconds() % (60 * 60);
			String out = String.format("%35s %10s%n", zone, offset);

			// Write only time zones that do not have a whole hour offset
			// to standard out.
			if (secondsOfHour != 0) {
				System.out.printf(out);
			}
			m1();
		}
	}

	static void m1() {
		DateTimeFormatter format = DateTimeFormatter.ofPattern("MMM d yyyy  hh:mm a");

		// Leaving from San Francisco on July 20, 2013, at 7:30 p.m.
		LocalDateTime leaving = LocalDateTime.of(2013, Month.JULY, 20, 19, 30);
		ZoneId leavingZone = ZoneId.of("America/Los_Angeles");
		ZonedDateTime departure = ZonedDateTime.of(leaving, leavingZone);

		try {
			String out1 = departure.format(format);
			System.out.printf("LEAVING:  %s (%s)%n", out1, leavingZone);
		} catch (DateTimeException exc) {
			System.out.printf("%s can't be formatted!%n", departure);
			throw exc;
		}

		// Flight is 10 hours and 50 minutes, or 650 minutes
		ZoneId arrivingZone = ZoneId.of("Asia/Tokyo");
		ZonedDateTime arrival = departure.withZoneSameInstant(arrivingZone)
		.plusMinutes(650);

		try {
			String out2 = arrival.format(format);
			System.out.printf("ARRIVING: %s (%s)%n", out2, arrivingZone);
		} catch (DateTimeException exc) {
			System.out.printf("%s can't be formatted!%n", arrival);
			throw exc;
		}

		if (arrivingZone.getRules().isDaylightSavings(arrival.toInstant()))
			System.out.printf("  (%s daylight saving time will be in effect.)%n", arrivingZone);
		else
			System.out.printf("  (%s standard time will be in effect.)%n", arrivingZone);
	}
}
