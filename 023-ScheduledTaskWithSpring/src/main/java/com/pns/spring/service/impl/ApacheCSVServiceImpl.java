package com.pns.spring.service.impl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import com.pns.spring.entity.Employee;
import com.pns.spring.service.ApacheCSVService;

public class ApacheCSVServiceImpl implements ApacheCSVService {

	@Override
	public String writeEmployeesToCsv(String[] header, List<Employee> list) {
		CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader(header);
		String writeToPath = "src/main/resources/employee.csv";
		try (Writer writer = new FileWriter(new File(writeToPath), false);
				CSVPrinter printer = new CSVPrinter(writer, csvFormat);) {
			printer.printRecords(list);
			return writeToPath;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
