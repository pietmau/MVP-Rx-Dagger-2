package com.pietrantuono.offser.films.view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pietrantuono.offser.R;
import com.pietrantuono.offser.model.api.pojos.Film;

import java.util.List;

/**
 * Created by Maurizio Pietrantuono, maurizio.pietrantuono@gmail.com.
 */
class FilmsAdapter extends RecyclerView.Adapter<FilmsHolder> {
    private final List<Film> films;

    public FilmsAdapter(List<Film> films) {
        this.films = films;
    }

    @Override
    public FilmsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.films_item, parent, false);
        return new FilmsHolder(view);
    }

    @Override
    public void onBindViewHolder(FilmsHolder holder, int position) {
        holder.bind(films.get(position));
    }

    @Override
    public int getItemCount() {
        return films.size();
    }

}
