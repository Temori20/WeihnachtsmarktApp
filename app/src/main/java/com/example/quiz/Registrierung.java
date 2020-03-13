package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class Registrierung extends AppCompatActivity {

    private EditText userSurName;
    public TextView content;
    private EditText userLastName;
    private EditText userPhone;
    private EditText userPassword;
    private EditText userEmail;
    private EditText userType;
    private Button regButton;
    private TextView userLogin ;
    String Vorname, Nachname, Telefon, Passwort, Email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        userSurName = (EditText) findViewById(R.id.etSurname);
        userLastName = (EditText) findViewById(R.id.etLastName);
        userPhone = (EditText) findViewById(R.id.etPhone);
        userPassword = (EditText) findViewById(R.id.etUserPassword);
        userEmail = (EditText) findViewById(R.id.etUserEmail);
        regButton = (Button) findViewById(R.id.btnRegister);
        content = (TextView) findViewById(R.id.content);
        userLogin = (TextView) findViewById(R.id.tvUserLogin);

        regButton.setOnClickListener(new Button.OnClickListener(){

            public void onClick(View v)
            {
                try{

                    // CALL GetText method to make post method call
                    GetText();
                }
                catch(Exception ex)
                {
                    content.setText(" url exeption! " );
                }
            }
        });

    }

    // Create GetText Metod
    public  void  GetText()  throws UnsupportedEncodingException
    {
        // Get user defined values
        Vorname = userSurName.getText().toString();
        Email = userEmail.getText().toString();
        Nachname   = userLastName.getText().toString();
        Passwort   = userPassword.getText().toString();
        Telefon = userPhone.getText().toString();


        // Create data variable for sent values to server
        String data = URLEncoder.encode("Vorname", "UTF-8")
                + "=" + URLEncoder.encode(Vorname, "UTF-8");

        data += "&" + URLEncoder.encode("email", "UTF-8") + "="
                + URLEncoder.encode(Email, "UTF-8");

        data += "&" + URLEncoder.encode("Nachname", "UTF-8")
                + "=" + URLEncoder.encode(Nachname, "UTF-8");

        data += "&" + URLEncoder.encode("Passwort", "UTF-8")
                + "=" + URLEncoder.encode(Passwort, "UTF-8");

        data += "&" + URLEncoder.encode("Telefon", "UTF-8")
                + "=" + URLEncoder.encode(Telefon, "UTF-8");

        String text = "";
        BufferedReader reader=null;

        // Send data
        try
        {

            // Defined URL  where to send data
            URL url = new URL("https://zwiftnote.com");

            // Send POST data request


            URLConnection conn = url.openConnection();
            conn.setDoOutput(true);
            OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
            wr.write( data );
            wr.flush();

            // Get the server response

            reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line = null;

            // Read Server Response
            while((line = reader.readLine()) != null)
            {
                // Append server response in string
                sb.append(line + "\n");
            }


            text = sb.toString();
        }
        catch(Exception ex)
        {

        }
        finally
        {
            try
            {

                reader.close();
            }

            catch(Exception ex) {}
        }

        // Show response on activity
        content.setText( text  );

    }

}






