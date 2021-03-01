package com.example.gospellremotestb;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.ConsumerIrManager;
import android.os.Bundle;
import android.util.ArrayMap;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button power, info, mute, one, two, three, four, five, six, seven;
    Button eight, nine, menu, epg, fav, exit, up, down, left, right, ok;
    Button back, tvRadio, zero;
    private ConsumerIrManager irManager;
    private final int carrierFrequency = 38000;
    private ArrayMap<String, int[]> lookUp = new ArrayMap<String, int[]>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        irManager = (ConsumerIrManager) getSystemService(Context.CONSUMER_IR_SERVICE);
        power = (Button) findViewById(R.id.btn_power);
        power.setOnClickListener(this);
        info = (Button) findViewById(R.id.btn_info);
        info.setOnClickListener(this);
        mute = (Button) findViewById(R.id.btn_mute);
        mute.setOnClickListener(this);
        one = (Button) findViewById(R.id.btn_1);
        one.setOnClickListener(this);
        two = (Button) findViewById(R.id.btn_2);
        two.setOnClickListener(this);
        three = (Button) findViewById(R.id.btn_3);
        three.setOnClickListener(this);
        four = (Button) findViewById(R.id.btn_4);
        four.setOnClickListener(this);
        five = (Button) findViewById(R.id.btn_5);
        five.setOnClickListener(this);
        six = (Button) findViewById(R.id.btn_6);
        six.setOnClickListener(this);
        seven = (Button) findViewById(R.id.btn_7);
        seven.setOnClickListener(this);
        eight = (Button) findViewById(R.id.btn_8);
        eight.setOnClickListener(this);
        nine = (Button) findViewById(R.id.btn_9);
        nine.setOnClickListener(this);
        zero = (Button) findViewById(R.id.btn_0);
        zero.setOnClickListener(this);
        menu = (Button) findViewById(R.id.btn_menu);
        menu.setOnClickListener(this);
        epg = (Button) findViewById(R.id.btn_epg);
        epg.setOnClickListener(this);
        fav = (Button) findViewById(R.id.btn_fav);
        fav.setOnClickListener(this);
        exit = (Button) findViewById(R.id.btn_exit);
        exit.setOnClickListener(this);
        up = (Button) findViewById(R.id.btn_up);
        up.setOnClickListener(this);
        down = (Button) findViewById(R.id.btn_down);
        down.setOnClickListener(this);
        left = (Button) findViewById(R.id.btn_left);
        left.setOnClickListener(this);
        right = (Button) findViewById(R.id.btn_right);
        right.setOnClickListener(this);
        ok = (Button) findViewById(R.id.btn_ok);
        ok.setOnClickListener(this);
        back = (Button) findViewById(R.id.btn_back);
        back.setOnClickListener(this);
        tvRadio = (Button) findViewById(R.id.btn_tvRadio);
        tvRadio.setOnClickListener(this);
      //  lookUp.put("btn_power", new int[]{341,170,21,21,21,21,21,21,21,21,21,21,21,21,21,21,21,64,21,64,21,64,21,64,21,64,21,64,21,64,21,64,21,21,21,21,21,21,21,21,21,21,21,64,21,21,21,64,21,21,21,64,21,64,21,64,21,64,21,21,21,64,21,21,21,64,21,1517,341,85,21,3655});
      //  lookUp.put("btn_mute", new int[]{341,170,21,21,21,21,21,21,21,21,21,21,21,21,21,21,21,64,21,64,21,64,21,64,21,64,21,64,21,64,21,64,21,21,21,21,21,21,21,21,21,21,21,64,21,64,21,21,21,21,21,64,21,64,21,64,21,64,21,21,21,21,21,64,21,64,21,1517});
        lookUp.put("btn_info", new int[]{341,170,21,21,21,21,21,21,21,21,21,21,21,21,21,21,21,64,21,64,21,64,21,64,21,64,21,64,21,64,21,64,21,21,21,21,21,21,21,21,21,64,21,64,21,21,21,64,21,64,21,64,21,64,21,64,21,21,21,21,21,64,21,21,21,21,21,1517,341,85,21,3655});
        lookUp.put("btn_0", new int[]{341,170,21,21,21,21,21,21,21,21,21,21,21,21,21,21,21,64,21,64,21,64,21,64,21,64,21,64,21,64,21,64,21,21,21,21,21,21,21,21,21,21,21,21,21,64,21,64,21,21,21,64,21,64,21,64,21,64,21,64,21,21,21,21,21,64,21,1517,341,85,21,3655});
        lookUp.put("btn_1", new int[]{341,170,21,21,21,21,21,21,21,21,21,21,21,21,21,21,21,64,21,64,21,64,21,64,21,64,21,64,21,64,21,64,21,21,21,21,21,21,21,21,21,64,21,21,21,21,21,21,21,64,21,64,21,64,21,64,21,21,21,64,21,64,21,64,21,21,21,1517,341,85,21,3655});
        lookUp.put("btn_2", new int[]{341,170,21,21,21,21,21,21,21,21,21,21,21,21,21,21,21,64,21,64,21,64,21,64,21,64,21,64,21,64,21,64,21,21,21,21,21,21,21,21,21,64,21,21,21,21,21,64,21,21,21,64,21,64,21,64,21,21,21,64,21,64,21,21,21,64,21,1517,341,85,21,3655});
        lookUp.put("btn_3", new int[]{341,170,21,21,21,21,21,21,21,21,21,21,21,21,21,21,21,64,21,64,21,64,21,64,21,64,21,64,21,64,21,64,21,21,21,21,21,21,21,21,21,64,21,21,21,21,21,64,21,64,21,64,21,64,21,64,21,21,21,64,21,64,21,21,21,21,21,1517,341,85,21,3655});
        lookUp.put("btn_4", new int[]{341,170,21,21,21,21,21,21,21,21,21,21,21,21,21,21,21,64,21,64,21,64,21,64,21,64,21,64,21,64,21,64,21,21,21,21,21,21,21,21,21,64,21,21,21,64,21,21,21,21,21,64,21,64,21,64,21,21,21,64,21,21,21,64,21,64,21,1517,341,85,21,3655});
        lookUp.put("btn_5", new int[]{341,170,21,21,21,21,21,21,21,21,21,21,21,21,21,21,21,64,21,64,21,64,21,64,21,64,21,64,21,64,21,64,21,21,21,21,21,21,21,21,21,64,21,21,21,64,21,21,21,64,21,64,21,64,21,64,21,21,21,64,21,21,21,64,21,21,21,1517,341,85,21,3655});
        lookUp.put("btn_6", new int[]{341,170,21,21,21,21,21,21,21,21,21,21,21,21,21,21,21,64,21,64,21,64,21,64,21,64,21,64,21,64,21,64,21,21,21,21,21,21,21,21,21,64,21,21,21,64,21,64,21,21,21,64,21,64,21,64,21,21,21,64,21,21,21,21,21,64,21,1517,341,85,21,3655});
        lookUp.put("btn_7", new int[]{341,170,21,21,21,21,21,21,21,21,21,21,21,21,21,21,21,64,21,64,21,64,21,64,21,64,21,64,21,64,21,64,21,21,21,21,21,21,21,21,21,64,21,21,21,64,21,64,21,64,21,64,21,64,21,64,21,21,21,64,21,21,21,21,21,21,21,1517,341,85,21,3655});
        lookUp.put("btn_8", new int[]{341,170,21,21,21,21,21,21,21,21,21,21,21,21,21,21,21,64,21,64,21,64,21,64,21,64,21,64,21,64,21,64,21,21,21,21,21,21,21,21,21,64,21,64,21,21,21,21,21,21,21,64,21,64,21,64,21,21,21,21,21,64,21,64,21,64,21,1517,341,85,21,3655});
        lookUp.put("btn_9", new int[]{341,170,21,21,21,21,21,21,21,21,21,21,21,21,21,21,21,64,21,64,21,64,21,64,21,64,21,64,21,64,21,64,21,21,21,21,21,21,21,21,21,64,21,64,21,21,21,21,21,64,21,64,21,64,21,64,21,21,21,21,21,64,21,64,21,21,21,1517,341,85,21,3655});
        lookUp.put("btn_back", new int[]{341,170,21,21,21,21,21,21,21,21,21,21,21,21,21,21,21,64,21,64,21,64,21,64,21,64,21,64,21,64,21,64,21,21,21,21,21,21,21,21,21,21,21,64,21,64,21,64,21,64,21,64,21,64,21,64,21,64,21,21,21,21,21,21,21,21,21,1517,341,85,21,3655});
        lookUp.put("btn_tvRadio", new int[]{341,170,21,21,21,21,21,21,21,21,21,21,21,21,21,21,21,64,21,64,21,64,21,64,21,64,21,64,21,64,21,64,21,21,21,21,21,21,21,21,21,21,21,21,21,64,21,64,21,21,21,64,21,64,21,64,21,64,21,64,21,21,21,21,21,64,21,1517,341,85,21,3655});
        lookUp.put("btn_menu", new int[]{341,170,21,21,21,21,21,21,21,21,21,21,21,21,21,21,21,64,21,64,21,64,21,64,21,64,21,64,21,64,21,64,21,21,21,21,21,64,21,21,21,21,21,21,21,21,21,21,21,21,21,64,21,21,21,64,21,64,21,64,21,64,21,64,21,64,21,1517,341,85,21,3655});
        lookUp.put("btn_epg", new int[]{341,170,21,21,21,21,21,21,21,21,21,21,21,21,21,21,21,64,21,64,21,64,21,64,21,64,21,64,21,64,21,64,21,21,21,21,21,21,21,21,21,64,21,64,21,64,21,21,21,64,21,64,21,64,21,64,21,21,21,21,21,21,21,64,21,21,21,1517,341,85,21,3655});
        lookUp.put("btn_fav", new int[]{341,170,21,21,21,21,21,21,21,21,21,21,21,21,21,21,21,64,21,64,21,64,21,64,21,64,21,64,21,64,21,64,21,21,21,21,21,64,21,21,21,21,21,21,21,21,21,21,21,64,21,64,21,21,21,64,21,64,21,64,21,64,21,64,21,21,21,1517,341,85,21,3655});
        lookUp.put("btn_exit", new int[]{341,170,21,21,21,21,21,21,21,21,21,21,21,21,21,21,21,64,21,64,21,64,21,64,21,64,21,64,21,64,21,64,21,21,21,21,21,21,21,21,21,21,21,64,21,64,21,64,21,21,21,64,21,64,21,64,21,64,21,21,21,21,21,21,21,64,21,1517,341,85,21,3655});
        lookUp.put("btn_up", new int[]{341,170,21,21,21,21,21,21,21,21,21,21,21,21,21,21,21,64,21,64,21,64,21,64,21,64,21,64,21,64,21,64,21,21,21,21,21,21,21,21,21,21,21,21,21,21,21,21,21,21,21,64,21,64,21,64,21,64,21,64,21,64,21,64,21,64,21,1517,341,85,21,3655});
        lookUp.put("btn_down", new int[]{341,170,21,21,21,21,21,21,21,21,21,21,21,21,21,21,21,64,21,64,21,64,21,64,21,64,21,64,21,64,21,64,21,21,21,21,21,21,21,21,21,21,21,21,21,21,21,21,21,64,21,64,21,64,21,64,21,64,21,64,21,64,21,64,21,21,21,1517,341,85,21,3655});
        lookUp.put("btn_left", new int[]{341,170,21,21,21,21,21,21,21,21,21,21,21,21,21,21,21,64,21,64,21,64,21,64,21,64,21,64,21,64,21,64,21,21,21,21,21,21,21,21,21,21,21,21,21,21,21,64,21,64,21,64,21,64,21,64,21,64,21,64,21,64,21,21,21,21,21,1517,341,85,21,3655});
        lookUp.put("btn_right", new int[]{341,170,21,21,21,21,21,21,21,21,21,21,21,21,21,21,21,64,21,64,21,64,21,64,21,64,21,64,21,64,21,64,21,21,21,21,21,21,21,21,21,21,21,21,21,21,21,64,21,21,21,64,21,64,21,64,21,64,21,64,21,64,21,21,21,64,21,1517,341,85,21,3655});
        lookUp.put("btn_ok", new int[]{341,170,21,21,21,21,21,21,21,21,21,21,21,21,21,21,21,64,21,64,21,64,21,64,21,64,21,64,21,64,21,64,21,21,21,21,21,21,21,21,21,64,21,64,21,64,21,64,21,64,21,64,21,64,21,64,21,21,21,21,21,21,21,21,21,21,21,1517,341,85,21,3655});

    }

    @Override
    public void onClick(View v) {
        try {
            if (irManager.hasIrEmitter()) {
                switch (v.getId()) {
                    case R.id.btn_power:
                        irManager.transmit(carrierFrequency, new int[]{341,170,21,21,21,21,21,21,21,21,21,21,21,21,21,21,21,64,21,64,21,64,21,64,21,64,21,64,21,64,21,64,21,21,21,21,21,21,21,21,21,21,21,64,21,21,21,64,21,21,21,64,21,64,21,64,21,64,21,21,21,64,21,21,21,64,21,1517,341,85,21,3655});
                        break;
                    case R.id.btn_info:
                        irManager.transmit(carrierFrequency, lookUp.get("btn_info"));
                        break;
                    case R.id.btn_mute:
                        irManager.transmit(carrierFrequency, new int[]{341,170,21,21,21,21,21,21,21,21,21,21,21,21,21,21,21,64,21,64,21,64,21,64,21,64,21,64,21,64,21,64,21,21,21,21,21,21,21,21,21,21,21,64,21,64,21,21,21,21,21,64,21,64,21,64,21,64,21,21,21,21,21,64,21,64,21,1517});
                        break;
                    case R.id.btn_0:
                        irManager.transmit(carrierFrequency, lookUp.get("btn_0"));
                        break;
                    case R.id.btn_1:
                        irManager.transmit(carrierFrequency, lookUp.get("btn_1"));
                        break;
                    case R.id.btn_2:
                        irManager.transmit(carrierFrequency, lookUp.get("btn_2"));
                        break;
                    case R.id.btn_3:
                        irManager.transmit(carrierFrequency, lookUp.get("btn_3"));
                        break;
                    case R.id.btn_4:
                        irManager.transmit(carrierFrequency, lookUp.get("btn_4"));
                        break;
                    case R.id.btn_5:
                        irManager.transmit(carrierFrequency, lookUp.get("btn_5"));
                        break;
                    case R.id.btn_6:
                        irManager.transmit(carrierFrequency, lookUp.get("btn_6"));
                        break;
                    case R.id.btn_7:
                        irManager.transmit(carrierFrequency, lookUp.get("btn_7"));
                        break;
                    case R.id.btn_8:
                        irManager.transmit(carrierFrequency, lookUp.get("btn_8"));
                        break;
                    case R.id.btn_9:
                        irManager.transmit(carrierFrequency, lookUp.get("btn_9"));
                        break;
                    case R.id.btn_back:
                        irManager.transmit(carrierFrequency, lookUp.get("btn_back"));
                        break;
                    case R.id.btn_tvRadio:
                        irManager.transmit(carrierFrequency, lookUp.get("btn_tvRadio"));
                        break;
                    case R.id.btn_menu:
                        irManager.transmit(carrierFrequency, lookUp.get("btn_menu"));
                        break;
                    case R.id.btn_epg:
                        irManager.transmit(carrierFrequency, lookUp.get("btn_epg"));
                        break;
                    case R.id.btn_fav:
                        irManager.transmit(carrierFrequency, lookUp.get("btn_fav"));
                        break;
                    case R.id.btn_exit:
                        irManager.transmit(carrierFrequency, lookUp.get("btn_exit"));
                        break;
                    case R.id.btn_up:
                        irManager.transmit(carrierFrequency, lookUp.get("btn_up"));
                        break;
                    case R.id.btn_down:
                        irManager.transmit(carrierFrequency, lookUp.get("btn_down"));
                        break;
                    case R.id.btn_left:
                        irManager.transmit(carrierFrequency, lookUp.get("btn_left"));
                        break;
                    case R.id.btn_right:
                        irManager.transmit(carrierFrequency, lookUp.get("btn_right"));
                        break;
                    case R.id.btn_ok:
                        irManager.transmit(carrierFrequency, lookUp.get("btn_ok"));
                        break;
                }
            } else {
                throw new IOException("Device has no IR Blaster.");
            }
        } catch(IOException e) {
            System.out.println("Device has no IR Blaster. ");
        }
    }
}