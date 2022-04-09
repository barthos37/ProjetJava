package modele;

public class Jour<D extends Date,M extends Menu> {
	private Date date;
	private Menu menu;
	
	public Jour(Date date, Menu menu) {
		this.date = date;
		this.menu = menu;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Menu getMenu() {
		return menu;
	}
	public void setMenu(Menu menu) {
		this.menu = menu;
		
	}
	public String toString() {
		return (date.toString()+ " : " + menu.getNom());
	}
}
