package com.pietrantuono.offser.view.films;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pietrantuono.offser.R;
import com.pietrantuono.offser.model.api.pojos.Film;

import java.util.List;

/**
 * Created by Maurizio Pietrantuono, maurizio.pietrantuono@gmail.com.
 */
public class FilmsAdapter extends RecyclerView.Adapter<FilmsAdapter.FilmsHolder> {
    private final List<Film> films;

    public FilmsAdapter(List<Film> films) {
        this.films = films;
    }

    @Override
    public FilmsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.film_item, parent, false);
        FilmsHolder holder = new FilmsHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(FilmsHolder holder, int position) {
        holder.bind(films.get(position));
    }

    @Override
    public int getItemCount() {
        return films.size();
    }

    static class FilmsHolder extends RecyclerView.ViewHolder {
        private final TextView titleView;

        public FilmsHolder(View itemView) {
            super(itemView);
            titleView = (TextView) itemView.findViewById(R.id.title);
        }

        public void bind(Film film) {
            String title = film.getTitle() == null ? titleView.getContext().getResources().getString(R.string.not_available) : film.getTitle();
            titleView.setText(title);
        }
    }
}
