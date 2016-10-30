package com.pietrantuono.offser.people.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.pietrantuono.offser.R;
import com.pietrantuono.offser.model.api.pojos.Person;

/**
 * Created by Maurizio Pietrantuono, maurizio.pietrantuono@gmail.com.
 */
class PersonHolder extends RecyclerView.ViewHolder {
    private final TextView birthYearView;
    private final TextView eyeColorView;
    private final TextView genderView;
    private final TextView hairColorView;
    private final TextView heightView;
    private final TextView massView;
    private final TextView nameView;
    private final TextView skinColorView;


    public PersonHolder(View itemView) {
        super(itemView);
        nameView = (TextView) itemView.findViewById(R.id.name);
        birthYearView = (TextView) itemView.findViewById(R.id.birth);
        eyeColorView = (TextView) itemView.findViewById(R.id.eyes);
        genderView = (TextView) itemView.findViewById(R.id.gender);
        hairColorView = (TextView) itemView.findViewById(R.id.hair);
        heightView = (TextView) itemView.findViewById(R.id.height);
        massView = (TextView) itemView.findViewById(R.id.mass);
        skinColorView = (TextView) itemView.findViewById(R.id.skin);
    }

    public void bind(Person person) {
        String notAvailable = nameView.getContext().getResources().getString(R.string.not_available);
        String name = person.getName() == null ? notAvailable : person.getName();
        nameView.setText(name);

        String birthDate = person.getBirthYear() == null ? notAvailable : person.getBirthYear();
        birthYearView.setText(birthDate);

        String eyecolor = person.getEyeColor() == null ? notAvailable : person.getEyeColor();
        eyeColorView.setText(eyecolor);

        String gender = person.getGender() == null ? notAvailable : person.getGender();
        genderView.setText(gender);


        String haircolor = person.getHairColor() == null ? notAvailable : person.getHairColor();
        hairColorView.setText(haircolor);


        String height = person.getHeight() == null ? notAvailable : person.getHeight();
        heightView.setText(height);


        String mass = person.getMass() == null ? notAvailable : person.getMass();
        massView.setText(mass);


        String skin = person.getSkinColor() == null ? notAvailable : person.getSkinColor();
        skinColorView.setText(skin);
    }
}
