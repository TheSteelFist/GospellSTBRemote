package com.example.gospellremotestb;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.ConsumerIrManager;
import android.os.Build;
import android.os.Bundle;
import android.util.ArrayMap;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button power, info, mute, one, two, three, four, five, six, seven;
    Button eight, nine, menu, epg, fav, exit, up, down, left, right, ok;
    Button back, tvRadio, zero;
    private String command;
    public ConsumerIrManager irManager;
    public int carrierFrequency;
    public static ArrayMap<String, int[]> lookUp = new ArrayMap<String, int[]>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        irManager = (ConsumerIrManager) getSystemService(Context.CONSUMER_IR_SERVICE);
        power = findViewById(R.id.btn_power);
        power.setOnClickListener(this);
        info =  findViewById(R.id.btn_info);
        info.setOnClickListener(this);
        mute = findViewById(R.id.btn_mute);
        mute.setOnClickListener(this);
        one = findViewById(R.id.btn_1);
        one.setOnClickListener(this);
        two = findViewById(R.id.btn_2);
        two.setOnClickListener(this);
        three = findViewById(R.id.btn_3);
        three.setOnClickListener(this);
        four = findViewById(R.id.btn_4);
        four.setOnClickListener(this);
        five = findViewById(R.id.btn_5);
        five.setOnClickListener(this);
        six = findViewById(R.id.btn_6);
        six.setOnClickListener(this);
        seven = findViewById(R.id.btn_7);
        seven.setOnClickListener(this);
        eight = findViewById(R.id.btn_8);
        eight.setOnClickListener(this);
        nine = findViewById(R.id.btn_9);
        nine.setOnClickListener(this);
        zero = findViewById(R.id.btn_0);
        zero.setOnClickListener(this);
        menu = findViewById(R.id.btn_menu);
        menu.setOnClickListener(this);
        epg = findViewById(R.id.btn_epg);
        epg.setOnClickListener(this);
        fav = findViewById(R.id.btn_fav);
        fav.setOnClickListener(this);
        exit = findViewById(R.id.btn_exit);
        exit.setOnClickListener(this);
        up = findViewById(R.id.btn_up);
        up.setOnClickListener(this);
        down = findViewById(R.id.btn_down);
        down.setOnClickListener(this);
        left = findViewById(R.id.btn_left);
        left.setOnClickListener(this);
        right = findViewById(R.id.btn_right);
        right.setOnClickListener(this);
        ok = findViewById(R.id.btn_ok);
        ok.setOnClickListener(this);
        back = findViewById(R.id.btn_back);
        back.setOnClickListener(this);
        tvRadio = findViewById(R.id.btn_tvRadio);
        tvRadio.setOnClickListener(this);
      //  lookUp.put("btn_power", new int[]{341,170,21,21,21,21,21,21,21,21,21,21,21,21,21,21,21,64,21,64,21,64,21,64,21,64,21,64,21,64,21,64,21,21,21,21,21,21,21,21,21,21,21,64,21,21,21,64,21,21,21,64,21,64,21,64,21,64,21,21,21,64,21,21,21,64,21,1517,341,85,21,3655});
      //  lookUp.put("btn_mute", new int[]{341,170,21,21,21,21,21,21,21,21,21,21,21,21,21,21,21,64,21,64,21,64,21,64,21,64,21,64,21,64,21,64,21,21,21,21,21,21,21,21,21,21,21,64,21,64,21,21,21,21,21,64,21,64,21,64,21,64,21,21,21,21,21,64,21,64,21,1517,341,85,21,3655});
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
                        irManager.transmit(carrierFrequency, string2Dec(new int[]{341,170,21,21,21,21,21,21,21,21,21,21,21,21,21,21,21,64,21,64,21,64,21,64,21,64,21,64,21,64,21,64,21,21,21,21,21,21,21,21,21,21,21,64,21,21,21,64,21,21,21,64,21,64,21,64,21,64,21,21,21,64,21,21,21,64,21,1517,341,85,21,3655},carrierFrequency));
                        break;
                    case R.id.btn_info:
                        irManager.transmit(carrierFrequency, string2Dec(lookUp.get("btn_info"),carrierFrequency));
                        break;
                    case R.id.btn_mute:
                        irManager.transmit(carrierFrequency, new int[]{341,170,21,21,21,21,21,21,21,21,21,21,21,21,21,21,21,64,21,64,21,64,21,64,21,64,21,64,21,64,21,64,21,21,21,21,21,21,21,21,21,21,21,64,21,64,21,21,21,21,21,64,21,64,21,64,21,64,21,21,21,21,21,64,21,64,21,1517,341,85,21,3655});
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
            System.out.println("IR BLASTER NOT PRESENT!");
        }
    }

    public RemoteCommandCode commandConversion(String command){
        List<String> list;
        RemoteCommandCode code;
        int frequency;
        list = new ArrayList<String>(Arrays.asList(command.split(" ")));
        list.remove(0);
        frequency = Integer.parseInt(list.remove(0),16);
        list.remove(0);
        list.remove(0);
        code = new RemoteCommandCode(list.size());
        for (int i = 0; i < list.size(); i++){
            code.setCode(i, Integer.parseInt(list.get(i),16));
        }
        frequency = (int) (1000000 / (frequency * 0.241246));
        code.setFrequency(frequency);
        return code;
    }

    public static int shouldEqnRun(){
        if(Build.MANUFACTURER.equalsIgnoreCase("HTC")){
            return 1;
        }
        if (Build.VERSION.SDK_INT >= 21){
            return 1;
        }
        if (Build.MANUFACTURER.equalsIgnoreCase("SAMSUNG")){
            if (Build.VERSION.SDK_INT >= 19){
                int lastIdx = Build.VERSION.RELEASE.lastIndexOf(".");
                int VERSION_MR = Integer.parseInt(Build.VERSION.RELEASE.substring(lastIdx + 1));
                if (VERSION_MR > 3){
                    return 0;
                } else {
                    return 2;
                }
            }
        }
        return 0;
    }

    public static int[] string2Dec(int[] irData, int frequency){
        int formula = shouldEqnRun();

        if (formula !=0){
            for (int i = 0; i < irData.length; i++){
                if (formula == 1) {
                    irData[i] = irData[i] * (1000000 / frequency);
                } else {
                    irData[i] = (int) Math.ceil(irData[i] * 26.27272727272727);
                }
            }
        }
        return irData;
    }
}