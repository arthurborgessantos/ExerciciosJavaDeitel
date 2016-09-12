public class GradeBookTest{
	public static void main(String args []){
		//array de notas de aluno
		int[] gradesArray = {87, 68, 94, 100, 83, 78, 85, 91, 76, 87};
		int[] gradesArray2 = {30, 50, 23, 45, 70, 90, 40, 56, 60, 54};
		
		GradeBook grade1 = new GradeBook("Introducition to Java Programing", gradesArray);
		GradeBook grade2 = new GradeBook("Introducition to Web Programing", gradesArray2);
		
		grade1.displayMessage();
		grade1.processGrades();
		
		grade2.displayMessage();
		grade2.processGrades();
	}//fim do main
}//fim da classe