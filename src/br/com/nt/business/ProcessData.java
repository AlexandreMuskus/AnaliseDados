package br.com.nt.business;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.Scanner;
import java.util.stream.Stream;

public class ProcessData {
	static String path = System.getProperty("user.home") + File.separator + "data"  + File.separator ;

	private CustomerBO customers = new CustomerBO();
	private SaleBO sales = new SaleBO();
	private SalesmanBO salesman = new SalesmanBO();
	
	public void LoadFile(String file) {
		try (Stream<String> stream = Files.lines(Paths.get(path+file))) {
			stream.forEach(p -> SetDataEntity(p));
		}catch(IOException ioex) {
			System.out.println("erro:data read: " +ioex.getMessage());
		}
	}
	
	public void SetDataEntity(String data) {
		switch (GetDataType(data)) {
		case 1:
			salesman.setSalesman(data);
			break;
		case 2:
			customers.setCustomer(data);
			break;
		case 3:
			sales.setSale(data);
			break;

		default:
			System.out.println ("unrecognized type");
			break;
		}
	}

	private int GetDataType(String data) {
		try {
			return Integer.parseInt(data.substring(0, 3));
		}
		catch (NumberFormatException e)
		{
			return 0;
		}		
	}

	public void GenerateReport() {
		FileWriter resultFile;
		try {
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(new File(path+"out"+File.separator+"Outpu.file"));
		    scanner.useDelimiter("\\Z");
		    String dataOld="";
		    if(scanner.hasNextLine())
	    		dataOld = scanner.next()+"\n\n";
			
			resultFile = new FileWriter(new File(path+"out"+File.separator+"Outpu.file"));
			resultFile.append(dataOld);
			resultFile.append(Instant.now()+"\n");
			resultFile.append("Amount of clients in the input file: " + customers.count()+"\n");
			resultFile.append("Amount of salesman in the input file: " + salesman.count()+"\n");
			resultFile.append("Id of the most expensive sale: " + sales.getIdMostExpensiveSale()+"\n");
			resultFile.append("Worst salesman ever: " + sales.getWorstSalesman()+"\n");
			resultFile.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

