package Objetos;

public class Titles {
	private int title_no;
	private String title;
	
	public Titles(String title_no, String title)
	{
		this.title_no =  Integer.parseInt(title_no);
		this.title = title;
		
	}
	
	
	public Titles(String title_no) {
		this.title_no = Integer.parseInt(title_no);
		
	}


	public int getTitle_no() {
		return title_no;
	}


	public void setTitle_no(int title_no) {
		this.title_no = title_no;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}



}
