package rs.crhov.tijanap.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import rs.crhov.tijanap.soap.Grupa;
import rs.crhov.tijanap.soap.PrivredniSubjekat;

public class CSVReader implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public List<PrivredniSubjekat> getValues() {

		String csvFile = "F:\\a\\a1.csv";
		String line = "";
		String cvsSplitBy = ",";
		List<PrivredniSubjekat> psList = new ArrayList<PrivredniSubjekat>();
		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

			while ((line = br.readLine()) != null) {
				List<Grupa> grupa = new ArrayList<Grupa>();
				PrivredniSubjekat myPS = new PrivredniSubjekat();

				// use comma as separator
				String[] ps = line.split(cvsSplitBy);
				myPS.setMaticniBroj(ps[0]);
				myPS.setTip(ps[1]);		
				
				psList.add(myPS);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return psList;

	}

	public static Date parseStringToDate(String dateString) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateInString = dateString;
		Date date = null;

		try {

			date = formatter.parse(dateInString);
			//System.out.println(date);
			//System.out.println(formatter.format(date));

		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;

	}

}

