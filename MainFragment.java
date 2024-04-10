package com.example.aruuke_rakhmanova_hw2_3m;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class MainFragment extends Fragment {

    private EditText email_et;
    private EditText theme_et;
    private EditText message_et;
    private Button btnOpenGmail;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        email_et = requireActivity().findViewById(R.id.et1_email);
        theme_et = requireActivity().findViewById(R.id.et2_theme);
        message_et = requireActivity().findViewById(R.id.et3_message);
        btnOpenGmail = requireActivity().findViewById(R.id.btnOpenGmail);

        btnOpenGmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGmail();
            }
        });
    }

    private void openGmail() {
        String email = email_et.getText().toString();
        String theme = theme_et.getText().toString();
        String message = message_et.getText().toString();

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));

        if (!email.isEmpty()) {
            intent.putExtra(Intent.EXTRA_EMAIL, new String[]{email});
        }

        intent.putExtra(Intent.EXTRA_SUBJECT, theme);
        intent.putExtra(Intent.EXTRA_TEXT, message);

        try {
            startActivity(Intent.createChooser(intent, "Choose an email client..."));
        } catch (android.content.ActivityNotFoundException ex) {

        }
    }

}
