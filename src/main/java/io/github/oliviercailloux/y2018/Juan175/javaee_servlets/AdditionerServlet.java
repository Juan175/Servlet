package io.github.oliviercailloux.y2018.Juan175.javaee_servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MediaType;

@SuppressWarnings("serial")
@WebServlet("/additioner/add")
public class AdditionerServlet extends HttpServlet {
	  
		int val;
		@SuppressWarnings("unused")
		private static final Logger LOGGER = Logger.getLogger(AdditionerServlet.class.getCanonicalName());
		
		@Override
		public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException , ServletException
		{
			PrintWriter output=res.getWriter();
			res.setContentType("text/plain");
			try
			{
				int x =  Integer.parseInt(req.getParameter("param1"));
				int y =  0;	
				int sum = 0 ;
				if(req.getParameter("param2")==null) {
					
					 sum = x+val;
					 output.println(sum);
					 LOGGER.info(req.getParameter(val+""));
					 
				}else {
					
					y  = Integer.parseInt(req.getParameter("param2"));
				    sum =x+y;
					output.println(x+y);
					LOGGER.info(req.getParameter("param2"));
				}
				 
				LOGGER.info(req.getParameter("param1"));
				LOGGER.info(sum+"");
			}
			catch(Exception e)
			{
				output.println("Exécution impossible, paramètre manquant");
			}
		}
		
		@Override
		protected void doPut(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
			resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
			resp.setContentType(MediaType.TEXT_PLAIN);
		
			resp.setContentType("text/plain");
			try {
				
			    val = Integer.parseInt(req.getParameter("param2"));
				resp.getWriter().println("OK");
				LOGGER.warning("You sent the following parameter  + " + val + " .");

				
			}catch(NumberFormatException e){
				resp.setStatus(400);
				
				resp.getWriter().println("Exécution impossible, paramètre manquant.");
			}
		}
	}

