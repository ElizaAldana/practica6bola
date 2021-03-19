package com.example.conect;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.gson.Gson;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button upBtn, rightBtn, leftBtn, downBtn, colorBtn;
    private BufferedWriter bwriter;
    private int posX=250,posY=200, r=50,g=50,b=50;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        upBtn = findViewById(R.id.upBtn);
        rightBtn = findViewById(R.id.rightBtn);
        leftBtn = findViewById(R.id.leftBtn);
        downBtn = findViewById(R.id.downBtn);
        colorBtn = findViewById(R.id.colorBtn);

        //conection = new TCPclient();
        //conection.setMain(this);

        //*--Intenté con onTouch y no funcionó--* (mi cerebro no funcionó)
        //upBtn.setOnTouchListener(this);
        //rightBtn.setOnTouchListener(this);
        //leftBtn.setOnTouchListener(this);
        //downBtn.setOnTouchListener(this);
        //colorBtn.setOnTouchListener(this);

        upBtn.setOnClickListener(
                v -> {
                    posY-=10;
                    cod();
                }
        );
        downBtn.setOnClickListener(
                v -> {
                    posY+=10;
                    cod();
                }
        );
        rightBtn.setOnClickListener(
                v -> {
                    posX+=10;
                    cod();
                }
        );
        leftBtn.setOnClickListener(
                v -> {
                    posX-=10;
                    cod();
                }
        );
        colorBtn.setOnClickListener(
                v -> {
                    r = 255;
                    g = 255;
                    b = 255;
                    cod();
                }
        );
        new Thread(
                ()-> {
                    // Ponemos la IP del server y el puerto donde el servidor escucha
                    try {
                        Socket socket = new Socket("192.168.1.7", 5000);
                        InputStream is = socket.getInputStream();
                        OutputStream os = socket.getOutputStream();
                        OutputStreamWriter osw = new OutputStreamWriter(os);
                        bwriter = new BufferedWriter(osw);

                    } catch (UnknownHostException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }).start();

    }


    public void cod() {
        Gson gson = new Gson();
        MovBall bola = new MovBall(posX, posY,r,g,b,30);
        String movact = gson.toJson(bola);

        new Thread(()-> {
            try {
                bwriter.write(movact+"\n");
                bwriter.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
}