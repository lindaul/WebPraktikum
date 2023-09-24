package de.hwg_lu.bwi.beans;

public class PortalBean {
	
	LoginBean login;

	public PortalBean() {
		// TODO Auto-generated constructor stub
	}
	
	public void getLoggedHeaderImage() {
		String html ="";
		
		
		if(!this.login.isLoggedIn()) {
			html += "<a href='loginView.jsp'><img src='../img/register.png' alt='' width='18px'>Login</a>\n"
					+ "            <a href='registerView.jsp'><img src='../img/register.png' alt='' width='18px'>Register</a>";
			
		}else {
			
			html += "<a href='loginView.jsp'><img src='../img/register.png' alt='' width='18px'>Logout</a>\n";
			
		}
		
		
		
	}

}
