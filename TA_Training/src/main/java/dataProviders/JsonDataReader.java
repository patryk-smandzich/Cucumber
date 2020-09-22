package dataProviders;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import io.cucumber.messages.internal.com.google.gson.Gson;
import managers.FileReaderManager;
import testDataTypes.Informations;

public class JsonDataReader {

	private final String informationsFilePath = FileReaderManager.getInstance().getConfigReader()
			.getTestDataResourcePath() + "Informations.json";
	private List<Informations> informationsList;

	public JsonDataReader() {
		informationsList = getInformationsListData();
	}

	private List<Informations> getInformationsListData() {
		Gson gson = new Gson();
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(informationsFilePath));
			Informations[] info = gson.fromJson(bufferReader, Informations[].class);
			return Arrays.asList(info);
		} catch (FileNotFoundException e) {
			throw new RuntimeException("Json file not found at path : " + informationsFilePath);
		} finally {
			try {
				if (bufferReader != null)
					bufferReader.close();
			} catch (IOException ignore) {
			}
		}
	}

	public final Informations getInformationsByName(String customerName) {
		return informationsList.stream().filter(x -> x.firstName.equalsIgnoreCase(customerName)).findAny().get();
	}

}
