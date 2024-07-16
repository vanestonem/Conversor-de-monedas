package ConversorMonedas;

import javax.swing.JOptionPane;

public class OpcionesConversion {
	
	ConvertirMonedas monedas = new ConvertirMonedas();
	
	public void ConvertirMonedas(double valor) {
	
	String opcion = (JOptionPane.showInputDialog(null,
			"Escoge la moneda en la que deseas convertir tu dinero ",  "Monedas",
			JOptionPane.PLAIN_MESSAGE, null, new Object[]
					{"De Pesos a Dólar", "De Pesos a Euro", "De Pesos a Libras Esterlinas", "De Pesos a Yen Japonés", "De Pesos a Won sub-coreano", "De Dólar a Pesos", "De Euro a Pesos", "De Libras Esterlinas a Pesos", "De Yen Japonés a Pesos", "De Won sub-coreano a Pesos"}, 
					"Seleccion")).toString();
	
	switch (opcion) {
	case "De Pesos a Dólar": 
		monedas.ConvertirPesosMexicanosDolares(valor);
		break;
	
	case "De Pesos a Euro": 
		monedas.ConvertirPesosMexicanosEnEuros(valor);
		break;
		
	case "De Pesos a Libras Esterlinas":
		monedas.ConvertirPesosMexicanosEnLibra(valor);
		break;
		
	case "De Pesos a Yen Japonés":
		monedas.ConvertirPesosMexicanosEnYen(valor);
		break;
		
	case "De Pesos a Won sub-coreano":
		monedas.ConvertirPesosMexicanosEnWon(valor);
		break;
	
	case "De Dólar a Pesos":
		monedas.ConvertirDolaresEnPesosMexicanos(valor);
		break;
		
	case "De Euro a Pesos":
		monedas.ConvertirEurosEnPesosMexicanos(valor);
		break;
		
	case "De Libras Esterlinas a Pesos":
		monedas.ConvertirLibraEnPesosMexicanos(valor);
		break;
	 
	case "De Yen Japonés a Pesos":
		monedas.ConvertirYenEnPesosMexicanos(valor);
		break;
		
	case "De Won sub-coreano a Pesos":
		monedas.ConvertirWonEnPesosMexicanos(valor);
		break;
	}
	}

}
