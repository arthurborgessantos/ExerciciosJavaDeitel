public class Card{
	private String face; //face da carta
	private String suit; //naipe da carta
	
	//construtor de dois argumentos inicializa face e naipe da carta
	public Card( String cardFace, String cardSuit){
		face = cardFace;
		suit = cardSuit;
	}//fim do construtor
	
	//retorna representacao String de cardFace
	public String toString(){
		return face + " of " + suit;
	}//fim do metodo toString
	
}//fim da classe cardFace