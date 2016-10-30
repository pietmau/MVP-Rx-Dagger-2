package com.pietrantuono.offser.dagger.main;

import com.pietrantuono.offser.model.api.StarWarsApi;
import com.pietrantuono.offser.model.api.pojos.AllFilms;
import com.pietrantuono.offser.model.api.pojos.AllPeople;
import com.pietrantuono.offser.model.api.pojos.Film;
import com.pietrantuono.offser.model.api.pojos.Person;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;

/**
 * Created by Maurizio Pietrantuono, maurizio.pietrantuono@gmail.com.
 */
public class StarWarsApiMock implements StarWarsApi {
    public static final String FILM_TITLE = "Halloween";
    public static final String PERSON_NAME = "Sam";

    @Override
    public Observable<AllFilms> getAllFilms() {
        AllFilms allFilms = new AllFilms();
        List<Film> films = new ArrayList<>();
        Film film = new Film();
        film.setTitle(FILM_TITLE);
        films.add(film);
        allFilms.setFilms(films);
        return Observable.just(allFilms);
    }

    @Override
    public Observable<AllPeople> getAllPeople() {
        AllPeople allPeople = new AllPeople();
        List<Person> persons = new ArrayList<>();
        Person person = new Person();
        person.setName(PERSON_NAME);
        persons.add(person);
        allPeople.setPersons(persons);
        return Observable.just(allPeople);
    }
}
