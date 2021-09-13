package controllers.users.account;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;

import java.io.IOException;
import java.io.File;

import models.User;

import utils.SMS;
import utils.ActivationCodeGenerator;
import utils.EmailSend;
import utils.ActivationCodeMail;

public class RegisterOTPServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		
		request.getRequestDispatcher("register_otp.jsp").forward(request,response);		
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		HttpSession session = request.getSession();
		
		String userNameData = (String)session.getAttribute("userNameData");
		String emailData = (String)session.getAttribute("emailData");
		String mobileData = (String)session.getAttribute("mobileData");
		String passwordData = (String)session.getAttribute("passwordData");

		String otpData = (String)session.getAttribute("otpData");

		
		String otp1 = request.getParameter("otp1");
		String otp2 = request.getParameter("otp2");
		String otp3 = request.getParameter("otp3");
		String otp4 = request.getParameter("otp4");
		String otp5 = request.getParameter("otp5");

		String otp = otp1+otp2+otp3+otp4+otp5;
		
		if(otpData.equals(otp)){
			String activationCode = ActivationCodeGenerator.getActivationCode();
			
			if(User.registerUser(userNameData,emailData,mobileData,passwordData,activationCode)){
				String message = ActivationCodeMail.getMail(userNameData,activationCode);

				EmailSend.sendEmail(emailData,"itech",message,"legecyprezzie@gmail.com","Prezzie@1legecy");
				
				String realPath = getServletContext().getRealPath("/WEB-INF/uploads");

				File file = new File(realPath,userNameData);
				if(file.mkdir()){
					System.out.println("created");
				}else{
					System.out.println("not created");
				}

				response.sendRedirect("activation_link_message.do");
			}else{
				
			}	
		}else{
			request.setAttribute("otp_err_msg","Wrong Otp Entered..");
			request.getRequestDispatcher("register_otp.jsp").forward(request,response);
		}
	}
}