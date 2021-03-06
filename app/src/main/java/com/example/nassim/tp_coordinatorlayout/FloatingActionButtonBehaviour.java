package com.example.nassim.tp_coordinatorlayout;

import android.content.Context;
import android.support.design.internal.ForegroundLinearLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by Nassim on 01/11/2016.
 */

public class FloatingActionButtonBehaviour extends CoordinatorLayout.Behavior<FloatingActionButton> {

    public FloatingActionButtonBehaviour(Context context, AttributeSet attrs){

    }

    // Si cette methode retourne true la methode onDepentViewChangedSeraExecutée
    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, FloatingActionButton child, View dependency) {
        return  dependency instanceof Snackbar.SnackbarLayout;
    }

    // Pour être en accord avec la documentation, il faut retourner true quand on change la position d'objets dans l'ecran
    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, FloatingActionButton child, View dependency) {
        float translationY = Math.min(0, dependency.getTranslationY() - dependency.getHeight());
        float translationX =0 ;
        if(translationY < -10) translationX= -dependency.getWidth()+child.getWidth() +30;
        else translationX = 0;
        child.setTranslationY(translationY);
        child.setTranslationX(translationX);
        return false;
    }
}
