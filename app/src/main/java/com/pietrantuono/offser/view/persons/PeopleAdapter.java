package com.pietrantuono.offser.view.persons;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pietrantuono.offser.R;
import com.pietrantuono.offser.model.api.pojos.Person;

import java.util.List;

/**
 * Created by Maurizio Pietrantuono, maurizio.pietrantuono@gmail.com.
 */
class PeopleAdapter extends RecyclerView.Adapter<PersonHolder> {
    private final List<Person> persons;

    public PeopleAdapter(List<Person> persons) {
        this.persons = persons;
    }

    @Override
    public PersonHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.persons_item, parent, false);
        return new PersonHolder(view);
    }

    @Override
    public void onBindViewHolder(PersonHolder holder, int position) {
        holder.bind(persons.get(position));
    }

    @Override
    public int getItemCount() {
        return persons.size();
    }

}
