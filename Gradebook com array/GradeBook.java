//classe gradeBook usando um array para armazenar notas de teste.

public class GradeBook{
	private String courseName;// nome do curso que essa GradeBook representa
	private int[] grades;// array de notas de aluno
	
	//construtor de dois argumentos inicializa courseName e o array de notas
	public GradeBook(String name, int[] gradesArray){
		this.courseName = name;
		this.grades = gradesArray;
	}//fim do construtor de dois argumentos
	
	//metodos sets e gets para courseName
	public void setCourseName(String name){
		this.courseName = name;
	}
	public String getCourseName(){
		return courseName;
	}
	
	//exibe uma menssagem de boas-vindas para o usuario GradeBook
	public void displayMessage(){
		System.out.printf("\nWelcome to the grade book for\n%s!\n\n",
			getCourseName() );
	}//fim displayMessage
	
	//realiza varias operacaos nos dados
	public void processGrades(){
		//gera saida de array de notas
		outputGrades();
		//chama metodo getAvarage para calcular a nota media
		System.out.printf("\nClass average is %.2f\n", getAvarage());
		//chama metodos getMinimum e getMaximum
		System.out.printf("Lowest grade is %d\nHighest grade is %d\n\n",
			getMinimum(), getMaximum());
		//chama outputBarChart para imprimir grafico de distribuicao de notas
		outputBarChart();
	}//fim do metodo processGrades
	
	public int getMinimum(){
		int lowGrade = grades[0];//assume que grades [ 0 ] é a menos nota
		//faz um loop pelo array de notas
		for(int grade : grades){
			//se nota for mais baixa que lowGrade, essa nota é atribuida a lowGRade
			if(grade < lowGrade){
				lowGrade = grade; //nota mais baixa 
			}
		}//fim do for
		return lowGrade;// retorna a mais baixa
	}//fim do getMinimum
	
	public int getMaximum(){
		int highGrade = grades[0];// assume que grades [ 0 ] é a maior nota
		//faz um loop pelo array de notas
		for(int grade : grades){
			//se a nota for maior que highGrade, atribui essa nota a highGrade
			if(grade > highGrade){
				highGrade = grade;// nota mais alta
			}
		}//fim do for
		return highGrade;// retorna a mais alta
	}//fim do getMaximum
	
	public double getAvarage(){
		int total = 0;// inicializa total
		//soma notas de um aluno
		for(int grade : grades){
			total += grade;
		}// fim do for
		return (double) total / grades.length;
	}//fim do getAvarage
	
	//gera a saida do ggrafico de barras exibindo distribuicao de notas
	public void outputBarChart(){
		System.out.println("Grade distribution:");
		//armazena a frequancia de notas em cada intervalo de 10 notas
		int[] frequency = new int[11];
		
		//para cada nota, incremena a frequancia aprimorada
		for(int grade : grades){
			++frequency[grade/10];	
		}//fim do for
		
		//para cada frequancia de nota, immprime barra no grafico
		for(int count = 0; count < frequency.length; count++){
			//imprime rotulo de barra ("00-09", ..., "90-99", "100: ")
			if (count == 10){
				System.out.printf("%5d: ", 100);
			}else{
				System.out.printf("%02d-%02d: ",
					count * 10, count * 10 +9);
			}//fim do else
			
			//impime a barra de asteriscos
			for(int stars = 0; stars < frequency[ count ]; stars++){
				System.out.print("*");
			}//fim do for
			System.out.println();
		}//fim do for externo
	}//fim do outputBarChart
	
	//gera a saida do conteudo do array de notas
	public void outputGrades(){
		System.out.println("The grades are:\n");
		
		//gera a saida de nota de cada aluno
		for(int student = 0; student < grades.length; student++){
			System.out.printf("Student %2d: %3d\n",
				student + 1, grades[student]);
		}
	}//fim do outputGrades
}//fim da classe 