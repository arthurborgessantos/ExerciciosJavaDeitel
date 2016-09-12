public class DeckOfCardsTest{
	
	//executa o aplicativo
	public static void main( String args[]){
		DeckOfCards myDeckOfCards = new DeckOfCards();
		myDeckOfCards.shuffle();
		
		//imprime todas as 52 cartas na ordem em que são distribuida
		for( int c = 1; c <= 52; c++){
			//distribui e exibe uma Card
			System.out.printf("%-19s", myDeckOfCards.dealCard());
			
			if( c % 4 == 0){
				System.out.println();
			}//fim do if
		}//fim do for
	}//fim do main
}//fim da classe