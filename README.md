# YTDimmer
Turn off your screen while watching Youtube videos.

## Problem
Smartphone displays can get pretty bright if you can't sleep and watch Youtube videos till 3am. Sometimes, you don't even watch the video, but only listen to it. However, you can't turn your screen off, without stoping the video, and your phone keeps enlighting your room.

## Solution
If you don't buy a YoutubeRed membership, there is no official way for you to turn your screen of while using Youtube. Thats the reason, i wrote this little application, that enables me to turn my screen completely off, while listening to Youtube videos.

## How it works
YTDimmer is working with Share actions. Which means, in your YoutubeApp, click on a video, click the Share button, and share it with YTDimmer. YTDimmer will then completely turn off your screen. Return to Youtube with doublepressing your back button.

## Programming
When YTDimmer receives a Share action, it puts a completely blank overlay Activity, on top of the Youtube App. By getting the WindowManager.LayoutParams, you can set the dimAmount between 0.f and 1.f, while 1.f means completely dimmed.

```java
        //Background of Dialog dimmed to 0x000000 with 1.0f
        WindowManager.LayoutParams layoutParams = window.getAttributes();

        //set this between 0.f and 1.f (1.f 100% dimmed, 0.f 0% dimmed)
        layoutParams.dimAmount = 1.f;

        window.setAttributes(layoutParams);
```

## Downsides, room for improvements
YTDimmer works best on OLED screens, due to the lack of a backlight. If you use this app on a device with LCD, it won't turn off the backlight, but only turn your screen black.

##### Tested on a Samsung Galaxy S7 w/ Android 7
