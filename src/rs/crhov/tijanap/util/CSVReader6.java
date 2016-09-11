package rs.crhov.tijanap.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import rs.crhov.tijanap.soap.Grupa;
import rs.crhov.tijanap.soap.Podatak;
import rs.crhov.tijanap.soap.PrivredniSubjekat;

public class CSVReader6 implements java.io.Serializable{
	public List<PrivredniSubjekat> getValues() {

		String csvFile = "F:\\a\\aa.csv";
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
				/**/
				Grupa g = new Grupa();
				g.setId(ps[1]);
				//
				Podatak p = new Podatak();
				p.setNaziv("DatumPromene");
				p.setVrednost(ps[2]);

				//System.out.println(ps[2]);
				p.setTip("DateTime");
				//
				g.getPodatak().add(p);
				////////////////////////////////////////////
				Podatak pi = new Podatak();
				pi.setNaziv("Identifikatornacinapromene");
				pi.setVrednost(ps[3]);
				pi.setTip("Integer");
				//
				g.getPodatak().add(pi);
				////////////////////////////////////////////
				Podatak pr = new Podatak();
				pr.setNaziv("Identifikatortiparegistracionogpostupka");
				pr.setVrednost(ps[4]);
				pr.setTip("Integer");
				//
				g.getPodatak().add(pi);
				////////////////////////////////////////////
				Podatak pt = new Podatak();
				pt.setNaziv("TipPrivrednogSubjekta");
				pt.setVrednost(ps[5]);
				pt.setTip("Integer");
				//
				g.getPodatak().add(pt);
				////////////////////////////////////////////
				myPS.getGrupa().add(g);
				// myPS.getGrupa().add(grupa.get(0).getPodatak().get(0).getVrednost().add("124"));
				// System.out.println("mb= " + ps[0] + " , tip=" + ps[1]);
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
