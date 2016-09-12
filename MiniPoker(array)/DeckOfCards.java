import java.util.Random;

public class DeckOfCards{
	private Card[] deck; //array de objetos cartas
	private int currentCard; //indice do procimo Card a ser distribuido
	private static final int NUMBER_OF_CARDS = 52; //numero constante de Cards
	//gerados de numero aleatorio;
	private static final Random randomNumbers = new Random();

	//construtor preenche baralho de cartas
	public DeckOfCards(){
		String faces[] = {"Ace", "Deuce", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
		String suits[] = {"Hearts", "Diamonds", "Clubs", " Spades"};
		
		deck = new Card[NUMBER_OF_CARDS]; //cria um array de cards
		currentCard = 0; 
		
		//preenche baralho com objetos Card
		for( int count = 0; count < deck.length; count++){
			deck[count] = new Card( faces[ count%13 ], suits[ count/13 ] );
		}
	}//fim do construtor
	
	//embaralha as cartas com um algoritimo de uma passagem
	public void shuffle(){
		
		//depois de embaralhar, a distribuicao deve iniciar em deck[ 0 ] novamente
		currentCard = 0;
		
		//para cada card, seleciona outro card aleatorio e os compara
		for( int first = 0; first < deck.length; first++){
			//seleciona um numero aleatorio entre 0 e 51
			int second =  randomNumbers.nextInt( NUMBER_OF_CARDS );
			//compara Card atual com Card aleatoriamente selecionado
			Card temp = deck[ first ];
			deck[ first ] = deck[ second ];
			deck[ second ] = temp;
		}//fim do for
	}//fim do metodo shuffle
	
	//distribui um Card
	public Card dealCard(){
		
		//determina se ainda ha Cards a serem distribuidos
		if( currentCard < deck.length ){
			return deck[ currentCard++ ];
		}else{
			return null;
		}
	}//fim do metodo dealCard
}//fim da classe