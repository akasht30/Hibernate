package com.jsp.hsl.sample.HibernateProject_movieHQL_SQL;

import java.util.Scanner;

import com.jsp.hsl.sample.HibernateProject_movieHQL_SQL.repository.MovieRepository;

public class App 
{
	public static void main( String[] args )
	{

		MovieRepository mr = new MovieRepository();
		Scanner sc=new Scanner(System.in);
		
		System.out.println(""
				+ "1.Add Movies.\n"
				+"2.Find movie details by name.\n"+
				"3.Find movie details by genere.\n"
				+"4.Find movies by director.\n"+
				"5.Filter movies by box officce collection greater than given number.\n"
				+"6.Update movie verddict between given collection.\n"+
				"7.Update  all movie collection by director name.(current value+2000000).\n"+
				"8.Delete all movie by genere.\n "+
				"9.Delete movies between collection.\n");
		
		System.out.println("Enter a choice:");
		int choice=sc.nextInt();

		switch(choice) {
		case 1:
			mr.addMovie();
			break;
		case 2:
			mr.findMovieByName();
			break;
		case 3:
			mr.findMovieByGenere();
			break;
		case 4:
			mr.findMovieByDirector();
			break;
		case 5:
			mr.findMovieByGreaterBoxOfficeCollection();
			break;
		case 6:
			mr.updateMovieVerddictByCollecction();
			break;
		case 7:
			mr.updateCollecctionByDirectorName();
			break;
		case 8:
			mr.deleteByGenere();
			break;
		case 9:
			mr.delteDetailsBetweenCollection();
			break;

			
		}
	}
}
