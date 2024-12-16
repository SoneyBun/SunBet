# Welcome to SunBet!

Welcome to **SunBet**. SunBet is a fun little game in which you bet a certain amount, and let Math.random() decide your fate in which you either get it, lose it, or push it. Do you have what it takes to get 1 million?

## Currency List

SunBet offers you to bet in a variety of currencies that can be found [here](https://bit.ly/SunBetCurrencies). When selecting a currency, you immediately get 100 of that currency regardless of it's value compared to another currency.

If a currency is not valid, it will give you ¤100 of whatever you said.

## What is the math behind it?

A random number is generated between 0-6.
- 0-2 Gain
- 3-5 Loss
- 6 Push

```
public int betMoney() {
        int chance = (int) (Math.random() * 7);

        if(chance <= 2) {
            return bet;
        }
        else if(chance <= 5) {
            return (bet * -1);
        }
        return 0;
    }
```

## CodeHS Variant

The [CodeHS variant of SunBet](https://bit.ly/SunBetTesting) runs almost identical to the actual variant of SunBet.

## Discord Server

The [SunCode Discord server](https://bit.ly/SunCode) is a little fun laid back community hangout that also has a passion for all things computer science and cybersecurity.

>Just make sure to join the Vuy Dynasty and not the Volkov Dynasty (We are at war with them).

## GitHub Repository

The GitHub repository for SunCalc can be found [here](https://github.com/SoneyBun/SunBet). It contains all the code and the pdf file for the functions.

## Who am I?
I'm Sunny. I've been programming for around 4 years now. I can program in the following languages, in order from most fluent to least.
* Java
* Lua
* Python

Coding is my passion as the thought of building something huge from nothing but an empty file is insane.

I love to play video games. Roblox being one of my favorites. I like to listen to music, maybe we have a similar taste?
