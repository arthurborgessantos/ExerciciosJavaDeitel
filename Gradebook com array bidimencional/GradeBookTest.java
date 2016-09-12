/*GradeBookTest cria um objeto GradeBook usando um array bidimensional
das notas, entao invoca o metodo processGrades para analiza-las*/
public class GradeBookTest{
	public static void main(String[] args){
		//array bidimensional de notas de aluno
		int[][] gradesArray = {{87, 96, 70},
							   {68, 87, 90},
							   {94, 100, 90},
							   {100, 81, 82},
							   {83, 65, 85},
						       {78, 87, 65},
							   {85, 75, 83},
							   {91, 94, 100},
							   {76, 72, 84},
		                       {87, 93, 73}};
		
		GradeBook grade1 = new GradeBook("Java Programming", gradesArray);
		grade1.displayMessage();
		grade1.processGrades();
	}//fim do main
}//fim da classe GradeBookTest