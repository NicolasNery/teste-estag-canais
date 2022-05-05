import java.util.Scanner;
public class TesteItau {	
	
	public static void main(String[] args) {
		Scanner myObj = new Scanner(System.in);
		//Abaixo,inicializacao das variaveis a serem usadas no algoritmo.
		int id_transferencia = 0;
		float valor_transferencia = 0;
		String tipo_transferencia = "";
		String nome_emissor ="";
		String agencia_emissor ="";
		String conta_emissor = "";
		String cpf_emissor = "";
		String nome_receptor = "";
		String agencia_receptor = "";
		String conta_receptor = "";
		String cpf_receptor= "";
		
		float saldo_emissor=0;
		float saldo_receptor=0;
		//abaixo,sistema pede que o usuario entre os comandos a serem guardados nas variaveis inicializadas acima.
		System.out.println("Digite o nome do emissor:");
		nome_emissor = myObj.nextLine();
		System.out.println("Digite o cpf do emissor:");
		cpf_emissor = myObj.nextLine();
		
		if (cpf_emissor.length()>14) { //Verifica se o CPF digitado excede 14 algorismos (contanto "."s)
			System.out.println("Sua transferência não foi completada pois o valor digitado excede o numero de algorismos comuns a CPF.");
			System.exit(0);
		} 
		
		System.out.println("Digite a agencia do emissor:");
		agencia_emissor = myObj.nextLine();
		System.out.println("Digite a conta do emissor:");
		conta_emissor = myObj.nextLine();
	    //Acima,dados do emissor | Abaixo,dados do receptor
		System.out.println("Digite o nome do receptor:");
		nome_receptor = myObj.nextLine();
		System.out.println("Digite o cpf do receptor:");
		cpf_receptor = myObj.nextLine();
		
		if (cpf_receptor.length()>14) { //Mesmo teste realizado nas linhas de codigo #27-#30.
			System.out.println("Sua transferência não foi completada pois o valor digitado excede o numero de algorismos comuns a CPF.");
			System.exit(0);
		}
		
		System.out.println("Digite a agencia do receptor:");
		agencia_receptor = myObj.nextLine();
		System.out.println("Digite a conta do receptor:");
		conta_receptor = myObj.nextLine();
		
		if(conta_receptor.equals(conta_emissor)) {
			System.out.println("Sua transferência não foi completada pois transferencias para a mesma conta não podem ser realizadas");
			System.exit(0);
		}
		//Acima, sistema verifica caso de teste #7 | Abaixo,sistema pede que o usuario selecione o tipo de transferencia.
		System.out.println("Selecione o Tipo de transferencia a ser realizada:");
		System.out.println("1-PIX");
		System.out.println("2-TED");
		System.out.println("3-DOC");
		
		int resposta =  myObj.nextInt();
		
		if ( resposta == 1 ) {
			tipo_transferencia = "PIX";
		}else {if(resposta == 2){
			tipo_transferencia = "TED";
		}
		else {if(resposta == 3) {
			tipo_transferencia = "DOC";
		}else{
			System.out.println("Sua transferência não foi completada pois valor digitado não correspode a nenhuma opção");
			}
		  }
		}
        //Acima,sistema verifica se a entrada do usuario se aplica as opcoes propostas|Abaixo,sistema pede que usuario digite valor da transferencia e verifica os casos de teste #4,#5 e #6
		System.out.println("Digite o valor a ser transferido:");
		valor_transferencia = myObj.nextFloat();
		if (tipo_transferencia == "PIX" ) {
		   if(valor_transferencia>5000.00) {
		   System.out.println("Sua transferência não foi completada pois o valor digitado excede o maximo de R$5000.00 permitido a transferencias PIX.");
		   System.exit(0);
		   }
		}
		if (tipo_transferencia == "TED" ) {
			   if(valor_transferencia>10000.00 || valor_transferencia<5000.00) {
			   System.out.println("Sua transferência não foi completada pois o valor digitado excede o maximo de R$10,000.00 ou esta abaixo do minimo de R$5000.00 permitido a transferencias TED.");
			   System.exit(0);
			   }
			   
		}
		if (tipo_transferencia == "DOC" ) {
			   if(valor_transferencia<10000.00) {
			   System.out.println("Sua transferência não foi completada pois o valor digitado esta abaixo do minimo de R$10,000.00 permitido a transferencias DOC.");
			   System.exit(0);
			   }
			   
		}
		//Abaixo,sistema finaliza a transferencia,especifica o id_transferencia e comunica o resultado ao usuario.
		id_transferencia = id_transferencia +1;
		saldo_emissor = saldo_emissor - valor_transferencia;
		saldo_receptor = saldo_receptor + valor_transferencia;
		System.out.println("Sua transferência foi realizada com sucesso!");
		System.out.println("Saldo do Emissor: R$" + saldo_emissor);
		System.out.println("Saldo do Receptor: R$" + saldo_receptor);
		
	}

}
