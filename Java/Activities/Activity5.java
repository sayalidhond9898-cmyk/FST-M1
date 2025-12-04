package activities;

public class Activity5 {

	public static void main(String[] args) {
        //Initialize title of the book
        String s = "Ram";
        //Create object for MyBook
        Book newNovel = new MyBook();
        //Set title
        newNovel.setTittle(s);
        
        //Print result
        System.out.println("The title is: " + newNovel.getTittle());
    }
}
