import java.util.Random;

//simulador do jogo Craps

public class Craps{
	
	//gerador de numeros aleatorio
	private static final Random random = new Random();
	
	//enumeracao com constantes que representam o status do jogo
	private enum Status { CONTINUE, WON, LOST };
	
	//constantes que representam lançamentos comuns dos dados
	private static final int SNAKE_EYE = 2;
	private static final int TREY = 3;
	private static final int SEVEN = 7;
	private static final int YO_LEVEN = 11;
	private static final int BOX_CARS = 12;
	
	//joga uma partida de craps
	public void play(){
		int myPoint = 0;
		Status gameStatus;
		int sumOfDice = rollDice();
		
		//determina o status do jogo e a pontuacao com base no primeiro lançamento
		switch (sumOfDice){
			case SEVEN: //ganha com 7 na primeira rolagem
			case YO_LEVEN: //ganha com 11 na primeira rolagem
				gameStatus = Status.WON;
				break;
			case SNAKE_EYE: //perde com 2 no primeiro lançamento
			case TREY: //perde com 3 no primeiro lançamento
			case BOX_CARS: //perdecom 12 no primeiro lançamento
				gameStatus = Status.LOST;
				break;
			default: //nao ganhou nem perdeu
				gameStatus = Status.CONTINUE; //jogo nao terminou
				myPoint = sumOfDice; //informa a pontuacao
				System.out.println("Point is " + myPoint);
				break;				
		}//fim do switch
		
		//emquanto o jogo nao estiver completo
		while(gameStatus == Status.CONTINUE){
			
			sumOfDice = rollDice();
			
			//determina o status do jogo
			if (sumOfDice == myPoint) //vitoria por pontuaçao
				gameStatus = Status.WON;
			else 
				if (sumOfDice == SEVEN) //perde obtedo 7 antes de atingir a pontuacao
					gameStatus = Status.LOST;
					
		}//fim do while
		
		//exibe uma menssagem ganhou ou perdeu
		if (gameStatus == Status.WON)
			System.out.println("Player wins");
		else
			System.out.println("Player Loses");

	}//fim do metodo play
	
	//lanca os dados, calcula a soma e exibe os resultados
	public int rollDice(){
		//seleciona valores aleatorios do dados
		int die1 = random.nextInt(6) + 1;
		int die2 = random.nextInt(6) + 1;
		
		int sum = die1 + die2;
		
		//exibe os resultados desse lancamento
		System.out.printf("Player rolled %d + %d = %d\n", die1, die2, sum);
		
		return sum;//retorna a soma dos dados 
	}//fim do metodo rollDice
}//fim da classe