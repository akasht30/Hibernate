package com.jsp.hsl.sample.HibernateProject_movieHQL_SQL.repository;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import com.jsp.hsl.sample.HibernateProject_movieHQL_SQL.Entity.Movie;

public class MovieRepository {

	Configuration cfg = new Configuration().configure().addAnnotatedClass(Movie.class);
	SessionFactory sf = cfg.buildSessionFactory();
	Scanner sc = new Scanner(System.in);

	// Add movie
	public void addMovie() {

		System.out.println("Enter a id of movie:");
		int id = sc.nextInt();
		System.out.println("Enter a movie name:");
		String name = sc.next();
		System.out.println("Enter a movie genre:");
		String genre = sc.next();
		System.out.println("Enter a director name:");
		String director = sc.next();
		System.out.println("Enter a box office Collection:");
		int bc = sc.nextInt();
		System.out.println("Enter a box office verdict");
		String bv = sc.next();

		Movie m = new Movie();
		m.setMovieId(id);
		m.setMovieName(name);
		m.setDirector(director);
		m.setGenre(genre);
		m.setBoxOfficeCollection(bc);
		m.setBoxOficeVerdict(bv);

		Session se = sf.openSession();
		Transaction tran = se.beginTransaction();

		se.save(m);

		tran.commit();
		se.close();
		sf.close();

	}

	// Find by name
	public void findMovieByName() {

		System.out.println("Enter a name:");
		String name = sc.next();

		Movie m = new Movie();

		Session se = sf.openSession();
		Transaction tran = se.beginTransaction();

		Query<Movie> query = se.createQuery("from  Movie m where m.movieName= ?1", Movie.class);
		query.setParameter(1, name);

		List<Movie> ml = query.list();

		for (Movie i : ml) {
			System.out.println(i);
		}

		tran.commit();
		se.close();
		sf.close();

	}

	// Find by genre
	public void findMovieByGenere() {

		System.out.println("Enter a genere of movie:");
		String gen = sc.next();

		Session se = sf.openSession();
		Transaction tran = se.beginTransaction();

		Query<Movie> query = se.createQuery("from  Movie m where m.genre= ?1", Movie.class);
		query.setParameter(1, gen);

		List<Movie> ml = query.list();

		for (Movie i : ml) {
			System.out.println(i);
		}

		tran.commit();
		se.close();
		sf.close();
	}

	// Find by Director
	public void findMovieByDirector() {
		System.out.println("Enter a director name:");

		Session se = sf.openSession();
		Transaction tran = se.beginTransaction();

		NativeQuery<Movie> query = se.createNativeQuery("SELECT * FROM hibernate_moviehql.movie WHERE director= ?",
				Movie.class);
		query.setParameter(1, sc.next());

		List<Movie> movie = query.list();

		for (Movie ml : movie) {
			System.out.println(ml);
		}

		tran.commit();
		se.close();
		sf.close();

	}

	// Find by greater than given box office collection
	public void findMovieByGreaterBoxOfficeCollection() {
		System.out.println("Enter a collection:");

		Session se = sf.openSession();
		Transaction tran = se.beginTransaction();

		NativeQuery query = se.createNativeQuery("SELECT  * FROM hibernate_moviehql.movie WHERE boxOfficeCollection>=?",
				Movie.class);
		query.setParameter(1, sc.nextInt());
		List<Movie> details = query.list();

		if (details == null) {
			System.out.println("No records");
		}
		for (Movie del : details) {
			System.out.println(del);
		}

		tran.commit();
		se.close();
		sf.close();

	}

	public void updateMovieVerddictByCollecction() {

		System.out.println("Enter a box office verddict to set:");
		String ver = sc.next();
		System.out.println("Enter a box office collection range:");
		int bc1 = sc.nextInt();
		int bc2 = sc.nextInt();

		Session se = sf.openSession();
		Transaction tran = se.beginTransaction();

		Query<Movie> query = se.createQuery(
				"UPDATE Movie m SET m.boxOficeVerdict=?1  WHERE  m.boxOfficeCollection BETWEEN ?2 AND ?3");
		query.setParameter(1, ver);
		query.setParameter(2, bc1);
		query.setParameter(3, bc2);

		int rowInsert = query.executeUpdate();

		if (rowInsert > 0) {
			System.out.println("data updated.");
		}

		tran.commit();
		se.close();
		sf.close();
	}

	public void updateCollecctionByDirectorName() {

		System.out.println("Enter a name of director:");
		String director = sc.next();

		Session se = sf.openSession();
		Transaction tran = se.beginTransaction();

		Movie m = new Movie();

		Query<Movie> query = se.createQuery("UPDATE Movie m SET m.boxOfficeCollection=?1 WHERE m.director=?2");
		query.setParameter(1, m.getBoxOfficeCollection() + 2000000);
		query.setParameter(2, director);

		int rowInsert = query.executeUpdate();
		if (rowInsert > 0) {
			System.out.println("data updated.");
		}

		tran.commit();
		se.close();
		sf.close();
	}

	public void deleteByGenere() {

		System.out.print("Enter a genre:");
		String gen = sc.next();

		Session se = sf.openSession();
		Transaction tran = se.beginTransaction();

		NativeQuery<Movie> query = se.createNativeQuery("DELETE FROM hibernate_moviehql.movie WHERE genre=?",
				Movie.class);
		query.setParameter(1, gen);

		int delete = query.executeUpdate();

		if (delete > 0) {
			System.out.println("data is deleted");
		}

		tran.commit();
		se.close();
		sf.close();
	}

	public void delteDetailsBetweenCollection() {
		System.out.print("Enter a range of Box office collection:");
		int bc1 = sc.nextInt();
		int bc2 = sc.nextInt();

		Session se = sf.openSession();
		Transaction tran = se.beginTransaction();

		NativeQuery<Movie> query = se.createNativeQuery("DELETE FROM movie WHERE boxOfficeCollection BETWEEN ? AND ?",
				Movie.class);
		query.setParameter(1, bc1);
		query.setParameter(2, bc2);

		int delete = query.executeUpdate();

		if (delete > 0) {
			System.out.println("data is deleted");
		}

		tran.commit();
		se.close();
		sf.close();

	}

	public void findAll() {

		Session se = sf.openSession();
		Transaction tran = se.beginTransaction();

		Criteria criteria = se.createCriteria(Movie.class);
		// criteria.add(Restrictions.gt("movieId", 900));
		// criteria.add(Restrictions.between("movieId",100, 900));
		// criteria.add(Restrictions.lt("movieId", 900));
		criteria.add(Restrictions.eq("movieId", 900));

		List<Movie> mov = criteria.list();
		for (Movie m : mov) {
			System.out.println(m);
		}

		tran.commit();
		se.close();
		sf.close();
	}

}
