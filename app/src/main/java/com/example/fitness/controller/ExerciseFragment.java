package com.example.fitness.controller;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.fitness.R;
import com.google.android.youtube.player.YouTubePlayerView;


public class ExerciseFragment extends Fragment {

    TextView mTextViewVideo;
    TextView mTextViewDescription;
    FrameLayout frameLayout;
    //YouTubePlayerView mYouTubePlayerView;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);

        View v = inflater.inflate(R.layout.fragment_exercise, container, false);

        mTextViewDescription = (TextView) v.findViewById(R.id.textViewVideo);
        mTextViewDescription = (TextView) v.findViewById(R.id.textViewDescriptionVideo);
        frameLayout = v.findViewById(R.id.youtube_frame_layout);
        //mYouTubePlayerView = v.findViewById(R.id.youtube_view);
        mTextViewDescription.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        //mYouTubePlayerView = (YouTubePlayerView) v.findViewById(R.id.youtube_view);

        return v;

    }




}