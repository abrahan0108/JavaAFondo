package libro.cap07;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class DemoClienteB 
{
	private static final int BUFFER_LENGTH = 3;

	public static void main(String[] args) throws Exception 
	{
		// TODO Auto-generated method stub
		BufferedReader br = null;
		BufferedWriter bw = null;
		
		Socket s = null;
		
		try 
		{
			s = new Socket("127.0.0.1",5433);
			bw = new BufferedWriter(new PrintWriter(s.getOutputStream()));
			br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			
			char bEnviar[] = "Abrahan".toCharArray();
			char bRecibe[] = new char[BUFFER_LENGTH];
			bw.write(bEnviar);
			bw.flush();
			
			int n;
			StringBuffer sb = new StringBuffer();
			while ( (n=br.read(bRecibe)) == BUFFER_LENGTH)
			{
				sb.append(bRecibe);
			}
			sb.append(bRecibe,0,n);
			System.out.println(sb);
		} 
		catch (Exception e) 
		{
			// TODO: handle exception
			e.printStackTrace();
		}
		finally
		{
			if(br != null) br.close();
			if(bw != null) bw.close();
			if(s != null) s.close();
		}

	}

}
