package br.com.Money;

/**
 * FAO.java
 *  Lê e Persiste os dados
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

public class FAO {

	
	/**
	 * Método Responsável por ler o Arquivo
	 * @param accounts ArrayList
	 **/
	
	public void readFile(ArrayList<Account> contas) throws FileNotFoundException, IOException {
		Path path = Paths.get("Accounts.txt");

		try {
			BufferedReader reader = Files.newBufferedReader(path, Charset.defaultCharset());
			String line;
			String linha[] = new String[4];
			while ((line = reader.readLine()) != null) {
			//	System.out.println(line);
				linha = line.split(",");
				int accountNumber = Integer.parseInt(linha[0]);
				int pin = Integer.parseInt(linha[1]);
				double availableBalance = Double.parseDouble(linha[2]);
				double totalBalance = Double.parseDouble(linha[3]);

				Account contaAux = new Account(accountNumber, pin, availableBalance, totalBalance);
				contas.add(contaAux);

			}
			reader.close();
		} catch (FileNotFoundException x) {
			System.err.format("FileNotFoundException: %s%n", x);
		} catch (IOException ex) {
			System.err.format("IOException: %s%n", ex);
		}

		System.out.printf("%-17s%-10s%-11s%12s\n", "Conta", "PIN", "Saldo", "Saldo Total");
		for (Account conta : contas) {
			conta.toString();
		}

	}

	/**
	 * Método Responsável por gravar os dados
	 * @param accounts ArrayList
	 **/
	
	public void writeFile(ArrayList<Account> contas) throws FileNotFoundException, IOException {
		Path path = Paths.get("Accounts.txt");
		
		try {
			BufferedReader reader = Files.newBufferedReader(path);
			BufferedWriter writer = Files.newBufferedWriter(path);		
			contas.forEach(data -> {
			
				System.out.println(data.toStringWriter());
				try {
					writer.write(data.toStringWriter());
					writer.newLine();
				} catch (IOException e) {
					System.err.format("IOException %s%n", e);
				}				
			});
							
			writer.flush();
			writer.close();
			reader.close();
			
		}catch (FileNotFoundException x) {
			System.err.format("FileNotFoundException: %s%n", x);
		} catch (IOException ex) {
			System.err.format("IOException: %s%n", ex);
		}
	}

}
