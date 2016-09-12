//classe com um array bidimencional para armazenar notas

public class GradeBook{
	private String courseName;// nome do curso que este livro de nota representa
	private int[][] grades;// array bidimencional de notas de aluno
	
	//construtor de dois argumentos que inicializa courseName e grades
	public GradeBook(String name, int[][] gradesArray){
		this.courseName = name;
		this.grades = gradesArray;
	}// fim do construtor
	
	//metodos gets e sets para courseName
	public void setCourseName(String name){
		this.courseName = name; 
	}
	
	public String getCourseName(){
		return courseName;
	}
	
	//exibe uma mensagem de boas vindas para o usuario gradebook
	public void displayMessage(){
		System.out.printf("Welcome to the grade book for\n%s!\n\n", 
			getCourseName());
	}//fim do displayMessage
	
	//realiza operacoes de dados
	public void processGrades(){
		//gera saida de array de notas
		outputGrades();
		
		//chama metodos getMinimum e getMaximum
		System.out.printf("\n%s %d\n%s %d\n\n",
			"Lowest grade in the grade book is", getMinimum(),
			"Highest grade in the grade book is", getMaximum());
			
		//gera a saida de gradico de distribuicao de todas as notas em todos os testes
		outputBarChart();
	}//fim do metodo processGrades
	
	//localiza nota minima
	public int getMinimum(){
		//assume que o primeiro elemento de grades é o menor
		int lowGrade = grades[0][0];
		//faz um loop pelas linhas do array
		for (int[] studantGrades : grades){
			//faz um loop pelas colunas da linha atual
			for(int grade : studantGrades){
				//se a nota for menor que lowGrade, atribui a nota a lowGrade
				if(grade < lowGrade){
					lowGrade = grade;
				}//fim do if
			}//fim do for interno
		}//fim do for externo
		
		return lowGrade;
	}//fim do metodo getMinimum
	
	//localiza a nota maxima
	public int getMaximum(){
		int highGrade = grades[0][0];		
		for(int[] studantGrades : grades){
			for(int grade : studantGrades){
				if(grade > highGrade){
					highGrade = grade;
				}//fim do if
			}//fim do for interno
		}//fim do for externo
		
		return highGrade;
	}//fim do metodo getMaximum
	
	//determina a media do conjunto particular de notas
	public double getAvarage(int[] setOfGrades){
		int total = 0;
		
		//soma as notas de um aluno
		for(int grade : setOfGrades){
			total += grade;
		}//fim do for
		
		return (double) total / setOfGrades.length;
	}//fim do metodo getAvarage
	
	//gera a saida do grafico de barras para exibir distribuicao total de notas
	public void outputBarChart(){
		System.out.println("Overall grade distribution:");
		
		//armazena frequencia de notas em cada intervalo de 10 notas 
		int[] frequency = new int[11];
		
		//para cada nota de GradeBook, incrementa a frequencia certa
		for(int[] studantGrades : grades){
			for(int grade : studantGrades){
				++frequency[grade / 10];
			}//fim do for interno
		}//fim do for externo
		
		//para cada frequencia de nota, imprime uma barra no grafico
		for(int count = 0; count < frequency.length; count++){
			//imprime rotulo de barra("00-09: ", ..., "90-99: ", "100: ")
			if(count == 10){
				System.out.printf("%5d: ", 100);
			}else{
				System.out.printf("%02d-%02d: ",
					count * 10, count * 10 + 9);
			}//fim do if else
			
			//imprime a barra de asteriscos
			for(int stars = 0; stars < frequency[count]; stars++){
				System.out.print("*");
			}//fim do for
			System.out.println();
		}//fim do for externo
	}//fim do metodo outputBarChart
	
	//gera a saida do conteudo do array de notas
	public void outputGrades(){
		System.out.println("Teh grades are:\n");
		System.out.print("	    ");//alinha titulos de colunas
		
		//cria um titulo coluna para cada um dos testes
		for(int test = 0; test  < grades[0].length; test++){
			System.out.printf("Test %d  ", test + 1);
		}
		System.out.println("Avarage");// titulo da coluna de media do aluno
	
		//cria linhas/colunas de texto que representam notas de array
		for(int studant = 0; studant< grades.length; studant++){
			System.out.printf("Student %2d", studant +1);
				
			for(int test: grades[studant]){// gera a saida de notas do aluno
				System.out.printf("%8d", test);
			}// fim do for
			/*chama metodo getAvarage para calcular a media do aluno
			passa linha de notas como argumento para getAvarage*/
			double avarage = getAvarage(grades[studant]);
			System.out.printf("%9.2f\n", avarage);				
		}// fim do for externo
	}// fim do metodo outputGrades
}// fim da classe
