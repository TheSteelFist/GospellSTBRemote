# GospellSTBRemote
This is an app that can be used to control Gospell Set Top Box using an IR blaster using an android device.

The app works as an app, it also shoots IR blasts. However, it seems the code its sending is incorrect. Because my settop box doesn't seem to repsond to the int patterns i've been sending.

I suspect that its a conversion issue, because I converted the IR codes from NEC format to integer format for the java application.

Here are the NEC codes below if anyone wants to convert it for their own self:
807F 50AF - Power ON/OFF (80)
807F D827 - INFO (216)
807F 30CF - Mute (48)
807F 08F7 - 0 (8)
807F 8877 - 1 (136)
807F 48B7 - 2 (72)
807F C837 - 3 (200)
807F 28D7 - 4 (40)
807F A857 - 5 (168)
807F 6897 - 6 (104)
807F E817 - 7 (232)
807F 18E7 - 8 (24)
807F 9867 - 9 (152)
807F F00F - BACK (240)
807F 609F - TV/Radio (96)
807F 02FD - Menu (2)
807F B847 - EPG (184)
807F 827D - FAV (130)
807F 708F - Exit (112)
807F 00FF -  UP / CH up(0)
807F 807F - Down / CH Down(128)
807F C03F - LEFT/Vol - down (192)
807F 40BF - RIGHT/Vol + up(64)
807F F807 - OK (248)


Below are the NEC codes for buttons I didn't put in the app, cause I've never used it and are obsolete to me.
807F 58A7 - Audio (88)
807F 20DF - Audio Stereo (32)
807F 0AF5 - SUBT (10)
807F 2AD5 - TTX (42)
807F 10EF - Pause (16)
807F 38C7 - Email (56)
807F 7887 - Quick Search (120)
807F 8A75 - record (138)
