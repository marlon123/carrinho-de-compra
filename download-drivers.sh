#!/bin/bash
mkdir -p drivers
cd drivers
curl -L https://github.com/mozilla/geckodriver/releases/download/v0.20.1/geckodriver-v0.20.1-linux64.tar.gz | tar xvz
wget https://chromedriver.storage.googleapis.com/2.40/chromedriver_linux64.zip -O temp.zip
unzip temp.zip
rm temp.zip